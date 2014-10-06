package com.companyname.hbms.utils.business;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.utils.BeanUtils;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import java.util.*;

/**
 * Created by fellowlong on 2014/10/1.
 */
public abstract class ObjectUtils {

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

