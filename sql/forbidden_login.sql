/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.30.13
 Source Server Type    : MySQL
 Source Server Version : 100312
 Source Host           : 192.168.30.13:3306
 Source Schema         : eports_dev

 Target Server Type    : MySQL
 Target Server Version : 100312
 File Encoding         : 65001

 Date: 24/09/2019 15:00:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for forbidden_login
-- ----------------------------
DROP TABLE IF EXISTS `forbidden_login`;
CREATE TABLE `forbidden_login`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家',
  `account_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip状态/0是黑名单，1是解除黑名单',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forbidden_login
-- ----------------------------
INSERT INTO `forbidden_login` VALUES ('0084cc34a61f471fb37ccd6db6501891', 'chen_12@163.com', NULL, '2019-09-05 13:48:58', '0');
INSERT INTO `forbidden_login` VALUES ('bf85201c47a7492fb654b2218ce445f0', '18511793709@163.com', 'xingchen', '2019-09-11 10:42:01', '0');

SET FOREIGN_KEY_CHECKS = 1;
