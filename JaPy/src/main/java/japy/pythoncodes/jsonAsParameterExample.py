#ES: Importar librerias
#EN: Import libraries
import sys
import json
import io 
import csv

"""
ES:
    Los argumentos de entrada del script son los siguientes: 
        0. Nombre del script
        1. Nombre de la función a llamar
        2. Archivo json
        3-N. Otros argumentos
    Nota: los print en cada método son para que java pueda obtener los valores de retorno
EN:
    The input arguments of the script are the following:
        0. Script name
        1. Function name to call
        2. Json file
        3-N. Other arguments
    Note: the prints in each method are for java to get the return values
"""

def formatJson(jsonString) -> str:
    """
    ES: Formatear el json
        Argumentos de entrada: 
            jsonString: json en formato string
        Salida: json formateado como string
    EN: Format the json
        Input arguments: 
            jsonString: json in string format
        Output: formatted json as string
    """
    try:
        jsonDict = json.loads(jsonString) #Convert the json to a dictionary
        jsonString = json.dumps(jsonDict, indent=4, sort_keys=True) #Convert the dictionary to a json
        return jsonString
    except Exception as e:
        print("Error: " + str(e))
        return jsonString

def cambiarTelefono():
    """
    ES: Modificar el teléfon
        Argumentos de entrada (sys.argv[i]): 
            0. Nombre del script
            1. Nombre de la función a llamar
            2. json
            3. Teléfono
        Salida: json modificado
    EN: Modify the phone
        Input arguments (sys.argv[i]):
            0. Script name
            1. Function name to call
            2. json
            3. Phone
        Output: modified json
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Load the json as a dictionary

    datos_diccionario["telefono"] = str(sys.argv[3]) #Modify the phone

    modificado = json.dumps(datos_diccionario) #Convert the dictionary to json

    """outputFile = open("outputData.json", "w") #Abrimos el archivo de salida
    outputFile.write(modificado) #Escribimos el json modificado
    outputFile.close() #Cerramos el archivo de salida"""

    print("Modificado: ")
    print(modificado) #Print the modified json

def consultarLocalizacion():
    """
    ES: consultar la localizacion
        Argumentos de entrada (sys.argv[i]): 
            0. Nombre del script
            1. Nombre de la función a llamar
            2. json
            3. Nombre
        Salida: localizacion
    EN: consult the location
        Input arguments (sys.argv[i]):
            0. Script name
            1. Function name to call
            2. json
            3. Name
        Output: location
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Load the json as a dictionary

    nombre = str(sys.argv[3]) #Get the name

    localizacion = datos_diccionario["localizacion"] #Get the location

    print("Localización de " + nombre + ": " + localizacion) #Print the location

def agnadirElemento():
    """
    ES: Añadir un elemento
        Argumentos de entrada (sys.argv[i]):
            0. Nombre del script
            1. Nombre de la función a llamar
            2. json
            3. Key
            4. Value
        Salida: json modificado
    EN: Add an element
        Input arguments (sys.argv[i]):
            0. Script name
            1. Function name to call
            2. json
            3. Key
            4. Value
        Output: modified json
    """
    jsonString = sys.argv[2]
    key = str(sys.argv[3]) #Get the key
    value = str(sys.argv[4]) #Get the value
    datos_diccionario = json.loads(jsonString) #Load the json as a dictionary
    
    try:
        datos_diccionario[key] = value #Add the element
    except:
        print("No se pudo añadir el elemento con la key " + key + " y el valor " + value)
        return

    modificado = json.dumps(datos_diccionario) #Convert the dictionary to json

    print("Elemento añadido: ")
    print(modificado) #Print the modified json

def eliminarElemento():
    """
    ES: Eliminar un elemento
        Argumentos de entrada (sys.argv[i]):
            0. Nombre del script
            1. Nombre de la función a llamar
            2. json
            3. Key
        Salida: json modificado
    EN: Delete an element
        Input arguments (sys.argv[i]):
            0. Script name
            1. Function name to call
            2. json
            3. Key
        Output: modified json
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Load the json as a dictionary
    key = str(sys.argv[3]) #Get the key

    try:
        del datos_diccionario[key] #Delete the element
    except KeyError:
        print("No existe el elemento con la key " + key)
        return
    
    modificado = json.dumps(datos_diccionario) #Convert the dictionary to json

    print("Elemento eliminado: ")
    print(modificado) #Print the modified json

def encontrarValor():
    """
    ES: Encontrar el valor de un elemento
        Argumentos de entrada (sys.argv[i]):
            0. Nombre del script
            1. Nombre de la función a llamar
            2. json
            3. Key
        Salida: valor
    EN: Find the value of an element
        Input arguments (sys.argv[i]):
            0. Script name
            1. Function name to call
            2. json
            3. Key
        Output: value
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Load the json as a dictionary
    key = str(sys.argv[3]) #Get the key

    try:
        value = datos_diccionario[key] #Get the value
    except KeyError:
        print("No existe el elemento con la key " + key)
        return
    
    print("Valor: " + value) #Print the value

def parseJsonToCsv():
    """
    ES: Convertir un JSON a CSV
        Argumentos de entrada (sys.argv[i]):
            0. Nombre del script
            1. Nombre de la función a llamar
            2. json
        Salida: csv
    EN: Convert a JSON to CSV
        Input arguments (sys.argv[i]):
            0. Script name
            1. Function name to call
            2. json
        Output: csv
    """
    jsonString = sys.argv[2]
    # Convert the JSON string to a dictionarys
    json_data = json.loads(jsonString)
    # Create a StringIO object to store the CSV data
    csv_output = io.StringIO()
    # Create a CSV writer using the StringIO object
    writer = csv.writer(csv_output)
    # Write the header row
    writer.writerow(json_data.keys())
    # Write the data rows
    writer.writerow(json_data.values())
    # Get the CSV content as a string
    csv_string = csv_output.getvalue()
    print("csv_string: ")
    print(csv_string)

def writeJsonToFile():
    """
    ES: Escribir un JSON en un archivo
        Argumentos de entrada (sys.argv[i]):
            0. Nombre del script
            1. Nombre de la función a llamar
            2. json
            3. Nombre del archivo de salida
        Salida: None
    EN: Write a JSON to a file
        Input arguments (sys.argv[i]):
            0. Script name
            1. Function name to call
            2. json
            3. Output file name
        Output: None
    """
    jsonString = sys.argv[2]
    ruta = "./src/main/java/japy/json/"
    outputFile = open(ruta+sys.argv[3], "w") #Abrimos el archivo de salida
    outputFile.write(formatJson(jsonString)) #Escribimos el json
    outputFile.close() #Cerramos el archivo de salida
    print("Json escrito en el archivo " + sys.argv[3])

#ES: Método main
#EN: Main method
def main():
    print("Argumentos: "+str(sys.argv))
    if len(sys.argv) < 2:
        print("Debe proporcionar el nombre de la función a llamar como argumento")
        return
    function_name = sys.argv[1]
    if function_name == "cambiarTelefono":
        cambiarTelefono()
    elif function_name == "consultarLocalizacion":
        consultarLocalizacion()
    elif function_name == "agnadirElemento":
        agnadirElemento()
    elif function_name == "eliminarElemento":
        eliminarElemento()
    elif function_name == "encontrarValor":
        encontrarValor()
    elif function_name == "parseJsonToCsv":
        parseJsonToCsv()
    elif function_name == "writeJsonToFile":
        writeJsonToFile()
    else:
        print("Función desconocida: " + function_name + ".")

if __name__ == '__main__':
    #ES: No se ejecuta si es un modulo importado
    #EN: It is not executed if it is an imported module
    main()
