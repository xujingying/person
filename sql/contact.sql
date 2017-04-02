/*
Navicat MySQL Data Transfer

Source Server         : home-mysql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : person

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-04-02 23:23:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `age` int(5) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `address` varchar(300) DEFAULT NULL COMMENT '家庭地址',
  `insert_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
