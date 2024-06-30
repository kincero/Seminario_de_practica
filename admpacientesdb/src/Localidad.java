/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

 public class Localidad {
    // Atributos
    private int id;
    private String nombre;
    private String codPostal;

    // constructor de la clase
    public Localidad(int id, String nombre, String codPostal) {
        this.id = id;
        this.nombre = nombre;
        this.codPostal = codPostal;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    @Override
    public String toString() {
        return nombre + " (CP: " + codPostal + ")";
    }
}

