/*
 Navicat Premium Data Transfer

 Source Server         : postgres@docker-hadoop104
 Source Server Type    : PostgreSQL
 Source Server Version : 120001
 Source Host           : hadoop104:5432
 Source Catalog        : db2021
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120001
 File Encoding         : 65001

 Date: 13/09/2021 20:32:24
*/


-- ----------------------------
-- Table structure for tb_ziptaskinfo_sub
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_ziptaskinfo_sub";
CREATE TABLE "public"."tb_ziptaskinfo_sub" (
  "f_id" int4 NOT NULL,
  "f_stepcode" varchar(255) COLLATE "pg_catalog"."default",
  "f_name" varchar(255) COLLATE "pg_catalog"."default",
  "f_status" numeric(255),
  "f_log" text COLLATE "pg_catalog"."default",
  "f_starttime" timestamp(6),
  "f_endtime" timestamp(6),
  "f_code" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."tb_ziptaskinfo_sub"."f_stepcode" IS '步骤id';

-- ----------------------------
-- Records of tb_ziptaskinfo_sub
-- ----------------------------
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10001, '1001', '数据解压', 1, '数据解压完成', '2021-09-07 15:28:57', '2021-09-08 15:29:01', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10002, '1002', '数据有效性检查', 1, '数据文件正常打开', '2021-09-08 15:29:42', '2021-09-09 15:29:48', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10003, '1002', '数学基础检查', 1, '采用2000国家大地坐标系（经纬度坐标）', '2021-09-06 15:31:19', '2021-09-08 15:31:15', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10004, '1002', '属性结构检查', 1, '共检查30个字段，图层属性字段的数量符合要求，其中29个属性字段名称、类型、长度符合要求，1个字段类型不符合要求。', '2021-09-07 15:32:09', '2021-09-09 15:32:14', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10025, '1005', '套合图件成果', 1, '套合图件成果输出完成。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10005, '1002', '代码一致性检查', 1, '共检查5个字段，其中5个字段值是代码的字段取值符合要求。', '2021-09-07 15:32:46', '2021-09-08 15:32:49', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10006, '1002', '编号唯一性检查', 1, '共检查300个监测编号，其中290个监测编号字段取值唯一，10个监测编号字段值存在重复。', '2021-09-07 15:33:40', '2021-09-09 15:33:46', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10007, '1002', '字段必填性检查', 1, '共检查20个必填字段，其中20个必填字段符合要求。', '2021-09-07 15:34:26', '2021-09-09 15:34:29', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10026, '1005', '质检结果', 1, '质检结果输出完成。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10008, '1002', '面层内拓扑关系', 1, '共检查300个要素，其中300个要素无自相交，300个要素全部闭合。', '2021-09-07 15:35:10', '2021-09-09 15:35:13', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10009, '1002', '数据自重叠检查', 1, '共检查300个要素，其中300个要素无重叠。', '2021-09-07 15:35:45', '2021-09-08 15:35:49', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10010, '1002', '数据间重叠检查', 1, '共检查300个要素，其中300个要素与历史批次下发数据不重叠。', '2021-09-07 15:36:22', '2021-09-08 15:36:26', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10027, '1005', '统计分析成果', 1, '统计和分析报告编制完成。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10028, '1006', '150502-科尔沁区', 1, '[2021-06-21 10:01:33] \\172.16.67.66\…\150502.mdb YGJCTB开始入库...', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10029, '1006', '150502-科尔沁区', 1, '[2021-06-21 10:01:33] \\172.16.67.66\…\150502.mdb YGJCTB开始入库...', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10011, '1003', '与土地利用现状数据套合比对', 1, '共300个要素进行套合比对，其中300个要素套合比对通过', '2021-09-06 15:37:12', '2021-09-09 15:37:17', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10012, '1003', '与土地利用总体规划数据套合比对', 1, '共300个要素进行套合比对，其中300个要素套合比对通过', '2021-09-07 15:38:00', '2021-09-08 15:38:04', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10013, '1003', '与永久基本农田数据套合比对', 1, '共300个要素进行套合比对，其中300个要素套合比对通过', '2021-09-06 15:38:35', '2021-09-08 15:38:04', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10014, '1003', '与国家自然保护区数据套合比对', 1, '共300个要素进行套合比对，其中300个要素套合比对通过', '2021-09-06 15:38:35', '2021-09-08 15:38:04', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10015, '1003', '与批准农转用数据套合比对', 1, '共300个要素进行套合比对，其中300个要素套合比对通过', '2021-09-06 15:38:35', '2021-09-08 15:38:04', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10016, '1004', '要素个数一致性检查', 1, '比对结果中要素个数与质检通过要素个数一致。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10017, '1004', '图件数量检查', 1, '图件数量与图斑数量一致。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10018, '1004', '面积字段值检查', 1, '面积字段值大于等于0，各类套合面积之和大于0。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10019, '1004', '监测面积与现状数据套合关系', 1, '监测面积与现状套合农用地、建设用地面积、未利用地面积逻辑关系通过。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10020, '1004', '农用地与耕地面积关系', 1, '农用地面积大于等于耕地面积。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10021, '1004', '监测面积与基本农田面积关系', 1, '监测面积大于等于基本农田面积。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10022, '1004', '耕地面积检查', 1, '占耕地面积小于套上耕地面积与套不上耕地面积之和。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10023, '1005', '套合成果总体描述信息', 1, '套合成果总体描述文件输出完成。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');
INSERT INTO "public"."tb_ziptaskinfo_sub" VALUES (10024, '1005', '套合结果', 1, '套合结果输出完成。', '2021-09-01 15:40:48', '2021-09-02 15:40:52', '2021S205190028');

-- ----------------------------
-- Primary Key structure for table tb_ziptaskinfo_sub
-- ----------------------------
ALTER TABLE "public"."tb_ziptaskinfo_sub" ADD CONSTRAINT "tb_zipfileinfo_sub_pkey" PRIMARY KEY ("f_id");
