use P_is;

DROP TABLE IF EXISTS FUNCIONARIO_LAB;
DROP TABLE IF EXISTS EQUIPO_FALLA;
DROP TABLE IF EXISTS MANTENIMIENTO;
DROP TABLE IF EXISTS PERIFERICO;
DROP TABLE IF EXISTS EQUIPO;
DROP TABLE IF EXISTS LABSALA;
DROP TABLE IF EXISTS FUNCIONARIO;
DROP TABLE IF EXISTS ADMINISTRADOR;
DROP TABLE IF EXISTS FALLA;
DROP TABLE IF EXISTS EDIFICIO;
DROP TABLE IF EXISTS USUARIO;

CREATE TABLE USUARIO(
	Id_Usuario INT PRIMARY KEY NOT NULL,
    Username Varchar(13) NOT NULL,
    Pass Varchar(16) NOT NULL
);

CREATE TABLE EDIFICIO(
	Id_Edificio INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nom_Edificio Varchar(100) NOT NULL
);

CREATE TABLE FALLA(
	Id_Falla INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nom_Falla Varchar(30) NOT NULL,
    Desc_Falla Varchar(255)
);

CREATE TABLE ADMINISTRADOR(
	USUARIOId_Usuario INT PRIMARY KEY NOT NULL,
    FOREIGN KEY (USUARIOId_Usuario) REFERENCES USUARIO(Id_Usuario)
);

CREATE TABLE FUNCIONARIO(
	USUARIOId_Usuario INT PRIMARY KEY NOT NULL,
    ADMINUSUARIOId_Usuario INT,
    FOREIGN KEY (USUARIOId_Usuario) REFERENCES USUARIO(Id_Usuario),
    FOREIGN KEY (ADMINUSUARIOId_Usuario) REFERENCES ADMINISTRADOR(USUARIOId_Usuario)
);

CREATE TABLE LABSALA(
	Id_Lab INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Tipo VARCHAR(15) NOT NULL,
    Nombre_Lab Varchar(50) NOT NULL,
    Descripción_Lab Varchar(255),
    EDIFICIOId_Edificio INT NOT NULL,
    ADMINUSUARIOId_Usuario INT,
    FOREIGN KEY (EDIFICIOId_Edificio) REFERENCES EDIFICIO(Id_Edificio),
    FOREIGN KEY (ADMINUSUARIOId_Usuario) REFERENCES ADMINISTRADOR(USUARIOId_Usuario)
);

CREATE TABLE EQUIPO(
	Id_Equipo INT PRIMARY KEY NOT NULL,
    Nombre_Equipo Varchar(30) NOT NULL,
    Descripción_Equipo Varchar(255),
    LABId_Lab INT NOT NULL,
    FOREIGN KEY (LABId_Lab) REFERENCES LABSALA(Id_Lab)
);

CREATE TABLE PERIFERICO(
	Id_Periferico INT PRIMARY KEY NOT NULL,
    Tipo_Periférico Varchar(255),
    Marca Varchar(30),
    EQUIPOId_Equipo INT,
    FOREIGN KEY (EQUIPOId_Equipo) REFERENCES EQUIPO(Id_Equipo)
);

CREATE TABLE MANTENIMIENTO(
	Id_Mantenimiento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Fecha_Mantenimiento DATETIME NOT NULL,
    Nombre_Mantenimiento VARCHAR(30),
    Descripción_Mantenimiento VARCHAR(255),
    EQUIPOId_Equipo INT,
    PERIFERICOId_Periferico INT,
    FOREIGN KEY (EQUIPOId_Equipo) REFERENCES EQUIPO(Id_Equipo),
    FOREIGN KEY (PERIFERICOId_Periferico) REFERENCES PERIFERICO(Id_Periferico)
);

CREATE TABLE EQUIPO_FALLA(
	Id_Equipo_Falla INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	FECHA_HORA_FALLA DATETIME NOT NULL,
	FALLAId_Falla INT NOT NULL,
	EQUIPOId_Equipo INT NOT NULL,
    FOREIGN KEY (FALLAId_Falla) REFERENCES FALLA(Id_Falla),
    FOREIGN KEY (EQUIPOId_Equipo) REFERENCES EQUIPO(Id_Equipo)
);

CREATE TABLE FUNCIONARIO_LAB(
	Id_Funcionario_Lab INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	LABId_Lab INT NOT NULL,
	FUNCIONARIOUSUARIOId_Usuario INT NOT NULL,
    FOREIGN KEY (LABId_Lab) REFERENCES LABSALA(Id_Lab),
    FOREIGN KEY (FUNCIONARIOUSUARIOId_Usuario) REFERENCES FUNCIONARIO(USUARIOId_Usuario)
);


INSERT into EDIFICIO VALUES(454, "Edificio de Ciencia y Tecnologia Luis Carlos Sarmiento Angulo");
INSERT into EDIFICIO VALUES(453, "Aulas de Ingenieria");
INSERT into EDIFICIO VALUES(412, "Laboratorios de ingenireia quimica");
INSERT into EDIFICIO VALUES(408, "Postgrados en Materiales y Procesos de Manufactura");
INSERT into EDIFICIO VALUES(407, "Laboratorio de Hidráulica - Hangar y CADE Ingeniería");
INSERT into EDIFICIO VALUES(409, "Laboratorio de Hidráulica");
INSERT into EDIFICIO VALUES(411, "Laboratorios de Ingeniería");
INSERT into EDIFICIO VALUES(401, "Facultad de Ingenieria");