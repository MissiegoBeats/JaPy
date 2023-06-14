package missiego.jpypeexampleproject;

import org.jpype.*;

public class MainExample {
    public static void main(String[] args) {
        try {
            // Start the JVM with the path to the Python interpreter
            String pythonHome = "ruta_al_interprete_de_python";
            String[] jvmArgs = new String[] { "-Djava.library.path=" + pythonHome };
            JPype.startJVM(jvmArgs);

            // Execute Python code
            JPype.exec("print('Hello from Python!')");

            // Execute a Python function
            JPype.exec("def square(x):\n    return x ** 2");
            JPypeObject squareFunc = JPype.JClass("square");
            JPypeObject result = squareFunc.call(5);
            System.out.println("Result: " + result.toInt());

            // Shut down the JVM
            JPype.shutdownJVM();
        } catch (JPypeException e) {
            e.printStackTrace();
        }
    }
}
