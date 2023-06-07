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
            String json ="{\"tamano\": \"mediana\","+
                "\"precio\": 15.67,"+
                "\"toppings\": [\"champinones\", \"queso extra\", \"pepperoni\", \"albahaca\"],"+
                "\"cliente\": {"+
                    "\"nombre\": \"Jane Doe\","+
                    "\"telefono\": \"455-344-234\","+
                    "\"correo\": \"janedoe@email.com\""+
                "}"+
            "}";
            // Construye el comando para llamar a la función en Python
            String command = "python mainJson.py " + functionName; // Comando para llamar a la función en Python
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

            //MiClase mc = convertToMiClase(output); // Convierte el String a MiClase
            //System.out.println(mc.toString());

            // Cierra el lector y el proceso
            reader.close();
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Fin método main
} //Fin clase JavaPythonIntegration
