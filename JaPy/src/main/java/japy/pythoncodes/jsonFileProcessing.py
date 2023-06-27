import sys
import json
import os

"""
ES:
    Los argumentos de entrada del script son los siguientes: 
        0. Nombre del script
        1. Nombre de la función a llamar
        2-N. Otros argumentos
    Nota: los print en cada método son para que java pueda obtener los valores de retorno
EN:
    The input arguments of the script are the following:
        0. Script name
        1. Function name to call
        2-N. Other arguments
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

def procesarJsonDefault():
    """
    ES: Procesar el json
        Argumentos de entrada (sys.argv[i]): 
            0. Nombre del script
            1. Nombre de la función a llamar
            2. Ruta del archivo de entrada
            3. Ruta del archivo de salida
        Salida: json guardado en el archivo de salida
    EN: Process the json
        Input arguments (sys.argv[i]):
            0. Script name
            1. Function name to call
            2. Input file path
            3. Output file path
        Output: json saved in the output file
    """
    try:
        jsonInputFile = open(sys.argv[2], "r") #Open the input file
        jsonString = jsonInputFile.read() #Read the json

        jsonDict = json.loads(jsonString) #Convert the json to a dictionary
        print("Json leído del archivo " + sys.argv[2])
        print(jsonDict)

        jsonDict["telefono"] = str("123-456-789") #Modify the phone
        jsonString = json.dumps(jsonDict) #Convert the dictionary to a json
        jsonString = formatJson(jsonString) #Format the json

        outputFile = open(sys.argv[3], "w") #Open the output file
        outputFile.write(jsonString) #Write the json
        print("Json escrito en la ruta" + sys.argv[3])

        outputFile.close() #Close the output file
        jsonInputFile.close() #Close the input file
    except Exception as e:
        print("Error: " + str(e))

def main():
    #ES: Funcion main
    #EN: Main function
    print("Argumentos recibidos en Python: "+str(sys.argv))
    if len(sys.argv) < 2:
        print("Debe proporcionar el nombre de la función a llamar como argumento")
        return
    function_name = sys.argv[1]
    if function_name == "procesarJsonDefault":
        procesarJsonDefault()
    else:
        print("Debe proporcionar el nombre de la función a llamar como argumento")
        return
    return 

if __name__ == "__main__":
    #ES: No se ejecuta si se importa como módulo
    #EN: It is not executed if it is imported as a module
    main()