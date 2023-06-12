package pythonjavaintegration.executables;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private String ruta = "./src/pythonjavaintegration/json/empresas.json";
    private String rutaPy = "./src/pythonjavaintegration/pythoncodes/buscadorEmpresas.py";
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
    
    private void actualizarJson(String newJson){
        PyObject j = this.interpreter.eval("formatear_json('"+newJson+"')");
        newJson = (String) j.__tojava__(Object.class);
        File Old_File = new File(this.ruta);
        Old_File.delete();
        File New_File = new File(this.ruta);
        try {
            FileWriter Overwritten_File = new FileWriter(New_File, false);
            Overwritten_File.write(newJson);
            Overwritten_File.close();
        } catch (IOException e) {
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
    
    public String obtenerTelefono(String nombreEmpresa){
        PyString empresa = new PyString("'"+nombreEmpresa+"'");
       
        PyObject res = this.interpreter.eval("buscarTelefono("+empresa+","+this.jsonString+")");
        Object telef = res.__tojava__(Object.class);
        
        return telef.toString();
    }
    
    public String obtenerDireccion(String nombreEmpresa){
        PyString empresa = new PyString("'"+nombreEmpresa+"'");
       
        PyObject res = this.interpreter.eval("buscarDireccion("+empresa+","+this.jsonString+")");
        Object dir = res.__tojava__(Object.class);
        
        return dir.toString();
    }
    
    public void modificarDireccion(String nombreEmpresa, String nuevaDireccion){
        PyString empresa = new PyString("'"+nombreEmpresa+"'");
        PyString direccion = new PyString("'"+nuevaDireccion+"'");
        
        PyObject res = this.interpreter.eval("modificarDireccion("+empresa+","+direccion+","+this.jsonString+")");
        String jsonmod = (String)res.__tojava__(Object.class);
        
        actualizarJson(jsonmod);
    }
}
