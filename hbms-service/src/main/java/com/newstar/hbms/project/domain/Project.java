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
   * 重要程度
   */
  private Long importantLevelId;
  private TreeNode importantLevel;

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
   * 所含职位
   */
  private List<Position> positions;

  /**
   * 项目负责人
   */
  private Long managerId;
  private User manager;

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
   * 其他顾问
   */
  private List<User> otherConsultants = new ArrayList<User>();

  /**
   * 项目状态
   */
  private Long statusId;
  private TreeNode status;

  /**
   * 项目计划
   */
  private Long plantId;
  private TreeNode plant;

  /**
   * 计划备注
   */
  private String plantRemark;

  /**
   * 备注
   */
  private String remark;

  /**
   * 是否共享
   */
  private Boolean share;

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

  public List<Position> getPositions() {
    return positions;
  }

  public void setPositions(List<Position> positions) {
    this.positions = positions;
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

  public List<User> getOtherConsultants() {
    return otherConsultants;
  }

  public void setOtherConsultants(List<User> otherConsultants) {
    this.otherConsultants = otherConsultants;
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

  public Long getPlantId() {
    return plantId;
  }

  public void setPlantId(Long plantId) {
    this.plantId = plantId;
  }

  public TreeNode getPlant() {
    return plant;
  }

  public void setPlant(TreeNode plant) {
    this.plant = plant;
  }

  public String getPlantRemark() {
    return plantRemark;
  }

  public void setPlantRemark(String plantRemark) {
    this.plantRemark = plantRemark;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Boolean getShare() {
    return share;
  }

  public void setShare(Boolean share) {
    this.share = share;
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
