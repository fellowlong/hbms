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
 * Created by fellowlong on 2016/11/2.
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
    public TreeNode getLanguages() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_LANGUAGE);
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
    public TreeNode getCompanies() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_COMPANY);
    }

    @Override
    public TreeNode getNationalities() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_NATIONALITY);
    }

    @Override
    public TreeNode getCandidateStatus() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_CANDIDATE_STATUS);
    }

    @Override
    public TreeNode getCandidateFolders() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_CANDIDATE_FOLDER);
    }

    @Override
    public TreeNode getCandidateSources() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_CANDIDATE_SOURCE);
    }

    @Override
    public TreeNode getCompanyTypes() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_COMPANY_TYPE);
    }

    @Override
    public TreeNode getCompanyFolders() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_COMPANY_FOLDER);
    }

    @Override
    public TreeNode getCompanyNatures() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_COMPANY_NATURE);
    }

    @Override
    public TreeNode getCompanyPropertyRightStructures() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_COMPANY_PROPERTY_RIGHT_STRUCTURE);
    }

    @Override
    public TreeNode getContactImportantLevels() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_CONTACT_IMPORTANT_LEVEL);
    }

    @Override
    public TreeNode getPositionPriorities() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_POSITION_PRIORITY);
    }

    @Override
    public TreeNode getPositionFameCompanyBackgrounds() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_POSITION_FAME_COMPANY_BACKGROUND);
    }

    @Override
    public TreeNode getProjectImportantLevels() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_PROJECT_IMPORTANT_LEVEL);
    }

    @Override
    public TreeNode getProjectStatuses() {
        return treeService.findTreeByAncestorCode(TYPE_CODE_PROJECT_STATUS);
    }

}
