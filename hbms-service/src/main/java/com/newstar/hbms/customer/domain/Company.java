package com.newstar.hbms.customer.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.system.domain.User;

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
  private TreeNode companyType;

  /**
   * 名称
   */
  private String name;

  /**
   * 公司全称
   */
  private String fullName;

  /**
   * 所属行业
   */
  private List<CompanyIndustry> industries = new ArrayList<CompanyIndustry>();

  /**
   * 所在城市
   */
  private Long cityId;
  private TreeNode city;

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
  private Long businessDeveloperId;
  private User businessDeveloper;

  /**
   * 所属文件夹
   */
  private Long folderId;
  private List<CompanyFolder> folders = new ArrayList<CompanyFolder>();

  /**
   * 员工数量
   */
  private Integer staffCount;

  /**
   * 企业性质
   */
  private Long natureId;
  private TreeNode nature;

  /**
   * 产品
   */
  private String products;

  /**
   * 注册资金
   */
  private Double registeredCapital;

  /**
   * 法人
   */
  private String legalPerson;

  /**
   * 产权结构
   */
  private Long propertyRightStructureId;
  private TreeNode propertyRightStructure;

  /**
   * 企业简介
   */
  private String intro;

  /**
   * 客户联系人
   */
  private List<Contact> contacts = new ArrayList<Contact>();

  /**
   * 关键字
   */
  private String keyword;

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

  public TreeNode getCompanyType() {
    return companyType;
  }

  public void setCompanyType(TreeNode companyType) {
    this.companyType = companyType;
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

  public List<CompanyIndustry> getIndustries() {
    return industries;
  }

  public void setIndustries(List<CompanyIndustry> industries) {
    this.industries = industries;
  }

  public Long getCityId() {
    return cityId;
  }

  public void setCityId(Long cityId) {
    this.cityId = cityId;
  }

  public TreeNode getCity() {
    return city;
  }

  public void setCity(TreeNode city) {
    this.city = city;
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

  public Long getBusinessDeveloperId() {
    return businessDeveloperId;
  }

  public void setBusinessDeveloperId(Long businessDeveloperId) {
    this.businessDeveloperId = businessDeveloperId;
  }

  public User getBusinessDeveloper() {
    return businessDeveloper;
  }

  public void setBusinessDeveloper(User businessDeveloper) {
    this.businessDeveloper = businessDeveloper;
  }

  public Long getFolderId() {
    return folderId;
  }

  public void setFolderId(Long folderId) {
    this.folderId = folderId;
  }

  public List<CompanyFolder> getFolders() {
    return folders;
  }

  public void setFolders(List<CompanyFolder> folders) {
    this.folders = folders;
  }

  public Integer getStaffCount() {
    return staffCount;
  }

  public void setStaffCount(Integer staffCount) {
    this.staffCount = staffCount;
  }

  public Long getNatureId() {
    return natureId;
  }

  public void setNatureId(Long natureId) {
    this.natureId = natureId;
  }

  public TreeNode getNature() {
    return nature;
  }

  public void setNature(TreeNode nature) {
    this.nature = nature;
  }

  public String getProducts() {
    return products;
  }

  public void setProducts(String products) {
    this.products = products;
  }

  public Double getRegisteredCapital() {
    return registeredCapital;
  }

  public void setRegisteredCapital(Double registeredCapital) {
    this.registeredCapital = registeredCapital;
  }

  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }

  public Long getPropertyRightStructureId() {
    return propertyRightStructureId;
  }

  public void setPropertyRightStructureId(Long propertyRightStructureId) {
    this.propertyRightStructureId = propertyRightStructureId;
  }

  public TreeNode getPropertyRightStructure() {
    return propertyRightStructure;
  }

  public void setPropertyRightStructure(TreeNode propertyRightStructure) {
    this.propertyRightStructure = propertyRightStructure;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public List<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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