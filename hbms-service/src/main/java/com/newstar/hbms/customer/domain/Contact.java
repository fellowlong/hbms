package com.newstar.hbms.customer.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 联系人
 *
 * Created by fellowlong on 14-6-4.
 */
public class Contact implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 姓名
   */
  private String name;

  /**
   * 客户编号，外键
   */
  private Long customerId;

  /**
   * 英文姓名
   */
  private String englishName;

  /**
   * 生日
   */
  private Date birthday;

  /**
   * 所在部门
   */
  private String department;

  /**
   * 职位
   */
  private String position;

  /**
   * 公司电话
   */
  private String companyPhone;

  /**
   * 移动电话
   */
  private String mobilePhone;

  /**
   * 公司传真
   */
  private String companyFax;

  /**
   * 电子邮箱
   */
  private String email;

  /**
   * 是否关键
   */
  private Boolean isKey;

  /**
   * 备注
   */
  private String remark;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEnglishName() {
    return englishName;
  }

  public void setEnglishName(String englishName) {
    this.englishName = englishName;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
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

  public String getCompanyPhone() {
    return companyPhone;
  }

  public void setCompanyPhone(String companyPhone) {
    this.companyPhone = companyPhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getCompanyFax() {
    return companyFax;
  }

  public void setCompanyFax(String companyFax) {
    this.companyFax = companyFax;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getIsKey() {
    return isKey;
  }

  public void setIsKey(Boolean isKey) {
    this.isKey = isKey;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
