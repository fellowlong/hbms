package com.companyname.hbms.resume.domain;

import java.io.Serializable;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class OriginalResume implements Serializable {

  /**
   * 主键
   */
  private Long id;

  /**
   * 简历编号，外键
   */
  private Long resumeId;

  /**
   * 简历名称
   */
  private String name;

  /**
   * 搜索关键字
   */
  private String keyword;

  /**
   * 附件名称
   */
  private String attachmentName;

  /**
   * 附件路径
   */
  private String attachmentPath;

  /**
   * 是否有效
   */
  private Boolean yn;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getAttachmentName() {
    return attachmentName;
  }

  public void setAttachmentName(String attachmentName) {
    this.attachmentName = attachmentName;
  }

  public String getAttachmentPath() {
    return attachmentPath;
  }

  public void setAttachmentPath(String attachmentPath) {
    this.attachmentPath = attachmentPath;
  }

  public Boolean getYn() {
    return yn;
  }

  public void setYn(Boolean yn) {
    this.yn = yn;
  }

  @Override
  public String toString() {
    return "OriginalResume{" +
        "id=" + id +
        ", resumeId='" + resumeId + '\'' +
        ", name='" + name + '\'' +
        ", keyword='" + keyword + '\'' +
        ", attachmentName='" + attachmentName + '\'' +
        ", attachmentPath='" + attachmentPath + '\'' +
        ", yn='" + yn + '\'' +
        '}';
  }
}
