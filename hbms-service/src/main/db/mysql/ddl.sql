
drop table Resume;
create table Resume(
  id int auto_increment not null primary key comment '简历编号，主键',
  name varchar(100) comment '简历名称',
  languageId int(2) comment '简历语言',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  updateTime datetime comment '修改时间'
);

drop table OriginalResume;
create table OriginalResume(
  id int auto_increment not null primary key comment '原始简历编号，主键',
  resumeId int comment '简历编号，外键',
  name varchar(200) comment '原始简历名称',
  keyword varchar(200) comment '简历关键字',
  attachmentName varchar(200) comment '原始简历附件名称',
  attachmentPath varchar(200) comment '原始简历附件路径',
  yn int(1) comment '是否有效'
);

drop table PersonalInfo;
create table PersonalInfo (
  resumeId int primary key comment '简历编号，既是主键又是外键',
  name varchar(50) comment '姓名',
  sex int(1) comment '性别',
  birthday date comment '出生日期',
  workingYears int(3) comment '工作年限',
  papersType int(1) comment '证件类型',
  papersNumber varchar(50) comment '证件编号',
  residence varchar(200) comment '居住地',
  abroadStudyOrWork int(1) comment '是否有海外学习或工作经历',
  email varchar(50) comment '邮箱',
  currentAnnualSalary double comment '当前年薪',
  mobilePhone varchar(30) comment '移动电话',
  homePhone varchar(30) comment '家庭电话',
  companyPhone varchar(30) comment '公司电话',
  jobHuntingStatus int(1) comment '求职状态',
  householdRegister varchar(50) comment '户籍',
  keyword varchar(50) comment '关键字',
  country varchar(50) comment '国家',
  high int(3) comment '身高',
  maritalStatus int(1) comment '婚姻状况',
  politicalStatus int(1) comment '政治面貌',
  postcode varchar(10) comment '邮编',
  qq varchar(20) comment 'QQ号码',
  address varchar(200) comment '联系地址',
  selfHomepage varchar(200) comment '个人主页',
  createTime datetime comment '创建时间',
  updateTime datetime comment '修改时间'
) engine=innodb default charset=utf8 comment '个人信息表';
