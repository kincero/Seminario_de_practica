/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

import java.util.Comparator;
import java.util.List;

public class PacienteController {
    // Atributos
    private PacienteDAO pacienteDAO;
    private PacienteView pacienteView;
    private List<Plan> planes;
    private List<Localidad> localidades;

    // constructor de la clase
    public PacienteController(PacienteDAO pacienteDAO, PacienteView pacienteView) {
        this.pacienteDAO = pacienteDAO;
        this.pacienteView = pacienteView;
        this.planes = pacienteDAO.obtenerPlanes();
        this.localidades = pacienteDAO.obtenerLocalidades();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = pacienteView.mostrarMenu();
            switch (opcion) {
                case 1: // Cargar paciente
                    Paciente nuevoPaciente = pacienteView.cargarPaciente(planes, localidades);
                    if (nuevoPaciente != null) {
                        pacienteDAO.guardarPaciente(nuevoPaciente);
                        System.out.println("Paciente cargado exitosamente.");
                    }
                    break;
                case 2: // actualizar paciente
                    String dniActualizar = pacienteView.solicitarDni();
                    Paciente pacienteActualizar = pacienteDAO.buscarPacientePorDni(dniActualizar);
                    if (pacienteActualizar != null) {
                        Paciente pacienteActualizado = pacienteView.cargarPaciente(planes, localidades);
                        if (pacienteActualizado != null) {
                            pacienteActualizado.setDni(dniActualizar); // Mantener el mismo DNI
                            pacienteDAO.actualizarPaciente(pacienteActualizado);
                            System.out.println("Paciente actualizado exitosamente.");
                        }
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 3: // Eliminar paciente
                    String dniEliminar = pacienteView.solicitarDni();
                    pacienteDAO.eliminarPaciente(dniEliminar);
                    System.out.println("Paciente eliminado exitosamente.");
                    break;
                case 4: // Listar pacientes
                    List<Paciente> pacientes = pacienteDAO.listarPacientes();
                    pacienteView.mostrarPacientes(pacientes);
                    break;
                case 5: // mostrar paciente
                    String dniMostrar = pacienteView.solicitarDni();
                    Paciente pacienteMostrar = pacienteDAO.buscarPacientePorDni(dniMostrar);
                    pacienteView.mostrarPaciente(pacienteMostrar);
                    break;
                case 6: // listar pacientes ordenados
                    List<Paciente> pacientesOrdenados = pacienteDAO.listarPacientes();
                    pacientesOrdenados.sort(Comparator.comparing(Paciente::getNombre));
                    pacienteView.mostrarPacientes(pacientesOrdenados);
                    break;
                case 0: // salir del sistema
                    System.out.println("Saliendo, Que tenga un buen día!!");
                    break;
                default: // opcion por defecto
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0); // mientras opcion sea diferente de cero hace
    }
}
