package com.newstar.hbms.project.domain;

import com.newstar.hbms.system.domain.User;

import java.io.Serializable;

/**
 * Created by fellowlong on 2016/11/18.
 */
public class ProjectAssistant implements Serializable {

  private Long id;

  private Long projectId;
  private Project project;

  private Long assistantId;
  private User assistant;

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
}
