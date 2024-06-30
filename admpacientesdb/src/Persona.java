/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

import java.time.LocalDate;

 public class Persona {
    // Atributos
     private String nombre;
     private String dni;
     private LocalDate fechaNacimiento;
     private String domicilio;
     private String telefono;
     private String email;
     private String sexo;
     private Localidad localidad;
 
     // constructor de la clase
     public Persona(String nombre, String dni, LocalDate fechaNacimiento, String domicilio, String telefono, String email, String sexo, Localidad localidad) {
         this.nombre = nombre;
         this.dni = dni;
         this.fechaNacimiento = fechaNacimiento;
         this.domicilio = domicilio;
         this.telefono = telefono;
         this.email = email;
         this.sexo = sexo;
         this.localidad = localidad;
     }
 
     // Getters y setters
     public String getNombre() {
         return nombre;
     }
 
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
 
     public String getDni() {
         return dni;
     }
 
     public void setDni(String dni) {
         this.dni = dni;
     }
 
     public LocalDate getFechaNacimiento() {
         return fechaNacimiento;
     }
 
     public void setFechaNacimiento(LocalDate fechaNacimiento) {
         this.fechaNacimiento = fechaNacimiento;
     }
 
     public String getDomicilio() {
         return domicilio;
     }
 
     public void setDomicilio(String domicilio) {
         this.domicilio = domicilio;
     }
 
     public String getTelefono() {
         return telefono;
     }
 
     public void setTelefono(String telefono) {
         this.telefono = telefono;
     }
 
     public String getEmail() {
         return email;
     }
 
     public void setEmail(String email) {
         this.email = email;
     }
 
     public String getSexo() {
         return sexo;
     }
 
     public void setSexo(String sexo) {
         this.sexo = sexo;
     }
 
     public Localidad getLocalidad() {
         return localidad;
     }
 
     public void setLocalidad(Localidad localidad) {
         this.localidad = localidad;
     }
 }
 
