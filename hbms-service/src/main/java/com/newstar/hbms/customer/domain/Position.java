package com.newstar.hbms.customer.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.system.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fellowlong on 2014-09-22.
 */
public class Position implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 所属公司
   */
  private Long companyId;

  private Company company;

  /**
   * 客户联系人
   */
  private Long contactId;
  private Contact contact;

  /**
   * 名称
   */
  private String name;

  /**
   * 优先级
   */
  private Long priorityId;

  /**
   * 行业
   */
  private Long industryId;

  /**
   * 职能
   */
  private Long functionId;

  /**
   * 城市
   */
  private Long cityId;

  /**
   * 名企背景
   */
  private Long fameCompanyBackgroundId;

  /**
   * 国籍
   */
  private Long nationalityId;

  /**
   * 学历
   */
  private Long degreeId;

  /**
   * 语言
   */
  private Long languageId;

  /**
   * 年龄要求
   */
  private Integer minAge;
  private Integer maxAge;

  /**
   * 工作年限要求：
   */
  private Integer minWorkYears;
  private Integer maxWorkYears;

  /**
   * 年薪范围
   */
  private Double minAnnualSalary;
  private Double maxAnnualSalary;

  /**
   * 性别要求
   */
  private Integer sex;

  /**
   * 招聘地址
   */
  private String address;

  /**
   * 标签
   */
  private List<TreeNode> tags = new ArrayList<TreeNode>();

  /**
   * 说明
   */
  private String description;

  /**
   * 职位亮点及优势
   */
  private String brightAndAdvantage;

  /**
   * 流程及领导介绍
   */
  private String processAndLeaderIntro;

  /**
   * 薪资结构
   */
  private String salaryStructure;

  /**
   * 寻访方向
   */
  private String searchDirection;

  /**
   * BD
   */
  private Long businessDeveloperId;
  private User businessDeveloper;

  /**
   * 备注
   */
  private String remark;

  /**
   * 是否有效
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
