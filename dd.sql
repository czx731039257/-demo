/*
SQLyog Professional v12.08 (32 bit)
MySQL - 5.7.26 : Database - sis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sis`;

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `monitor_id` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `instructor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `monitor_id` (`monitor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `class` */

insert  into `class`(`id`,`name`,`monitor_id`,`number`,`instructor`) values (1,'计算机1班',1,4,'王辅导员'),(2,'化学1班',2,4,'李辅导员'),(3,'生物1班',4,3,'邱辅导员');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `classroom` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `course` */

insert  into `course`(`id`,`name`,`classroom`,`date`,`credit`,`teacher_id`) values (1,'算法与数据结构','东三100','周三 第2节',2,3),(2,'计算机组成原理','东二200','周二 第4节',3,3),(3,'计算机网络','东二201','周二 第2节',2,1),(4,'数据库','西二302','周二 第1节',2,1),(5,'无机化学','西一102','周四 第1节',2,2),(6,'分析化学','西二201','周四 第2节',3,2),(7,'有机化学','西二302','周四 第3节',2,4),(8,'动物学','东一301','周一 第2节',3,4),(9,'植物学','东一201','周一 第3节',2,5),(10,'细胞学','东一202','周一 第4节',2,5),(11,'生物信息学','东一102','周一 第1节',3,2);

/*Table structure for table `sc` */

DROP TABLE IF EXISTS `sc`;

CREATE TABLE `sc` (
  `student_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sc` */

insert  into `sc`(`student_id`,`course_id`,`grade`) values (1,2,100),(1,2,100),(2,1,100),(2,1,100),(3,3,100),(3,3,100),(4,5,100),(4,5,100),(5,7,100),(5,7,100);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`sex`,`age`,`major`,`phone`,`class_id`) values (1,'张三','男',20,'计算机','1234561',1),(2,'李四','男',21,'化学','123456',2),(3,'王五','男',21,'化学','12345611',2),(4,'小明','男',21,'生物','123456',3),(5,'小红','女',22,'计算机','123456',1),(6,'老六','男',22,'生物','123456',3),(7,'陈二','男',22,'计算机','123456',1),(8,'刘三','男',23,'化学','123456',2),(9,'孙某','男',23,'生物','123456',3),(10,'李三','男',23,'计算机','123456',1),(11,'王四','男',23,'化学','123123',2),(12,'1','女',23,'化学','123456',2);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`name`,`sex`,`age`,`phone`) values (3,'孙老师','男',31,'123456'),(1,'陈老师','男',30,'123456'),(2,'李老师','女',30,'123456'),(4,'王老师','女',32,'123456'),(5,'叶老师','男',35,'12345623');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`username`,`password`) values ('admin','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
