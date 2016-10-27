package com.newstar.hbms.customer.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 2014-09-22.
 */
public class Position implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * 年龄要求
   */
  private Integer minAge;
  private Integer maxAge;

  /**
   * 性别要求
   */
  private Integer sex;

  /**
   * 工作年限要求：
   */
  private Integer minWorkYears;
  private Integer maxWorkYears;

  /**
   * 学历要求
   */
  private String educationLevel;

  /**
   * 行业要求
   */
  private String industry;

  /**
   * 外语要求
   */
  private String foreignLanguage;

  /**
   * 招聘地址
   */
  private String address;

  /**
   * 说明
   */
  private String description;

  /**
   * 备注
   */
  private String remark;

  /**
   * 所属客户编号
   */
  private Long customerId;

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

  public Customer customer;

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

  public Integer getMinAge() {
    return minAge;
  }

  public void setMinAge(Integer minAge) {
    this.minAge = minAge;
  }

  public Integer getMaxAge() {
    return maxAge;
  }

  public void setMaxAge(Integer maxAge) {
    this.maxAge = maxAge;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Integer getMinWorkYears() {
    return minWorkYears;
  }

  public void setMinWorkYears(Integer minWorkYears) {
    this.minWorkYears = minWorkYears;
  }

  public Integer getMaxWorkYears() {
    return maxWorkYears;
  }

  public void setMaxWorkYears(Integer maxWorkYears) {
    this.maxWorkYears = maxWorkYears;
  }

  public String getEducationLevel() {
    return educationLevel;
  }

  public void setEducationLevel(String educationLevel) {
    this.educationLevel = educationLevel;
  }

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public String getForeignLanguage() {
    return foreignLanguage;
  }

  public void setForeignLanguage(String foreignLanguage) {
    this.foreignLanguage = foreignLanguage;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
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

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

}
