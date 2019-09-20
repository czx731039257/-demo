/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : internship2

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 09/08/2019 08:59:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES (1, '组一');
INSERT INTO `group` VALUES (2, '组二');
INSERT INTO `group` VALUES (3, '组三');
INSERT INTO `group` VALUES (4, '超级管理员组');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date_create` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `date_edit` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '留言1', '留言1内容', '2019-08-07 09:00:24', '2019-08-07 09:00:24', 1);
INSERT INTO `message` VALUES (2, '留言2', '留言2内容', '2019-08-07 09:00:26', '2019-08-07 09:00:26', 1);
INSERT INTO `message` VALUES (3, '留言3', '留言3内容', '2019-08-07 09:00:28', '2019-08-07 09:00:28', 2);
INSERT INTO `message` VALUES (4, '留言4', '留言4内容', '2019-08-07 09:00:34', '2019-08-07 09:00:34', 2);
INSERT INTO `message` VALUES (7, '留言7', '留言7内容', '2019-08-07 09:00:04', '2019-08-07 09:00:04', 4);
INSERT INTO `message` VALUES (8, '留言8', '留言8内容', '2019-08-07 09:00:05', '2019-08-07 09:00:05', 4);
INSERT INTO `message` VALUES (9, '留言9', '留言9内容', '2019-08-07 09:00:06', '2019-08-07 09:00:06', 5);
INSERT INTO `message` VALUES (10, '留言10', '留言10内容', '2019-08-07 09:00:07', '2019-08-07 09:00:07', 5);
INSERT INTO `message` VALUES (11, '留言11', '留言11内容', '2019-08-07 09:00:07', '2019-08-07 09:00:07', 6);
INSERT INTO `message` VALUES (13, '留言13', '留言13内容', '2019-08-07 09:00:09', '2019-08-07 09:00:09', 7);
INSERT INTO `message` VALUES (14, '留言14', '留言14内容', '2019-08-07 09:00:10', '2019-08-07 09:00:10', 7);
INSERT INTO `message` VALUES (15, '留言15', '留言15内容', '2019-08-07 09:00:11', '2019-08-07 09:00:11', 8);
INSERT INTO `message` VALUES (16, '留言16', '留言16内容', '2019-08-07 09:00:12', '2019-08-07 09:00:12', 8);
INSERT INTO `message` VALUES (17, '留言17', '留言17内容', '2019-08-07 09:02:06', '2019-08-07 09:02:06', 9);
INSERT INTO `message` VALUES (18, '留言18', '留言18内容', '2019-08-07 09:02:08', '2019-08-07 09:02:08', 9);
INSERT INTO `message` VALUES (34, 'czx', 'nmsl22222', '2019-08-07 01:51:08', '2019-08-07 01:51:08', 1);
INSERT INTO `message` VALUES (38, 'fdgdfg', 'nmsl22222', '2019-08-07 04:17:52', '2019-08-07 04:17:52', 2);
INSERT INTO `message` VALUES (39, 'zzzz', 'zzz1', '2019-08-07 04:17:56', '2019-08-09 08:51:52', 2);
INSERT INTO `message` VALUES (43, 'asd', 'asd', '2019-08-08 01:55:13', '2019-08-08 01:55:13', 1);
INSERT INTO `message` VALUES (44, 'fdgdfg', 'asdad', '2019-08-08 01:55:23', '2019-08-08 01:55:23', 1);
INSERT INTO `message` VALUES (45, 'zxc', 'zxc', '2019-08-08 05:31:50', '2019-08-08 05:31:50', 1);
INSERT INTO `message` VALUES (46, 'zzzz', 'zzz', '2019-08-08 05:31:53', '2019-08-08 05:31:53', 1);
INSERT INTO `message` VALUES (47, 'aa', 'aa', '2019-08-08 05:31:56', '2019-08-08 05:31:56', 1);
INSERT INTO `message` VALUES (48, 'ss', 'ss', '2019-08-08 05:32:00', '2019-08-08 05:32:00', 1);
INSERT INTO `message` VALUES (49, 'zz', 'zz', '2019-08-08 05:32:17', '2019-08-08 05:32:17', 1);
INSERT INTO `message` VALUES (51, '11111', '1', '2019-08-09 08:34:37', '2019-08-09 08:34:37', 10);
INSERT INTO `message` VALUES (52, 'zxc', 'z', '2019-08-09 08:43:44', '2019-08-09 08:43:44', 10);
INSERT INTO `message` VALUES (53, '0', '00', '2019-08-09 08:52:06', '2019-08-09 08:52:06', 1);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '编辑自己的用户信息');
INSERT INTO `permission` VALUES (2, '编辑所在用户组的人的用户信息');
INSERT INTO `permission` VALUES (3, '编辑其他用户组的人的用户信息');
INSERT INTO `permission` VALUES (4, '浏览自己的用户信息');
INSERT INTO `permission` VALUES (5, '浏览所在用户组的人的用户信息');
INSERT INTO `permission` VALUES (6, '浏览其他用户组的人的用户信息');
INSERT INTO `permission` VALUES (7, '新建留言');
INSERT INTO `permission` VALUES (8, '删除自己的留言');
INSERT INTO `permission` VALUES (9, '删除所在用户组的人的留言');
INSERT INTO `permission` VALUES (10, '删除其他用户组的人的留言');
INSERT INTO `permission` VALUES (11, '编辑自己的留言');
INSERT INTO `permission` VALUES (12, '编辑所在用户组的人的留言');
INSERT INTO `permission` VALUES (13, '编辑其他用户组的人的留言');
INSERT INTO `permission` VALUES (14, '浏览自己的留言');
INSERT INTO `permission` VALUES (15, '浏览所在组的人的留言');
INSERT INTO `permission` VALUES (16, '浏览其他组的人的留言');
INSERT INTO `permission` VALUES (17, '给用户分配角色和权限');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '普通用户');
INSERT INTO `role` VALUES (2, '组长');
INSERT INTO `role` VALUES (3, '超级管理员');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `permission_id`(`permission_id`) USING BTREE,
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 4);
INSERT INTO `role_permission` VALUES (1, 5);
INSERT INTO `role_permission` VALUES (1, 8);
INSERT INTO `role_permission` VALUES (1, 11);
INSERT INTO `role_permission` VALUES (1, 14);
INSERT INTO `role_permission` VALUES (2, 9);
INSERT INTO `role_permission` VALUES (2, 12);
INSERT INTO `role_permission` VALUES (2, 16);
INSERT INTO `role_permission` VALUES (3, 3);
INSERT INTO `role_permission` VALUES (3, 10);
INSERT INTO `role_permission` VALUES (3, 13);
INSERT INTO `role_permission` VALUES (3, 17);
INSERT INTO `role_permission` VALUES (1, 15);
INSERT INTO `role_permission` VALUES (2, 2);
INSERT INTO `role_permission` VALUES (2, 6);
INSERT INTO `role_permission` VALUES (1, 7);
INSERT INTO `role_permission` VALUES (1, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `group_id`(`group_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aa', 'aa', 'aa', 'aanew', 1);
INSERT INTO `user` VALUES (2, 'bb', 'bb', 'bb', 'b11', 1);
INSERT INTO `user` VALUES (3, 'cc', 'cc', 'cc', 'ccz', 1);
INSERT INTO `user` VALUES (4, 'dd', 'dd', 'dd', 'dd', 2);
INSERT INTO `user` VALUES (5, 'ee', 'ee', 'ee', 'ee', 2);
INSERT INTO `user` VALUES (6, 'ff', 'ff', 'ff', 'ff', 2);
INSERT INTO `user` VALUES (7, 'gg', 'gg', 'gg', ' xx', 3);
INSERT INTO `user` VALUES (8, 'hh', 'hh', 'hh', 'hh', 3);
INSERT INTO `user` VALUES (9, 'ii', 'ii', 'ii', 'xx', 3);
INSERT INTO `user` VALUES (10, 'admin', 'admin', 'admin', 'admin', 4);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (1, 2);
INSERT INTO `user_role` VALUES (2, 1);
INSERT INTO `user_role` VALUES (3, 1);
INSERT INTO `user_role` VALUES (5, 1);
INSERT INTO `user_role` VALUES (4, 2);
INSERT INTO `user_role` VALUES (4, 1);
INSERT INTO `user_role` VALUES (6, 1);
INSERT INTO `user_role` VALUES (7, 1);
INSERT INTO `user_role` VALUES (7, 2);
INSERT INTO `user_role` VALUES (8, 1);
INSERT INTO `user_role` VALUES (9, 1);
INSERT INTO `user_role` VALUES (10, 1);
INSERT INTO `user_role` VALUES (10, 3);
INSERT INTO `user_role` VALUES (10, 2);

SET FOREIGN_KEY_CHECKS = 1;
