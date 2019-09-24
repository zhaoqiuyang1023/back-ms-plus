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

 Date: 24/09/2019 15:00:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for forbidden_ip
-- ----------------------------
DROP TABLE IF EXISTS `forbidden_ip`;
CREATE TABLE `forbidden_ip`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家',
  `date_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `date_update` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `ip_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip状态/0是黑名单，1是解除黑名单',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forbidden_ip
-- ----------------------------
INSERT INTO `forbidden_ip` VALUES ('1d5ccb6d608a4043b5d124c0690fa636', 'Japan', '2019-09-05 13:15:26', '2019-09-05 13:15:26', '0', '157.69.45.6');
INSERT INTO `forbidden_ip` VALUES ('322ad2bbe67f4131b399ac5a90e21736', 'India', '2019-09-05 13:14:28', '2019-09-05 13:14:28', '0', '122.168.30.119');
INSERT INTO `forbidden_ip` VALUES ('58416162edfd4b7db964de187b78a8d0', 'Australia', '2019-09-05 13:16:20', '2019-09-05 13:16:20', '0', '122.148.30.11');
INSERT INTO `forbidden_ip` VALUES ('74c854df6baa4dc0a0ade429894e24d4', 'United States', '2019-09-05 13:15:44', '2019-09-05 13:15:44', '0', '154.26.35.89');
INSERT INTO `forbidden_ip` VALUES ('77e848a51ae347d1b818502dffbd7291', NULL, '2019-09-05 13:14:21', '2019-09-05 13:14:21', '0', '192.168.10.119');
INSERT INTO `forbidden_ip` VALUES ('935bac3eba384a49b13baa123bfb39fc', 'China', '2019-09-05 13:14:50', '2019-09-05 13:14:50', '0', '42.168.30.119');
INSERT INTO `forbidden_ip` VALUES ('9b0b9e6ac2334af79ad276f8268f67a1', 'United States', '2019-09-05 13:43:40', '2019-09-05 13:43:40', '0', '166.228.5.22');
INSERT INTO `forbidden_ip` VALUES ('b48f83070b2749f990927607c353a9e0', 'United States', '2019-09-05 13:15:05', '2019-09-05 13:15:05', '0', '142.168.30.119');
INSERT INTO `forbidden_ip` VALUES ('b7c68579e72e47a6ae27bdc1f42b3c09', NULL, '2019-09-05 13:14:59', '2019-09-05 13:14:59', '0', '192.168.120.119');
INSERT INTO `forbidden_ip` VALUES ('b97db05c91b3424c9f74ef8c7c707684', 'France', '2019-09-05 13:14:34', '2019-09-05 13:14:34', '0', '92.168.30.119');
INSERT INTO `forbidden_ip` VALUES ('d24eacbeafbf4a77b409ad66e9af8ee1', 'United States', '2019-09-05 13:15:19', '2019-09-05 13:15:19', '0', '156.26.36.55');
INSERT INTO `forbidden_ip` VALUES ('e4dc65ee708c4767800dc89ddc2ed61e', 'China', '2019-09-05 13:14:40', '2019-09-05 13:14:40', '0', '123.168.30.119');

SET FOREIGN_KEY_CHECKS = 1;
