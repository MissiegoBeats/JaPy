import sys

"""
Los argumentos de entrada del script son los siguientes: 
    0. python
    1. Nombre del script
    2. Nombre de la función a llamar
    3. Archivo json
    4-N. Otros argumentos
"""

def cambiarTelefono():
    """
    Argumentos de entrada (sys.argv[i]): 
        0. python
        1. Nombre del script
        2. Nombre de la función a llamar
        3. Archivo json
        4. Teléfono
    """
    datos_diccionario = json.loads(sys.argv[3]) #Cargamos el json como diccionario

    datos_diccionario["cliente"]["telefono"] = str(sys.argv[4]) #Modificamos el teléfono
    modificado = json.dumps(datos_diccionario) #Convertimos el diccionario a json

    outputFile = open("outputData.json", "w") #Abrimos el archivo de salida
    outputFile.write(modificado) #Escribimos el json modificado

    outputFile.close() #Cerramos el archivo de salida
    jsonFile.close() #Cerramos el archivo json

    print(modificado) #Imprimimos el json modificado

def main():
    print("hola mundo, esto es el main de jsonAsParameterExample.py")
    print("Argumentos: "+str(sys.argv))

    if len(sys.argv) < 2:
        print("Debe proporcionar el nombre de la función a llamar como argumento")
        return

    function_name = sys.argv[1]
    
    if function_name == "cambiarTelefono":
        cambiarTelefono()
    else:
        print("Función desconocida: " + function_name + ".")

if __name__ == '__main__':
    #No se ejecuta si es un modulo importado
    main()
