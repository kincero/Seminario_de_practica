package admpacientes;

/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

public class Localidad {
    // Atributos
    private String nombre;
    private String codPostal;

    // constructor de la clase
    public Localidad(String nombre, String codPostal) {
        this.nombre = nombre;
        this.codPostal = codPostal;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getCodPostal() {
        return codPostal;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    @Override
    public String toString() {
        return nombre + " (CP: " + codPostal + ")";
    }
}
