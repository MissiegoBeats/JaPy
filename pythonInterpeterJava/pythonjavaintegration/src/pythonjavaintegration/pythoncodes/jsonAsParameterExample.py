import sys
import json

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
        2. Archivo json
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
        2. Archivo json
        3. Nombre
    """
    jsonString = sys.argv[2]
    datos_diccionario = json.loads(jsonString) #Cargamos el json como diccionario
    nombre = str(sys.argv[3]) #Obtenemos el nombre
    localizacion = datos_diccionario[nombre] #Obtenemos la localización
    print("Localización de " + nombre + ": " + localizacion) #Imprimimos la localización

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
    else:
        print("Función desconocida: " + function_name + ".")

if __name__ == '__main__':
    #No se ejecuta si es un modulo importado
    main()
