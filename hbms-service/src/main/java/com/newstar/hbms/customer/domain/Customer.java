package com.newstar.hbms.customer.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户
 *
 * Created by fellowlong on 14-6-4.
 */
public class Customer implements Serializable {

  /**
   * 主键
   */
  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * web站点
   */
  private String webSite;

  /**
   * 电话
   */
  private String phone;

  /**
   * 传真
   */
  private String fax;

  /**
   * 地区
   */
  private String region;

  /**
   * 地址
   */
  private String address;

  /**
   * 邮编
   */
  private String postCode;

  /**
   * 员工数量
   */
  private Integer staffCount;

  /**
   * 行业
   */
  private String industry;

  /**
   * 性质
   */
  private String nature;

  /**
   * 产品
   */
  private String products;

  /**
   * 注册资金
   */
  private String registeredCapital;

  /**
   * 法人
   */
  private String legalPerson;

  /**
   * 产权结构
   */
  private String propertyRightStructure;

  /**
   * 企业备注
   */
  private String remark;

  /**
   * 关键字
   */
  private String keyword;

  /**
   * 是否有效
   * @return
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
}