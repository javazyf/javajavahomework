-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: homework
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `post_id` bigint(20) NOT NULL,
  `post_writerid` bigint(20) NOT NULL,
  `post_title` varchar(45) NOT NULL,
  `post_tag1` int(11) NOT NULL,
  `post_tag2` int(11) DEFAULT NULL,
  `post_tag3` int(11) DEFAULT NULL,
  `post_visible` int(11) NOT NULL,
  `post_price` int(11) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `post_txt1` varchar(45) DEFAULT NULL,
  `post_impage1` varchar(45) DEFAULT NULL,
  `post_txt2` varchar(45) DEFAULT NULL,
  `post_impage2` varchar(45) DEFAULT NULL,
  `post_txt3` varchar(45) DEFAULT NULL,
  `post_impage3` varchar(45) DEFAULT NULL,
  `post_txt4` varchar(45) DEFAULT NULL,
  `post_impage4` varchar(45) DEFAULT NULL,
  `post_txt5` varchar(45) DEFAULT NULL,
  `post_impage5` varchar(45) DEFAULT NULL,
  `post_txt6` varchar(45) DEFAULT NULL,
  `post_impage6` varchar(45) DEFAULT NULL,
  `post_txt7` varchar(45) DEFAULT NULL,
  `post_impage7` varchar(45) DEFAULT NULL,
  `post_txt8` varchar(45) DEFAULT NULL,
  `post_impage8` varchar(45) DEFAULT NULL,
  `post_txt9` varchar(45) DEFAULT NULL,
  `post_impage9` varchar(45) DEFAULT NULL,
  `post_txt10` varchar(45) DEFAULT NULL,
  `post_impage10` varchar(45) DEFAULT NULL,
  `post_zan` int(11) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,2016001,'1',1,1,1,1,12,'2016-12-14 00:00:00','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100','2016000100',12),(2,2016002,'2',1,1,1,1,0,'2016-12-18 00:16:27','2016001',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,2016002,'money',1,1,1,0,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,0,'123123',1,NULL,NULL,0,NULL,NULL,'123','/image/1.jpg','123','/image/1.jpg','123','/image/1.jpg','123','/image/1.jpg','123','/image/1.jpg','123','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,0,'123123',1,NULL,NULL,0,NULL,NULL,'123','/image/1.jpg','123','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,0,'123123',1,NULL,NULL,0,NULL,NULL,'','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,0,'123123',1,NULL,NULL,0,NULL,NULL,'123','/image/1.jpg','','/image/1.jpg','123','/image/1.jpg','123','/image/1.jpg','123','/image/1.jpg','123','/image/1.jpg','123','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','/image/1.jpg','','/image/1.jpg','123','/image/1.jpg',NULL),(11,0,'123123',1,NULL,NULL,0,NULL,NULL,'','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,0,'123123',1,NULL,NULL,0,NULL,NULL,'123','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','/image/1.jpg','','/image/1.jpg','123','/image/1.jpg',NULL),(14,0,'123123',1,NULL,NULL,0,NULL,NULL,'','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,0,'123123',1,NULL,NULL,0,NULL,NULL,'','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg',NULL,NULL,NULL),(16,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','/image/1.jpg','','/image/1.jpg','','/image/1.jpg',NULL),(17,0,'123123',1,NULL,NULL,0,NULL,NULL,'sdg','/image/1.jpg','gh','/image/1.jpg','huj','/image/1.jpg','huj','/image/1.jpg','gh','/image/1.jpg','gh','/image/1.jpg','gh','/image/1.jpg','gh','/image/1.jpg','gh','/image/1.jpg',NULL,NULL,NULL),(18,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,0,'123123',1,NULL,NULL,0,NULL,NULL,'aaa','/image/1.jpg','fg','/image/1.jpg','g','/image/1.jpg','h','/image/1.jpg','是','/image/1.jpg','s','/image/1.jpg','d','/image/1.jpg','f','/image/1.jpg','h','/image/1.jpg','了','/image/1.jpg',NULL),(20,0,'123123',1,NULL,NULL,0,NULL,NULL,'手术','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,0,'123123',1,NULL,NULL,0,NULL,NULL,'','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,0,'123123',1,NULL,NULL,0,NULL,NULL,'dd','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg','','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,0,'123123',1,NULL,NULL,0,NULL,NULL,'ww','/image/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,0,'123123',1,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-23 20:20:38
