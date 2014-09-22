package com.companyname.hbms.project.domain;

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
   * 开始日期
   */
  private Date startDate;

  /**
   * 结束日期
   */
  private Date endDate;

  /**
   * 客户联系人
   */
  private String contract;

  /**
   * 顾问
   */
  private String consultant;

  /**
   * 助理
   */
  private String assistant;

  /**
   * 项目负责人
   */
  private String leader;

  /**
   * 销售员
   */
  private String salesman;

  /**
   * 项目级别
   */
  private String level;

  /**
   * 是否关键
   */
  private String isKey;

  /**
   * 项目状态
   */
  private String status;

  /**
   * 备注
   */
  private String remark;

  /**
   * 项目计划
   */
  private String plant;

  /**
   * 计划备注
   */
  private String plantRemark;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getContract() {
    return contract;
  }

  public void setContract(String contract) {
    this.contract = contract;
  }

  public String getConsultant() {
    return consultant;
  }

  public void setConsultant(String consultant) {
    this.consultant = consultant;
  }

  public String getAssistant() {
    return assistant;
  }

  public void setAssistant(String assistant) {
    this.assistant = assistant;
  }

  public String getLeader() {
    return leader;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }

  public String getSalesman() {
    return salesman;
  }

  public void setSalesman(String salesman) {
    this.salesman = salesman;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getIsKey() {
    return isKey;
  }

  public void setIsKey(String isKey) {
    this.isKey = isKey;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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
}
