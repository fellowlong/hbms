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
    public static final String TYPE_CODE_STATION = "STATION";
    //城市
    public static final String TYPE_CODE_CITY = "CITY";
    //标签
    public static final String TYPE_CODE_TAG = "TAG";
    //部门
    public static final String TYPE_CODE_DEPARTMENT = "DEPARTMENT";


    public List<TreeNode> getSexes();
    public List<TreeNode> getMaritals();
    public List<TreeNode> getDegree();
    public List<TreeNode> getIndustries();
    public List<TreeNode> getFunctions();
    public List<TreeNode> getStations();
    public List<TreeNode> getCities();
    public List<TreeNode> getTags();
    public List<TreeNode> getDepartments();


}
