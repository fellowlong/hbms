package com.newstar.hbms.customer.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fellowlong on 2014-09-22.
 */
public class Position implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;


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
