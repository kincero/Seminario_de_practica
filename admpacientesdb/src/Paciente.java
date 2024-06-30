/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

 import java.time.LocalDate;

 public class Paciente extends Persona {
    // Atributos
     private Plan plan;
 
     // constructor de la clase
     public Paciente(String nombre, String dni, LocalDate fechaNacimiento, String domicilio, String telefono, String email, String sexo, Localidad localidad, Plan plan) {
         super(nombre, dni, fechaNacimiento, domicilio, telefono, email, sexo, localidad);
         this.plan = plan;
     }
 
     // Getters y setters
     public Plan getPlan() {
         return plan;
     }
 
     public void setPlan(Plan plan) {
         this.plan = plan;
     }
 }
 