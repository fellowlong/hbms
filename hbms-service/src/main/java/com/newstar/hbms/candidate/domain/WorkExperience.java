package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.common.domain.Domain;

import java.util.Date;

/**
 * Created by fellowlong on 2014-05-27.
 */
public class WorkExperience extends Domain {

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
   * 公司
   */
  private String company;

  /**
   * 开始时间
   */
  private Date startDate;

  /**
   * 结束时间
   */
  private Date endDate;

  /**
   * 职位
   */
  private String position;

  /**
   * 工作职责
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

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
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
