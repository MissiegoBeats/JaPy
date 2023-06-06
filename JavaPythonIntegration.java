import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class JavaPythonIntegration {

    /**
     * Convierte un String a MiClase
     * @param miClaseString
     * @return MiClase 
     */
    private static MiClase convertToMiClase(String miClaseString) {
        miClaseString = miClaseString.replace("[", "");
        miClaseString = miClaseString.replace("]", "");
        String[] miClaseArray = miClaseString.split(",");
        MiClase miClase = new MiClase();
        miClase.setNombre(miClaseArray[2].trim());
        miClase.setEdad(Integer.parseInt(miClaseArray[3].trim()));
        return miClase;
    }

    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {
        try {
            String functionName = "cumpleagnos";
            String[] params = {"prueba", "21"}; // Parámetros para la función en Python

            // Construye el comando para llamar a la función en Python
            String command = "python main.py " + functionName;
            for (String param : params) {
                command += " " + param;
            }

            // Ejecuta el comando de Python
            Process process = Runtime.getRuntime().exec(command);

            // Lee la salida del proceso de Python
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String output = reader.readLine();

            MiClase mc = convertToMiClase(output); // Convierte el String a MiClase
            System.out.println(mc.toString());

            // Cierra el lector y el proceso
            reader.close();
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
