package com.companyname.hbms.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
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


}
