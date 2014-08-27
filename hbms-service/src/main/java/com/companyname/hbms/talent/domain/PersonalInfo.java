package com.companyname.hbms.talent.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 2014-05-27.
 */
public class PersonalInfo implements Serializable {


  private Long resumeId;

  /**
   * 姓名
   */
  private String name;

  /**
   * 性别
   */
  private Boolean sex;

  /**
   * 出生日期
   */
  private Date birthday;

  /**
   * 工作年限
   */
  private String workingYears;

  /**
   * 证件类型
   */
  private String papersType;

  /**
   * 证件编号
   */
  private String papersNumber;

  /**
   * 居住地
   */
  private String residence;

  /**
   * 海外学习/工作经历
   */
  private Boolean abroadStudyOrWork;

  /**
   * 电子邮箱
   */
  private String email;

  /**
   * 目前年薪
   */
  private double currentAnnualSalary;

  /**
   * 手机
   */
  private String mobilePhone;

  /**
   * 家庭电话
   */
  private String homePhone;

  /**
   * 公司电话
   */
  private String companyPhone;

  /**
   * 求职状态
   */
  private String jobHuntingStatus;

  /**
   * 户籍
   */
  private String householdRegister;

  /**
   * 关键词
   */
  private String keyword;

  /**
   * 国家
   */
  private String country;

  /**
   * 身高
   */
  private byte high;

  /**
   * 婚姻状况
   */
  private String maritalStatus;

  /**
   * 政治面貌
   */
  private String politicalStatus;

  /**
   * 邮编
   */
  private String postcode;

  /**
   * QQ号码
   */
  private String qq;

  /**
   * 联系地址
   */
  private String address;

  /**
   * 个人主页
   */
  private String selfHomepage;

  public Long getResumeId() {
    return resumeId;
  }

  public void setResumeId(Long resumeId) {
    this.resumeId = resumeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getSex() {
    return sex;
  }

  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getWorkingYears() {
    return workingYears;
  }

  public void setWorkingYears(String workingYears) {
    this.workingYears = workingYears;
  }

  public String getPapersType() {
    return papersType;
  }

  public void setPapersType(String papersType) {
    this.papersType = papersType;
  }

  public String getPapersNumber() {
    return papersNumber;
  }

  public void setPapersNumber(String papersNumber) {
    this.papersNumber = papersNumber;
  }

  public String getResidence() {
    return residence;
  }

  public void setResidence(String residence) {
    this.residence = residence;
  }

  public Boolean getAbroadStudyOrWork() {
    return abroadStudyOrWork;
  }

  public void setAbroadStudyOrWork(Boolean abroadStudyOrWork) {
    this.abroadStudyOrWork = abroadStudyOrWork;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getCurrentAnnualSalary() {
    return currentAnnualSalary;
  }

  public void setCurrentAnnualSalary(double currentAnnualSalary) {
    this.currentAnnualSalary = currentAnnualSalary;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public String getCompanyPhone() {
    return companyPhone;
  }

  public void setCompanyPhone(String companyPhone) {
    this.companyPhone = companyPhone;
  }

  public String getJobHuntingStatus() {
    return jobHuntingStatus;
  }

  public void setJobHuntingStatus(String jobHuntingStatus) {
    this.jobHuntingStatus = jobHuntingStatus;
  }

  public String getHouseholdRegister() {
    return householdRegister;
  }

  public void setHouseholdRegister(String householdRegister) {
    this.householdRegister = householdRegister;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public byte getHigh() {
    return high;
  }

  public void setHigh(byte high) {
    this.high = high;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getPoliticalStatus() {
    return politicalStatus;
  }

  public void setPoliticalStatus(String politicalStatus) {
    this.politicalStatus = politicalStatus;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getSelfHomepage() {
    return selfHomepage;
  }

  public void setSelfHomepage(String selfHomepage) {
    this.selfHomepage = selfHomepage;
  }

  @Override
  public String toString() {
    return "PersonalInfo{" +
        "resumeId=" + resumeId +
        ", name='" + name + '\'' +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", workingYears='" + workingYears + '\'' +
        ", papersType='" + papersType + '\'' +
        ", papersNumber='" + papersNumber + '\'' +
        ", residence='" + residence + '\'' +
        ", abroadStudyOrWork=" + abroadStudyOrWork +
        ", email='" + email + '\'' +
        ", currentAnnualSalary=" + currentAnnualSalary +
        ", mobilePhone='" + mobilePhone + '\'' +
        ", homePhone='" + homePhone + '\'' +
        ", companyPhone='" + companyPhone + '\'' +
        ", jobHuntingStatus='" + jobHuntingStatus + '\'' +
        ", householdRegister='" + householdRegister + '\'' +
        ", keyword='" + keyword + '\'' +
        ", country='" + country + '\'' +
        ", high=" + high +
        ", maritalStatus='" + maritalStatus + '\'' +
        ", politicalStatus='" + politicalStatus + '\'' +
        ", postcode='" + postcode + '\'' +
        ", qq='" + qq + '\'' +
        ", address='" + address + '\'' +
        ", selfHomepage='" + selfHomepage + '\'' +
        '}';
  }
}
