/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.26 : Database - drivers
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`drivers` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `cadet` */

CREATE TABLE `cadet` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `driver_id` bigint(20) DEFAULT NULL COMMENT '驾驶员数据ID',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `mobile` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `weixin_num` varchar(20) DEFAULT NULL COMMENT '微信号',
  `idcard_num` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学员信息';

/*Data for the table `cadet` */

LOCK TABLES `cadet` WRITE;

insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (1,1,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (2,NULL,NULL,NULL,NULL,NULL,NULL,'xjj900217','513722199215422092','','','2016-08-11 12:16:59','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (3,NULL,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (4,NULL,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (5,NULL,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (6,NULL,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (7,NULL,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (8,NULL,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (9,NULL,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (10,NULL,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);
insert  into `cadet`(`id`,`driver_id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (11,NULL,'a','a','a',21,'18782271111','xjj900217','513722199215422092','admin','admin','2016-08-11 11:18:05','2016-09-16 23:35:16',1);

UNLOCK TABLES;

/*Table structure for table `cadet_course` */

CREATE TABLE `cadet_course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) NOT NULL COMMENT '学员信息数据ID',
  `course` tinyint(1) NOT NULL COMMENT '目前课程',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='学员信息_课程情况';

/*Data for the table `cadet_course` */

LOCK TABLES `cadet_course` WRITE;

insert  into `cadet_course`(`id`,`cadet_id`,`course`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (1,1,1,'admin','admin','2016-08-13 17:23:06','2016-08-13 17:23:06');
insert  into `cadet_course`(`id`,`cadet_id`,`course`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (2,2,2,'admin','admin','2016-08-13 17:23:20','2016-08-13 17:23:20');

UNLOCK TABLES;

/*Table structure for table `cadet_pay` */

CREATE TABLE `cadet_pay` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) NOT NULL COMMENT '学员信息数据ID',
  `pay_status` tinyint(1) NOT NULL COMMENT '缴费状态',
  `pay_amount` decimal(10,0) DEFAULT NULL COMMENT '缴费金额',
  `pay_datetime` datetime DEFAULT NULL COMMENT '缴费日期时间',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='学员信息_缴费信息';

/*Data for the table `cadet_pay` */

LOCK TABLES `cadet_pay` WRITE;

insert  into `cadet_pay`(`id`,`cadet_id`,`pay_status`,`pay_amount`,`pay_datetime`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (1,1,1,'3500',NULL,'admin','admin','2016-08-13 17:23:33','2016-08-13 18:06:12');
insert  into `cadet_pay`(`id`,`cadet_id`,`pay_status`,`pay_amount`,`pay_datetime`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (2,2,2,'1548',NULL,'admin','admin','2016-08-13 17:23:39','2016-08-13 18:06:23');

UNLOCK TABLES;

/*Table structure for table `city` */

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `city` */

LOCK TABLES `city` WRITE;

insert  into `city`(`id`,`name`,`state`) values (1,'石家庄','河北');
insert  into `city`(`id`,`name`,`state`) values (2,'邯郸','河北');
insert  into `city`(`id`,`name`,`state`) values (3,'石家庄','河北');
insert  into `city`(`id`,`name`,`state`) values (4,'邯郸','河北');
insert  into `city`(`id`,`name`,`state`) values (5,'秦皇岛','河北');
insert  into `city`(`id`,`name`,`state`) values (6,'石家庄','河北');
insert  into `city`(`id`,`name`,`state`) values (7,'邯郸','河北');
insert  into `city`(`id`,`name`,`state`) values (8,'秦皇岛','河北');
insert  into `city`(`id`,`name`,`state`) values (9,'石家庄','河北');
insert  into `city`(`id`,`name`,`state`) values (10,'邯郸','河北');
insert  into `city`(`id`,`name`,`state`) values (11,'秦皇岛','河北');

UNLOCK TABLES;

/*Table structure for table `driver` */

CREATE TABLE `driver` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '电话号码1',
  `mobile2` varchar(20) DEFAULT NULL COMMENT '电话号码2',
  `model` varchar(2) DEFAULT NULL COMMENT '车型',
  `register_datetime` datetime DEFAULT NULL COMMENT '注册时间',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `driver` */

LOCK TABLES `driver` WRITE;

insert  into `driver`(`id`,`name`,`mobile`,`mobile2`,`model`,`register_datetime`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (1,'黄继忠','14780196128','13778878743','C1','2016-08-28 16:19:11','admin','admin','2016-08-28 16:19:28','2016-09-16 23:33:12',1);

UNLOCK TABLES;

/*Table structure for table `persistent_logins` */

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `persistent_logins` */

LOCK TABLES `persistent_logins` WRITE;

insert  into `persistent_logins`(`username`,`series`,`token`,`last_used`) values ('admin','NCpnEvbk7MUbreEi1ne8Cg==','ZZ3J+dJYdcTQH50+KmvrvQ==','2016-08-24 00:51:27');

UNLOCK TABLES;

/*Table structure for table `role` */

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `create_datetime` datetime NOT NULL,
  `update_datetime` datetime NOT NULL,
  `data_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

LOCK TABLES `role` WRITE;

insert  into `role`(`id`,`name`,`description`,`seq`,`create_datetime`,`update_datetime`,`data_status`) values (1,'ROLE_ADMIN','管理员',1,'2016-05-07 14:19:51','2016-05-07 14:20:03','');
insert  into `role`(`id`,`name`,`description`,`seq`,`create_datetime`,`update_datetime`,`data_status`) values (2,'ROLE_USER','用户',2,'2016-05-07 14:20:06','2016-05-07 14:20:09','');

UNLOCK TABLES;

/*Table structure for table `school` */

CREATE TABLE `school` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `name` varchar(20) NOT NULL COMMENT '驾校名称',
  `logo_url` varchar(100) DEFAULT NULL COMMENT '驾校logo地址',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) DEFAULT NULL COMMENT '电子邮箱',
  `addr` varchar(50) DEFAULT NULL COMMENT '驾校地址',
  `slogan` varchar(50) DEFAULT NULL COMMENT '宣传口号',
  `introduction` varchar(2000) DEFAULT NULL COMMENT '驾校简介',
  `administrators` varchar(10) DEFAULT NULL COMMENT '管理员',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='驾校信息';

/*Data for the table `school` */

LOCK TABLES `school` WRITE;

insert  into `school`(`id`,`name`,`logo_url`,`mobile`,`phone`,`email`,`addr`,`slogan`,`introduction`,`administrators`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (1,'眉山市瑞达驾校','/images/logo/logo.jpg','18782275356','028-8145523','xhujinjun@163.com','四川省彭山市','专业从事驾驶员培训20余年','眉山市彭山区瑞达汽车驾驶培训有限公司是原彭山县南门口交通驾校，专业从事驾驶员培训20余年，一次性收费，管理严格。','金宏宇','admin','admin','2016-08-12 11:17:03','2016-09-11 14:44:47',1);

UNLOCK TABLES;

/*Table structure for table `school_tuition` */

CREATE TABLE `school_tuition` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `school_id` bigint(20) NOT NULL COMMENT '驾校信息数据ID',
  `tuition` decimal(10,2) NOT NULL COMMENT '学费',
  `tuition_explain` varchar(100) DEFAULT NULL COMMENT '学费说明',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='驾校信息_学费信息';

/*Data for the table `school_tuition` */

LOCK TABLES `school_tuition` WRITE;

insert  into `school_tuition`(`id`,`school_id`,`tuition`,`tuition_explain`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (1,1,'3600.60','所有学费','admin','admin','2016-08-13 22:06:16','2016-09-11 16:47:08');

UNLOCK TABLES;

/*Table structure for table `suggestion` */

CREATE TABLE `suggestion` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) DEFAULT NULL COMMENT '学员信息数据ID',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `content` varchar(1000) DEFAULT NULL COMMENT '投诉内容',
  `business_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '业务状态(1：未处理，2：正在处理,3:已处理)',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='投诉建议';

/*Data for the table `suggestion` */

LOCK TABLES `suggestion` WRITE;

insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (1,1,'user1','18785545656','本宝宝不高兴啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊',2,'admin','admin','2016-08-13 21:05:02','2016-09-17 00:23:44',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (2,NULL,'','','meorpmg',3,'weixin','weixin','2016-09-10 22:04:35','2016-09-17 00:23:45',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (3,NULL,'谢进军','12456','内容',2,'weixin','weixin','2016-09-10 22:05:33','2016-09-17 00:23:47',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (4,NULL,'dfg','4587','1245',3,'weixin','weixin','2016-09-10 22:20:55','2016-09-17 00:23:48',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (5,NULL,'sdf','453','sdfff',1,'weixin','weixin','2016-09-10 22:29:01','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (6,NULL,'sdf','453','sdfff',1,'weixin','weixin','2016-09-10 22:29:31','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (7,NULL,'sdf','46','456',1,'weixin','weixin','2016-09-10 22:30:12','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (8,NULL,'sdf','sdf','sdf',1,'weixin','weixin','2016-09-10 22:32:09','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (9,NULL,'sdf','gsdg','sdffffffffffff',1,'weixin','weixin','2016-09-10 22:35:09','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (10,NULL,'sdf','sdf','sdf',1,'weixin','weixin','2016-09-10 22:37:42','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (11,NULL,'sdffffffffff','sdffffff','sdfffffffffffffffffas',1,'weixin','weixin','2016-09-10 22:40:45','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (12,NULL,'sdffffffffff','sdffffff','sdfffffffffffffffffas',1,'weixin','weixin','2016-09-10 22:40:58','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (13,NULL,'sdf','sdf','sdf',1,'weixin','weixin','2016-09-10 22:44:43','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (14,NULL,'sdf','g','sdfg',1,'weixin','weixin','2016-09-10 22:55:24','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (15,NULL,'sdf','sdddddddddd','sdddddddddddd',1,'weixin','weixin','2016-09-10 23:04:46','2016-09-17 00:23:25',1);
insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (16,NULL,'sdffffffffff','ggggggggg','seeeeeeeeeeeee',1,'weixin','weixin','2016-09-10 23:05:44','2016-09-17 00:23:25',1);

UNLOCK TABLES;

/*Table structure for table `suggestion_feekback` */

CREATE TABLE `suggestion_feekback` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `suggestion_id` bigint(20) NOT NULL COMMENT '投诉建议数据ID',
  `content` text COMMENT '反馈信息',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投诉建议_反馈信息';

/*Data for the table `suggestion_feekback` */

LOCK TABLES `suggestion_feekback` WRITE;

UNLOCK TABLES;

/*Table structure for table `sys_manager` */

CREATE TABLE `sys_manager` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `avatar_url` varchar(100) DEFAULT NULL COMMENT '头像地址',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='系统管理员信息';

/*Data for the table `sys_manager` */

LOCK TABLES `sys_manager` WRITE;

insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (1,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (2,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (3,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (4,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (5,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (6,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (7,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (8,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (9,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (10,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (11,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (12,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (13,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (14,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (15,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (16,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (17,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (18,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (19,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (20,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (21,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (22,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (23,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (24,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (25,'admin','admin','xhujinjun@163.com','/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg','admin',1,27,'18782275356','admin','admin','2016-08-12 16:01:37','2016-09-11 23:39:12',1);
insert  into `sys_manager`(`id`,`username`,`password`,`email`,`avatar_url`,`name`,`sex`,`age`,`mobile`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (26,'谢进军','123sdf','xhujinjun@163.com',NULL,'',0,NULL,'','admin','admin','2016-09-15 14:54:40','2016-09-15 14:54:40',1);

UNLOCK TABLES;

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(5) DEFAULT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reset_date` timestamp NULL DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `idx_user_login` (`login`),
  UNIQUE KEY `idx_user_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

LOCK TABLES `user` WRITE;

insert  into `user`(`id`,`login`,`password`,`first_name`,`last_name`,`email`,`activated`,`lang_key`,`activation_key`,`reset_key`,`created_by`,`created_date`,`reset_date`,`last_modified_by`,`last_modified_date`) values (1,'system','$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG','System','System','system@localhost','','en','',NULL,'system','2016-08-18 22:43:25',NULL,NULL,NULL);
insert  into `user`(`id`,`login`,`password`,`first_name`,`last_name`,`email`,`activated`,`lang_key`,`activation_key`,`reset_key`,`created_by`,`created_date`,`reset_date`,`last_modified_by`,`last_modified_date`) values (2,'anonymousUser','$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO','Anonymous','User','anonymous@localhost','','en',NULL,NULL,'system','2016-04-18 20:50:05',NULL,NULL,NULL);
insert  into `user`(`id`,`login`,`password`,`first_name`,`last_name`,`email`,`activated`,`lang_key`,`activation_key`,`reset_key`,`created_by`,`created_date`,`reset_date`,`last_modified_by`,`last_modified_date`) values (3,'admin','$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC','Administrator','Administrator','admin@localhost','','en',NULL,NULL,'system','2016-04-18 20:50:05',NULL,NULL,NULL);
insert  into `user`(`id`,`login`,`password`,`first_name`,`last_name`,`email`,`activated`,`lang_key`,`activation_key`,`reset_key`,`created_by`,`created_date`,`reset_date`,`last_modified_by`,`last_modified_date`) values (4,'user','$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K','User','User','user@localhost','','en','123',NULL,'system','2016-08-18 22:43:29',NULL,NULL,NULL);
insert  into `user`(`id`,`login`,`password`,`first_name`,`last_name`,`email`,`activated`,`lang_key`,`activation_key`,`reset_key`,`created_by`,`created_date`,`reset_date`,`last_modified_by`,`last_modified_date`) values (5,'test','$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K','test','test','test@localhost','\0','zh',NULL,NULL,'system','2016-08-19 00:23:32',NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `user_role` */

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`role_id`),
  KEY `fk_role_id` (`role_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

LOCK TABLES `user_role` WRITE;

insert  into `user_role`(`id`,`user_id`,`role_id`) values (1,1,1);
insert  into `user_role`(`id`,`user_id`,`role_id`) values (3,1,2);
insert  into `user_role`(`id`,`user_id`,`role_id`) values (2,3,1);
insert  into `user_role`(`id`,`user_id`,`role_id`) values (4,3,2);
insert  into `user_role`(`id`,`user_id`,`role_id`) values (5,4,2);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
