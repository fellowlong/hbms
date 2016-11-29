package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import org.apache.poi.hmef.Attachment;
import org.apache.poi.hslf.model.Comment;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Candidate implements Serializable {

  /**
   * 主键，编号
   */
  private Long id;

  /**
   * 原始简历文件，用来临时存储
   */
  private MultipartFile resumeFile;

  /**
   * 原始简历
   */
  private Resume resume;

  private MultipartFile[] otherAttachmentFiles;

  private Attachment[] otherAttachments;

  /**
   * 人才编号
   */
  private String code;

  /**
   * 姓名
   */
  private String name;

  /**
   * 性别
   */
  private Long sexId;

  /**
   * 出生日期
   */
  private Date birthday;

  /**
   * 手机号码
   */
  private String mobile;

  /**
   * 座机
   */
  private String telephone;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 其他联系方式
   */
  private String otherContact;

  /**
   * 学历
   */
  private Long degreeId;

  /**
   * 婚姻状况
   */
  private Long maritalId;

  /**
   * 所在地
   */
  private Long locationId;

  /**
   * 工作年限
   */
  private Integer workYears;

  /**
   * 工作年限
   */
  private Boolean overseasExperience;

  /**
   * 所在行业
   */
  private Long industryId;

  /**
   * 公司
   */
  private Long currentCompanyId;

  /**
   * 职位
   */
  private Long currentPositionId;

  /**
   * 年薪
   */
  private Double currentAnnualSalary;

  /**
   * 求职状态
   */
  private Long jobHuntingStatusId;

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
   * 项目经验
   */
  private List<ProjectExperience> projectExperiences;

  /**
   * 技能
   */
  private String skills;

  /**
   * 其他信息
   */
  private String other;

  /**
   * 搜索关键字
   */
  private String keyword;

  /**
   * 备注
   */
  private String remark;

  /**
   * 优势和劣势
   */
  private String strengthsAndWeaknesses;

  /**
   * 批注
   */
  private List<Comment> comments = new ArrayList<Comment>();

  /**
   * 收藏夹
    */
  private Long favoriteId;
  private TreeNode favorite;

  /**
   * 所属文件夹
   */
  private Long folderId;
  private TreeNode folder;

  /**
   * 来源
   */
  private Long sourceId;
  private TreeNode source;

  /**
   * 上传者
   */
  private Long updaterId;
  private TreeNode updater;

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

  public MultipartFile getResumeFile() {
    return resumeFile;
  }

  public void setResumeFile(MultipartFile resumeFile) {
    this.resumeFile = resumeFile;
  }

  public Resume getResume() {
    return resume;
  }

  public void setResume(Resume resume) {
    this.resume = resume;
  }

  public MultipartFile[] getOtherAttachmentFiles() {
    return otherAttachmentFiles;
  }

  public void setOtherAttachmentFiles(MultipartFile[] otherAttachmentFiles) {
    this.otherAttachmentFiles = otherAttachmentFiles;
  }

  public Attachment[] getOtherAttachments() {
    return otherAttachments;
  }

  public void setOtherAttachments(Attachment[] otherAttachments) {
    this.otherAttachments = otherAttachments;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getSexId() {
    return sexId;
  }

  public void setSexId(Long sexId) {
    this.sexId = sexId;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOtherContact() {
    return otherContact;
  }

  public void setOtherContact(String otherContact) {
    this.otherContact = otherContact;
  }

  public Long getDegreeId() {
    return degreeId;
  }

  public void setDegreeId(Long degreeId) {
    this.degreeId = degreeId;
  }

  public Long getMaritalId() {
    return maritalId;
  }

  public void setMaritalId(Long maritalId) {
    this.maritalId = maritalId;
  }

  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public Integer getWorkYears() {
    return workYears;
  }

  public void setWorkYears(Integer workYears) {
    this.workYears = workYears;
  }

  public Boolean getOverseasExperience() {
    return overseasExperience;
  }

  public void setOverseasExperience(Boolean overseasExperience) {
    this.overseasExperience = overseasExperience;
  }

  public Long getIndustryId() {
    return industryId;
  }

  public void setIndustryId(Long industryId) {
    this.industryId = industryId;
  }

  public Long getCurrentCompanyId() {
    return currentCompanyId;
  }

  public void setCurrentCompanyId(Long currentCompanyId) {
    this.currentCompanyId = currentCompanyId;
  }

  public Long getCurrentPositionId() {
    return currentPositionId;
  }

  public void setCurrentPositionId(Long currentPositionId) {
    this.currentPositionId = currentPositionId;
  }

  public Double getCurrentAnnualSalary() {
    return currentAnnualSalary;
  }

  public void setCurrentAnnualSalary(Double currentAnnualSalary) {
    this.currentAnnualSalary = currentAnnualSalary;
  }

  public Long getJobHuntingStatusId() {
    return jobHuntingStatusId;
  }

  public void setJobHuntingStatusId(Long jobHuntingStatusId) {
    this.jobHuntingStatusId = jobHuntingStatusId;
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

  public List<ProjectExperience> getProjectExperiences() {
    return projectExperiences;
  }

  public void setProjectExperiences(List<ProjectExperience> projectExperiences) {
    this.projectExperiences = projectExperiences;
  }

  public String getSkills() {
    return skills;
  }

  public void setSkills(String skills) {
    this.skills = skills;
  }

  public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getStrengthsAndWeaknesses() {
    return strengthsAndWeaknesses;
  }

  public void setStrengthsAndWeaknesses(String strengthsAndWeaknesses) {
    this.strengthsAndWeaknesses = strengthsAndWeaknesses;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public Long getFavoriteId() {
    return favoriteId;
  }

  public void setFavoriteId(Long favoriteId) {
    this.favoriteId = favoriteId;
  }

  public TreeNode getFavorite() {
    return favorite;
  }

  public void setFavorite(TreeNode favorite) {
    this.favorite = favorite;
  }

  public Long getFolderId() {
    return folderId;
  }

  public void setFolderId(Long folderId) {
    this.folderId = folderId;
  }

  public TreeNode getFolder() {
    return folder;
  }

  public void setFolder(TreeNode folder) {
    this.folder = folder;
  }

  public Long getSourceId() {
    return sourceId;
  }

  public void setSourceId(Long sourceId) {
    this.sourceId = sourceId;
  }

  public TreeNode getSource() {
    return source;
  }

  public void setSource(TreeNode source) {
    this.source = source;
  }

  public Long getUpdaterId() {
    return updaterId;
  }

  public void setUpdaterId(Long updaterId) {
    this.updaterId = updaterId;
  }

  public TreeNode getUpdater() {
    return updater;
  }

  public void setUpdater(TreeNode updater) {
    this.updater = updater;
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
