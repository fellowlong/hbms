package com.companyname.hbms.resume.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangjinsi on 2016/2/9.
 */
public class SourceResume implements Serializable {

  private Long id;

  /**
   * 简历名称（文件名）
   */
  private String name;

  /**
   * 二进制简历
   */
  private byte[] binaryResume;


  /**
   * 原始简历文本
   */
  private String textResume;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public byte[] getBinaryResume() {
    return binaryResume;
  }

  public void setBinaryResume(byte[] binaryResume) {
    this.binaryResume = binaryResume;
  }

  public String getTextResume() {
    return textResume;
  }

  public void setTextResume(String textResume) {
    this.textResume = textResume;
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
    return "SourceResume{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", textResume='" + textResume + '\'' +
        ", yn=" + yn +
        ", createTime=" + createTime +
        ", createUser='" + createUser + '\'' +
        ", updateTime=" + updateTime +
        ", updateUser='" + updateUser + '\'' +
        '}';
  }
}
