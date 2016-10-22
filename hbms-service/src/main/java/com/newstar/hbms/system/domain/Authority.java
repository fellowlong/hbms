package com.newstar.hbms.system.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fellowlong on 2014-10-30.
 */
public class Authority implements Serializable {

  /**
   * 编号
   */
  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * uri
   */
  private String uri;

  /**
   * 编码
   */
  private String code;

  /**
   * 父编号
   */
  private Long parentId;


  /**
   *
   */
  private Boolean yn;


  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private String createUser;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private String updateUser;


  /**
   * 父权限
   */
  private Authority parent;

  /**
   * 子权限
   */
  private List<Authority> children = new ArrayList<Authority>();

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

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
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

  public Authority getParent() {
    return parent;
  }

  public void setParent(Authority parent) {
    this.parent = parent;
  }

  public List<Authority> getChildren() {
    return children;
  }

  public void setChildren(List<Authority> children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return "Authority{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", uri='" + uri + '\'' +
        ", code='" + code + '\'' +
        ", parentId=" + parentId +
        ", yn=" + yn +
        ", createTime=" + createTime +
        ", createUser='" + createUser + '\'' +
        ", updateTime=" + updateTime +
        ", updateUser='" + updateUser + '\'' +
//        ", parent=" + parent +
//        ", children=" + children +
        '}';
  }
}
