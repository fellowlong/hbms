package com.companyname.hbms.candidate.domain;

import java.io.Serializable;

public class Resume implements Serializable {
  private Long id;
  private Long candidateId;
  private String name;
  private String keyword;
  private String path;
  private Long languageId;
  private Long type;
  private Boolean yn;

  private Candidate candidate;

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

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Long getLanguageId() {
    return languageId;
  }

  public void setLanguageId(Long languageId) {
    this.languageId = languageId;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public Boolean getYn() {
    return yn;
  }

  public void setYn(Boolean yn) {
    this.yn = yn;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  @Override
  public String toString() {
    return "Resume{" +
      "id=" + id +
      ", candidateId=" + candidateId +
      ", name='" + name + '\'' +
      ", keyword='" + keyword + '\'' +
      ", path='" + path + '\'' +
      ", languageId=" + languageId +
      ", type=" + type +
      ", yn=" + yn +
      '}';
  }
}
