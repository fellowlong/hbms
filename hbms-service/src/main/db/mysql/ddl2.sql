drop table Candidate;
create table Candidate(
  id int auto_increment not null primary key comment '人才编号，主键',
  name varchar(100) comment '姓名',
  sex int(1) comment '性别',
  birthday datetime comment '出生日期',
  workingYears int comment '工作年限',
  papersTypeId int comment '证件类型',
  papersNumber varchar(50) comment '证件号码',
  residence varchar(100) comment '居住地',
  abroadStudyOrWork int(1) comment '海外学习/工作经历',
  email varchar(50) comment '电子邮箱',
  currentAnnualSalary varchar(50) comment '目前年薪',
  mobilePhone varchar(15) comment '手机',
  homePhone varchar(20) comment '家庭电话',
  companyPhone varchar(20) comment '公司电话',
  jobHuntingStatusId int comment '求职状态',
  householdRegister varchar(50) comment '户籍',
  keyword varchar(200) comment '搜索关键字',
  countryId int comment '国家',
  high int comment '身高',
  maritalStatusId int comment '婚姻状况',
  politicalStatusId int comment '政治面貌',
  postcode varchar(10) comment '邮编',
  qq varchar(20) comment 'QQ号码',
  address varchar(100) comment '联系地址',
  selfHomepage varchar(100) comment '个人主页',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

drop table Resume;
create table Resume(
  id int auto_increment not null primary key comment '简历编号，主键',
  candidateId int comment '人才编号，外键',
  name varchar(100) comment '简历名称',
  keyword varchar(200) comment '简历搜索关键字',
  path varchar(200) comment '简历路径',
  languageId int(2) comment '简历语言',
  type int(1) comment '类型，原始：0,报告：1',
  yn int(1) comment '是否有效'
);

drop table ListItem;
create table ListItem(
  id int auto_increment not null primary key comment '列表项编号，主键',
  code varchar(100) comment '值',
  value varchar(100) comment '值',
  typeId int comment '列表项编号，外键',
  UNIQUE KEY UK_ListItem_Code (code)
) auto_increment = 100001;