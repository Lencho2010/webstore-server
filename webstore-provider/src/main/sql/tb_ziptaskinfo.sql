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

 Date: 13/09/2021 20:32:17
*/


-- ----------------------------
-- Table structure for tb_ziptaskinfo
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_ziptaskinfo";
CREATE TABLE "public"."tb_ziptaskinfo" (
  "f_id" int4 NOT NULL,
  "f_code" varchar(255) COLLATE "pg_catalog"."default",
  "f_name" varchar(255) COLLATE "pg_catalog"."default",
  "f_status" numeric(255),
  "f_progress" numeric(255),
  "f_starttime" timestamp(6),
  "f_endtime" timestamp(6)
)
;
COMMENT ON COLUMN "public"."tb_ziptaskinfo"."f_code" IS '关联任务主键';
COMMENT ON COLUMN "public"."tb_ziptaskinfo"."f_name" IS '步骤名称';

-- ----------------------------
-- Records of tb_ziptaskinfo
-- ----------------------------
INSERT INTO "public"."tb_ziptaskinfo" VALUES (1001, '2021S205190028', '接收解压', 1, 100, '2021-09-06 15:20:39', '2021-09-08 15:20:43');
INSERT INTO "public"."tb_ziptaskinfo" VALUES (1002, '2021S205190028', '质量检查', 1, 100, '2021-09-07 15:21:21', '2021-09-08 15:21:27');
INSERT INTO "public"."tb_ziptaskinfo" VALUES (1006, '2021S205190028', '数据入库', 1, 0, '2021-09-07 15:23:28', '2021-09-10 15:23:34');
INSERT INTO "public"."tb_ziptaskinfo" VALUES (1004, '2021S205190028', '成果检查', 1, 60, '2021-09-07 15:22:30', '2021-09-08 15:22:34');
INSERT INTO "public"."tb_ziptaskinfo" VALUES (1003, '2021S205190028', '套合比对', 1, 80, '2021-09-07 15:21:59', '2021-09-09 15:22:02');
INSERT INTO "public"."tb_ziptaskinfo" VALUES (1005, '2021S205190028', '成果输出', 1, 40, '2021-09-06 15:22:55', '2021-09-08 15:22:59');

-- ----------------------------
-- Primary Key structure for table tb_ziptaskinfo
-- ----------------------------
ALTER TABLE "public"."tb_ziptaskinfo" ADD CONSTRAINT "tb_ziptaskinfo_pkey" PRIMARY KEY ("f_id");
