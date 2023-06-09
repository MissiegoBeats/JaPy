import json

idpython = "(PYTHON)  "

def formatear_json(cadena_json):
    try:
        json_objeto = json.loads(cadena_json)
        json_formateado = json.dumps(json_objeto, indent=4)
        return json_formateado
    except json.JSONDecodeError:
        print("Error: La cadena no es un JSON valido.")
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