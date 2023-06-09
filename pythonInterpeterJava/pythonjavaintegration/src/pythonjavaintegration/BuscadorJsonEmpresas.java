package pythonjavaintegration;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

/**
 *
 * @author missi
 */
public class BuscadorJsonEmpresas {
    private JSONObject jsonObject = null;
    private PyString jsonString;
    private String ruta = "./src/pythonjavaintegration/empresas.json";
    private String rutaPy = "./src/pythonjavaintegration/buscadorEmpresas.py";
    private PythonInterpreter interpreter = new PythonInterpreter();
    
    //Constructor de la clase
    public BuscadorJsonEmpresas(){
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(this.ruta));
            this.jsonObject = (JSONObject) obj;
            this.jsonString = new PyString("'"+this.jsonObject.toString()+"'");
            this.interpreter.execfile(rutaPy);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String obtenerCorreo(String nombreEmpresa, String nombreUsuario){
        PyString empresa = new PyString("'"+nombreEmpresa+"'");
        PyString usuario = new PyString("'"+nombreUsuario+"'");
       
        PyObject res = this.interpreter.eval("buscarCorreo("+empresa+","+usuario+","+this.jsonString+")");
        Object correo = res.__tojava__(Object.class);
        
        return correo.toString();
    }
}
