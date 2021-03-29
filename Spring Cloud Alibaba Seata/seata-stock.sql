/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : seata-stock

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2021-03-28 22:18:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_stock`
-- ----------------------------
DROP TABLE IF EXISTS `s_stock`;
CREATE TABLE `s_stock` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(30) DEFAULT NULL,
  `item_num` int(3) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_stock
-- ----------------------------

-- ----------------------------
-- Table structure for `undo_log`
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
