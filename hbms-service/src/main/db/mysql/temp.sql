DROP TABLE resume;
CREATE TABLE resume (
	id bigint auto_increment not null primary key comment '主键',
	fileName VARCHAR(200),
	binary_content MEDIUMBLOB comment '文件二进制数据集',
	text_content text comment '文本数据',
	account VARCHAR(200),
	resumeId VARCHAR(200),
	name VARCHAR(200),
	industry VARCHAR(200),
	company VARCHAR(200),
	position VARCHAR(200),
	hopePosition VARCHAR(200),
	positionType VARCHAR(200),
	city VARCHAR(100)
) ENGINE=InnoDB;
