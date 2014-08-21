package com.companyname.hbms.visit.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 14-6-6.
 */
public class Candidate implements Serializable {

  /**
   * 主键
   */
  private Long id;

  /**
   * 外键，寻访记录的主键
   */
  private Long visitId;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getVisitId() {
    return visitId;
  }

  public void setVisitId(Long visitId) {
    this.visitId = visitId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCurrentIndustry() {
    return currentIndustry;
  }

  public void setCurrentIndustry(String currentIndustry) {
    this.currentIndustry = currentIndustry;
  }

  public String getCurrentCompany() {
    return currentCompany;
  }

  public void setCurrentCompany(String currentCompany) {
    this.currentCompany = currentCompany;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getResumeLevel() {
    return resumeLevel;
  }

  public void setResumeLevel(String resumeLevel) {
    this.resumeLevel = resumeLevel;
  }

  public Date getCurrentWorkStartTime() {
    return currentWorkStartTime;
  }

  public void setCurrentWorkStartTime(Date currentWorkStartTime) {
    this.currentWorkStartTime = currentWorkStartTime;
  }

  public String getCurrentWorkRegion() {
    return currentWorkRegion;
  }

  public void setCurrentWorkRegion(String currentWorkRegion) {
    this.currentWorkRegion = currentWorkRegion;
  }

}
