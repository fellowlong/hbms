package com.newstar.hbms.project.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.domain.Contact;
import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.system.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
   * 重要程度
   */
  private Long importantLevelId;
  private TreeNode importantLevel;

  /**
   * 项目名称
   */
  private String name;

  /**
   * 开始日期
   */
  private Date startDate;

  /**
   * 结束日期
   */
  private Date endDate;

  /**
   * 所含职位
   */
  private List<Position> positions;

  /**
   * 项目负责人
   */
  private Long managerId;
  private User manager;

  /**
   * 顾问
   */
  private Long consultantId;
  private User consultant;

  /**
   * 助理
   */
  private Long assistantId;
  private User assistant;

  /**
   * 其他顾问
   */
  private List<User> otherConsultants = new ArrayList<User>();

  /**
   * 项目状态
   */
  private Long statusId;
  private TreeNode status;

  /**
   * 项目计划
   */
  private Long plantId;
  private TreeNode plant;

  /**
   * 计划备注
   */
  private String plantRemark;

  /**
   * 备注
   */
  private String remark;

  /**
   * 是否共享
   */
  private Boolean share;

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
