package com.companyname.hbms.customer.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 联系人
 *
 * Created by fellowlong on 14-6-4.
 */
public class Contact implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 客户编号，外键
   */
  private Long customerId;

  /**
   * 姓名
   */
  private String name;

  /**
   * 英文姓名
   */
  private String englishName;

  /**
   * 生日
   */
  private Date birthday;

  /**
   * 所在部门
   */
  private String department;

  /**
   * 职位
   */
  private String position;

  /**
   * 公司电话
   */
  private String companyPhone;

  /**
   * 移动电话
   */
  private String mobilePhone;

  /**
   * 公司传真
   */
  private String companyFax;

  /**
   * 电子邮箱
   */
  private String email;

  /**
   * 是否关键
   */
  private Boolean isKey;

  /**
   * 备注
   */
  private String remark;
}
