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
  `LlavePublica` varchar(1024) DEFAULT NULL,
  `LlavePrivada` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sistemacompras.tdepartamento: ~4 rows (approximately)
/*!40000 ALTER TABLE `tdepartamento` DISABLE KEYS */;
INSERT INTO `tdepartamento` (`idDepartamento`, `NombreDepartamento`, `LlavePublica`, `LlavePrivada`) VALUES
	(1, 'Administracion', NULL, NULL),
	(2, 'Finanzas', NULL, NULL),
	(3, 'IT', NULL, NULL),
	(4, 'Otros', 'MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAILb2c0p++VfDOG3SjXHsHBe4EIA71xMYHnsV8ivNueELG8LxBm1hrHHhKY1vnHQ/V+JwOtuKzyNYAnuFkBSUlUCAwEAAQ==', 'MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAgtvZzSn75V8M4bdKNcewcF7gQgDvXExgeexXyK8254QsbwvEGbWGsceEpjW+cdD9X4nA624rPI1gCe4WQFJSVQIDAQABAkABpTH/2l9IawGGdP+B3ZjiUM8RBWH9DxjHb6lK5KkUEBjA3uFSG3O/AIJ4lh9sMSakYq0tjCkj1Je6f3Wu/f0BAiEAxlUo0GqmqsgxDXvyCVfioEL9np8jPacam3hmseH+YgkCIQCo6Eqo0F8PWBw4sEspMpt2uzSocSiKK0do48ztjGkQ7QIhAId0siNmM96AS8BB3tSyyX1bQ4yKc68v6eQ1Hy5ugybBAiBRBvZh22vuwXbwXun/fm6D27ScJYSsG6zrDXTOdDAm1QIgGZGJrsp0EY91nUqru3PZpy4jgC1nKRJOJIVmeJ2YUyc=');
/*!40000 ALTER TABLE `tdepartamento` ENABLE KEYS */;

-- Dumping structure for table sistemacompras.templeado
CREATE TABLE IF NOT EXISTS `templeado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `NombreEmpleado` varchar(60) DEFAULT NULL,
  `RolEmpleado` varchar(60) DEFAULT NULL,
  `ContrasennaEmpleado` varchar(60) DEFAULT NULL,
  `idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `idDepartamento` (`idDepartamento`),
  CONSTRAINT `templeado_ibfk_1` FOREIGN KEY (`idDepartamento`) REFERENCES `tdepartamento` (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table sistemacompras.templeado: ~3 rows (approximately)
/*!40000 ALTER TABLE `templeado` DISABLE KEYS */;
INSERT INTO `templeado` (`idEmpleado`, `NombreEmpleado`, `RolEmpleado`, `ContrasennaEmpleado`, `idDepartamento`) VALUES
	(1, 'Hayleen Bonilla', 'X', '11', 1),
	(2, 'Danilo Calderon', 'X', '2', 2),
	(3, 'Daniel Arroyo', 'X', '3', 3);
/*!40000 ALTER TABLE `templeado` ENABLE KEYS */;

-- Dumping structure for table sistemacompras.ttramite
CREATE TABLE IF NOT EXISTS `ttramite` (
  `idTramite` int(11) NOT NULL AUTO_INCREMENT,
  `NombreTramite` varchar(50) NOT NULL DEFAULT '0',
  `DescripcionTramite` varchar(500) DEFAULT NULL,
  `ContenidoTramite` varchar(1024) DEFAULT NULL,
  `EstadoTramite` varchar(50) DEFAULT NULL,
  `FirmaDigitalTramite` varchar(250) DEFAULT NULL,
  `OrigenTramite` varchar(250) DEFAULT NULL,
  `DestinoTramite` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idTramite`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table sistemacompras.ttramite: ~0 rows (approximately)
/*!40000 ALTER TABLE `ttramite` DISABLE KEYS */;
INSERT INTO `ttramite` (`idTramite`, `NombreTramite`, `DescripcionTramite`, `ContenidoTramite`, `EstadoTramite`, `FirmaDigitalTramite`, `OrigenTramite`, `DestinoTramite`) VALUES
	(1, '0', 'Este tramite viene desde el main', 'eDnQyZApJnjVj+iyObWercYq1nlIAYFkEeK4MQO7EvveZ/STX6FILq4kKfEclGWCpOhWABZtQgAbVUYhmZUc0w==', NULL, 'Danilo', 'QA DEPARTMENT', 'Logistica');
/*!40000 ALTER TABLE `ttramite` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
