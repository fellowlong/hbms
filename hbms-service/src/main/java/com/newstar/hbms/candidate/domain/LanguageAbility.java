package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
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
   * 人才，外键
   */
  private Long candidateId;
  private Candidate candidate;

  /**
   * 语言，外键
   */
  private Long languageId;
  private TreeNode language;

  /**
   * 读写能力，外键
   */
  private Long readAndWriteId;
  private TreeNode readAndWrite;

  /**
   * 听说能力，外键
   */
  private Long listenAndSpeakingId;
  private TreeNode listenAndSpeaking;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(Long candidateId) {
    this.candidateId = candidateId;
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

  public TreeNode getLanguage() {
    return language;
  }

  public void setLanguage(TreeNode language) {
    this.language = language;
  }

  public Long getReadAndWriteId() {
    return readAndWriteId;
  }

  public void setReadAndWriteId(Long readAndWriteId) {
    this.readAndWriteId = readAndWriteId;
  }

  public TreeNode getReadAndWrite() {
    return readAndWrite;
  }

  public void setReadAndWrite(TreeNode readAndWrite) {
    this.readAndWrite = readAndWrite;
  }

  public Long getListenAndSpeakingId() {
    return listenAndSpeakingId;
  }

  public void setListenAndSpeakingId(Long listenAndSpeakingId) {
    this.listenAndSpeakingId = listenAndSpeakingId;
  }

  public TreeNode getListenAndSpeaking() {
    return listenAndSpeaking;
  }

  public void setListenAndSpeaking(TreeNode listenAndSpeaking) {
    this.listenAndSpeaking = listenAndSpeaking;
  }
}
