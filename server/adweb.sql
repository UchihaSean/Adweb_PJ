-- MySQL dump 10.13  Distrib 5.6.30, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: adweb
-- ------------------------------------------------------
-- Server version	5.6.30-0ubuntu0.14.04.1

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
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action` (
  `uid` int(11) DEFAULT NULL,
  `vid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,1,0),(1,1,1),(1,1,2),(1,2,2),(1,3,1),(1,3,0),(2,1,0),(2,1,2),(2,3,1),(2,2,1),(2,3,2),(3,1,1),(3,2,0),(3,3,2),(3,4,1),(3,4,0);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `vid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `detail` varchar(100) DEFAULT NULL,
  `url` varchar(10) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `addtion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flag`
--

DROP TABLE IF EXISTS `flag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flag` (
  `fid` int(11) DEFAULT NULL,
  `vid` int(11) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `addtion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flag`
--

LOCK TABLES `flag` WRITE;
/*!40000 ALTER TABLE `flag` DISABLE KEYS */;
/*!40000 ALTER TABLE `flag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--


/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'zhouyi','123456',NULL),(2,'gym','123456',NULL),(3,'jly','123456',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `view`
--

DROP TABLE IF EXISTS `view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `view` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `detail` varchar(100) DEFAULT NULL,
  `picture` varchar(10) DEFAULT NULL,
  `scope` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `view`
--

LOCK TABLES `view` WRITE;
/*!40000 ALTER TABLE `view` DISABLE KEYS */;
INSERT INTO `view` VALUES (1,0,'复旦大学张江校区',121.606,31.1951,'复旦是个好学校','v_fddx','121.601307,31.197314,121.607451,31.198056,121.607972,31.191708,121.605475,31.191353,121.604073,31.194581,121.601864,31.194272'),(2,0,'上海中医药大学',121.603,31.2003,'在复旦大学隔壁的学校，女生比较多','v_shzyydx','121.60121,31.197493,121.600375,31.199601,121.597644,31.199508,121.59653,31.200744,121.60704,31.202118,121.60704,31.202118'),(3,1,'曙光医院',121.6,31.1921,'三级甲等','v_sgyy','121.59869,31.190792,121.597881,31.193341,121.601852,31.19416,121.602912,31.192136,121.602355,31.191348'),(4,1,'高科苑',121.6,31.1959,'小高层公寓，包括复旦学生和企业人员。','v_gky','121.600307,31.193997,121.599651,31.195218,121.598438,31.195658,121.598016,31.196731,121.601169,31.197233,121.60187,31.194237');
/*!40000 ALTER TABLE `view` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-02 18:40:11

DROP TABLE IF EXISTS `search`;
CREATE TABLE `search` (
  `uid` int(11) DEFAULT NULL,
  `vid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
