package com.newstar.hbms.customer.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.system.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fellowlong on 2014-09-22.
 */
public class PositionTag implements Serializable {

  private Long id;

  private Long positionId;
  private Position position;

  private Long tagId;
  private TreeNode tag;

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

  public Long getTagId() {
    return tagId;
  }

  public void setTagId(Long tagId) {
    this.tagId = tagId;
  }

  public TreeNode getTag() {
    return tag;
  }

  public void setTag(TreeNode tag) {
    this.tag = tag;
  }
}
