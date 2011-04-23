-- MySQL dump 10.13  Distrib 5.1.52, for apple-darwin10.3.0 (i386)
--
-- Host: localhost    Database: tanyajava
-- ------------------------------------------------------
-- Server version	5.1.52

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
-- Table structure for table `QUESTION_TAGS`
--

DROP TABLE IF EXISTS `QUESTION_TAGS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QUESTION_TAGS` (
  `QUESTION_ID` bigint(20) NOT NULL,
  `TAG_ID` bigint(20) NOT NULL,
  KEY `FK7E1738D2C994394F` (`QUESTION_ID`),
  KEY `FK7E1738D215B3B905` (`TAG_ID`),
  CONSTRAINT `FK7E1738D215B3B905` FOREIGN KEY (`TAG_ID`) REFERENCES `T_TAG` (`TAG_ID`),
  CONSTRAINT `FK7E1738D2C994394F` FOREIGN KEY (`QUESTION_ID`) REFERENCES `T_QUESTION` (`QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_ANSWER`
--

DROP TABLE IF EXISTS `T_ANSWER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_ANSWER` (
  `ANSWER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWER` longtext,
  `DATE_CREATED` datetime DEFAULT NULL,
  `VOTED_DOWN` bigint(20) DEFAULT NULL,
  `VOTED_UP` bigint(20) DEFAULT NULL,
  `QUESTION_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ANSWER_ID`),
  KEY `FK2AAFEA09F44DE5AF` (`USER_ID`),
  KEY `FK2AAFEA09C994394F` (`QUESTION_ID`),
  CONSTRAINT `FK2AAFEA09C994394F` FOREIGN KEY (`QUESTION_ID`) REFERENCES `T_QUESTION` (`QUESTION_ID`),
  CONSTRAINT `FK2AAFEA09F44DE5AF` FOREIGN KEY (`USER_ID`) REFERENCES `T_USER` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_ANSWER_RESPONSE`
--

DROP TABLE IF EXISTS `T_ANSWER_RESPONSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_ANSWER_RESPONSE` (
  `ANSWER_RESPONSE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_CREATED` datetime DEFAULT NULL,
  `RESPONSE` longtext,
  `USER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ANSWER_RESPONSE_ID`),
  KEY `FK41EE85B7F44DE5AF` (`USER_ID`),
  CONSTRAINT `FK41EE85B7F44DE5AF` FOREIGN KEY (`USER_ID`) REFERENCES `T_USER` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_BADGE`
--

DROP TABLE IF EXISTS `T_BADGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_BADGE` (
  `BADGE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ASSIGNED` bigint(20) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `BADGE_NAME` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`BADGE_ID`),
  UNIQUE KEY `BADGE_NAME` (`BADGE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_BRP`
--

DROP TABLE IF EXISTS `T_BRP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_BRP` (
  `BRP_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ASSIGNEe_ID` bigint(20) DEFAULT NULL,
  `USER_ASSIGNER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`BRP_ID`),
  KEY `FK4CBE7957E846B7` (`USER_ASSIGNEe_ID`),
  KEY `FK4CBE7957EE2F8A` (`USER_ASSIGNER_ID`),
  CONSTRAINT `FK4CBE7957E846B7` FOREIGN KEY (`USER_ASSIGNEe_ID`) REFERENCES `T_USER` (`USER_ID`),
  CONSTRAINT `FK4CBE7957EE2F8A` FOREIGN KEY (`USER_ASSIGNER_ID`) REFERENCES `T_USER` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_COMPANY_ROLE`
--

DROP TABLE IF EXISTS `T_COMPANY_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_COMPANY_ROLE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ROLE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_CONNECTION`
--

DROP TABLE IF EXISTS `T_CONNECTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_CONNECTION` (
  `CONNECTION_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACCESS_TOKEN` varchar(255) DEFAULT NULL,
  `ACCOUNT_ID` varchar(255) DEFAULT NULL,
  `PROVIDER_ACCOUNT_ID` varchar(255) DEFAULT NULL,
  `PROVIDER_ID` varchar(255) DEFAULT NULL,
  `REFRESH_TOKEN` varchar(255) DEFAULT NULL,
  `SECRET` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CONNECTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_DOWNLOAD`
--

DROP TABLE IF EXISTS `T_DOWNLOAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_DOWNLOAD` (
  `DOWNLOAD_ID` varchar(20) NOT NULL,
  `BLOG` varchar(100) NOT NULL,
  `COMPANY` varchar(100) NOT NULL,
  `COMPANY_ROLE` varchar(30) DEFAULT NULL,
  `DOWNLOAD_DATE` datetime DEFAULT NULL,
  `DOWNLOADED_DATE` datetime DEFAULT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `USER_NAME` varchar(100) NOT NULL,
  `NEWSLETTER` bit(1) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `PROJECT_STAGE` varchar(30) DEFAULT NULL,
  `STATUS` varchar(1) DEFAULT NULL,
  `TEAM_SIZE` int(11) DEFAULT NULL,
  `DOWNLOAD_ITEM_FK` varchar(15) NOT NULL,
  PRIMARY KEY (`DOWNLOAD_ID`),
  KEY `FKB13F0813D187BB4A` (`DOWNLOAD_ITEM_FK`),
  CONSTRAINT `FKB13F0813D187BB4A` FOREIGN KEY (`DOWNLOAD_ITEM_FK`) REFERENCES `T_DOWNLOAD_ITEM` (`DOWNLOAD_ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_DOWNLOAD_ITEM`
--

DROP TABLE IF EXISTS `T_DOWNLOAD_ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_DOWNLOAD_ITEM` (
  `DOWNLOAD_ITEM_ID` varchar(15) NOT NULL,
  `CONTENT` longtext,
  `EMAIL_FROM` varchar(100) DEFAULT NULL,
  `EMAIL_SUBJECT` varchar(100) DEFAULT NULL,
  `EMAIL_TEMPLATE` longtext,
  `FILE_ABSOLUTE_PATH` varchar(150) DEFAULT NULL,
  `FILE_MIME_TYPE` varchar(150) DEFAULT NULL,
  `FILE_NAME` varchar(150) DEFAULT NULL,
  `TITLE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DOWNLOAD_ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_GRP`
--

DROP TABLE IF EXISTS `T_GRP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_GRP` (
  `GRP_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ASSIGNEE_ID` bigint(20) DEFAULT NULL,
  `USER_ASSIGNER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`GRP_ID`),
  KEY `FK4CBFA5A7E846B7` (`USER_ASSIGNEE_ID`),
  KEY `FK4CBFA5A7EE2F8A` (`USER_ASSIGNER_ID`),
  CONSTRAINT `FK4CBFA5A7E846B7` FOREIGN KEY (`USER_ASSIGNEE_ID`) REFERENCES `T_USER` (`USER_ID`),
  CONSTRAINT `FK4CBFA5A7EE2F8A` FOREIGN KEY (`USER_ASSIGNER_ID`) REFERENCES `T_USER` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_PROJECT_STAGE`
--

DROP TABLE IF EXISTS `T_PROJECT_STAGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_PROJECT_STAGE` (
  `PS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PROJECT_STAGE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`PS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_QUESTION`
--

DROP TABLE IF EXISTS `T_QUESTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_QUESTION` (
  `QUESTION_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWERED` bit(1) DEFAULT NULL,
  `DATE_CREATED` datetime DEFAULT NULL,
  `QUESTION` longtext,
  `TITLE` varchar(255) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `VIEWED` bigint(20) DEFAULT NULL,
  `ANSWER_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`QUESTION_ID`),
  UNIQUE KEY `URL` (`URL`),
  KEY `FK16A67B7146C3DB8F` (`ANSWER_ID`),
  KEY `FK16A67B71F44DE5AF` (`USER_ID`),
  CONSTRAINT `FK16A67B7146C3DB8F` FOREIGN KEY (`ANSWER_ID`) REFERENCES `T_ANSWER` (`ANSWER_ID`),
  CONSTRAINT `FK16A67B71F44DE5AF` FOREIGN KEY (`USER_ID`) REFERENCES `T_USER` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_QUESTION_T_ANSWER`
--

DROP TABLE IF EXISTS `T_QUESTION_T_ANSWER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_QUESTION_T_ANSWER` (
  `T_QUESTION_QUESTION_ID` bigint(20) NOT NULL,
  `answers_ANSWER_ID` bigint(20) NOT NULL,
  UNIQUE KEY `answers_ANSWER_ID` (`answers_ANSWER_ID`),
  KEY `FK51F3EF1730424045` (`answers_ANSWER_ID`),
  KEY `FK51F3EF17C995D561` (`T_QUESTION_QUESTION_ID`),
  CONSTRAINT `FK51F3EF1730424045` FOREIGN KEY (`answers_ANSWER_ID`) REFERENCES `T_ANSWER` (`ANSWER_ID`),
  CONSTRAINT `FK51F3EF17C995D561` FOREIGN KEY (`T_QUESTION_QUESTION_ID`) REFERENCES `T_QUESTION` (`QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_SEQUENCE`
--

DROP TABLE IF EXISTS `T_SEQUENCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_SEQUENCE` (
  `SEQ_ID` varchar(255) NOT NULL,
  `SEQ_DATE` varchar(255) DEFAULT NULL,
  `LAST_SEQUENCE` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SEQ_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_TAG`
--

DROP TABLE IF EXISTS `T_TAG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_TAG` (
  `TAG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ASSIGNED` bigint(20) DEFAULT NULL,
  `DATE_CREATED` datetime DEFAULT NULL,
  `TAG_NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`TAG_ID`),
  UNIQUE KEY `TAG_NAME` (`TAG_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_USER`
--

DROP TABLE IF EXISTS `T_USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_USER` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(100) DEFAULT NULL,
  `USER_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `T_USER_T_BADGE`
--

DROP TABLE IF EXISTS `T_USER_T_BADGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_USER_T_BADGE` (
  `USER_ID` bigint(20) NOT NULL,
  `BADGE_ID` bigint(20) NOT NULL,
  KEY `FK5736996F242719A5` (`BADGE_ID`),
  KEY `FK5736996FF44DE5AF` (`USER_ID`),
  CONSTRAINT `FK5736996F242719A5` FOREIGN KEY (`BADGE_ID`) REFERENCES `T_BADGE` (`BADGE_ID`),
  CONSTRAINT `FK5736996FF44DE5AF` FOREIGN KEY (`USER_ID`) REFERENCES `T_USER` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-04-23 13:56:10
