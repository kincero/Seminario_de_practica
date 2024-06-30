/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

 public class Plan {
    // Atributos
    private int id;
    private String nombre;
    private String abreviatura;

    // constructor de la clase
    public Plan(int id, String nombre, String abreviatura) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public String toString() {
        return nombre + " (" + abreviatura + ")";
    }
}

