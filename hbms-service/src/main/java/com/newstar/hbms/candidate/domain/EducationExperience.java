package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.common.domain.Domain;

/**
 * Created by fellowlong on 2014-05-27.
 */
public class EducationExperience extends Domain {

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
   * 学校名称
   */
  private String school;

  /**
   * 开始时间
   */
  private String startDate;

  /**
   * 结束时间
   */
  private String endDate;

  /**
   * 学历
   */
  private String degree;

  /**
   * 专业
   */
  private String major;

  /**
   * 类型：统招、自考、成人、远程
   */
  private Long typeId;


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

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
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

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }
}
