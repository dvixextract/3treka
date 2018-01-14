CREATE DATABASE  IF NOT EXISTS `3trekka` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `3trekka`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: 3trekka
-- ------------------------------------------------------
-- Server version	5.5.36

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
-- Table structure for table `p_day`
--

DROP TABLE IF EXISTS `p_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `p_day` (
  `D_id` int(11) NOT NULL,
  `StartDate` datetime DEFAULT NULL,
  `EndDateTime` datetime DEFAULT NULL,
  `D_Date` date DEFAULT NULL,
  PRIMARY KEY (`D_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `p_day`
--

LOCK TABLES `p_day` WRITE;
/*!40000 ALTER TABLE `p_day` DISABLE KEYS */;
/*!40000 ALTER TABLE `p_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `P_code` int(11) NOT NULL,
  `P_name` varchar(255) DEFAULT NULL,
  `P_timespan` varchar(255) DEFAULT NULL,
  `NumTasks` int(11) DEFAULT NULL,
  `NumSprints` int(11) DEFAULT NULL,
  `P_Desc` varchar(255) DEFAULT NULL,
  `P_AsgnTeam` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`P_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (5,'Test','10',3,5,'asadsadsadsc ','Test'),(10,'tstdrive','36',25,10,'testing the project','3treka'),(32,'3treka','36',102,32,'This is a project tracking application','Test'),(34,'TribalNexus','6',12,34,'building an application','DoubleUP'),(976,'trekkkkk','30',24,976,'blaaaa','Teamers');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `T_id` int(11) NOT NULL,
  `T_name` varchar(255) DEFAULT NULL,
  `T_timespan` varchar(255) DEFAULT NULL,
  `P_projectCode` varchar(255) DEFAULT NULL,
  `T_status` varchar(45) NOT NULL,
  `T_Description` varchar(45) DEFAULT NULL,
  `T_lead` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`T_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'xcxcx','1','5','Incomplete','zxcxzcx','Test');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_event`
--

DROP TABLE IF EXISTS `task_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_num` varchar(45) DEFAULT NULL,
  `task_num` varchar(45) DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_event`
--

LOCK TABLES `task_event` WRITE;
/*!40000 ALTER TABLE `task_event` DISABLE KEYS */;
INSERT INTO `task_event` VALUES (1,'5','1','0'),(2,'5','1','2');
/*!40000 ALTER TABLE `task_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taskday`
--

DROP TABLE IF EXISTS `taskday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taskday` (
  `Td_id` int(11) NOT NULL,
  `Td_taskID` int(11) DEFAULT NULL,
  `Td_dayID` int(11) DEFAULT NULL,
  `Td_userID` int(11) DEFAULT NULL,
  `Td_timespan` varchar(255) DEFAULT NULL,
  `Td_Active` int(11) DEFAULT NULL,
  PRIMARY KEY (`Td_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taskday`
--

LOCK TABLES `taskday` WRITE;
/*!40000 ALTER TABLE `taskday` DISABLE KEYS */;
/*!40000 ALTER TABLE `taskday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `TeamID` int(11) NOT NULL,
  `TeamName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TeamID`),
  UNIQUE KEY `TeamName` (`TeamName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_members`
--

DROP TABLE IF EXISTS `team_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_members` (
  `RecordID` int(11) NOT NULL AUTO_INCREMENT,
  `TeamID` int(11) DEFAULT NULL,
  `U_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`RecordID`),
  UNIQUE KEY `tb_uq` (`TeamID`,`U_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_members`
--

LOCK TABLES `team_members` WRITE;
/*!40000 ALTER TABLE `team_members` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teams` (
  `Teamname` varchar(100) NOT NULL,
  `Members` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES ('3treka','dvix'),('Test','1'),('Trial','admin'),('er','dvix'),('er','icon'),('','admin'),('','Masha'),('','admin'),('','kudzai'),('Winners','clint'),('Loosers','2'),('Terror4','clint'),('honnet','clint'),('torrent','2'),('dropme','a'),('Y2K','1'),('DoubleUP','kudzai'),('QG','kudzai'),('StepOut','2'),('2BG','kudzai'),('EasyTeam','1'),('SMA_Team','[4, 8, 7, 1]'),('MusicHeads','[6, 7, 3, 1]'),('ITD_Team','1'),('ITD_Team','4'),('ITD_Team','6'),('ITD_Team','8'),('TinyTemper','1'),('TinyTemper','4'),('TinyTemper','6'),('TinyTemper','8'),('kelamin','8'),('ITD','1'),('Kelatoni','1'),('Teamers','4'),('exile','1');
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccesslevel`
--

DROP TABLE IF EXISTS `useraccesslevel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccesslevel` (
  `AccessLevel` varchar(100) NOT NULL,
  `AccessLevelInfo` text,
  `AccessLevelID` int(11) NOT NULL AUTO_INCREMENT,
  UNIQUE KEY `AccessLevelID_UNIQUE` (`AccessLevelID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccesslevel`
--

LOCK TABLES `useraccesslevel` WRITE;
/*!40000 ALTER TABLE `useraccesslevel` DISABLE KEYS */;
INSERT INTO `useraccesslevel` VALUES ('Tier 4','Super User With full access rights.',1),('Tier 0','employee for less than 3 months contract.',2),('','',3),('Tear 5','highest levels',4);
/*!40000 ALTER TABLE `useraccesslevel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userrole` (
  `Role` varchar(255) NOT NULL,
  `RoleInfo` text,
  `RoleID` int(11) NOT NULL AUTO_INCREMENT,
  UNIQUE KEY `RoleID_UNIQUE` (`RoleID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES ('Observer','Assess team dynamic and note down team strengths and weaknesses.',1),('Data Scientist','Analysing system data and deducing hidden parterns.',2),('Business Analyst','create documents from briding requirements between developers and the business.',3),('','',4),('Scrum master','Lead the team through sprints.',5),('Manager','Manages team and stuff',6),('lecturer','teache students',7);
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `U_id` int(11) NOT NULL AUTO_INCREMENT,
  `U_username` varchar(255) DEFAULT NULL,
  `U_name` varchar(255) DEFAULT NULL,
  `U_surname` varchar(255) DEFAULT NULL,
  `U_email` varchar(255) DEFAULT NULL,
  `U_phone` varchar(255) DEFAULT NULL,
  `U_password` varchar(255) DEFAULT NULL,
  `Role` varchar(100) NOT NULL,
  `accessLevel` varchar(100) NOT NULL,
  `employeeType` varchar(100) NOT NULL,
  PRIMARY KEY (`U_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'dvix','dvix','extract','dvixextract@gmail.com','0729304545','ok','Manager','Tier 3','Permenent'),(2,'1','1','1','1','1','1','Intern','Tier 1','Contract'),(3,'a','a','a','a','2','a','','',''),(4,'kelatoni_admin','admin','admin','admin@kelatoni.co.za','729304545','kelatoni','[Team Lead, Intern, Manager, Scrum Master, Junior Engineer, Intermediate Engineer, Senior Engineer]','[Tier 1, Tier 2, Tier 3]','[Contract, Permanent]'),(5,'2','2','2','2','2','2','Intern','Tier 1','Contract'),(6,'iconies','icon','Lamaf','Iconlamaf@kelatoni.co.za','0','icon','Manager','Tier 3','Permanent'),(7,'ufufufy','clint','ut','clint','976','fttu','Team Lead','Tier 3','Permanent'),(8,'kudzai.mhou','kudzai','Mhou','kudzaimhou@gmail.com','729304545','qwerty','Junior Engineer','Tier 3','Permanent'),(9,'herewego','postane','km','mohale@gmail.com','8755853','1234566','Intern','Tier 3','Permanent');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertype` (
  `EmployeeType` varchar(255) NOT NULL,
  `EmployeeTypeInfo` text,
  `EmployeeTypeID` int(11) NOT NULL AUTO_INCREMENT,
  UNIQUE KEY `EmployeeTypeID_UNIQUE` (`EmployeeTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES ('3rd Party Contractor','Individual contracting from another company.\nUsually two companies in the middle.',1),('','',2),('','',3),('Intern','newbee',4);
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-14 10:12:55
