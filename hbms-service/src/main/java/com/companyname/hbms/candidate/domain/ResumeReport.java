package com.companyname.hbms.candidate.domain;

import com.companyname.hbms.basedata.domain.ListItem;
import com.companyname.hbms.customer.domain.Company;
import com.companyname.hbms.customer.domain.Position;
import com.companyname.hbms.project.domain.Project;

import java.io.Serializable;
import java.util.Date;

public class ResumeReport implements Serializable {

  /**
   * 主键，编号
   */
  private Long id;

  /**
   * 候选人编号
   */
  private Long candidateId;

  /**
   * 候选人
   */
  private Candidate candidate;

  /**
   * 名称
   */
  private String name;

  /**
   * 搜索关键字
   */
  private String keyword;

  /**
   * 附件存储路径
   */
  private String path;

  /**
   * 公司编号
   */
  private Long companyId;

  /**
   * 公司
   */
  private Company company;

  /**
   * 职位编号
   */
  private Long positionId;

  /**
   * 职位
   */
  private Position position;

  /**
   * 项目编号
   */
  private Long projectId;

  /**
   * 项目
   */
  private Project project;

  /**
   * 语言编号
   */
  private Long languageId;

  /**
   * 语言
   */
  private ListItem language;

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
