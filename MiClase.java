public class MiClase {
    private String nombre;
    private int edad;

    public MiClase() {
        this.nombre = "Juan";
        this.edad = 20;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Valores de MiClase: " + this.nombre + ", " + this.edad;
    }
}
