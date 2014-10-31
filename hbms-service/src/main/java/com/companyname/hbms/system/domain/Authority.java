package com.companyname.hbms.system.domain;

import java.io.Serializable;

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
}
