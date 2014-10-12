package com.companyname.hbms.resume.domain;

import com.companyname.hbms.common.domain.Domain;

import java.io.Serializable;

/**
 * Created by fellowlong on 2014-05-27.
 */
public class Certificate extends Domain {

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
   * 证书名称
   */
  private String name;

  /**
   * 获取时间
   */
  private String acquireDate;

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

  public String getAcquireDate() {
    return acquireDate;
  }

  public void setAcquireDate(String acquireDate) {
    this.acquireDate = acquireDate;
  }
}
