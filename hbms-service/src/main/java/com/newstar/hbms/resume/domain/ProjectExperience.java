package com.newstar.hbms.resume.domain;

import com.newstar.hbms.common.domain.Domain;

/**
 * Created by fellowlong on 2014/10/3.
 */
public class ProjectExperience extends Domain {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 简历编号
   */
  private Long resumeId;

  /**
   * 简历
   */
  private Resume resume;

  /**
   * 名称
   */
  private String name;

  /**
   * 开始时间
   */
  private String startDate;

  /**
   * 结束时间
   */
  private String endDate;

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
   * 项目中职责
   */
  private String responsibility;

  /**
   * 项目描述
   */
  private String projectDescription;

  /**
   * 项目职务
   */
  private String position;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getResumeId() {
    return resumeId;
  }

  public void setResumeId(Long resumeId) {
    this.resumeId = resumeId;
  }

  public Resume getResume() {
    return resume;
  }

  public void setResume(Resume resume) {
    this.resume = resume;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public Boolean getIsIt() {
    return isIt;
  }

  public void setIsIt(Boolean isIt) {
    this.isIt = isIt;
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

  public String getResponsibility() {
    return responsibility;
  }

  public void setResponsibility(String responsibility) {
    this.responsibility = responsibility;
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
}
