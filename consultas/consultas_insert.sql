INSERT INTO `admin_pacientes`.`convenio`
(`nombre`, `domicilio`, `cuit`)
VALUES
('Jerárquico Salud', 'Avda. Fdo. Zuviría 4584', '30686955180');

INSERT INTO `admin_pacientes`.`plan`
(`nombre`, `abreviatura`, `id_convenio`)
VALUES
('PMI2000', 'PMI2000', 1 );

INSERT INTO `admin_pacientes`.`localidad`
(`nombre`, `nod_Postal`)
VALUES
('Santa Fe', '3000');

INSERT INTO `admin_pacientes`.`paciente`
(`nombre`, `DNI`, `domicilio`, `telefono`, `email`, `fecha_nacimiento`, `sexo`, `id_plan`, `id_localidad`)
VALUES
('Marcos Scharfspitz', '24855283', 'Francia 3745', '3426310295', 'kincero@gmail.com', '1976-07-11', 'M', 1, 1);