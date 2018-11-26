-- ----------------------------
-- Table structure for user
-- 用户表
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) NOT NULL COMMENT '电话号码',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
INSERT INTO user(phone, password, register_time) VALUES ('17621859608','123456','2017-03-02 16:34');

-- ----------------------------
-- Table structure for classification
-- 记账item条目表
-- ----------------------------
DROP TABLE IF EXISTS `classification`;
CREATE TABLE `classification`(
	`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
	`des` VARCHAR(32) NOT NULL COMMENT '记账条目描述',
	`picpath` VARCHAR(255) NOT NULL COMMENT '记账条目图片',
	PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
INSERT INTO classification(des, picpath) VALUES ('餐饮','http://xxx/xxx/xxx.png');

-- ----------------------------
-- Table structure for bookkeeping
-- 记账表
-- ----------------------------
DROP TABLE IF EXISTS `bookkeeping`;
CREATE TABLE `bookkeeping`(
	`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT(11) NOT NULL COMMENT '用户id',
	`type_id` BIGINT(11) NOT NULL COMMENT '账目名称id',
	`classification_id` BIGINT(11) NOT NULL COMMENT '记账条目id',
	`money_type` BIGINT(11) NOT NULL COMMENT '记账类型：0 收入 1支出',
	`des` VARCHAR(32) NOT NULL COMMENT '记账描述',
	`money` DECIMAL NOT NULL COMMENT '记账金额',
	`add_time` TIMESTAMP NOT NULL COMMENT '记账时间',
	PRIMARY KEY(`id`),
  --  外键约束
	FOREIGN KEY(`user_id`) REFERENCES user(`id`),
	FOREIGN KEY(`type_id`) REFERENCES bookkeeping_type(`id`),
	FOREIGN KEY(`classification_id`) REFERENCES classification(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO bookkeeping(user_id,type_id,classification_id,money_type,content,money,add_time) VALUES (2,1,2,1,'人情红包',1000,'2018-11-26 13:39:58');

-- ----------------------------
-- Table structure for bookkeeping_type
-- 记账类型表
-- ----------------------------
DROP TABLE IF EXISTS `bookkeeping_type`;
CREATE TABLE `bookkeeping_type`(
	`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL COMMENT '记账本名称',
	PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO bookkeeping_type(name) VALUES ('日常记账本');
INSERT INTO bookkeeping_type(name) VALUES ('生意记账本');
INSERT INTO bookkeeping_type(name) VALUES ('结婚记账本');
INSERT INTO bookkeeping_type(name) VALUES ('旅游记账本');

-- ----------------------------
-- sql
-- ----------------------------

--  查询全部用户的记账表(指定用戶只需要在后面加上 WHERE b.user_id = x)
SELECT b.user_id,b.type_id,b.content,b.money,b.money_type,u.phone,c.des
			FROM bookkeeping b
			LEFT JOIN user u on u.id = b.user_id
			LEFT JOIN classification c on c.id = b.classification_id
			LEFT JOIN bookkeeping_type t on t.id = b.type_id;
