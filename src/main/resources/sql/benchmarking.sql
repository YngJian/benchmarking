/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 127.0.0.1:3306
 Source Schema         : benchmarking

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 02/04/2022 19:25:24
*/
CREATE DATABASE IF NOT EXISTS benchmarking;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for indicators
-- ----------------------------
DROP TABLE IF EXISTS `indicators`;
CREATE TABLE `indicators` (
  `I_id` smallint NOT NULL AUTO_INCREMENT COMMENT '自增列',
  `I_number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '三级指标序号',
  `Working_procedure_classification` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '工序分类',
  `Category_of_indicators` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '指标类别',
  `Indicators_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '指标',
  `Unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位',
  `Indicators_grade` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '指标等级',
  `Benchmarking_enterprise` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标杆企业',
  `Benchmark_value` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标杆值',
  `Average_reference_value` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '公司年平均水平基准值',
  `Completion_value` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '完成值',
  `Weight` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权重',
  `Single_index_capability_index` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单项指标能力指数',
  `Process_comprehensive_capability_index` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '工序综合能力指数',
  `Series_comprehensive_capability_index` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '系列综合能力指数',
  `Group_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '小组',
  `Branch_company` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分公司',
  `Electrolytic_series` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '系列',
  `Series_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '系列名',
  `Year` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '年',
  `Month` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '月',
  `Date_month` varchar(7) DEFAULT NULL COMMENT 'yyyy-MM',
  `Date_enter` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '录入时间（yyyy-MM-dd）',
  PRIMARY KEY (`I_id`)
) ENGINE=InnoDB AUTO_INCREMENT=687 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of indicators
-- ----------------------------
BEGIN;
INSERT INTO `indicators` VALUES (589, '1', '电解工序（50%）', '产能利用率10%', '产能利用率', '%', '一级', '山西中润', '1', '2', '3', '6', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (590, '1.1', '电解工序（50%）', '产能利用率10%', '停槽寿命', '天', '二级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (591, '1.2', '电解工序（50%）', '产能利用率10%', '电流强度', 'kA', '二级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (592, '2', '电解工序（50%）', '成本及技术经济指标55%', '制造成本', '元/吨', '一级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (593, '2.1', '电解工序（50%）', '成本及技术经济指标55%', '氧化铝价格', '元/吨', '二级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (594, '2.2', '电解工序（50%）', '成本及技术经济指标55%', '氟化铝价格', '元/吨', '二级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (595, '2.3', '电解工序（50%）', '成本及技术经济指标55%', '阳极价格', '元/吨', '二级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (596, '2.4', '电解工序（50%）', '成本及技术经济指标55%', '综合电价', '元/kWh', '二级', '山西中润', '1', '2', '3', '4', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (597, '2.4.1', '电解工序（50%）', '成本及技术经济指标55%', '自发电单价', '元/kWh', '三级', '山西中润', '1', '2', '3', '0', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (598, '2.4.2', '电解工序（50%）', '成本及技术经济指标55%', '网购电单价', '元/kWh', '三级', '山西中润', '1', '2', '3', '0', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (599, '2.5', '电解工序（50%）', '成本及技术经济指标55%', '天然气单价', '元/m3', '二级', '山西中润', '1', '2', '3', '0', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (600, '2.6', '电解工序（50%）', '成本及技术经济指标55%', '氧化铝单耗', 'kg/t', '二级', '山西中润', '1', '2', '3', '3', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (601, '2.7', '电解工序（50%）', '成本及技术经济指标55%', '氟化铝单耗', 'kg/t', '二级', '山西中润', '1', '2', '3', '3', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (602, '2.8', '电解工序（50%）', '成本及技术经济指标55%', '阳极毛耗', 'kg/t', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (603, '2.9', '电解工序（50%）', '成本及技术经济指标55%', '原铝液综合电耗', 'kwh/t', '二级', '山西中润', '1', '2', '3', '6', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (604, '2.9.1', '电解工序（50%）', '成本及技术经济指标55%', '原铝液直流电耗', 'kwh/t', '三级', '山西中润', '1', '2', '3', '3', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (605, '2.9.2', '电解工序（50%）', '成本及技术经济指标55%', '原铝液交流电耗', 'kwh/t', '三级', '山西中润', '1', '2', '3', '3', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (606, '2.9.3', '电解工序（50%）', '成本及技术经济指标55%', '电解工序动力电耗', 'kwh/t', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (607, '2.10', '电解工序（50%）', '成本及技术经济指标55%', '天然气单耗', 'm3/t', '二级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (608, '2.11', '电解工序（50%）', '成本及技术经济指标55%', '工资及附加成本', '元/吨', '二级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (609, '2.12', '电解工序（50%）', '成本及技术经济指标55%', '制造费用', '元/吨', '二级', '山西中润', '1', '2', '3', '3', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (610, '2.12.1', '电解工序（50%）', '成本及技术经济指标55%', '折旧', '元/吨', '三级', '山西中润', '1', '2', '3', '0', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (611, '2.12.2', '电解工序（50%）', '成本及技术经济指标55%', '修理费', '元/吨', '三级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (612, '2.12.3', '电解工序（50%）', '成本及技术经济指标55%', '机物料消耗', '元/吨', '三级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (613, '2.12.4', '电解工序（50%）', '成本及技术经济指标55%', '备品备件', '元/吨', '三级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (614, '3', '电解工序（50%）', '劳动生产率5%', '劳动生产率', '%', '一级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (615, '4', '电解工序（50%）', '质量类指标10%', '原铝液99.85%以上槽占比', '%', '一级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (616, '4.1', '电解工序（50%）', '质量类指标10%', '原铝Fe含量', '%', '二级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (617, '4.2', '电解工序（50%）', '质量类指标10%', '原铝Si含量', '%', '二级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (618, '4.3', '电解工序（50%）', '质量类指标10%', '吨铝炭渣量', 'kg/t', '二级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (619, '5.1', '电解工序（50%）', '工艺操作类指标20%', '电流效率', '%', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (620, '5.2', '电解工序（50%）', '工艺操作类指标20%', '平均电压', 'v', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (621, '5.2.1', '电解工序（50%）', '工艺操作类指标20%', '工作电压', 'V', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (622, '5.2.2', '电解工序（50%）', '工艺操作类指标20%', '电压偏离', '', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (623, '5.2.3', '电解工序（50%）', '工艺操作类指标20%', '效应系数', '次/槽·日', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (624, '5.2.4', '电解工序（50%）', '工艺操作类指标20%', '炉底压降（GS-5；全石墨）', 'mv', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (625, '5.2.5', '电解工序（50%）', '工艺操作类指标20%', '电解质合格率', '%', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (626, '5.2.6', '电解工序（50%）', '工艺操作类指标20%', '铝水平合格率', '%', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (627, '5.2.7', '电解工序（50%）', '工艺操作类指标20%', '槽温合格率', '%', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (628, '5.2.8', '电解工序（50%）', '工艺操作类指标20%', '分子比合格率', '%', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (629, '5.2.9', '电解工序（50%）', '工艺操作类指标20%', '换极作业合格率', '%', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (630, '5.2.10', '电解工序（50%）', '工艺操作类指标20%', '卡具压降', 'mv', '三级', '山西中润', '1', '2', '3', '1', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (631, '7.1', '净化工序（含脱硫）（10%）', '成本及技术经济指标70%', '净化工序动力电耗', 'kwh/t', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (632, '7.1.1', '净化工序（含脱硫）（10%）', '成本及技术经济指标70%', '净化动力电耗', 'kwh/t', '三级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (633, '7.1.2', '净化工序（含脱硫）（10%）', '成本及技术经济指标70%', '脱硫动力电耗', 'kwh/t', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (634, '7.2', '净化工序（含脱硫）（10%）', '成本及技术经济指标70%', '工资及附加成本', '元/吨', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (635, '7.3', '净化工序（含脱硫）（10%）', '成本及技术经济指标70%', '净化制造费用', '元/吨', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (636, '7.3.1', '净化工序（含脱硫）（10%）', '成本及技术经济指标70%', '净化折旧', '元/吨', '三级', '山西中润', '1', '2', '3', '0', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (637, '7.3.2', '净化工序（含脱硫）（10%）', '成本及技术经济指标70%', '净化修理费', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (638, '7.3.3', '净化工序（含脱硫）（10%）', '成本及技术经济指标70%', '净化机物料消耗', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (639, '7.3.4', '净化工序（含脱硫）（10%）', '成本及技术经济指标70%', '净化备品备件', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (640, '8', '净化工序（含脱硫）（10%）', '劳动生产率10%', '劳动生产率', '%', '一级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (641, '9.1', '净化工序（含脱硫）（10%）', '工艺操作类指标20%', 'SO2排放量', 'mg/m3', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (642, '9.2', '净化工序（含脱硫）（10%）', '工艺操作类指标20%', '粉尘排放量', 'mg/m3', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (643, '9.3', '净化工序（含脱硫）（10%）', '工艺操作类指标20%', '氟化物排放量', 'mg/m3', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (644, '10.1', '供电工序（10%）', '成本及技术经济指标70%', '供电工序动力电耗', 'kwh/t', '二级', '山西中润', '1', '2', '3', '25', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (645, '10.2', '供电工序（10%）', '成本及技术经济指标70%', '工资及附加成本', '元/吨', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (646, '10.3', '供电工序（10%）', '成本及技术经济指标70%', '供电制造费用', '元/吨', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (647, '10.3.1', '供电工序（10%）', '成本及技术经济指标70%', '供电折旧', '元/吨', '三级', '山西中润', '1', '2', '3', '0', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (648, '10.3.2', '供电工序（10%）', '成本及技术经济指标70%', '供电修理费', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (649, '10.3.3', '供电工序（10%）', '成本及技术经济指标70%', '供电机物料消耗', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (650, '10.3.4', '供电工序（10%）', '成本及技术经济指标70%', '供电备品备件', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (651, '11', '供电工序（10%）', '劳动生产率10%', '劳动生产率', '%', '一级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (652, '12.1', '供电工序（10%）', '工艺操作类指标20%', '整流效率', '%', '二级', '山西中润', '1', '2', '3', '20', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (653, '13.1', '动力工序（10%）', '成本及技术经济指标90%', '动力工序动力电耗', 'kwh/t', '二级', '山西中润', '1', '2', '3', '25', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (654, '13.2', '动力工序（10%）', '成本及技术经济指标90%', '工资及附加成本', '元/吨', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (655, '13.3', '动力工序（10%）', '成本及技术经济指标90%', '动力制造费用', '元/吨', '二级', '山西中润', '1', '2', '3', '20', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (656, '13.3.1', '动力工序（10%）', '成本及技术经济指标90%', '动力折旧', '元/吨', '三级', '山西中润', '1', '2', '3', '0', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (657, '13.3.2', '动力工序（10%）', '成本及技术经济指标90%', '动力修理费', '元/吨', '三级', '山西中润', '1', '2', '3', '14', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (658, '13.3.3', '动力工序（10%）', '成本及技术经济指标90%', '动力机物料消耗', '元/吨', '三级', '山西中润', '1', '2', '3', '13', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (659, '13.3.4', '动力工序（10%）', '成本及技术经济指标90%', '动力备品备件', '元/吨', '三级', '山西中润', '1', '2', '3', '13', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (660, '14', '动力工序（10%）', '劳动生产率10%', '劳动生产率', '%', '一级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (661, '15.1', '铸造工序（10%）', '成本及技术经济指标70%', '铸造动力电耗', 'kwh/t', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (662, '15.2', '铸造工序（10%）', '成本及技术经济指标70%', '铸造天然气单耗', 'm3/t', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (663, '15.3', '铸造工序（10%）', '成本及技术经济指标70%', '铸造新水单耗', 'kg/t', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (664, '15.4', '铸造工序（10%）', '成本及技术经济指标70%', '工资及附加成本', '元/吨', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (665, '15.5', '铸造工序（10%）', '成本及技术经济指标70%', '铸造制造费用', '元/吨', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (666, '15.5.1', '铸造工序（10%）', '成本及技术经济指标70%', '铸造折旧', '元/吨', '三级', '山西中润', '1', '2', '3', '0', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (667, '15.5.2', '铸造工序（10%）', '成本及技术经济指标70%', '铸造修理费', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (668, '15.5.3', '铸造工序（10%）', '成本及技术经济指标70%', '铸造机物料消耗', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (669, '15.5.4', '铸造工序（10%）', '成本及技术经济指标70%', '铸造备品备件', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (670, '16', '铸造工序（10%）', '劳动生产率10%', '劳动生产率', '%', '一级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (671, '17.1', '铸造工序（10%）', '质量类指标20%', '铸造损失', '%', '二级', '山西中润', '1', '2', '3', '15', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (672, '17.2', '铸造工序（10%）', '质量类指标20%', '铸造一次合格率', '%', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (673, '18.1', '组装工序（含残极清破）（10%）', '成本及技术经济指标70%', '组装块加工费用', 'kwh/t', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (674, '18.2', '组装工序（含残极清破）（10%）', '成本及技术经济指标70%', '组装动力电耗', 'kwh/t', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (675, '18.2.1', '组装工序（含残极清破）（10%）', '成本及技术经济指标70%', '组装中频炉动力电单耗', 'kwh/t', '三级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (676, '18.3', '组装工序（含残极清破）（10%）', '成本及技术经济指标70%', '工资及附加成本', '元/吨', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (677, '18.4', '组装工序（含残极清破）（10%）', '成本及技术经济指标70%', '制造费用', '元/吨', '二级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (678, '18.4.1', '组装工序（含残极清破）（10%）', '成本及技术经济指标70%', '组装折旧', '元/吨', '三级', '山西中润', '1', '2', '3', '0', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (679, '18.4.2', '组装工序（含残极清破）（10%）', '成本及技术经济指标70%', '组装修理费', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (680, '18.4.3', '组装工序（含残极清破）（10%）', '成本及技术经济指标70%', '组装机物料消耗', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (681, '18.4.4', '组装工序（含残极清破）（10%）', '成本及技术经济指标70%', '组装备品备件', '元/吨', '三级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (682, '19', '组装工序（含残极清破）（10%）', '劳动生产率10%', '劳动生产率', '%', '一级', '山西中润', '1', '2', '3', '10', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (683, '20.1', '组装工序（含残极清破）（10%）', '质量类指标20%', '组装块Fe-C压降≤70mv占比', '%', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (684, '20.2', '组装工序（含残极清破）（10%）', '质量类指标20%', '浇铸磷铁水成分达标率', '%', '二级', '山西中润', '1', '2', '3', '5', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (685, '20.3', '组装工序（含残极清破）（10%）', '质量类指标20%', '导杆下线率', '%', '二级', '山西中润', '1', '2', '3', '3', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
INSERT INTO `indicators` VALUES (686, '20.4', '组装工序（含残极清破）（10%）', '质量类指标20%', '破碎料铁含量', '%', '二级', '山西中润', '1', '2', '3', '2', '1', '1.0', '1.0', '500kA指标体系', '内蒙古华云', '500KA', '内蒙古华云500kA', '2022', '04', '2022-04', '2022-04-02');
COMMIT;

-- ----------------------------
-- Table structure for t_series_info
-- ----------------------------
DROP TABLE IF EXISTS `t_series_info`;
CREATE TABLE `t_series_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '系类信息',
  `electrolytic_series` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分公司',
  `branch_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '系列',
  `series_type` smallint NOT NULL COMMENT '系类所属类型1：500kA指标系类 2：300-400kA指标系类 3： 240kA及以下指标系类',
  `series_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='系列信息';

-- ----------------------------
-- Records of t_series_info
-- ----------------------------
BEGIN;
INSERT INTO `t_series_info` VALUES (1, '山西中润500kA', '500kA', '山西中润', 1, '山西中润500kA', '2022-04-01 17:00:47', '2022-04-01 17:02:00');
INSERT INTO `t_series_info` VALUES (2, '内蒙古华云500kA', '500kA', '内蒙古华云', 1, '内蒙古华云500kA', '2022-04-01 17:02:00', '2022-04-01 17:02:00');
INSERT INTO `t_series_info` VALUES (3, '连城分公司500KA', '500KA', '连城分公司', 1, '连城分公司500KA', '2022-04-01 17:02:31', '2022-04-01 17:02:31');
INSERT INTO `t_series_info` VALUES (4, '山西新材料300KA', '300KA', '山西新材料', 2, '山西新材料300KA', '2022-04-01 17:03:01', '2022-04-01 17:03:01');
INSERT INTO `t_series_info` VALUES (5, '包头铝业400KA', '400KA', '包头铝业', 2, '包头铝业400KA', '2022-04-01 17:03:27', '2022-04-01 17:03:27');
INSERT INTO `t_series_info` VALUES (6, '内蒙古华云390KA', '390KA', '内蒙古华云', 2, '内蒙古华云390KA', '2022-04-01 17:04:12', '2022-04-01 17:05:04');
INSERT INTO `t_series_info` VALUES (7, '兰州分公司375KA', '375KA', '兰州分公司', 2, '兰州分公司375KA', '2022-04-01 17:04:13', '2022-04-01 17:05:04');
INSERT INTO `t_series_info` VALUES (8, '青海分公司240KA', '240KA', '青海分公司', 3, '青海分公司240KA', '2022-04-01 17:05:04', '2022-04-01 17:05:04');
INSERT INTO `t_series_info` VALUES (9, '青海分公司200KA', '200KA', '青海分公司', 3, '青海分公司200KA', '2022-04-01 17:06:38', '2022-04-01 17:06:38');
INSERT INTO `t_series_info` VALUES (10, '青海分公司180KA', '180KA', '青海分公司', 3, '青海分公司180KA', '2022-04-01 17:07:09', '2022-04-01 17:07:09');
INSERT INTO `t_series_info` VALUES (11, '包头铝业240KA', '240KA', '包头铝业', 3, '包头铝业240KA', '2022-04-01 17:08:33', '2022-04-01 17:08:33');
INSERT INTO `t_series_info` VALUES (12, '包头铝业200KA', '200KA', '包头铝业', 3, '包头铝业200KA', '2022-04-01 17:09:08', '2022-04-01 17:09:08');
INSERT INTO `t_series_info` VALUES (13, '兰州分公司200KA', '200KA', '兰州分公司', 3, '兰州分公司200KA', '2022-04-01 17:09:28', '2022-04-01 17:09:28');
INSERT INTO `t_series_info` VALUES (14, '连城分公司200KA', '200KA', '连城分公司', 3, '连城分公司200KA', '2022-04-01 17:09:55', '2022-04-01 17:09:55');
COMMIT;

-- ----------------------------
-- Table structure for t_series_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_series_permission`;
CREATE TABLE `t_series_permission` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` int NOT NULL COMMENT '用户组id',
  `series_id` int NOT NULL COMMENT '系列信息id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='数据系类权限关联表';

-- ----------------------------
-- Records of t_series_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_series_permission` VALUES (1, 1, 1, '2022-04-01 17:28:40');
INSERT INTO `t_series_permission` VALUES (2, 1, 2, '2022-04-01 17:28:51');
INSERT INTO `t_series_permission` VALUES (3, 1, 3, '2022-04-01 17:28:57');
INSERT INTO `t_series_permission` VALUES (4, 1, 4, '2022-04-01 17:29:01');
INSERT INTO `t_series_permission` VALUES (5, 1, 5, '2022-04-01 17:29:07');
INSERT INTO `t_series_permission` VALUES (6, 1, 6, '2022-04-01 17:29:11');
INSERT INTO `t_series_permission` VALUES (7, 1, 7, '2022-04-01 17:29:16');
INSERT INTO `t_series_permission` VALUES (8, 1, 8, '2022-04-01 17:29:20');
INSERT INTO `t_series_permission` VALUES (9, 1, 9, '2022-04-01 17:29:23');
INSERT INTO `t_series_permission` VALUES (10, 1, 10, '2022-04-01 17:29:31');
INSERT INTO `t_series_permission` VALUES (11, 1, 11, '2022-04-01 17:30:00');
INSERT INTO `t_series_permission` VALUES (12, 1, 12, '2022-04-01 17:30:03');
INSERT INTO `t_series_permission` VALUES (13, 1, 13, '2022-04-01 17:30:08');
INSERT INTO `t_series_permission` VALUES (14, 1, 14, '2022-04-01 17:30:19');
INSERT INTO `t_series_permission` VALUES (15, 2, 1, '2022-04-01 17:28:40');
INSERT INTO `t_series_permission` VALUES (16, 2, 2, '2022-04-01 17:28:51');
INSERT INTO `t_series_permission` VALUES (17, 2, 3, '2022-04-01 17:28:57');
INSERT INTO `t_series_permission` VALUES (18, 2, 4, '2022-04-01 17:29:01');
INSERT INTO `t_series_permission` VALUES (19, 2, 5, '2022-04-01 17:29:07');
INSERT INTO `t_series_permission` VALUES (20, 2, 6, '2022-04-01 17:29:11');
INSERT INTO `t_series_permission` VALUES (21, 2, 7, '2022-04-01 17:29:16');
INSERT INTO `t_series_permission` VALUES (22, 2, 8, '2022-04-01 17:29:20');
INSERT INTO `t_series_permission` VALUES (23, 2, 9, '2022-04-01 17:29:23');
INSERT INTO `t_series_permission` VALUES (24, 2, 10, '2022-04-01 17:29:31');
INSERT INTO `t_series_permission` VALUES (25, 2, 11, '2022-04-01 17:30:00');
INSERT INTO `t_series_permission` VALUES (26, 2, 12, '2022-04-01 17:30:03');
INSERT INTO `t_series_permission` VALUES (27, 2, 13, '2022-04-01 17:30:08');
INSERT INTO `t_series_permission` VALUES (28, 2, 14, '2022-04-01 17:30:19');
INSERT INTO `t_series_permission` VALUES (29, 3, 1, '2022-04-01 17:34:41');
INSERT INTO `t_series_permission` VALUES (30, 3, 2, '2022-04-01 17:34:51');
INSERT INTO `t_series_permission` VALUES (31, 3, 3, '2022-04-01 17:35:01');
INSERT INTO `t_series_permission` VALUES (32, 4, 4, '2022-04-01 17:35:28');
INSERT INTO `t_series_permission` VALUES (33, 4, 5, '2022-04-01 17:35:37');
INSERT INTO `t_series_permission` VALUES (34, 4, 6, '2022-04-01 17:35:46');
INSERT INTO `t_series_permission` VALUES (35, 4, 7, '2022-04-01 17:35:57');
INSERT INTO `t_series_permission` VALUES (36, 5, 8, '2022-04-01 17:36:23');
INSERT INTO `t_series_permission` VALUES (37, 5, 9, '2022-04-01 17:36:28');
INSERT INTO `t_series_permission` VALUES (38, 5, 10, '2022-04-01 17:36:33');
INSERT INTO `t_series_permission` VALUES (39, 5, 11, '2022-04-01 17:37:14');
INSERT INTO `t_series_permission` VALUES (40, 5, 12, '2022-04-01 17:37:21');
INSERT INTO `t_series_permission` VALUES (41, 5, 13, '2022-04-01 17:37:28');
INSERT INTO `t_series_permission` VALUES (42, 5, 14, '2022-04-01 17:37:33');
INSERT INTO `t_series_permission` VALUES (43, 6, 1, '2022-04-01 17:37:46');
INSERT INTO `t_series_permission` VALUES (44, 7, 2, '2022-04-01 17:38:10');
INSERT INTO `t_series_permission` VALUES (45, 7, 6, '2022-04-01 17:38:23');
INSERT INTO `t_series_permission` VALUES (46, 7, 5, '2022-04-01 17:38:39');
INSERT INTO `t_series_permission` VALUES (47, 7, 11, '2022-04-01 17:38:45');
INSERT INTO `t_series_permission` VALUES (48, 7, 12, '2022-04-01 17:38:49');
INSERT INTO `t_series_permission` VALUES (49, 8, 3, '2022-04-01 17:39:31');
INSERT INTO `t_series_permission` VALUES (50, 8, 14, '2022-04-01 17:39:38');
INSERT INTO `t_series_permission` VALUES (51, 9, 4, '2022-04-01 17:39:54');
INSERT INTO `t_series_permission` VALUES (52, 10, 7, '2022-04-01 17:40:11');
INSERT INTO `t_series_permission` VALUES (53, 10, 13, '2022-04-01 17:40:24');
INSERT INTO `t_series_permission` VALUES (54, 11, 8, '2022-04-01 17:40:39');
INSERT INTO `t_series_permission` VALUES (55, 11, 9, '2022-04-01 17:40:45');
INSERT INTO `t_series_permission` VALUES (56, 11, 10, '2022-04-01 17:40:51');
COMMIT;

-- ----------------------------
-- Table structure for t_user_group
-- ----------------------------
DROP TABLE IF EXISTS `t_user_group`;
CREATE TABLE `t_user_group` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `group_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户组表';

-- ----------------------------
-- Records of t_user_group
-- ----------------------------
BEGIN;
INSERT INTO `t_user_group` VALUES (1, '中铝股份 所有系列', '2022-04-01 17:18:52', '2022-04-01 17:18:52');
INSERT INTO `t_user_group` VALUES (2, '北方电解铝牵头企业 所有系类', '2022-04-01 17:19:33', '2022-04-01 17:19:59');
INSERT INTO `t_user_group` VALUES (3, '500kA指标组组长 山西中润500kA 内蒙古华云500kA 连城分公司500KA', '2022-04-01 17:20:28', '2022-04-01 17:20:28');
INSERT INTO `t_user_group` VALUES (4, '300-400kA指标组组长 山西新材料300KA 包头铝业400KA 内蒙古华云390KA 兰州分公司375KA\r\n', '2022-04-01 17:21:03', '2022-04-01 17:21:03');
INSERT INTO `t_user_group` VALUES (5, '240kA及以下指标组组长 青海分公司240KA 青海分公司200KA 青海分公司180KA 包头铝业240KA 包头铝业200KA 兰州分公司200KA 连城分公司200KA\r\n', '2022-04-01 17:21:51', '2022-04-01 17:21:51');
INSERT INTO `t_user_group` VALUES (6, '山西中润 山西中润500kA\r\n', '2022-04-01 17:22:19', '2022-04-01 17:22:19');
INSERT INTO `t_user_group` VALUES (7, '包头铝业（含内蒙古华云）内蒙古华云500kA 内蒙古华云390KA 包头铝业400KA 包头铝业240KA 包头铝业200KA\r\n', '2022-04-01 17:23:00', '2022-04-01 17:23:00');
INSERT INTO `t_user_group` VALUES (8, '连城分公司 连城分公司500KA 连城分公司200KA', '2022-04-01 17:23:26', '2022-04-01 17:23:26');
INSERT INTO `t_user_group` VALUES (9, '山西新材料 山西新材料300KA ', '2022-04-01 17:23:51', '2022-04-01 17:23:51');
INSERT INTO `t_user_group` VALUES (10, '兰州分公司 兰州分公司375KA 兰州分公司200KA', '2022-04-01 17:24:17', '2022-04-01 17:24:17');
INSERT INTO `t_user_group` VALUES (11, '青海分公司 青海分公司240KA 青海分公司200KA 青海分公司180KA', '2022-04-01 17:24:36', '2022-04-01 17:24:36');
COMMIT;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `group_id` bigint NOT NULL COMMENT '组id（id为1的包含所有数据系列权限）',
  `is_upload` smallint NOT NULL COMMENT '是否能上传0不能1能',
  `user_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
BEGIN;
INSERT INTO `t_user_info` VALUES (1, 'zlgf', '123456', 1, 0, '中铝股份', '2022-04-01 17:12:17', '2022-04-01 17:12:17');
INSERT INTO `t_user_info` VALUES (2, 'qtqy', '123456', 2, 0, '北方电解铝牵头企业', '2022-04-01 17:13:01', '2022-04-01 17:24:55');
INSERT INTO `t_user_info` VALUES (3, '5zbzc', '123456', 3, 0, '500kA指标组组长', '2022-04-01 17:14:02', '2022-04-01 17:24:56');
INSERT INTO `t_user_info` VALUES (4, '3zbzc', '123456', 4, 0, '500kA指标组组长', '2022-04-01 17:14:40', '2022-04-01 17:24:57');
INSERT INTO `t_user_info` VALUES (5, '2zbzc', '123456', 5, 0, '500kA指标组组长', '2022-04-01 17:15:02', '2022-04-01 17:24:58');
INSERT INTO `t_user_info` VALUES (6, 'sxzr', '123456', 6, 1, '山西中润', '2022-04-01 17:15:38', '2022-04-01 17:24:59');
INSERT INTO `t_user_info` VALUES (7, 'btly', '123456', 7, 1, '包头铝业（含内蒙古华云）', '2022-04-01 17:16:06', '2022-04-01 17:25:00');
INSERT INTO `t_user_info` VALUES (8, 'lcfgs', '123456', 8, 1, '连城分公司', '2022-04-01 17:16:27', '2022-04-01 17:25:00');
INSERT INTO `t_user_info` VALUES (9, 'sxxcl', '123456', 9, 1, '山西新材料', '2022-04-01 17:16:57', '2022-04-01 17:25:01');
INSERT INTO `t_user_info` VALUES (10, 'lzfgs', '123456', 10, 1, '兰州分公司', '2022-04-01 17:17:23', '2022-04-01 17:25:03');
INSERT INTO `t_user_info` VALUES (11, 'qhfgs', '123456', 11, 1, '青海分公司', '2022-04-01 17:17:45', '2022-04-01 17:25:05');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
