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

  public static class ProxySubObjectFetcher implements SubObjectFetcher {

    private SubObjectConfig subObjectConfig;

    private SubObjectFetcher targetSubObjectFetcher;

    public ProxySubObjectFetcher(SubObjectConfig subObjectConfig, SubObjectFetcher targetSubObjectFetcher) {
      this.subObjectConfig = subObjectConfig;
      this.targetSubObjectFetcher = targetSubObjectFetcher;
    }

    @Override
    public List fetch(List keys) {
      return targetSubObjectFetcher.fetch(keys);
    }

    public SubObjectConfig getSubObjectConfig() {
      return subObjectConfig;
    }

    public SubObjectFetcher getTargetSubObjectFetcher() {
      return targetSubObjectFetcher;
    }
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


  public static void fillAssociationByKey(List parents,
                                          String keyNameInParent,
                                          String associationNameInParent,
                                          String keyNameInAssociation,
                                          AssociationFetcher associationFetcher) {
    if (parents == null || parents.isEmpty()
       || keyNameInParent == null || keyNameInParent.isEmpty()
       || associationNameInParent == null || associationNameInParent.isEmpty()
       || keyNameInAssociation == null || keyNameInAssociation.isEmpty()
       || associationFetcher == null) {
      return;
    }
    //获取parent中所有子对象的key
    List associationKeys = getUniquePropertyValuesFromCollection(parents, keyNameInParent);
    if (associationKeys == null || associationKeys.size() == 0) {
      return;
    }
    //根据key获取所有对象
    List associations = associationFetcher.fetch(associationKeys.toArray(new Object[associationKeys.size()]));
    if (associations == null || associations.size() == 0) {
      return;
    }
    //建立key和子对象的关联
    Map<Object, Object> keyAssociationPairs = new HashMap<Object, Object>(associations.size());
    JexlEngine jexlEngine = new JexlEngine();
    String associationJexlKeyName = "association";
    Expression subObjectExpression =
       jexlEngine.createExpression(associationJexlKeyName + "." + keyNameInAssociation);
    for (Object association : associations) {
      MapContext jexlContext = new MapContext();
      jexlContext.set(associationJexlKeyName, association);
      Object associationKeyValue = subObjectExpression.evaluate(jexlContext);
      keyAssociationPairs.put(associationKeyValue, association);
    }
    if (keyAssociationPairs == null || keyAssociationPairs.size() == 0) {
      return;
    }
    //将子对象填充到父对象中
    String parentJexlKeyName = "parent";
    Expression parentExpression =
       jexlEngine.createExpression(parentJexlKeyName + "." + keyNameInParent);
    for (Object parent : parents) {
      Map<String, Object> properties = new HashMap<String, Object>(1);
      MapContext jexlContext = new MapContext();
      jexlContext.set(parentJexlKeyName, parent);
      Object associationKeyValue = parentExpression.evaluate(jexlContext);
      properties.put(associationNameInParent, keyAssociationPairs.get(associationKeyValue));
      BeanUtils.bindProperties(parent, properties);
    }
  }

  public interface AssociationFetcher {

    public List fetch(Object[] associationKeys);

  }

  public static void fillCollection(List parents,
                                    String parentKeyNameInParent,
                                    String collectionNameInParent,
                                    String parentKeyNameInCollectionItem,
                                    CollectionFetcher collectionFetcher) {
    if (parents == null || parents.isEmpty()
       || parentKeyNameInParent == null || parentKeyNameInParent.isEmpty()
       || collectionNameInParent == null || collectionNameInParent.isEmpty()
       || parentKeyNameInCollectionItem == null || parentKeyNameInCollectionItem.isEmpty()
       || collectionFetcher == null) {
      return;
    }
    List parentKeys = getUniquePropertyValuesFromCollection(parents, parentKeyNameInParent);
    if (parentKeys == null || parentKeys.isEmpty()) {
      return;
    }
    List collection = collectionFetcher.fetch(parentKeys.toArray(new Object[parentKeys.size()]));
    if (collection == null || collection.isEmpty()) {
      return;
    }
    Map<Object, Collection> groups = collectionGroup(collection, parentKeyNameInCollectionItem);
    if (groups == null || groups.isEmpty()) {
      return;
    }
    JexlEngine jexlEngine = new JexlEngine();
    String parentJexlKeyName = "parent";
    Expression parentKeyExpression =
       jexlEngine.createExpression(parentJexlKeyName + "." + parentKeyNameInParent);
    for (Object parent : parents) {
      MapContext mapContext = new MapContext();
      mapContext.set(parentJexlKeyName, parent);
      Object parentKeyValue = parentKeyExpression.evaluate(mapContext);
      Map<String, Object> properties = new HashMap<String, Object>(1);
      properties.put(collectionNameInParent, groups.get(parentKeyValue));
      BeanUtils.bindProperties(parent, properties);
    }
  }

  public interface CollectionFetcher {

    public List fetch(Object[] parentKeys);

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
      JexlEngine jexlEngine = new JexlEngine();
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

