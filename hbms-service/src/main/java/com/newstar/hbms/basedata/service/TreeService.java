package com.newstar.hbms.basedata.service;

import com.newstar.hbms.basedata.domain.TreeNode;

import java.util.List;

/**
 * Created by fellowlong on 2014-09-09.
 */
public interface TreeService {

  public int insert(TreeNode treeNode);

  public int update(TreeNode treeNode);

  public int deleteById(Long[] ids);

  public List<TreeNode> findAllTrees();

  public TreeNode findTreeByAncestorCode(String code);

  public TreeNode findByCode(String code);

  public List<TreeNode> findByIds(Long[] ids);
}
