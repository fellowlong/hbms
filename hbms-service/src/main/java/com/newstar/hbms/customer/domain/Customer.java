package com.newstar.hbms.customer.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户
 *
 * Created by fellowlong on 14-6-4.
 */
public class Customer implements Serializable {

  /**
   * 主键
   */
  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * web站点
   */
  private String webSite;

  /**
   * 电话
   */
  private String phone;

  /**
   * 传真
   */
  private String fax;

  /**
   * 地区
   */
  private String region;

  /**
   * 地址
   */
  private String address;

  /**
   * 邮编
   */
  private String postCode;

  /**
   * 员工数量
   */
  private Integer staffCount;

  /**
   * 所属行业
   */
  private String industry;

  /**
   * 企业性质
   */
  private String nature;

  /**
   * 产品
   */
  private String products;

  /**
   * 注册资金
   */
  private String registeredCapital;

  /**
   * 法人
   */
  private String legalPerson;

  /**
   * 产权结构
   */
  private String propertyRightStructure;

  /**
   * 企业备注
   */
  private String remark;

  /**
   * 关键字
   */
  private String keyword;

  /**
   * 是否有效
   * @return
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

  public String getWebSite() {
    return webSite;
  }

  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public Integer getStaffCount() {
    return staffCount;
  }

  public void setStaffCount(Integer staffCount) {
    this.staffCount = staffCount;
  }

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public String getNature() {
    return nature;
  }

  public void setNature(String nature) {
    this.nature = nature;
  }

  public String getProducts() {
    return products;
  }

  public void setProducts(String products) {
    this.products = products;
  }

  public String getRegisteredCapital() {
    return registeredCapital;
  }

  public void setRegisteredCapital(String registeredCapital) {
    this.registeredCapital = registeredCapital;
  }

  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }

  public String getPropertyRightStructure() {
    return propertyRightStructure;
  }

  public void setPropertyRightStructure(String propertyRightStructure) {
    this.propertyRightStructure = propertyRightStructure;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
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
}