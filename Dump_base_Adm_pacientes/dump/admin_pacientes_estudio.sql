-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: admin_pacientes
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estudio`
--

DROP TABLE IF EXISTS `estudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudio` (
  `id_estudio` int NOT NULL AUTO_INCREMENT,
  `id_hc` int NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` longtext NOT NULL,
  `diagnostico` longtext NOT NULL,
  `id_profesional_sol` int DEFAULT NULL,
  `id_profesional_anes` int DEFAULT NULL,
  `id_profesional_ayu` int DEFAULT NULL,
  `flg_baja` tinyint NOT NULL DEFAULT '0',
  `flg_cerrado` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_estudio`),
  KEY `id_hc` (`id_hc`),
  KEY `id_profesional_sol` (`id_profesional_sol`),
  KEY `id_profesional_anes` (`id_profesional_anes`),
  KEY `id_profesional_ayu` (`id_profesional_ayu`),
  CONSTRAINT `estudio_ibfk_1` FOREIGN KEY (`id_hc`) REFERENCES `hc` (`id_hc`),
  CONSTRAINT `estudio_ibfk_2` FOREIGN KEY (`id_profesional_sol`) REFERENCES `profesional` (`id_profesional`),
  CONSTRAINT `estudio_ibfk_3` FOREIGN KEY (`id_profesional_anes`) REFERENCES `profesional` (`id_profesional`),
  CONSTRAINT `estudio_ibfk_4` FOREIGN KEY (`id_profesional_ayu`) REFERENCES `profesional` (`id_profesional`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-19 18:09:44
