package com.newstar.hbms.basedata.service;

import com.newstar.hbms.basedata.domain.TreeNode;

import java.util.List;

/**
 * Created by wangjinsi on 2016/11/2.
 */
public interface BaseDataService {

    //单层
    //性别
    public static final String TYPE_CODE_SEX = "SEX";
    //婚姻状况
    public static final String TYPE_CODE_MARITAL = "MARITAL";
    //学历
    public static final String TYPE_CODE_DEGREE = "DEGREE";

    //多层
    //行业
    public static final String TYPE_CODE_INDUSTRY = "INDUSTRY";
    //职能
    public static final String TYPE_CODE_FUNCTION = "FUNCTION";
    //岗位
    public static final String TYPE_CODE_POSITION = "POSITION";
    //城市
    public static final String TYPE_CODE_CITY = "CITY";
    //标签
    public static final String TYPE_CODE_TAG = "TAG";
    //部门
    public static final String TYPE_CODE_DEPARTMENT = "DEPARTMENT";

    public static final String TYPE_CODE_COMPANY = "COMPANY";

    public static final String TYPE_CODE_JOB_HUNTING_STATUS = "JOB_HUNTING_STATUS";

    public static final String TYPE_CODE_COMPANY_TYPE = "COMPANY_TYPE";
    public static final String TYPE_CODE_COMPANY_FOLDER = "COMPANY_FOLDER";
    public static final String TYPE_CODE_COMPANY_NATURE = "COMPANY_NATURE";
    public static final String TYPE_CODE_COMPANY_PROPERTY_RIGHT_STRUCTURE = "COMPANY_PROPERTY_RIGHT_STRUCTURE";

    public static final String TYPE_CODE_CONTACT_IMPORTANT_LEVEL = "CONTACT_IMPORTANT_LEVEL";

    public static final String TYPE_CODE_PROJECT_IMPORTANT_LEVEL = "PROJECT_IMPORTANT_LEVEL";

    public static final String TYPE_CODE_PROJECT_STATUS = "PROJECT_STATUS";


    public TreeNode getSexes();
    public TreeNode getMaritals();
    public TreeNode getDegrees();
    public TreeNode getIndustries();
    public TreeNode getFunctions();
    public TreeNode getPositions();
    public TreeNode getCities();
    public TreeNode getTags();
    public TreeNode getDepartments();
    public TreeNode getCompanies();
    public TreeNode getJobHuntingStatuses();
    public TreeNode getCompanyTypes();
    public TreeNode getCompanyFolders();
    public TreeNode getCompanyNatures();
    public TreeNode getCompanyPropertyRightStructures();
    public TreeNode getContactImportantLevels();
    public TreeNode getProjectImportantLevels();
    public TreeNode getProjectStatuses();


}
