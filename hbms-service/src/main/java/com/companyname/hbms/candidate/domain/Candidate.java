package com.companyname.hbms.candidate.domain;

import com.companyname.hbms.basedata.domain.ListItem;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 2014-08-25.
 */
public class Candidate implements Serializable {

  /**
   * 编号
   */
  private Long id;

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
  private Integer workingYears;

  /**
   * 证件类型编号
   */
  private Long papersTypeId;

  /**
   * 证件类型
   */
  private ListItem papersType;

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
   * 求职状态编号
   */
  private Long jobHuntingStatusId;

  /**
   * 求职状态
   */
  private ListItem jobHuntingStatus;

  /**
   * 户籍
   */
  private String householdRegister;

  /**
   * 关键词
   */
  private String keyword;

  /**
   * 国家编号
   */
  private Long countryId;

  /**
   * 国家
   */
  private ListItem country;

  /**
   * 身高
   */
  private byte high;

  /**
   * 婚姻状况编号
   */
  private Long maritalStatusId;
  /**
   * 婚姻状况
   */
  private ListItem maritalStatus;

  /**
   * 政治面貌编号
   */
  private Long politicalStatusId;

  /**
   * 政治面貌
   */
  private ListItem politicalStatus;

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

  /**
   * 是否有效
   */
  private Boolean yn;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private String createUser;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private String updateUser;

  /**
   * 最近原始简历
   */
  private Resume lastOriginalResume;

  /**
   * 最近简历报告
   */
  private Resume lastReportResume;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Integer getWorkingYears() {
    return workingYears;
  }

  public void setWorkingYears(Integer workingYears) {
    this.workingYears = workingYears;
  }

  public Long getPapersTypeId() {
    return papersTypeId;
  }

  public void setPapersTypeId(Long papersTypeId) {
    this.papersTypeId = papersTypeId;
  }

  public ListItem getPapersType() {
    return papersType;
  }

  public void setPapersType(ListItem papersType) {
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

  public Long getJobHuntingStatusId() {
    return jobHuntingStatusId;
  }

  public void setJobHuntingStatusId(Long jobHuntingStatusId) {
    this.jobHuntingStatusId = jobHuntingStatusId;
  }

  public ListItem getJobHuntingStatus() {
    return jobHuntingStatus;
  }

  public void setJobHuntingStatus(ListItem jobHuntingStatus) {
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

  public Long getCountryId() {
    return countryId;
  }

  public void setCountryId(Long countryId) {
    this.countryId = countryId;
  }

  public ListItem getCountry() {
    return country;
  }

  public void setCountry(ListItem country) {
    this.country = country;
  }

  public byte getHigh() {
    return high;
  }

  public void setHigh(byte high) {
    this.high = high;
  }

  public Long getMaritalStatusId() {
    return maritalStatusId;
  }

  public void setMaritalStatusId(Long maritalStatusId) {
    this.maritalStatusId = maritalStatusId;
  }

  public ListItem getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(ListItem maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public Long getPoliticalStatusId() {
    return politicalStatusId;
  }

  public void setPoliticalStatusId(Long politicalStatusId) {
    this.politicalStatusId = politicalStatusId;
  }

  public ListItem getPoliticalStatus() {
    return politicalStatus;
  }

  public void setPoliticalStatus(ListItem politicalStatus) {
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

  public Boolean getYn() {
    return yn;
  }

  public void setYn(Boolean yn) {
    this.yn = yn;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Resume getLastOriginalResume() {
    return lastOriginalResume;
  }

  public void setLastOriginalResume(Resume lastOriginalResume) {
    this.lastOriginalResume = lastOriginalResume;
  }

  public Resume getLastReportResume() {
    return lastReportResume;
  }

  public void setLastReportResume(Resume lastReportResume) {
    this.lastReportResume = lastReportResume;
  }

  @Override
  public String toString() {
    return "Candidate{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", sex=" + sex +
      ", birthday=" + birthday +
      ", workingYears=" + workingYears +
      ", papersTypeId=" + papersTypeId +
      ", papersType=" + papersType +
      ", papersNumber='" + papersNumber + '\'' +
      ", residence='" + residence + '\'' +
      ", abroadStudyOrWork=" + abroadStudyOrWork +
      ", email='" + email + '\'' +
      ", currentAnnualSalary=" + currentAnnualSalary +
      ", mobilePhone='" + mobilePhone + '\'' +
      ", homePhone='" + homePhone + '\'' +
      ", companyPhone='" + companyPhone + '\'' +
      ", jobHuntingStatusId=" + jobHuntingStatusId +
      ", jobHuntingStatus=" + jobHuntingStatus +
      ", householdRegister='" + householdRegister + '\'' +
      ", keyword='" + keyword + '\'' +
      ", countryId=" + countryId +
      ", country=" + country +
      ", high=" + high +
      ", maritalStatus=" + maritalStatus +
      ", politicalStatusId=" + politicalStatusId +
      ", politicalStatus=" + politicalStatus +
      ", postcode='" + postcode + '\'' +
      ", qq='" + qq + '\'' +
      ", address='" + address + '\'' +
      ", selfHomepage='" + selfHomepage + '\'' +
      ", yn=" + yn +
      ", createTime=" + createTime +
      ", createUser='" + createUser + '\'' +
      ", updateTime=" + updateTime +
      ", updateUser='" + updateUser + '\'' +
      ", lastOriginalResume=" + lastOriginalResume +
      ", lastReportResume=" + lastReportResume +
      '}';
  }
}
