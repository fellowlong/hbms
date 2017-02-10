package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.common.domain.Attachment;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangjinsi on 2016/2/9.
 */
public class Resume implements Serializable {

  private Long candidateId;

  /**
   * 简历名称（文件名）
   */
  private String name;

  /**
   * 简历附件
   */
  private Long attachmentId;

  /**
   * 简历附件
   */
  private Attachment attachment;

  /**
   * 原始简历文本
   */
  private String textResume;

  private Boolean yn;
  private Date createTime;
  private String createUser;
  private Date updateTime;
  private String updateUser;

  public Long getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(Long candidateId) {
    this.candidateId = candidateId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getAttachmentId() {
    return attachmentId;
  }

  public void setAttachmentId(Long attachmentId) {
    this.attachmentId = attachmentId;
  }

  public Attachment getAttachment() {
    return attachment;
  }

  public void setAttachment(Attachment attachment) {
    this.attachment = attachment;
  }

  public String getTextResume() {
    return textResume;
  }

  public void setTextResume(String textResume) {
    this.textResume = textResume;
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
