package admpacientes;

/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    
    // Método para cargar un nuevo paciente
    public static Paciente cargarPaciente(Scanner scanner, List<Plan> planes, List<Localidad> localidades) {
        try {
            System.out.print("Nombre: ");
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

            // Crear y devolver el nuevo paciente
            return new Paciente(nombre, dni, fechaNacimiento, domicilio, telefono, email, sexo, localidad, plan);
        } catch (ParseException | IndexOutOfBoundsException e) {
            System.out.println("Error al cargar el paciente: " + e.getMessage());
            return null;
        }
    }

    // Método para actualizar un paciente
    public void actualizarPaciente(Scanner scanner, List<Plan> planes, List<Localidad> localidades) {
        try {
            System.out.print("Nuevo nombre (actual: " + getNombre() + "): ");
            String nombre = scanner.nextLine();
            System.out.print("Nueva fecha de nacimiento (dd/MM/yyyy, actual: " + getFechaNacimiento() + "): ");
            Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
            System.out.print("Nuevo domicilio (actual: " + getDomicilio() + "): ");
            String domicilio = scanner.nextLine();
            System.out.print("Nuevo teléfono (actual: " + getTelefono() + "): ");
            String telefono = scanner.nextLine();
            System.out.print("Nuevo email (actual: " + getEmail() + "): ");
            String email = scanner.nextLine();

            // Selector para el sexo
            System.out.println("Sexo:");
            System.out.println("1. Masculino");
            System.out.println("2. Femenino");
            System.out.print("Seleccione una opción: ");
            String sexo = scanner.nextInt() == 1 ? "Masculino" : "Femenino";
            scanner.nextLine(); // Nueva línea

            // Selector para localidades
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

            // Actualizar el paciente con los nuevos datos
            setNombre(nombre);
            setFechaNacimiento(fechaNacimiento);
            setDomicilio(domicilio);
            setTelefono(telefono);
            setEmail(email);
            setSexo(sexo);
            setLocalidad(localidad);
            setPlan(plan);

            System.out.println("Paciente actualizado exitosamente.");
        } catch (ParseException | IndexOutOfBoundsException e) {
            System.out.println("Error al actualizar el paciente: " + e.getMessage());
        }
    }

    // Método para eliminar un paciente de la lista
    public static void eliminarPaciente(List<Paciente> pacientes, Scanner scanner) {
        System.out.print("Ingrese el DNI del paciente a eliminar: ");
        String dni = scanner.nextLine();

        Paciente paciente = buscarPacientePorDni(pacientes, dni);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        // Eliminar el paciente de la lista
        pacientes.remove(paciente);
        System.out.println("Paciente eliminado exitosamente.");
    }

    // Método para listar todos los pacientes
    public static void listarPacientes(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes cargados.");
            return;
        }

        // Listar todos los pacientes
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getNombre() + " - " + paciente.getDni() + " - " + paciente.getPlan().getNombre());
        }
    }

    // Método para mostrar los detalles de un paciente
    public static void mostrarPaciente(List<Paciente> pacientes, Scanner scanner) {
        System.out.print("Ingrese el DNI del paciente a mostrar: ");
        String dni = scanner.nextLine();

        Paciente paciente = buscarPacientePorDni(pacientes, dni);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        // Mostrar los detalles del paciente
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

    // Método para listar pacientes ordenados por nombre
    public static void listarPacientesOrdenados(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes cargados.");
            return;
        }

        // Ordenar la lista de pacientes por nombre
        pacientes.sort(Comparator.comparing(Paciente::getNombre));
        listarPacientes(pacientes); // Listar pacientes ordenados
    }

    // Método para buscar un paciente por DNI
    public static Paciente buscarPacientePorDni(List<Paciente> pacientes, String dni) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                return paciente;
            }
        }
        return null;
    }
    
}
