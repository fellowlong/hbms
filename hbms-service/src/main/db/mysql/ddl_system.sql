drop table User;
create table User(
  id bigint auto_increment not null primary key comment '主键',
  account varchar(100) comment '登录账号',
  password varchar(50) comment '密码',
  name  varchar(100) comment '姓名',
  position  int(1) comment '职位',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

drop table Role;
create table Role(
  id bigint auto_increment not null primary key comment '主键',
  account varchar(100) comment '登录账号',
  password varchar(50) comment '密码',
  name  varchar(100) comment '姓名',
  position  int(1) comment '职位',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

drop table Role;
create table Role(
  id bigint auto_increment not null primary key comment '主键',
  name varchar(100) comment '角色名称',
  code varchar(50) comment '角色编码',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

drop table Authority;
create table Authority(
  id bigint auto_increment not null primary key comment '主键',
  name varchar(100) comment '权限名称',
  uri varchar(50) comment '权限访问地址',
  code varchar(50) comment '权限编码',
  parentId bigint comment '父编号',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);

