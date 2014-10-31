package com.companyname.hbms.system.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fellowlong on 2014-10-30.
 */
public class Model implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * 该模块下的所有权限
   */
  private List<Authority> authorities = new ArrayList<Authority>();

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

  public List<Authority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<Authority> authorities) {
    this.authorities = authorities;
  }
}
