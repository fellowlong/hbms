drop table Resume;
create table Resume(
  id bigint auto_increment not null primary key comment '主键',
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
  name varchar(100) comment '姓名',
  sexId bigint(1) comment '性别',
  birthday datetime comment '出生日期',
  mobile varchar(20) comment '手机',
  telephone varchar(20) comment '家庭电话',
  email varchar(50) comment '电子邮箱',
  otherContact varchar(100) comment '电子邮箱',
  degreeId bigint comment '学历',
  maritalId bigint comment '婚姻状况',
  locationId bigint comment '所在地',
  workYears int comment '工作年限',
  overseasExperience int(1) comment '海外经历',
  industryId bigint comment '行业编号',
  currentCompanyId varchar(100) comment '目前公司',
  currentPositionId varchar(100) comment '目前职位',
  currentAnnualSalary varchar(50) comment '目前年薪',
  jobHuntingStatusId bigint comment '求职状态',
  other varchar(500) comment '其他信息',
  keyword varchar(200) comment '搜索关键字',
  remark varchar(500) comment '其他信息',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='候选人';

drop table WorkExperience;
create table WorkExperience (
  id bigint auto_increment not null primary key comment '工作经历编号,主键',
  resumeId bigint comment '简历编号',
  company varchar(100) comment '公司名称',
  startDate varchar(20) comment '开始日期',
  endDate varchar(20) comment '结束日期',
  industry varchar(100) comment '行业',
  position varchar(100) comment '职位',
  responsibility varchar(500) comment '职责'
) comment='工作经历';

drop table EducationExperience;
create table EducationExperience (
  id bigint auto_increment not null primary key comment '工作经历编号,主键',
  resumeId bigint comment '简历编号',
  school varchar(100) comment '学校名称',
  startDate varchar(20) comment '开始日期',
  endDate varchar(20) comment '结束日期',
  degree varchar(100) comment '学历'
) comment='教育经历';


drop table LanguageAbility;
create table LanguageAbility (
  id bigint auto_increment not null primary key comment '语言能力编号,主键',
  resumeId bigint comment '简历编号',
  name varchar(100) comment '名称',
  readAndWrite varchar(50) comment '读写能力',
  listenAndSpeaking varchar(50) comment '听说能力'
) comment='语言能力';

drop table Certificate;
create table Certificate (
  id bigint auto_increment not null primary key comment '证书编号,主键',
  resumeId bigint comment '简历编号',
  name varchar(50) comment '证书名称',
  acquireDate varchar(20) comment '获得日期'
) comment='证书';

drop table ProjectExperience;
create table ProjectExperience (
  id bigint auto_increment not null primary key comment '项目编号,主键',
  resumeId bigint comment '简历编号',
  name varchar(100) comment '项目名称',
  startDate varchar(20) comment '开始日期',
  endDate varchar(20) comment '结束日期',
  isIt int (1) comment '是否IT项目',
  softwareEnvironment varchar(100) comment '软件环境',
  hardwareEnvironment varchar(100) comment '硬件环境',
  developTool varchar(100) comment '开发工具',
  responsibility varchar(500) comment '工作职责',
  projectDescription varchar(500) comment '项目介绍'

) comment='项目经历';

drop table ResumeReport;
create table ResumeReport(
  id int auto_increment not null primary key comment '简历报告编号,主键',
  candidateId int comment '候选人编号,外键',
  name varchar(100) comment '简历名称',
  keyword varchar(200) comment '简历搜索关键字',
  path varchar(200) comment '简历路径',
  companyId int comment '公司编号,外键',
  positionId int comment '职位编号,外键',
  projectId int comment '项目编号,外键',
  languageId int(2) comment '简历语言',
  type int(1) comment '类型,原始：0,报告：1',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='简历报告';

drop table ListItem;
create table ListItem(
  id int auto_increment not null primary key comment '列表项编号,主键',
  code varchar(100) comment '值',
  value varchar(100) comment '值',
  typeId int comment '列表项编号,外键',
  UNIQUE KEY UK_ListItem_Code (code)
) auto_increment = 100001, comment='下拉列表';


drop table ResumeIndexTask;
create table ResumeIndexTask(
  id bigint auto_increment not null primary key comment '简历索引任务编号,主键',
  resumeId bigint comment '简历编号',
  status int comment '任务状态',
  yn int comment '任务是否有效',
  createTime datetime comment '任务创建时间',
  updateTime datetime comment '任务修改时间'
) comment='创建简历索引的任务表';



drop table Customer;
create table Customer(
  id bigint auto_increment not null primary key comment '客户编号,主键',
  name  varchar(100) comment '名称',
  webSite varchar(100) comment '网址',
  phone varchar(20) comment '电话',
  fax varchar(20) comment '传真',
  region varchar(50) comment '地区',
  address varchar(100) comment '地址',
  postCode varchar(20) comment '邮编',
  staffCount int comment '员工数量',
  industry varchar(100) comment '所属行业',
  nature varchar(50) comment '企业性质',
  products varchar(100) comment '产品',
  registeredCapital varchar(50) comment '注册资金',
  legalPerson varchar(50) comment '法人',
  propertyRightStructure varchar(50) comment '产权结构',
  remark varchar(500) comment '企业备注',
  keyword varchar(100) comment 'keyword',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='客户表';


drop table Contact;
create table Contact(
  id bigint auto_increment not null primary key comment '客户编号,主键',
  name  varchar(100) comment '名称',
  englishName varchar(20) comment '英文姓名',
  customerId bigint comment '外键，客户主键',
  birthday DATE comment '生日',
  department varchar(50) comment '部门',
  position varchar(50) comment '职位',
  companyPhone varchar(20) comment '公司电话',
  mobilePhone varchar(20) comment '手机',
  companyFax varchar(20) comment '公司传真',
  email varchar(20) comment '邮箱',
  isKey INT (1) comment '是否关键',
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
  name  varchar(100) comment '名称',
  minAge int comment '最低年龄',
  maxAge int comment '最高年龄',
  sex int(1) comment '性别要求',
  minWorkYears int comment '最小工作年限',
  maxWorkYears int comment '最大工作年限',
  educationLevel varchar(100) comment '学历要求',
  industry varchar(100) comment '行业要求',
  foreignLanguage varchar(100) comment '外语要求',
  address varchar(100) comment '地址',
  description varchar(2000) comment '职位描述',
  customerId bigint comment '客户编号，外键',
  remark varchar(500) comment '备注',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='职位表';