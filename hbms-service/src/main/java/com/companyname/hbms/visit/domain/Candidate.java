package com.companyname.hbms.visit.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 14-6-6.
 */
public class Candidate implements Serializable {

  /**
   * 姓名
   */
  private String name;

  /**
   * 性别
   */
  private String sex;

  /**
   * 出生日期
   */
  private Date birthday;

  /**
   * 年龄
   */
  private Integer age;

  /**
   * 学历
   */
  private String degree;

  /**
   * 手机号码
   */
  private String mobilePhone;

  /**
   * 工作电话
   */
  private String workPhone;

  /**
   * 电子邮箱
   */
  private String email;

  /**
   * 当前行业
   */
  private String currentIndustry;

  /**
   * 当前公司
   */
  private String currentCompany;

  /**
   * 部门
   */
  private String department;

  /**
   * 当前职位
   */
  private String position;

  /**
   * 简历等级
   */
  private String resumeLevel;

  /**
   * 现工作开始时间
   */
  private Date currentWorkStartTime;

  /**
   * 现工作地区
   */
  private String currentWorkRegion;

  /**
   * 项目公司
   */
  private Long companyId;

  /**
   * 项目
   */
  private Long projectId;

}
