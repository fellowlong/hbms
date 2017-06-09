package com.newstar.hbms.search.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.project.domain.Project;
import com.newstar.hbms.system.domain.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 14-6-6.
 */
public class TempCandidate implements Serializable {

    private Long id;

    //候选人信息
    private String name;

    private String phone;

    private String email;

    private Long companyId;

    private TreeNode company;

    private String department;

    private Long positionId;
    private TreeNode position;

    private String production;

    private Long cityId;
    private TreeNode city;

    private Long jobHuntingStatusId;
    private TreeNode jobHuntingStatus;

    //项目信息
    private Long projectCompanyId;
    private Company projectCompany;

    //项目信息
    private Long projectId;
    private Project project;

    //创建信息
    private Long addUserId;
    private User addUser;

    private Date addTime;

    //寻访信息
    private Long searchUserId;
    private User searchUser;

    private Date searchTime;

    private Long searchStatusId;
    private TreeNode searchStatus;

    //
    private String searchRemark;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
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

    public Long getProjectCompanyId() {
        return projectCompanyId;
    }

    public void setProjectCompanyId(Long projectCompanyId) {
        this.projectCompanyId = projectCompanyId;
    }

    public Company getProjectCompany() {
        return projectCompany;
    }

    public void setProjectCompany(Company projectCompany) {
        this.projectCompany = projectCompany;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Long addUserId) {
        this.addUserId = addUserId;
    }

    public User getAddUser() {
        return addUser;
    }

    public void setAddUser(User addUser) {
        this.addUser = addUser;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getSearchUserId() {
        return searchUserId;
    }

    public void setSearchUserId(Long searchUserId) {
        this.searchUserId = searchUserId;
    }

    public User getSearchUser() {
        return searchUser;
    }

    public void setSearchUser(User searchUser) {
        this.searchUser = searchUser;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    public Long getSearchStatusId() {
        return searchStatusId;
    }

    public void setSearchStatusId(Long searchStatusId) {
        this.searchStatusId = searchStatusId;
    }

    public TreeNode getSearchStatus() {
        return searchStatus;
    }

    public void setSearchStatus(TreeNode searchStatus) {
        this.searchStatus = searchStatus;
    }

    public String getSearchRemark() {
        return searchRemark;
    }

    public void setSearchRemark(String searchRemark) {
        this.searchRemark = searchRemark;
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

    @Override
    public String toString() {
        return "TempCandidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", companyId=" + companyId +
                ", company=" + company +
                ", department='" + department + '\'' +
                ", positionId=" + positionId +
                ", position=" + position +
                ", production='" + production + '\'' +
                ", cityId=" + cityId +
                ", city=" + city +
                ", jobHuntingStatusId=" + jobHuntingStatusId +
                ", jobHuntingStatus=" + jobHuntingStatus +
                ", projectCompanyId=" + projectCompanyId +
                ", projectCompany=" + projectCompany +
                ", projectId=" + projectId +
                ", project=" + project +
                ", addUserId=" + addUserId +
                ", addUser=" + addUser +
                ", addTime=" + addTime +
                ", searchUserId=" + searchUserId +
                ", searchUser=" + searchUser +
                ", searchTime=" + searchTime +
                ", searchStatusId=" + searchStatusId +
                ", searchStatus=" + searchStatus +
                ", searchRemark='" + searchRemark + '\'' +
                ", yn=" + yn +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", updateTime=" + updateTime +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
