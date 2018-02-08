-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 192.168.1.231    Database: erp_db
-- ------------------------------------------------------
-- Server version	5.0.67-Max

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `reg_contables`
--

DROP TABLE IF EXISTS `reg_contables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reg_contables` (
  `id_reg` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(45) default NULL,
  `tipo` char(1) NOT NULL,
  `monto` decimal(10,3) NOT NULL,
  PRIMARY KEY  (`id_reg`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reg_contables`
--

LOCK TABLES `reg_contables` WRITE;
/*!40000 ALTER TABLE `reg_contables` DISABLE KEYS */;
INSERT INTO `reg_contables` VALUES (13,'2018-02-07','pago haberes','d',1500.000),(5,'2018-02-07','pago haberes','d',1500.000),(7,'2018-02-07','pago haberes','d',1500.000),(9,'2018-02-07','pago haberes','d',1500.000),(11,'2018-02-07','pago haberes','h',2500.000),(154,'2018-02-07','pagos','h',1500.000),(114,'2018-02-07','pago de haberes xd','d',2000.000),(116,'2018-02-07','cobro credito','h',13000.000),(115,'2018-02-07','cobro','h',122.000),(117,'2018-02-07','cobro credito a empleado','h',1300.000),(121,'2018-02-07','pago haberes','d',113.000);
/*!40000 ALTER TABLE `reg_contables` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-07 20:41:27
