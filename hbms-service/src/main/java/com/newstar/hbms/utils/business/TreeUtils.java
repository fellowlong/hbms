package com.newstar.hbms.utils.business;

import com.newstar.hbms.basedata.domain.TreeNode;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by root on 16-12-30.
 */
public abstract class TreeUtils {

  public static void removeParentOfProperties(List objects, boolean includeDescendant) {
    try {
      if (objects != null && !objects.isEmpty()) {
        for (Object o : objects) {
          Field[] fields = o.getClass().getDeclaredFields();
          List notTreeNodeProperties = new ArrayList(fields.length);
          for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(o);
            if (value instanceof TreeNode) {
              removeParent(Arrays.asList(new TreeNode[]{(TreeNode) value}), includeDescendant);
            } else {
              notTreeNodeProperties.add(value);
            }
          }
          if (notTreeNodeProperties != null) {
            removeParentOfProperties(notTreeNodeProperties, includeDescendant);
          }
        }
      }
    } catch (IllegalAccessException e) {
      throw new RuntimeException("获取对象属性值出错", e);
    }
  }

  public static void removeChildrenOfProperties(List objects, boolean includeAncestor, Map properties) {
    if (properties == null) {
      properties = new HashMap();
    }
    try {
      if (objects != null && !objects.isEmpty()) {
        for (Object o : objects) {
          Field[] fields = o.getClass().getDeclaredFields();
          if (fields != null && fields.length > 0) {
            for (Field field : fields) {
              field.setAccessible(true);
              Object value = field.get(o);
              if (value != null) {
                if (value instanceof TreeNode) {
                  removeChildren(Arrays.asList(new TreeNode[]{(TreeNode) value}), includeAncestor);
                } else if (value instanceof Collection) {
                  removeChildrenOfProperties(new ArrayList((Collection) value), includeAncestor, properties);
                } else if (value instanceof Map) {
                  removeChildrenOfProperties(new ArrayList(((Map) value).values()), includeAncestor, properties);
                } else {
                  if (!properties.containsKey(value)) {
                    properties.put(value, value);
                    removeChildrenOfProperties(Arrays.asList(new Object[]{value}), includeAncestor, properties);
                  }
                }
              }
            }
          }
        }
      }
    } catch (IllegalAccessException e) {
      throw new RuntimeException("获取对象属性值出错", e);
    }
  }

  public static void removeParent(List<TreeNode> treeNodes, boolean includeDescendant) {
    if (treeNodes != null && !treeNodes.isEmpty()) {
      for (TreeNode treeNode : treeNodes) {
        treeNode.setParent(null);
        if (includeDescendant&& treeNode.getChildren() != null) {
          removeParent(treeNode.getChildren(), includeDescendant);
        }
      }
    }
  }

  public static void removeChildren(List<TreeNode> treeNodes, boolean includeAncestor) {
    if (treeNodes != null && !treeNodes.isEmpty()) {
      for (TreeNode treeNode : treeNodes) {
        treeNode.setChildren(null);
        if (includeAncestor && treeNode.getParent() != null) {
          removeChildren(Arrays.asList(new TreeNode[]{treeNode.getParent()}), includeAncestor);
        }
      }
    }
  }

}
