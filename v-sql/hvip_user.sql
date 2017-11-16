/*
Navicat MySQL Data Transfer

Source Server         : 10.1.249.49
Source Server Version : 50522
Source Host           : 10.1.249.49:8090
Source Database       : hvip_user

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2016-05-11 16:39:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth`
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `authId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `authName` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `authType` varchar(2) DEFAULT NULL COMMENT '权限类型：1.菜单 2.页面元素 3.方法',
  `authValue` text COMMENT '权限值',
  PRIMARY KEY (`authId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth
-- ----------------------------
INSERT INTO `auth` VALUES ('1', '超级管理员', '1', '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29');
INSERT INTO `auth` VALUES ('2', '商品管理权限', '1', null);
INSERT INTO `auth` VALUES ('3', '订单管理权限', '1', null);
INSERT INTO `auth` VALUES ('4', '库管权限', '1', null);
INSERT INTO `auth` VALUES ('5', '财务权限', '1', null);
INSERT INTO `auth` VALUES ('6', '客服权限', '1', null);
INSERT INTO `auth` VALUES ('7', '门店权限', '1', null);

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `empId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `empNo` varchar(50) DEFAULT NULL COMMENT '员工编号',
  `lastName` varchar(50) DEFAULT NULL COMMENT '姓',
  `firstName` varchar(50) DEFAULT NULL COMMENT '名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮件',
  `telNo` varchar(50) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机',
  `orgId` bigint(20) DEFAULT NULL COMMENT '组织id',
  `userdept` varchar(255) DEFAULT NULL COMMENT '部门',
  `position` varchar(50) DEFAULT NULL COMMENT '岗位(无)',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUser` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `updateUser` varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='雇员表';

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', null, '001', 'admin', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `oprole`
-- ----------------------------
DROP TABLE IF EXISTS `oprole`;
CREATE TABLE `oprole` (
  `roleId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名',
  `cnName` varchar(50) DEFAULT NULL COMMENT '中文名',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oprole
-- ----------------------------
INSERT INTO `oprole` VALUES ('1', 'admin', '管理员', '超级管理员');
INSERT INTO `oprole` VALUES ('2', 'user', '用户', '普通用户');

-- ----------------------------
-- Table structure for `opuser`
-- ----------------------------
DROP TABLE IF EXISTS `opuser`;
CREATE TABLE `opuser` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮件',
  `mobile` varchar(50) DEFAULT NULL COMMENT '邮件',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `accountEnabled` bit(1) DEFAULT NULL COMMENT '是否有效',
  `accountExpired` bit(1) DEFAULT NULL COMMENT '是否过期',
  `accountLocked` bit(1) DEFAULT NULL COMMENT '是否锁定',
  `credentialsExpired` bit(1) DEFAULT NULL COMMENT '密码过期',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `lastLoginIP` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `empId` bigint(20) DEFAULT NULL COMMENT '员工id',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUser` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `updateUser` varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of opuser
-- ----------------------------
INSERT INTO `opuser` VALUES ('1', 'admin', 'tttt', null, '21232f297a57a5a743894a0e4a801fc3', '', '', '', '', null, null, null, '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for `opuserrole`
-- ----------------------------
DROP TABLE IF EXISTS `opuserrole`;
CREATE TABLE `opuserrole` (
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  `roleId` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of opuserrole
-- ----------------------------
INSERT INTO `opuserrole` VALUES ('1', '1');
INSERT INTO `opuserrole` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `pageelement`
-- ----------------------------
DROP TABLE IF EXISTS `pageelement`;
CREATE TABLE `pageelement` (
  `elementId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `elementName` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`elementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pageelement
-- ----------------------------

-- ----------------------------
-- Table structure for `roleauth`
-- ----------------------------
DROP TABLE IF EXISTS `roleauth`;
CREATE TABLE `roleauth` (
  `roleId` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  `authId` bigint(20) NOT NULL DEFAULT '0' COMMENT '权限id',
  PRIMARY KEY (`roleId`,`authId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleauth
-- ----------------------------
INSERT INTO `roleauth` VALUES ('1', '1');
