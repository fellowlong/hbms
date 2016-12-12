package com.newstar.hbms.basedata.service;

import com.newstar.hbms.basedata.domain.TreeNode;

import java.util.List;

/**
 * Created by fellowlong on 2014-09-09.
 */
public interface TreeService {

  public int insertOrUpdate(TreeNode treeNode);

  public int disableByIds(Long[] ids);

  public List<TreeNode> findAllTrees();

  public TreeNode findTreeByAncestorCode(String code);

  public TreeNode findNodeByCode(String code);

  public List<TreeNode> findNodeByIds(Long[] ids);
}
