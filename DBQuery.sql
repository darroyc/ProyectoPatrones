-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for sistemacompras
CREATE DATABASE IF NOT EXISTS `sistemacompras` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sistemacompras`;

-- Dumping structure for table sistemacompras.tdepartamento
CREATE TABLE IF NOT EXISTS `tdepartamento` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `NombreDepartamento` varchar(60) DEFAULT NULL,
  `LlavePublica` blob DEFAULT NULL,
  `LlavePrivada` blob DEFAULT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table sistemacompras.templeado
CREATE TABLE IF NOT EXISTS `templeado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `NombreEmpleado` varchar(60) DEFAULT NULL,
  `RolEmpleado` varchar(60) DEFAULT NULL,
  `Contrasenna` varchar(60) DEFAULT NULL,
  `idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `idDepartamento` (`idDepartamento`),
  CONSTRAINT `templeado_ibfk_1` FOREIGN KEY (`idDepartamento`) REFERENCES `tdepartamento` (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table sistemacompras.ttramite
CREATE TABLE IF NOT EXISTS `ttramite` (
  `idTramite` int(11) NOT NULL AUTO_INCREMENT,
  `NombreTramite` varchar(50) NOT NULL DEFAULT '0',
  `DescripcionTramite` varchar(500) DEFAULT NULL,
  `ContenidoTramite` blob DEFAULT NULL,
  `FirmaDigitalTramite` varchar(250) DEFAULT NULL,
  `OrigenTramite` varchar(250) DEFAULT NULL,
  `DestinoTramite` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idTramite`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
