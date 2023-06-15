package pythonjavaintegration.executables;

import java.io.IOException;

/**
 * ProcessBuilderExample
 * @author Andrés Missiego
 */
public class ProcessBuilderExample {

    /**
     * @param args the command line arguments
     */
    
    //NOTA: FUNCIONAN LAS LIBRERÍAS EXTERNAS!!!
    public static void main(String[] args) {
        try {
            // Ruta al ejecutable de Python y el script Python
            String pythonExecutable = "python";
            String pythonScript = "./src/pythonjavaintegration/pythoncodes/useoflibs.py";

            // JSON de ejemplo como cadena
            String jsonParameter = "{\"key\": \"value\"}";

            // Construir el comando para ejecutar el script Python con el parámetro JSON
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, pythonScript, jsonParameter);

            // Ejecutar el comando y obtener el proceso resultante
            Process process = processBuilder.start();

            // Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso)
            // Aquí se imprime la salida del script Python en la consola ed Java
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
