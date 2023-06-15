package pythonjavaintegration.executables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JavaPythonIntegrationJson {

    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {
        try {
            String functionName = "cambiarTelefono"; // Nombre de la función en Python
            String json = "./src/pythonjavaintegration/json/inputData.json"; // Nombre del archivo JSON
            // Construye el comando para llamar a la función en Python
            String command = "python ./src/pythonjavaintregration/pythoncodes/mainJson.py " + functionName; // Comando para llamar a la función en Python
            String[] params = {json, "123-123-123"}; // Parámetros que recibe la función en Python
            for (String param : params) {
                command += " " + param;
            }

            System.out.println(command);
            
            // Ejecuta el comando de Python
            Process process = Runtime.getRuntime().exec(command);

            // Lee la salida del proceso de Python
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String output = reader.readLine();

            System.out.println(output);

            StringBuilder sb = new StringBuilder();
            sb.append("{");
    
            // Split the string by comma and iterate over key-value pairs
            String[] pairs = output.split(",");
            for (String pair : pairs) {
                // Split each pair by colon to separate key and value
                String[] keyValue = pair.split(":");
    
                // Remove leading and trailing quotes from key and value
                String key = keyValue[0].trim().replaceAll("\"", "");
                String value = keyValue[1].trim().replaceAll("\"", "");
    
                // Append key-value pair to the JSON object
                sb.append("\"").append(key).append("\": \"").append(value).append("\",");
            }
    
            // Remove trailing comma if present
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
    
            // Close the JSON object
            sb.append("}");
    
            // Convert StringBuilder to JSON string
            String jsonResult = sb.toString();
    
            // Print the JSON string
            System.out.println(jsonResult);

            /*
            Mejor con esto: 
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(stringToParse);*/

            // Cierra el lector y el proceso
            reader.close();
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Fin método main
} //Fin clase JavaPythonIntegration