/**
 * MiClase.java
 */
public class MiClase {
    private String nombre;
    private int edad;

    /**
     * Constructor de MiClase
     */
    public MiClase() {
        this.nombre = "Juan";
        this.edad = 20;
    }

    /**
     * Set nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Set edad
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * toString de clase MiClase
     */
    @Override
    public String toString() {
        return "Valores de MiClase: " + this.nombre + ", " + this.edad;
    }
}
