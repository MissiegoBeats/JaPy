package pythonjavaintegration;

import org.python.util.PythonInterpreter;

/**
 * Pythonjavaintregration
 * @author Andrés Missiego
 */
public class Pythonjavaintegration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        
        // Execute Python code
        interpreter.exec("def greet(name):\n    return 'Hello, ' + name\n");
        
        // Call Python function
        interpreter.exec("result = greet('John')");
        
        // Get the result
        String result = interpreter.get("result").toString();
        
        System.out.println(result); 
    }
    
}
