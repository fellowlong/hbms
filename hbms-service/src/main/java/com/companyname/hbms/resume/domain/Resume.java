package com.companyname.hbms.resume.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Resume implements Serializable {

  /**
   * 简历编号
   */
  private Long resumeId;

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

  public Boolean getYn() {
    return yn;
  }

  public void setYn(Boolean yn) {
    this.yn = yn;
  }

  public Long getResumeId() {
    return resumeId;
  }

  public void setResumeId(Long resumeId) {
    this.resumeId = resumeId;
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
}
