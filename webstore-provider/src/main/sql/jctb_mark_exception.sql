/*
 Navicat Premium Data Transfer

 Source Server         : postgres@docker-hadoop104
 Source Server Type    : PostgreSQL
 Source Server Version : 120001
 Source Host           : hadoop104:5432
 Source Catalog        : db01
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120001
 File Encoding         : 65001

 Date: 16/09/2021 18:35:41
*/


-- ----------------------------
-- Table structure for jctb_mark_exception
-- ----------------------------
DROP TABLE IF EXISTS "public"."jctb_mark_exception";
CREATE TABLE "public"."jctb_mark_exception" (
  "id" int8 NOT NULL,
  "task_name" varchar(255) COLLATE "pg_catalog"."default",
  "province_code" varchar(255) COLLATE "pg_catalog"."default",
  "province_name" varchar(255) COLLATE "pg_catalog"."default",
  "city_code" varchar(255) COLLATE "pg_catalog"."default",
  "city_name" varchar(255) COLLATE "pg_catalog"."default",
  "county_code" varchar(255) COLLATE "pg_catalog"."default",
  "county_name" varchar(255) COLLATE "pg_catalog"."default",
  "jcbh" varchar(255) COLLATE "pg_catalog"."default",
  "error_type" varchar(255) COLLATE "pg_catalog"."default",
  "error_desc" varchar(255) COLLATE "pg_catalog"."default",
  "is_mark" int2 DEFAULT 0,
  "mark_reason" varchar(255) COLLATE "pg_catalog"."default",
  "step_code" int2
)
;
COMMENT ON COLUMN "public"."jctb_mark_exception"."step_code" IS '1002-质量检查；1003-套合比对；1004-成果检查';

-- ----------------------------
-- Records of jctb_mark_exception
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table jctb_mark_exception
-- ----------------------------
ALTER TABLE "public"."jctb_mark_exception" ADD CONSTRAINT "jctb_mark_exception_pkey" PRIMARY KEY ("id");
