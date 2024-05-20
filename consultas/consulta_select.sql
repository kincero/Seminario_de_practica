SELECT  pa.nombre AS Paciente,
		lo.nombre AS Localidad,
        pla.nombre AS Plan
FROM paciente pa,
	localidad lo,
    plan pla
WHERE pa.id_paciente = 1;