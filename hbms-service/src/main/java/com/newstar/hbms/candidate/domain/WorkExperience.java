package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.common.domain.Domain;

/**
 * Created by fellowlong on 2014-05-27.
 */
public class WorkExperience extends Domain {

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
   * 公司
   */
  private String company;

  /**
   * 开始时间
   */
  private String startDate;

  /**
   * 结束时间
   */
  private String endDate;

  /**
   * 行业
   */
  private String industry;

  /**
   * 结束时间
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

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
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

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
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
