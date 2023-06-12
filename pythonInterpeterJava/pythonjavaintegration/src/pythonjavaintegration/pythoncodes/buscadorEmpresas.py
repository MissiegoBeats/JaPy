import json

idpython = "(PYTHON)  "

def formatear_json(cadena_json):
    try:
        json_objeto = json.loads(cadena_json)
        json_formateado = json.dumps(json_objeto, indent=4)
        return json_formateado
    except Exception as e:
        print("Error: La cadena no es un JSON valido.")
        print(str(e))
        return None

def buscarCorreo(empresa, usuario, jsonString):
    nombre_usuario_buscar = usuario
    nombre_empresa_buscar = empresa
    datos = json.loads(jsonString) #Cargamos el json como diccionario
    for empresa in datos["empresas"]:
        if empresa["nombre"] == nombre_empresa_buscar:
            for usuario in empresa["usuarios"]:
                if usuario["nombre"] == nombre_usuario_buscar:
                    correo_usuario = usuario["correo"]
                    print(idpython+"El correo del usuario "+str(nombre_usuario_buscar)+" en la empresa "+str(nombre_empresa_buscar)+" es: "+str(correo_usuario))
                    return correo_usuario
            break

def buscarTelefono(empresa, jsonString):
    nombre_empresa_buscar = empresa
    datos = json.loads(jsonString) #Cargamos el json como diccionario
    for empresa in datos["empresas"]:
        if empresa["nombre"] == nombre_empresa_buscar:
            telefono_empresa = empresa["telefono"]
            print(idpython+"El telefono de la empresa "+str(nombre_empresa_buscar)+" es: "+str(telefono_empresa))
            return telefono_empresa

def buscarDireccion(empresa, jsonString):
    nombre_empresa_buscar = empresa
    datos = json.loads(jsonString) #Cargamos el json como diccionario
    for empresa in datos["empresas"]:
        if empresa["nombre"] == nombre_empresa_buscar:
            direccion_empresa = empresa["ubicacion"]
            print(idpython+"La direccion de la empresa "+str(nombre_empresa_buscar)+" es: "+str(direccion_empresa))
            return direccion_empresa

def modificarDireccion(empresa, nuevaDireccion, jsonString):
    nombre_empresa_buscar = empresa
    datos = json.loads(jsonString) #Cargamos el json como diccionario
    for empresa in datos["empresas"]:
        print(empresa["nombre"])
        if empresa["nombre"] == nombre_empresa_buscar:
            empresa["ubicacion"] = nuevaDireccion
            print(idpython+"La direccion de la empresa "+str(nombre_empresa_buscar)+" ha sido modificada a: "+str(nuevaDireccion))
            return json.dumps(datos)