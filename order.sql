-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: reggie
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address_book`
--
create database reggie character set utf8mb4;
use reggie;

DROP TABLE IF EXISTS `address_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_book` (
                                `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `user_id` int NOT NULL COMMENT '用户id',
                                `consignee` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '收货人',
                                `sex` tinyint NOT NULL COMMENT '性别 0 女 1 男',
                                `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '手机号',
                                `province_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '省级区划编号',
                                `province_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '省级名称',
                                `city_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '市级区划编号',
                                `city_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '市级名称',
                                `district_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '区级区划编号',
                                `district_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '区级名称',
                                `detail` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '详细地址',
                                `label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标签',
                                `is_default` tinyint(1) NOT NULL DEFAULT '0' COMMENT '默认 0 否 1是',
                                `create_time` datetime NOT NULL COMMENT '创建时间',
                                `update_time` datetime NOT NULL COMMENT '更新时间',
                                `create_user` int NOT NULL COMMENT '创建人',
                                `update_user` int NOT NULL COMMENT '修改人',
                                `is_deleted` int NOT NULL DEFAULT '0' COMMENT '是否删除',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='地址管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_book`
--

LOCK TABLES `address_book` WRITE;
/*!40000 ALTER TABLE `address_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `type` int DEFAULT NULL COMMENT '类型   1 菜品分类 2 套餐分类',
                            `name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '分类名称',
                            `sort` int NOT NULL DEFAULT '0' COMMENT '顺序',
                            `create_time` datetime NOT NULL COMMENT '创建时间',
                            `update_time` datetime NOT NULL COMMENT '更新时间',
                            `create_user` int NOT NULL COMMENT '创建人',
                            `update_user` int NOT NULL COMMENT '修改人',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_category_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='菜品及套餐分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,1,'川菜1',1,'2024-04-28 09:59:21','2024-04-28 10:07:58',1,1),(2,1,'湘菜',2,'2024-04-28 09:59:33','2024-04-28 09:59:33',1,1),(3,1,'粤菜',3,'2024-04-28 09:59:40','2024-04-28 09:59:40',1,1),(4,1,'陕菜',3,'2024-04-28 09:59:49','2024-04-28 09:59:49',1,1),(5,1,'鲁菜',4,'2024-04-28 10:00:02','2024-04-28 10:00:02',1,1),(6,1,'东北菜',6,'2024-04-28 10:00:11','2024-04-28 10:00:11',1,1),(7,2,'情侣套餐',1,'2024-04-28 10:00:33','2024-04-28 10:00:33',1,1),(8,2,'单人套餐',2,'2024-04-28 10:00:43','2024-04-28 10:00:43',1,1),(9,2,'双人套餐',3,'2024-04-28 10:01:01','2024-04-28 10:01:01',1,1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish`
--

DROP TABLE IF EXISTS `dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dish` (
                        `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '菜品名称',
                        `category_id` bigint NOT NULL COMMENT '菜品分类id',
                        `price` decimal(10,2) DEFAULT NULL COMMENT '菜品价格',
                        `code` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '商品码',
                        `image` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '图片',
                        `description` varchar(400) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '描述信息',
                        `status` int NOT NULL DEFAULT '1' COMMENT '0 停售 1 起售',
                        `sort` int NOT NULL DEFAULT '0' COMMENT '顺序',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `update_time` datetime NOT NULL COMMENT '更新时间',
                        `create_user` int NOT NULL COMMENT '创建人',
                        `update_user` int NOT NULL COMMENT '修改人',
                        `is_deleted` int NOT NULL DEFAULT '0' COMMENT '是否删除',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `idx_dish_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='菜品管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` VALUES (8,'鱼香肉丝',1,1100.00,'','edce48ab-0970-4aa6-90a5-e521e6440055.png','最好吃的鱼肉',1,0,'2024-04-28 12:18:58','2024-04-28 15:58:05',1,1,0),(9,'老干妈土豆丝',2,4300.00,'','638e8602-0456-4a05-90d4-80e87a38a4a7.png','最好吃的土豆丝',1,0,'2024-04-28 12:19:31','2024-04-28 12:46:50',1,1,0),(11,'麻婆豆腐',1,3300.00,'','a1c59ed3-c23a-423b-93ce-ef4c536814a7.png','aaaa',1,0,'2024-04-28 14:39:58','2024-04-28 14:39:58',1,1,0);
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish_flavor`
--

DROP TABLE IF EXISTS `dish_flavor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dish_flavor` (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                               `dish_id` int NOT NULL COMMENT '菜品',
                               `name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '口味名称',
                               `value` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '口味数据list',
                               `create_time` datetime NOT NULL COMMENT '创建时间',
                               `update_time` datetime NOT NULL COMMENT '更新时间',
                               `create_user` int NOT NULL COMMENT '创建人',
                               `update_user` int NOT NULL COMMENT '修改人',
                               `is_deleted` int NOT NULL DEFAULT '0' COMMENT '是否删除',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='菜品口味关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_flavor`
--

LOCK TABLES `dish_flavor` WRITE;
/*!40000 ALTER TABLE `dish_flavor` DISABLE KEYS */;
INSERT INTO `dish_flavor` VALUES (1,6,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]','2024-04-28 11:44:37','2024-04-28 11:44:37',1,1,0),(2,6,'温度','[\"热饮\",\"常温\",\"去冰\",\"少冰\",\"多冰\"]','2024-04-28 11:44:37','2024-04-28 11:44:37',1,1,0),(3,7,'辣度','[\"重辣\"]','2024-04-28 12:02:20','2024-04-28 12:02:20',1,1,0),(4,7,'忌口','[\"不要葱\",\"不要香菜\"]','2024-04-28 12:02:20','2024-04-28 12:02:20',1,1,0),(6,9,'忌口','[\"不要葱\",\"不要蒜\",\"不要香菜\",\"不要辣\"]','2024-04-28 12:19:31','2024-04-28 12:19:31',1,1,0),(7,10,'甜味','[\"多糖\"]','2024-04-28 12:20:02','2024-04-28 12:20:02',1,1,0),(12,9,'忌口','[\"不要葱\",\"不要蒜\",\"不要香菜\",\"不要辣\"]','2024-04-28 12:46:50','2024-04-28 12:46:50',1,1,0),(13,11,'辣度','[\"不辣\",\"微辣\",\"中辣\",\"重辣\"]','2024-04-28 14:39:58','2024-04-28 14:39:58',1,1,0),(14,11,'忌口','[\"不要葱\",\"不要蒜\",\"不要香菜\",\"不要辣\"]','2024-04-28 14:39:58','2024-04-28 14:39:58',1,1,0),(18,8,'甜味','[\"全糖\"]','2024-04-28 15:58:05','2024-04-28 15:58:05',1,1,0);
/*!40000 ALTER TABLE `dish_flavor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '姓名',
                            `username` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '用户名',
                            `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '密码',
                            `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '手机号',
                            `sex` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '性别',
                            `id_number` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '身份证号',
                            `status` int NOT NULL DEFAULT '1' COMMENT '状态 0:禁用，1:正常',
                            `create_time` datetime NOT NULL COMMENT '创建时间',
                            `update_time` datetime NOT NULL COMMENT '更新时间',
                            `create_user` int NOT NULL COMMENT '创建人',
                            `update_user` int NOT NULL COMMENT '修改人',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='员工信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'管理员','admin','e10adc3949ba59abbe56e057f20f883e','13812312312','1','110101199001010047',1,'2021-05-06 17:20:07','2021-05-10 02:24:09',1,1),(2,'李四','zhangsan','e10adc3949ba59abbe56e057f20f883e','17766665555','1','610622199905061815',1,'2024-04-28 10:01:38','2024-04-28 10:01:46',1,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
                                `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '名字',
                                `image` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '图片',
                                `order_id` int NOT NULL COMMENT '订单id',
                                `dish_id` int DEFAULT NULL COMMENT '菜品id',
                                `setmeal_id` int DEFAULT NULL COMMENT '套餐id',
                                `dish_flavor` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '口味',
                                `number` int NOT NULL DEFAULT '1' COMMENT '数量',
                                `amount` decimal(10,2) NOT NULL COMMENT '金额',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='订单明细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
                          `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `number` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '订单号',
                          `status` int NOT NULL DEFAULT '1' COMMENT '订单状态 1待付款，2待派送，3已派送，4已完成，5已取消',
                          `user_id` int NOT NULL COMMENT '下单用户',
                          `address_book_id` int NOT NULL COMMENT '地址id',
                          `order_time` datetime NOT NULL COMMENT '下单时间',
                          `checkout_time` datetime NOT NULL COMMENT '结账时间',
                          `pay_method` int NOT NULL DEFAULT '1' COMMENT '支付方式 1微信,2支付宝',
                          `amount` decimal(10,2) NOT NULL COMMENT '实收金额',
                          `remark` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '备注',
                          `phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
                          `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
                          `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
                          `consignee` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setmeal`
--

DROP TABLE IF EXISTS `setmeal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setmeal` (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `category_id` int NOT NULL COMMENT '菜品分类id',
                           `name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '套餐名称',
                           `price` decimal(10,2) NOT NULL COMMENT '套餐价格',
                           `status` int DEFAULT NULL COMMENT '状态 0:停用 1:启用',
                           `code` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '编码',
                           `description` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '描述信息',
                           `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '图片',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           `update_time` datetime NOT NULL COMMENT '更新时间',
                           `create_user` int NOT NULL COMMENT '创建人',
                           `update_user` int NOT NULL COMMENT '修改人',
                           `is_deleted` int NOT NULL DEFAULT '0' COMMENT '是否删除',
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `idx_setmeal_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='套餐';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setmeal`
--

LOCK TABLES `setmeal` WRITE;
/*!40000 ALTER TABLE `setmeal` DISABLE KEYS */;
INSERT INTO `setmeal` VALUES (4,8,'最优惠套餐',11100.00,1,'','aaaa','3eb0234d-d1c7-4ef0-bae4-def73ccbb32a.png','2024-04-28 15:37:06','2024-04-28 15:37:06',1,1,0),(5,9,'神龙套餐',8800.00,1,'','bbbb','ab80c47b-1f98-40fd-803b-6479a3ffcd69.png','2024-04-28 15:37:47','2024-04-28 15:37:47',1,1,0);
/*!40000 ALTER TABLE `setmeal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setmeal_dish`
--

DROP TABLE IF EXISTS `setmeal_dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setmeal_dish` (
                                `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `setmeal_id` int NOT NULL COMMENT '套餐id ',
                                `dish_id` int NOT NULL COMMENT '菜品id',
                                `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '菜品名称 （冗余字段）',
                                `price` decimal(10,2) DEFAULT NULL COMMENT '菜品原价（冗余字段）',
                                `copies` int NOT NULL COMMENT '份数',
                                `sort` int NOT NULL DEFAULT '0' COMMENT '排序',
                                `create_time` datetime NOT NULL COMMENT '创建时间',
                                `update_time` datetime NOT NULL COMMENT '更新时间',
                                `create_user` int NOT NULL COMMENT '创建人',
                                `update_user` int NOT NULL COMMENT '修改人',
                                `is_deleted` int NOT NULL DEFAULT '0' COMMENT '是否删除',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='套餐菜品关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setmeal_dish`
--

LOCK TABLES `setmeal_dish` WRITE;
/*!40000 ALTER TABLE `setmeal_dish` DISABLE KEYS */;
INSERT INTO `setmeal_dish` VALUES (6,5,8,'鱼香肉丝',1100.00,1,0,'2024-04-28 15:37:47','2024-04-28 15:37:47',1,1,0),(7,5,11,'麻婆豆腐',3300.00,2,0,'2024-04-28 15:37:47','2024-04-28 15:37:47',1,1,0),(8,5,9,'老干妈土豆丝',4300.00,1,0,'2024-04-28 15:37:47','2024-04-28 15:37:47',1,1,0),(11,4,8,'鱼香肉丝',1100.00,2,0,'2024-04-28 16:11:25','2024-04-28 16:11:25',1,1,0),(12,4,11,'麻婆豆腐',3300.00,1,0,'2024-04-28 16:11:25','2024-04-28 16:11:25',1,1,0);
/*!40000 ALTER TABLE `setmeal_dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart` (
                                 `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '名称',
                                 `image` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '图片',
                                 `user_id` int NOT NULL COMMENT '主键',
                                 `dish_id` int DEFAULT NULL COMMENT '菜品id',
                                 `setmeal_id` int DEFAULT NULL COMMENT '套餐id',
                                 `dish_flavor` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '口味',
                                 `number` int NOT NULL DEFAULT '1' COMMENT '数量',
                                 `amount` decimal(10,2) NOT NULL COMMENT '金额',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='购物车';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '姓名',
                        `phone` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '手机号',
                        `sex` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '性别',
                        `id_number` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '身份证号',
                        `avatar` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '头像',
                        `status` int DEFAULT '0' COMMENT '状态 0:禁用，1:正常',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-28 16:21:46
