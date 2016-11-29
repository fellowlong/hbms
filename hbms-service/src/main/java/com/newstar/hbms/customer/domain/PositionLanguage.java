package com.newstar.hbms.customer.domain;

import com.newstar.hbms.basedata.domain.TreeNode;

import java.io.Serializable;

/**
 * Created by fellowlong on 2014-09-22.
 */
public class PositionLanguage implements Serializable {

  private Long id;

  private Long positionId;
  private Position position;

  private Long languageId;
  private TreeNode language;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPositionId() {
    return positionId;
  }

  public void setPositionId(Long positionId) {
    this.positionId = positionId;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
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
}
