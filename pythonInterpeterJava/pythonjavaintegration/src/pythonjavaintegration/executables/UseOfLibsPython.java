package pythonjavaintegration.executables;

//Imports
import java.io.IOException;
import org.python.util.PythonInterpreter;
import pythonjavaintegration.classes.Rutas;

/**
 * ES: Clase para probar el uso de librerías de python con jython (no funciona porque jython usa python 2.7)
 * EN: Class to test the use of python libraries with jython (not working because jython uses python 2.7)
 * @author Andrés Missiego
 */
public class UseOfLibsPython {
    
    /**
     * ES: Método main
     * EN: Main method
     * @param args String[] the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println("Instalando Pandas");
        //installPandas();
        Rutas rutas = new Rutas();
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(rutas.useoflibs); //not working because jython uses python 2.7 
    }//End main
    
    /**
     * ES: Ejemplo de instalacion de una librería Python (en este caso pandas)
     * EN: Example of installing a python library (in this case pandas)
     */
    private static void installPandas(){
        try {
            //ES: Crear el comando pip install pandas
            //EN: Create the command pip install pandas
            String[] command = {"pip", "install", "pandas"};

            //ES: Crear el proceso y configurarlo
            //EN: Create the process and configure it
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);

            //ES: Ejecutar el proceso
            //EN: Execute the process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso
            //EN: Read the process output
            java.io.InputStream inputStream = process.getInputStream();
            java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
            String output = scanner.hasNext() ? scanner.next() : "";

            //ES: Esperar a que el proceso termine
            //EN: Wait for the process to finish
            int exitCode = process.waitFor();

            //ES: Mostrar la salida del proceso
            //EN: Show the process output
            System.out.println(output);

            if (exitCode == 0) {
                System.out.println("¡Instalación exitosa!");
            } else {
                System.out.println("¡Error durante la instalación!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }//End installPandas
    
}//End UseOfLibsPython
