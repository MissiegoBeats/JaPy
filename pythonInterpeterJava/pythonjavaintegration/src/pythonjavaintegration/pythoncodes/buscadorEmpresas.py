#ES: Importar librerias
#EN: Import libraries
import json

#Id para identificar los mensajes de python
idpython = "(PYTHON)  "

def formatear_json(cadena_json):
    """
    ES:
        OBJ: Función que formatea una cadena json para que sea más legible.
        IN: cadena_json: Cadena json a formatear.
        OUT: json_formateado: Cadena json formateada (None si no se ha podido formatear)
    EN:
        OBJ: Function that formats a json string to make it more readable.
        IN: cadena_json: Json string to format.
        OUT: json_formateado: Formatted json string (None if it could not be formatted)"""

    try:
        json_objeto = json.loads(cadena_json)
        json_formateado = json.dumps(json_objeto, indent=4)
        return json_formateado
    except Exception as e:
        print("Error: La cadena no es un JSON valido.")
        print(str(e))
        return None

def buscarCorreo(empresa, usuario, jsonString):
    """
    ES:
        OBJ: Función que busca el correo de un usuario en una empresa.
        IN: empresa: Nombre de la empresa.
            usuario: Nombre del usuario.
            jsonString: Cadena json con los datos.
        OUT: correo_usuario: Correo del usuario (None si no se ha encontrado)
    EN:
        OBJ: Function that searches the email of a user in a company.
        IN: empresa: Name of the company.
            usuario: Name of the user.
            jsonString: Json string with the data.
        OUT: correo_usuario: User email (None if not found)
    """

    nombre_usuario_buscar = usuario
    nombre_empresa_buscar = empresa
    datos = json.loads(jsonString) #Load the json as a dictionary

    for empresa in datos["empresas"]:
        if empresa["nombre"] == nombre_empresa_buscar:
            for usuario in empresa["usuarios"]:
                if usuario["nombre"] == nombre_usuario_buscar:
                    correo_usuario = usuario["correo"]
                    print(idpython+"El correo del usuario "+str(nombre_usuario_buscar)+" en la empresa "+str(nombre_empresa_buscar)+" es: "+str(correo_usuario))
                    return correo_usuario
            break
    
    return None

def buscarTelefono(empresa, jsonString):
    """
    ES:
        OBJ: Función que busca el telefono de una empresa.
        IN: empresa: Nombre de la empresa.
            jsonString: Cadena json con los datos.
        OUT: telefono_empresa: Telefono de la empresa (None si no se ha encontrado)
    EN:
        OBJ: Function that searches the phone of a company.
        IN: empresa: Name of the company.
            jsonString: Json string with the data.
        OUT: telefono_empresa: Company phone (None if not found)
    """

    nombre_empresa_buscar = empresa
    datos = json.loads(jsonString) #Load the json as a dictionary

    for empresa in datos["empresas"]:
        if empresa["nombre"] == nombre_empresa_buscar:
            telefono_empresa = empresa["telefono"]
            print(idpython+"El telefono de la empresa "+str(nombre_empresa_buscar)+" es: "+str(telefono_empresa))
            return telefono_empresa

    return None

def buscarDireccion(empresa, jsonString):
    """
    ES:
        OBJ: Función que busca la direccion de una empresa.
        IN: empresa: Nombre de la empresa.
            jsonString: Cadena json con los datos.
        OUT: direccion_empresa: Direccion de la empresa (None si no se ha encontrado)
    EN:
        OBJ: Function that searches the address of a company.
        IN: empresa: Name of the company.
            jsonString: Json string with the data.
        OUT: direccion_empresa: Company address (None if not found)
    """

    nombre_empresa_buscar = empresa
    datos = json.loads(jsonString) #Load the json as a dictionary

    for empresa in datos["empresas"]:
        if empresa["nombre"] == nombre_empresa_buscar:
            direccion_empresa = empresa["ubicacion"]
            print(idpython+"La direccion de la empresa "+str(nombre_empresa_buscar)+" es: "+str(direccion_empresa))
            return direccion_empresa

    return None

def modificarDireccion(empresa, nuevaDireccion, jsonString):
    """
    ES:
        OBJ: Función que modifica la direccion de una empresa.
        IN: empresa: Nombre de la empresa.
            nuevaDireccion: Nueva direccion de la empresa.
            jsonString: Cadena json con los datos.
        OUT: jsonString: Cadena json con los datos modificados (None si no se ha podido modificar)
    EN:
        OBJ: Function that modifies the address of a company.
        IN: empresa: Name of the company.
            nuevaDireccion: New address of the company.
            jsonString: Json string with the data.
        OUT: jsonString: Json string with the modified data (None if it could not be modified)
    """

    nombre_empresa_buscar = empresa
    datos = json.loads(jsonString) #Load the json as a dictionary

    for empresa in datos["empresas"]:
        print(empresa["nombre"])
        if empresa["nombre"] == nombre_empresa_buscar:
            empresa["ubicacion"] = nuevaDireccion
            print(idpython+"La direccion de la empresa "+str(nombre_empresa_buscar)+" ha sido modificada a: "+str(nuevaDireccion))
            return json.dumps(datos)

    return None