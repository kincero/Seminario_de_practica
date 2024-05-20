DELETE FROM `admin_pacientes`.`paciente` WHERE id_paciente = 1;
DELETE FROM `admin_pacientes`.`plan` WHERE id_plan = 1;
DELETE FROM `admin_pacientes`.`localidad` WHERE id_localidad = 1; 
DELETE FROM `admin_pacientes`.`convenio` WHERE id_convenio = 1;

SELECT * FROM `admin_pacientes`.`paciente`;
SELECT * FROM `admin_pacientes`.`plan`;
SELECT * FROM `admin_pacientes`.`localidad`;
SELECT * FROM `admin_pacientes`.`convenio`;