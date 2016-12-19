package com.newstar.hbms.basedata.service.impl;

import com.newstar.hbms.basedata.dao.TreeNodeDao;
import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.basedata.service.TreeService;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by wuchunli on 2016/11/3.
 */
public class TreeServiceImpl implements TreeService {

    private TreeNodeDao treeNodeDao;

    public void setTreeNodeDao(TreeNodeDao treeNodeDao) {
        this.treeNodeDao = treeNodeDao;
    }

    @Override
    public int insertOrUpdate(TreeNode treeNode) {
        return treeNode.getId() != null ?
                treeNodeDao.update(treeNode) :
                treeNodeDao.insert(treeNode);
    }

    @Override
    public int disableByIds(Long[] nodeIds) {
        return treeNodeDao.disableByIds(nodeIds);
    }

    @Override
    public List<TreeNode> findAllTrees() {
        List<TreeNode> treeNodes = treeNodeDao.findAll();
        if (treeNodes == null || treeNodes.isEmpty()) {
            return null;
        }
        return buildTrees(treeNodes);
    }

    @Override
    public TreeNode findTreeByAncestorCode(String code) {
        List<TreeNode> treeNodes = treeNodeDao.findByAncestorCode(code);
        if (treeNodes == null || treeNodes.isEmpty()) {
            return null;
        }
        List<TreeNode> trees = buildTrees(treeNodes);
        if (trees != null && !trees.isEmpty()) {
            return trees.get(0);
        }
        return null;
    }

    @Override
    public List<TreeNode> findTreesByIds(Long[] ids) {
        List<TreeNode> treeNodes = treeNodeDao.findAllWithSameAncestorByIds(ids);
        if (treeNodes == null || treeNodes.isEmpty()) {
            return null;
        }
        buildTrees(treeNodes);
        List<TreeNode> trees = new ArrayList<TreeNode>();
        for (TreeNode node : treeNodes) {
            for (Long id : ids) {
                if (node.getId().longValue() == id.longValue()) {
                    trees.add(node);
                }
            }
        }
        return trees;
    }

    public TreeNode findNodeByCode(String code) {
        return treeNodeDao.findByCode(code);
    }

    @Override
    public List<TreeNode> findNodeByIds(Long[] ids) {
        return treeNodeDao.findByIds(ids);
    }

    private List<TreeNode> buildTrees(List<TreeNode> treeNodes) {
        //先转成Map
        SortedMap<Long, TreeNode> nodeTreeMap = new TreeMap<Long, TreeNode>();
        for (TreeNode treeNode : treeNodes) {
            nodeTreeMap.put(treeNode.getId(), treeNode);
        }
        //生成按模块的树结构
        for (TreeNode treeNode : nodeTreeMap.values()) {
            if (treeNode.getParentId() != null) {
                TreeNode parent = nodeTreeMap.get(treeNode.getParentId());
                if (parent != null) {
                    treeNode.setParent(parent);
                    treeNode.getParent().getChildren().add(treeNode);
                }
            }
        }
        List<TreeNode> treeTreeNodes = new ArrayList<TreeNode>();
        //生成按模块的树结构
        for (TreeNode treeNode : nodeTreeMap.values()) {
            if (treeNode.getParent() == null) {
                treeTreeNodes.add(treeNode);
            }
        }
        return treeTreeNodes;
    }
}
