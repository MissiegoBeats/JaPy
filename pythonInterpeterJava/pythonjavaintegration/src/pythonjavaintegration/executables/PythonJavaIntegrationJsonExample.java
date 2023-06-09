package pythonjavaintegration.executables;

import java.io.FileReader;
import org.python.util.PythonInterpreter;
import org.python.core.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

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
        
        interpreter.close();
        
        //Para el ejemplo de paso como parámetro, lo voy a leer del archivo inputData.json
        PythonInterpreter pyInterpreter = new PythonInterpreter();
        pyInterpreter.execfile(ruta + "jsonprocessing.py");
        
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(ruta+"inputData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String jsonString = jsonObject.toString(); 
            PyString jsonPy =  new PyString("str('"+jsonString+"')");
            PyString telefono = new PyString("str('456-456-456')");
            PyObject jsonModificado = interpreter.eval("cambiarTelefonoDadoJson("+jsonPy+","+telefono+")");
            Object res = jsonModificado.__tojava__(Object.class);
            System.out.println("Resultado del segundo metodo: \n"+res);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }   
}
