/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云数据库
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 47.102.139.183:3306
 Source Schema         : qgstudio

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 02/08/2019 08:49:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` smallint(255) UNSIGNED NOT NULL DEFAULT 0 COMMENT '序号',
  `project` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '项目',
  `game` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '比赛',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '时间',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '比赛等级',
  `prize` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '获奖等级',
  `institution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '授奖部门',
  `winner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '获奖学生',
  `leader` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '指导老师',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of award
-- ----------------------------
INSERT INTO `award` VALUES (30, 0, '矿工帽项目', '挑战杯', '2019', '国家级', '特等奖', '中科院', '曾华琛', '谢光强', '2019-07-31 08:11:46', '2019-07-31 08:11:46');
INSERT INTO `award` VALUES (31, 0, '开天辟地', '挑战杯', '公元前一万年', '顶天立地', '高水平成功', '天庭', '盘古', '混沌', '2019-07-31 08:38:29', '2019-07-31 08:57:09');
INSERT INTO `award` VALUES (32, 0, '开天又辟地', '大闹天宫', '公元200年', '小孩子玩耍级别', '熊孩子奖', '', '小A', '大B', '2019-07-31 11:04:49', '2019-07-31 11:04:49');
INSERT INTO `award` VALUES (35, 0, '威锋网', '微软发改委', '而乏味2', '违反微软', '威风威风', '弱覆盖违反', '为凤尾', '试点范围2', '2019-07-31 11:45:52', '2019-07-31 11:45:52');
INSERT INTO `award` VALUES (36, 0, '矿工帽', '挑战杯', '2019', '国家级', '特等奖', '中科院', '曾华琛', '谢光强', '2019-07-31 16:54:03', '2019-07-31 16:54:03');
INSERT INTO `award` VALUES (37, 0, '2019特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '2019特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '2019特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '2019-07-31 18:31:28', '2019-07-31 18:44:50');
INSERT INTO `award` VALUES (39, 0, '', '', '', '', '特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '', '', '特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '2019-07-31 18:41:54', '2019-07-31 18:41:54');
INSERT INTO `award` VALUES (40, 0, 'tesyt', '', '', '', '', '', '', '线程', '2019-07-31 19:04:40', '2019-07-31 20:12:22');
INSERT INTO `award` VALUES (41, 0, 'goodluck', '我在修改\n', '2019特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '', '2019特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖特等奖', '', '', '', '2019-07-31 20:12:37', '2019-07-31 20:31:46');

-- ----------------------------
-- Table structure for copyright
-- ----------------------------
DROP TABLE IF EXISTS `copyright`;
CREATE TABLE `copyright`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` smallint(6) UNSIGNED NOT NULL DEFAULT 0 COMMENT '序号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1234' COMMENT '名称',
  `rn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '登记号',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '发表时间',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of copyright
-- ----------------------------
INSERT INTO `copyright` VALUES (3, 0, '订单集群打印系统V1.0', '2017SR267145', '订单集群打印系统V2.0', '2019-07-31 15:58:44', '2019-07-31 17:48:46');
INSERT INTO `copyright` VALUES (5, 0, '微软2', '而为人服务2', '而乏味2', '2019-07-31 16:16:13', '2019-07-31 16:16:13');

-- ----------------------------
-- Table structure for feature
-- ----------------------------
DROP TABLE IF EXISTS `feature`;
CREATE TABLE `feature`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feature
-- ----------------------------
INSERT INTO `feature` VALUES (1, '50d2a842b9cd4579946ba2f6f4da9366', '康乐活动', '简介', '2019-07-29 15:53:06', '2019-08-01 21:20:35');
INSERT INTO `feature` VALUES (2, '362788b316944b169808098ba7819e2d', '标题', '描述', '2019-08-01 16:04:49', '2019-08-01 16:04:49');
INSERT INTO `feature` VALUES (3, 'b9e9445dded34b7ca135d19d7d5100a1', '康乐活动', '简介', '2019-08-01 16:10:27', '2019-08-01 16:10:27');

-- ----------------------------
-- Table structure for field
-- ----------------------------
DROP TABLE IF EXISTS `field`;
CREATE TABLE `field`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of field
-- ----------------------------
INSERT INTO `field` VALUES (1, '0d8db505c81047bc8a206cbca8871d11', '分布式智能网络化系统小组后台方向', '后台是一个与数据和信息打交道的方向，负责着各类数据的处理与传输。无论是网页端、移动端还是嵌入式端，都需要后台技术的支持。QG后台组基于Java语言，自成立以来致力于后台服务器的开发，成功为工作室多数项目提供了坚实的后台技术支持，慢慢成长为一支团结可靠的队伍。', '2019-08-01 17:11:28', '2019-08-01 21:11:13');
INSERT INTO `field` VALUES (5, 'aa1960532e634c4fb8c5cbe70d3a7f9a', '分布式智能网络化系统小组前端方向', '前端在网络开发中属于呈现给用户的部分，最具有代表性的莫过于传统的网页。前端组一直紧随最前沿的技术脚步，秉承着用户体验至上的原则，完成用户的需求。前端发展至今天，所能完成的任务可不仅仅于此，前端开发者探索的脚步从未停止，我们可以用Node.js进行高性能后端开发。我们创造出挑战原生APP地位的webapp小程序，更可以开发桌面级应用。想你所想，前端的未来将由你来开拓。', '2019-08-01 21:23:10', '2019-08-01 21:23:10');
INSERT INTO `field` VALUES (6, 'c96f8229567f4264a3cf65fe6d2fea3a', '虚拟现实与智能交互小组', '图形渲染组（前身手游组）的研究方向为计算机图形学与AR/VR开发。小组以DirectX、Unity3D作为主要学习方向，DirectX用于理解底层图形渲染原理，Unity3D引擎用于开发AR/VR应用程序、仿真平台以及其他交互式媒体应用程序。', '2019-08-01 21:27:18', '2019-08-01 21:29:24');
INSERT INTO `field` VALUES (7, '3b136df02d3d4a1e9e07e9480b443c26', '人机交互与UI设计小组', '设计组的主要研究方向是手机游戏和网页的界面设计及交互，游戏原画设计以及平面设计。我们旨在锻炼成员的创新能力、创意思想，培养成员的视觉设计和交互设计能力。除此之外，设计组也在着手3D模型的设计以及3D打印机的使用，产出的智能打印机和智能头盔已经斩获多个奖项，更是在挑战杯校赛中协助取得特等奖、一等奖的好成绩。想用你的创意思维点燃技术的光芒吗？设计组在这里等你！', '2019-08-01 21:29:58', '2019-08-01 21:29:58');
INSERT INTO `field` VALUES (8, 'cd71987c94e6476ba34c2284c9319acf', '智能移动技术小组', '智能手机应用开发小组，简称移动组。小组在结构上前前后后经历了三次变革，主攻方向从Android应用/游戏开发变为Android应用/后台开发再到现在的纯Android应用开', '2019-08-01 21:30:39', '2019-08-01 21:30:39');
INSERT INTO `field` VALUES (9, '8c97826aecba48409b12e9248e608904', '分布式智能系统小组', '为计算机学院历史最悠久、实力最强的嵌入式开发团队。小组内部有着丰富的开发资源及技术传承，主要研究方向为基于ARM+LINUX平台以及其他各类开发板的嵌入式软件开发。小组的学习之旅主要伴随着比赛，近年来获得过许多奖项，第十四届“挑战杯”全国大学生课外学术科技作品竞赛香港专项赛特等奖更是刷新了学校在挑战杯获奖层次的记录。', '2019-08-01 21:34:49', '2019-08-01 21:34:49');
INSERT INTO `field` VALUES (10, '5dcfa37040d0408fa960cb03fabc8975', '大数据挖掘与知识管理小组', '大数据挖掘与知识管理小组，研究方向为大数据的存储、获取与运算以及机器学习的算法，是与当下流行的人工智能最相关的组。小组以机器学习的基本理论，使用数据分析库进行数据科学的研究和实践，利用Linux下的Hadoop、Spark等框架进行大数据的存储和运算。如果你是一个不仅喜欢编程，对数据的力量充满好奇，想要了解数据科学的话，请带上你的热情，来我们数据挖掘组报名吧！', '2019-08-01 21:36:10', '2019-08-01 21:36:10');
INSERT INTO `field` VALUES (12, 'ae7b77bd43f14385b1671beb4a8211d9', '1234', '二点五十公分高的护法国会·', '2019-08-02 08:35:54', '2019-08-02 08:35:54');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1234' COMMENT '标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES (1, 'd7674ccb80544c92be8dad6b0fad60b8', '标题', '描述', '2019-08-01 21:20:12', '2019-08-01 21:20:12');
INSERT INTO `history` VALUES (2, '4d3423fb1b934894840f97861ce3a655', '标题2', '描述2', '2019-08-01 21:20:59', '2019-08-01 21:20:59');
INSERT INTO `history` VALUES (4, '35c7e57945e347269ec53e01e35d4202', '标题3', '描述3', '2019-08-01 22:00:29', '2019-08-01 22:00:29');

-- ----------------------------
-- Table structure for honor
-- ----------------------------
DROP TABLE IF EXISTS `honor`;
CREATE TABLE `honor`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '时间',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of honor
-- ----------------------------
INSERT INTO `honor` VALUES (25, '08c34f002cb24602a757a12f5145d335', '挑战杯获奖', '', NULL, '2019-08-01 23:10:10', '2019-08-01 23:10:10');
INSERT INTO `honor` VALUES (27, 'f687ea24f96c4c1886f5b5fd9c03ebd3', '挑战杯获奖', '华琛获奖', NULL, '2019-08-01 23:14:43', '2019-08-01 23:14:43');
INSERT INTO `honor` VALUES (28, '9b8758cbced440feac546b179401e84f', '挑战杯获奖', '华琛获奖', NULL, '2019-08-02 08:42:43', '2019-08-02 08:42:43');
INSERT INTO `honor` VALUES (29, 'eedb107fedae41c6a0384d31309fc26f', '挑战杯获奖', '华琛获奖', NULL, '2019-08-02 08:43:26', '2019-08-02 08:43:26');
INSERT INTO `honor` VALUES (30, 'c51c8576f98542b1884f885b486dd9ac', '挑战杯获奖', '华琛获奖', NULL, '2019-08-02 08:43:58', '2019-08-02 08:43:58');
INSERT INTO `honor` VALUES (31, 'e8983cce36f4487b88bd2b2e2172c46c', '挑战杯获奖', '华琛获奖', NULL, '2019-08-02 08:44:01', '2019-08-02 08:44:01');
INSERT INTO `honor` VALUES (33, 'da33ff7f3d86415383d45bc1cc16ae54', '挑战杯获奖', '华琛获奖', '2019-03-02', '2019-08-02 08:48:14', '2019-08-02 08:48:14');
INSERT INTO `honor` VALUES (34, '1e354427719844179cf44f898ac32a13', '挑战杯获奖', '华琛获奖', '2019-03-02', '2019-08-02 08:48:42', '2019-08-02 08:48:42');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fuuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `filename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文件名',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片描述',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fuuid`(`fuuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 270 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (6, 'c3bfc26ee05c45a88d5b754f6d3a92ef', '4855a2091ca7442490f4572d7fab6124.png', '图片描述', '2019-07-28 11:30:14', '2019-07-31 17:13:35');
INSERT INTO `image` VALUES (7, 'c3bfc26ee05c45a88d5b754f6d3a92ef', '52a9275eeb0e441591cda7dfa9c12019.jpg', '', '2019-07-28 11:31:05', '2019-07-28 11:31:05');
INSERT INTO `image` VALUES (10, '7874a29188674bb5b7e39638269410f5', 'e47199cae4964fa799b5b52aff5fc5e8.png', '', '2019-07-28 13:37:03', '2019-07-28 13:37:03');
INSERT INTO `image` VALUES (11, '47356f4f0e504935b29037c79096dc3c', '42e457bdd406464380bdd00ad91e710d.png', '', '2019-07-28 13:43:33', '2019-07-28 13:43:33');
INSERT INTO `image` VALUES (12, '7b51bb9b5ba94b78bae959003bf103b2', 'ebefa00d049c4263a3c40448ec93b3dc.jpg', '', '2019-07-28 13:43:56', '2019-07-28 13:43:56');
INSERT INTO `image` VALUES (13, '60184fffef4e48ca956f9f0cb3687f94', '743747e393154831b648d9621632f7b2.jpg', '', '2019-07-28 13:44:33', '2019-07-28 13:44:33');
INSERT INTO `image` VALUES (14, '72f384ed206444ee93a173751c58fdd8', '398d7da432eb4782b9d9ee104a1c6d4a.png', '', '2019-07-28 13:48:13', '2019-07-28 13:48:13');
INSERT INTO `image` VALUES (15, '72f384ed206444ee93a173751c58fdd8', '581a4cc96c1d4970acb727bc30300c6f.jpg', '', '2019-07-28 15:03:56', '2019-07-28 15:03:56');
INSERT INTO `image` VALUES (18, 'a39fcde91e0042ef90a2131b0a1794c9', '996701b43f46488f99bdab7ff47fbd35.jpg', '', '2019-07-28 22:50:23', '2019-07-28 22:50:23');
INSERT INTO `image` VALUES (23, '1a1ce68fe8a34500a7e05ecd28d81a96', 'd6ec55107f4048deb6e36b19a295ad44.jpg', '', '2019-07-28 22:51:57', '2019-07-28 22:51:57');
INSERT INTO `image` VALUES (24, 'd7f1d3fac63c4148926be753425325af', '7095b30097e546abac2efb2d6441304c.jpg', '', '2019-07-28 22:52:04', '2019-07-28 22:52:04');
INSERT INTO `image` VALUES (25, '4d133e8ded3145fba070d74c81c7d1bf', '518d5105d81a4c738999256edee8d015.jpg', '', '2019-07-28 22:52:09', '2019-07-28 22:52:09');
INSERT INTO `image` VALUES (26, '19f62cdad37d4066889885cb8d1136e0', '2d57cbeb91e24f2dbb203faa8409f8b4.jpg', '', '2019-07-28 22:52:16', '2019-07-28 22:52:16');
INSERT INTO `image` VALUES (28, '8b24a10a7d464f78a8dedda9e689d16c', '887293f691d14aedbd097ed2d02ac3c2.jpg', '', '2019-07-29 08:22:14', '2019-07-29 08:22:14');
INSERT INTO `image` VALUES (30, '5872ab398c4443018f388a95515a8528', '28fc95f699a44157a400262c4dac023b.png', '', '2019-07-29 08:34:36', '2019-07-29 08:34:36');
INSERT INTO `image` VALUES (35, 'eb8358ade268473ca7ac9b5a3f35860c', 'd7ac37e91f154813a89be555c76720c3.jpg', '', '2019-07-29 15:37:55', '2019-07-29 15:37:55');
INSERT INTO `image` VALUES (36, '5c39e5a2e00d40438695ab21e2e9a403', '30ef2540504346d8a36101bc044f1a4d.png', '', '2019-07-29 15:43:35', '2019-07-29 15:43:35');
INSERT INTO `image` VALUES (41, '4fcc8ce5a23f46e08f65ab728ccf4af8', '5d1d5e3850414d9081bb2d37194b25dd.png', '', '2019-07-29 16:12:47', '2019-07-29 16:12:47');
INSERT INTO `image` VALUES (45, '1e2de61968a54c52a6d80254ea0ead68', '119d1e6abc3b4ef184454f84420846c3.png', '', '2019-07-29 16:42:30', '2019-07-29 16:42:30');
INSERT INTO `image` VALUES (49, 'bca67654cc9b48a784a81725d12a33a1', '1538b30afc5b4db6ab5f98f3ffe77243.png', '', '2019-07-29 16:45:34', '2019-07-29 16:45:34');
INSERT INTO `image` VALUES (81, '8ad6d7764c9c448199ebbb04728da681', 'a1f2b45db96346c5a0d3a4a29b64f935.jpg', '', '2019-07-29 18:26:04', '2019-07-29 18:26:04');
INSERT INTO `image` VALUES (83, 'bf28af0ca592455fa97ae841894ccecb', '30f3c32534184ea0ac381f48ad7ee2f1.jpg', '', '2019-07-29 18:27:27', '2019-07-29 18:27:27');
INSERT INTO `image` VALUES (85, 'cb5f52518c954f25a0ebba95725bf7c6', '32ba16649fad49248c698fa6ae714857.jpg', '', '2019-07-29 18:33:50', '2019-07-29 18:33:50');
INSERT INTO `image` VALUES (86, 'd44a148b450242cc8db249ad2e1513ca', '3f59ff653f684e66924cece2ecba8921.jpg', '', '2019-07-29 20:18:14', '2019-07-29 20:18:14');
INSERT INTO `image` VALUES (88, '4a85c6d58e434fc691bb234dad31c146', '73e8165e22094188be55a28632ccacd7.jpg', '', '2019-07-29 20:29:03', '2019-07-29 20:29:03');
INSERT INTO `image` VALUES (90, '4e247a01085c4bd49497297d23407938', '3a46f7a20a084e05b94c3e5d61b5a712.jpg', '', '2019-07-29 21:55:34', '2019-07-29 21:55:34');
INSERT INTO `image` VALUES (92, '3058e9349cfe4453a76e9fdb7a427610', 'cfbd52f352b841b2932e15c188f60d9f.png', '', '2019-07-29 21:56:38', '2019-07-29 21:56:38');
INSERT INTO `image` VALUES (94, '34c1632ae50449b2af91c7c34f91ba18', '22e06eb871bd4cb9afe1e23884113b24.jpg', '', '2019-07-29 21:57:13', '2019-07-29 21:57:13');
INSERT INTO `image` VALUES (97, '68d5eae6fedb4ffcadee0a9606a466b5', 'fe3a7400da7d44b1ba896cf9926c7bd9.png', '', '2019-07-30 11:14:45', '2019-07-30 11:14:45');
INSERT INTO `image` VALUES (100, '5c9a091a30184c989c1a3ccbb551a177', '01bb37885b5d4a7786becc577954f57c.jpg', '', '2019-07-30 15:38:23', '2019-07-30 15:38:23');
INSERT INTO `image` VALUES (101, 'ed6c43abbfc54b688ba45326eeb742b0', '0ba55da279164fe1bd36bfc63e1973f0.png', '', '2019-07-30 16:01:06', '2019-07-30 16:01:06');
INSERT INTO `image` VALUES (102, 'f6b7ed55405d481ca93c1f943f3677bc', '4081f9a0229f4907a09171b4b08722a7.jpg', '', '2019-07-30 16:02:23', '2019-07-30 16:02:23');
INSERT INTO `image` VALUES (103, 'd20f3489a1054ded8565a8ade36a4680', 'b31abca8e6fa4ceb8d3af4dcf2d8265a.jpg', '', '2019-07-30 16:04:23', '2019-07-30 16:04:23');
INSERT INTO `image` VALUES (110, 'f3070fed8e9a48eca9eb1909a1a23588', '4c8f13fe3f3f40019d3a1beec6c210ed.jpg', '', '2019-07-30 16:26:52', '2019-07-30 16:26:52');
INSERT INTO `image` VALUES (111, '2939859cab2d424d911eaca7a34ad783', '94871b46eac6463c84f78d5aaf21cc63.png', '', '2019-07-30 16:27:04', '2019-07-30 16:27:04');
INSERT INTO `image` VALUES (112, 'd86105dd380c48798f799155504d456e', '9df3fd9128a647d9959839bce9572767.jpg', '', '2019-07-30 16:27:08', '2019-07-30 16:27:08');
INSERT INTO `image` VALUES (114, '824116bc2d6a4dc5badaab8f9fc4eae4', '258ebac105c14f408b36d2d24ccc69f5.png', '', '2019-07-31 08:28:44', '2019-07-31 08:28:44');
INSERT INTO `image` VALUES (115, '3f48c24efa2d4be5b2b20dd6b7273fbf', 'd77a6d22eae14d32a1bb7fbd0d489295.jpg', '', '2019-07-31 08:57:58', '2019-07-31 08:57:58');
INSERT INTO `image` VALUES (116, '63462dd294a44dabbeb50770ae4a3912', '7fb379b6eabb45e7852ce085a8881789.jpg', '', '2019-07-31 08:58:37', '2019-07-31 08:58:37');
INSERT INTO `image` VALUES (117, 'e03a84c4f91a4155a4a8d22af6cfa9bf', '1c2b5a8f67404019b680973344f4852d.jpg', '', '2019-07-31 09:04:21', '2019-07-31 09:04:21');
INSERT INTO `image` VALUES (118, 'c23839c917374c53bd1c7bd645e5a729', '0d842ab2434c4dc1aefa97da8cb693bc.jpg', '', '2019-07-31 09:07:23', '2019-07-31 09:07:23');
INSERT INTO `image` VALUES (119, 'ff796798fe3c4c50867a026e0cfe6fd1', 'd22eb2be9987465ba6b6b9d635ce3853.jpg', '', '2019-07-31 15:02:12', '2019-07-31 15:02:12');
INSERT INTO `image` VALUES (120, '', 'd89d4f70b99241f3bd7b3fd6267fc6c0', '', '2019-07-31 15:07:32', '2019-07-31 15:07:32');
INSERT INTO `image` VALUES (121, 'd89d4f70b99241f3bd7b3fd6267fc6c0', '124aa2e9b388439e98386deea37add2c.jpg', '', '2019-07-31 15:07:38', '2019-07-31 15:07:38');
INSERT INTO `image` VALUES (122, '', '33d8555ca24945ce98ea833c5a0630d2', '', '2019-07-31 15:12:08', '2019-07-31 15:12:08');
INSERT INTO `image` VALUES (123, '33d8555ca24945ce98ea833c5a0630d2', 'b4a04a7bc24d4a85b6e125d2b2866dc8.jpg', '', '2019-07-31 15:12:10', '2019-07-31 15:12:10');
INSERT INTO `image` VALUES (124, '', '7e81c0ce60bc4e4098d70ec88135ac4c', '', '2019-07-31 15:13:06', '2019-07-31 15:13:06');
INSERT INTO `image` VALUES (125, '7e81c0ce60bc4e4098d70ec88135ac4c', '807febf630d2444c8e115d04a32b4d68.jpg', '', '2019-07-31 15:13:06', '2019-07-31 15:13:06');
INSERT INTO `image` VALUES (126, '', 'a8452c83ff7a4219978196f95d1e86bc', '', '2019-07-31 15:32:12', '2019-07-31 15:32:12');
INSERT INTO `image` VALUES (127, 'a8452c83ff7a4219978196f95d1e86bc', 'bbbe0d4398b4498096c709c9ea49f4fb.bmp', '', '2019-07-31 15:32:12', '2019-07-31 15:32:12');
INSERT INTO `image` VALUES (132, 'e2362bbbefb04aefa54a8d62551c6eaf', '89416e4ec4d347d3bb67121350a02e9d.png', '', '2019-07-31 19:16:23', '2019-07-31 19:16:23');
INSERT INTO `image` VALUES (133, 'e2362bbbefb04aefa54a8d62551c6eaf', '95538b479fc04d239ee384553e346f9d.png', '', '2019-07-31 19:16:23', '2019-07-31 19:16:23');
INSERT INTO `image` VALUES (134, 'e2362bbbefb04aefa54a8d62551c6eaf', 'ba04c78e28fe43909ed2ba8f5a069c40.png', '', '2019-07-31 19:16:23', '2019-07-31 19:16:23');
INSERT INTO `image` VALUES (138, '', '4cb08d5cbdc64702a44f54cce4b30309', '', '2019-07-31 20:47:05', '2019-07-31 20:47:05');
INSERT INTO `image` VALUES (139, '4cb08d5cbdc64702a44f54cce4b30309', '25165c23cb4149f7854e19f9b6283c42.png', '', '2019-07-31 20:47:06', '2019-07-31 20:47:06');
INSERT INTO `image` VALUES (140, '', '46b9bee1820e449bac8023ad7a8e65b2', '', '2019-07-31 20:48:03', '2019-07-31 20:48:03');
INSERT INTO `image` VALUES (141, '46b9bee1820e449bac8023ad7a8e65b2', '08f7c5f0668d42b5a21f3861bbbaed24.jpg', '', '2019-07-31 20:48:03', '2019-07-31 20:48:03');
INSERT INTO `image` VALUES (142, '', '9705b7fcf25c4b9cafeb52c34df4c171', '', '2019-07-31 20:51:34', '2019-07-31 20:51:34');
INSERT INTO `image` VALUES (143, '9705b7fcf25c4b9cafeb52c34df4c171', 'd7b60071d00d48b3819c84d7f38836dd.png', '', '2019-07-31 20:51:34', '2019-07-31 20:51:34');
INSERT INTO `image` VALUES (144, '', '0384e0451a714e11bebd6506ced1e956', '', '2019-07-31 21:03:45', '2019-07-31 21:03:45');
INSERT INTO `image` VALUES (145, '0384e0451a714e11bebd6506ced1e956', '5f67e9ef50d6480db17ebce6939b0bd9.jpg', '', '2019-07-31 21:03:46', '2019-07-31 21:03:46');
INSERT INTO `image` VALUES (146, '', '735b2376b4d947868c5b5e85920f286e', '', '2019-07-31 21:04:31', '2019-07-31 21:04:31');
INSERT INTO `image` VALUES (147, '735b2376b4d947868c5b5e85920f286e', '0793a8c7a32346faad856d90330dccf2.jpg', '', '2019-07-31 21:04:43', '2019-07-31 21:04:43');
INSERT INTO `image` VALUES (148, '', 'b165a1c2cc1f42d9b69b7eb950241b22', '', '2019-07-31 21:09:50', '2019-07-31 21:09:50');
INSERT INTO `image` VALUES (149, 'b165a1c2cc1f42d9b69b7eb950241b22', 'a31eb0fc12954f0e9d03cc6dc59f96c3.gif', '', '2019-07-31 21:09:50', '2019-07-31 21:09:50');
INSERT INTO `image` VALUES (150, '', 'ffaf1d5912794dd898b8af7267dc7685', '', '2019-07-31 21:11:10', '2019-07-31 21:11:10');
INSERT INTO `image` VALUES (151, 'ffaf1d5912794dd898b8af7267dc7685', '3346870144d94827a0c7d30294a726d6.gif', '', '2019-07-31 21:11:10', '2019-07-31 21:11:10');
INSERT INTO `image` VALUES (152, '', '4658e91688994020b4bf3ed1b3e61a59', '', '2019-07-31 21:12:24', '2019-07-31 21:12:24');
INSERT INTO `image` VALUES (153, '4658e91688994020b4bf3ed1b3e61a59', '62b8c0558f1b4d68a8c4f5d9f8e5b610.gif', '', '2019-07-31 21:12:24', '2019-07-31 21:12:24');
INSERT INTO `image` VALUES (154, '', 'bd6ec16641464121984a95974110f5dd', '', '2019-07-31 21:25:48', '2019-07-31 21:25:48');
INSERT INTO `image` VALUES (155, 'bd6ec16641464121984a95974110f5dd', 'd0e4e05b90254303b1abe4484d4258c8.gif', '', '2019-07-31 21:25:48', '2019-07-31 21:25:48');
INSERT INTO `image` VALUES (156, '', 'ad5d6051b0e64c7285bc9559d21b247d', '', '2019-08-01 07:51:11', '2019-08-01 07:51:11');
INSERT INTO `image` VALUES (157, 'ad5d6051b0e64c7285bc9559d21b247d', 'f2b1e5b5639a4ab1ab4a3c21d9ad5d29.gif', '', '2019-08-01 07:51:11', '2019-08-01 07:51:11');
INSERT INTO `image` VALUES (158, '3058e9349cfe4453a76e9fdb7a427610', 'beef621d41db45909e12ca37c8fc9d7c.gif', '', '2019-08-01 09:01:23', '2019-08-01 09:01:23');
INSERT INTO `image` VALUES (159, '3058e9349cfe4453a76e9fdb7a427610', '5eb6e7c942c849418ee180e6d892c5d0.gif', '', '2019-08-01 09:01:43', '2019-08-01 09:01:43');
INSERT INTO `image` VALUES (160, '50d2a842b9cd4579946ba2f6f4da9366', 'd125a91bc3a542b0ad6642a385ff6713.jpg', '图片简介', '2019-08-01 11:07:23', '2019-08-01 23:45:33');
INSERT INTO `image` VALUES (161, '50d2a842b9cd4579946ba2f6f4da9366', 'd13628e20b234612a2054200fae4e096.jpg', 'yeah~', '2019-08-01 11:07:23', '2019-08-01 15:41:08');
INSERT INTO `image` VALUES (163, '50d2a842b9cd4579946ba2f6f4da9366', '12ac566525f6408982c96eafc533ef82.jpg', '工大正门', '2019-08-01 11:07:23', '2019-08-01 15:40:55');
INSERT INTO `image` VALUES (164, '50d2a842b9cd4579946ba2f6f4da9366', '0102102629864613bf426fc6f49e99a8.jpg', '怎么肥事小老弟', '2019-08-01 11:07:23', '2019-08-01 14:15:52');
INSERT INTO `image` VALUES (167, 'ff796798fe3c4c50867a026e0cfe6fd1', '08f54afecb2f4056920ec2a6cded0d5a.jpg', '', '2019-08-01 11:36:09', '2019-08-01 11:36:09');
INSERT INTO `image` VALUES (168, 'ff796798fe3c4c50867a026e0cfe6fd1', '35f6d6f6c13d4ec7adefaa489b25a4f6.jpg', '', '2019-08-01 11:36:33', '2019-08-01 11:36:33');
INSERT INTO `image` VALUES (169, '4a85c6d58e434fc691bb234dad31c146', '12895782c1684aec9350b5295aba4671.png', '', '2019-08-01 11:40:41', '2019-08-01 11:40:41');
INSERT INTO `image` VALUES (170, '4a85c6d58e434fc691bb234dad31c146', 'beb6b8fa3077469f9ddda64a02eb8915.png', '', '2019-08-01 11:41:27', '2019-08-01 11:41:27');
INSERT INTO `image` VALUES (171, '', 'bc47a73f059848a5adadc606c86713e3', '', '2019-08-01 11:43:13', '2019-08-01 11:43:13');
INSERT INTO `image` VALUES (174, 'bc47a73f059848a5adadc606c86713e3', 'e58a6b8cb7d14dc49dfcf685858d6f0e.jpg', '', '2019-08-01 14:49:45', '2019-08-01 14:49:45');
INSERT INTO `image` VALUES (175, '', '27391496bbb6421fa75a415df91ef0fb', '', '2019-08-01 14:50:14', '2019-08-01 14:50:14');
INSERT INTO `image` VALUES (176, '27391496bbb6421fa75a415df91ef0fb', 'ce412aeb9a324c8a888b1e2901f58511.jpg', '', '2019-08-01 14:50:14', '2019-08-01 14:50:14');
INSERT INTO `image` VALUES (177, '', 'df6007eee0b74c08a5489490a55ceb5e', '', '2019-08-01 14:51:03', '2019-08-01 14:51:03');
INSERT INTO `image` VALUES (178, 'df6007eee0b74c08a5489490a55ceb5e', 'a5a8ad5d929c4d04b9369baa2c41492d.gif', '', '2019-08-01 14:51:03', '2019-08-01 14:51:03');
INSERT INTO `image` VALUES (179, '', 'cdd7110b3f2c46359f52b12d7c4900b5', '', '2019-08-01 14:51:51', '2019-08-01 14:51:51');
INSERT INTO `image` VALUES (181, '', '2fae7655b01249b28dd2ee160123cf00', '', '2019-08-01 14:52:31', '2019-08-01 14:52:31');
INSERT INTO `image` VALUES (182, '2fae7655b01249b28dd2ee160123cf00', '45628e6fc8de4f1e967b6f6307cdb346.gif', '', '2019-08-01 14:52:31', '2019-08-01 14:52:31');
INSERT INTO `image` VALUES (183, '', '261ef7942683451a8435ab2a78290533', '', '2019-08-01 14:54:04', '2019-08-01 14:54:04');
INSERT INTO `image` VALUES (184, '261ef7942683451a8435ab2a78290533', 'ad516d2965394c71bb599b754d25cc49.gif', '', '2019-08-01 14:54:04', '2019-08-01 14:54:04');
INSERT INTO `image` VALUES (185, '50d2a842b9cd4579946ba2f6f4da9366', '1445d2f547c543af85abefa0e8c45fb3.png', '教六创客空间', '2019-08-01 15:08:01', '2019-08-01 15:40:12');
INSERT INTO `image` VALUES (186, '', '7b525c5f2dd3404b97c20ffebccaa5e2', '', '2019-08-01 15:10:18', '2019-08-01 15:10:18');
INSERT INTO `image` VALUES (187, '7b525c5f2dd3404b97c20ffebccaa5e2', '65a2d721895d4b32b1f93609a7b7bf65.gif', '', '2019-08-01 15:10:19', '2019-08-01 15:10:19');
INSERT INTO `image` VALUES (188, 'cdd7110b3f2c46359f52b12d7c4900b5', '39ce8d5af8764cb8b8f9be0f8a6f85b9.gif', '', '2019-08-01 15:10:28', '2019-08-01 15:10:28');
INSERT INTO `image` VALUES (189, 'f3070fed8e9a48eca9eb1909a1a23588', '30a23f2e12aa44acb7ce9ac11e729ace.jpg', '', '2019-08-01 15:11:23', '2019-08-01 15:11:23');
INSERT INTO `image` VALUES (190, 'd86105dd380c48798f799155504d456e', '339099749c114c6c95f5bcecf0c82dea.png', '', '2019-08-01 15:11:29', '2019-08-01 15:11:29');
INSERT INTO `image` VALUES (191, '2939859cab2d424d911eaca7a34ad783', 'f802a3afdc684042a52a84392ca5824a.png', '', '2019-08-01 15:11:36', '2019-08-01 15:11:36');
INSERT INTO `image` VALUES (192, 'd86105dd380c48798f799155504d456e', '68b5c572a616426dbe397a0a03984d66.jpg', '', '2019-08-01 15:11:40', '2019-08-01 15:11:40');
INSERT INTO `image` VALUES (193, 'd20f3489a1054ded8565a8ade36a4680', '9c4c26899d9048b68e1082a7f11ae9e1.jpg', '', '2019-08-01 15:11:46', '2019-08-01 15:11:46');
INSERT INTO `image` VALUES (194, '5c9a091a30184c989c1a3ccbb551a177', '63a268d3e2c5482a9fbdeeee1040f08d.jpg', '', '2019-08-01 15:11:52', '2019-08-01 15:11:52');
INSERT INTO `image` VALUES (195, 'c23839c917374c53bd1c7bd645e5a729', 'e8d3870955a44bdd81783689749769ab.jpg', '', '2019-08-01 15:12:02', '2019-08-01 15:12:02');
INSERT INTO `image` VALUES (196, 'f3070fed8e9a48eca9eb1909a1a23588', '6360b330061147dd9c85d6c3f7e50071.jpg', '', '2019-08-01 15:12:20', '2019-08-01 15:12:20');
INSERT INTO `image` VALUES (197, '', '2d28eabe7af5437c8a2c42c77829804d', '', '2019-08-01 15:12:25', '2019-08-01 15:12:25');
INSERT INTO `image` VALUES (198, '2d28eabe7af5437c8a2c42c77829804d', 'c997e025b86b41aa90df9a439737f0cf.gif', '', '2019-08-01 15:12:25', '2019-08-01 15:12:25');
INSERT INTO `image` VALUES (199, '6ae46f900fb44fdba197d70ee54b069c', 'cd1e1b4447924931821c45a897faebd6.jpg', '', '2019-08-01 15:13:08', '2019-08-01 15:13:08');
INSERT INTO `image` VALUES (200, '', '09d0924042c94195bffdbcf50108d5e3', '', '2019-08-01 15:13:28', '2019-08-01 15:13:28');
INSERT INTO `image` VALUES (201, '09d0924042c94195bffdbcf50108d5e3', '2fdd801a601748f6aa9983f8905ef4f5.gif', '', '2019-08-01 15:13:28', '2019-08-01 15:13:28');
INSERT INTO `image` VALUES (202, '', '374c998c7e624b97a09e8548e9c038a4', '', '2019-08-01 15:13:58', '2019-08-01 15:13:58');
INSERT INTO `image` VALUES (203, '374c998c7e624b97a09e8548e9c038a4', '8a1ef349341b479f88db748642622212.gif', '', '2019-08-01 15:13:58', '2019-08-01 15:13:58');
INSERT INTO `image` VALUES (204, '', '1b999979b51e41f5ab4db5dd37c759a0', '', '2019-08-01 15:14:31', '2019-08-01 15:14:31');
INSERT INTO `image` VALUES (205, '1b999979b51e41f5ab4db5dd37c759a0', '57b01df2cd014790830d9fc8e22adb47.gif', '', '2019-08-01 15:14:31', '2019-08-01 15:14:31');
INSERT INTO `image` VALUES (207, '781554db498d41d88999fbe226429fa4', 'f427dd48d8514d7cb21b2a4b312d8790.png', '', '2019-08-01 15:15:01', '2019-08-01 15:15:01');
INSERT INTO `image` VALUES (208, 'd85f891612b0492980e89b0bccff5596', '64392979f26e4f7cb7cff4387d880297.png', '', '2019-08-01 15:20:22', '2019-08-01 15:20:22');
INSERT INTO `image` VALUES (210, '36655e2d21d044e3a6b379fb83176c14', '5a574af29c36416ca6275d99b1b8cea7.jpg', '', '2019-08-01 16:31:54', '2019-08-01 16:31:54');
INSERT INTO `image` VALUES (211, '0d8db505c81047bc8a206cbca8871d11', 'bb3a766d6b024ba99216e60aad1fc615.jpg', '', '2019-08-01 17:11:57', '2019-08-01 17:11:57');
INSERT INTO `image` VALUES (212, '0d8db505c81047bc8a206cbca8871d11', 'dd0f5e4fe1834b32b0de5f132e85e1fd.jpg', '', '2019-08-01 17:11:57', '2019-08-01 17:11:57');
INSERT INTO `image` VALUES (213, '47ff3d372ff34010a258f2f7d7bc583a', '078532c7db484160ac71426fbd03cfd3.jpg', '', '2019-08-01 18:20:11', '2019-08-01 18:20:11');
INSERT INTO `image` VALUES (214, '45933278be4e42908d25e27482678e18', '4a9a8d90d7de478f921f58c8a0366438.jpg', '', '2019-08-01 18:22:18', '2019-08-01 18:22:18');
INSERT INTO `image` VALUES (215, 'f2c95131a06e4e97a019a3f3fbde51ef', 'f0af8400d43d443fa7e3740c50e8b1e3.jpg', '', '2019-08-01 19:05:08', '2019-08-01 19:05:08');
INSERT INTO `image` VALUES (226, '362788b316944b169808098ba7819e2d', '313f9e94f0eb40f4889944d2a9dbb4d7.jpg', 'Me', '2019-08-01 20:13:35', '2019-08-01 20:13:35');
INSERT INTO `image` VALUES (227, '5eaea895db444427b74ef81100311cc5', '7275bbcfc7234995bb38b3341d81ee4a.jpeg', 'QG工作室成员方锦基于2017年在人民大会堂接受“小平科技创新团队”表彰', '2019-08-01 20:50:18', '2019-08-01 20:50:18');
INSERT INTO `image` VALUES (228, 'fcc5b8b5203841c7bd70dbf91b340846', 'b101563c2ead4d40b0e2d400a5656bc5.jpg', '', '2019-08-01 20:51:04', '2019-08-01 20:51:04');
INSERT INTO `image` VALUES (229, 'd7674ccb80544c92be8dad6b0fad60b8', '38bce3186e0843f6a4924c0c01810fc3.jpg', '', '2019-08-01 21:21:13', '2019-08-01 21:21:13');
INSERT INTO `image` VALUES (230, '4d3423fb1b934894840f97861ce3a655', '431514cd10ec43e699a8ff869997563f.png', '', '2019-08-01 21:21:20', '2019-08-01 21:21:20');
INSERT INTO `image` VALUES (231, 'aa1960532e634c4fb8c5cbe70d3a7f9a', '4222399f198d4b1a9c1dc38485eb512f.jpg', '', '2019-08-01 21:24:35', '2019-08-01 21:24:35');
INSERT INTO `image` VALUES (232, 'aa1960532e634c4fb8c5cbe70d3a7f9a', '61758cea780f4a1d801aa153d4c71257.jpg', '', '2019-08-01 21:24:35', '2019-08-01 21:24:35');
INSERT INTO `image` VALUES (233, 'c96f8229567f4264a3cf65fe6d2fea3a', '3831b4d8cbf74685aa3ef7630139de99.jpg', '', '2019-08-01 21:28:29', '2019-08-01 21:28:29');
INSERT INTO `image` VALUES (234, 'c96f8229567f4264a3cf65fe6d2fea3a', '68b1ea39c0de4c2c80028561a036612c.jpg', '', '2019-08-01 21:28:29', '2019-08-01 21:28:29');
INSERT INTO `image` VALUES (235, '3b136df02d3d4a1e9e07e9480b443c26', '89d3364eab1e489193ebc53ab23c7109.png', '', '2019-08-01 21:30:21', '2019-08-01 21:30:21');
INSERT INTO `image` VALUES (236, '3b136df02d3d4a1e9e07e9480b443c26', '41d3a19171fa45babf6e593ffa3dcd82.png', '', '2019-08-01 21:30:21', '2019-08-01 21:30:21');
INSERT INTO `image` VALUES (238, 'cd71987c94e6476ba34c2284c9319acf', 'dd725c1aecd7455a9eb8c3b0d6e7289e.png', '', '2019-08-01 21:34:28', '2019-08-01 21:34:28');
INSERT INTO `image` VALUES (239, 'cd71987c94e6476ba34c2284c9319acf', '3b4fbecbc19f41cab962ca9f12de2fbe.png', '', '2019-08-01 21:34:28', '2019-08-01 21:34:28');
INSERT INTO `image` VALUES (240, '8c97826aecba48409b12e9248e608904', '234e04d082994286be88c70ad9e8c36f.png', '', '2019-08-01 21:35:49', '2019-08-01 21:35:49');
INSERT INTO `image` VALUES (241, '8c97826aecba48409b12e9248e608904', '260091ea0a55408b8bdbabe65eb1ef51.png', '', '2019-08-01 21:35:49', '2019-08-01 21:35:49');
INSERT INTO `image` VALUES (242, '5dcfa37040d0408fa960cb03fabc8975', 'e49f63e3c1ca4783807b31943c212fca.png', '', '2019-08-01 21:36:25', '2019-08-01 21:36:25');
INSERT INTO `image` VALUES (243, '5dcfa37040d0408fa960cb03fabc8975', 'e75c8a39c48c4fde8eae2d39a479b25a.png', '', '2019-08-01 21:36:25', '2019-08-01 21:36:25');
INSERT INTO `image` VALUES (244, '870d87e145f64e7bae77b1841ffaa543', '653995619200441b99dc751457592761.jpg', '', '2019-08-01 22:00:04', '2019-08-01 22:00:04');
INSERT INTO `image` VALUES (245, '35c7e57945e347269ec53e01e35d4202', 'f7945adfa80c4371b14b5320a90e3305.jpg', '', '2019-08-01 22:00:30', '2019-08-01 22:00:30');
INSERT INTO `image` VALUES (246, 'eb8358ade268473ca7ac9b5a3f35860c', '655eaeffc2204f18b83b4f2c55bc6098.png', '', '2019-08-01 22:42:08', '2019-08-01 22:42:08');
INSERT INTO `image` VALUES (247, 'eb8358ade268473ca7ac9b5a3f35860c', '1a26b0a002054cd487b705ec3f51621c.png', '', '2019-08-01 22:42:08', '2019-08-01 22:42:08');
INSERT INTO `image` VALUES (248, 'eb8358ade268473ca7ac9b5a3f35860c', 'b6f0257496314fda9e3ce91959b2abf7.png', '', '2019-08-01 22:42:08', '2019-08-01 22:42:08');
INSERT INTO `image` VALUES (249, '09b10f89160140efb348928663141ed5', 'ea54a9ce9753458f844d77af54555608.jpg', '', '2019-08-01 22:43:19', '2019-08-01 22:43:19');
INSERT INTO `image` VALUES (250, '09b10f89160140efb348928663141ed5', '61e84e90d69c4bffaf45ce0b0101b9c8.jpg', '', '2019-08-01 22:43:19', '2019-08-01 22:43:19');
INSERT INTO `image` VALUES (251, '09b10f89160140efb348928663141ed5', '0097b7eeae2b47869defb287ff5e4174.jpg', '', '2019-08-01 22:43:19', '2019-08-01 22:43:19');
INSERT INTO `image` VALUES (252, '09b10f89160140efb348928663141ed5', '2e606a5fc0c249f48d5f2f70cbe16be5.jpg', '', '2019-08-01 22:43:19', '2019-08-01 22:43:19');
INSERT INTO `image` VALUES (253, '09b10f89160140efb348928663141ed5', 'b359ad104136467190f4dfab09bd333c.jpg', '', '2019-08-01 22:43:19', '2019-08-01 22:43:19');
INSERT INTO `image` VALUES (254, '439fb80b380d4de8973644a2e5a90de0', '1d9f6ab023d34c519c0e2a548c4dfa8e.png', '', '2019-08-01 22:53:18', '2019-08-01 22:53:18');
INSERT INTO `image` VALUES (255, '773ac38ad95c4345bb82a1e3621a2f67', '6d7003fd04a74fbbbe9acf33397dc057.jpg', '', '2019-08-01 22:55:00', '2019-08-01 22:55:00');
INSERT INTO `image` VALUES (256, 'd85f891612b0492980e89b0bccff5596', 'bae795b9acf74405bac12b49209754c0.jpg', '', '2019-08-01 22:55:20', '2019-08-01 22:55:20');
INSERT INTO `image` VALUES (257, '781554db498d41d88999fbe226429fa4', '3fc42a75196e49c4ab8e52273edda939.jpg', '', '2019-08-01 22:55:22', '2019-08-01 22:55:22');
INSERT INTO `image` VALUES (258, '08c34f002cb24602a757a12f5145d335', '6c21dd304b964e18a66740186a0b9310.jpg', '', '2019-08-01 23:10:44', '2019-08-01 23:10:44');
INSERT INTO `image` VALUES (259, '08c34f002cb24602a757a12f5145d335', '077c1802daeb4f42b645f041cf650017.jpg', '', '2019-08-01 23:10:44', '2019-08-01 23:10:44');
INSERT INTO `image` VALUES (260, '08c34f002cb24602a757a12f5145d335', '3f5a83b036ad41078497cbe451462521.jpg', '', '2019-08-01 23:10:44', '2019-08-01 23:10:44');
INSERT INTO `image` VALUES (261, '08c34f002cb24602a757a12f5145d335', '5d1a941bdd2b41bb8337a9818f35f67b.jpg', '', '2019-08-01 23:10:44', '2019-08-01 23:10:44');
INSERT INTO `image` VALUES (263, 'f687ea24f96c4c1886f5b5fd9c03ebd3', 'd1bc9831f6cd48c99c3dd1c6d2b99b8c.jpg', '', '2019-08-01 23:17:17', '2019-08-01 23:17:17');
INSERT INTO `image` VALUES (264, 'f687ea24f96c4c1886f5b5fd9c03ebd3', 'd2df75d840aa4c3fbe72b36d34227853.jpg', '', '2019-08-01 23:17:17', '2019-08-01 23:17:17');
INSERT INTO `image` VALUES (265, 'f687ea24f96c4c1886f5b5fd9c03ebd3', '2b52138eac7049c29e0b78554b35a4ac.jpg', '', '2019-08-01 23:17:17', '2019-08-01 23:17:17');
INSERT INTO `image` VALUES (266, 'f687ea24f96c4c1886f5b5fd9c03ebd3', '3e6edd58bf6340d7a27fb27563d0cdfe.jpg', '', '2019-08-01 23:17:17', '2019-08-01 23:17:17');
INSERT INTO `image` VALUES (268, 'ae7b77bd43f14385b1671beb4a8211d9', 'f55472041a044d4f95a648ae6613a7a5.jpg', '', '2019-08-02 08:36:43', '2019-08-02 08:36:43');
INSERT INTO `image` VALUES (269, 'ae7b77bd43f14385b1671beb4a8211d9', 'f33d9f9fa6a74dc3a0744e2bd52d4939.jpeg', '', '2019-08-02 08:36:43', '2019-08-02 08:36:43');

-- ----------------------------
-- Table structure for intro
-- ----------------------------
DROP TABLE IF EXISTS `intro`;
CREATE TABLE `intro`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of intro
-- ----------------------------
INSERT INTO `intro` VALUES (62, '6ae46f900fb44fdba197d70ee54b069c', '标题', '介绍', '2019-08-01 15:13:06', '2019-08-01 15:13:06');
INSERT INTO `intro` VALUES (63, 'f2c95131a06e4e97a019a3f3fbde51ef', '钱端', '莫得money', '2019-08-01 15:14:18', '2019-08-01 15:14:18');
INSERT INTO `intro` VALUES (64, '439fb80b380d4de8973644a2e5a90de0', '多方面能受建联合', '请在此输入项目介绍', '2019-08-01 22:53:15', '2019-08-01 22:53:15');

-- ----------------------------
-- Table structure for leader
-- ----------------------------
DROP TABLE IF EXISTS `leader`;
CREATE TABLE `leader`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '身份',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leader
-- ----------------------------
INSERT INTO `leader` VALUES (1, '47ff3d372ff34010a258f2f7d7bc583a', '谢光强博士', '广东工业大学计算机学院副院长、副教授、硕士生导师', '2005年创建QG科技创新团队、第一指导教师\n个人共获各类省、市、校奖项40多项\n获得广东省教育教学成果奖（高等教育）一等奖\n广东工业大学“学生最喜爱的教师”、“十佳授课教师”、“师德标兵”\n主持和参加国家自然基金等各类科研项目30余项\n已申请专利和软件著作权共30多项\n指导学生获各类科技竞赛奖项180余项', '2019-08-01 18:19:38', '2019-08-01 21:11:36');
INSERT INTO `leader` VALUES (2, '45933278be4e42908d25e27482678e18', '李杨博士', '广东工业大学副教授、硕士生导师', '2005年至今担任QG科技创新团队指导教师 持和参加国家自然科学基金、省市科技等各类项目13项 获专利授权10项，其中发明专利1项 在国际期刊、会议和核心期刊发表论文10多篇 个人共获各类省、市、校奖项30多项 被评选为广东工业大学 “十佳授课教师” 指导学生获各类科技竞赛奖项100多项', '2019-08-01 18:21:58', '2019-08-01 18:21:58');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '时间',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '信息',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 861 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (523, '2019-08-01 09:35:08', '用户[test] 对[成员]执行了[删除]操作', '2019-08-01 09:35:08', '2019-08-01 09:35:08');
INSERT INTO `log` VALUES (524, '2019-08-01 11:07:23', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 11:07:23', '2019-08-01 11:07:23');
INSERT INTO `log` VALUES (525, '2019-08-01 11:09:16', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:09:16', '2019-08-01 11:09:16');
INSERT INTO `log` VALUES (526, '2019-08-01 11:10:26', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:10:26', '2019-08-01 11:10:26');
INSERT INTO `log` VALUES (527, '2019-08-01 11:10:30', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:10:30', '2019-08-01 11:10:30');
INSERT INTO `log` VALUES (528, '2019-08-01 11:10:34', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:10:34', '2019-08-01 11:10:34');
INSERT INTO `log` VALUES (529, '2019-08-01 11:10:37', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:10:37', '2019-08-01 11:10:37');
INSERT INTO `log` VALUES (530, '2019-08-01 11:10:42', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:10:42', '2019-08-01 11:10:42');
INSERT INTO `log` VALUES (531, '2019-08-01 11:10:45', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:10:45', '2019-08-01 11:10:45');
INSERT INTO `log` VALUES (532, '2019-08-01 11:25:20', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:25:20', '2019-08-01 11:25:20');
INSERT INTO `log` VALUES (533, '2019-08-01 11:36:09', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:36:09', '2019-08-01 11:36:09');
INSERT INTO `log` VALUES (534, '2019-08-01 11:36:09', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:36:09', '2019-08-01 11:36:09');
INSERT INTO `log` VALUES (535, '2019-08-01 11:36:33', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:36:33', '2019-08-01 11:36:33');
INSERT INTO `log` VALUES (536, '2019-08-01 11:36:33', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:36:33', '2019-08-01 11:36:33');
INSERT INTO `log` VALUES (537, '2019-08-01 11:40:40', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:40:40', '2019-08-01 11:40:40');
INSERT INTO `log` VALUES (538, '2019-08-01 11:40:41', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:40:41', '2019-08-01 11:40:41');
INSERT INTO `log` VALUES (539, '2019-08-01 11:41:27', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:41:27', '2019-08-01 11:41:27');
INSERT INTO `log` VALUES (540, '2019-08-01 11:41:27', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:41:27', '2019-08-01 11:41:27');
INSERT INTO `log` VALUES (541, '2019-08-01 11:43:13', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 11:43:13', '2019-08-01 11:43:13');
INSERT INTO `log` VALUES (542, '2019-08-01 11:43:13', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:43:13', '2019-08-01 11:43:13');
INSERT INTO `log` VALUES (543, '2019-08-01 11:43:13', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:43:13', '2019-08-01 11:43:13');
INSERT INTO `log` VALUES (544, '2019-08-01 11:43:26', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:43:26', '2019-08-01 11:43:26');
INSERT INTO `log` VALUES (545, '2019-08-01 11:43:26', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 11:43:26', '2019-08-01 11:43:26');
INSERT INTO `log` VALUES (546, '2019-08-01 11:43:26', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 11:43:26', '2019-08-01 11:43:26');
INSERT INTO `log` VALUES (547, '2019-08-01 12:22:52', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 12:22:52', '2019-08-01 12:22:52');
INSERT INTO `log` VALUES (548, '2019-08-01 12:23:06', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 12:23:06', '2019-08-01 12:23:06');
INSERT INTO `log` VALUES (549, '2019-08-01 12:27:15', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 12:27:15', '2019-08-01 12:27:15');
INSERT INTO `log` VALUES (550, '2019-08-01 12:27:26', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 12:27:26', '2019-08-01 12:27:26');
INSERT INTO `log` VALUES (551, '2019-08-01 12:29:23', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 12:29:23', '2019-08-01 12:29:23');
INSERT INTO `log` VALUES (552, '2019-08-01 12:36:31', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 12:36:31', '2019-08-01 12:36:31');
INSERT INTO `log` VALUES (553, '2019-08-01 14:13:45', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:13:45', '2019-08-01 14:13:45');
INSERT INTO `log` VALUES (554, '2019-08-01 14:14:26', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:14:26', '2019-08-01 14:14:26');
INSERT INTO `log` VALUES (555, '2019-08-01 14:15:27', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 14:15:27', '2019-08-01 14:15:27');
INSERT INTO `log` VALUES (556, '2019-08-01 14:15:35', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:15:35', '2019-08-01 14:15:35');
INSERT INTO `log` VALUES (557, '2019-08-01 14:15:37', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:15:37', '2019-08-01 14:15:37');
INSERT INTO `log` VALUES (558, '2019-08-01 14:15:52', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:15:52', '2019-08-01 14:15:52');
INSERT INTO `log` VALUES (559, '2019-08-01 14:23:05', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:23:05', '2019-08-01 14:23:05');
INSERT INTO `log` VALUES (560, '2019-08-01 14:24:21', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:24:21', '2019-08-01 14:24:21');
INSERT INTO `log` VALUES (561, '2019-08-01 14:25:58', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:25:58', '2019-08-01 14:25:58');
INSERT INTO `log` VALUES (562, '2019-08-01 14:26:54', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:26:54', '2019-08-01 14:26:54');
INSERT INTO `log` VALUES (563, '2019-08-01 14:49:01', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:49:01', '2019-08-01 14:49:01');
INSERT INTO `log` VALUES (564, '2019-08-01 14:49:04', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:49:04', '2019-08-01 14:49:04');
INSERT INTO `log` VALUES (565, '2019-08-01 14:49:08', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:49:08', '2019-08-01 14:49:08');
INSERT INTO `log` VALUES (566, '2019-08-01 14:49:12', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:49:12', '2019-08-01 14:49:12');
INSERT INTO `log` VALUES (567, '2019-08-01 14:49:15', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:49:15', '2019-08-01 14:49:15');
INSERT INTO `log` VALUES (568, '2019-08-01 14:49:19', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:49:19', '2019-08-01 14:49:19');
INSERT INTO `log` VALUES (569, '2019-08-01 14:49:22', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:49:22', '2019-08-01 14:49:22');
INSERT INTO `log` VALUES (570, '2019-08-01 14:49:26', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:49:26', '2019-08-01 14:49:26');
INSERT INTO `log` VALUES (571, '2019-08-01 14:49:30', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:49:30', '2019-08-01 14:49:30');
INSERT INTO `log` VALUES (572, '2019-08-01 14:49:43', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 14:49:43', '2019-08-01 14:49:43');
INSERT INTO `log` VALUES (573, '2019-08-01 14:49:45', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 14:49:45', '2019-08-01 14:49:45');
INSERT INTO `log` VALUES (574, '2019-08-01 14:49:45', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 14:49:45', '2019-08-01 14:49:45');
INSERT INTO `log` VALUES (575, '2019-08-01 14:50:14', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 14:50:14', '2019-08-01 14:50:14');
INSERT INTO `log` VALUES (576, '2019-08-01 14:50:14', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 14:50:14', '2019-08-01 14:50:14');
INSERT INTO `log` VALUES (577, '2019-08-01 14:50:14', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 14:50:14', '2019-08-01 14:50:14');
INSERT INTO `log` VALUES (578, '2019-08-01 14:51:03', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 14:51:03', '2019-08-01 14:51:03');
INSERT INTO `log` VALUES (579, '2019-08-01 14:51:03', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 14:51:03', '2019-08-01 14:51:03');
INSERT INTO `log` VALUES (580, '2019-08-01 14:51:03', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 14:51:03', '2019-08-01 14:51:03');
INSERT INTO `log` VALUES (581, '2019-08-01 14:51:51', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 14:51:51', '2019-08-01 14:51:51');
INSERT INTO `log` VALUES (582, '2019-08-01 14:51:51', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 14:51:51', '2019-08-01 14:51:51');
INSERT INTO `log` VALUES (583, '2019-08-01 14:51:51', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 14:51:51', '2019-08-01 14:51:51');
INSERT INTO `log` VALUES (584, '2019-08-01 14:52:31', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 14:52:31', '2019-08-01 14:52:31');
INSERT INTO `log` VALUES (585, '2019-08-01 14:52:31', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 14:52:31', '2019-08-01 14:52:31');
INSERT INTO `log` VALUES (586, '2019-08-01 14:52:31', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 14:52:31', '2019-08-01 14:52:31');
INSERT INTO `log` VALUES (587, '2019-08-01 14:53:35', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:53:35', '2019-08-01 14:53:35');
INSERT INTO `log` VALUES (588, '2019-08-01 14:53:37', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:53:37', '2019-08-01 14:53:37');
INSERT INTO `log` VALUES (589, '2019-08-01 14:53:49', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:53:49', '2019-08-01 14:53:49');
INSERT INTO `log` VALUES (590, '2019-08-01 14:54:04', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 14:54:04', '2019-08-01 14:54:04');
INSERT INTO `log` VALUES (591, '2019-08-01 14:54:04', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 14:54:04', '2019-08-01 14:54:04');
INSERT INTO `log` VALUES (592, '2019-08-01 14:54:04', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 14:54:04', '2019-08-01 14:54:04');
INSERT INTO `log` VALUES (593, '2019-08-01 14:54:52', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:54:52', '2019-08-01 14:54:52');
INSERT INTO `log` VALUES (594, '2019-08-01 14:56:08', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:56:08', '2019-08-01 14:56:08');
INSERT INTO `log` VALUES (595, '2019-08-01 14:56:10', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:56:10', '2019-08-01 14:56:10');
INSERT INTO `log` VALUES (596, '2019-08-01 14:56:22', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:56:22', '2019-08-01 14:56:22');
INSERT INTO `log` VALUES (597, '2019-08-01 14:57:36', '用户[null] 对[成员]执行了[删除]操作', '2019-08-01 14:57:36', '2019-08-01 14:57:36');
INSERT INTO `log` VALUES (598, '2019-08-01 14:58:04', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 14:58:04', '2019-08-01 14:58:04');
INSERT INTO `log` VALUES (599, '2019-08-01 15:03:56', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 15:03:56', '2019-08-01 15:03:56');
INSERT INTO `log` VALUES (600, '2019-08-01 15:08:01', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 15:08:01', '2019-08-01 15:08:01');
INSERT INTO `log` VALUES (601, '2019-08-01 15:10:18', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 15:10:18', '2019-08-01 15:10:18');
INSERT INTO `log` VALUES (602, '2019-08-01 15:10:19', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 15:10:19', '2019-08-01 15:10:19');
INSERT INTO `log` VALUES (603, '2019-08-01 15:10:19', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 15:10:19', '2019-08-01 15:10:19');
INSERT INTO `log` VALUES (604, '2019-08-01 15:10:28', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 15:10:28', '2019-08-01 15:10:28');
INSERT INTO `log` VALUES (605, '2019-08-01 15:10:28', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 15:10:28', '2019-08-01 15:10:28');
INSERT INTO `log` VALUES (606, '2019-08-01 15:10:28', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 15:10:28', '2019-08-01 15:10:28');
INSERT INTO `log` VALUES (607, '2019-08-01 15:11:22', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:22', '2019-08-01 15:11:22');
INSERT INTO `log` VALUES (608, '2019-08-01 15:11:23', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:23', '2019-08-01 15:11:23');
INSERT INTO `log` VALUES (609, '2019-08-01 15:11:29', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:29', '2019-08-01 15:11:29');
INSERT INTO `log` VALUES (610, '2019-08-01 15:11:29', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:29', '2019-08-01 15:11:29');
INSERT INTO `log` VALUES (611, '2019-08-01 15:11:36', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:36', '2019-08-01 15:11:36');
INSERT INTO `log` VALUES (612, '2019-08-01 15:11:36', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:36', '2019-08-01 15:11:36');
INSERT INTO `log` VALUES (613, '2019-08-01 15:11:40', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:40', '2019-08-01 15:11:40');
INSERT INTO `log` VALUES (614, '2019-08-01 15:11:40', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:40', '2019-08-01 15:11:40');
INSERT INTO `log` VALUES (615, '2019-08-01 15:11:46', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:46', '2019-08-01 15:11:46');
INSERT INTO `log` VALUES (616, '2019-08-01 15:11:46', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:46', '2019-08-01 15:11:46');
INSERT INTO `log` VALUES (617, '2019-08-01 15:11:52', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:52', '2019-08-01 15:11:52');
INSERT INTO `log` VALUES (618, '2019-08-01 15:11:52', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:11:52', '2019-08-01 15:11:52');
INSERT INTO `log` VALUES (619, '2019-08-01 15:12:02', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:12:02', '2019-08-01 15:12:02');
INSERT INTO `log` VALUES (620, '2019-08-01 15:12:03', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:12:03', '2019-08-01 15:12:03');
INSERT INTO `log` VALUES (621, '2019-08-01 15:12:20', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:12:20', '2019-08-01 15:12:20');
INSERT INTO `log` VALUES (622, '2019-08-01 15:12:20', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:12:20', '2019-08-01 15:12:20');
INSERT INTO `log` VALUES (623, '2019-08-01 15:12:25', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 15:12:25', '2019-08-01 15:12:25');
INSERT INTO `log` VALUES (624, '2019-08-01 15:12:25', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 15:12:25', '2019-08-01 15:12:25');
INSERT INTO `log` VALUES (625, '2019-08-01 15:12:25', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 15:12:25', '2019-08-01 15:12:25');
INSERT INTO `log` VALUES (626, '2019-08-01 15:13:06', '用户[null] 对[关于QG]执行了[插入]操作', '2019-08-01 15:13:06', '2019-08-01 15:13:06');
INSERT INTO `log` VALUES (627, '2019-08-01 15:13:08', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 15:13:08', '2019-08-01 15:13:08');
INSERT INTO `log` VALUES (628, '2019-08-01 15:13:08', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:13:08', '2019-08-01 15:13:08');
INSERT INTO `log` VALUES (629, '2019-08-01 15:13:14', '用户[null] 对[关于QG]执行了[删除]操作', '2019-08-01 15:13:14', '2019-08-01 15:13:14');
INSERT INTO `log` VALUES (630, '2019-08-01 15:13:16', '用户[null] 对[关于QG]执行了[删除]操作', '2019-08-01 15:13:16', '2019-08-01 15:13:16');
INSERT INTO `log` VALUES (631, '2019-08-01 15:13:18', '用户[null] 对[关于QG]执行了[删除]操作', '2019-08-01 15:13:18', '2019-08-01 15:13:18');
INSERT INTO `log` VALUES (632, '2019-08-01 15:13:19', '用户[null] 对[关于QG]执行了[删除]操作', '2019-08-01 15:13:19', '2019-08-01 15:13:19');
INSERT INTO `log` VALUES (633, '2019-08-01 15:13:21', '用户[null] 对[关于QG]执行了[删除]操作', '2019-08-01 15:13:21', '2019-08-01 15:13:21');
INSERT INTO `log` VALUES (634, '2019-08-01 15:13:28', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 15:13:28', '2019-08-01 15:13:28');
INSERT INTO `log` VALUES (635, '2019-08-01 15:13:28', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 15:13:28', '2019-08-01 15:13:28');
INSERT INTO `log` VALUES (636, '2019-08-01 15:13:28', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 15:13:28', '2019-08-01 15:13:28');
INSERT INTO `log` VALUES (637, '2019-08-01 15:13:29', '用户[null] 对[关于QG]执行了[删除]操作', '2019-08-01 15:13:29', '2019-08-01 15:13:29');
INSERT INTO `log` VALUES (638, '2019-08-01 15:13:58', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 15:13:58', '2019-08-01 15:13:58');
INSERT INTO `log` VALUES (639, '2019-08-01 15:13:58', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 15:13:58', '2019-08-01 15:13:58');
INSERT INTO `log` VALUES (640, '2019-08-01 15:13:58', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 15:13:58', '2019-08-01 15:13:58');
INSERT INTO `log` VALUES (641, '2019-08-01 15:14:18', '用户[null] 对[关于QG]执行了[插入]操作', '2019-08-01 15:14:18', '2019-08-01 15:14:18');
INSERT INTO `log` VALUES (642, '2019-08-01 15:14:31', '用户[null] 对[成员]执行了[插入]操作', '2019-08-01 15:14:31', '2019-08-01 15:14:31');
INSERT INTO `log` VALUES (643, '2019-08-01 15:14:31', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 15:14:31', '2019-08-01 15:14:31');
INSERT INTO `log` VALUES (644, '2019-08-01 15:14:31', '用户[null] 对[成员]执行了[更新]操作', '2019-08-01 15:14:31', '2019-08-01 15:14:31');
INSERT INTO `log` VALUES (645, '2019-08-01 15:14:33', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:14:33', '2019-08-01 15:14:33');
INSERT INTO `log` VALUES (646, '2019-08-01 15:14:33', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 15:14:33', '2019-08-01 15:14:33');
INSERT INTO `log` VALUES (647, '2019-08-01 15:14:33', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 15:14:33', '2019-08-01 15:14:33');
INSERT INTO `log` VALUES (648, '2019-08-01 15:15:00', '用户[null] 对[项目]执行了[插入]操作', '2019-08-01 15:15:00', '2019-08-01 15:15:00');
INSERT INTO `log` VALUES (649, '2019-08-01 15:15:01', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 15:15:01', '2019-08-01 15:15:01');
INSERT INTO `log` VALUES (650, '2019-08-01 15:15:05', '用户[null] 对[项目]执行了[删除]操作', '2019-08-01 15:15:05', '2019-08-01 15:15:05');
INSERT INTO `log` VALUES (651, '2019-08-01 15:15:07', '用户[null] 对[项目]执行了[删除]操作', '2019-08-01 15:15:07', '2019-08-01 15:15:07');
INSERT INTO `log` VALUES (652, '2019-08-01 15:15:30', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 15:15:30', '2019-08-01 15:15:30');
INSERT INTO `log` VALUES (653, '2019-08-01 15:16:29', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 15:16:29', '2019-08-01 15:16:29');
INSERT INTO `log` VALUES (654, '2019-08-01 15:20:20', '用户[null] 对[项目]执行了[插入]操作', '2019-08-01 15:20:20', '2019-08-01 15:20:20');
INSERT INTO `log` VALUES (655, '2019-08-01 15:20:22', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 15:20:22', '2019-08-01 15:20:22');
INSERT INTO `log` VALUES (656, '2019-08-01 15:23:20', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 15:23:20', '2019-08-01 15:23:20');
INSERT INTO `log` VALUES (657, '2019-08-01 15:32:57', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 15:32:57', '2019-08-01 15:32:57');
INSERT INTO `log` VALUES (658, '2019-08-01 15:38:51', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 15:38:51', '2019-08-01 15:38:51');
INSERT INTO `log` VALUES (659, '2019-08-01 15:39:34', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 15:39:34', '2019-08-01 15:39:34');
INSERT INTO `log` VALUES (660, '2019-08-01 15:39:48', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 15:39:48', '2019-08-01 15:39:48');
INSERT INTO `log` VALUES (661, '2019-08-01 15:40:12', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 15:40:12', '2019-08-01 15:40:12');
INSERT INTO `log` VALUES (662, '2019-08-01 15:40:38', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 15:40:38', '2019-08-01 15:40:38');
INSERT INTO `log` VALUES (663, '2019-08-01 15:40:55', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 15:40:55', '2019-08-01 15:40:55');
INSERT INTO `log` VALUES (664, '2019-08-01 15:41:08', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 15:41:08', '2019-08-01 15:41:08');
INSERT INTO `log` VALUES (665, '2019-08-01 16:04:49', '用户[null] 对[QG特色]执行了[插入]操作', '2019-08-01 16:04:49', '2019-08-01 16:04:49');
INSERT INTO `log` VALUES (666, '2019-08-01 16:10:18', '用户[null] 对[专利]执行了[更新]操作', '2019-08-01 16:10:18', '2019-08-01 16:10:18');
INSERT INTO `log` VALUES (667, '2019-08-01 16:10:27', '用户[null] 对[QG特色]执行了[插入]操作', '2019-08-01 16:10:27', '2019-08-01 16:10:27');
INSERT INTO `log` VALUES (668, '2019-08-01 16:15:41', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 16:15:41', '2019-08-01 16:15:41');
INSERT INTO `log` VALUES (669, '2019-08-01 16:15:45', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 16:15:45', '2019-08-01 16:15:45');
INSERT INTO `log` VALUES (670, '2019-08-01 16:15:47', '用户[null] 对[QG特色]执行了[插入]操作', '2019-08-01 16:15:47', '2019-08-01 16:15:47');
INSERT INTO `log` VALUES (671, '2019-08-01 16:20:29', '用户[null] 对[QG特色]执行了[删除]操作', '2019-08-01 16:20:29', '2019-08-01 16:20:29');
INSERT INTO `log` VALUES (672, '2019-08-01 16:20:29', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 16:20:29', '2019-08-01 16:20:29');
INSERT INTO `log` VALUES (673, '2019-08-01 16:31:54', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 16:31:54', '2019-08-01 16:31:54');
INSERT INTO `log` VALUES (674, '2019-08-01 17:11:28', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 17:11:28', '2019-08-01 17:11:28');
INSERT INTO `log` VALUES (675, '2019-08-01 17:11:57', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 17:11:57', '2019-08-01 17:11:57');
INSERT INTO `log` VALUES (676, '2019-08-01 17:11:57', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 17:11:57', '2019-08-01 17:11:57');
INSERT INTO `log` VALUES (677, '2019-08-01 17:30:45', '用户[null] 对[QG特色]执行了[插入]操作', '2019-08-01 17:30:45', '2019-08-01 17:30:45');
INSERT INTO `log` VALUES (678, '2019-08-01 17:30:50', '用户[null] 对[QG特色]执行了[删除]操作', '2019-08-01 17:30:50', '2019-08-01 17:30:50');
INSERT INTO `log` VALUES (679, '2019-08-01 17:30:50', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 17:30:50', '2019-08-01 17:30:50');
INSERT INTO `log` VALUES (680, '2019-08-01 18:02:42', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 18:02:42', '2019-08-01 18:02:42');
INSERT INTO `log` VALUES (681, '2019-08-01 18:19:38', '用户[null] 对[指导老师]执行了[插入]操作', '2019-08-01 18:19:38', '2019-08-01 18:19:38');
INSERT INTO `log` VALUES (682, '2019-08-01 18:20:11', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 18:20:11', '2019-08-01 18:20:11');
INSERT INTO `log` VALUES (683, '2019-08-01 18:20:11', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 18:20:11', '2019-08-01 18:20:11');
INSERT INTO `log` VALUES (684, '2019-08-01 18:21:59', '用户[null] 对[指导老师]执行了[插入]操作', '2019-08-01 18:21:59', '2019-08-01 18:21:59');
INSERT INTO `log` VALUES (685, '2019-08-01 18:22:18', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 18:22:18', '2019-08-01 18:22:18');
INSERT INTO `log` VALUES (686, '2019-08-01 18:22:18', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 18:22:18', '2019-08-01 18:22:18');
INSERT INTO `log` VALUES (687, '2019-08-01 18:29:32', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 18:29:32', '2019-08-01 18:29:32');
INSERT INTO `log` VALUES (688, '2019-08-01 18:30:20', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 18:30:20', '2019-08-01 18:30:20');
INSERT INTO `log` VALUES (689, '2019-08-01 18:31:11', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 18:31:11', '2019-08-01 18:31:11');
INSERT INTO `log` VALUES (690, '2019-08-01 18:31:23', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 18:31:23', '2019-08-01 18:31:23');
INSERT INTO `log` VALUES (691, '2019-08-01 18:31:26', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 18:31:26', '2019-08-01 18:31:26');
INSERT INTO `log` VALUES (692, '2019-08-01 18:31:41', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 18:31:41', '2019-08-01 18:31:41');
INSERT INTO `log` VALUES (693, '2019-08-01 19:05:00', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 19:05:00', '2019-08-01 19:05:00');
INSERT INTO `log` VALUES (694, '2019-08-01 19:05:07', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 19:05:07', '2019-08-01 19:05:07');
INSERT INTO `log` VALUES (695, '2019-08-01 19:05:08', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 19:05:08', '2019-08-01 19:05:08');
INSERT INTO `log` VALUES (696, '2019-08-01 19:05:08', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 19:05:08', '2019-08-01 19:05:08');
INSERT INTO `log` VALUES (697, '2019-08-01 19:05:35', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 19:05:35', '2019-08-01 19:05:35');
INSERT INTO `log` VALUES (698, '2019-08-01 19:19:29', '用户[null] 对[奖项]执行了[删除]操作', '2019-08-01 19:19:29', '2019-08-01 19:19:29');
INSERT INTO `log` VALUES (699, '2019-08-01 19:19:29', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 19:19:29', '2019-08-01 19:19:29');
INSERT INTO `log` VALUES (700, '2019-08-01 19:37:00', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 19:37:00', '2019-08-01 19:37:00');
INSERT INTO `log` VALUES (701, '2019-08-01 19:37:34', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 19:37:34', '2019-08-01 19:37:34');
INSERT INTO `log` VALUES (702, '2019-08-01 20:07:10', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 20:07:10', '2019-08-01 20:07:10');
INSERT INTO `log` VALUES (703, '2019-08-01 20:08:10', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 20:08:10', '2019-08-01 20:08:10');
INSERT INTO `log` VALUES (704, '2019-08-01 20:08:24', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:08:24', '2019-08-01 20:08:24');
INSERT INTO `log` VALUES (705, '2019-08-01 20:08:26', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:08:26', '2019-08-01 20:08:26');
INSERT INTO `log` VALUES (706, '2019-08-01 20:08:38', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:08:38', '2019-08-01 20:08:38');
INSERT INTO `log` VALUES (707, '2019-08-01 20:08:41', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:08:41', '2019-08-01 20:08:41');
INSERT INTO `log` VALUES (708, '2019-08-01 20:09:09', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:09:09', '2019-08-01 20:09:09');
INSERT INTO `log` VALUES (709, '2019-08-01 20:12:52', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:12:52', '2019-08-01 20:12:52');
INSERT INTO `log` VALUES (710, '2019-08-01 20:12:53', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:12:53', '2019-08-01 20:12:53');
INSERT INTO `log` VALUES (711, '2019-08-01 20:12:56', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:12:56', '2019-08-01 20:12:56');
INSERT INTO `log` VALUES (712, '2019-08-01 20:13:00', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:13:00', '2019-08-01 20:13:00');
INSERT INTO `log` VALUES (713, '2019-08-01 20:13:09', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:13:09', '2019-08-01 20:13:09');
INSERT INTO `log` VALUES (714, '2019-08-01 20:13:12', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:13:12', '2019-08-01 20:13:12');
INSERT INTO `log` VALUES (715, '2019-08-01 20:13:35', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 20:13:35', '2019-08-01 20:13:35');
INSERT INTO `log` VALUES (716, '2019-08-01 20:14:56', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 20:14:56', '2019-08-01 20:14:56');
INSERT INTO `log` VALUES (717, '2019-08-01 20:16:21', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:16:21', '2019-08-01 20:16:21');
INSERT INTO `log` VALUES (718, '2019-08-01 20:18:27', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:18:27', '2019-08-01 20:18:27');
INSERT INTO `log` VALUES (719, '2019-08-01 20:18:29', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:18:29', '2019-08-01 20:18:29');
INSERT INTO `log` VALUES (720, '2019-08-01 20:18:32', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:18:32', '2019-08-01 20:18:32');
INSERT INTO `log` VALUES (721, '2019-08-01 20:23:57', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:23:57', '2019-08-01 20:23:57');
INSERT INTO `log` VALUES (722, '2019-08-01 20:26:50', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 20:26:50', '2019-08-01 20:26:50');
INSERT INTO `log` VALUES (723, '2019-08-01 20:26:55', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 20:26:55', '2019-08-01 20:26:55');
INSERT INTO `log` VALUES (724, '2019-08-01 20:26:57', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 20:26:57', '2019-08-01 20:26:57');
INSERT INTO `log` VALUES (725, '2019-08-01 20:27:06', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 20:27:06', '2019-08-01 20:27:06');
INSERT INTO `log` VALUES (726, '2019-08-01 20:27:15', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 20:27:15', '2019-08-01 20:27:15');
INSERT INTO `log` VALUES (727, '2019-08-01 20:27:41', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 20:27:41', '2019-08-01 20:27:41');
INSERT INTO `log` VALUES (728, '2019-08-01 20:28:30', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 20:28:30', '2019-08-01 20:28:30');
INSERT INTO `log` VALUES (729, '2019-08-01 20:34:16', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:34:16', '2019-08-01 20:34:16');
INSERT INTO `log` VALUES (730, '2019-08-01 20:40:53', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:40:53', '2019-08-01 20:40:53');
INSERT INTO `log` VALUES (731, '2019-08-01 20:41:52', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:41:52', '2019-08-01 20:41:52');
INSERT INTO `log` VALUES (732, '2019-08-01 20:47:52', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:47:52', '2019-08-01 20:47:52');
INSERT INTO `log` VALUES (733, '2019-08-01 20:48:17', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:48:17', '2019-08-01 20:48:17');
INSERT INTO `log` VALUES (734, '2019-08-01 20:48:29', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:48:29', '2019-08-01 20:48:29');
INSERT INTO `log` VALUES (735, '2019-08-01 20:49:34', '用户[null] 对[重要时刻]执行了[插入]操作', '2019-08-01 20:49:34', '2019-08-01 20:49:34');
INSERT INTO `log` VALUES (736, '2019-08-01 20:50:18', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:50:18', '2019-08-01 20:50:18');
INSERT INTO `log` VALUES (737, '2019-08-01 20:50:18', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:50:18', '2019-08-01 20:50:18');
INSERT INTO `log` VALUES (738, '2019-08-01 20:50:51', '用户[null] 对[重要时刻]执行了[插入]操作', '2019-08-01 20:50:51', '2019-08-01 20:50:51');
INSERT INTO `log` VALUES (739, '2019-08-01 20:51:04', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 20:51:04', '2019-08-01 20:51:04');
INSERT INTO `log` VALUES (740, '2019-08-01 20:51:04', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:51:04', '2019-08-01 20:51:04');
INSERT INTO `log` VALUES (741, '2019-08-01 20:54:00', '用户[null] 对[重要时刻]执行了[更新]操作', '2019-08-01 20:54:00', '2019-08-01 20:54:00');
INSERT INTO `log` VALUES (742, '2019-08-01 21:00:30', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 21:00:30', '2019-08-01 21:00:30');
INSERT INTO `log` VALUES (743, '2019-08-01 21:01:00', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 21:01:00', '2019-08-01 21:01:00');
INSERT INTO `log` VALUES (744, '2019-08-01 21:09:41', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 21:09:41', '2019-08-01 21:09:41');
INSERT INTO `log` VALUES (745, '2019-08-01 21:11:13', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 21:11:13', '2019-08-01 21:11:13');
INSERT INTO `log` VALUES (746, '2019-08-01 21:11:36', '用户[null] 对[指导老师]执行了[更新]操作', '2019-08-01 21:11:36', '2019-08-01 21:11:36');
INSERT INTO `log` VALUES (747, '2019-08-01 21:17:10', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 21:17:10', '2019-08-01 21:17:10');
INSERT INTO `log` VALUES (748, '2019-08-01 21:17:55', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 21:17:55', '2019-08-01 21:17:55');
INSERT INTO `log` VALUES (749, '2019-08-01 21:18:13', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 21:18:13', '2019-08-01 21:18:13');
INSERT INTO `log` VALUES (750, '2019-08-01 21:20:12', '用户[null] 对[QG大事记]执行了[插入]操作', '2019-08-01 21:20:12', '2019-08-01 21:20:12');
INSERT INTO `log` VALUES (751, '2019-08-01 21:20:35', '用户[null] 对[QG特色]执行了[更新]操作', '2019-08-01 21:20:35', '2019-08-01 21:20:35');
INSERT INTO `log` VALUES (752, '2019-08-01 21:20:59', '用户[null] 对[QG大事记]执行了[插入]操作', '2019-08-01 21:20:59', '2019-08-01 21:20:59');
INSERT INTO `log` VALUES (753, '2019-08-01 21:21:13', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 21:21:13', '2019-08-01 21:21:13');
INSERT INTO `log` VALUES (754, '2019-08-01 21:21:20', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 21:21:20', '2019-08-01 21:21:20');
INSERT INTO `log` VALUES (755, '2019-08-01 21:22:06', '用户[null] 对[研究方向]执行了[删除]操作', '2019-08-01 21:22:06', '2019-08-01 21:22:06');
INSERT INTO `log` VALUES (756, '2019-08-01 21:22:06', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:22:06', '2019-08-01 21:22:06');
INSERT INTO `log` VALUES (757, '2019-08-01 21:22:16', '用户[null] 对[研究方向]执行了[删除]操作', '2019-08-01 21:22:16', '2019-08-01 21:22:16');
INSERT INTO `log` VALUES (758, '2019-08-01 21:22:16', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:22:16', '2019-08-01 21:22:16');
INSERT INTO `log` VALUES (759, '2019-08-01 21:22:24', '用户[null] 对[研究方向]执行了[删除]操作', '2019-08-01 21:22:24', '2019-08-01 21:22:24');
INSERT INTO `log` VALUES (760, '2019-08-01 21:22:24', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:22:24', '2019-08-01 21:22:24');
INSERT INTO `log` VALUES (761, '2019-08-01 21:23:10', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 21:23:10', '2019-08-01 21:23:10');
INSERT INTO `log` VALUES (762, '2019-08-01 21:24:35', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:24:35', '2019-08-01 21:24:35');
INSERT INTO `log` VALUES (763, '2019-08-01 21:24:35', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 21:24:35', '2019-08-01 21:24:35');
INSERT INTO `log` VALUES (764, '2019-08-01 21:27:18', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 21:27:18', '2019-08-01 21:27:18');
INSERT INTO `log` VALUES (765, '2019-08-01 21:28:29', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:28:29', '2019-08-01 21:28:29');
INSERT INTO `log` VALUES (766, '2019-08-01 21:28:29', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 21:28:29', '2019-08-01 21:28:29');
INSERT INTO `log` VALUES (767, '2019-08-01 21:29:24', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 21:29:24', '2019-08-01 21:29:24');
INSERT INTO `log` VALUES (768, '2019-08-01 21:29:58', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 21:29:58', '2019-08-01 21:29:58');
INSERT INTO `log` VALUES (769, '2019-08-01 21:30:21', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:30:21', '2019-08-01 21:30:21');
INSERT INTO `log` VALUES (770, '2019-08-01 21:30:21', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 21:30:21', '2019-08-01 21:30:21');
INSERT INTO `log` VALUES (771, '2019-08-01 21:30:39', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 21:30:39', '2019-08-01 21:30:39');
INSERT INTO `log` VALUES (772, '2019-08-01 21:33:55', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:33:55', '2019-08-01 21:33:55');
INSERT INTO `log` VALUES (773, '2019-08-01 21:33:55', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 21:33:55', '2019-08-01 21:33:55');
INSERT INTO `log` VALUES (774, '2019-08-01 21:34:28', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:34:28', '2019-08-01 21:34:28');
INSERT INTO `log` VALUES (775, '2019-08-01 21:34:28', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 21:34:28', '2019-08-01 21:34:28');
INSERT INTO `log` VALUES (776, '2019-08-01 21:34:49', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 21:34:49', '2019-08-01 21:34:49');
INSERT INTO `log` VALUES (777, '2019-08-01 21:35:49', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:35:49', '2019-08-01 21:35:49');
INSERT INTO `log` VALUES (778, '2019-08-01 21:35:49', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 21:35:49', '2019-08-01 21:35:49');
INSERT INTO `log` VALUES (779, '2019-08-01 21:36:10', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-01 21:36:10', '2019-08-01 21:36:10');
INSERT INTO `log` VALUES (780, '2019-08-01 21:36:25', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 21:36:25', '2019-08-01 21:36:25');
INSERT INTO `log` VALUES (781, '2019-08-01 21:36:25', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-01 21:36:25', '2019-08-01 21:36:25');
INSERT INTO `log` VALUES (782, '2019-08-01 21:51:51', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 21:51:51', '2019-08-01 21:51:51');
INSERT INTO `log` VALUES (783, '2019-08-01 21:51:53', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 21:51:53', '2019-08-01 21:51:53');
INSERT INTO `log` VALUES (784, '2019-08-01 21:52:39', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 21:52:39', '2019-08-01 21:52:39');
INSERT INTO `log` VALUES (785, '2019-08-01 21:53:09', '用户[null] 对[QG大事记]执行了[插入]操作', '2019-08-01 21:53:09', '2019-08-01 21:53:09');
INSERT INTO `log` VALUES (786, '2019-08-01 21:53:26', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 21:53:26', '2019-08-01 21:53:26');
INSERT INTO `log` VALUES (787, '2019-08-01 21:54:20', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 21:54:20', '2019-08-01 21:54:20');
INSERT INTO `log` VALUES (788, '2019-08-01 21:57:39', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 21:57:39', '2019-08-01 21:57:39');
INSERT INTO `log` VALUES (789, '2019-08-01 22:00:04', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 22:00:04', '2019-08-01 22:00:04');
INSERT INTO `log` VALUES (790, '2019-08-01 22:00:04', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 22:00:04', '2019-08-01 22:00:04');
INSERT INTO `log` VALUES (791, '2019-08-01 22:00:12', '用户[null] 对[QG大事记]执行了[删除]操作', '2019-08-01 22:00:12', '2019-08-01 22:00:12');
INSERT INTO `log` VALUES (792, '2019-08-01 22:00:29', '用户[null] 对[QG大事记]执行了[插入]操作', '2019-08-01 22:00:29', '2019-08-01 22:00:29');
INSERT INTO `log` VALUES (793, '2019-08-01 22:00:31', '用户[null] 对[QG大事记]执行了[更新]操作', '2019-08-01 22:00:31', '2019-08-01 22:00:31');
INSERT INTO `log` VALUES (794, '2019-08-01 22:42:08', '用户[null] 对[最近的荣誉]执行了[更新]操作', '2019-08-01 22:42:08', '2019-08-01 22:42:08');
INSERT INTO `log` VALUES (795, '2019-08-01 22:43:19', '用户[null] 对[最近的荣誉]执行了[更新]操作', '2019-08-01 22:43:19', '2019-08-01 22:43:19');
INSERT INTO `log` VALUES (796, '2019-08-01 22:44:35', '用户[null] 对[最近的荣誉]执行了[删除]操作', '2019-08-01 22:44:35', '2019-08-01 22:44:35');
INSERT INTO `log` VALUES (797, '2019-08-01 22:53:15', '用户[null] 对[关于QG]执行了[插入]操作', '2019-08-01 22:53:15', '2019-08-01 22:53:15');
INSERT INTO `log` VALUES (798, '2019-08-01 22:53:18', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 22:53:18', '2019-08-01 22:53:18');
INSERT INTO `log` VALUES (799, '2019-08-01 22:53:18', '用户[null] 对[关于QG]执行了[更新]操作', '2019-08-01 22:53:18', '2019-08-01 22:53:18');
INSERT INTO `log` VALUES (800, '2019-08-01 22:54:11', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 22:54:11', '2019-08-01 22:54:11');
INSERT INTO `log` VALUES (801, '2019-08-01 22:54:17', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 22:54:17', '2019-08-01 22:54:17');
INSERT INTO `log` VALUES (802, '2019-08-01 22:54:29', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 22:54:29', '2019-08-01 22:54:29');
INSERT INTO `log` VALUES (803, '2019-08-01 22:54:58', '用户[null] 对[项目]执行了[插入]操作', '2019-08-01 22:54:58', '2019-08-01 22:54:58');
INSERT INTO `log` VALUES (804, '2019-08-01 22:55:00', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 22:55:00', '2019-08-01 22:55:00');
INSERT INTO `log` VALUES (805, '2019-08-01 22:55:20', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 22:55:20', '2019-08-01 22:55:20');
INSERT INTO `log` VALUES (806, '2019-08-01 22:55:20', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 22:55:20', '2019-08-01 22:55:20');
INSERT INTO `log` VALUES (807, '2019-08-01 22:55:22', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 22:55:22', '2019-08-01 22:55:22');
INSERT INTO `log` VALUES (808, '2019-08-01 22:55:22', '用户[null] 对[项目]执行了[更新]操作', '2019-08-01 22:55:22', '2019-08-01 22:55:22');
INSERT INTO `log` VALUES (809, '2019-08-01 23:10:10', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-01 23:10:10', '2019-08-01 23:10:10');
INSERT INTO `log` VALUES (810, '2019-08-01 23:10:44', '用户[null] 对[最近的荣誉]执行了[更新]操作', '2019-08-01 23:10:44', '2019-08-01 23:10:44');
INSERT INTO `log` VALUES (811, '2019-08-01 23:11:23', '用户[null] 对[最近的荣誉]执行了[更新]操作', '2019-08-01 23:11:23', '2019-08-01 23:11:23');
INSERT INTO `log` VALUES (812, '2019-08-01 23:11:58', '用户[null] 对[最近的荣誉]执行了[删除]操作', '2019-08-01 23:11:58', '2019-08-01 23:11:58');
INSERT INTO `log` VALUES (813, '2019-08-01 23:14:26', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-01 23:14:26', '2019-08-01 23:14:26');
INSERT INTO `log` VALUES (814, '2019-08-01 23:14:43', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-01 23:14:43', '2019-08-01 23:14:43');
INSERT INTO `log` VALUES (815, '2019-08-01 23:15:09', '用户[null] 对[最近的荣誉]执行了[删除]操作', '2019-08-01 23:15:09', '2019-08-01 23:15:09');
INSERT INTO `log` VALUES (816, '2019-08-01 23:15:09', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 23:15:09', '2019-08-01 23:15:09');
INSERT INTO `log` VALUES (817, '2019-08-01 23:17:17', '用户[null] 对[最近的荣誉]执行了[更新]操作', '2019-08-01 23:17:17', '2019-08-01 23:17:17');
INSERT INTO `log` VALUES (818, '2019-08-01 23:27:11', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-01 23:27:11', '2019-08-01 23:27:11');
INSERT INTO `log` VALUES (819, '2019-08-01 23:45:33', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 23:45:33', '2019-08-01 23:45:33');
INSERT INTO `log` VALUES (820, '2019-08-01 23:45:33', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 23:45:33', '2019-08-01 23:45:33');
INSERT INTO `log` VALUES (821, '2019-08-01 23:45:39', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 23:45:39', '2019-08-01 23:45:39');
INSERT INTO `log` VALUES (822, '2019-08-01 23:45:39', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 23:45:39', '2019-08-01 23:45:39');
INSERT INTO `log` VALUES (823, '2019-08-01 23:46:36', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 23:46:36', '2019-08-01 23:46:36');
INSERT INTO `log` VALUES (824, '2019-08-01 23:46:36', '用户[null] 对[首页信息]执行了[更新]操作', '2019-08-01 23:46:36', '2019-08-01 23:46:36');
INSERT INTO `log` VALUES (825, '2019-08-02 08:18:41', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:18:41', '2019-08-02 08:18:41');
INSERT INTO `log` VALUES (826, '2019-08-02 08:18:54', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:18:54', '2019-08-02 08:18:54');
INSERT INTO `log` VALUES (827, '2019-08-02 08:19:10', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:19:10', '2019-08-02 08:19:10');
INSERT INTO `log` VALUES (828, '2019-08-02 08:19:42', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:19:42', '2019-08-02 08:19:42');
INSERT INTO `log` VALUES (829, '2019-08-02 08:20:15', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:20:15', '2019-08-02 08:20:15');
INSERT INTO `log` VALUES (830, '2019-08-02 08:21:09', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:21:09', '2019-08-02 08:21:09');
INSERT INTO `log` VALUES (831, '2019-08-02 08:21:43', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:21:43', '2019-08-02 08:21:43');
INSERT INTO `log` VALUES (832, '2019-08-02 08:22:58', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:22:58', '2019-08-02 08:22:58');
INSERT INTO `log` VALUES (833, '2019-08-02 08:24:26', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:24:26', '2019-08-02 08:24:26');
INSERT INTO `log` VALUES (834, '2019-08-02 08:29:29', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:29:29', '2019-08-02 08:29:29');
INSERT INTO `log` VALUES (835, '2019-08-02 08:30:14', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:30:14', '2019-08-02 08:30:14');
INSERT INTO `log` VALUES (836, '2019-08-02 08:32:37', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:32:37', '2019-08-02 08:32:37');
INSERT INTO `log` VALUES (837, '2019-08-02 08:32:45', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:32:45', '2019-08-02 08:32:45');
INSERT INTO `log` VALUES (838, '2019-08-02 08:34:17', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:34:17', '2019-08-02 08:34:17');
INSERT INTO `log` VALUES (839, '2019-08-02 08:35:05', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-02 08:35:05', '2019-08-02 08:35:05');
INSERT INTO `log` VALUES (840, '2019-08-02 08:35:29', '用户[null] 对[研究方向]执行了[删除]操作', '2019-08-02 08:35:29', '2019-08-02 08:35:29');
INSERT INTO `log` VALUES (841, '2019-08-02 08:35:29', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-02 08:35:29', '2019-08-02 08:35:29');
INSERT INTO `log` VALUES (842, '2019-08-02 08:35:54', '用户[null] 对[研究方向]执行了[插入]操作', '2019-08-02 08:35:54', '2019-08-02 08:35:54');
INSERT INTO `log` VALUES (843, '2019-08-02 08:36:07', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-02 08:36:07', '2019-08-02 08:36:07');
INSERT INTO `log` VALUES (844, '2019-08-02 08:36:07', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:36:07', '2019-08-02 08:36:07');
INSERT INTO `log` VALUES (845, '2019-08-02 08:36:43', '用户[null] 对[首页信息]执行了[删除]操作', '2019-08-02 08:36:43', '2019-08-02 08:36:43');
INSERT INTO `log` VALUES (846, '2019-08-02 08:36:43', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:36:43', '2019-08-02 08:36:43');
INSERT INTO `log` VALUES (847, '2019-08-02 08:36:59', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:36:59', '2019-08-02 08:36:59');
INSERT INTO `log` VALUES (848, '2019-08-02 08:37:19', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:37:19', '2019-08-02 08:37:19');
INSERT INTO `log` VALUES (849, '2019-08-02 08:37:27', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:37:27', '2019-08-02 08:37:27');
INSERT INTO `log` VALUES (850, '2019-08-02 08:42:43', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-02 08:42:43', '2019-08-02 08:42:43');
INSERT INTO `log` VALUES (851, '2019-08-02 08:43:26', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-02 08:43:26', '2019-08-02 08:43:26');
INSERT INTO `log` VALUES (852, '2019-08-02 08:43:58', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-02 08:43:58', '2019-08-02 08:43:58');
INSERT INTO `log` VALUES (853, '2019-08-02 08:44:01', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-02 08:44:01', '2019-08-02 08:44:01');
INSERT INTO `log` VALUES (854, '2019-08-02 08:44:10', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-02 08:44:10', '2019-08-02 08:44:10');
INSERT INTO `log` VALUES (855, '2019-08-02 08:48:14', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-02 08:48:14', '2019-08-02 08:48:14');
INSERT INTO `log` VALUES (856, '2019-08-02 08:48:33', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:48:33', '2019-08-02 08:48:33');
INSERT INTO `log` VALUES (857, '2019-08-02 08:48:42', '用户[null] 对[最近的荣誉]执行了[插入]操作', '2019-08-02 08:48:42', '2019-08-02 08:48:42');
INSERT INTO `log` VALUES (858, '2019-08-02 08:49:00', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:49:00', '2019-08-02 08:49:00');
INSERT INTO `log` VALUES (859, '2019-08-02 08:49:10', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:49:10', '2019-08-02 08:49:10');
INSERT INTO `log` VALUES (860, '2019-08-02 08:49:24', '用户[null] 对[研究方向]执行了[更新]操作', '2019-08-02 08:49:24', '2019-08-02 08:49:24');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '年级',
  `field` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '组别',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (23, 'c3bfc26ee05c45a88d5b754f6d3a92ef', '曾华琛', '2017', '后台组', '2019-07-28 11:23:23', '2019-07-28 11:23:23');
INSERT INTO `member` VALUES (60, 'bc47a73f059848a5adadc606c86713e3', '测试', '2018', '后台组', '2019-08-01 11:43:13', '2019-08-01 11:43:13');
INSERT INTO `member` VALUES (61, '27391496bbb6421fa75a415df91ef0fb', '科比', '2019', '后台组', '2019-08-01 14:50:14', '2019-08-01 14:50:14');
INSERT INTO `member` VALUES (62, 'df6007eee0b74c08a5489490a55ceb5e', '沙雕网友', '2018', '前端组', '2019-08-01 14:51:03', '2019-08-01 14:51:03');
INSERT INTO `member` VALUES (63, 'cdd7110b3f2c46359f52b12d7c4900b5', '雨女无瓜', '2018', '嵌入式组', '2019-08-01 14:51:51', '2019-08-01 14:51:51');
INSERT INTO `member` VALUES (64, '2fae7655b01249b28dd2ee160123cf00', '郭沛', '2018', '后台组', '2019-08-01 14:52:31', '2019-08-01 14:52:31');
INSERT INTO `member` VALUES (65, '261ef7942683451a8435ab2a78290533', '天线宝宝', '2019', '后台组', '2019-08-01 14:54:04', '2019-08-01 14:54:04');
INSERT INTO `member` VALUES (66, '7b525c5f2dd3404b97c20ffebccaa5e2', '拉拉', '2018', '后台组', '2019-08-01 15:10:18', '2019-08-01 15:10:18');
INSERT INTO `member` VALUES (67, '2d28eabe7af5437c8a2c42c77829804d', '嘤嘤', '2018', '移动组', '2019-08-01 15:12:25', '2019-08-01 15:12:25');
INSERT INTO `member` VALUES (68, '09d0924042c94195bffdbcf50108d5e3', '坤坤', '2018', '移动组', '2019-08-01 15:13:28', '2019-08-01 15:13:28');
INSERT INTO `member` VALUES (69, '374c998c7e624b97a09e8548e9c038a4', '小卡', '2018', '后台组', '2019-08-01 15:13:58', '2019-08-01 15:13:58');
INSERT INTO `member` VALUES (70, '1b999979b51e41f5ab4db5dd37c759a0', '库先生', '2018', '后台组', '2019-08-01 15:14:31', '2019-08-01 15:14:31');

-- ----------------------------
-- Table structure for moment
-- ----------------------------
DROP TABLE IF EXISTS `moment`;
CREATE TABLE `moment`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of moment
-- ----------------------------
INSERT INTO `moment` VALUES (1, '36655e2d21d044e3a6b379fb83176c14', '大闹天宫', '2019-07-29 15:47:03', '2019-08-01 20:48:29');
INSERT INTO `moment` VALUES (2, '5eaea895db444427b74ef81100311cc5', 'QG工作室成员方锦基于2017年在人民大会堂接受“小平科技创新团队”表彰', '2019-08-01 20:49:34', '2019-08-01 20:49:34');
INSERT INTO `moment` VALUES (3, 'fcc5b8b5203841c7bd70dbf91b340846', '2019年获“五四青年奖章”团体奖提名奖', '2019-08-01 20:50:51', '2019-08-01 20:50:51');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` smallint(6) UNSIGNED NOT NULL DEFAULT 0 COMMENT '序号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '链接',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, 0, '第二十一届“广东青年五四奖章” 候选人选公示公告', 'https://mp.weixin.qq.com/s/VK74vo-Skqy_EB1RArpWBQ', '2019-07-31 12:02:31', '2019-07-31 12:02:31');
INSERT INTO `news` VALUES (2, 0, '南方卫视采访QG工作室,曾华琛接受采访', 'https://v.qq.com/x/cover/aon28ztgjgljgk4/j00305qzj1g.html', '2019-07-31 12:02:51', '2019-07-31 20:35:36');
INSERT INTO `news` VALUES (3, 0, '我校“QG工作室”获 大学生“小平科技创新团队”称号', 'http://news.gdut.edu.cn/viewarticle.aspx?articleid=132732', '2019-07-31 16:13:10', '2019-07-31 20:24:02');

-- ----------------------------
-- Table structure for patent
-- ----------------------------
DROP TABLE IF EXISTS `patent`;
CREATE TABLE `patent`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` smallint(6) UNSIGNED NOT NULL DEFAULT 0 COMMENT '序号',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类型',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `zl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '专利号',
  `inventor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '发明人',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patent
-- ----------------------------
INSERT INTO `patent` VALUES (2, 0, '的事情我都2', '热个人', '但是服务费2', '十多个微软', '2019-07-31 15:45:39', '2019-07-31 15:45:39');
INSERT INTO `patent` VALUES (3, 0, '实用新型专利', '一种可穿戴设备电源管理装置\n', 'ZL 2017 2 0632371.0', '方锦基、谢光强、陈济斌、李杨、张盛强、黄冠恒、梁智豪、陈文戈', '2019-07-31 16:13:40', '2019-08-01 16:10:18');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '全局id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (3, '781554db498d41d88999fbe226429fa4', '图书馆', '对是否会受到否为独孤般若三个代表发现2', '2019-08-01 15:15:00', '2019-08-01 22:55:22');
INSERT INTO `project` VALUES (4, 'd85f891612b0492980e89b0bccff5596', '五六饭APP订购智能服务', '为广工大学子提供夜宵新方式，也为流动商家书阁官方唯一也为而符合本身就打开', '2019-08-01 15:20:20', '2019-08-01 22:54:29');
INSERT INTO `project` VALUES (5, '773ac38ad95c4345bb82a1e3621a2f67', '顾客王府井', '请在此热个人输入项目介绍', '2019-08-01 22:54:58', '2019-08-01 22:54:58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1234' COMMENT '账号密码',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'USER' COMMENT '用户类型',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (23, 'test', '1234', 'USER', '2019-07-25 21:20:30', '2019-07-25 21:20:30');
INSERT INTO `user` VALUES (24, 'test1', '1234', 'USER', '2019-07-25 21:20:54', '2019-07-26 09:18:08');

SET FOREIGN_KEY_CHECKS = 1;
