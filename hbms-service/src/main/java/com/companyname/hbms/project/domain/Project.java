package com.companyname.hbms.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目
 *
 * Created by fellowlong on 14-6-4.
 */
public class Project implements Serializable {

  /**
   * 主键
   */
  private Long id;

  /**
   * 开始日期
   */
  private Date startDate;

  /**
   * 结束日期
   */
  private Date endDate;

  /**
   * 客户联系人
   */
  private String contract;

  /**
   * 顾问
   */
  private String consultant;

  /**
   * 助理
   */
  private String assistant;

  /**
   * 项目负责人
   */
  private String leader;

  /**
   * 销售员
   */
  private String salesman;

  /**
   * 项目级别
   */
  private String level;

  /**
   * 是否关键
   */
  private String isKey;

  /**
   * 项目状态
   */
  private String status;

  /**
   * 备注
   */
  private String remark;

  /**
   * 项目计划
   */
  private String plant;

  /**
   * 计划备注
   */
  private String plantRemark;
}
