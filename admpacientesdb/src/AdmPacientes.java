/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

 public class AdmPacientes {
    public static void main(String[] args) {
        PacienteDAO pacienteDAO = new PacienteDAO(); // operaciones de la base de datos
        PacienteView pacienteView = new PacienteView(); // mostrar el menú e interactuar con el usuario
        // pacienteController gestionará la comunicación entre la vista y el modelo.
        PacienteController pacienteController = new PacienteController(pacienteDAO, pacienteView);

        pacienteController.iniciar();
    }
}