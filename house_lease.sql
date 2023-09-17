/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50704
Source Host           : localhost:3306
Source Database       : house_lease

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2023-03-25 20:55:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('3', 'mingli', '123456');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('3', '毛坯房', '2022-12-20 14:30:32');
INSERT INTO `tb_category` VALUES ('4', '精装修', '2022-12-20 14:30:37');
INSERT INTO `tb_category` VALUES ('5', '豪华房', '2022-12-20 14:30:51');

-- ----------------------------
-- Table structure for tb_house
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_desc` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `house_area` int(11) DEFAULT NULL,
  `house_floor` varchar(255) DEFAULT NULL,
  `house_type` varchar(255) DEFAULT NULL,
  `house_price` int(11) DEFAULT NULL,
  `house_address` varchar(255) DEFAULT NULL,
  `house_plot` varchar(255) DEFAULT NULL,
  `house_tel` varchar(255) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `publisher_time` datetime DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `poster` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES ('3', '绿地未来城18栋1006', '4', '100', '5楼', '三室一厅', '1050', 'XX市XXX县', '绿地未来城', '17681182996', '2', '2022-12-20 21:35:50', '104.20', '30.56', 'http://localhost:8081/upload/74a85d6d-6f63-4468-a635-88b81eb4bbc1.png');
INSERT INTO `tb_house` VALUES ('5', '11', '5', '22', '33', '44', '55', '66', '77', '88', '3', '2022-12-21 19:52:29', '104.10', '30.57', 'http://localhost:8081/upload/74a85d6d-6f63-4468-a635-88b81eb4bbc1.png');
INSERT INTO `tb_house` VALUES ('6', '1', '4', '2', '3', '4', '5', '6', '7', '8', '2', '2023-03-20 12:20:13', '104.30', '30.58', 'http://localhost:8081/upload/74a85d6d-6f63-4468-a635-88b81eb4bbc1.png');
INSERT INTO `tb_house` VALUES ('7', '2', '3', '3', '4', '5', '6', '7', '1', '8', null, '2023-03-24 22:32:53', '104.05', '30.59', 'http://localhost:8081/upload/74a85d6d-6f63-4468-a635-88b81eb4bbc1.png');

-- ----------------------------
-- Table structure for tb_liuyan
-- ----------------------------
DROP TABLE IF EXISTS `tb_liuyan`;
CREATE TABLE `tb_liuyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `comment` varchar(1000) DEFAULT NULL,
  `submitdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_liuyan
-- ----------------------------
INSERT INTO `tb_liuyan` VALUES ('3', '1', '规划性', 'asdfasdfasd', '2023-03-22 12:09:08');
INSERT INTO `tb_liuyan` VALUES ('4', '1', '指导性', 'asdfadsf', '2023-03-22 19:42:03');
INSERT INTO `tb_liuyan` VALUES ('5', '1', '建设性', '阿斯顿发山东', '2023-03-25 20:36:32');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('9', '6', '1', '2023-03-22 19:56:49', 'mingli');

-- ----------------------------
-- Table structure for tb_seek
-- ----------------------------
DROP TABLE IF EXISTS `tb_seek`;
CREATE TABLE `tb_seek` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `requires` varchar(255) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `submitdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_seek
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'mingli', '123456', '33', '2');
INSERT INTO `tb_user` VALUES ('2', 'mingli', '123456', '17681182996', '3');
INSERT INTO `tb_user` VALUES ('3', 'xiaohua', '123456', '18556501333', '2');
INSERT INTO `tb_user` VALUES ('4', 'test', '123456', '18555321111', '3');
