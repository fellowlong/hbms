package com.newstar.hbms.customer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户
 *
 * Created by fellowlong on 14-6-4.
 */
public class Company implements Serializable {

  /**
   * 主键
   */
  private Long id;

  private Long companyTypeId;

  /**
   * 名称
   */
  private String name;

  /**
   * 公司全称
   */
  private String fullName;

  /**
   * 所属行业，可以选三个
   */
  private Long industryId1;
  private Long industryId2;
  private Long industryId3;

  /**
   * 所在城市
   */
  private Long cityId;

  /**
   * 电话
   */
  private String phone;

  /**
   * web站点
   */
  private String webSite;

  /**
   * 地址
   */
  private String address;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 传真
   */
  private String fax;

  /**
   * 维护人
   */
  private Long maintainer;

  /**
   * 所属文件夹
   */
  private Long folderId;

  /**
   * 员工数量
   */
  private Integer staffCount;

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
   * 企业简介
   */
  private String intro;
  /**
   * 关键字
   */
  private String keyword;

  /**
   * 客户开发者
   */
  private Long businessDeveloper;

  /**
   * 客户联系人
   */
  private List<Contact> contacts = new ArrayList<Contact>();

  /**
   * 企业备注
   */
  private String remark;

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

  public Long getCompanyTypeId() {
    return companyTypeId;
  }

  public void setCompanyTypeId(Long companyTypeId) {
    this.companyTypeId = companyTypeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Long getIndustryId1() {
    return industryId1;
  }

  public void setIndustryId1(Long industryId1) {
    this.industryId1 = industryId1;
  }

  public Long getIndustryId2() {
    return industryId2;
  }

  public void setIndustryId2(Long industryId2) {
    this.industryId2 = industryId2;
  }

  public Long getIndustryId3() {
    return industryId3;
  }

  public void setIndustryId3(Long industryId3) {
    this.industryId3 = industryId3;
  }

  public Long getCityId() {
    return cityId;
  }

  public void setCityId(Long cityId) {
    this.cityId = cityId;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getWebSite() {
    return webSite;
  }

  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public Long getMaintainer() {
    return maintainer;
  }

  public void setMaintainer(Long maintainer) {
    this.maintainer = maintainer;
  }

  public Long getFolderId() {
    return folderId;
  }

  public void setFolderId(Long folderId) {
    this.folderId = folderId;
  }

  public Integer getStaffCount() {
    return staffCount;
  }

  public void setStaffCount(Integer staffCount) {
    this.staffCount = staffCount;
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

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
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

  public Long getBusinessDeveloper() {
    return businessDeveloper;
  }

  public void setBusinessDeveloper(Long businessDeveloper) {
    this.businessDeveloper = businessDeveloper;
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