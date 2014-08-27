package com.companyname.hbms.talent.domain;

import java.io.Serializable;

public class Resume implements Serializable {
  private Long id;
  private Long talentId;
  private String name;
  private String keyword;
  private String path;
  private Long languageId;
  private Long type;
  private Boolean yn;

  private Talent talent;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTalentId() {
    return talentId;
  }

  public void setTalentId(Long talentId) {
    this.talentId = talentId;
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

  public Talent getTalent() {
    return talent;
  }

  public void setTalent(Talent talent) {
    this.talent = talent;
  }

  @Override
  public String toString() {
    return "Resume{" +
      "id=" + id +
      ", talentId=" + talentId +
      ", name='" + name + '\'' +
      ", keyword='" + keyword + '\'' +
      ", path='" + path + '\'' +
      ", languageId=" + languageId +
      ", type=" + type +
      ", yn=" + yn +
      '}';
  }
}
