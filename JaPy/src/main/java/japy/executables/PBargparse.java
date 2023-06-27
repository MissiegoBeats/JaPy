package japy.executables;

import java.io.IOException;

import japy.classes.Rutas;

/**
 * PBargparse
 *
 * @author Andrés Missiego
 */
public class PBargparse
{

    /**
     * ES: Funcion Main EN: Main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
          {
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python3";
            String pythonScript = rutas.findStadium;
            String team = "\"Real Madrid\"";
            String country = "Spain";
            String league = "ACB";
            
            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameter
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, pythonScript, team, "--country", country, "-l", league); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the process output (this may be optional depending on your use case). Here the Python script output is printed in the Java console
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null)
              {
                System.out.println(line);
              }

            //ES: Esperar a que el proceso termine
            //EN: Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
            
            java.io.BufferedReader errors = new java.io.BufferedReader(
                   new java.io.InputStreamReader(process.getErrorStream()));

            String errorLine;
            while ((errorLine = errors.readLine()) != null) {
                System.out.println(errorLine);
            }
          } catch (IOException | InterruptedException e)
          {
            e.printStackTrace();
          }
    }

}
