CREATE DATABASE SistemaCompras
	CHARACTER SET utf8
	COLLATE utf8_general_ci;

USE SistemaCompras

CREATE TABLE tDepartamento(
  idDepartamento INT NOT NULL AUTO_INCREMENT,	
  NombreDepartamento varchar (60),
  LlavePublica varchar (1024),
  PRIMARY KEY (idDepartamento)
  );

CREATE TABLE tTramite(
  idTramite INT NOT NULL AUTO_INCREMENT,
  FirmaDigitalTramite varchar (250),
  OrigenTramite varchar (250),
  DestinoTramite varchar (250),
  PRIMARY KEY (idTramite) 
  );

CREATE TABLE tEmpleado(
  idEmpleado INT NOT NULL AUTO_INCREMENT,
  NombreEmpleado varchar (60),
  RolEmpleado varchar (60),
  idDepartamento INT NOT NULL,
  FOREIGN KEY (idDepartamento) REFERENCES tDepartamento(idDepartamento),
  PRIMARY KEY (idEmpleado)
  );

INSERT INTO tDepartamento (NombreDepartamento)
    SELECT  'IT'
    UNION ALL 
    SELECT  'Finanzas'
    UNION ALL 
    SELECT  'Administracion'

INSERT INTO tEmpleado (NombreEmpleado, RolEmpleado, idDepartamento)
    SELECT  'Hayleen Bonilla', 'X', 1
    UNION ALL 
    SELECT  'Danilo Calderon', 'X', 2
    UNION ALL 
    SELECT  'Daniel Arroyo', 'X', 3
