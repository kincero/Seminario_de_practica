CREATE TABLE CONVENIO (
    id_convenio INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    domicilio VARCHAR(60) NOT NULL,
    cuit VARCHAR(25) NOT NULL,
    flg_baja TINYINT NOT NULL DEFAULT '0',
    PRIMARY KEY (id_convenio)
);

CREATE TABLE PLAN (
    id_plan INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    abreviatura VARCHAR(60) NOT NULL,
    id_convenio INT NOT NULL,
    flg_baja TINYINT NOT NULL DEFAULT '0',
    PRIMARY KEY (id_plan),
    FOREIGN KEY (id_convenio) REFERENCES CONVENIO(id_convenio)
);

CREATE TABLE LOCALIDAD (
    id_localidad INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    nod_Postal VARCHAR(60) NOT NULL,
    flg_baja TINYINT NOT NULL DEFAULT '0',
    PRIMARY KEY (id_localidad)
);

CREATE TABLE PACIENTE (
    id_paciente INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    DNI VARCHAR(20) NOT NULL,
    domicilio VARCHAR(60) NOT NULL,
    telefono VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    fecha_nacimiento DATE DEFAULT NULL,
    sexo VARCHAR(20) NOT NULL,
    id_plan INT NOT NULL,
    id_localidad INT NOT NULL,
    flg_baja TINYINT NOT NULL DEFAULT '0',
    PRIMARY KEY (id_paciente),
    FOREIGN KEY (id_plan) REFERENCES PLAN(id_plan),
    FOREIGN KEY (id_localidad) REFERENCES LOCALIDAD(id_localidad)
);