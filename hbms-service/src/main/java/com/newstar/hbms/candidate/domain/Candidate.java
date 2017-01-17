package com.newstar.hbms.candidate.domain;

import com.newstar.hbms.basedata.domain.TreeNode;
import org.apache.poi.hmef.Attachment;
import org.apache.poi.hslf.model.Comment;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Candidate implements Serializable {

  /**
   * 主键，编号
   */
  private Long id;

  /**
   * 原始简历文件，用来临时存储
   */
  private MultipartFile resumeFile;

  /**
   * 原始简历
   */
  private Resume resume;

  private MultipartFile[] otherAttachmentFiles;

  private Attachment[] otherAttachments;

  /**
   * 人才编号
   */
  private String code;

  /**
   * 姓名
   */
  private String name;

  /**
   * 性别
   */
  private Long sexId;
  private TreeNode sex;

  /**
   * 出生日期
   */
  private Date birthday;

  /**
   * 手机号码
   */
  private String mobile;

  /**
   * 座机
   */
  private String telephone;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 其他联系方式
   */
  private String otherContact;

  /**
   * 学历
   */
  private Long degreeId;
  private TreeNode degree;

  /**
   * 婚姻状况
   */
  private Long maritalId;
  private TreeNode marital;

  /**
   * 所在地
   */
  private Long cityId;
  private TreeNode city;

  /**
   * 工作年限
   */
  private Integer workYears;

  /**
   * 工作年限
   */
  private Boolean overseasExperience;

  /**
   * 所在行业
   */
  private Long industryId;
  private TreeNode industry;

  /**
   * 公司
   */
  private Long companyId;
  private TreeNode company;

  /**
   * 职位
   */
  private Long positionId;
  private TreeNode position;

  /**
   * 年薪
   */
  private Double currentAnnualSalary;

  /**
   * 求职状态
   */
  private Long jobHuntingStatusId;
  private TreeNode jobHuntingStatus;


  /**
   * 优势和劣势
   */
  private String strengthsAndWeaknesses;

  /**
   * 备注
   */
  private String remark;

  /**
   * 搜索关键字
   */
  private String keyword;

  /**
   * 收藏夹
    */
  private Long favoriteId;
  private TreeNode favorite;

  /**
   * 所属文件夹
   */
  private Long folderId;
  private TreeNode folder;

  /**
   * 来源
   */
  private Long sourceId;
  private TreeNode source;

  /**
   * 上传者
   */
  private Long uploaderId;
  private TreeNode uploader;

  /**
   * 批注
   */
  private List<Comment> comments = new ArrayList<Comment>();

  /**
   *
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
