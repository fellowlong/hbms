drop table Candidate;
create table Candidate(
  id int auto_increment not null primary key comment '候选人编号，主键',
  name varchar(100) comment '姓名',
  sex int(1) comment '性别',
  birthday datetime comment '出生日期',
  workingYears int comment '工作年限',
  residence varchar(100) comment '居住地',
  abroadStudyOrWork int(1) comment '海外学习/工作经历',
  email varchar(50) comment '电子邮箱',
  industryId int comment '行业编号',
  currentCompany varchar(100) comment '目前公司',
  currentPosition varchar(100) comment '目前职位',
  currentAnnualSalary varchar(50) comment '当前年薪',
  mobilePhone varchar(15) comment '手机',
  homePhone varchar(20) comment '家庭电话',
  companyPhone varchar(20) comment '公司电话',
  jobHuntingStatusId int comment '求职状态',
  keyword varchar(200) comment '搜索关键字',
  countryId int comment '国家',
  high int comment '身高',
  maritalStatusId int comment '婚姻状况',
  snsNo varchar(20) comment 'SNS号码',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

drop table Resume;
create table Resume(
  id int auto_increment not null primary key comment '简历编号，主键',
  candidateId int comment '候选人编号，外键',
  name varchar(100) comment '简历名称',
  keyword varchar(200) comment '简历搜索关键字',
  path varchar(200) comment '简历路径',
  languageId int(2) comment '简历语言',
  type int(1) comment '类型，原始：0,报告：1',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

drop table ResumeReport;
create table ResumeReport(
  id int auto_increment not null primary key comment '简历报告编号，主键',
  candidateId int comment '候选人编号，外键',
  name varchar(100) comment '简历名称',
  keyword varchar(200) comment '简历搜索关键字',
  path varchar(200) comment '简历路径',
  companyId int comment '公司编号，外键',
  positionId int comment '职位编号，外键',
  projectId int comment '项目编号，外键',
  languageId int(2) comment '简历语言',
  type int(1) comment '类型，原始：0,报告：1',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

drop table ListItem;
create table ListItem(
  id int auto_increment not null primary key comment '列表项编号，主键',
  code varchar(100) comment '值',
  value varchar(100) comment '值',
  typeId int comment '列表项编号，外键',
  UNIQUE KEY UK_ListItem_Code (code)
) auto_increment = 100001;