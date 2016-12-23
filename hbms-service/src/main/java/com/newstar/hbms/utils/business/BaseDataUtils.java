package com.newstar.hbms.utils.business;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.utils.BeanUtils;

import java.util.*;

/**
 * Created by root on 16-12-23.
 */
public abstract class BaseDataUtils {

    public static void fillBaseData(List objects,
                                    List<BaseDataConfig> baseDataConfigs,
                                    TreeService treeService) {
        if (objects == null || objects.isEmpty()) {
            return;
        }
        List<ObjectBaseDataMapping> objectBaseDataMappings = new ArrayList<ObjectBaseDataMapping>(objects.size());
        Set<Long> baseDataIds = new HashSet<Long>();
        for (Object o : objects) {
            for (BaseDataConfig baseDataConfig : baseDataConfigs) {
                List fullObject = new ArrayList();
                try {
                if (baseDataConfig.isCollection()) {
                    Collection subCollection = (Collection) BeanUtils.searchValue(o, baseDataConfig.getCollectionName());
                    if (subCollection != null) {
                        fullObject.addAll(subCollection);
                    }
                } else {
                    fullObject.add(o);
                }
                for (Object perO : fullObject) {
                    Long id = (Long) BeanUtils.searchValue(perO, baseDataConfig.getIdName());
                    if (id != null) {
                        ObjectBaseDataMapping objectBaseDataMapping = new ObjectBaseDataMapping(perO);
                        objectBaseDataMapping.configIdMapping.put(baseDataConfig, id);
                        baseDataIds.add(id);
                    }
                }
                } catch (Exception e) {
                   throw new RuntimeException("获取对象属性失败，o=" + o.getClass() + ", property=" + baseDataConfig.getIdName());
                }
            }
        }
        if (!baseDataIds.isEmpty()) {
            List<TreeNode> baseDatas = treeService.findNodeByIds(baseDataIds.toArray(new Long[baseDataIds.size()]));
            if (baseDatas != null && baseDatas.isEmpty()) {
                for (TreeNode baseData : baseDatas) {
                    for (ObjectBaseDataMapping mapping : objectBaseDataMappings) {
                        Map<String, Object> valueMapping = new HashMap<String, Object>();
                        for (Map.Entry<BaseDataConfig, Long> entry : mapping.configIdMapping.entrySet()) {
                            if (entry.getValue().equals(baseData.getId())) {
                                valueMapping.put(entry.getKey().getValueName(), baseData);
                            }
                        }
                        BeanUtils.bindProperties(mapping.o, valueMapping);
                    }
                }
            }
        }

    }

    public static  class  BaseDataConfig {

        private boolean collection;
        private String collectionName;
        private String idName;
        private String valueName;

        public BaseDataConfig(String idName, String valueName) {
            this.idName = idName;
            this.valueName = valueName;
        }

        public BaseDataConfig(boolean collection, String collectionName, String idName, String valueName) {
            this.collection = collection;
            this.collectionName = collectionName;
            this.idName = idName;
            this.valueName = valueName;
        }

        public boolean isCollection() {
            return collection;
        }

        public void setCollection(boolean collection) {
            this.collection = collection;
        }

        public String getCollectionName() {
            return collectionName;
        }

        public void setCollectionName(String collectionName) {
            this.collectionName = collectionName;
        }

        public String getIdName() {
            return idName;
        }

        public void setIdName(String idName) {
            this.idName = idName;
        }

        public String getValueName() {
            return valueName;
        }

        public void setValueName(String valueName) {
            this.valueName = valueName;
        }
    }

    static  class  ObjectBaseDataMapping {
        public ObjectBaseDataMapping(Object o) {
            this.o = o;
        }

        Object o;
        Map<BaseDataConfig, Long> configIdMapping = new HashMap<BaseDataConfig, Long>();
    }

}
