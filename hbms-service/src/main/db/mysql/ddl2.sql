drop table Resume;
create table Resume(
  candidateId bigint primary key comment '主键，候选人外键',
  name varchar(100) comment '名称',
  attachmentId MEDIUMBLOB comment '简历附件编号',
  textResume  MEDIUMTEXT comment '文本简历',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

drop table Candidate;
create table Candidate(
  id bigint auto_increment not null primary key comment '候选人编号,主键',
  code varchar(100) comment '姓名',
  name varchar(100) comment '姓名',
  sexId int(1) comment '性别',
  birthday datetime comment '出生日期',
  mobile varchar(20) comment '手机',
  telephone varchar(20) comment '家庭电话',
  email varchar(50) comment '电子邮箱',
  otherContact varchar(100) comment '电子邮箱',
  degreeId bigint comment '学历',
  maritalId bigint comment '婚姻状况',
  cityId bigint comment '所在地',
  workYears int comment '工作年限',
  overseasExperience int(1) comment '海外经历',
  industryId bigint comment '行业编号',
  companyId bigint comment '目前公司',
  positionId bigint comment '目前职位',
  currentAnnualSalary varchar(50) comment '目前年薪',
  jobHuntingStatusId bigint comment '求职状态',
  strengthsAndWeaknesses varchar(500) comment '优劣势',
  keyword varchar(100) comment '搜索关键字',
  remark varchar(500) comment '其他信息',
  favoriteId bigint comment '收藏夹',
  folderId bigint comment '目录',
  sourceId bigint comment '来源',
  uploaderId bigint comment '上传者',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='候选人';

drop table WorkExperience;
create table WorkExperience (
  id bigint auto_increment not null primary key comment '工作经历编号,主键',
  candidateId bigint comment '人才，外键',
  company varchar(100) comment '公司名称',
  startDate date comment '开始日期',
  endDate date comment '结束日期',
  position varchar(100) comment '职位',
  responsibility varchar(500) comment '职责'
) comment='工作经历';

drop table EducationExperience;
create table EducationExperience (
  id bigint auto_increment not null primary key comment '工作经历编号,主键',
  candidateId bigint comment '人才，外键',
  schoolId bigint comment '学习，外键',
  startDate date comment '开始日期',
  endDate date comment '结束日期',
  degreeId bigint comment '学历，外键',
  majorId bigint comment '专业，外键',
  typeId bigint comment '类型，外键'
) comment='教育经历';


drop table LanguageAbility;
create table LanguageAbility (
  id bigint auto_increment not null primary key comment '语言能力编号,主键',
  candidateId bigint comment '人才，外键',
  languageId bigint comment '语言，外键',
  readAndWriteId bigint comment '读写能力，外键',
  listenAndSpeakingId bigint comment '听说能力，外键'
) comment='语言能力';

drop table Certificate;
create table Certificate (
  id bigint auto_increment not null primary key comment '证书编号,主键',
  candidateId bigint comment '人才，外键',
  certificateId bigint comment '证书，外键',
  acquireDate date comment '获得日期'
) comment='证书';

drop table ProjectExperience;
create table ProjectExperience (
  id bigint auto_increment not null primary key comment '项目编号,主键',
  candidateId bigint comment '人才，外键',
  name varchar(100) comment '项目名称',
  startDate date comment '开始日期',
  endDate date comment '结束日期',
  isIt int (1) comment '是否IT项目',
  projectDescription varchar(500) comment '项目介绍',
  softwareEnvironment varchar(100) comment '软件环境',
  hardwareEnvironment varchar(100) comment '硬件环境',
  developTool varchar(100) comment '开发工具',
  position varchar(50) comment '项目职务',
  responsibility varchar(500) comment '工作职责'
) comment='项目经历';

drop table ResumeIndexTask;
create table ResumeIndexTask(
  id bigint auto_increment not null primary key comment '简历索引任务编号,主键',
  resumeId bigint comment '简历编号',
  status int comment '任务状态',
  yn int comment '任务是否有效',
  createTime datetime comment '任务创建时间',
  updateTime datetime comment '任务修改时间'
) comment='创建简历索引的任务表';

drop table Company;
create table Company(
  id bigint auto_increment not null primary key comment '主键',
  companyTypeId  bigint comment '公司类型外键',
  name varchar(100) comment '公司名称',
  fullName varchar(100) comment '公司全名',
  cityId bigint comment '所属城市外键',
  phone varchar(50) comment '公司电话',
  webSite varchar(100) comment '公司网址',
  address varchar(100) comment '公司地址',
  email varchar(50) comment '公司邮箱',
  fax varchar(50) comment '公司传真',
  maintainerId bigint comment '客户维护人外键',
  folderId bigint comment '客户所属文件夹外键',
  staffCount int comment '公司员工数量',
  natureId bigint comment '公司性质外键',
  products varchar(200) comment '公司产品',
  registeredCapital double comment '注册资金',
  legalPerson varchar(50) comment '法人',
  propertyRightStructureId bigint comment '产权结构外键',
  intro varchar(500) comment '企业介绍',
  keyword varchar(100) comment '搜索关键字',
  businessDeveloperId bigint comment '客户开发者外键',
  remark varchar(500) comment '企业备注',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='客户表';

drop table CompanyIndustry;
create table CompanyIndustry(
  id bigint auto_increment not null primary key comment '主键',
  companyId  bigint comment '公司外键',
  industryId bigint comment '行业外键'
) comment='公司所属行业表';


drop table CompanyFolder;
create table CompanyFolder(
  id bigint auto_increment not null primary key comment '主键',
  companyId  bigint comment '公司外键',
  folderId bigint comment '目录外键'
) comment='公司所属目录表';


drop table Contact;
create table Contact(
  id bigint auto_increment not null primary key comment '客户编号,主键',
  importantLevelId bigint comment '重要级别外键',
  companyId bigint comment '所属公司外键',
  name varchar(100) comment '名称',
  englishName varchar(100) comment '英文姓名',
  sexId bigint comment '性别外键',
  department varchar(100) comment '部门',
  position varchar(100) comment '职位',
  companyPhone varchar(50) comment '公司电话',
  mobilePhone varchar(50) comment '手机',
  companyFax varchar(100) comment '公司传真',
  email varchar(50) comment '邮箱',
  otherContact varchar(50) comment '其他联系方式',
  birthday date comment '生日',
  maintainerId bigint comment '客户维护人外键',
  remark varchar(500) comment '备注',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='联系人表';

drop table `Position`;
create table `Position`(
  id bigint auto_increment not null primary key comment '客户编号,主键',
  companyId bigint comment '所属公司外键',
  contactId bigint comment '职位联系人外键',
  code varchar(50) comment '职位编号',
  name varchar(100) comment '职位名称',
  priorityId bigint comment '优先级外键',
  industryId bigint comment '所属公司外键',
  functionId bigint comment '职能外键',
  cityId bigint comment '所属城市外键',
  fameCompanyBackgroundId bigint comment '名企背景外键',
  nationalityId bigint comment '国籍外键',
  degreeId bigint comment '学历外键',
  minAge int comment '年龄要求',
  maxAge int comment '年龄要求',
  minWorkYears int comment '工作年限要求',
  maxWorkYears int comment '工作年限要求',
  minAnnualSalary double comment '年薪范围',
  maxAnnualSalary double comment '年薪范围',
  sexId bigint comment '性别外键',
  address varchar(100) comment '招聘地址',
  description varchar(500) comment '职位描述',
  brightAndAdvantage varchar(500) comment '职位亮点及优势',
  processAndLeaderIntro varchar(500) comment '流程及领导介绍',
  salaryStructure varchar(500) comment '薪资结构',
  searchDirection varchar(500) comment '寻访方向',
  businessDeveloperId bigint comment '业务开发人外键',
  remark varchar(500) comment '备注',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='职位表';

drop table PositionLanguage;
create table PositionLanguage(
  id bigint auto_increment not null primary key comment '主键',
  positionId  bigint comment '职位外键',
  languageId bigint comment '语言外键'
) comment='职位要求的语言';


drop table PositionTag;
create table PositionTag(
  id bigint auto_increment not null primary key comment '主键',
  positionId  bigint comment '职位外键',
  tagId bigint comment '标签外键'
) comment='职位标签';


drop table Project;
create table Project(
  id bigint auto_increment not null primary key comment '客户编号,主键',
  code varchar(50) comment '项目编号',
  name varchar(50) comment '项目名称',
  companyId bigint comment '所属公司，外键',
  positionId bigint comment '职位，外键',
  contactId bigint comment '联系人，外键',
  importantLevelId bigint comment '重要程度，外键',
  startDate date comment '开始日期',
  endDate date comment '结束日期',
  managerId bigint comment '项目经理，外键',
  statusId bigint comment '状态外键',
  share int comment '是否共享',
  remark varchar(500) comment '备注',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='项目表';


drop table ProjectAssistant;
create table ProjectAssistant(
  id bigint auto_increment not null primary key comment '主键',
  projectId  bigint comment '项目外键',
  assistantId bigint comment '助理(user)外键'
) comment='项目助理';

drop table ProjectConsultant;
create table ProjectConsultant(
  id bigint auto_increment not null primary key comment '主键',
  projectId  bigint comment '项目外键',
  consultantId bigint comment '顾问(user)外键'
) comment='项目顾问';
