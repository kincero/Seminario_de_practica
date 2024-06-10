package admpacientes;

/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

import java.util.Date;

public class Paciente extends Persona{
    // Atributo
    private Plan plan;

    // constructor de la clase
    public Paciente(String nombre, String dni, Date fechaNacimiento, String domicilio, String telefono, String email, String sexo, Localidad localidad, Plan plan) {
        super(nombre, dni, fechaNacimiento, domicilio, telefono, email, sexo, localidad);
        this.plan = plan;
    }

    // Getters
    public Plan getPlan() {
        return plan;
    }

    // Setters
    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
