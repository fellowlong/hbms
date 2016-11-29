package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.common.domain.Domain;

import java.util.Date;

/**
 * Created by fellowlong on 2014/10/3.
 */
public class ProjectExperience extends Domain {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 人才，外键
   */
  private Long candidateId;
  private Candidate candidate;

  /**
   * 名称
   */
  private String name;

  /**
   * 开始时间
   */
  private Date startDate;

  /**
   * 结束时间
   */
  private Date endDate;

  /**
   * 是否IT项目
   */
  private Boolean isIt;

  /**
   * 软件环境
   */
  private String softwareEnvironment;

  /**
   * 硬件环境
   */
  private String hardwareEnvironment;

  /**
   * 开发工具
   */
  private String developTool;

  /**
   * 项目描述
   */
  private String projectDescription;

  /**
   * 项目职务
   */
  private String position;

  /**
   * 项目中职责
   */
  private String responsibility;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(Long candidateId) {
    this.candidateId = candidateId;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
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

  public Boolean getIt() {
    return isIt;
  }

  public void setIt(Boolean it) {
    isIt = it;
  }

  public String getSoftwareEnvironment() {
    return softwareEnvironment;
  }

  public void setSoftwareEnvironment(String softwareEnvironment) {
    this.softwareEnvironment = softwareEnvironment;
  }

  public String getHardwareEnvironment() {
    return hardwareEnvironment;
  }

  public void setHardwareEnvironment(String hardwareEnvironment) {
    this.hardwareEnvironment = hardwareEnvironment;
  }

  public String getDevelopTool() {
    return developTool;
  }

  public void setDevelopTool(String developTool) {
    this.developTool = developTool;
  }

  public String getProjectDescription() {
    return projectDescription;
  }

  public void setProjectDescription(String projectDescription) {
    this.projectDescription = projectDescription;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getResponsibility() {
    return responsibility;
  }

  public void setResponsibility(String responsibility) {
    this.responsibility = responsibility;
  }
}
