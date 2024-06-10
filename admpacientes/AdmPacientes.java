package admpacientes;

/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

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
                    Paciente nuevoPaciente = Paciente.cargarPaciente(scanner, planes, localidades);
                    if (nuevoPaciente != null) {
                        pacientes.add(nuevoPaciente);
                        System.out.println("Paciente cargado exitosamente.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el DNI del paciente a actualizar: ");
                    String dniActualizar = scanner.nextLine();
                    Paciente pacienteActualizar = Paciente.buscarPacientePorDni(pacientes, dniActualizar);
                    if (pacienteActualizar != null) {
                        pacienteActualizar.actualizarPaciente(scanner, planes, localidades);
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 3:
                    Paciente.eliminarPaciente(pacientes, scanner);
                    break;
                case 4:
                    Paciente.listarPacientes(pacientes);
                    break;
                case 5:
                    Paciente.mostrarPaciente(pacientes, scanner);
                    break;
                case 6:
                    Paciente.listarPacientesOrdenados(pacientes);
                    break;
                case 0:
                    System.out.println("Saliendo, Que tenga un buen día!!");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }
}
