package japy.executables;

//Imports
import java.io.IOException;
import japy.classes.Rutas;

/**
 * PBStructureExample
 * @author Andrés Missiego
 */
public class PBStructureExample {

    /**
     * ES: Método main
     * EN: Main method
     * @param args String[] the command line arguments
     */
    
    //ES: de esta manera funcionan las librerias externas (a diferencia que haciendo uso de jython)
    //EN: this is how external libraries work (unlike using jython)
    public static void main(String[] args) {
        try {
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.useoflibs;

            //ES: JSON de ejemplo como cadena
            //EN: Example JSON as a string
            String jsonParameter = "{\"key\": \"value\"}";

            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameter
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, pythonScript, jsonParameter); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the process output (this may be optional depending on your use case). Here the Python script output is printed in the Java console
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            //ES: Esperar a que el proceso termine
            //EN: Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }//End main 
}//End PBStructureExample
