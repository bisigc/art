-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: art
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

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
-- Table structure for table `Ar`
--

DROP TABLE IF EXISTS `Ar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ar`
--

LOCK TABLES `Ar` WRITE;
/*!40000 ALTER TABLE `Ar` DISABLE KEYS */;
INSERT INTO `Ar` VALUES (6),(7),(9),(11),(12);
/*!40000 ALTER TABLE `Ar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ArSearch`
--

DROP TABLE IF EXISTS `ArSearch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ArSearch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `search` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fauc9tg55n78ftfhci2aliyo0` (`user_id`),
  CONSTRAINT `FK_fauc9tg55n78ftfhci2aliyo0` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ArSearch`
--

LOCK TABLES `ArSearch` WRITE;
/*!40000 ALTER TABLE `ArSearch` DISABLE KEYS */;
/*!40000 ALTER TABLE `ArSearch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ArVersion`
--

DROP TABLE IF EXISTS `ArVersion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ArVersion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `description` longtext,
  `modified` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `arhead_id` bigint(20) DEFAULT NULL,
  `editor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rayosrm3rvvd6v4gfiuj2y29s` (`arhead_id`),
  KEY `FK_dk1d0lj19h3jpbnjj4fo6h55c` (`editor_id`),
  CONSTRAINT `FK_dk1d0lj19h3jpbnjj4fo6h55c` FOREIGN KEY (`editor_id`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_rayosrm3rvvd6v4gfiuj2y29s` FOREIGN KEY (`arhead_id`) REFERENCES `Ar` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ArVersion`
--

LOCK TABLES `ArVersion` WRITE;
/*!40000 ALTER TABLE `ArVersion` DISABLE KEYS */;
INSERT INTO `ArVersion` VALUES (12,'2015-05-26 13:28:39','<p><i>This </i>is the Doodle example to identify the knowledge elements that are apparent and important to know to be able to apply the same AR in a similar project context. See the <a href=\"http://www.computer.org/csdl/mags/so/2015/02/mso2015020026-abs.html\" target=\"_blank\">research paper</a> for details: <a href=\"http://www.computer.org/csdl/mags/so/2015/02/mso2015020026-abs.html\">http://www.computer.org/csdl/mags/so/2015/02/mso2015020026-abs.html</a></p><p><img src=\"http://www.eaipatterns.com/img/MessageChannelSolution.gif\" alt=\"Selfhtml\"/></p>','2015-05-26 13:28:39','De-SQL','published',6,5),(13,'2015-05-26 14:10:01','<p><b>Execution Tasks:</b><br/></p><ul><li>Design document layout (i.e., the pendant to the machine-readable SQL DDL)</li><li>Write new data access layer, implement SQLish query capabilities within project&#8226;Decide on transaction boundaries (if any)</li><li>Documentcument the changes to database administration changes (e.g., command-line DDL/DML, backup)<br/></li></ul>','2015-05-26 14:10:01','ZIO-AR3','draft',7,5),(15,'2015-08-19 16:36:31','<p>Add a tier in <i>physical </i>viewpooint:</p><ul><li>install server</li><li>Follow step documented here: <a href=\"http://www.ifs.hsr.ch/Olaf-Zimmermann.11623.0.html?&amp;L=4\">TODO</a><br/></li></ul><p><u><i><b>tbc</b></i></u></p><p><br/></p><p><a href=\"http://www.exitcertified.com/training/images/featureSheet/topImages/random6.gif\"><u><i><b>http://www.exitcertified.com/training/images/featureSheet/topImages/random6.gif</b></i></u></a><br/></p>','2015-08-19 16:36:31','Add Tier','draft',9,1),(16,'2015-08-19 16:43:36','<p>Add a tier in <i>physical </i>viewpooint:</p><ul><li>install server</li><li>Follow step documented here: <a href=\"http://www.ifs.hsr.ch/Olaf-Zimmermann.11623.0.html?&amp;L=4\">TODO</a><br/></li></ul><p><u><i><b>tbc</b></i></u></p><p><br/></p><p><img src=\"http://www.exitcertified.com/training/images/featureSheet/topImages/random6.gif\"/></p>','2015-08-19 16:43:36','Add Tier','draft',9,1),(18,'2015-09-29 11:16:04','<p></p><p><span>A Client Session State has some disadvantages which can become unhandy when an application runs in a cloud environment.</span><br/></p><p>One major disadvantage for client session state is its limitation of space. For example a cookie can hold only 4093 Bytes. Not be able to store too much data on the client side makes sense, since this forces the development to use either server (not recommended to use in a cloud environment, see <a href=\"http://sinv-56041.edu.hsr.ch/art-app/#/ar/12\">http://sinv-56041.edu.hsr.ch/art-app/#/ar/12</a>) or database session state.</p><p>Also the use of the client session state implies, that all session attributes are transfered back and forth between the client and the server even though not all of the attributes might be used (e.x. to display) on the client side.</p><p>Other advantages of the database session state are for example, that the session gets not lost after connection loss between client and server or after a either one of them crashes.</p><p>In addition Database Session State copes better with a clustered environment than a common Server Session State. Since the session is stored in the database layer, multiple webservers can have access to it (Session migration) and therefore it is not necessary to have Session affinity (only one server which handles the session).</p><p><b>Remark</b>: Remember, at least one attribute (user identifier / session id) has to be stored always on the client side.</p><p></p><hr/><p></p>Affected by the session state migration are the business application (most probably only the backend) and the middleware. Current middleware (e.x. RDBMS) can be used or new middleware (e.x. noSQL Key-Value-Store) has to be put in place.&#160;<span>The first step would be to determine all necessary Session attributes.</span><p>For a new application you are free in the design and choice of storage.&#160;</p>','2015-09-29 11:16:04','Migrate from Client to Database Session State','draft',11,1),(19,'2015-09-29 13:01:54',NULL,'2015-09-29 13:01:54','Migrate from Server to Database Session State','draft',12,1);
/*!40000 ALTER TABLE `ArVersion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ArVersion_ModelElementLink`
--

DROP TABLE IF EXISTS `ArVersion_ModelElementLink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ArVersion_ModelElementLink` (
  `ArVersion_id` bigint(20) NOT NULL,
  `properties_id` bigint(20) NOT NULL,
  KEY `FK_ceaew6fs2p42l9bfqde1wpaqk` (`properties_id`),
  KEY `FK_fkw03099i0x29yelrn49f2js5` (`ArVersion_id`),
  CONSTRAINT `FK_ceaew6fs2p42l9bfqde1wpaqk` FOREIGN KEY (`properties_id`) REFERENCES `ModelElementLink` (`id`),
  CONSTRAINT `FK_fkw03099i0x29yelrn49f2js5` FOREIGN KEY (`ArVersion_id`) REFERENCES `ArVersion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ArVersion_ModelElementLink`
--

LOCK TABLES `ArVersion_ModelElementLink` WRITE;
/*!40000 ALTER TABLE `ArVersion_ModelElementLink` DISABLE KEYS */;
INSERT INTO `ArVersion_ModelElementLink` VALUES (13,50),(13,1),(13,38),(13,34),(13,37),(13,35),(13,40),(13,41),(13,51),(13,52),(13,49),(12,1),(12,48),(12,24),(12,31),(12,33),(12,49),(16,60),(16,11),(16,10),(16,59),(16,25),(16,26),(16,33),(16,45),(19,61),(18,12),(18,62),(18,5),(18,64),(18,63),(18,34),(18,61),(15,60),(15,11),(15,10),(15,59),(15,25),(15,26),(15,33),(15,45);
/*!40000 ALTER TABLE `ArVersion_ModelElementLink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ArVersion_Smell`
--

DROP TABLE IF EXISTS `ArVersion_Smell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ArVersion_Smell` (
  `ArVersion_id` bigint(20) NOT NULL,
  `smells_id` bigint(20) NOT NULL,
  KEY `FK_bt7jxcbdap4mryr6msmvssaj1` (`smells_id`),
  KEY `FK_ndklyjp9hgvd2it5b5dx54klw` (`ArVersion_id`),
  CONSTRAINT `FK_bt7jxcbdap4mryr6msmvssaj1` FOREIGN KEY (`smells_id`) REFERENCES `Smell` (`id`),
  CONSTRAINT `FK_ndklyjp9hgvd2it5b5dx54klw` FOREIGN KEY (`ArVersion_id`) REFERENCES `ArVersion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ArVersion_Smell`
--

LOCK TABLES `ArVersion_Smell` WRITE;
/*!40000 ALTER TABLE `ArVersion_Smell` DISABLE KEYS */;
INSERT INTO `ArVersion_Smell` VALUES (13,18),(12,18),(12,19),(16,23),(16,22),(18,25),(18,26);
/*!40000 ALTER TABLE `ArVersion_Smell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ArVersion_TaskTemplate`
--

DROP TABLE IF EXISTS `ArVersion_TaskTemplate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ArVersion_TaskTemplate` (
  `ArVersion_id` bigint(20) NOT NULL,
  `tasks_id` bigint(20) NOT NULL,
  KEY `FK_jdu4a8o10wxvhgjnxt369mwkr` (`tasks_id`),
  KEY `FK_pve7w7d2e6h1nwangynsjj8dc` (`ArVersion_id`),
  CONSTRAINT `FK_jdu4a8o10wxvhgjnxt369mwkr` FOREIGN KEY (`tasks_id`) REFERENCES `TaskTemplate` (`id`),
  CONSTRAINT `FK_pve7w7d2e6h1nwangynsjj8dc` FOREIGN KEY (`ArVersion_id`) REFERENCES `ArVersion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ArVersion_TaskTemplate`
--

LOCK TABLES `ArVersion_TaskTemplate` WRITE;
/*!40000 ALTER TABLE `ArVersion_TaskTemplate` DISABLE KEYS */;
INSERT INTO `ArVersion_TaskTemplate` VALUES (13,12),(12,5),(16,3),(16,2),(18,17),(18,20),(18,21),(18,22),(15,3),(15,2);
/*!40000 ALTER TABLE `ArVersion_TaskTemplate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` longtext,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `discussion_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_98fa9xjgdg4lqrubyuq5lujp7` (`discussion_id`),
  KEY `FK_jhvt6d9ap8gxv67ftrmshdfhj` (`user_id`),
  CONSTRAINT `FK_98fa9xjgdg4lqrubyuq5lujp7` FOREIGN KEY (`discussion_id`) REFERENCES `Discussion` (`id`),
  CONSTRAINT `FK_jhvt6d9ap8gxv67ftrmshdfhj` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
INSERT INTO `Comment` VALUES (12,'Need to find balance betweenb free form and popups','2015-05-26 14:10:21','2015-05-26 14:10:21',13,5),(13,'Does this really make sense?','2015-08-19 16:38:49','2015-08-19 16:38:49',15,1),(14,'Dunno','2015-08-19 16:38:55','2015-08-19 16:38:55',15,1);
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Digest`
--

DROP TABLE IF EXISTS `Digest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Digest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `salt` varchar(255) DEFAULT NULL,
  `scrypt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Digest`
--

LOCK TABLES `Digest` WRITE;
/*!40000 ALTER TABLE `Digest` DISABLE KEYS */;
INSERT INTO `Digest` VALUES (1,'6jXwcJwzde0gnHW77GSxww==','7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),(2,'6jXwcJwzde0gnHW77GSxww==','7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),(3,'6jXwcJwzde0gnHW77GSxww==','7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),(4,'6jXwcJwzde0gnHW77GSxww==','7tXGVoLVSYrQRoovswFzPbz0YKnioawIq931TSX4iVc='),(5,'UVe6rIH30kUqZpxeoJ3FRQ==','szvPfWiU4mwmiqNzNNs0ALT/dPEMOfsgj4BEGq6yUfQ='),(6,'A+4GOr0IVUAESa14FgR0Zg==','1iH4mxiK+tCV8c6mB+BcH+i8S6CPdBY38yILLqt2Rqo='),(7,'1xBl3UFSF6a+By8AfPGT4A==','6ORGjY7M8YsLqFNrY+pd7VTnmewaz7TCRkX1Q4IC/NI=');
/*!40000 ALTER TABLE `Digest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Discussion`
--

DROP TABLE IF EXISTS `Discussion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Discussion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `ar_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_au0d6h4mkbre9v32xcyr0wmir` (`ar_id`),
  CONSTRAINT `FK_au0d6h4mkbre9v32xcyr0wmir` FOREIGN KEY (`ar_id`) REFERENCES `ArVersion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Discussion`
--

LOCK TABLES `Discussion` WRITE;
/*!40000 ALTER TABLE `Discussion` DISABLE KEYS */;
INSERT INTO `Discussion` VALUES (12,'2015-05-26 13:28:39','DISCUSSION',12),(13,'2015-05-26 14:10:01','DISCUSSION',13),(15,'2015-08-19 16:36:31','DISCUSSION',15),(16,'2015-08-19 16:43:36','DISCUSSION',16),(18,'2015-09-29 11:16:04','DISCUSSION',18),(19,'2015-09-29 13:01:54','DISCUSSION',19);
/*!40000 ALTER TABLE `Discussion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ExecTaskType`
--

DROP TABLE IF EXISTS `ExecTaskType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ExecTaskType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ordering` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_svn6hnkjoy1l6jjgr6fsm69vi` (`parent_id`),
  CONSTRAINT `FK_svn6hnkjoy1l6jjgr6fsm69vi` FOREIGN KEY (`parent_id`) REFERENCES `ExecTaskType` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ExecTaskType`
--

LOCK TABLES `ExecTaskType` WRITE;
/*!40000 ALTER TABLE `ExecTaskType` DISABLE KEYS */;
INSERT INTO `ExecTaskType` VALUES (1,'','root',1,1),(2,'ZIO Task','Execution Task Type',1,1),(3,'','Analysis Task',0,2),(4,'','Measurement Task',0,3),(5,'','Design Task',0,2),(6,'','Decision Task',0,5),(7,'','Development Task',0,2),(8,'','Admin Task',0,2),(9,'','Systemmanagement Task',0,8),(10,'','ITIL Task',0,9),(11,'','Testing Task',0,2),(12,'','Integration Task',0,2),(13,'','Commercial Task',0,2),(14,'','Communication Task',0,2),(15,'','Hold Meeting (ZIO)',0,14),(17,'','New Execution Task Type',0,14),(18,'','Leadership Tasks',0,2),(19,'','EAM Tasks',0,2),(20,'See this article for templates: http://www.ifs.hsr.ch/fileadmin/user_upload/customers/ifs.hsr.ch/Home/projekte/ADMentor-WICSA2015ubmissionv11nc.pdf','Update TOGAF ADM Repo and ADs log',0,19);
/*!40000 ALTER TABLE `ExecTaskType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Likeing`
--

DROP TABLE IF EXISTS `Likeing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Likeing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lpjmiui3dtgtho76r9dvfr8sd` (`comment_id`,`user_id`),
  KEY `FK_3ospvjpcpqhcj5tdwifmlmxo1` (`user_id`),
  CONSTRAINT `FK_3ospvjpcpqhcj5tdwifmlmxo1` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_nwfnc3ifvy0ac6ga20vx3x5ww` FOREIGN KEY (`comment_id`) REFERENCES `Comment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Likeing`
--

LOCK TABLES `Likeing` WRITE;
/*!40000 ALTER TABLE `Likeing` DISABLE KEYS */;
INSERT INTO `Likeing` VALUES (2,13,1),(1,14,1);
/*!40000 ALTER TABLE `Likeing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Menuitem`
--

DROP TABLE IF EXISTS `Menuitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Menuitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ordering` int(11) DEFAULT NULL,
  `pos` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `tooltip` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `menuitem_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_p1p3r8tnjlsh081geeocv246w` (`menuitem_id`),
  CONSTRAINT `FK_p1p3r8tnjlsh081geeocv246w` FOREIGN KEY (`menuitem_id`) REFERENCES `Menuitem` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Menuitem`
--

LOCK TABLES `Menuitem` WRITE;
/*!40000 ALTER TABLE `Menuitem` DISABLE KEYS */;
INSERT INTO `Menuitem` VALUES (1,'Root','','root',0,'','','','root','',1),(3,'AR Browser','','root.arbrowser',10,'left','','Architectural Refactoring Browser','include','',1),(4,'Smell Browser','','root.smellbrowser',15,'left','','','include','',1),(5,'Task Browser','','root.taskbrowser',25,'left','','','include','',1),(6,'Smell Self-Assessment','','root.smellassess',30,'left','','Refactoring Qualification','include','',1),(7,'Admin','','root.admin',40,'left','Admin,Editor','','dropdown','',1),(9,'Execution Task Types','','root.exectypes',10,'left','Admin,Editor','Edit Execution Task Types','include','',7),(10,'AR Meta Data','','root.modelelement',15,'left','Admin,Editor','','include','',7),(11,'Smell Groups','','root.smellgroup',20,'left','Admin,Editor','','include','',7),(12,'About','','root.about',45,'left','','','include','',1),(13,'Profile','','root.profile',50,'right','','','include','',1),(14,'Login','','root.login',55,'right','','','login-logout','',1);
/*!40000 ALTER TABLE `Menuitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ModelElementLink`
--

DROP TABLE IF EXISTS `ModelElementLink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ModelElementLink` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ModelElementLink`
--

LOCK TABLES `ModelElementLink` WRITE;
/*!40000 ALTER TABLE `ModelElementLink` DISABLE KEYS */;
INSERT INTO `ModelElementLink` VALUES (1,NULL,'Context View','ContextElementLink'),(2,NULL,'Functional View','ContextElementLink'),(3,NULL,'Information View','ContextElementLink'),(4,NULL,'Concurrency View','ContextElementLink'),(5,NULL,'Logical View','ContextElementLink'),(6,NULL,'Process View','ContextElementLink'),(7,NULL,'Development View','ContextElementLink'),(8,NULL,'Physical View','ContextElementLink'),(9,NULL,'Scenarios','ContextElementLink'),(10,NULL,'Deployment View','ContextElementLink'),(11,'http://en.wikipedia.org/wiki/Computer_performance','Performance','QASElementLink'),(12,NULL,'Scalability','QASElementLink'),(13,NULL,'Costs','QASElementLink'),(14,NULL,'Complexity','QASElementLink'),(15,NULL,'Dependency','QASElementLink'),(16,NULL,'Probability','QASElementLink'),(17,NULL,'Data integrety','QASElementLink'),(18,NULL,'High parallelisation','DecisionElementLink'),(19,NULL,'Choice of hardware plattform','DecisionElementLink'),(20,NULL,'Choice of operating system','DecisionElementLink'),(21,NULL,'Choice of middleware','DecisionElementLink'),(22,NULL,'Choice of thirdparty vendor','DecisionElementLink'),(23,NULL,'Choice of thirdparty vendor','DecisionElementLink'),(24,NULL,'Approach to threading (concurrency management)','DecisionElementLink'),(25,NULL,'Approach to resource protection','DecisionElementLink'),(26,NULL,'Switch processor (server) architecture to x86','DesignElementLink'),(27,NULL,'Redesign application(s) threading behaviour','DesignElementLink'),(28,NULL,'Reduce used middleware components','DesignElementLink'),(29,NULL,'Create standalone application','DesignElementLink'),(30,NULL,'Provide service','DesignElementLink'),(31,NULL,'Implement threadpooling','DesignElementLink'),(32,NULL,'Re-evaluate existing libraries with respect to threadsafe property','DesignElementLink'),(33,NULL,'Hardware (server)','ComponentElementLink'),(34,NULL,'Application software (Business software)','ComponentElementLink'),(35,NULL,'Operating system','ComponentElementLink'),(36,NULL,'Middleware','ComponentElementLink'),(37,NULL,'Interfaces','ComponentElementLink'),(38,NULL,'Scheduler','ComponentElementLink'),(39,NULL,'Other applications','ComponentElementLink'),(40,NULL,'Quality assurance of service','ComponentElementLink'),(41,NULL,'Unit of work','ComponentElementLink'),(42,NULL,'Software Systems Architecture [Rozanski & Woods]','ReferenceElementLink'),(43,NULL,'Applying UML and Patterns [Larman]','ReferenceElementLink'),(44,NULL,'UML Distilled [Fowler]','ReferenceElementLink'),(45,NULL,'Refactoring To Patterns [Kerievsky]','ReferenceElementLink'),(46,NULL,'Just Enough Software Architecture [Fairbanks]','ReferenceElementLink'),(47,NULL,'Flexibility','QASElementLink'),(48,'http://philippe.kruchten.com/2011/02/10/the-frog-and-the-octopus-go-to-snowbird/','OCTOPUS-1','ContextElementLink'),(49,'http://www.eaipatterns.com/ramblings/74_messaging.html','EIP Website','ReferenceElementLink'),(50,'tbd','Maintainability (ZIO)','QASElementLink'),(51,NULL,'DD-ZIO','DecisionElementLink'),(52,NULL,'tbd','DesignElementLink'),(53,'tbd','Choice of data modeling paradigm (current decision is: relational)','DecisionElementLink'),(54,NULL,'Choice of metamodel and query language (current decision is SQL)','DecisionElementLink'),(55,NULL,'tbc','DecisionElementLink'),(56,NULL,'tbd','DecisionElementLink'),(57,NULL,'dfasdf','QASElementLink'),(58,NULL,'Scenario VP','ContextElementLink'),(59,'abc','New VP','ContextElementLink'),(60,'As an end user, I want to experience subsecond response times so that I can get a lot of work done every time I work withteh system.','Performance IS everything','QASElementLink'),(61,'http://martinfowler.com/books/eaa.html','Patterns of Enterprise Application Architecture [Martin Fowler]','ReferenceElementLink'),(62,NULL,'Security','QASElementLink'),(63,NULL,'Choice of session state management','DecisionElementLink'),(64,NULL,'Conceptual Level','ContextElementLink');
/*!40000 ALTER TABLE `ModelElementLink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Permission`
--

DROP TABLE IF EXISTS `Permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `function` varchar(255) DEFAULT NULL,
  `httpMethod` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Permission`
--

LOCK TABLES `Permission` WRITE;
/*!40000 ALTER TABLE `Permission` DISABLE KEYS */;
INSERT INTO `Permission` VALUES (1,'smell','POST'),(2,'smell','PUT'),(3,'smell','DELETE'),(4,'smellgroup','POST'),(5,'smellgroup','PUT'),(6,'smellgroup','DELETE'),(7,'property','POST'),(8,'property','PUT'),(9,'property','DELETE'),(10,'menu','POST'),(11,'menu','PUT'),(12,'menu','DELETE'),(13,'user','POST'),(14,'user','PUT'),(15,'user','DELETE'),(16,'changepw','PUT'),(17,'exectasktype','POST'),(18,'exectasktype','PUT'),(19,'exectasktype','DELETE'),(20,'discussion','POST'),(21,'discussion','PUT'),(22,'discussion','DELETE'),(23,'comment','POST'),(24,'comment','PUT'),(25,'comment','DELETE'),(26,'like','PUT'),(27,'avatar','POST'),(28,'usersearch','GET'),(29,'usersearch','POST'),(30,'usersearch','DELETE'),(31,'task','POST'),(32,'task','PUT'),(33,'task','DELETE'),(34,'modelelement','POST'),(35,'modelelement','PUT'),(36,'modelelement','DELETE'),(37,'ar','POST'),(38,'ar','PUT'),(39,'ar','DELETE'),(40,'arversion','POST'),(41,'arversion','PUT'),(42,'arversion','DELETE');
/*!40000 ALTER TABLE `Permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Property`
--

DROP TABLE IF EXISTS `Property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute` varchar(255) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderidx` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Property`
--

LOCK TABLES `Property` WRITE;
/*!40000 ALTER TABLE `Property` DISABLE KEYS */;
INSERT INTO `Property` VALUES (1,'group5','OtherCategorie','desc','Group 5',5),(2,'group5','OtherCategorie','desc','Group 5',5);
/*!40000 ALTER TABLE `Property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Question`
--

DROP TABLE IF EXISTS `Question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  `smell_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_otp61ctddtdd511i1t4t2imt3` (`smell_id`),
  CONSTRAINT `FK_otp61ctddtdd511i1t4t2imt3` FOREIGN KEY (`smell_id`) REFERENCES `Smell` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Question`
--

LOCK TABLES `Question` WRITE;
/*!40000 ALTER TABLE `Question` DISABLE KEYS */;
INSERT INTO `Question` VALUES (27,'Are?',18),(28,'you',18),(33,'HELLO?, what is going on here???',22),(34,'This is another Q?',22),(35,'How to do this?',24),(36,'Are you reaching the limit of your session state storage?',25),(37,'Does your session state contain sensitive session data?',26);
/*!40000 ALTER TABLE `Question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,'ART Administrator','Admin'),(2,'Architecture Expert entering architectural refactorings into the ART.','Editor'),(3,'Searchs for architectural refactorings base on smells.','Applier'),(4,'Non Login User with only read rights.','nonLogin');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role_Permission`
--

DROP TABLE IF EXISTS `Role_Permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role_Permission` (
  `Role_id` bigint(20) NOT NULL,
  `permissions_id` bigint(20) NOT NULL,
  KEY `FK_ibnjcmfkplwwcrpbh0sdgdwq1` (`permissions_id`),
  KEY `FK_akd8skuq4c17sbdhpa9yvrhgo` (`Role_id`),
  CONSTRAINT `FK_akd8skuq4c17sbdhpa9yvrhgo` FOREIGN KEY (`Role_id`) REFERENCES `Role` (`id`),
  CONSTRAINT `FK_ibnjcmfkplwwcrpbh0sdgdwq1` FOREIGN KEY (`permissions_id`) REFERENCES `Permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role_Permission`
--

LOCK TABLES `Role_Permission` WRITE;
/*!40000 ALTER TABLE `Role_Permission` DISABLE KEYS */;
INSERT INTO `Role_Permission` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(2,1),(2,2),(2,14),(2,16),(2,17),(2,18),(2,19),(2,23),(2,24),(2,25),(2,26),(2,27),(2,28),(2,29),(2,30),(2,31),(2,32),(2,33),(1,34),(1,35),(1,37),(1,38),(1,40),(1,41),(3,23),(3,24),(3,25),(3,26),(3,27),(3,28),(3,29),(3,30);
/*!40000 ALTER TABLE `Role_Permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Smell`
--

DROP TABLE IF EXISTS `Smell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Smell` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `description` longtext,
  `keywords` varchar(255) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tecdebtidx` varchar(255) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b5xcqtaig9nmfrc7h6ihmqnyf` (`group_id`),
  CONSTRAINT `FK_b5xcqtaig9nmfrc7h6ihmqnyf` FOREIGN KEY (`group_id`) REFERENCES `SmellGroup` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Smell`
--

LOCK TABLES `Smell` WRITE;
/*!40000 ALTER TABLE `Smell` DISABLE KEYS */;
INSERT INTO `Smell` VALUES (18,'2015-05-26 13:31:07','<p>It takes rather long to migrate existing data after an update to the data model (database schema)<br/></p>','Database, flexibility','2015-05-26 13:52:24','Migration Problems','draft','hh',1,2),(19,'2015-05-26 13:32:43','<p>dds<br/></p>','ZIO','2015-05-26 13:32:43','ZIO-Smell','draft','ll',1,2),(22,'2015-08-19 16:46:41','<p>TODO tbd<br/></p>','Infrastructure design','2015-08-19 16:49:12','Performance s***s','draft','hh',0,1),(23,'2015-08-19 16:58:09',NULL,NULL,'2015-08-19 16:58:09','New smell created within AR','draft','mm',0,1),(24,'2015-08-19 18:04:02','<p>hhhh<br/></p>',NULL,'2015-08-19 18:10:51','scalability issuew','draft','mm',0,2),(25,'2015-09-29 14:20:39','<p>Scenario 1:</p><p>During the evolution of an application it might be possible, that more and more session attributes are necessary. The amount of attributes reaches the limit of the session store (e.x. a client side cookie (4093 Bytes)).</p><p><br/></p><p>Scenario 2:</p><p>Your newly developing an application which requires a lot of session attributes.</p>','session, state, attributes','2015-09-29 14:20:39','Large amount of session attributes','draft','mh',0,1),(26,'2015-09-29 16:23:08',NULL,NULL,'2015-09-29 16:23:08','Sensitive Session Data','draft','hh',0,4);
/*!40000 ALTER TABLE `Smell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SmellGroup`
--

DROP TABLE IF EXISTS `SmellGroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SmellGroup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SmellGroup`
--

LOCK TABLES `SmellGroup` WRITE;
/*!40000 ALTER TABLE `SmellGroup` DISABLE KEYS */;
INSERT INTO `SmellGroup` VALUES (1,'desc','Performance'),(2,'desc','Complexity'),(3,'desc','Dependency'),(4,'desc','Security'),(5,'desc','Standards');
/*!40000 ALTER TABLE `SmellGroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TaskProperty`
--

DROP TABLE IF EXISTS `TaskProperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TaskProperty` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  `property_id` bigint(20) DEFAULT NULL,
  `tasktemplate_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qi5jb7uamdad0xgm1ryl1tnyt` (`property_id`),
  KEY `FK_nd6owxx92onfi9rmy9y0bpjck` (`tasktemplate_id`),
  CONSTRAINT `FK_nd6owxx92onfi9rmy9y0bpjck` FOREIGN KEY (`tasktemplate_id`) REFERENCES `TaskTemplate` (`id`),
  CONSTRAINT `FK_qi5jb7uamdad0xgm1ryl1tnyt` FOREIGN KEY (`property_id`) REFERENCES `TaskPropertyType` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TaskProperty`
--

LOCK TABLES `TaskProperty` WRITE;
/*!40000 ALTER TABLE `TaskProperty` DISABLE KEYS */;
INSERT INTO `TaskProperty` VALUES (1,'Design Task',8,1),(2,'high',10,1),(3,'20h',12,1),(4,'Communication Task',8,2),(5,'medium',10,2),(6,'10h',12,2),(7,'Development Task',8,3),(8,'medium',10,3),(9,'10h',12,3),(10,'Development Task',8,4),(11,'medium',10,4),(12,'1h',12,4),(13,'Testing Task',8,5),(14,'low',10,5),(15,'15h',12,5),(16,'Testing Task',8,6),(17,'medium',10,6),(19,'Integration Task',8,7),(20,'high',10,7),(21,'8h',12,7),(22,'Commercial Task',8,8),(23,'high',10,8),(24,'40h',12,8),(25,'Measurement Task',8,9),(26,'medium',10,9),(27,'3h',12,9),(28,'Design Task',8,10),(29,'medium',10,10),(30,'1h',12,10),(32,'low',10,11),(33,'19h',12,11),(34,'qwq',12,16),(35,'<p>See <a href=\"http://epf.eclipse.org/wikis/openup/\">OpenUP</a><br/></p>',9,16),(36,'Analysis Task',8,17),(37,'<p>Analyse the current implementation, which attributes are saved in the client side cookie.&#160;</p>',9,17),(40,'Decision Task',8,20),(41,'<p>Evaluate which Session State Store should be used. It is possible to use a SQL based RDBMS or for example a noSQL Key value store which might be much more performant.&#160;</p>',9,20),(42,'Softwarearchitect',7,21),(43,'Design Task',8,21),(44,'Softwarearchitect',7,22),(45,'Design Task',8,22),(46,'<ul><li>Compare a list of the current attributes and with a list of the future attributes.</li><li>Search for the affected program parts</li><li>Create a data migration mapping</li></ul>',9,22);
/*!40000 ALTER TABLE `TaskProperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TaskPropertyType`
--

DROP TABLE IF EXISTS `TaskPropertyType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TaskPropertyType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TaskPropertyType`
--

LOCK TABLES `TaskPropertyType` WRITE;
/*!40000 ALTER TABLE `TaskPropertyType` DISABLE KEYS */;
INSERT INTO `TaskPropertyType` VALUES (7,'Assignee'),(8,'Type'),(9,'Description'),(10,'Priority'),(11,'Due Date'),(12,'Estimated Duration');
/*!40000 ALTER TABLE `TaskPropertyType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TaskTemplate`
--

DROP TABLE IF EXISTS `TaskTemplate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TaskTemplate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3x1w26hwv38j1d5wj71u9hg35` (`parent_id`),
  CONSTRAINT `FK_3x1w26hwv38j1d5wj71u9hg35` FOREIGN KEY (`parent_id`) REFERENCES `TaskTemplate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TaskTemplate`
--

LOCK TABLES `TaskTemplate` WRITE;
/*!40000 ALTER TABLE `TaskTemplate` DISABLE KEYS */;
INSERT INTO `TaskTemplate` VALUES (1,'Create SAD',NULL),(2,'Organise project status meeting',NULL),(3,'Organise code review meeting',NULL),(4,'Implement change',NULL),(5,'Execute load test',NULL),(6,'Execute integration test',NULL),(7,'Deploy application',NULL),(8,'Purchase 3rd party software license',NULL),(9,'Emit current application performance',NULL),(10,'Software Architecture Design sign-off',NULL),(11,'Order Server Hardware',NULL),(12,'Redesign layer (ZIO)',NULL),(13,'Design document layout (i.e., the pendant to the machine-readable SQL DDL)',NULL),(14,'Get work done',NULL),(16,'Design system the rational way :-)',NULL),(17,'Determine used Session parameters',NULL),(20,'Evaluate Session State Store',NULL),(21,'Adjust current Application Design',NULL),(22,'Create attribute migration plan',NULL);
/*!40000 ALTER TABLE `TaskTemplate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` longblob,
  `created` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `organisation` varchar(255) DEFAULT NULL,
  `startpage` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`),
  KEY `FK_fe6nqh4mlcjr068gcfrstmh2y` (`role_id`),
  CONSTRAINT `FK_fe6nqh4mlcjr068gcfrstmh2y` FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,NULL,'2015-05-26 09:45:12','cbisig@hsr.ch','Christian','http://www.hsr.ch','Bisig','2015-05-26 09:45:12','HSR','stay',1),(2,NULL,'2015-05-26 09:45:12','admin@hsr.ch','Hans','http://www.hsr.ch','Admin','2015-05-26 09:45:12','HSR','stay',1),(3,NULL,'2015-05-26 09:45:12','editor@hsr.ch','Hugo','http://www.hsr.ch','Editor','2015-05-26 09:45:12','HSR','stay',2),(4,NULL,'2015-05-26 09:45:12','applier@hsr.ch','Rudolf','http://www.hsr.ch','Applier','2015-05-26 09:45:12','HSR','stay',3),(5,NULL,NULL,'ozimmerm@hsr.ch','Olaf','http://www.ifs.hsr.ch/Olaf-Zimmermann.11623.0.html?&L=4','Zimmermann',NULL,'HSR FHO, Institute for Software','arbrowser',1),(6,NULL,NULL,'test@test.org','TEst','www.google.ch','test',NULL,'test','arbrowser',2),(7,NULL,NULL,'tbd@t.b.c','OLAF','TBC','Zimm',NULL,'tbd','home',2);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-13 23:33:41