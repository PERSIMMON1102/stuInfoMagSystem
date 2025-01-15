/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80036
Source Host           : localhost:3306
Source Database       : sdyk

Target Server Type    : MYSQL
Target Server Version : 80036
File Encoding         : 65001

Date: 2025-01-15 14:16:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `uid` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `adminname` char(10) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  CONSTRAINT `admins_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('0045', '张三', '123');
INSERT INTO `admins` VALUES ('1111', '小明', '111');

-- ----------------------------
-- Table structure for `checkcourse`
-- ----------------------------
DROP TABLE IF EXISTS `checkcourse`;
CREATE TABLE `checkcourse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `coursecode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coursename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `credits` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `instructorname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `coursecode` (`coursecode`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of checkcourse
-- ----------------------------
INSERT INTO `checkcourse` VALUES ('1', '1111', '数据结构', '4', '轩宇', '本课程介绍数据结构的基本概念和应用，包括线性结构（如数组、链表、栈、队列）和非线性结构（如树、图）。学生将学习如何选择和实现适当的数据结构，以提高算法的效率和性能，同时掌握常用的数据操作与算法分析技巧。');
INSERT INTO `checkcourse` VALUES ('2', '1112', '数据库', '3.5', '俊豪', '数据库课程探讨数据库系统的设计、实施和管理，包括关系数据库、数据库建模、SQL语言、数据查询和事务管理。学习数据库管理系统的基本原理和技术，培养使用数据库技术解决实际问题的能力。');
INSERT INTO `checkcourse` VALUES ('4', '1113', '计算机网络', '3.5', '李鹏', '本课程涵盖计算机网络的基本概念与技术，包括网络架构、协议、传输媒介、网络安全等。学生将学习TCP/IP模型、网络层和传输层的工作原理，掌握如何设计和管理计算机网络的基本技能。');
INSERT INTO `checkcourse` VALUES ('5', '1114', '医学信息系统', '2', '子豪', '医学信息系统课程介绍医疗信息的收集、存储和分析方法。内容包括电子病历、医疗数据标准、信息系统的设计与实施，以及如何利用信息技术改善医疗服务质量和效率。强调信息系统在现代医疗中的重要性。');
INSERT INTO `checkcourse` VALUES ('6', '1123', '美容课', '3', '依晨', '美容课旨在教授学生基础的美容知识和技能，包括皮肤护理、化妆技巧、发型设计及美容产品的选择与使用。课程还将讨论美容行业的发展趋势和职业道德，以帮助学生为进入该行业做好准备。');
INSERT INTO `checkcourse` VALUES ('7', '1010', '体育', '23', '磊鑫', '体育课程关注身体健康与运动技能的提升。通过多种团体和个人运动项目，学生将学习身体素质、运动规则、团队合作、竞争精神和终身健身的重要性。课程还将探讨体育的心理和社会影响。');
INSERT INTO `checkcourse` VALUES ('8', '3212', '模拟电路', '2', '玉婷', '模拟电路课程介绍电子元件（如电阻、电容、晶体管等）的工作原理及其在电路中的应用。学生将学习电路分析、设计与调试，包括增益、频率响应及噪声等基本概念，以便有效构建模拟电路。');
INSERT INTO `checkcourse` VALUES ('9', '5464', '数字电路', '3', '恩慧', '数字电路课程着重介绍逻辑电路的基本概念和设计原理，包括布尔代数、逻辑门、组合与时序电路。学生将学习如何使用数字电路设计工具与程序，理解数字信号的处理与应用。');
INSERT INTO `checkcourse` VALUES ('10', '6454', '高等数学', '5', '嘉怡', '高等数学课程覆盖微积分、线性代数、常微分方程等数学基础。课程旨在培养学生的分析能力，应用数学理论解决实际问题，并为后续的专业课程打下扎实的数学基础。');
INSERT INTO `checkcourse` VALUES ('11', '3242', '英语', '5', '子轩', '英语课程旨在提高学生的听、说、读、写能力。通过多种教学方式，如互动练习、阅读理解、写作训练和口语练习，帮助学生增强语言技能，理解文化背景，提高跨文化交流能力。');
INSERT INTO `checkcourse` VALUES ('12', '4534', '法语', '3', '乔安', '法语课程关注法语基础知识的学习，包括语法、词汇、发音和文化。学生将通过听、说、读、写的练习，提高语言运用能力，同时了解法国和法语国家的文化与传统。');
INSERT INTO `checkcourse` VALUES ('13', '4353', '西班牙语', '32', '昊天', '西班牙语课程引导学生学习西班牙语的基本语法、词汇和发音。课程通过多样的交流活动，提升学生的听说读写能力，探索西班牙语国家的文化与社会背景。');
INSERT INTO `checkcourse` VALUES ('14', '3422', '德语', '2', '雅琴', '德语课程涵盖德语的基础语法、词汇和发音，通过交互性练习和文化讨论帮助学生建立语言能力。课程注重提高学生的实用语言能力，并增加对德语国家文化的理解。');
INSERT INTO `checkcourse` VALUES ('17', '123456', '软件工程', '3', '东哥', null);

-- ----------------------------
-- Table structure for `checkitem`
-- ----------------------------
DROP TABLE IF EXISTS `checkitem`;
CREATE TABLE `checkitem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stuid` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `age` varchar(32) DEFAULT NULL,
  `ethnicity` varchar(20) DEFAULT NULL,
  `type` char(1) DEFAULT NULL COMMENT '查检项类型,分为检查和检验两种',
  `hometown` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `politicalstatus` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`,`stuid`),
  KEY `stuid` (`stuid`),
  CONSTRAINT `checkitem_ibfk_1` FOREIGN KEY (`stuid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of checkitem
-- ----------------------------
INSERT INTO `checkitem` VALUES ('28', '0001', '李明', '0', '18', '汉', '0', '上海', '共青团员');
INSERT INTO `checkitem` VALUES ('29', '0002', '王芳', '1', '18', '回', '0', '深圳', '共青团员');
INSERT INTO `checkitem` VALUES ('30', '0003', '张伟', '0', '19', '汉', '1', '北京', '共青团员');
INSERT INTO `checkitem` VALUES ('31', '0004', '刘洋', '0', '19', '汉', '1', '泰安', '共青团员');
INSERT INTO `checkitem` VALUES ('32', '0005', '陈静', '1', '21', '汉', '1', '泰安', '共青团员');
INSERT INTO `checkitem` VALUES ('33', '0006', '杨丽', '1', '21', '维吾尔', '1', '青岛', '共青团员');
INSERT INTO `checkitem` VALUES ('34', '0007', '赵雷', '0', '22', '藏', '1', '济南', '共青团员');
INSERT INTO `checkitem` VALUES ('35', '0008', '孙悦', '0', '23', '汉', '1', '枣庄', '群众');
INSERT INTO `checkitem` VALUES ('36', '0009', '周杰', '0', '24', '汉', '1', '菏泽', '群众');
INSERT INTO `checkitem` VALUES ('37', '0010', '吴婷', '1', '25', '汉', '1', '威海', '群众');
INSERT INTO `checkitem` VALUES ('38', '0011', '黄俊', '0', '22', '朝鲜', '2', '烟台', '群众');
INSERT INTO `checkitem` VALUES ('39', '0012', '韩雪', '1', '21', '汉', '2', '威海', '群众');
INSERT INTO `checkitem` VALUES ('40', '0013', '朱丽叶', '1', '22', '汉', '2', '山西', '群众');
INSERT INTO `checkitem` VALUES ('41', '0014', '高远', '0', '21', '汉', '2', '陕西', '共青团员');
INSERT INTO `checkitem` VALUES ('42', '0015', '郭晓', '0', '22', '汉', '2', '日照', '共青团员');
INSERT INTO `checkitem` VALUES ('43', '0016', '罗娜', '1', '19', '汉', '2', '潍坊', '共青团员');
INSERT INTO `checkitem` VALUES ('44', '0017', '郑天', '0', '20', '汉', '2', '淄博', '共青团员');
INSERT INTO `checkitem` VALUES ('45', '0018', '程心', '1', '22', '汉', '2', '淄博', '党员');
INSERT INTO `checkitem` VALUES ('46', '0019', '谢雨', '1', '21', '回', '2', '滨州', '党员');
INSERT INTO `checkitem` VALUES ('47', '0020', '魏晨', '0', '18', '傣', '2', '德州', '党员');
INSERT INTO `checkitem` VALUES ('48', '0021', '林浩', '0', '20', '汉', '2', '德州', '党员');
INSERT INTO `checkitem` VALUES ('49', '0022', '邓亚', '1', '23', '汉', '2', '德州', '党员');
INSERT INTO `checkitem` VALUES ('50', '0023', '萧然', '1', '24', '汉', '2', '莱芜', '党员');
INSERT INTO `checkitem` VALUES ('51', '0024', '钟灵', '0', '22', '汉', '2', '加纳', '共青团员');
INSERT INTO `checkitem` VALUES ('52', '0025', '曹阳', '0', '21', '汉', '2', '美国', '共青团员');
INSERT INTO `checkitem` VALUES ('53', '0026', '何雨', '1', '22', '汉', '2', '南京', '群众');
INSERT INTO `checkitem` VALUES ('54', '0027', '邵阳', '0', '24', '汉', '2', '天津', '群众');
INSERT INTO `checkitem` VALUES ('98', '1112', '小红', null, null, null, null, null, null);
INSERT INTO `checkitem` VALUES ('99', '1112', '梓涵', '0', '25', '汉', '1', '河北', '群众');

-- ----------------------------
-- Table structure for `checkteacher`
-- ----------------------------
DROP TABLE IF EXISTS `checkteacher`;
CREATE TABLE `checkteacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tehid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `title` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tehid` (`tehid`) USING BTREE,
  CONSTRAINT `checkteacher_ibfk_1` FOREIGN KEY (`tehid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of checkteacher
-- ----------------------------
INSERT INTO `checkteacher` VALUES ('5', '0029', '轩宇', '1314', '1', '教师', '30');
INSERT INTO `checkteacher` VALUES ('6', '0030', '俊豪', '121', '0', '教师', '33');
INSERT INTO `checkteacher` VALUES ('7', '0031', '子豪', '113', '0', '教师', '34');
INSERT INTO `checkteacher` VALUES ('8', '0032', '柏林', '113', '0', '副教授', '22');
INSERT INTO `checkteacher` VALUES ('9', '0033', '依晨', '151', '1', '副教授', '45');
INSERT INTO `checkteacher` VALUES ('10', '0034', '磊鑫', '114', '1', '副教授', '46');
INSERT INTO `checkteacher` VALUES ('11', '0035', '玉婷', '116', '1', '院长', '60');
INSERT INTO `checkteacher` VALUES ('12', '0036', '恩慧', '117', '1', '校长', '50');
INSERT INTO `checkteacher` VALUES ('13', '0037', '嘉怡', '119', '1', '教授', '23');
INSERT INTO `checkteacher` VALUES ('14', '0038', '子轩', '123', '2', '教授', '66');
INSERT INTO `checkteacher` VALUES ('15', '0039', '乔安', '167', '0', '教授', '45');
INSERT INTO `checkteacher` VALUES ('16', '0040', '昊天 ', '189', '1', '副教授', '44');
INSERT INTO `checkteacher` VALUES ('17', '0041', '雅琴', '199', '1', '教授', '43');
INSERT INTO `checkteacher` VALUES ('18', '0042', '瑞彤', '178', '1', '教授', '32');
INSERT INTO `checkteacher` VALUES ('19', '0043', '紫燕', '134', '1', '副教授', '22');
INSERT INTO `checkteacher` VALUES ('20', '0044', '洛华', '16789', '0', '教授', '24');
INSERT INTO `checkteacher` VALUES ('24', '1113', 'xl', null, null, null, null);
INSERT INTO `checkteacher` VALUES ('35', '1003', 'hz', '1111', '0', '老师', '23');
INSERT INTO `checkteacher` VALUES ('36', '123456', '肖华', '1111', '0', null, '12');
INSERT INTO `checkteacher` VALUES ('37', '1114', '熊大', '无', '0', '无', '11');
INSERT INTO `checkteacher` VALUES ('38', '1115', 'xz', null, '0', null, null);

-- ----------------------------
-- Table structure for `registration`
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stuid` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `coursecode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `term` varchar(16) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`,`stuid`,`coursecode`),
  KEY `fk_student` (`stuid`),
  KEY `fk_course` (`coursecode`),
  CONSTRAINT `fk_student` FOREIGN KEY (`stuid`) REFERENCES `checkitem` (`stuid`),
  CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`coursecode`) REFERENCES `checkcourse` (`coursecode`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of registration
-- ----------------------------
INSERT INTO `registration` VALUES ('20', '1112', '1111', '2024', '100');
INSERT INTO `registration` VALUES ('21', '1112', '1113', '2025', '60');
INSERT INTO `registration` VALUES ('23', '1112', '1010', null, '10');
INSERT INTO `registration` VALUES ('24', '1112', '1114', null, '90');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` varchar(10) NOT NULL,
  `rolename` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0', '管理员');
INSERT INTO `role` VALUES ('1', '学生');
INSERT INTO `role` VALUES ('2', '教师');

-- ----------------------------
-- Table structure for `teachercourse`
-- ----------------------------
DROP TABLE IF EXISTS `teachercourse`;
CREATE TABLE `teachercourse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `courseid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `thid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `courseid` (`courseid`),
  KEY `thid` (`thid`),
  CONSTRAINT `teachercourse_ibfk_1` FOREIGN KEY (`courseid`) REFERENCES `checkcourse` (`coursecode`),
  CONSTRAINT `teachercourse_ibfk_2` FOREIGN KEY (`thid`) REFERENCES `checkteacher` (`tehid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teachercourse
-- ----------------------------
INSERT INTO `teachercourse` VALUES ('1', '1112', '1113');
INSERT INTO `teachercourse` VALUES ('2', '1111', '123456');
INSERT INTO `teachercourse` VALUES ('3', '1113', '1113');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(10) NOT NULL,
  `uname` varchar(32) DEFAULT NULL,
  `upass` varchar(128) DEFAULT NULL,
  `regtime` date DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0001', 'admin', 'admin', '2024-12-10', '110');
INSERT INTO `user` VALUES ('0002', 'ss', '123456', '2024-12-18', '121');
INSERT INTO `user` VALUES ('0003', null, null, null, null);
INSERT INTO `user` VALUES ('0004', null, null, null, null);
INSERT INTO `user` VALUES ('0005', null, null, null, null);
INSERT INTO `user` VALUES ('0006', null, null, null, null);
INSERT INTO `user` VALUES ('0007', null, null, null, null);
INSERT INTO `user` VALUES ('0008', null, null, null, null);
INSERT INTO `user` VALUES ('0009', null, null, null, null);
INSERT INTO `user` VALUES ('0010', null, null, null, null);
INSERT INTO `user` VALUES ('0011', null, null, null, null);
INSERT INTO `user` VALUES ('0012', null, null, null, null);
INSERT INTO `user` VALUES ('0013', null, null, null, null);
INSERT INTO `user` VALUES ('0014', null, null, null, null);
INSERT INTO `user` VALUES ('0015', null, null, null, null);
INSERT INTO `user` VALUES ('0016', null, null, null, null);
INSERT INTO `user` VALUES ('0017', null, null, null, null);
INSERT INTO `user` VALUES ('0018', null, null, null, null);
INSERT INTO `user` VALUES ('0019', null, null, null, null);
INSERT INTO `user` VALUES ('0020', null, null, null, null);
INSERT INTO `user` VALUES ('0021', null, null, null, null);
INSERT INTO `user` VALUES ('0022', null, null, null, null);
INSERT INTO `user` VALUES ('0023', null, null, null, null);
INSERT INTO `user` VALUES ('0024', null, null, null, null);
INSERT INTO `user` VALUES ('0025', null, null, null, null);
INSERT INTO `user` VALUES ('0026', null, null, null, null);
INSERT INTO `user` VALUES ('0027', null, null, null, null);
INSERT INTO `user` VALUES ('0028', null, null, null, null);
INSERT INTO `user` VALUES ('0029', null, null, null, null);
INSERT INTO `user` VALUES ('0030', null, null, null, null);
INSERT INTO `user` VALUES ('0031', null, null, null, null);
INSERT INTO `user` VALUES ('0032', null, null, null, null);
INSERT INTO `user` VALUES ('0033', null, null, null, null);
INSERT INTO `user` VALUES ('0034', null, null, null, null);
INSERT INTO `user` VALUES ('0035', null, null, null, null);
INSERT INTO `user` VALUES ('0036', null, null, null, null);
INSERT INTO `user` VALUES ('0037', null, null, null, null);
INSERT INTO `user` VALUES ('0038', null, null, null, null);
INSERT INTO `user` VALUES ('0039', null, null, null, null);
INSERT INTO `user` VALUES ('0040', null, null, null, null);
INSERT INTO `user` VALUES ('0041', 'teacher', 'teacher', null, null);
INSERT INTO `user` VALUES ('0042', null, null, null, null);
INSERT INTO `user` VALUES ('0043', null, null, null, null);
INSERT INTO `user` VALUES ('0044', null, null, null, null);
INSERT INTO `user` VALUES ('0045', null, null, null, null);
INSERT INTO `user` VALUES ('1003', null, null, null, null);
INSERT INTO `user` VALUES ('1102', null, null, null, null);
INSERT INTO `user` VALUES ('1111', '1', '1', null, null);
INSERT INTO `user` VALUES ('1112', '2', '2', null, null);
INSERT INTO `user` VALUES ('1113', '3', '3', null, null);
INSERT INTO `user` VALUES ('1114', '4', '4', null, null);
INSERT INTO `user` VALUES ('1115', null, null, null, null);
INSERT INTO `user` VALUES ('123456', 's', 's', null, null);

-- ----------------------------
-- Table structure for `userrole`
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `uid` varchar(10) NOT NULL,
  `roleid` varchar(10) NOT NULL,
  PRIMARY KEY (`uid`,`roleid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `userrole_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `userrole_ibfk_3` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1111', '0');
INSERT INTO `userrole` VALUES ('0001', '1');
INSERT INTO `userrole` VALUES ('0002', '1');
INSERT INTO `userrole` VALUES ('0003', '1');
INSERT INTO `userrole` VALUES ('0004', '1');
INSERT INTO `userrole` VALUES ('0005', '1');
INSERT INTO `userrole` VALUES ('0006', '1');
INSERT INTO `userrole` VALUES ('0007', '1');
INSERT INTO `userrole` VALUES ('0008', '1');
INSERT INTO `userrole` VALUES ('0009', '1');
INSERT INTO `userrole` VALUES ('0010', '1');
INSERT INTO `userrole` VALUES ('0011', '1');
INSERT INTO `userrole` VALUES ('0012', '1');
INSERT INTO `userrole` VALUES ('0013', '1');
INSERT INTO `userrole` VALUES ('0014', '1');
INSERT INTO `userrole` VALUES ('0015', '1');
INSERT INTO `userrole` VALUES ('0016', '1');
INSERT INTO `userrole` VALUES ('0017', '1');
INSERT INTO `userrole` VALUES ('0018', '1');
INSERT INTO `userrole` VALUES ('0019', '1');
INSERT INTO `userrole` VALUES ('0020', '1');
INSERT INTO `userrole` VALUES ('0021', '1');
INSERT INTO `userrole` VALUES ('0022', '1');
INSERT INTO `userrole` VALUES ('0023', '1');
INSERT INTO `userrole` VALUES ('0024', '1');
INSERT INTO `userrole` VALUES ('0025', '1');
INSERT INTO `userrole` VALUES ('0026', '1');
INSERT INTO `userrole` VALUES ('0027', '1');
INSERT INTO `userrole` VALUES ('0028', '1');
INSERT INTO `userrole` VALUES ('1112', '1');
INSERT INTO `userrole` VALUES ('1113', '2');
INSERT INTO `userrole` VALUES ('123456', '2');
