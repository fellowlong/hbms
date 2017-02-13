package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.common.domain.Attachment;
import com.newstar.hbms.common.domain.Comment;
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

  private Long deletedResumeFileId;

  private MultipartFile[] otherAttachmentFiles;

  private List<Attachment> otherAttachments;

  private Long[] deletedOtherAttachmentIds;

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
  private TreeNode sex;

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
  private TreeNode degree;

  /**
   * 婚姻状况
   */
  private Long maritalId;
  private TreeNode marital;

  /**
   * 所在地
   */
  private Long cityId;
  private TreeNode city;

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
  private TreeNode industry;

  /**
   * 公司
   */
  private Long companyId;
  private TreeNode company;

  /**
   * 职位
   */
  private Long positionId;
  private TreeNode position;

  /**
   * 年薪
   */
  private Double currentAnnualSalary;

  /**
   * 求职状态
   */
  private Long jobHuntingStatusId;
  private TreeNode jobHuntingStatus;


  /**
   * 优势和劣势
   */
  private String strengthsAndWeaknesses;

  /**
   * 备注
   */
  private String remark;

  /**
   * 搜索关键字
   */
  private String keyword;

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
  private Long uploaderId;
  private TreeNode uploader;

  /**
   * 批注
   */
  private List<Comment> comments = new ArrayList<Comment>();

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

  public Long getDeletedResumeFileId() {
    return deletedResumeFileId;
  }

  public void setDeletedResumeFileId(Long deletedResumeFileId) {
    this.deletedResumeFileId = deletedResumeFileId;
  }

  public MultipartFile[] getOtherAttachmentFiles() {
    return otherAttachmentFiles;
  }

  public void setOtherAttachmentFiles(MultipartFile[] otherAttachmentFiles) {
    this.otherAttachmentFiles = otherAttachmentFiles;
  }

  public List<Attachment> getOtherAttachments() {
    return otherAttachments;
  }

  public void setOtherAttachments(List<Attachment> otherAttachments) {
    this.otherAttachments = otherAttachments;
  }

  public Long[] getDeletedOtherAttachmentIds() {
    return deletedOtherAttachmentIds;
  }

  public void setDeletedOtherAttachmentIds(Long[] deletedOtherAttachmentIds) {
    this.deletedOtherAttachmentIds = deletedOtherAttachmentIds;
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

  public TreeNode getSex() {
    return sex;
  }

  public void setSex(TreeNode sex) {
    this.sex = sex;
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

  public TreeNode getDegree() {
    return degree;
  }

  public void setDegree(TreeNode degree) {
    this.degree = degree;
  }

  public Long getMaritalId() {
    return maritalId;
  }

  public void setMaritalId(Long maritalId) {
    this.maritalId = maritalId;
  }

  public TreeNode getMarital() {
    return marital;
  }

  public void setMarital(TreeNode marital) {
    this.marital = marital;
  }

  public Long getCityId() {
    return cityId;
  }

  public void setCityId(Long cityId) {
    this.cityId = cityId;
  }

  public TreeNode getCity() {
    return city;
  }

  public void setCity(TreeNode city) {
    this.city = city;
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

  public TreeNode getIndustry() {
    return industry;
  }

  public void setIndustry(TreeNode industry) {
    this.industry = industry;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public TreeNode getCompany() {
    return company;
  }

  public void setCompany(TreeNode company) {
    this.company = company;
  }

  public Long getPositionId() {
    return positionId;
  }

  public void setPositionId(Long positionId) {
    this.positionId = positionId;
  }

  public TreeNode getPosition() {
    return position;
  }

  public void setPosition(TreeNode position) {
    this.position = position;
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

  public TreeNode getJobHuntingStatus() {
    return jobHuntingStatus;
  }

  public void setJobHuntingStatus(TreeNode jobHuntingStatus) {
    this.jobHuntingStatus = jobHuntingStatus;
  }

  public String getStrengthsAndWeaknesses() {
    return strengthsAndWeaknesses;
  }

  public void setStrengthsAndWeaknesses(String strengthsAndWeaknesses) {
    this.strengthsAndWeaknesses = strengthsAndWeaknesses;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
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

  public Long getUploaderId() {
    return uploaderId;
  }

  public void setUploaderId(Long uploaderId) {
    this.uploaderId = uploaderId;
  }

  public TreeNode getUploader() {
    return uploader;
  }

  public void setUploader(TreeNode uploader) {
    this.uploader = uploader;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
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
