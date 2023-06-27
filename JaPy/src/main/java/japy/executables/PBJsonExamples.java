package japy.executables;

//Imports
import java.io.IOException;
import org.json.simple.JSONObject;
import japy.classes.Rutas;

/**
 * JsonAsParameterExample
 * @author Andrés Missiego
 */
public class PBJsonExamples {
    /**
     * ES: método para generar un JSON de ejemplo como String
     * EN: method to generate an example JSON as String
     * @return String JSON generated
     */
    public static String generarJson() {
        // JSON de ejemplo como cadena
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("\"nombre\"", "\"Pepe\"");
        jsonObject.put("\"edad\"", 24);
        jsonObject.put("\"localizacion\"", "\"Madrid\"");
        jsonObject.put("\"telefono\"", "\"234-567-890\"");
        String jsonString = jsonObject.toString();
        return jsonString;
    }
    
    /**
     * ES: ejemplo de ejecución de un script Python con un parámetro JSON (modificacion de un valor del JSON)
     * EN: example of execution of a Python script with a JSON parameter (modification of a value of the JSON)
     */
    public static void example1(){
        try {
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "cambiarTelefono";
            String telefono = "123-123-123";

            //ES: Generar el parámetro JSON
            //EN: Generate the JSON parameter
            String jsonParameter = generarJson();
            
            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameter
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, pythonScript, function, jsonParameter, telefono); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the output of the process (it can be optional depending on your use case). Here the output of the Python script is printed in the Java console
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
    }//End example1
    
    /**
     * ES: ejemplo de ejecución de un script Python con un parámetro JSON (consulta de un valor del JSON)
     * EN: example of execution of a Python script with a JSON parameter (query of a value of the JSON)
     */
    public static void example2(){
        try{
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "consultarLocalizacion";
            String nombre = "Pepe";

            //ES: Generar el parámetro JSON
            //EN: Generate the JSON parameter
            String jsonParameter = generarJson();

            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameter
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, nombre); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the output of the process (it can be optional depending on your use case). Here the output of the Python script is printed in the Java console
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }//End example2
    
    /**
     * ES: ejemplo de ejecución de un script Python con un parámetro JSON (añadir un elemento al JSON)
     * EN: example of execution of a Python script with a JSON parameter (add an element to the JSON)
     */
    public static void example3(){
        try{
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "agnadirElemento";
            String key = "trabajo";
            String value = "programador";

            //ES: Generar el parámetro JSON
            //EN: Generate the JSON parameter
            String jsonParameter = generarJson();

            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameter
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, key, value); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the output of the process (it can be optional depending on your use case). Here the output of the Python script is printed in the Java console
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }//End example3
    
    /**
     * ES: ejemplo de ejecución de un script Python con un parámetro JSON (eliminar un elemento del JSON)
     * EN: example of execution of a Python script with a JSON parameter (delete an element from the JSON)
     */
    public static void example4(){
        try{
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "eliminarElemento";
            String key = "telefono";

            //ES: Generar el parámetro JSON
            //EN: Generate the JSON parameter
            String jsonParameter = generarJson();

            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameter
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, key); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the output of the process (it can be optional depending on your use case). Here the output of the Python script is printed in the Java console
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }//End example4
    
    /**
     * ES: ejemplo de ejecución de un script Python con un parámetro JSON (eliminar un elemento del JSON). En este caso se intenta eliminar un elemento que no existe
     * EN: example of execution of a Python script with a JSON parameter (delete an element from the JSON). In this case we try to delete an element that does not exist
     */
    public static void example4KeyNotFound(){
        try{
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "eliminarElemento";
            String key = "notAKey";

            //ES: Generar el parámetro JSON
            //EN: Generate the JSON parameter
            String jsonParameter = generarJson();

            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameter
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, key); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the output of the process (it can be optional depending on your use case). Here the output of the Python script is printed in the Java console
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }//End example4KeyNotFound
    
    /**
     * ES: ejemplo de ejecución de un script Python con un parámetro JSON (encontrar un valor en el JSON)
     * EN: example of execution of a Python script with a JSON parameter (find a value in the JSON)
     */
    public static void example5(){
        try{
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "encontrarValor";
            String key = "nombre";

            //ES: Generar el parámetro JSON
            //EN: Generate the JSON parameter
            String jsonParameter = generarJson();
            
            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameter
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, key); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the output of the process (it can be optional depending on your use case). Here the output of the Python script is printed in the Java console
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }//End example5
    
    /**
     * ES: ejemplo de ejecución de un script Python con un parámetro JSON (convertir JSON a CSV)
     * EN: example of execution of a Python script with a JSON parameter (convert JSON to CSV)
     */
    public static void example6(){
        try {
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "parseJsonToCsv";

            //ES: Generar el parámetro JSON
            //EN: Generate the JSON parameter
            String jsonParameter = generarJson();
            
            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameters
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the output of the process (it can be optional depending on your use case). Here the output of the Python script is printed in the Java console
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }//End example6
    
    /**
     * ES: ejemplo de ejecución de un script Python con un parámetro JSON (escribir JSON a un archivo)
     * EN: example of execution of a Python script with a JSON parameter (write JSON to a file)
     */
    public static void example7(){
        try{
            //ES: Ruta al ejecutable de Python y los parámetros del script Python
            //EN: Path to the Python executable and the Python script parameters
            Rutas rutas = new Rutas();
            String pythonExecutable = "python";
            String pythonScript = rutas.jsonAsParameterExample;
            String function = "writeJsonToFile";
            String nombreArchivo = "output.json";
            
            //ES: Generar el parámetro JSON
            //EN: Generate the JSON parameter
            String jsonParameter = generarJson();
            
            //ES: Construir el comando para ejecutar el script Python con el parámetro JSON
            //EN: Build the command to execute the Python script with the JSON parameters
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, 
                    pythonScript, function, jsonParameter, nombreArchivo); //python <file_name> <arg1> ... <argN>

            //ES: Ejecutar el comando y obtener el proceso resultante
            //EN: Execute the command and get the resulting process
            Process process = processBuilder.start();

            //ES: Leer la salida del proceso (puede ser opcional dependiendo de tu caso de uso). Aquí se imprime la salida del script Python en la consola de Java
            //EN: Read the output of the process (it can be optional depending on your use case). Here the output of the Python script is printed in the Java console
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }//End example7
    
    /**
     * ES: Método main (ejecucion ejemplos)
     * EN: main method (examples execution)
     * @param args String[] the command line arguments
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
        example7();
        System.out.println("-----------------------------------------------");
    }//End main
}//End class
