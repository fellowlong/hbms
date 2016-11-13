package com.newstar.hbms.basedata.service.impl;

import com.newstar.hbms.basedata.dao.TreeNodeDao;
import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.basedata.service.BaseDataService;
import com.newstar.hbms.basedata.service.TreeService;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by wangjinsi on 2016/11/2.
 */
public class BaseDataServiceImpl implements BaseDataService {

    private TreeService treeService;

    public void setTreeService(TreeService treeService) {
        this.treeService = treeService;
    }

    @Override
    public TreeNode getSexes() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_SEX);
    }

    @Override
    public TreeNode getMaritals() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_MARITAL);
    }

    @Override
    public TreeNode getDegrees() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_DEGREE);
    }

    @Override
    public TreeNode getIndustries() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_INDUSTRY);
    }

    @Override
    public TreeNode getFunctions() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_FUNCTION);
    }

    @Override
    public TreeNode getPositions() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_POSITION);
    }

    @Override
    public TreeNode getCities() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_CITY);
    }

    @Override
    public TreeNode getTags() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_TAG);
    }

    @Override
    public TreeNode getDepartments() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_DEPARTMENT);
    }

    @Override
    public TreeNode getConpanies() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_COMPANY);
    }

    @Override
    public TreeNode getJobHuntingStatuses() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_JOB_HUNTING_STATUS);
    }

}
