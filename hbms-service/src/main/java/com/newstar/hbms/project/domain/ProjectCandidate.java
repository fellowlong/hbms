package com.newstar.hbms.project.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.system.domain.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangjinsi on 2016/11/18.
 */
public class ProjectCandidate implements Serializable {

  private Long id;

  private Long projectId;
  private Project project;

  private Long candidateId;
  private Candidate candidate;

  private TreeNode status;


  /**
   *
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

  public TreeNode getStatus() {
    return status;
  }

  public void setStatus(TreeNode status) {
    this.status = status;
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

  @Override
  public String toString() {
    return "ProjectCandidate{" +
            "id=" + id +
            ", projectId=" + projectId +
            ", project=" + project +
            ", candidateId=" + candidateId +
            ", candidate=" + candidate +
            ", status=" + status +
            ", yn=" + yn +
            ", createTime=" + createTime +
            ", createUser='" + createUser + '\'' +
            ", updateTime=" + updateTime +
            '}';
  }
}
