package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.common.domain.Domain;

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
  private Candidate candidate;

  /**
   * 证书名称
   */
  private Long certificateId;

  /**
   * 取得时间
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

  public Candidate getCandidate() {
    return candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  public Long getCertificateId() {
    return certificateId;
  }

  public void setCertificateId(Long certificateId) {
    this.certificateId = certificateId;
  }

  public String getAcquireDate() {
    return acquireDate;
  }

  public void setAcquireDate(String acquireDate) {
    this.acquireDate = acquireDate;
  }
}
