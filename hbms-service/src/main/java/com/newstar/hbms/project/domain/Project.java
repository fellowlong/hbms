package com.newstar.hbms.project.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.domain.Contact;
import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.system.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 项目
 *
 * Created by fellowlong on 14-6-4.
 */
public class Project implements Serializable {

  /**
   * 主键
   */
  private Long id;

  /**
   * 项目编码
   */
  private String code;

  /**
   * 项目名称
   */
  private String name;

  /**
   * 客户公司
   */
  private Long companyId;
  private Company company;

  /**
   * 职位
   */
  private Long positionId;
  private Position position;

  /**
   * 客户联系人
   */
  private Long contactId;
  private Contact contact;

  /**
   * 重要程度
   */
  private Long importantLevelId;
  private TreeNode importantLevel;

  /**
   * 开始日期
   */
  private Date startDate;

  /**
   * 结束日期
   */
  private Date endDate;

  /**
   * 项目经理
   */
  private Long managerId;
  private User manager;

  /**
   * 顾问
   */
  private List<ProjectConsultant> consultants = new ArrayList<ProjectConsultant>();

  /**
   * 助理
   */
  private List<ProjectAssistant> assistants = new ArrayList<ProjectAssistant>();

  /**
   * 项目状态
   */
  private Long statusId;
  private TreeNode status;

  /**
   * 是否共享
   */
  private Boolean share;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public Long getPositionId() {
    return positionId;
  }

  public void setPositionId(Long positionId) {
    this.positionId = positionId;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Long getContactId() {
    return contactId;
  }

  public void setContactId(Long contactId) {
    this.contactId = contactId;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
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

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Long getManagerId() {
    return managerId;
  }

  public void setManagerId(Long managerId) {
    this.managerId = managerId;
  }

  public User getManager() {
    return manager;
  }

  public void setManager(User manager) {
    this.manager = manager;
  }

  public List<ProjectAssistant> getAssistants() {
    return assistants;
  }

  public void setAssistants(List<ProjectAssistant> assistants) {
    this.assistants = assistants;
  }

  public List<ProjectConsultant> getConsultants() {
    return consultants;
  }

  public void setConsultants(List<ProjectConsultant> consultants) {
    this.consultants = consultants;
  }

  public Long getStatusId() {
    return statusId;
  }

  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }

  public TreeNode getStatus() {
    return status;
  }

  public void setStatus(TreeNode status) {
    this.status = status;
  }

  public Boolean getShare() {
    return share;
  }

  public void setShare(Boolean share) {
    this.share = share;
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
