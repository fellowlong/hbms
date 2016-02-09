package com.newstar.hbms.visit.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 14-6-5.
 */
public class Visit implements Serializable {

  /**
   * 主键
   */
  private Long id;

  //======项目信息
  /**
   * 项目公司
   */
  private Long projectCompanyId;

  /**
   * 项目订单
   */
  private Long projectOrderId;

  //=======创建信息================
  /**
   * 职位
   */
  private Long positionId;

  /**
   * 创建人
   */
  private Long createUserId;

  /**
   * 下次访问时间
   */
  private Date nextVisitTime;

  /**
   * 提前提醒
   */
  private String earlyRemindTime;

  /**
   * 提醒间隔
   */
  private int remindInterval;

  //========寻访信息===========
  /**
   * 寻访人
   */
  private Long visitorId;

  /**
   * 寻访时间
   */
  private Date visitTime;

  /**
   * 寻访状态
   */
  private int visitStatus;

  /**
   * 入选原因
   */
  private String selectedReason;

  /**
   * 背景调查
   */
  private String backgroundCheck;

  /**
   * 印象
   */
  private String impression;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 修改时间
   */
  private Date updateTime;

}
