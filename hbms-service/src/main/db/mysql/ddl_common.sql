drop table Attachment;
create table Attachment(
  id bigint auto_increment not null primary key comment '主键',
  businessType varchar(100) comment '业务类型',
  businessId  bigint comment '业务编号',
  fileName  varchar(100) comment '文件名',
  fileType  varchar(100) comment '文件类型',
  fileBinaryData MEDIUMBLOB comment '文件二进制数据集',
  remark  varchar(500) comment '备注',
  yn  int(1) comment '是否有效',
  createTime datetime comment '创建时间',
  createUser varchar(50) comment '创建人账户',
  updateTime datetime comment '修改时间',
  updateUser varchar(50) comment '修改人账户'
);
