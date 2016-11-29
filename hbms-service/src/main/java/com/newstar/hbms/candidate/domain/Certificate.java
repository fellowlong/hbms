package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.common.domain.Domain;

import java.util.Date;

/**
 * Created by fellowlong on 2014-05-27.
 */
public class Certificate extends Domain {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 人才外键
   */
  private Long candidateId;
  private Candidate candidate;

  /**
   * 证书名称
   */
  private Long certificateId;
  private TreeNode certificate;

  /**
   * 取得时间
   */
  private Date acquireDate;

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

  public Long getCertificateId() {
    return certificateId;
  }

  public void setCertificateId(Long certificateId) {
    this.certificateId = certificateId;
  }

  public TreeNode getCertificate() {
    return certificate;
  }

  public void setCertificate(TreeNode certificate) {
    this.certificate = certificate;
  }

  public Date getAcquireDate() {
    return acquireDate;
  }

  public void setAcquireDate(Date acquireDate) {
    this.acquireDate = acquireDate;
  }
}
