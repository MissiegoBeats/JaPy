import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class JavaPythonIntegration {
    public static void main(String[] args) {
        try {
            // Ejecuta el comando de Python
            Process process = Runtime.getRuntime().exec("python main.py");

            // Lee la salida del proceso de Python
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String output = reader.readLine();

            // Imprime el resultado
            System.out.println(output);

            // Cierra el lector y el proceso
            reader.close();
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
