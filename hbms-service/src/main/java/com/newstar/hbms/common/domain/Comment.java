package com.newstar.hbms.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangjinsi on 2016/11/2.
 */
public class Comment implements Serializable {

    public static final String BUSINESS_TYPE_CANDIDATE = "candidate";
    public static final String BUSINESS_TYPE_COMPANY = "company";
    public static final String BUSINESS_TYPE_POSITION = "position";
    public static final String BUSINESS_TYPE_PROJECT = "project";

    private Long id;
    private String businessType;
    private Long businessId;
    private String content;

    private Boolean yn;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Comment{" +
                "id=" + id +
                ", businessType='" + businessType + '\'' +
                ", businessId=" + businessId +
                ", content='" + content + '\'' +
                ", yn=" + yn +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", updateTime=" + updateTime +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
