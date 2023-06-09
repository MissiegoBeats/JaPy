package pythonInterpeterJava.pythonjavaintegration.src.pythonjavaintegration;

import java.io.StringWriter;
import org.python.core.*;
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
        String directoryName = System.getProperty("user.dir");
        System.out.println(directoryName);
        //ES: para ejecutar líneas de código python se hace de la siguiente manera
        //EN: to execute separate lines using python you can do it this way
        PythonInterpreter pi = new PythonInterpreter();
        pi.set("integer1", new PyInteger(42));
        pi.set("integer2", new PyInteger(43));
        pi.exec("result = integer1 + integer2");
        //pi.exec("print(result)");
        PyInteger result = (PyInteger) pi.get("result");
        System.out.println("result: "+result.asInt()+"\n");
        pi.close();
        
        //ES:Para ejecutar un archivo se hace de la siguiente manera
        //EN:To exectue a python file you can do it this way
        PythonInterpreter interpreter = new PythonInterpreter();
        
        StringWriter output = new StringWriter();
        interpreter.setOut(output);
        interpreter.execfile("./src/pythonjavaintegration/main.py"); //nota: se puede usar el interpreter.get() para obtener el valor de una variable
        String pyOutput = output.toString();
        System.out.println("res del archivo: "+pyOutput);
        
        output.flush();
        output.getBuffer().setLength(0);
        
        PyObject res = interpreter.eval("saludar()"); //devuelve null ya que no devuelve nada y el output está en la var "output"
        System.out.print("output pantalla: "+output);
        Object javaObj = res.__tojava__(Object.class);
        System.out.println("res de la funcion: "+javaObj+"\n");
        
        PyInteger a = new PyInteger(3);
        PyInteger b = new PyInteger(5);
        PyObject suma = interpreter.eval("suma("+a+","+b+")");
        Object sumaJava = suma.__tojava__(Object.class);
        System.out.println("suma: "+sumaJava);
    }
}