package admpacientes;

/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// Clase principal
public class AdmPacientes {
    
    // Declaración de listas para almacenar datos
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Plan> planes = new ArrayList<>();
    private List<Localidad> localidades = new ArrayList<>();
    
    public static void main(String[] args) {
       AdmPacientes adm = new AdmPacientes();
        adm.inicializarDatos(); // Inicializar datos de planes y localidades
        adm.mostrarMenu(); // Mostrar el menú principal
    }

    public void inicializarDatos() {
        // Inicializar planes
        planes.add(new Plan("IAPOS"));
        planes.add(new Plan("PMI"));
        planes.add(new Plan("PMI2000"));
        planes.add(new Plan("PMI3000"));

        // Inicializar localidades
        localidades.add(new Localidad("Santa Fe", "3000"));
        localidades.add(new Localidad("Rosario", "2000"));
        localidades.add(new Localidad("Rincon", "3001"));
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("------------------------------------");
            System.out.println("Menú de Administración de Pacientes:");
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
            opcion = scanner.nextInt();
            scanner.nextLine(); // Nueva línea
            System.out.println("------------------------------------");

            switch (opcion) {
                case 1:
                    cargarPaciente(scanner); // Cargar paciente
                    break;
                case 2:
                    actualizarPaciente(scanner); // Actualizar paciente
                    break;
                case 3:
                    eliminarPaciente(scanner); // Eliminar paciente
                    break;
                case 4:
                    listarPacientes(); // Listar todos los pacientes
                    break;
                case 5:
                    mostrarPaciente(scanner); // Mostrar un paciente por DNI
                    break;
                case 6:
                    listarPacientesOrdenados(); // Listar pacientes ordenados por nombre
                    break;
                case 0:
                    System.out.println("Saliendo, Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    private void cargarPaciente(Scanner scanner) {
        try {
            System.out.print("Apellido Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("DNI: ");
            String dni = scanner.nextLine();
            System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
            Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
            System.out.print("Domicilio: ");
            String domicilio = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
            // Selector para el sexo
            System.out.println("Sexo:");
            System.out.println("1. Masculino");
            System.out.println("2. Femenino");
            System.out.print("Seleccione una opción: ");
            String sexo = scanner.nextInt() == 1 ? "Masculino" : "Femenino";
            scanner.nextLine(); // Nueva línea
            
            // Selector para localidades
            System.out.println("Seleccione una localidad:");
            for (int i = 0; i < localidades.size(); i++) {
                System.out.println((i + 1) + ". " + localidades.get(i));
            }
            int indiceLocalidad = scanner.nextInt() - 1;
            scanner.nextLine(); // Nueva línea

            Localidad localidad = localidades.get(indiceLocalidad);

            // Selector para el plan
            System.out.println("Seleccione un plan:");
            for (int i = 0; i < planes.size(); i++) {
                System.out.println((i + 1) + ". " + planes.get(i));
            }
            int indicePlan = scanner.nextInt() - 1;
            scanner.nextLine(); // Nueva línea

            Plan plan = planes.get(indicePlan);

            // Crear y agregar el nuevo paciente a la lista
            Paciente paciente = new Paciente(nombre, dni, fechaNacimiento, domicilio, telefono, email, sexo, localidad, plan);
            pacientes.add(paciente);
            System.out.println("Paciente cargado exitosamente.");
        } catch (ParseException | IndexOutOfBoundsException e) {
            System.out.println("Error al cargar el paciente: " + e.getMessage());
        }
    }

    private void actualizarPaciente(Scanner scanner) {
        System.out.print("Ingrese el DNI del paciente a actualizar: ");
        String dni = scanner.nextLine();

        Paciente paciente = buscarPacientePorDni(dni);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        try {
            // Actualizar los datos del paciente
            System.out.print("Nuevo nombre (actual: " + paciente.getNombre() + "): ");
            String nombre = scanner.nextLine();
            System.out.print("Nueva fecha de nacimiento (dd/MM/yyyy, actual: " + paciente.getFechaNacimiento() + "): ");
            Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
            System.out.print("Nuevo domicilio (actual: " + paciente.getDomicilio() + "): ");
            String domicilio = scanner.nextLine();
            System.out.print("Nuevo teléfono (actual: " + paciente.getTelefono() + "): ");
            String telefono = scanner.nextLine();
            System.out.print("Nuevo email (actual: " + paciente.getEmail() + "): ");
            String email = scanner.nextLine();

            // Selector para el sexo
            System.out.println("Sexo:");
            System.out.println("1. Masculino");
            System.out.println("2. Femenino");
            System.out.print("Seleccione una opción: ");
            String sexo = scanner.nextInt() == 1 ? "Masculino" : "Femenino";
            scanner.nextLine(); // Nueva línea

            // Selector para la localidad
            System.out.println("Seleccione una nueva localidad:");
            for (int i = 0; i < localidades.size(); i++) {
                System.out.println((i + 1) + ". " + localidades.get(i));
            }
            int indiceLocalidad = scanner.nextInt() - 1;
            scanner.nextLine(); // Nueva línea

            Localidad localidad = localidades.get(indiceLocalidad);

            // Selector para el plan
            System.out.println("Seleccione un nuevo plan:");
            for (int i = 0; i < planes.size(); i++) {
                System.out.println((i + 1) + ". " + planes.get(i));
            }
            int indicePlan = scanner.nextInt() - 1;
            scanner.nextLine(); // Nueva línea

            Plan plan = planes.get(indicePlan);

            // Establecer los nuevos valores al paciente
            paciente.setNombre(nombre);
            paciente.setFechaNacimiento(fechaNacimiento);
            paciente.setDomicilio(domicilio);
            paciente.setTelefono(telefono);
            paciente.setEmail(email);
            paciente.setSexo(sexo);
            paciente.setLocalidad(localidad);
            paciente.setPlan(plan);

            System.out.println("Paciente actualizado exitosamente.");
        } catch (ParseException | IndexOutOfBoundsException e) {
            System.out.println("Error al actualizar el paciente: " + e.getMessage());
        }
    }

    private void eliminarPaciente(Scanner scanner) {
        System.out.print("Ingrese el DNI del paciente a eliminar: ");
        String dni = scanner.nextLine();

        Paciente paciente = buscarPacientePorDni(dni);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        // Eliminar el paciente de la lista
        pacientes.remove(paciente);
        System.out.println("Paciente eliminado exitosamente.");
    }

    private void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes cargados.");
            return;
        }

        // Listar todos los pacientes
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getNombre() + " - " + paciente.getDni() + " - " + paciente.getPlan().getNombre());
        }
    }

    private void mostrarPaciente(Scanner scanner) {
        System.out.print("Ingrese el DNI del paciente a mostrar: ");
        String dni = scanner.nextLine();

        Paciente paciente = buscarPacientePorDni(dni);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        // Mostrar detalles del paciente
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("DNI: " + paciente.getDni());
        System.out.println("Fecha de nacimiento: " + paciente.getFechaNacimiento());
        System.out.println("Domicilio: " + paciente.getDomicilio());
        System.out.println("Teléfono: " + paciente.getTelefono());
        System.out.println("Email: " + paciente.getEmail());
        System.out.println("Sexo: " + paciente.getSexo());
        System.out.println("Localidad: " + paciente.getLocalidad());
        System.out.println("Plan: " + paciente.getPlan().getNombre());
    }

    private void listarPacientesOrdenados() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes cargados.");
            return;
        }

        // Ordenar la lista de pacientes por nombre
        pacientes.sort(Comparator.comparing(Paciente::getNombre));
        listarPacientes(); // Listar pacientes ordenados
    }

    private Paciente buscarPacientePorDni(String dni) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                return paciente;
            }
        }
        return null;
        
    }
    
}
