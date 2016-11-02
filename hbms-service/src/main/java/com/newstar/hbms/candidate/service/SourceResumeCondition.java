package com.newstar.hbms.candidate.service;

import java.util.Date;

/**
 * Created by wangjinsi on 2016/2/14.
 */
public class SourceResumeCondition {

  private String nameMatchKeyWord;
  private String nameNotMatchKeyWord;

  private String textResumeMatchKeyWord;
  private String textResumeNotMatchKeyWord;

  private Date startCreateTime;
  private Date endCreateTime;

  private String createUser;

  private Date startUpdateTime;
  private Date endUpdateTime;

  private String updateUser;

  public String getNameMatchKeyWord() {
    return nameMatchKeyWord;
  }

  public void setNameMatchKeyWord(String nameMatchKeyWord) {
    this.nameMatchKeyWord = nameMatchKeyWord;
  }

  public String getNameNotMatchKeyWord() {
    return nameNotMatchKeyWord;
  }

  public void setNameNotMatchKeyWord(String nameNotMatchKeyWord) {
    this.nameNotMatchKeyWord = nameNotMatchKeyWord;
  }

  public String getTextResumeMatchKeyWord() {
    return textResumeMatchKeyWord;
  }

  public void setTextResumeMatchKeyWord(String textResumeMatchKeyWord) {
    this.textResumeMatchKeyWord = textResumeMatchKeyWord;
  }

  public String getTextResumeNotMatchKeyWord() {
    return textResumeNotMatchKeyWord;
  }

  public void setTextResumeNotMatchKeyWord(String textResumeNotMatchKeyWord) {
    this.textResumeNotMatchKeyWord = textResumeNotMatchKeyWord;
  }

  public Date getStartCreateTime() {
    return startCreateTime;
  }

  public void setStartCreateTime(Date startCreateTime) {
    this.startCreateTime = startCreateTime;
  }

  public Date getEndCreateTime() {
    return endCreateTime;
  }

  public void setEndCreateTime(Date endCreateTime) {
    this.endCreateTime = endCreateTime;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getStartUpdateTime() {
    return startUpdateTime;
  }

  public void setStartUpdateTime(Date startUpdateTime) {
    this.startUpdateTime = startUpdateTime;
  }

  public Date getEndUpdateTime() {
    return endUpdateTime;
  }

  public void setEndUpdateTime(Date endUpdateTime) {
    this.endUpdateTime = endUpdateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  @Override
  public String toString() {
    return "SourceResumeCondition{" +
        "nameMatchKeyWord='" + nameMatchKeyWord + '\'' +
        ", nameNotMatchKeyWord='" + nameNotMatchKeyWord + '\'' +
        ", textResumeMatchKeyWord='" + textResumeMatchKeyWord + '\'' +
        ", textResumeNotMatchKeyWord='" + textResumeNotMatchKeyWord + '\'' +
        ", startCreateTime=" + startCreateTime +
        ", endCreateTime=" + endCreateTime +
        ", createUser='" + createUser + '\'' +
        ", startUpdateTime=" + startUpdateTime +
        ", endUpdateTime=" + endUpdateTime +
        ", updateUser='" + updateUser + '\'' +
        '}';
  }
}
