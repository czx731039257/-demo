/*
SQLyog Enterprise v12.08 (32 bit)
MySQL - 8.0.3-rc-log : Database - internship2
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

/*Table structure for table `billitem` */

DROP TABLE IF EXISTS `billitem`;

CREATE TABLE `billitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `money` double(7,2) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `billitem_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;

/*Data for the table `billitem` */

insert  into `billitem`(`id`,`type`,`money`,`user_id`,`date`) values (182,'充值',1.00,10,'2019-08-23 09:49:06'),(183,'充值',1.01,10,'2019-08-23 09:49:22'),(184,'消费',1.01,10,'2019-08-23 09:49:41'),(185,'收到打赏',1.01,4,'2019-08-23 09:49:41'),(186,'充值',1.00,10,'2019-08-23 22:07:29'),(187,'消费',1.00,10,'2019-08-23 22:07:37'),(188,'收到打赏',1.00,1,'2019-08-23 22:07:37'),(189,'充值',1.00,10,'2019-08-23 23:11:45');

/*Table structure for table `group` */

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `group` */

insert  into `group`(`id`,`name`) values (1,'组一'),(2,'组二'),(3,'组三'),(4,'超级管理员组');

/*Table structure for table `head` */

DROP TABLE IF EXISTS `head`;

CREATE TABLE `head` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `head_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `head` */

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `user_id` int(11) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `log` */

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
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `message` */

insert  into `message`(`id`,`label`,`detail`,`date_create`,`date_edit`,`user_id`) values (68,'xx','x','2019-08-20 13:45:12','2019-08-20 13:45:12',10),(71,'ss','x','2019-08-22 10:54:12','2019-08-22 10:54:12',1),(73,'asd','xx','2019-08-22 14:17:59','2019-08-22 14:17:59',1),(74,'asdasd','xasd','2019-08-22 14:18:06','2019-08-22 14:18:06',1),(75,'asd','asd','2019-08-22 14:18:09','2019-08-22 14:18:09',1),(77,'1','111111','2019-08-22 14:51:03','2019-08-22 14:51:03',1),(78,'asd','111','2019-08-22 16:24:46','2019-08-22 16:24:46',10),(79,'asd','11','2019-08-23 15:29:06','2019-08-23 15:29:06',10),(80,'asd','1155','2019-08-23 15:33:27','2019-08-23 15:33:27',10),(81,'asd','11','2019-08-23 15:29:19','2019-08-23 15:29:19',10),(82,'asd','11','2019-08-23 15:29:19','2019-08-23 15:29:19',10),(85,'asd','asdasdccc','2019-08-23 15:32:42','2019-08-23 15:32:42',10);

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
  `money` double(7,2) DEFAULT NULL,
  `count_message` int(11) DEFAULT '0',
  `head_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `group_id` (`group_id`) USING BTREE,
  KEY `head_id` (`head_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`head_id`) REFERENCES `head` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`email`,`phone`,`group_id`,`money`,`count_message`,`head_id`) values (1,'aa','aa','aaz','1111xa',1,1.00,0,NULL),(2,'bb','bb','bb2','b11x',1,0.00,0,NULL),(3,'cc4','cc','cc','cczxx',1,0.00,0,NULL),(4,'dd','dd','dd','dd',2,1.01,0,NULL),(5,'ee','ee','ee','ee',2,0.00,0,NULL),(6,'ff','ff','ff','ff',2,0.00,0,NULL),(7,'gg','gg','gg',' xx',3,0.00,0,NULL),(8,'hh','hh','hh你你','hh',3,0.00,0,NULL),(9,'ii','ii','ii','xx',3,0.00,0,NULL),(10,'admin','admin','admin搜索x','1212111xccc',4,2.00,0,NULL);

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
