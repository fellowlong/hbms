package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.common.domain.Domain;

/**
 * Created by fellowlong on 2014-05-27.
 */
public class LanguageAbility extends Domain {

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
  private Candidate candidate;

  /**
   * 语言名称
   */
  private Long languageId;

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

  public Candidate getCandidate() {
    return candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  public Long getLanguageId() {
    return languageId;
  }

  public void setLanguageId(Long languageId) {
    this.languageId = languageId;
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
