package com.companyname.hbms.candidate.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Resume2 implements Serializable {

  /**
   * 简历编号
   */
  private Long id;

  /**
   * 简历名称
   */
  private String name;

  /**
   * 语言
   */
  private Integer languageId;

  /**
   * 原始简历
   */
  private OriginalResume originalResume;

  /**
   * 个人信息
   */
  private PersonalInfo personalInfo;

  /**
   * 个人评价
   */
  private SelfEvaluate selfEvaluate;

  /**
   * 求职意向
   */
  private JobHuntingIntention jobHuntingIntention;

  /**
   * 工作经验
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
  private List<OtherInfo> otherInfos;

  /**
   * 项目经验
   */
  private List<ProjectExperience> projectExperiences;

  /**
   * 专业技能
   */
  private List<ProfessionalSkill> professionalSkills;

  /**
   * 是否有效
   */
  private Boolean yn = true;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 修改时间
   */
  private Date updateTime;

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

  public Integer getLanguageId() {
    return languageId;
  }

  public void setLanguageId(Integer languageId) {
    this.languageId = languageId;
  }

  public OriginalResume getOriginalResume() {
    return originalResume;
  }

  public void setOriginalResume(OriginalResume originalResume) {
    this.originalResume = originalResume;
  }

  public PersonalInfo getPersonalInfo() {
    return personalInfo;
  }

  public void setPersonalInfo(PersonalInfo personalInfo) {
    this.personalInfo = personalInfo;
  }

  public SelfEvaluate getSelfEvaluate() {
    return selfEvaluate;
  }

  public void setSelfEvaluate(SelfEvaluate selfEvaluate) {
    this.selfEvaluate = selfEvaluate;
  }

  public JobHuntingIntention getJobHuntingIntention() {
    return jobHuntingIntention;
  }

  public void setJobHuntingIntention(JobHuntingIntention jobHuntingIntention) {
    this.jobHuntingIntention = jobHuntingIntention;
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

  public List<OtherInfo> getOtherInfos() {
    return otherInfos;
  }

  public void setOtherInfos(List<OtherInfo> otherInfos) {
    this.otherInfos = otherInfos;
  }

  public List<ProjectExperience> getProjectExperiences() {
    return projectExperiences;
  }

  public void setProjectExperiences(List<ProjectExperience> projectExperiences) {
    this.projectExperiences = projectExperiences;
  }

  public List<ProfessionalSkill> getProfessionalSkills() {
    return professionalSkills;
  }

  public void setProfessionalSkills(List<ProfessionalSkill> professionalSkills) {
    this.professionalSkills = professionalSkills;
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

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "Resume{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", languageId=" + languageId +
        ", yn=" + yn +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        '}';
  }
}
