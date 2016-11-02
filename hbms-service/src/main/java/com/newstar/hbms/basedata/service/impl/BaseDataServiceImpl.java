package com.newstar.hbms.basedata.service.impl;

import com.newstar.hbms.basedata.dao.TreeNodeDao;
import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.basedata.service.BaseDataService;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by wangjinsi on 2016/11/2.
 */
public class BaseDataServiceImpl implements BaseDataService {

    private TreeNodeDao treeNodeDao;

    public void setTreeNodeDao(TreeNodeDao treeNodeDao) {
        this.treeNodeDao = treeNodeDao;
    }

    @Override
    public List<TreeNode> getSexes() {
        return treeNodeDao.findByAncestorCode(TYPE_CODE_SEX);
    }

    @Override
    public List<TreeNode> getMaritals() {
        return treeNodeDao.findByAncestorCode(TYPE_CODE_MARITAL);
    }

    @Override
    public List<TreeNode> getDegree() {
        return treeNodeDao.findByAncestorCode(TYPE_CODE_DEGREE);
    }

    @Override
    public List<TreeNode> getIndustries() {
        return getTrees(TYPE_CODE_INDUSTRY);
    }

    @Override
    public List<TreeNode> getFunctions() {
        return getTrees(TYPE_CODE_FUNCTION);
    }

    @Override
    public List<TreeNode> getStations() {
        return getTrees(TYPE_CODE_STATION);
    }

    @Override
    public List<TreeNode> getCities() {
        return getTrees(TYPE_CODE_CITY);
    }

    @Override
    public List<TreeNode> getTags() {
        return getTrees(TYPE_CODE_TAG);
    }

    @Override
    public List<TreeNode> getDepartments() {
        return getTrees(TYPE_CODE_DEPARTMENT);
    }

    private List<TreeNode> getTrees(String code) {
        List<TreeNode> nodes = treeNodeDao.findByAncestorCode(code);
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        //先转成Map
        SortedMap<Long, TreeNode> nodeTreeMap = new TreeMap<Long, TreeNode>();
        for (TreeNode treeNode : nodes) {
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
