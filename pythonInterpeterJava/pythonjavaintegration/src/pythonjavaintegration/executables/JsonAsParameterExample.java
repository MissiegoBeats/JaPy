package pythonjavaintegration.executables;

import java.io.IOException;
import org.json.simple.JSONObject;
import pythonjavaintegration.classes.Rutas;

/**
 * JsonAsParameterExample
 * @author Andrés Missiego
 */
public class JsonAsParameterExample {
    public static String generarJson(){
        // JSON de ejemplo como cadena
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("\"nombre\"", "\"Pepe\"");
        jsonObject.put("\"edad\"", 24);
        jsonObject.put("\"localizacion\"", "\"Madrid\"");
        jsonObject.put("\"telefono\"", "\"234-567-890\"");
        String jsonString = jsonObject.toString();
        return jsonString;
    }
    
    public static void example1(){
        try {
            // Ruta al ejecutable de Python y el script Python
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "cambiarTelefono";
            String telefono = "123-123-123";

            String jsonParameter = generarJson();
            
            // Construir el comando para ejecutar el script Python con el parámetro JSON
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, pythonScript, function, jsonParameter, telefono); //python <file_name> <arg1> ... <argN>

            // Ejecutar el comando y obtener el proceso resultante
            Process process = processBuilder.start();

            // Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso)
            // Aquí se imprime la salida del script Python en la consola de Java
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
    
    public static void example2(){
        try{
            // Ruta al ejecutable de Python y el script Python
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "consultarLocalizacion";
            String nombre = "Pepe";

            String jsonParameter = generarJson();

            // Construir el comando para ejecutar el script Python con el parámetro JSON
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, nombre); //python <file_name> <arg1> ... <argN>

            // Ejecutar el comando y obtener el proceso resultante
            Process process = processBuilder.start();

            // Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso)
            // Aquí se imprime la salida del script Python en la consola de Java
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void example3(){
        try{
            // Ruta al ejecutable de Python y el script Python
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "agnadirElemento";
            String key = "trabajo";
            String value = "programador";

            String jsonParameter = generarJson();

            // Construir el comando para ejecutar el script Python con el parámetro JSON
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, key, value); //python <file_name> <arg1> ... <argN>

            // Ejecutar el comando y obtener el proceso resultante
            Process process = processBuilder.start();

            // Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso)
            // Aquí se imprime la salida del script Python en la consola de Java
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void example4(){
        try{
            // Ruta al ejecutable de Python y el script Python
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "eliminarElemento";
            String key = "telefono";

            String jsonParameter = generarJson();

            // Construir el comando para ejecutar el script Python con el parámetro JSON
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, key); //python <file_name> <arg1> ... <argN>

            // Ejecutar el comando y obtener el proceso resultante
            Process process = processBuilder.start();

            // Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso)
            // Aquí se imprime la salida del script Python en la consola de Java
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void example4KeyNotFound(){
        try{
            // Ruta al ejecutable de Python y el script Python
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "eliminarElemento";
            String key = "notAKey";

            String jsonParameter = generarJson();

            // Construir el comando para ejecutar el script Python con el parámetro JSON
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, key); //python <file_name> <arg1> ... <argN>

            // Ejecutar el comando y obtener el proceso resultante
            Process process = processBuilder.start();

            // Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso)
            // Aquí se imprime la salida del script Python en la consola de Java
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void example5(){
        try{
            // Ruta al ejecutable de Python y el script Python
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "encontrarValor";
            String key = "nombre";

            String jsonParameter = generarJson();
            
            // Construir el comando para ejecutar el script Python con el parámetro JSON
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, key); //python <file_name> <arg1> ... <argN>

            // Ejecutar el comando y obtener el proceso resultante
            Process process = processBuilder.start();

            // Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso)
            // Aquí se imprime la salida del script Python en la consola de Java
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void example6(){
        try{
            // Ruta al ejecutable de Python y el script Python
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "parseJsonToCsv";

            String jsonParameter = generarJson();
            
            // Construir el comando para ejecutar el script Python con el parámetro JSON
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter); //python <file_name> <arg1> ... <argN>

            // Ejecutar el comando y obtener el proceso resultante
            Process process = processBuilder.start();

            // Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso)
            // Aquí se imprime la salida del script Python en la consola de Java
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        example1();
        System.out.println("-----------------------------------------------");
        example2();
        System.out.println("-----------------------------------------------");
        example3();
        System.out.println("-----------------------------------------------");
        example4();
        System.out.println("-----------------------------------------------");
        example4KeyNotFound();
        System.out.println("-----------------------------------------------");
        example5();
        System.out.println("-----------------------------------------------");
        example6();
        System.out.println("-----------------------------------------------");
    }
}
