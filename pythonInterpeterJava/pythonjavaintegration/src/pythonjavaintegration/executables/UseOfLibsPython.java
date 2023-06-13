package pythonjavaintegration.executables;

import java.io.IOException;
import org.python.util.PythonInterpreter;
import pythonjavaintegration.classes.Rutas;

/**
 *
 * @author Andrés Missiego
 */
public class UseOfLibsPython {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Instalando Pandas");
        installPandas();
        Rutas rutas = new Rutas();
        PythonInterpreter interpreter = new PythonInterpreter(); 
        interpreter.execfile(rutas.useoflibs);
    }
    
    private static void installPandas(){
        try {
            // Crear el comando pip install pandas
            String[] command = {"pip", "install", "pandas"};

            // Crear el proceso y configurarlo
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);

            // Ejecutar el proceso
            Process process = processBuilder.start();

            // Leer la salida del proceso
            java.io.InputStream inputStream = process.getInputStream();
            java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
            String output = scanner.hasNext() ? scanner.next() : "";

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();

            // Mostrar la salida del proceso
            System.out.println(output);

            if (exitCode == 0) {
                System.out.println("¡Instalación exitosa!");
            } else {
                System.out.println("¡Error durante la instalación!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
