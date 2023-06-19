import sys
import json
import io 
import csv

"""
Los argumentos de entrada del script son los siguientes: 
    0. Nombre del script
    1. Nombre de la función a llamar
    2. Archivo json
    3-N. Otros argumentos
"""

def cambiarTelefono():
    """
    Argumentos de entrada (sys.argv[i]): 
        0. Nombre del script
        1. Nombre de la función a llamar
        2. json
        3. Teléfono
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Cargamos el json como diccionario
    datos_diccionario["telefono"] = str(sys.argv[3]) #Modificamos el teléfono
    modificado = json.dumps(datos_diccionario) #Convertimos el diccionario a json
    """outputFile = open("outputData.json", "w") #Abrimos el archivo de salida
    outputFile.write(modificado) #Escribimos el json modificado
    outputFile.close() #Cerramos el archivo de salida"""
    print("Modificado: ")
    print(modificado) #Imprimimos el json modificado

def consultarLocalizacion():
    """
    Argumentos de entrada (sys.argv[i]): 
        0. Nombre del script
        1. Nombre de la función a llamar
        2. json
        3. Nombre
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Cargamos el json como diccionario
    nombre = str(sys.argv[3]) #Obtenemos el nombre
    localizacion = datos_diccionario["localizacion"] #Obtenemos la localización
    print("Localización de " + nombre + ": " + localizacion) #Imprimimos la localización

def agnadirElemento():
    """
    Argumentos de entrada (sys.argv[i]):
        0. Nombre del script
        1. Nombre de la función a llamar
        2. json
        3. Key
        4. Value
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Cargamos el json como diccionario
    key = str(sys.argv[3]) #Obtenemos la key
    value = str(sys.argv[4]) #Obtenemos el value
    datos_diccionario[key] = value #Añadimos el elemento
    modificado = json.dumps(datos_diccionario) #Convertimos el diccionario a json
    print("Elemento añadido: ")
    print(modificado) #Imprimimos el json modificado

def eliminarElemento():
    """
    Argumentos de entrada (sys.argv[i]):
        0. Nombre del script
        1. Nombre de la función a llamar
        2. json
        3. Key
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Cargamos el json como diccionario
    key = str(sys.argv[3]) #Obtenemos la key
    try:
        del datos_diccionario[key] #Eliminamos el elemento
    except KeyError:
        print("No existe el elemento con la key " + key)
        return
    modificado = json.dumps(datos_diccionario) #Convertimos el diccionario a json
    print("Elemento eliminado: ")
    print(modificado) #Imprimimos el json modificado

def encontrarValor():
    """
    Argumentos de entrada (sys.argv[i]):
        0. Nombre del script
        1. Nombre de la función a llamar
        2. json
        3. Key
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Cargamos el json como diccionario
    key = str(sys.argv[3]) #Obtenemos la key
    try:
        value = datos_diccionario[key] #Obtenemos el valor
    except KeyError:
        print("No existe el elemento con la key " + key)
        return
    print("Valor: " + value) #Imprimimos el valor

def parseJsonToCsv():
    """
    Argumentos de entrada (sys.argv[i]):
        0. Nombre del script
        1. Nombre de la función a llamar
        2. json
    """
    jsonString = sys.argv[2]
    # Convertir el JSON string a un objeto JSON
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
    

def main():
    print("hola mundo, esto es el main de jsonAsParameterExample.py")
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
    else:
        print("Función desconocida: " + function_name + ".")

if __name__ == '__main__':
    #No se ejecuta si es un modulo importado
    main()
