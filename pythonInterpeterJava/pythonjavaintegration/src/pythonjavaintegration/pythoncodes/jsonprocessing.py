import sys
import json

def formatear_json(cadena_json):
    try:
        json_objeto = json.loads(cadena_json)
        json_formateado = json.dumps(json_objeto, indent=4)
        return json_formateado
    except json.JSONDecodeError:
        print("Error: La cadena no es un JSON valido.")
        return None


def cambiarTelefono(archivoInput, telefono):
    jsonFile = open(archivoInput, "r") #Abrimos el archivo json
    datos = jsonFile.read() #Leemos el archivo
    datos_diccionario = json.loads(datos) #Cargamos el json como diccionario

    datos_diccionario["cliente"]["telefono"] = str(telefono) #Modificamos el telefono
    modificado = json.dumps(datos_diccionario) #Convertimos el diccionario a json

    modificado = formatear_json(modificado) #Formateamos el json

    print("Guardando el archivo modificado en outputData.json")
    outputFile = open("./src/pythonjavaintegration/json/outputData.json", "w") #Abrimos el archivo de salida
    outputFile.write(modificado) #Escribimos el json modificado
    print("Archivo guardado")
    outputFile.close() #Cerramos el archivo de salida

    jsonFile.close() #Cerramos el archivo json

    return modificado #Devolvemos el json modificado

#archivoInput ahora es un JSON, no la referencia a un archivo .json en el sistema
def cambiarTelefonoDadoJson(j, telefono):
    datos_diccionario = json.loads(j) #Cargamos el json como diccionario

    datos_diccionario["cliente"]["telefono"] = str(telefono) #Modificamos el telefono
    modificado = json.dumps(datos_diccionario) #Convertimos el diccionario a json

    modificado = formatear_json(modificado) #Formateamos el json

    print("Guardando el archivo modificado en outputData.json")
    outputFile = open("./src/pythonjavaintegration/json/outputData.json", "w") #Abrimos el archivo de salida
    outputFile.write(modificado) #Escribimos el json modificado
    print("Archivo guardado")
    outputFile.close() #Cerramos el archivo de salida

    return modificado #Devolvemos el json modificado
    

def main():
    print("hola mundo, esto es el main de jsonprocessing.py")
        
if __name__ == '__main__':
    #No se ejecuta si es un modulo importado
    main()