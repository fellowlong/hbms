package com.newstar.hbms.utils.business;

import com.newstar.hbms.basedata.domain.TreeNode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  public static void removeChildrenOfProperties(List objects, boolean includeAncestor) {
    try {
      if (objects != null && !objects.isEmpty()) {
        for (Object o : objects) {
          Field[] fields = o.getClass().getDeclaredFields();
          List notTreeNodeProperties = new ArrayList(fields.length);
          for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(o);
            if (value instanceof TreeNode) {
              removeChildren(Arrays.asList(new TreeNode[]{(TreeNode) value}), includeAncestor);
            } else {
              notTreeNodeProperties.add(value);
            }
          }
          if (notTreeNodeProperties != null) {
            removeChildrenOfProperties(notTreeNodeProperties, includeAncestor);
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
