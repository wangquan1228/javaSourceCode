/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-03-26 12:06:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `gender` varchar(16) NOT NULL,
  `card` varchar(32) NOT NULL,
  `room_id` int(11) NOT NULL,
  `in_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pay_price` int(11) NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_room_customer` (`room_id`),
  CONSTRAINT `fk_room_customer` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('16', '王全', '男', '4211223199612344318', '101', '2018-03-25 18:02:45', '300', '无');
INSERT INTO `customer` VALUES ('17', '茉莉', '男', '32123132344456777', '102', '2018-03-25 18:03:12', '300', '来个大保健');
INSERT INTO `customer` VALUES ('18', '李冉', '男', '24563464575889', '103', '2018-03-25 18:03:50', '300', '来来大保健');
INSERT INTO `customer` VALUES ('19', '老郭', '男', '2467283489759-', '104', '2018-03-25 18:04:29', '300', '来三个大保健');
INSERT INTO `customer` VALUES ('20', '老蔡', ' 男', '3543668990875', '201', '2018-03-25 18:08:09', '200', '来 五个大保健');
INSERT INTO `customer` VALUES ('21', '老邢', '男', '4212231234408', '203', '2018-03-25 18:14:53', '200', '来个6个大保健');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `room_name` varchar(16) NOT NULL,
  `room_type` varchar(16) NOT NULL,
  `room_price` int(11) NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('101', '梅花', '豪华', '300', '无');
INSERT INTO `room` VALUES ('102', '兰花', '豪华', '300', '有');
INSERT INTO `room` VALUES ('103', '紫竹', '豪华', '300', '有');
INSERT INTO `room` VALUES ('104', '青松', '豪华', '300', '有');
INSERT INTO `room` VALUES ('201', '琴', '普通', '200', '有');
INSERT INTO `room` VALUES ('202', '棋', '普通', '200', '有');
INSERT INTO `room` VALUES ('203', '书', '普通', '200', '有');
INSERT INTO `room` VALUES ('204', '画', '普通', '200', '有');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL,
  `account` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `mobile` varchar(16) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王全', 'wq', '234', '15090115992', '0', '2018-03-24 21:24:19');
INSERT INTO `user` VALUES ('2', '茉莉', 'ml', '123', '15090117233', '0', '2018-03-25 18:21:57');
