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
	(1, 'Administracion', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbJLf3ZhZ7U5gHKB2gMGwB00yCFAaeKl6Tg8ADof9G4sdr4glzTj6mMImp7i7ith1b8CwtCI5Wl2s1e4mJxguojQ5OZMg/m9CRHoCcwX72Me2+gg7o6rP+w8TKFH3VNsOUQF8LwCbxBgrZIa11H4ZoKOp9z0wFt6ghF+GOC1Pz8wIDAQAB', 'MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJskt/dmFntTmAcoHaAwbAHTTIIUBp4qXpODwAOh/0bix2viCXNOPqYwianuLuK2HVvwLC0IjlaXazV7iYnGC6iNDk5kyD+b0JEegJzBfvYx7b6CDujqs/7DxMoUfdU2w5RAXwvAJvEGCtkhrXUfhmgo6n3PTAW3qCEX4Y4LU/PzAgMBAAECgYAanhYiEBXTWug+cheDIEunlIUP3De2czZ+wJ/0/5o4ozfrvoA4lDgTc0hrKz5ID07CM1ag81LYcGooZuWWCbB+Gdb2R4aWd8vNLSaF40n7dKn7kuPNGmI73ew+ah1+OV5ssBEUzbkO3daFS5FMwPqU0tN1i8t6DpItPnrhDGoeAQJBANzKIp9DBfhs/8znAj2CY6LC4R6z/5Jv5ohp8szKCYoLM4+isiql342e6OmxikRlA+5rrprKa9BJ2/Ds3M7l9DMCQQCz4opWZPDRgpnEQ9Y3fXdcIpJqvv+bfchEpDx/QfMLDgdLD3pOPpK5mMPR1akNDWfuK+0vM2uX263HDjPwUEFBAkEAre2CRqm6y0+6VwToC+JqcO5J/zDWtNn35iBoR5Ek4J0gWhdVeSlAKUU0v9u/S0+0QB6N5pxtQCDe5TUCYO5fZwJBAJhyADK/UKb9OzrtEnnsRl86nUMBorUvn60sUmi2hzZzKRMfhtMQjF/lau5FWALLvaxGZbd+qEwFy/vJuZKLMQECQHEX35UDq8miaHv4uBQaZaZ5BsyT9wPa4oKbYi4ekq9rQKF6aLjSAwG5RRqtgvk2289po2ay4MLwRdVafMdYgCU='),
	(2, 'Finanzas', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKPxxDufKplf/+czbuEChf3XOwQSQ4O/r9z2IuNdpIAuoftzkyQocSi3OLVl+TdzkVpt0Lwm2qDAyq091DEpL0ZDOuRqbW/gVMyi3vuA924gtVaNATbFpGd9EGpLQ26CmyEZ8zKyOqL5Ax1X3+C+EA4NBzZ3mjO7zXC7Y5fwVpVwIDAQAB', 'MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIo/HEO58qmV//5zNu4QKF/dc7BBJDg7+v3PYi412kgC6h+3OTJChxKLc4tWX5N3ORWm3QvCbaoMDKrT3UMSkvRkM65Gptb+BUzKLe+4D3biC1Vo0BNsWkZ30QaktDboKbIRnzMrI6ovkDHVff4L4QDg0HNneaM7vNcLtjl/BWlXAgMBAAECgYBsj3KanIK6OVh1b/RKrdWGslgOqJjQsAlBFoF62D85HVDM5wy7MxLutSNe38zd+FmTbx1WBrAnQJ8R5p1x9jv/DLf5pwzm0kFf3A/DSob5O4p7TwBBGvkjZNcxVzIN+sEEZ3wXR2ezGeUvnNz28VlBBiJKISatcrg9tOGXmq1QgQJBAPRGI3ucErFj60ipI9vLfmzm0t9GqMpGeSZASTaSCNK4+qHq33tA6p2MtlXWvq7Oe9s+gz4vjslkE8XTeDVQdY8CQQCQ4gKAMfmrGi/5YfB10olgtZuFYWHm6UT93THgucXB9K4pYm9ySdgdpvO1ZLEQ0xMr/tC+/lFJNdxReDO3b7u5AkAps1+TVo2KYvhjqxxIBXFLvgv5ueJOxcEg2pClFEEVWCbRRXtpWyeyRbdK6CIdTXqvbviQwSWrE76cYwF+eIHZAkARmgOnw2qLqQDPEWD/T3a1MxsT10LnpMtm9CqNHMSzzaAjEvxrLCF/aLsO/I6udpZLsAd4TLlfZZXAqBPQY1ixAkAjmvbrpC0/75kft/gdUJNNmmuiz4asJVHgnyVMFexwWuKjzLXZRaoy73uEPHB0RM0qzE7D5EuRKa8Oan0CwPQQ'),
	(3, 'IT', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiw/7f2FwpOF8G+6gnFB8IYIerKO/sQovaW8Kg0UnHQvNIE+3vN91bkxekQNv+0WoaPxRqXgh4mGB3ur+lfYJ9Pnc8dEN2BgN3uypXoBy8pqnYS3OdnK72HnY0zXtduvTqGSuOnIAo/r8xHqvBX2z3VVVQbrVUiHPpEz39VHZeqQIDAQAB', 'MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKLD/t/YXCk4Xwb7qCcUHwhgh6so7+xCi9pbwqDRScdC80gT7e833VuTF6RA2/7Raho/FGpeCHiYYHe6v6V9gn0+dzx0Q3YGA3e7KlegHLymqdhLc52crvYedjTNe1269OoZK46cgCj+vzEeq8FfbPdVVVButVSIc+kTPf1Udl6pAgMBAAECgYEAnBmGph21fZ7fnC3cfeYRQRJ66s8vEpJb2EZqqZsuu9jcw4LBjcwxEnNGmDPQCVnD/XoD1WNrkmTpF8rVpBxz+KiCjnGb/xytFdgeTT81rjEJZ7xKRgD8Xrq+Hh8rmhFsWsS6t3BOA2Cxh36N2O0ePScazNcr6EzyHZLCcEnyOKUCQQDqu/p0cksaEDxkx9QMxv+aoHCKpGMNuUEH9586gbQs2B4StJnOnp93bE7rAqJtkqhhIl3yIZe2ueEuVkMGD1JXAkEAsYLmY4fE85UFcmHKo5pOQz9yXEip9kL8SItHxUUMZgMajmxh0FTDeOS9qqwTb0FsYDYCpPIR/5dLUayrS7M2/wJBAMvQPD8vnhYbUtUOzQfrIbTY6d73rSoVWGnaj971D8SAQlxrg8Dr6fp/iGZ1+yK43Iq6lGfQ0zJNY0AglkGEvDECQQCH315iCOZkXEjTCK+HEvGc38+1e5k8+oEJNjM1eGjJHM8S/TrRsE//FXdoUFZ/7l/6NN1JTFEihrgMSFLFmuQZAkBIcKiZ0PAO9aCwBBR+y/05S8d4ngVZrPURPoq+At76P1ztg4fdI3d0uY42+7wIoxPIQ0urYy6kVKCGWpyBgCdS'),
	(4, 'Otros', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTtuo4zv/JBVdNPu0YOG8nDLHaAh1ACoxslqUD76GOkjPA4QDvgdo6Kk6CcghBqzntAlM4qBjbMaMO1TuJqmSNK6d8z+baS8qBITgyRR90Vwv/kdF0QX3W/IDQ4HdKUXSJnHxkGgmvbonZ399RE8AueNsdVTCOCkfZgsMJmc7drwIDAQAB', 'MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJO26jjO/8kFV00+7Rg4bycMsdoCHUAKjGyWpQPvoY6SM8DhAO+B2joqToJyCEGrOe0CUzioGNsxow7VO4mqZI0rp3zP5tpLyoEhODJFH3RXC/+R0XRBfdb8gNDgd0pRdImcfGQaCa9uidnf31ETwC542x1VMI4KR9mCwwmZzt2vAgMBAAECgYAQpbq78EhPhXSTVhYudp3ATuP0Z+yX/RhaXJf4W5dflAaVJEaQt5e6mm4CsYtQq1V56psqdXdnrK5ty4ZMO5HdUudTmUkbkR5GgX0jzd07sksxW94DcPtjTrNMPodqZnmN328AhK1nVLYezx+5cjMS3EU9ghMtxrGvrVu3vfv0AQJBAN4xNVKWK5HG/R90Lp944JDDhyDZoxqvMT7eLkn4eP5Bd0xWJTcFj2y0Vd9Z+wFtO1kXUALDBzXFk6rr2vXc5K8CQQCqMKoKtEQsZdMty984Fq726kazrQtYnqrvzV995gDh7oBtycYkUY449nWcDqPaBJS7hi8WX2P3ZUi356RtDdcBAkEAkEWvc/KiU8O7dAMCivX4CseLJF9sstTyyvmFYO5/0cg8aEq/W1y25kSqRZ6thx2gHZcvkruEIPwriB4hTOejbQJBAKHtSWyD1bV0cHhLWKgSFQjDIOAFjh0UYkllWyz7cO2GMlXDPC4EFtCl1oLT/xwJbcX6RsT/n6qciJLJ6E0GdQECQQCdx5lIK6vJ4nn24+QScf4ODasrAvPsUi74ZvXS6thmIslJBgvlghRlr7Eme7tf7vcweZ9g2mypu6thUfOLA7VX');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sistemacompras.templeado: ~4 rows (approximately)
/*!40000 ALTER TABLE `templeado` DISABLE KEYS */;
INSERT INTO `templeado` (`idEmpleado`, `NombreEmpleado`, `RolEmpleado`, `ContrasennaEmpleado`, `idDepartamento`) VALUES
	(1, 'Hayleen Bonilla', 'X', '11', 1),
	(2, 'Danilo Calderon', 'X', '2', 2),
	(3, 'Daniel Arroyo', 'X', '3', 3),
	(4, 'Mauricio Montero', 'X', '4', 4);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table sistemacompras.ttramite: ~2 rows (approximately)
/*!40000 ALTER TABLE `ttramite` DISABLE KEYS */;
INSERT INTO `ttramite` (`idTramite`, `NombreTramite`, `DescripcionTramite`, `ContenidoTramite`, `EstadoTramite`, `FirmaDigitalTramite`, `OrigenTramite`, `DestinoTramite`) VALUES
	(1, 'Test', 'Test', 'Ncz6hXeLWKCNHuop9NDU+CLWs053Dpbbrkk++UBwrZrIXPAO0CKZQLAJUJfqxfpO2BSleKocuXnnaGqILye6Vw==', NULL, 'Test', 'Otros', 'Administracion'),
	(2, 'Test', 'Test', 'WWieJ97T17H9dI/6/PPe6dqmHuxTU56B0z5sYvBA1uTYb2q/3U73+iAxhDqLnSj0yK7p6y9ehoUlL5LB1jB2yg==', NULL, 'Test', 'Otros', 'Administracion');
/*!40000 ALTER TABLE `ttramite` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
