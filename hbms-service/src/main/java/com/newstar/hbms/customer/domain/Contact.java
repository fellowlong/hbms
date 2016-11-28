package com.newstar.hbms.customer.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.common.domain.Comment;
import com.newstar.hbms.system.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
   * 重要程度
   */
  private Long importantLevelId;
  private TreeNode importantLevel;

  /**
   * 公司编号，外键
   */
  private Long companyId;
  private Company company;

  /**
   * 姓名
   */
  private String name;

  /**
   * 英文姓名
   */
  private String englishName;

  /**
   * 性别
   */
  private Long sexId;

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
   * 其他联系方式
   */
  private String otherContact;

  /**
   * 生日
   */
  private Date birthday;

  /**
   * 维护人
   */
  private Long maintainerId;
  private User maintainer;

  /**
   * 批注
   */
  private List<Comment> comments = new ArrayList<Comment>();

  /**
   * 备注
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

  public Long getImportantLevelId() {
    return importantLevelId;
  }

  public void setImportantLevelId(Long importantLevelId) {
    this.importantLevelId = importantLevelId;
  }

  public TreeNode getImportantLevel() {
    return importantLevel;
  }

  public void setImportantLevel(TreeNode importantLevel) {
    this.importantLevel = importantLevel;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
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

  public Long getSexId() {
    return sexId;
  }

  public void setSexId(Long sexId) {
    this.sexId = sexId;
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

  public String getOtherContact() {
    return otherContact;
  }

  public void setOtherContact(String otherContact) {
    this.otherContact = otherContact;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Long getMaintainerId() {
    return maintainerId;
  }

  public void setMaintainerId(Long maintainerId) {
    this.maintainerId = maintainerId;
  }

  public User getMaintainer() {
    return maintainer;
  }

  public void setMaintainer(User maintainer) {
    this.maintainer = maintainer;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
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
