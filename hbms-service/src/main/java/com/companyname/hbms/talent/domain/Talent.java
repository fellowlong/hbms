package com.companyname.hbms.talent.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 2014-08-25.
 */
public class Talent implements Serializable {

  private Long id;
  private String name;
  private String keyword;
  private Boolean yn;
  private Date createTime;
  private String createUser;
  private Date updateTime;
  private String updateUser;

  private Resume lastOriginalResume;
  private Resume lastReportResume;

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

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
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

  public Resume getLastOriginalResume() {
    return lastOriginalResume;
  }

  public void setLastOriginalResume(Resume lastOriginalResume) {
    this.lastOriginalResume = lastOriginalResume;
  }

  public Resume getLastReportResume() {
    return lastReportResume;
  }

  public void setLastReportResume(Resume lastReportResume) {
    this.lastReportResume = lastReportResume;
  }

  @Override
  public String toString() {
    return "Talent{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", keyword='" + keyword + '\'' +
      ", yn=" + yn +
      ", createTime=" + createTime +
      ", createUser='" + createUser + '\'' +
      ", updateTime=" + updateTime +
      ", updateUser='" + updateUser + '\'' +
      '}';
  }
}
