package com.companyname.hbms.resume.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Resume_bak implements Serializable {

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
   * 出生日期
   */
  private Date birthday;

  /**
   * 户籍
   */
  private String householdRegister;

  /**
   * 身份证号码
   */
  private String idNumber;

  /**
   * 婚姻状况
   */
  private String maritalStatus;

  /**
   * 最高学历
   */
  private String highestDegree;

  /**
   * 专业
   */
  private String major;

  /**
   * 政治面貌
   */
  private String politicalStatus;

  /**
   * 从事行业
   */
  private String workIndustry;

  /**
   * 应聘岗位
   */
  private String applicantJob;

  /**
   * 居住地
   */
  private String residence;

  /**
   * 联系地址
   */
  private String address;

  /**
   * 职务
   */
  private String duty;

  /**
   * 工作经历
   */
  private List<WorkExperience> workExperiences;

  /**
   * 项目经历
   */
  private List<ProjectExperience> projectExperiences;

  /**
   * 教育经历
   */
  private List<EducationExperience> educationExperiences;

  /**
   * 培训经历
   */
  private List<TrainExperience> trainExperiences;

  /**
   * 证书
   */
  private String certificate;

  /**
   * 语言能力
   */
  private String languageAbility;

  /**
   * 身高
   */
  private byte height;

  /**
   * 国家
   */
  private String country;

  /**
   * 民族
   */
  private String nation;

  /**
   * 健康状况
   */
  private String healthStatus;

  /**
   * 年薪
   */
  private double annualSalary;

  /**
   * 毕业学校
   */
  private String graduateSchool;

  /**
   * 自我评价
   */
  private String selfEvaluate;

  /**
   * 家庭电话
   */
  private String homePhone;

  /**
   * 公司电话
   */
  private String companyPhone;

  /**
   * 传真
   */
  private String fax;

  /**
   * 手机
   */
  private String mobilePhone;

  /**
   * QQ号码
   */
  private String qq;

  /**
   * 电子邮箱
   */
  private String email;

  /**
   * 邮编
   */
  private String postcode;

  /**
   * 个人主页
   */
  private String selfHomepage;

  /**
   * 工作性质
   */
  private String jobCategory;

  /**
   * 目标地点
   */
  private String targetLocation;


  /**
   * 目标职能
   */
  private String targetFunction;


  /**
   * 最高学历值
   */
  private String highestDegreeValue;

  /**
   * IT技能
   */
  private List<ProfessionalSkill> professionalSkills;

  /**
   * 兴趣爱好
   */
  private String interest;

  /**
   * 奖励
   */
  private String award;

  /**
   * 荣誉
   */
  private String honor;

  /**
   * 技能特长
   */
  private String skillAndSpeciality;

  /**
   * 其他信息
   */
  private String other;

  /**
   * 工作年限
   */
  private String workYears;

  /**
   * 证书类型
   */
  private String certificateType;


  /**
   * 专业组织
   */
  private String specialtyOrganization;


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

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getHouseholdRegister() {
    return householdRegister;
  }

  public void setHouseholdRegister(String householdRegister) {
    this.householdRegister = householdRegister;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getHighestDegree() {
    return highestDegree;
  }

  public void setHighestDegree(String highestDegree) {
    this.highestDegree = highestDegree;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getPoliticalStatus() {
    return politicalStatus;
  }

  public void setPoliticalStatus(String politicalStatus) {
    this.politicalStatus = politicalStatus;
  }

  public String getWorkIndustry() {
    return workIndustry;
  }

  public void setWorkIndustry(String workIndustry) {
    this.workIndustry = workIndustry;
  }

  public String getApplicantJob() {
    return applicantJob;
  }

  public void setApplicantJob(String applicantJob) {
    this.applicantJob = applicantJob;
  }

  public String getResidence() {
    return residence;
  }

  public void setResidence(String residence) {
    this.residence = residence;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDuty() {
    return duty;
  }

  public void setDuty(String duty) {
    this.duty = duty;
  }

  public List<WorkExperience> getWorkExperiences() {
    return workExperiences;
  }

  public void setWorkExperiences(List<WorkExperience> workExperiences) {
    this.workExperiences = workExperiences;
  }

  public List<ProjectExperience> getProjectExperiences() {
    return projectExperiences;
  }

  public void setProjectExperiences(List<ProjectExperience> projectExperiences) {
    this.projectExperiences = projectExperiences;
  }

  public List<EducationExperience> getEducationExperiences() {
    return educationExperiences;
  }

  public void setEducationExperiences(List<EducationExperience> educationExperiences) {
    this.educationExperiences = educationExperiences;
  }

  public List<TrainExperience> getTrainExperiences() {
    return trainExperiences;
  }

  public void setTrainExperiences(List<TrainExperience> trainExperiences) {
    this.trainExperiences = trainExperiences;
  }

  public String getCertificate() {
    return certificate;
  }

  public void setCertificate(String certificate) {
    this.certificate = certificate;
  }

  public String getLanguageAbility() {
    return languageAbility;
  }

  public void setLanguageAbility(String languageAbility) {
    this.languageAbility = languageAbility;
  }

  public byte getHeight() {
    return height;
  }

  public void setHeight(byte height) {
    this.height = height;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public String getHealthStatus() {
    return healthStatus;
  }

  public void setHealthStatus(String healthStatus) {
    this.healthStatus = healthStatus;
  }

  public double getAnnualSalary() {
    return annualSalary;
  }

  public void setAnnualSalary(double annualSalary) {
    this.annualSalary = annualSalary;
  }

  public String getGraduateSchool() {
    return graduateSchool;
  }

  public void setGraduateSchool(String graduateSchool) {
    this.graduateSchool = graduateSchool;
  }

  public String getSelfEvaluate() {
    return selfEvaluate;
  }

  public void setSelfEvaluate(String selfEvaluate) {
    this.selfEvaluate = selfEvaluate;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public String getCompanyPhone() {
    return companyPhone;
  }

  public void setCompanyPhone(String companyPhone) {
    this.companyPhone = companyPhone;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getSelfHomepage() {
    return selfHomepage;
  }

  public void setSelfHomepage(String selfHomepage) {
    this.selfHomepage = selfHomepage;
  }

  public String getJobCategory() {
    return jobCategory;
  }

  public void setJobCategory(String jobCategory) {
    this.jobCategory = jobCategory;
  }

  public String getTargetLocation() {
    return targetLocation;
  }

  public void setTargetLocation(String targetLocation) {
    this.targetLocation = targetLocation;
  }

  public String getTargetFunction() {
    return targetFunction;
  }

  public void setTargetFunction(String targetFunction) {
    this.targetFunction = targetFunction;
  }

  public String getHighestDegreeValue() {
    return highestDegreeValue;
  }

  public void setHighestDegreeValue(String highestDegreeValue) {
    this.highestDegreeValue = highestDegreeValue;
  }

  public List<ProfessionalSkill> getProfessionalSkills() {
    return professionalSkills;
  }

  public void setProfessionalSkills(List<ProfessionalSkill> professionalSkills) {
    this.professionalSkills = professionalSkills;
  }

  public String getInterest() {
    return interest;
  }

  public void setInterest(String interest) {
    this.interest = interest;
  }

  public String getAward() {
    return award;
  }

  public void setAward(String award) {
    this.award = award;
  }

  public String getHonor() {
    return honor;
  }

  public void setHonor(String honor) {
    this.honor = honor;
  }

  public String getSkillAndSpeciality() {
    return skillAndSpeciality;
  }

  public void setSkillAndSpeciality(String skillAndSpeciality) {
    this.skillAndSpeciality = skillAndSpeciality;
  }

  public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
  }

  public String getWorkYears() {
    return workYears;
  }

  public void setWorkYears(String workYears) {
    this.workYears = workYears;
  }

  public String getCertificateType() {
    return certificateType;
  }

  public void setCertificateType(String certificateType) {
    this.certificateType = certificateType;
  }

  public String getSpecialtyOrganization() {
    return specialtyOrganization;
  }

  public void setSpecialtyOrganization(String specialtyOrganization) {
    this.specialtyOrganization = specialtyOrganization;
  }
}
