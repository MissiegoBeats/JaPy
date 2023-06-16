package pythonjavaintegration.executables;

import pythonjavaintegration.classes.BuscadorJsonEmpresas;

/**
 * buscador
 * @author Andrés Missiego
 */
public class buscador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String idjava = "(JAVA)    "; //Java identifier
        BuscadorJsonEmpresas b = new BuscadorJsonEmpresas();
        //ES: llamando a distintas funciones que a su vez llaman a funciones en python
        //EN: calling some functions that call python functions
        System.out.println(idjava+"El correo obtenido es: "+b.obtenerCorreo("ABC Corporation", "Juan"));
        System.out.println(idjava+"El telefono obtenido es: "+b.obtenerTelefono("ABC Corporation"));
        System.out.println(idjava+"La direccion obtenida es: "+b.obtenerDireccion("Global Solutions"));
        System.out.println(idjava+"Modificando direccion de Global Solutions a Madrid");
        b.modificarDireccion("Global Solutions","Madrid");
        System.out.println(idjava+"Direccion modificada, consulta el json"); //src/pythonjavaintegration/json/empresas.json 
    }
}
