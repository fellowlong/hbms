package com.companyname.hbms.resume.domain;

import com.companyname.hbms.basedata.domain.ListItem;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
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
  private String sex;

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
  private String workYears;

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


  /**
   * 搜索关键字
   */
  private String keyword;

  /**
   * 原始简历名称
   */
  private String originalResumeName;

  /**
   * 原始简历存储路径
   */
  private String originalResumeUri;

  /**
   * 原始简历输入流
   */
  private InputStream originalResumeInputStream;

  /**
   * 原始简历文本
   */
  private String originalResumeText;

  /**
   * 语言
   */
  private String language;

  /**
   *
   */
  private Boolean yn;


  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private String createUser;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private String updateUser;

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

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
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

  public String getWorkYears() {
    return workYears;
  }

  public void setWorkYears(String workYears) {
    this.workYears = workYears;
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

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getOriginalResumeName() {
    return originalResumeName;
  }

  public void setOriginalResumeName(String originalResumeName) {
    this.originalResumeName = originalResumeName;
  }

  public String getOriginalResumeUri() {
    return originalResumeUri;
  }

  public void setOriginalResumeUri(String originalResumeUri) {
    this.originalResumeUri = originalResumeUri;
  }

  public InputStream getOriginalResumeInputStream() {
    return originalResumeInputStream;
  }

  public void setOriginalResumeInputStream(InputStream originalResumeInputStream) {
    this.originalResumeInputStream = originalResumeInputStream;
  }

  public String getOriginalResumeText() {
    return originalResumeText;
  }

  public void setOriginalResumeText(String originalResumeText) {
    this.originalResumeText = originalResumeText;
  }


  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
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
