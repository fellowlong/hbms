package com.newstar.hbms.project.domain;

import com.newstar.hbms.customer.domain.Contact;
import com.newstar.hbms.customer.domain.Customer;
import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.system.domain.User;

import java.io.Serializable;
import java.util.Date;

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
   * 项目名称
   */
  private String name;

  /**
   * 开始日期
   */
  private Date startDate;

  /**
   * 结束日期
   */
  private Date endDate;

  /**
   * 客户编号
   */
  private Long customerId;

  private Customer customer;

  /**
   * 职位编号
   */
  private Long positionId;

  private Position position;

  /**
   * 客户联系人
   */
  private Long contractId;

  private Contact contact;

  /**
   * 顾问
   */
  private Long consultantId;

  private User consultant;

  /**
   * 助理
   */
  private Long assistantId;

  private User assistant;

  /**
   * 项目负责人
   */
  private Long managerId;

  private User manager;

  /**
   * 项目级别
   */
  private String level;

  /**
   * 项目状态
   */
  private String status;

  /**
   * 项目计划
   */
  private String plant;

  /**
   * 计划备注
   */
  private String plantRemark;

  /**
   * 是否关键
   */
  private Boolean isKey;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
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

  public Long getContractId() {
    return contractId;
  }

  public void setContractId(Long contractId) {
    this.contractId = contractId;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Long getConsultantId() {
    return consultantId;
  }

  public void setConsultantId(Long consultantId) {
    this.consultantId = consultantId;
  }

  public User getConsultant() {
    return consultant;
  }

  public void setConsultant(User consultant) {
    this.consultant = consultant;
  }

  public Long getAssistantId() {
    return assistantId;
  }

  public void setAssistantId(Long assistantId) {
    this.assistantId = assistantId;
  }

  public User getAssistant() {
    return assistant;
  }

  public void setAssistant(User assistant) {
    this.assistant = assistant;
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

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPlant() {
    return plant;
  }

  public void setPlant(String plant) {
    this.plant = plant;
  }

  public String getPlantRemark() {
    return plantRemark;
  }

  public void setPlantRemark(String plantRemark) {
    this.plantRemark = plantRemark;
  }

  public Boolean getKey() {
    return isKey;
  }

  public void setKey(Boolean key) {
    isKey = key;
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
