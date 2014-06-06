package com.companyname.hbms.project.domain;

import java.io.Serializable;

/**
 * Created by fellowlong on 14-6-6.
 */
public class Position implements Serializable {

  /**
   * 主键
   */
  private Long id;

  /**
   * 项目编号
   */
  private Long projectId;

  /**
   * 名词
   */
  private String name;

  /**
   * 要求
   */
  private String demand;

  /**
   * 职责
   */
  private String duty;
}
