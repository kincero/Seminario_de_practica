/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;
 import java.time.format.DateTimeParseException;
 import java.util.List;
 import java.util.Scanner;
 
 public class PacienteView {
 
    // menú del módulo pacientes
     public int mostrarMenu() {
         System.out.println("------------------------------------");
         System.out.println("Menú:");
         System.out.println("------------------------------------");
         System.out.println("1. Cargar paciente");
         System.out.println("2. Actualizar paciente");
         System.out.println("3. Eliminar paciente");
         System.out.println("4. Listar pacientes");
         System.out.println("5. Mostrar paciente");
         System.out.println("6. Listar pacientes ordenados por nombre");
         System.out.println("0. Salir");
         System.out.println("------------------------------------");
         System.out.print("Seleccione una opción: ");
         Scanner scanner = new Scanner(System.in);
         return scanner.nextInt();
     }
 
     // Cargar pacientes
     public Paciente cargarPaciente(List<Plan> planes, List<Localidad> localidades) {
         Scanner scanner = new Scanner(System.in);
         try {
             System.out.print("Ingrese nombre: ");
             String nombre = scanner.nextLine();
             System.out.print("Ingrese DNI: ");
             String dni = scanner.nextLine();
             System.out.print("Ingrese fecha de nacimiento (yyyy-MM-dd): ");
             LocalDate fechaNacimiento = null;
             while (fechaNacimiento == null) { // control de la fecha
                 String fechaStr = scanner.nextLine();
                 try {
                     fechaNacimiento = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);
                 } catch (DateTimeParseException e) {
                     System.out.print("Fecha inválida. Ingrese fecha de nacimiento (yyyy-MM-dd): ");
                 }
             }
             System.out.print("Ingrese domicilio: ");
             String domicilio = scanner.nextLine();
             System.out.print("Ingrese teléfono: ");
             String telefono = scanner.nextLine();
             System.out.print("Ingrese email: ");
             String email = scanner.nextLine();
             System.out.print("Ingrese sexo (Masculino/Femenino): ");
             String sexo = scanner.nextLine();
 
             // muestra una lista de localidades cargadas
             System.out.println("Seleccione una localidad:");
             for (int i = 0; i < localidades.size(); i++) {
                 System.out.println((i + 1) + ". " + localidades.get(i));
             }
             int indiceLocalidad = scanner.nextInt() - 1;
             scanner.nextLine(); // Nueva línea
 
             Localidad localidad = localidades.get(indiceLocalidad);
 
             // muestra una lista de planes cargados
             System.out.println("Seleccione un plan:");
             for (int i = 0; i < planes.size(); i++) {
                 System.out.println((i + 1) + ". " + planes.get(i));
             }
             int indicePlan = scanner.nextInt() - 1;
             scanner.nextLine(); // Nueva línea
 
             Plan plan = planes.get(indicePlan);
 
             return new Paciente(nombre, dni, fechaNacimiento, domicilio, telefono, email, sexo, localidad, plan);
         } catch (Exception e) {
             System.out.println("Error al cargar paciente: " + e.getMessage());
             return null;
         }
     }
 
     // pide el ingreso de un DNI para continuar con las acciones
     public String solicitarDni() {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Ingrese el DNI: ");
         return scanner.nextLine(); // Nueva línea
     }
 
     // muestra lista de pacientes
     public void mostrarPacientes(List<Paciente> pacientes) {
         if (pacientes.isEmpty()) {
             System.out.println("No hay pacientes cargados.");
         } else {
             System.out.printf("%-20s %-15s %-20s %-20s%n", 
                               "Nombre", "DNI", "Fecha de Nac", "Plan");
             for (Paciente paciente : pacientes) {
                 System.out.printf("%-20s %-15s %-20s %-20s%n", 
                                   paciente.getNombre(), paciente.getDni(), paciente.getFechaNacimiento(),  
                                   paciente.getPlan().getNombre());
             }
         }
     }
 
     // muestra los datos de un paciente
     public void mostrarPaciente(Paciente paciente) {
         if (paciente == null) {
             System.out.println("Paciente no encontrado.");
         } else {
             System.out.println("Datos del paciente:");
             System.out.println("Nombre: " + paciente.getNombre());
             System.out.println("DNI: " + paciente.getDni());
             System.out.println("Fecha de Nacimiento: " + paciente.getFechaNacimiento());
             System.out.println("Domicilio: " + paciente.getDomicilio());
             System.out.println("Teléfono: " + paciente.getTelefono());
             System.out.println("Email: " + paciente.getEmail());
             System.out.println("Sexo: " + paciente.getSexo());
             System.out.println("Localidad: " + paciente.getLocalidad().getNombre() + " (CP: " + paciente.getLocalidad().getCodPostal() + ")");
             System.out.println("Plan: " + paciente.getPlan().getNombre() + " (" + paciente.getPlan().getAbreviatura() + ")");
         }
     }
 }
 

