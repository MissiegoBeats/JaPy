package pythonjavaintegration;

/**
 *
 * @author missi
 */
public class buscador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String idjava = "(JAVA)    ";
        BuscadorJsonEmpresas b = new BuscadorJsonEmpresas();
        System.out.println(idjava+"El correo obtenido es: "+b.obtenerCorreo("ABC Corporation", "Juan"));
        System.out.println(idjava+"El telefono obtenido es: "+b.obtenerTelefono("ABC Corporation"));
    }
}
