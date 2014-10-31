package com.companyname.hbms.system.domain;

import java.io.Serializable;

/**
 * Created by fellowlong on 2014-10-30.
 */
public class Role implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * 编码
   */
  private String code;

  /**
   * 模块编号
   */
  private Long modelId;

  /**
   * 模块
   */
  private Model model;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Long getModelId() {
    return modelId;
  }

  public void setModelId(Long modelId) {
    this.modelId = modelId;
  }

  public Model getModel() {
    return model;
  }

  public void setModel(Model model) {
    this.model = model;
  }
}
