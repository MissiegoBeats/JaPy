#ES: Importar librerias
#EN: Import libraries
import sys
import json

def formatear_json(cadena_json):
    """
    ES:
        OBJ: Función que formatea una cadena json para que sea más legible.
        IN: cadena_json: Cadena json a formatear.
        OUT: json_formateado: Cadena json formateada (None si no se ha podido formatear)
    EN:
        OBJ: Function that formats a json string to make it more readable.
        IN: cadena_json: Json string to format.
        OUT: json_formateado: Formatted json string (None if it could not be formatted)
    """
    try:
        json_objeto = json.loads(cadena_json)
        json_formateado = json.dumps(json_objeto, indent=4)
        return json_formateado
    except json.JSONDecodeError:
        print("Error: La cadena no es un JSON valido.")
        return None

def cambiarTelefono(archivoInput, telefono):
    """
    ES:
        OBJ: Función que cambia el telefono de un cliente en un archivo json.
        IN: archivoInput: Ruta del archivo json.
            telefono: Nuevo telefono.
        OUT: modificado: Cadena json con el telefono modificado.
    EN:
        OBJ: Function that changes the phone of a client in a json file.
        IN: archivoInput: Path of the json file.
            telefono: New phone.
        OUT: modificado: Json string with the modified phone.
    """
    jsonFile = open(archivoInput, "r") #Open the json file
    datos = jsonFile.read() #Read the json file
    datos_diccionario = json.loads(datos) #Load the json as a dictionary

    datos_diccionario["cliente"]["telefono"] = str(telefono) #Modify the phone
    modificado = json.dumps(datos_diccionario) #Convert the dictionary to json

    modificado = formatear_json(modificado) #Format the json

    print("Guardando el archivo modificado en outputData.json")
    outputFile = open("./src/pythonjavaintegration/json/outputData.json", "w") #Open the output file
    outputFile.write(modificado) #Write the modified json
    print("Archivo guardado")
    outputFile.close() #Close the output file

    jsonFile.close() #Close the input file

    return modificado #return the modified json

#ES: archivoInput ahora es un JSON, no la referencia a un archivo .json en el sistema
#EN: archivoInput is now a JSON, not the reference to a .json file in the system
def cambiarTelefonoDadoJson(j, telefono):
    """
    ES:
        OBJ: Función que cambia el telefono de un cliente en un json.
        IN: j: Json.
            telefono: Nuevo telefono.
        OUT: modificado: Cadena json con el telefono modificado.
    EN:
        OBJ: Function that changes the phone of a client in a json.
        IN: j: Json.
            telefono: New phone.
        OUT: modificado: Json string with the modified phone.
    """
    datos_diccionario = json.loads(j) #Load the json as a dictionary

    datos_diccionario["cliente"]["telefono"] = str(telefono) #Modify the phone
    modificado = json.dumps(datos_diccionario) #Convert the dictionary to json

    modificado = formatear_json(modificado) #Format the json

    print("Guardando el archivo modificado en outputData.json")
    outputFile = open("./src/pythonjavaintegration/json/outputData.json", "w") #Open the output file
    outputFile.write(modificado) #Write the modified json
    print("Archivo guardado")
    outputFile.close() #Close the output file

    return modificado #Return the modified json
    
#ES: Método main
#EN: Main method
def main():
    print("hola mundo, esto es el main de jsonprocessing.py")
        
if __name__ == '__main__':
    #ES: No se ejecuta si es un modulo importado
    #EN: It is not executed if it is an imported module
    main()