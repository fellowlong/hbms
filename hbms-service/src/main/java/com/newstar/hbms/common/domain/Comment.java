package com.newstar.hbms.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangjinsi on 2016/11/2.
 */
public class Comment implements Serializable {

    private Long id;
    private String businessBigType;
    private String businessSmallType;
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

    public String getBusinessBigType() {
        return businessBigType;
    }

    public void setBusinessBigType(String businessBigType) {
        this.businessBigType = businessBigType;
    }

    public String getBusinessSmallType() {
        return businessSmallType;
    }

    public void setBusinessSmallType(String businessSmallType) {
        this.businessSmallType = businessSmallType;
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
}
