package pythonjavaintegration;

import org.python.util.PythonInterpreter;
import org.python.core.*;

/**
 * Example with json
 * @author Andrés Missiego
 */
public class PythonJavaIntegrationJsonExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta = "./src/pythonjavaintegration/";
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(ruta + "jsonprocessing.py");
        PyString ficheroInput = new PyString("str('"+ruta+"inputData.json')");
        PyString nuevoTelefono = new PyString("str('123-123-123')");
        PyObject jsonMod = interpreter.eval("cambiarTelefono("+ficheroInput+","+nuevoTelefono+")");
        Object jsonModJava = jsonMod.__tojava__(Object.class);
        System.out.println(jsonModJava);        
    }   
}
