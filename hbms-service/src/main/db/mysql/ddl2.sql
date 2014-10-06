drop table Candidate;
create table Candidate(
  id bigint auto_increment not null primary key comment '候选人编号,主键',
  name varchar(100) comment '姓名',
  sex int(1) comment '性别',
  birthday datetime comment '出生日期',
  workingYears int comment '工作年限',
  residence varchar(100) comment '居住地',
  abroadStudyOrWork int(1) comment '海外学习/工作经历',
  email varchar(50) comment '电子邮箱',
  industryId bigint comment '行业编号',
  currentCompany varchar(100) comment '目前公司',
  currentPosition varchar(100) comment '目前职位',
  currentAnnualSalary varchar(50) comment '当前年薪',
  mobilePhone varchar(15) comment '手机',
  homePhone varchar(20) comment '家庭电话',
  companyPhone varchar(20) comment '公司电话',
  jobHuntingStatusId bigint comment '求职状态',
  keyword varchar(200) comment '搜索关键字',
  countryId bigint comment '国家',
  high int comment '身高',
  maritalStatusId bigint comment '婚姻状况',
  snsNo varchar(20) comment 'SNS号码',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='候选人';

drop table Resume;
create table Resume(
  id bigint auto_increment not null primary key comment '简历编号,主键',
  name varchar(100) comment '简历名称',
  sex varchar(200) comment '简历搜索关键字',
  telephone varchar(200) comment '简历路径',
  age  varchar(10) comment '年龄',
  email  varchar(100) comment '邮箱',
  education  varchar(100) comment '教育情况',
  workYears  varchar(10) comment '工作年限',
  marital  varchar(50) comment '婚姻状况',
  location  varchar(100) comment '居住地',
  industry  varchar(100) comment '所属行业',
  company  varchar(100) comment '目前公司',
  position  varchar(100) comment '目前职位',
  salary  varchar(50) comment '薪资',
  selfEvaluation  varchar(500) comment '个人评价',
  other  varchar(500) comment '其他',
  keyword  varchar(100) comment '搜索关键字',
  originalResumeUri varchar(100) comment '原始简历存储路径',
  originalResumeText  text(100) comment '原始简历文本',
  language  varchar(50) comment '简历语言',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
) comment='简历';

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

) comment='项目';

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
);

drop table ListItem;
create table ListItem(
  id int auto_increment not null primary key comment '列表项编号,主键',
  code varchar(100) comment '值',
  value varchar(100) comment '值',
  typeId int comment '列表项编号,外键',
  UNIQUE KEY UK_ListItem_Code (code)
) auto_increment = 100001, comment='下拉列表';