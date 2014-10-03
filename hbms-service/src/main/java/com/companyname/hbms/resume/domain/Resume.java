package com.companyname.hbms.resume.domain;

import java.io.Serializable;
import java.util.List;

public class Resume implements Serializable {

  /**
   * 主键，编号
   */
  private Long id;

  /**
   * 姓名
   */
  private String name;

  /**
   * 性别
   */
  private Boolean sex;

  /**
   * 手机号码
   */
  private String telephone;

  /**
   * 年龄
   */
  private Integer age;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 教育
   */
  private String education;

  /**
   * 工作年限
   */
  private String workTime;

  /**
   * 婚姻状况
   */
  private String marital;

  /**
   * 所在地
   */
  private String location;

  /**
   * 所在行业
   */
  private String industry;

  /**
   * 公司
   */
  private String company;

  /**
   * 年薪
   */
  private String position;

  /**
   * 薪资
   */
  private String salary;

  /**
   * 自我评价
   */
  private String selfEvaluation;

  /**
   * 工作经历
   */
  private List<WorkExperience> workExperiences;

  /**
   * 教育经历
   */
  private List<EducationExperience> educationExperiences;


  /**
   * 语言能力
   */
  private List<LanguageAbility> languageAbilities;

  /**
   * 证书
   */
  private List<Certificate> certificates;

  /**
   * 其他信息
   */
  private String other;

  /**
   * 项目经验
   */
  private List<ProjectExperience> projectExperiences;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getSex() {
    return sex;
  }

  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getWorkTime() {
    return workTime;
  }

  public void setWorkTime(String workTime) {
    this.workTime = workTime;
  }

  public String getMarital() {
    return marital;
  }

  public void setMarital(String marital) {
    this.marital = marital;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getSelfEvaluation() {
    return selfEvaluation;
  }

  public void setSelfEvaluation(String selfEvaluation) {
    this.selfEvaluation = selfEvaluation;
  }

  public List<WorkExperience> getWorkExperiences() {
    return workExperiences;
  }

  public void setWorkExperiences(List<WorkExperience> workExperiences) {
    this.workExperiences = workExperiences;
  }

  public List<EducationExperience> getEducationExperiences() {
    return educationExperiences;
  }

  public void setEducationExperiences(List<EducationExperience> educationExperiences) {
    this.educationExperiences = educationExperiences;
  }

  public List<LanguageAbility> getLanguageAbilities() {
    return languageAbilities;
  }

  public void setLanguageAbilities(List<LanguageAbility> languageAbilities) {
    this.languageAbilities = languageAbilities;
  }

  public List<Certificate> getCertificates() {
    return certificates;
  }

  public void setCertificates(List<Certificate> certificates) {
    this.certificates = certificates;
  }

  public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
  }

  public List<ProjectExperience> getProjectExperiences() {
    return projectExperiences;
  }

  public void setProjectExperiences(List<ProjectExperience> projectExperiences) {
    this.projectExperiences = projectExperiences;
  }
}
