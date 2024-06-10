package admpacientes;

/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

import java.util.Date;

public class Persona {
    // Atributos
    private String nombre;
    private String dni;
    private Date fechaNacimiento;
    private String domicilio;
    private String telefono;
    private String email;
    private String sexo;
    private Localidad localidad;

    // Constructor de la clase
    public Persona(String nombre, String dni, Date fechaNacimiento, String domicilio, String telefono, String email, String sexo, Localidad localidad) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.sexo = sexo;
        this.localidad = localidad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
