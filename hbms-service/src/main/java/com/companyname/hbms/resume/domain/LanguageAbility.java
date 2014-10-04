package com.companyname.hbms.resume.domain;

import java.io.Serializable;

/**
 * Created by fellowlong on 2014-05-27.
 */
public class LanguageAbility implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 简历编号
   */
  private Long resumeId;

  /**
   * 简历
   */
  private Resume resume;

  /**
   * 语言名称
   */
  private String name;

  /**
   * 读写能力
   */
  private String readAndWrite;

  /**
   * 听说能力
   */
  private String listenAndSpeaking;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getResumeId() {
    return resumeId;
  }

  public void setResumeId(Long resumeId) {
    this.resumeId = resumeId;
  }

  public Resume getResume() {
    return resume;
  }

  public void setResume(Resume resume) {
    this.resume = resume;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReadAndWrite() {
    return readAndWrite;
  }

  public void setReadAndWrite(String readAndWrite) {
    this.readAndWrite = readAndWrite;
  }

  public String getListenAndSpeaking() {
    return listenAndSpeaking;
  }

  public void setListenAndSpeaking(String listenAndSpeaking) {
    this.listenAndSpeaking = listenAndSpeaking;
  }
}
