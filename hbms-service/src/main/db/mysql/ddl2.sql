drop table Talent;
create table Talent(
  id int auto_increment not null primary key comment '人才编号，主键',
  name varchar(100) comment '姓名',
  keyword varchar(200) comment '搜索关键字',
  yn int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

drop table Resume;
create table Resume(
  id int auto_increment not null primary key comment '简历编号，主键',
  talentId int comment '人才编号，外键',
  name varchar(100) comment '简历名称',
  keyword varchar(200) comment '简历搜索关键字',
  path varchar(200) comment '简历路径',
  languageId int(2) comment '简历语言',
  type int(1) comment '类型，原始：0,报告：1',
  yn int(1) comment '是否有效'
);