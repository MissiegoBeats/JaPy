package pythonjavaintegration.classes;

//Imports
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
 * BuscadorJsonEmpresas
 * @author Andrés Missiego
 */
public class BuscadorJsonEmpresas {
    //ES: Atributos de la clase
    //EN: Class attributes
    private Rutas rutas = new Rutas(); 
    private JSONObject jsonObject = null;
    private PyString jsonString;
    private String ruta = this.rutas.empresas;
    private String rutaPy = this.rutas.buscadorEmpresas;
    private PythonInterpreter interpreter = new PythonInterpreter();
    
    //ES: Constructor de la clase
    //EN: Class builder
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
    }//End constructor
    
    /**
     * ES: Clase para actualizar el archivo JSON de la clase
     * EN: Class to update the JSON file of the class
     * @param newJson String uptaded JSON
     */
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
    }//End actualizarJson
    
    /**
     * ES: método para obtener el correo dado el nombre de la empresa y el usuario
     * EN: method to get the email given the name of the company and the user name
     * @param nombreEmpresa String name of the company
     * @param nombreUsuario String user name
     * @return String email of the user
     */
    public String obtenerCorreo(String nombreEmpresa, String nombreUsuario){
        PyString empresa = new PyString("'"+nombreEmpresa+"'");
        PyString usuario = new PyString("'"+nombreUsuario+"'");
       
        PyObject res = this.interpreter.eval("buscarCorreo("+empresa+","+usuario+","+this.jsonString+")");
        Object correo = res.__tojava__(Object.class);
        
        return correo.toString();
    }//End obtenerCorreo
    
    /**
     * ES: método para obtener el número de teléfono dado el nombre de la empresa
     * EN: method to get the phone number given the name of the company
     * @param nombreEmpresa String name of the company
     * @return String phone number of the company
     */
    public String obtenerTelefono(String nombreEmpresa){
        PyString empresa = new PyString("'"+nombreEmpresa+"'");
       
        PyObject res = this.interpreter.eval("buscarTelefono("+empresa+","+this.jsonString+")");
        Object telef = res.__tojava__(Object.class);
        
        return telef.toString();
    }//End obtenerTelefono
    
    /**
     * ES: método para obtener la dirección dado el nombre de la empresa
     * EN: method to get the address given the name of the company
     * @param nombreEmpresa String name of the company
     * @return String address of the company
     */
    public String obtenerDireccion(String nombreEmpresa){
        PyString empresa = new PyString("'"+nombreEmpresa+"'");
       
        PyObject res = this.interpreter.eval("buscarDireccion("+empresa+","+this.jsonString+")");
        Object dir = res.__tojava__(Object.class);
        
        return dir.toString();
    }//End obtenerDireccion
    
    /**
     * ES: método para modificar la dirección de la empresa
     * EN: method to modify the address of the company
     * @param nombreEmpresa String company name
     * @param nuevaDireccion String new address
     */
    public void modificarDireccion(String nombreEmpresa, String nuevaDireccion){
        PyString empresa = new PyString("'"+nombreEmpresa+"'");
        PyString direccion = new PyString("'"+nuevaDireccion+"'");
        
        PyObject res = this.interpreter.eval("modificarDireccion("+empresa+","+direccion+","+this.jsonString+")");
        String jsonmod = (String)res.__tojava__(Object.class);
        
        actualizarJson(jsonmod);
    }//End modificarDireccion
}//End class
