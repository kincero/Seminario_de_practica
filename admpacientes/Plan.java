package admpacientes;

/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

public class Plan {
    // Atributo
    private String nombre;

    // constructor de la clase
    public Plan(String nombre) {
        this.nombre = nombre;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
