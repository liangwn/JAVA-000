CREATE TABLE `user` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk',
	`username` varchar(64) COMMENT '用户姓名',
	`password` varchar(64) COMMENT '用户密码',
	`gender` char(1) COMMENT '性别',
	`cellphone` char(11) COMMENT '手机号',
	`address` varchar(1024) COMMENT '地址',
	`creator` varchar(32) NOT NULL DEFAULT 'system' COMMENT '创建人',
	`gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`modifier` varchar(32) NOT NULL DEFAULT 'system' COMMENT '修改人',
	`gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	`is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除【N-否,Y-是】',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `good` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk',
	`goodname` varchar(64) COMMENT '商品名称',
	`price` decimal(13,0) COMMENT '商品价格',
	`count` bigint(20) COMMENT '商品数量',
	`creator` varchar(32) NOT NULL DEFAULT 'system' COMMENT '创建人',
	`gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`modifier` varchar(32) NOT NULL DEFAULT 'system' COMMENT '修改人',
	`gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	`is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除【N-否,Y-是】',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

CREATE TABLE `order` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk',
	`username` varchar(64) COMMENT '用户姓名',
	`goodname` varchar(64) COMMENT '商品名称',
	`price` decimal(13,0) COMMENT '商品价格',
	`count` bigint(20) COMMENT '商品数量',
	`cellphone` char(11) COMMENT '手机号',
	`address` varchar(1024) COMMENT '地址',
	`creator` varchar(32) NOT NULL DEFAULT 'system' COMMENT '创建人',
	`gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`modifier` varchar(32) NOT NULL DEFAULT 'system' COMMENT '修改人',
	`gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	`is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除【N-否,Y-是】',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
