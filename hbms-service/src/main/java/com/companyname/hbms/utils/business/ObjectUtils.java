package com.companyname.hbms.utils.business;

import com.companyname.hbms.candidate.domain.Resume;
import com.companyname.hbms.utils.BeanUtils;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fellowlong on 2014/10/1.
 */
public abstract class ObjectUtils {

  public static void fillSubObjectByKey(List<Resume> parents,
                                        String keyNameInParent,
                                        String subObjectNameInParent,
                                        String keyNameInSubObject,
                                        SubObjectsGetter subObjectsGetter) {
    if (parents != null && parents.size() > 0
       && keyNameInParent != null && !keyNameInParent.isEmpty()
       && keyNameInSubObject != null && !keyNameInSubObject.isEmpty()
       && subObjectsGetter != null) {
      //获取parent中所有子对象的key
      JexlEngine jexlEngine = new JexlEngine();
      String parentJexlKeyName = "parent";
      Expression parentExpression = jexlEngine.createExpression(parentJexlKeyName + "." + keyNameInParent);
      Map<Object, Object> keys = new HashMap<Object, Object>();
      for (Object parent : parents) {
        MapContext jexlContext = new MapContext();
        jexlContext.set(parentJexlKeyName, parent);
        Object subObjectKeyValue = parentExpression.evaluate(jexlContext);
        keys.put(subObjectKeyValue, subObjectKeyValue);
      }
      //根据key获取所有对象
      List subObjects = subObjectsGetter.getSubObjects(
         keys.keySet().toArray(new Object[keys.keySet().size()]));
      keys.clear();
      //建立key和子对象的关联
      if (subObjects != null && subObjects.size() > 0) {
        String subObjectJexlKeyName = "subObject";
        Expression subObjectExpression = jexlEngine.createExpression(
           subObjectJexlKeyName + "." + keyNameInSubObject);
        for (Object subObject : subObjects) {
          MapContext jexlContext = new MapContext();
          jexlContext.set(subObjectJexlKeyName, subObject);
          Object subObjectKeyValue = subObjectExpression.evaluate(jexlContext);
          keys.put(subObjectKeyValue, subObject);
        }
      }
      //将子对象填充到父对象中
      for (Object parent : parents) {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        MapContext jexlContext = new MapContext();
        jexlContext.set(parentJexlKeyName, parent);
        Object subObjectKeyValue = parentExpression.evaluate(jexlContext);
        properties.put(subObjectNameInParent, keys.get(subObjectKeyValue));
        BeanUtils.bindProperties(parent, properties);
      }
    }
  }

  public interface SubObjectsGetter {

    public List getSubObjects(Object[] keys);

  }
}

