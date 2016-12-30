package com.newstar.hbms.utils.business;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.utils.BeanUtils;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import java.util.*;

/**
 * Created by fellowlong on 2014/10/1.
 */
public abstract class ObjectUtils {

  private static JexlEngine jexlEngine = new JexlEngine();

  public static class SubObjectConfig {

    private String collectionNameInParent;
    private String keyNameInParent;
    private String valueNameInParent;
    private String keyNameInSubObject;
    private SubObjectFetcher subObjectFetcher;

    public SubObjectConfig(String keyNameInParent,
                           String valueNameInParent,
                           String keyNameInSubObject,
                           SubObjectFetcher subObjectFetcher) {
      this(null, keyNameInParent, valueNameInParent, keyNameInSubObject, subObjectFetcher);
    }

    public SubObjectConfig(String collectionNameInParent,
                           String keyNameInParent,
                           String valueNameInParent,
                           String keyNameInSubObject,
                           SubObjectFetcher subObjectFetcher) {
      this.collectionNameInParent = collectionNameInParent;
      this.keyNameInParent = keyNameInParent;
      this.valueNameInParent = valueNameInParent;
      this.keyNameInSubObject = keyNameInSubObject;
      this.subObjectFetcher = subObjectFetcher;
    }

    public String getCollectionNameInParent() {
      return collectionNameInParent;
    }

    public void setCollectionNameInParent(String collectionNameInParent) {
      this.collectionNameInParent = collectionNameInParent;
    }

    public String getKeyNameInParent() {
      return keyNameInParent;
    }

    public void setKeyNameInParent(String keyNameInParent) {
      this.keyNameInParent = keyNameInParent;
    }

    public String getValueNameInParent() {
      return valueNameInParent;
    }

    public void setValueNameInParent(String valueNameInParent) {
      this.valueNameInParent = valueNameInParent;
    }

    public String getKeyNameInSubObject() {
      return keyNameInSubObject;
    }

    public void setKeyNameInSubObject(String keyNameInSubObject) {
      this.keyNameInSubObject = keyNameInSubObject;
    }

    public SubObjectFetcher getSubObjectFetcher() {
      return subObjectFetcher;
    }

    public void setSubObjectFetcher(SubObjectFetcher subObjectFetcher) {
      this.subObjectFetcher = subObjectFetcher;
    }

    @Override
    public String toString() {
      return "SubObjectConfig{" +
              "collectionNameInParent='" + collectionNameInParent + '\'' +
              ", keyNameInParent='" + keyNameInParent + '\'' +
              ", valueNameInParent='" + valueNameInParent + '\'' +
              ", keyNameInSubObject='" + keyNameInSubObject + '\'' +
              ", subObjectFetcher=" + subObjectFetcher +
              '}';
    }
  }


  public interface SubObjectFetcher {

    public List fetch(List keys);

  }

  public static void fillSubObjects(List parents, List<SubObjectConfig> subObjectConfigs) {
    if (parents == null || parents.isEmpty() || subObjectConfigs == null || subObjectConfigs.isEmpty()) {
      return;
    }
    Map<Object, Map<SubObjectConfig, Object>> parentAndSubObjectMappings =
        new HashMap<Object, Map<SubObjectConfig, Object>>(parents.size());
    Map<SubObjectFetcher, Set> keys = new HashMap<SubObjectFetcher, Set>();
    for (Object parent : parents) {
      for (SubObjectConfig config : subObjectConfigs) {
        List parentsOfSubObject = new ArrayList();
        try {
          if (config.getCollectionNameInParent() != null && !config.getCollectionNameInParent().isEmpty()) {
            Collection subCollection = (Collection) BeanUtils.searchValue(parent, config.getCollectionNameInParent());
            if (subCollection != null && !subCollection.isEmpty()) {
              parentsOfSubObject.addAll(subCollection);
            }
          } else {
            parentsOfSubObject.add(parent);
          }
          for (Object parentOfSubObject : parentsOfSubObject) {
            Object key = BeanUtils.searchValue(parentOfSubObject, config.getKeyNameInParent());
            if (key != null) {
              //存储对象和子对象的映射关系，过滤掉空对象
              Map<SubObjectConfig, Object> configsOfObject = parentAndSubObjectMappings.get(parentOfSubObject);
              if (configsOfObject == null) {
                configsOfObject = new HashMap<SubObjectConfig, Object>(subObjectConfigs.size());
                parentAndSubObjectMappings.put(parentOfSubObject, configsOfObject);
              }
              configsOfObject.put(config, key);
              //找到子对象的key，用于查找
              Set keysOfFetcher = keys.get(config.getSubObjectFetcher());
              if (keysOfFetcher == null) {
                keysOfFetcher = new HashSet();
                keys.put(config.getSubObjectFetcher(), keysOfFetcher);
              }
              keysOfFetcher.add(key);
            }
          }
        } catch (Exception e) {
          throw new RuntimeException("获取对象属性失败，o=" + parent.getClass() + ", config=" + config, e);
        }
      }
    }
    if (keys.isEmpty() || parentAndSubObjectMappings.isEmpty()) {
      return;
    }

    //建立fetcher和config的映射关系
    Map<SubObjectFetcher, List<SubObjectConfig>> fetcherAndConfigMapping =
        new HashMap<SubObjectFetcher, List<SubObjectConfig>>();
    for (SubObjectConfig config : subObjectConfigs) {
      List<SubObjectConfig> configsOfFetcher = fetcherAndConfigMapping.get(config.getSubObjectFetcher());
      if (configsOfFetcher == null) {
        configsOfFetcher = new ArrayList<SubObjectConfig>();
        fetcherAndConfigMapping.put(config.getSubObjectFetcher(), configsOfFetcher);
      }
      configsOfFetcher.add(config);
    }

    //用fetcher抓取子对象
    Map<SubObjectFetcher, Map> subObjects = new HashMap<SubObjectFetcher, Map>();
    for (Map.Entry<SubObjectFetcher, Set> entry : keys.entrySet()) {
      List subObjectsOfFetcher = entry.getKey().fetch(new ArrayList(entry.getValue()));
      if (subObjectsOfFetcher != null && !subObjectsOfFetcher.isEmpty()) {
        String keyNameInSubObject = fetcherAndConfigMapping.get(entry.getKey()).get(0).getKeyNameInSubObject();
        subObjects.put(entry.getKey(), listToMap(subObjectsOfFetcher, keyNameInSubObject));
      }
    }

    if (subObjects.isEmpty()) {
      return;
    }

    //填充到parent
    for (Map.Entry<Object, Map<SubObjectConfig, Object>> objectEntry : parentAndSubObjectMappings.entrySet()) {
      Map<String, Object> subObjectPropertyAndValueMapping = new HashMap<String, Object>();
      for (Map.Entry<SubObjectConfig, Object> configEntry : objectEntry.getValue().entrySet()) {
        Map subObjectsOfParent = subObjects.get(configEntry.getKey().getSubObjectFetcher());
        if (subObjectsOfParent != null) {
          Object subObject = subObjectsOfParent.get(configEntry.getValue());
          if (subObject != null) {
            subObjectPropertyAndValueMapping.put(configEntry.getKey().getValueNameInParent(), subObject);
          }
        }
      }
      //将找到的属性值绑定到parent上
      BeanUtils.bindProperties(objectEntry.getKey(), subObjectPropertyAndValueMapping);
    }

  }//end

  public static Map listToMap(List list, String keyName) {
    if (list == null || list.isEmpty()) {
      return null;
    }
    Map map = new HashMap(list.size());
    for (Object o : list) {
      try {
        Object key = BeanUtils.searchValue(o, keyName);
        if (key == null) {
          throw new Exception("key值为null");
        }
        map.put(key, o);
      } catch (Exception e) {
        throw new RuntimeException("获取属性值出错:keyName=" + keyName, e);
      }
    }
    return map;
  }

  public static class SubCollectionConfig {

    private String parentKeyNameInParent;
    private String collectionNameInParent;
    private String parentKeyNameInCollectionItem;
    private SubCollectionFetcher subCollectionFetcher;

    public SubCollectionConfig(String parentKeyNameInParent,
                               String collectionNameInParent,
                               String parentKeyNameInCollectionItem,
                               SubCollectionFetcher subCollectionFetcher) {
      this.parentKeyNameInParent = parentKeyNameInParent;
      this.collectionNameInParent = collectionNameInParent;
      this.parentKeyNameInCollectionItem = parentKeyNameInCollectionItem;
      this.subCollectionFetcher = subCollectionFetcher;
    }

    public String getParentKeyNameInParent() {
      return parentKeyNameInParent;
    }

    public void setParentKeyNameInParent(String parentKeyNameInParent) {
      this.parentKeyNameInParent = parentKeyNameInParent;
    }

    public String getCollectionNameInParent() {
      return collectionNameInParent;
    }

    public void setCollectionNameInParent(String collectionNameInParent) {
      this.collectionNameInParent = collectionNameInParent;
    }

    public String getParentKeyNameInCollectionItem() {
      return parentKeyNameInCollectionItem;
    }

    public void setParentKeyNameInCollectionItem(String parentKeyNameInCollectionItem) {
      this.parentKeyNameInCollectionItem = parentKeyNameInCollectionItem;
    }

    public SubCollectionFetcher getSubCollectionFetcher() {
      return subCollectionFetcher;
    }

    public void setSubCollectionFetcher(SubCollectionFetcher subCollectionFetcher) {
      this.subCollectionFetcher = subCollectionFetcher;
    }

    @Override
    public String toString() {
      return "SubCollectionConfig{" +
          "parentKeyNameInParent='" + parentKeyNameInParent + '\'' +
          ", collectionNameInParent='" + collectionNameInParent + '\'' +
          ", parentKeyNameInCollectionItem='" + parentKeyNameInCollectionItem + '\'' +
          ", subCollectionFetcher=" + subCollectionFetcher +
          '}';
    }
  }


  public static interface SubCollectionFetcher {

    public List fetch(List parentKeys);

  }

  public static void fillSubCollection(List parents, List<SubCollectionConfig> subCollectionConfigs) {
    if (parents == null || parents.isEmpty() || subCollectionConfigs == null || subCollectionConfigs.isEmpty()) {
      return;
    }
    List parentKeys = getUniquePropertyValuesFromCollection(parents, subCollectionConfigs.get(0).getParentKeyNameInParent());
    if (parentKeys == null || parentKeys.isEmpty()) {
      return;
    }

    Map<Object, Object> parentMap = listToMap(parents, subCollectionConfigs.get(0).getParentKeyNameInParent());

    //找到parent下的所有子集合的对应关系
    Map<Object, Map<String, Object>> parentAndSubCollectionMapping = new HashMap<Object, Map<String, Object>>(parents.size());
    for (SubCollectionConfig config : subCollectionConfigs) {
      List subCollection = config.getSubCollectionFetcher().fetch(parentKeys);
      if (subCollection == null || subCollection.isEmpty()) {
        continue;
      }
      //按照parent key对子集合分组
      Map<Object, Collection> groups = collectionGroup(subCollection, config.getParentKeyNameInCollectionItem());
      if (groups == null || groups.isEmpty()) {
        continue;
      }
      for (Map.Entry<Object, Collection> entry : groups.entrySet()) {
        Object parent = parentMap.get(entry.getKey());
        Map<String, Object> subCollectionMapping = parentAndSubCollectionMapping.get(parent);
        if (subCollectionMapping == null) {
          subCollectionMapping = new HashMap<String, Object>(subCollectionConfigs.size());
          parentAndSubCollectionMapping.put(parent, subCollectionMapping);
        }
        subCollectionMapping.put(config.getCollectionNameInParent(), entry.getValue());
      }
    }

    //子集合绑定到parent上
    for (Map.Entry<Object, Map<String, Object>> entry : parentAndSubCollectionMapping.entrySet()) {
      Object parent = entry.getKey();
      Map<String, Object> subCollections = entry.getValue();
      BeanUtils.bindProperties(parent, subCollections);
    }
  }


  public static List getUniquePropertyValuesFromCollection(Collection collection, String propertyName) {
    Map<Object, Object> values = new HashMap<Object, Object>();
    if (collection != null
       && collection.size() > 0
       && propertyName != null
       && !propertyName.isEmpty()) {
      //获取parent中所有子对象的key
      JexlEngine jexlEngine = new JexlEngine();
      String itemJexlKeyName = "item";
      Expression itemExpression = jexlEngine.createExpression(itemJexlKeyName + "." + propertyName);
      for (Object item : collection) {
        MapContext jexlContext = new MapContext();
        jexlContext.set(itemJexlKeyName, item);
        Object value = itemExpression.evaluate(jexlContext);
        values.put(value, value);
      }
    }
    return new ArrayList(values.keySet());
  }

  public static Map<Object, Collection> collectionGroup(Collection collection, String groupPropertyName) {
    Map<Object, Collection> groups = new HashMap<Object, Collection>();
    if (collection != null
       && collection.size() > 0
       && groupPropertyName != null
       && !groupPropertyName.isEmpty()) {
      //获取parent中所有子对象的key
      String itemJexlKeyName = "item";
      Expression itemExpression = jexlEngine.createExpression(itemJexlKeyName + "." + groupPropertyName);
      for (Object item : collection) {
        MapContext jexlContext = new MapContext();
        jexlContext.set(itemJexlKeyName, item);
        Object groupKey = itemExpression.evaluate(jexlContext);
        Collection group = groups.get(groupKey);
        if (group == null) {
          group = new ArrayList();
          groups.put(groupKey, group);
        }
        group.add(item);
      }
    }
    return groups;
  }

}

