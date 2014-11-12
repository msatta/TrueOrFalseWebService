CREATE DATABASE  IF NOT EXISTS `trueorfalse` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `trueorfalse`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: trueorfalse
-- ------------------------------------------------------
-- Server version	5.5.25

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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer` bit(1) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'\0','Mexico achieved independence before USA'),(2,'','Henry VIII wife Anne Boleyn was executed'),(3,'','Alexander the Great became Pharaoh of Egypt'),(4,'','The Parthenon was built before the Colossus of Rhodes'),(5,'\0','The Magna Carta was signed in Rome'),(6,'\0','Nero was the first Roman Emperor'),(7,'','Marie Antoinette was married to Louis XVI'),(8,'','Cleopatra had a child with Julius Caesar'),(9,'\0','No US Presidents have been born in Missouri'),(10,'\0','Sir Winston Churchill was a Labour Prime Minister'),(11,'','Lieutenant Colonel Custer was defeated at Little Bighorn'),(12,'','The Iron Age comes after the Bronze Age'),(13,'\0','Joan of Arc fought at the Battle of Agincourt'),(14,'\0','Schuyler Colfax was Abraham Lincoln\'s Vice President'),(15,'\0','The Ming Dynasty was the final Chinese Dynasty'),(16,'\0','Stephenson\'s Rocket was the first steam locomotive'),(17,'\0','Blackbeard had a wooden leg'),(18,'','Socrates was sentenced to death'),(19,'\0','VJ Day occurred prior to VE Day'),(20,'','Norway separated from Sweden in the 20th Century'),(21,'','The White House was built before Big Ben'),(22,'','The Crimean War was fought before the Boer Wars'),(23,'\0','Wilbur Wright made the first successful powered flight'),(24,'','The Berlin Wall was constructed by East Germany'),(25,'','Napoleon Bonaparte\'s first wife was a widow'),(26,'','Genghis Khan\'s real name was Temujin'),(27,'\0','William Wallace lived before King Macbeth'),(28,'\0','Columbus crossed the Atlantic in the Mary Rose'),(29,'\0','Billy the Kid never actually shot anyone dead'),(30,'','Roald Amundsen was the first man to reach the South Pole');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bestscore` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a7hlm8sj8kmijx6ucp7wfyt31` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,20,'player1',1),(3,19,'player2',2),(4,18,'player3',3),(5,17,'player4',4),(6,16,'player5',5),(7,15,'player6',6),(8,14,'player7',7),(9,13,'player8',8),(10,12,'player9',9),(11,11,'player10',10);
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

-- Dump completed on 2014-11-11 20:11:51
