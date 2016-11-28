package com.newstar.hbms.project.domain;

import com.newstar.hbms.system.domain.User;

import java.io.Serializable;

/**
 * Created by wangjinsi on 2016/11/18.
 */
public class ProjectConsultant implements Serializable {

  private Long id;

  private Long projectId;
  private Project project;

  private Long consultantId;
  private User consultant;

  /**
   * 主要顾问
   */
  private Boolean isMaster;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
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

  public Boolean getMaster() {
    return isMaster;
  }

  public void setMaster(Boolean master) {
    isMaster = master;
  }
}
