package com.newstar.hbms.customer.domain;

import java.io.Serializable;

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
   * 占地面积
   */
  private String floorSpace;

  /**
   * 员工数量
   */
  private Integer staffCount;

  /**
   * 年产量
   */
  private String annuallyOutput;

  /**
   * 内销比例
   */
  private String domesticSaleRatio;

  /**
   * 编号
   */
  private String number;

  /**
   * 行业
   */
  private String industry;

  /**
   * 性质
   */
  private String nature;

  /**
   * 类型
   */
  private String type;

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
   * 管理人员数量
   */
  private String managerialStaffCount;

  /**
   * 产值
   */
  private String outputValue;

  /**
   * 外销比例
   */
  private String exportSaleRatio;

  /**
   * 其他信息
   */
  private String otherInfo;

  /**
   * 企业备注
   */
  private String remark;

  /**
   * 关键字
   */
  private String keyword;


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

  public String getFloorSpace() {
    return floorSpace;
  }

  public void setFloorSpace(String floorSpace) {
    this.floorSpace = floorSpace;
  }

  public Integer getStaffCount() {
    return staffCount;
  }

  public void setStaffCount(Integer staffCount) {
    this.staffCount = staffCount;
  }

  public String getAnnuallyOutput() {
    return annuallyOutput;
  }

  public void setAnnuallyOutput(String annuallyOutput) {
    this.annuallyOutput = annuallyOutput;
  }

  public String getDomesticSaleRatio() {
    return domesticSaleRatio;
  }

  public void setDomesticSaleRatio(String domesticSaleRatio) {
    this.domesticSaleRatio = domesticSaleRatio;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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

  public String getManagerialStaffCount() {
    return managerialStaffCount;
  }

  public void setManagerialStaffCount(String managerialStaffCount) {
    this.managerialStaffCount = managerialStaffCount;
  }

  public String getOutputValue() {
    return outputValue;
  }

  public void setOutputValue(String outputValue) {
    this.outputValue = outputValue;
  }

  public String getExportSaleRatio() {
    return exportSaleRatio;
  }

  public void setExportSaleRatio(String exportSaleRatio) {
    this.exportSaleRatio = exportSaleRatio;
  }

  public String getOtherInfo() {
    return otherInfo;
  }

  public void setOtherInfo(String otherInfo) {
    this.otherInfo = otherInfo;
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
}