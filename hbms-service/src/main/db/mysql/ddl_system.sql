drop table User;
create table User(
  id bigint auto_increment not null primary key comment '主键',
  username varchar(50) comment '登录账号',
  password varchar(50) comment '密码',
  realName varchar(50) comment '真实姓名',
  resumeId bigint comment 'candidate主键',
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

DROP TABLE sequence;
CREATE TABLE sequence (
  seqName varchar(50) NOT NULL comment '序列名称',
  currentValue int(11) NOT NULL comment '当前序列值',
  increment int(11) NOT NULL DEFAULT '1' comment '序列增量',
  PRIMARY KEY (seqName),
  UNIQUE KEY name (seqName)
) ENGINE=innodb comment='序列表，为表自动生产主键';


drop table TreeNode;
create table TreeNode(
  id bigint auto_increment not null primary key comment '主键',
  code varchar(50) comment '节点编码',
  label varchar(50) comment '节点编码',
  value varchar(100) comment '节点编码',
  parentId bigint comment '父编号',
  ancestorId bigint comment '祖宗编号',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);