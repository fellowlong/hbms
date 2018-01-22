package com.newstar.hbms.common.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by fellowlong on 2016/11/2.
 */
public class Attachment implements Serializable {

    public static final String BUSINESS_TYPE_RESUME = "resume";
    public static final String BUSINESS_TYPE_CANDIDATE = "candidate";
    public static final String BUSINESS_TYPE_COMPANY = "company";

    private Long id;
    private String businessType;
    private Long businessId;
    private String fileName;
    private String fileType;
    private byte[] fileBinaryData;

    private String remark;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileBinaryData() {
        return fileBinaryData;
    }

    public void setFileBinaryData(byte[] fileBinaryData) {
        this.fileBinaryData = fileBinaryData;
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

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", businessType='" + businessType + '\'' +
                ", businessId=" + businessId +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", yn=" + yn +
                '}';
    }
}
