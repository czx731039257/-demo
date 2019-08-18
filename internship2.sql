/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80003
 Source Host           : localhost:3306
 Source Schema         : internship2

 Target Server Type    : MySQL
 Target Server Version : 80003
 File Encoding         : 65001

 Date: 19/08/2019 01:25:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
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
-- Table structure for headportrait
-- ----------------------------
DROP TABLE IF EXISTS `headportrait`;
CREATE TABLE `headportrait`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `headportrait_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of headportrait
-- ----------------------------
INSERT INTO `headportrait` VALUES (9, 10, 'userhead/34ab55dd-be9f-4b8e-9f67-47bda70a9a3btest.png');
INSERT INTO `headportrait` VALUES (11, 10, 'userhead/749e3395-a6fd-4850-bc88-a81787e13708test.png');
INSERT INTO `headportrait` VALUES (12, 10, 'userhead/5280a5ac-5426-4c40-9ab0-337c03db5afbtest.png');
INSERT INTO `headportrait` VALUES (16, 10, 'userhead/fad04434-886c-48b5-a9fe-5cc9f2f33e2ctest.png');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `operation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` int(11) NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('admin', 10, '查看所有人的留言', 19, '成功', '2019-08-15 16:54:07');
INSERT INTO `log` VALUES ('admin', 10, '删除留言', 52, '成功', '2019-08-15 16:54:09');
INSERT INTO `log` VALUES ('admin', 10, '修改留言', 64, '成功', '2019-08-15 16:54:12');
INSERT INTO `log` VALUES ('admin', 10, '登入', 60, '成功', '2019-08-16 16:28:36');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 15, '成功', '2019-08-16 16:29:03');
INSERT INTO `log` VALUES ('admin', 10, '登入', 110, '成功', '2019-08-16 16:37:55');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 22, '成功', '2019-08-16 16:37:57');
INSERT INTO `log` VALUES ('admin', 10, '登入', 8, '成功', '2019-08-16 16:39:07');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 5, '成功', '2019-08-16 16:39:08');
INSERT INTO `log` VALUES ('admin', 10, '登入', 117, '成功', '2019-08-16 16:41:03');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 15, '成功', '2019-08-16 16:41:06');
INSERT INTO `log` VALUES ('admin', 10, '登入', 107, '成功', '2019-08-16 16:41:35');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 14, '成功', '2019-08-16 16:41:36');
INSERT INTO `log` VALUES ('admin', 10, '登入', 697, '成功', '2019-08-18 20:16:11');
INSERT INTO `log` VALUES ('admin', 10, '查看用户所在组的留言', 21, '成功', '2019-08-18 20:16:26');
INSERT INTO `log` VALUES ('admin', 10, '登入', 18, '成功', '2019-08-18 21:20:09');
INSERT INTO `log` VALUES ('admin', 10, '登入', 16, '成功', '2019-08-18 21:21:49');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 25, '成功', '2019-08-18 21:21:54');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 8, '成功', '2019-08-18 21:23:11');
INSERT INTO `log` VALUES ('admin', 10, '登入', 15, '成功', '2019-08-18 21:29:14');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 8, '成功', '2019-08-18 21:29:16');
INSERT INTO `log` VALUES ('admin', 10, '登入', 21, '成功', '2019-08-18 21:30:05');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 19, '成功', '2019-08-18 21:30:06');
INSERT INTO `log` VALUES ('admin', 10, '登入', 103, '成功', '2019-08-18 23:25:39');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 7, '成功', '2019-08-18 23:25:41');
INSERT INTO `log` VALUES ('admin', 10, '登入', 15, '成功', '2019-08-18 23:27:10');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 8, '成功', '2019-08-18 23:27:12');
INSERT INTO `log` VALUES ('admin', 10, '登入', 15, '成功', '2019-08-18 23:27:53');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 6, '成功', '2019-08-18 23:27:54');
INSERT INTO `log` VALUES ('admin', 10, '登入', 569, '成功', '2019-08-18 23:50:26');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 25, '成功', '2019-08-18 23:50:28');
INSERT INTO `log` VALUES ('admin', 10, '登入', 504, '成功', '2019-08-18 23:53:06');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 21, '成功', '2019-08-18 23:53:08');
INSERT INTO `log` VALUES ('admin', 10, '登入', 570, '成功', '2019-08-18 23:54:49');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 22, '成功', '2019-08-18 23:54:52');
INSERT INTO `log` VALUES ('admin', 10, '登入', 529, '成功', '2019-08-18 23:58:58');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 23, '成功', '2019-08-18 23:59:01');
INSERT INTO `log` VALUES ('admin', 10, '登入', 573, '成功', '2019-08-19 00:02:31');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 21, '成功', '2019-08-19 00:02:33');
INSERT INTO `log` VALUES ('admin', 10, '注销', 1, '成功', '2019-08-19 00:03:14');
INSERT INTO `log` VALUES ('admin', 10, '登入', 14, '成功', '2019-08-19 00:03:17');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 9, '成功', '2019-08-19 00:03:19');
INSERT INTO `log` VALUES ('admin', 10, '登入', 516, '成功', '2019-08-19 00:07:14');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 19, '成功', '2019-08-19 00:07:17');
INSERT INTO `log` VALUES ('admin', 10, '注销', 0, '成功', '2019-08-19 00:07:29');
INSERT INTO `log` VALUES ('admin', 10, '登入', 14, '成功', '2019-08-19 00:07:33');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 9, '成功', '2019-08-19 00:07:34');
INSERT INTO `log` VALUES ('admin', 10, '登入', 13, '成功', '2019-08-19 00:09:18');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 3, '成功', '2019-08-19 00:09:49');
INSERT INTO `log` VALUES ('admin', 10, '登入', 532, '成功', '2019-08-19 00:13:44');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 22, '成功', '2019-08-19 00:13:46');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 6, '成功', '2019-08-19 00:31:26');
INSERT INTO `log` VALUES ('admin', 10, '登入', 530, '成功', '2019-08-19 00:37:29');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 23, '成功', '2019-08-19 00:37:31');
INSERT INTO `log` VALUES ('admin', 10, '注销', 0, '成功', '2019-08-19 00:37:37');
INSERT INTO `log` VALUES ('admin', 10, '登入', 20, '成功', '2019-08-19 00:37:41');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 13, '成功', '2019-08-19 00:37:42');
INSERT INTO `log` VALUES ('admin', 10, '登入', 591, '成功', '2019-08-19 00:39:19');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 29, '成功', '2019-08-19 00:39:21');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 13, '成功', '2019-08-19 00:39:27');
INSERT INTO `log` VALUES ('admin', 10, '登入', 524, '成功', '2019-08-19 00:51:49');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 28, '成功', '2019-08-19 00:51:50');
INSERT INTO `log` VALUES ('admin', 10, '登入', 20, '成功', '2019-08-19 00:52:23');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 17, '成功', '2019-08-19 00:52:25');
INSERT INTO `log` VALUES ('admin', 10, '登入', 14, '成功', '2019-08-19 00:53:20');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 11, '成功', '2019-08-19 00:53:22');
INSERT INTO `log` VALUES ('admin', 10, '登入', 17, '成功', '2019-08-19 00:54:58');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 10, '成功', '2019-08-19 00:54:59');
INSERT INTO `log` VALUES ('admin', 10, '登入', 13, '成功', '2019-08-19 00:57:03');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 10, '成功', '2019-08-19 00:57:05');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 10, '成功', '2019-08-19 00:57:35');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 12, '成功', '2019-08-19 01:04:54');
INSERT INTO `log` VALUES ('admin', 10, '登入', 13, '成功', '2019-08-19 01:09:28');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 10, '成功', '2019-08-19 01:09:29');
INSERT INTO `log` VALUES ('admin', 10, '登入', 570, '成功', '2019-08-19 01:11:35');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 12, '成功', '2019-08-19 01:11:38');
INSERT INTO `log` VALUES ('admin', 10, '查看个人用户信息', 13, '成功', '2019-08-19 01:16:47');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `date_edit` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (7, '留言7', '留言7内容', '2019-08-07 09:00:04', '2019-08-07 09:00:04', 4);
INSERT INTO `message` VALUES (8, '留言8', '留言8内容', '2019-08-07 09:00:05', '2019-08-07 09:00:05', 4);
INSERT INTO `message` VALUES (10, '留言10', '留言10内容', '2019-08-07 09:00:07', '2019-08-15 16:54:12', 5);
INSERT INTO `message` VALUES (11, '留言11', '留言11内容', '2019-08-07 09:00:07', '2019-08-07 09:00:07', 6);
INSERT INTO `message` VALUES (13, '留言13', '留言13内容', '2019-08-07 09:00:09', '2019-08-07 09:00:09', 7);
INSERT INTO `message` VALUES (14, '留言14', '留言14内容', '2019-08-07 09:00:10', '2019-08-07 09:00:10', 7);
INSERT INTO `message` VALUES (15, '留言15', '留言15内容', '2019-08-07 09:00:11', '2019-08-07 09:00:11', 8);
INSERT INTO `message` VALUES (17, '留言17', '留言17内容', '2019-08-07 09:02:06', '2019-08-07 09:02:06', 9);
INSERT INTO `message` VALUES (18, '留言18', '留言18内容', '2019-08-07 09:02:08', '2019-08-07 09:02:08', 9);
INSERT INTO `message` VALUES (38, 'fdgdfg', 'nmsl22222', '2019-08-07 04:17:52', '2019-08-07 04:17:52', 2);
INSERT INTO `message` VALUES (39, 'zzzz', 'zzz1', '2019-08-07 04:17:56', '2019-08-09 08:51:52', 2);
INSERT INTO `message` VALUES (51, '11111', '111111', '2019-08-09 08:34:37', '2019-08-15 11:20:48', 10);
INSERT INTO `message` VALUES (56, 'test2', 'test2xx', '2019-08-13 01:54:50', '2019-08-13 02:02:41', 10);
INSERT INTO `message` VALUES (59, '=====111', 'zzzzzzzz11111', '2019-08-13 02:12:00', '2019-08-13 03:47:37', 10);
INSERT INTO `message` VALUES (60, 'nmsl', 'nmsl', '2019-08-14 04:11:12', '2019-08-14 04:11:12', 1);
INSERT INTO `message` VALUES (62, 'nmskll', 'nmsl', '2019-08-14 04:38:40', '2019-08-14 04:38:40', 1);
INSERT INTO `message` VALUES (63, '11111', '111111x', '2019-08-15 12:23:38', '2019-08-15 12:23:46', 1);
INSERT INTO `message` VALUES (64, 'xx', 'xx11', '2019-08-15 15:11:23', '2019-08-15 15:35:09', 10);

-- ----------------------------
-- Table structure for method
-- ----------------------------
DROP TABLE IF EXISTS `method`;
CREATE TABLE `method`  (
  `method_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `method_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`method_url`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of method
-- ----------------------------
INSERT INTO `method` VALUES ('allocationcontroller', '查看所有用户拥有的角色');
INSERT INTO `method` VALUES ('CancelUserController', '注销');
INSERT INTO `method` VALUES ('CreateMessageController', '新建留言');
INSERT INTO `method` VALUES ('DeleteMessageController', '删除留言');
INSERT INTO `method` VALUES ('EditMessageSuccessController', '修改留言');
INSERT INTO `method` VALUES ('editpermissioncontroller', '查看角色拥有的权限');
INSERT INTO `method` VALUES ('editpermissionsuccess', '编辑角色权限');
INSERT INTO `method` VALUES ('EditPersonInfoSuccessController', '编辑个人用户信息');
INSERT INTO `method` VALUES ('editrolesuccesscontroller', '编辑用户拥有的角色');
INSERT INTO `method` VALUES ('EditUserInfoSuccessController', '编辑用户信息');
INSERT INTO `method` VALUES ('LoginController', '登入');
INSERT INTO `method` VALUES ('PersonInfoController', '查看个人用户信息');
INSERT INTO `method` VALUES ('SelectAllMessageController', '查看所有人的留言');
INSERT INTO `method` VALUES ('SelectAllUserInfoController', '查看所有的用户信息');
INSERT INTO `method` VALUES ('SelectGroupMessageController', '查看用户所在组的留言');
INSERT INTO `method` VALUES ('SelectGroupUserInfoController', '查看同组用户信息');
INSERT INTO `method` VALUES ('SelectOtherGroupMessageController', '查看其他组的留言');
INSERT INTO `method` VALUES ('SelectOtherGroupUserInfoController', '查看其他组用户信息');
INSERT INTO `method` VALUES ('SelectPersonMessageController', '查看用户自己的留言');
INSERT INTO `method` VALUES ('selectrole', '查看所有角色');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
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
INSERT INTO `permission` VALUES (18, '查看日志');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
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
INSERT INTO `role_permission` VALUES (2, 9);
INSERT INTO `role_permission` VALUES (2, 12);
INSERT INTO `role_permission` VALUES (3, 3);
INSERT INTO `role_permission` VALUES (3, 10);
INSERT INTO `role_permission` VALUES (3, 13);
INSERT INTO `role_permission` VALUES (3, 17);
INSERT INTO `role_permission` VALUES (2, 2);
INSERT INTO `role_permission` VALUES (2, 6);
INSERT INTO `role_permission` VALUES (2, 16);
INSERT INTO `role_permission` VALUES (1, 5);
INSERT INTO `role_permission` VALUES (1, 7);
INSERT INTO `role_permission` VALUES (1, 8);
INSERT INTO `role_permission` VALUES (1, 15);
INSERT INTO `role_permission` VALUES (3, 12);
INSERT INTO `role_permission` VALUES (1, 11);
INSERT INTO `role_permission` VALUES (1, 4);
INSERT INTO `role_permission` VALUES (1, 14);
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (3, 18);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `test_id` int(11) NOT NULL,
  PRIMARY KEY (`test_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (0);
INSERT INTO `test` VALUES (1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `group_id` int(11) NOT NULL,
  `headportrait_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `group_id`(`group_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aa', 'aa', 'aaz', '1111xa', 1, 0);
INSERT INTO `user` VALUES (2, 'bb', 'bb', 'bb', 'b11x', 1, 0);
INSERT INTO `user` VALUES (3, 'cc', 'cc', 'cc', 'cczxx', 1, 0);
INSERT INTO `user` VALUES (4, 'dd', 'dd', 'dd', 'dd', 2, 0);
INSERT INTO `user` VALUES (5, 'ee', 'ee', 'ee', 'ee', 2, 0);
INSERT INTO `user` VALUES (6, 'ff', 'ff', 'ff', 'ff', 2, 0);
INSERT INTO `user` VALUES (7, 'gg', 'gg', 'gg', ' xx', 3, 0);
INSERT INTO `user` VALUES (8, 'hh', 'hh', 'hh你你', 'hh', 3, 0);
INSERT INTO `user` VALUES (9, 'ii', 'ii', 'ii', 'xx', 3, 0);
INSERT INTO `user` VALUES (10, 'admin', 'admin', 'admin搜索', '121212', 4, 16);

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
