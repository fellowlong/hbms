package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.basedata.domain.TreeNode;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 2014-05-27.
 */
public class EducationExperience  implements Serializable {//dsafasdfgdgfgfhgfijwkl234klkdfkl

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
   * 学校，外键
   */
  private String school;

  /**
   * 开始时间
   */
  private Date startDate;

  /**
   * 结束时间
   */
  private Date endDate;

  /**
   * 学历，外键
   */
  private Long degreeId;
  private TreeNode degree;

  /**
   * 专业，外键
   */
  private Long majorId;
  private TreeNode major;

  /**
   * 类型：统招、自考、成人、远程
   */
  private Long typeId;
  private TreeNode type;

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

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
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

  public Long getDegreeId() {
    return degreeId;
  }

  public void setDegreeId(Long degreeId) {
    this.degreeId = degreeId;
  }

  public TreeNode getDegree() {
    return degree;
  }

  public void setDegree(TreeNode degree) {
    this.degree = degree;
  }

  public Long getMajorId() {
    return majorId;
  }

  public void setMajorId(Long majorId) {
    this.majorId = majorId;
  }

  public TreeNode getMajor() {
    return major;
  }

  public void setMajor(TreeNode major) {
    this.major = major;
  }

  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  public TreeNode getType() {
    return type;
  }

  public void setType(TreeNode type) {
    this.type = type;
  }
}
