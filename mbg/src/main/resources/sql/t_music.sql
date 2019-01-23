-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: letui
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_music`
--

DROP TABLE IF EXISTS `t_music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_music` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `singer_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '歌手名字',
  `song_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '歌曲名称',
  `type` smallint(2) NOT NULL DEFAULT '-1' COMMENT '歌曲类型:：-1：其他；0：网络歌曲；1：流行歌曲；2：怀旧经典；3：纯音乐；4：儿歌；',
  `url` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '音频外链',
  `intervals` int(11) DEFAULT NULL COMMENT '时长(interval是关键字)',
  `status` smallint(2) NOT NULL DEFAULT '0' COMMENT '状态 -1：删除 0：正常',
  `create_by` bigint(20) NOT NULL COMMENT '创建者id',
  `create_by_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者名字',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者id',
  `update_by_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '更新者名字',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23 17:14:36
