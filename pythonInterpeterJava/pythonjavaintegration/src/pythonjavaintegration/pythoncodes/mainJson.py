import sys
import json


def cambiarTelefono():
    jsonFile = open(sys.argv[2], "r") #Abrimos el archivo json (sys.argv[2] es el nombre del archivo
    datos = jsonFile.read() #Leemos el archivo
    datos_diccionario = json.loads(datos) #Cargamos el json como diccionario

    datos_diccionario["cliente"]["telefono"] = str(sys.argv[3]) #Modificamos el teléfono
    modificado = json.dumps(datos_diccionario) #Convertimos el diccionario a json

    outputFile = open("outputData.json", "w") #Abrimos el archivo de salida
    outputFile.write(modificado) #Escribimos el json modificado

    outputFile.close() #Cerramos el archivo de salida
    jsonFile.close() #Cerramos el archivo json

    print(modificado) #Imprimimos el json modificado


def main():
    if len(sys.argv) < 2:
        print("Debe proporcionar el nombre de la función a llamar como argumento")
        return

    function_name = sys.argv[1]
    
    if function_name == "cambiarTelefono":
        cambiarTelefono()
    else:
        print("Función desconocida: " + function_name + ".")
        
if __name__ == '__main__':
    #No se ejecuta si es un módulo importado
    main()
