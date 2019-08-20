/*
SQLyog Professional v12.08 (32 bit)
MySQL - 5.7.26 : Database - internship2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`internship2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `internship2`;

/*Table structure for table `bill` */

DROP TABLE IF EXISTS `bill`;

CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bill` */

/*Table structure for table `group` */

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `group` */

insert  into `group`(`id`,`name`) values (1,'组一'),(2,'组二'),(3,'组三'),(4,'超级管理员组');

/*Table structure for table `headportrait` */

DROP TABLE IF EXISTS `headportrait`;

CREATE TABLE `headportrait` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `headportrait_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `headportrait` */

insert  into `headportrait`(`id`,`user_id`,`image_url`) values (39,10,'userhead/d206359e-922c-4582-b74b-7d5bbcd60518b97b7ad1e78cbe0dd12780ea3fea3f3a.jpg'),(40,10,'userhead/3034c136-bceb-4c12-9fdc-e036f0659ce975cfed6c7ef5ac81c0786e7fe44574f8.jpg');

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `user_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `log` */

insert  into `log`(`user_name`,`user_id`,`operation`,`time`,`result`,`date`) values ('admin',10,'查看用户自己的留言',4,'成功','2019-08-20 13:44:32'),('admin',10,'查看用户所在组的留言',1,'成功','2019-08-20 13:44:33'),('admin',10,'查看其他组的留言',7,'成功','2019-08-20 13:44:33'),('admin',10,'查看所有人的留言',4,'成功','2019-08-20 13:44:34'),('admin',10,'查看所有的用户信息',14,'成功','2019-08-20 13:44:34'),('admin',10,'查看同组用户信息',3,'成功','2019-08-20 13:44:36'),('admin',10,'查看个人用户信息',2,'成功','2019-08-20 13:44:38'),('admin',10,'删除留言',41,'成功','2019-08-20 13:44:48'),('admin',10,'修改留言',98,'成功','2019-08-20 13:44:51'),('admin',10,'查看个人用户信息',3,'成功','2019-08-20 13:44:55'),('admin',10,'编辑个人用户信息',65,'成功','2019-08-20 13:44:59'),('admin',10,'新建留言',65,'成功','2019-08-20 13:45:12'),('admin',10,'查看个人用户信息',8,'成功','2019-08-20 15:49:16'),('admin',10,'查看个人用户信息',7,'成功','2019-08-20 16:34:02'),('admin',10,'查看个人用户信息',8,'成功','2019-08-20 16:34:57'),('admin',10,'查看个人用户信息',9,'成功','2019-08-20 16:36:32'),('admin',10,'查看其他组的留言',8,'成功','2019-08-20 16:50:45'),('admin',10,'查看用户自己的留言',3,'成功','2019-08-20 16:50:50'),('admin',10,'查看其他组的留言',3,'成功','2019-08-20 16:50:53'),('admin',10,'查看其他组的留言',8,'成功','2019-08-20 17:15:02'),('admin',10,'查看其他组的留言',11,'成功','2019-08-20 17:16:11'),('admin',10,'查看所有人的留言',10,'成功','2019-08-20 17:20:11'),('admin',10,'查看其他组的留言',9,'成功','2019-08-20 17:21:45'),('admin',10,'查看其他组的留言',7,'成功','2019-08-20 17:23:36'),('admin',10,'查看其他组的留言',12,'成功','2019-08-20 17:25:47');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `date_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `date_edit` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `message` */

insert  into `message`(`id`,`label`,`detail`,`date_create`,`date_edit`,`user_id`) values (7,'留言7','留言7内容','2019-08-07 09:00:04','2019-08-07 09:00:04',4),(8,'留言8','留言8内容','2019-08-07 09:00:05','2019-08-07 09:00:05',4),(10,'留言10','留言10内容','2019-08-07 09:00:07','2019-08-15 16:54:12',5),(11,'留言11','留言11内容','2019-08-07 09:00:07','2019-08-07 09:00:07',6),(13,'留言13','留言13内容','2019-08-07 09:00:09','2019-08-07 09:00:09',7),(14,'留言14','留言14内容','2019-08-07 09:00:10','2019-08-07 09:00:10',7),(17,'留言17','留言17内容3','2019-08-07 09:02:06','2019-08-20 13:44:51',9),(38,'fdgdfg','nmsl22222','2019-08-07 04:17:52','2019-08-07 04:17:52',2),(39,'zzzz','zzz1','2019-08-07 04:17:56','2019-08-09 08:51:52',2),(56,'test2','test2xx','2019-08-13 01:54:50','2019-08-13 02:02:41',10),(59,'=====111','zzzzzzzz11111','2019-08-13 02:12:00','2019-08-13 03:47:37',10),(60,'nmsl','nmsl','2019-08-14 04:11:12','2019-08-14 04:11:12',1),(62,'nmskll','nmsl','2019-08-14 04:38:40','2019-08-14 04:38:40',1),(63,'11111','111111x','2019-08-15 12:23:38','2019-08-15 12:23:46',1),(64,'xx','xx1112','2019-08-15 15:11:23','2019-08-20 10:34:41',10),(65,'x','x','2019-08-19 16:29:27','2019-08-19 16:29:27',3),(66,'fdgdfg','asd','2019-08-19 17:00:58','2019-08-19 17:00:58',1),(68,'xx','x','2019-08-20 13:45:12','2019-08-20 13:45:12',10);

/*Table structure for table `method` */

DROP TABLE IF EXISTS `method`;

CREATE TABLE `method` (
  `method_url` varchar(255) NOT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`method_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `method` */

insert  into `method`(`method_url`,`method_name`) values ('createMessage','新建留言'),('deleteMessage','删除留言'),('editMessageSuccess','修改留言'),('editPersonInfoSuccess','编辑个人用户信息'),('editRoleHasPermissionsSuccess','编辑角色权限'),('editUserInfoSuccess','编辑用户信息'),('editUsersHaveRolesSuccess','编辑用户拥有的角色'),('intoEditRolesHavePermissions','查看角色拥有的权限'),('intoEditUsersHasRoles','查看所有用户拥有的角色'),('loginVerify','登入'),('logout','注销'),('queryAllMessage','查看所有人的留言'),('queryAllRoles','查看所有角色'),('queryAllUserInfo','查看所有的用户信息'),('queryOtherGroupMessage','查看其他组的留言'),('queryOtherGroupUserInfo','查看其他组用户信息'),('queryPersonInfo','查看个人用户信息'),('queryPersonMessage','查看用户自己的留言'),('querySameGroupMessage','查看用户所在组的留言'),('querySameGroupUserInfo','查看同组用户信息');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `permission` */

insert  into `permission`(`id`,`name`) values (1,'编辑自己的用户信息'),(2,'编辑所在用户组的人的用户信息'),(3,'编辑其他用户组的人的用户信息'),(4,'浏览自己的用户信息'),(5,'浏览所在用户组的人的用户信息'),(6,'浏览其他用户组的人的用户信息'),(7,'新建留言'),(8,'删除自己的留言'),(9,'删除所在用户组的人的留言'),(10,'删除其他用户组的人的留言'),(11,'编辑自己的留言'),(12,'编辑所在用户组的人的留言'),(13,'编辑其他用户组的人的留言'),(14,'浏览自己的留言'),(15,'浏览所在组的人的留言'),(16,'浏览其他组的人的留言'),(17,'给用户分配角色和权限'),(18,'查看日志');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'普通用户'),(2,'组长'),(3,'超级管理员');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  KEY `role_id` (`role_id`) USING BTREE,
  KEY `permission_id` (`permission_id`) USING BTREE,
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `role_permission` */

insert  into `role_permission`(`role_id`,`permission_id`) values (2,9),(2,12),(3,3),(3,10),(3,13),(3,17),(2,2),(2,6),(2,16),(1,5),(1,7),(1,8),(1,15),(3,12),(1,11),(1,4),(1,14),(3,18),(1,1);

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `test_id` int(11) NOT NULL,
  PRIMARY KEY (`test_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `test` */

insert  into `test`(`test_id`) values (0),(1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `group_id` int(11) NOT NULL,
  `headportrait_id` int(11) DEFAULT NULL,
  `money` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `group_id` (`group_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`email`,`phone`,`group_id`,`headportrait_id`,`money`) values (1,'aa','aa','aaz','1111xa',1,0,-30),(2,'bb','bb','bb','b11x',1,0,0),(3,'cc','cc','cc','cczxx',1,0,0),(4,'dd','dd','dd','dd',2,0,0),(5,'ee','ee','ee','ee',2,0,0),(6,'ff','ff','ff','ff',2,0,0),(7,'gg','gg','gg',' xx',3,0,0),(8,'hh','hh','hh你你','hh',3,0,0),(9,'ii','ii','ii','xx',3,0,0),(10,'admin','admin','admin搜索x','1212111x',4,40,80);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (1,1),(1,2),(2,1),(3,1),(5,1),(4,2),(4,1),(6,1),(7,1),(7,2),(8,1),(9,1),(10,1),(10,3),(10,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
