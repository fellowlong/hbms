package com.newstar.hbms.customer.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.system.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fellowlong on 2014-09-22.
 */
public class Position implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 所属公司
   */
  private Long companyId;
  private Company company;

  /**
   * 对应客户联系人
   */
  private Long contactId;
  private Contact contact;

  /**
   * 职位编号
   */
  private String code;

  /**
   * 名称
   */
  private String name;

  /**
   * 优先级
   */
  private Long priorityId;
  private TreeNode priority;

  /**
   * 行业
   */
  private Long industryId;
  private TreeNode industry;

  /**
   * 职能
   */
  private Long functionId;
  private TreeNode function;

  /**
   * 城市
   */
  private Long cityId;
  private TreeNode city;

  /**
   * 名企背景
   */
  private Long fameCompanyBackgroundId;
  private TreeNode fameCompanyBackground;

  /**
   * 国籍
   */
  private Long nationalityId;
  private TreeNode nationality;

  /**
   * 学历
   */
  private Long degreeId;
  private TreeNode degree;

  /**
   * 语言要求
   */
  private List<PositionLanguage> languages;

  /**
   * 年龄要求
   */
  private Integer minAge;
  private Integer maxAge;

  /**
   * 工作年限要求：
   */
  private Integer minWorkYears;
  private Integer maxWorkYears;

  /**
   * 年薪范围
   */
  private Double minAnnualSalary;
  private Double maxAnnualSalary;

  /**
   * 性别要求
   */
  private Long sexId;
  private TreeNode sex;

  /**
   * 招聘地址
   */
  private String address;

  /**
   * 标签
   */
  private List<PositionTag> tags = new ArrayList<PositionTag>();

  /**
   * 说明
   */
  private String description;

  /**
   * 职位亮点及优势
   */
  private String brightAndAdvantage;

  /**
   * 流程及领导介绍
   */
  private String processAndLeaderIntro;

  /**
   * 薪资结构
   */
  private String salaryStructure;

  /**
   * 寻访方向
   */
  private String searchDirection;

  /**
   * BD
   */
  private Long businessDeveloperId;
  private User businessDeveloper;

  /**
   * 备注
   */
  private String remark;

  /**
   * 是否有效
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

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public Long getContactId() {
    return contactId;
  }

  public void setContactId(Long contactId) {
    this.contactId = contactId;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
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

  public Long getPriorityId() {
    return priorityId;
  }

  public void setPriorityId(Long priorityId) {
    this.priorityId = priorityId;
  }

  public TreeNode getPriority() {
    return priority;
  }

  public void setPriority(TreeNode priority) {
    this.priority = priority;
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

  public Long getFunctionId() {
    return functionId;
  }

  public void setFunctionId(Long functionId) {
    this.functionId = functionId;
  }

  public TreeNode getFunction() {
    return function;
  }

  public void setFunction(TreeNode function) {
    this.function = function;
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

  public Long getFameCompanyBackgroundId() {
    return fameCompanyBackgroundId;
  }

  public void setFameCompanyBackgroundId(Long fameCompanyBackgroundId) {
    this.fameCompanyBackgroundId = fameCompanyBackgroundId;
  }

  public TreeNode getFameCompanyBackground() {
    return fameCompanyBackground;
  }

  public void setFameCompanyBackground(TreeNode fameCompanyBackground) {
    this.fameCompanyBackground = fameCompanyBackground;
  }

  public Long getNationalityId() {
    return nationalityId;
  }

  public void setNationalityId(Long nationalityId) {
    this.nationalityId = nationalityId;
  }

  public TreeNode getNationality() {
    return nationality;
  }

  public void setNationality(TreeNode nationality) {
    this.nationality = nationality;
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

  public List<PositionLanguage> getLanguages() {
    return languages;
  }

  public void setLanguages(List<PositionLanguage> languages) {
    this.languages = languages;
  }

  public Integer getMinAge() {
    return minAge;
  }

  public void setMinAge(Integer minAge) {
    this.minAge = minAge;
  }

  public Integer getMaxAge() {
    return maxAge;
  }

  public void setMaxAge(Integer maxAge) {
    this.maxAge = maxAge;
  }

  public Integer getMinWorkYears() {
    return minWorkYears;
  }

  public void setMinWorkYears(Integer minWorkYears) {
    this.minWorkYears = minWorkYears;
  }

  public Integer getMaxWorkYears() {
    return maxWorkYears;
  }

  public void setMaxWorkYears(Integer maxWorkYears) {
    this.maxWorkYears = maxWorkYears;
  }

  public Double getMinAnnualSalary() {
    return minAnnualSalary;
  }

  public void setMinAnnualSalary(Double minAnnualSalary) {
    this.minAnnualSalary = minAnnualSalary;
  }

  public Double getMaxAnnualSalary() {
    return maxAnnualSalary;
  }

  public void setMaxAnnualSalary(Double maxAnnualSalary) {
    this.maxAnnualSalary = maxAnnualSalary;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<PositionTag> getTags() {
    return tags;
  }

  public void setTags(List<PositionTag> tags) {
    this.tags = tags;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getBrightAndAdvantage() {
    return brightAndAdvantage;
  }

  public void setBrightAndAdvantage(String brightAndAdvantage) {
    this.brightAndAdvantage = brightAndAdvantage;
  }

  public String getProcessAndLeaderIntro() {
    return processAndLeaderIntro;
  }

  public void setProcessAndLeaderIntro(String processAndLeaderIntro) {
    this.processAndLeaderIntro = processAndLeaderIntro;
  }

  public String getSalaryStructure() {
    return salaryStructure;
  }

  public void setSalaryStructure(String salaryStructure) {
    this.salaryStructure = salaryStructure;
  }

  public String getSearchDirection() {
    return searchDirection;
  }

  public void setSearchDirection(String searchDirection) {
    this.searchDirection = searchDirection;
  }

  public Long getBusinessDeveloperId() {
    return businessDeveloperId;
  }

  public void setBusinessDeveloperId(Long businessDeveloperId) {
    this.businessDeveloperId = businessDeveloperId;
  }

  public User getBusinessDeveloper() {
    return businessDeveloper;
  }

  public void setBusinessDeveloper(User businessDeveloper) {
    this.businessDeveloper = businessDeveloper;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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
