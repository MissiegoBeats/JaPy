#ES: Importamos los módulos necesarios
#EN: Import the necessary modules
import sys
import json

def cambiarTelefono():
    """
    ES: Modificar el teléfono
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
    jsonFile = open(sys.argv[2], "r") #Open the json file
    datos = jsonFile.read() #Read the json file
    datos_diccionario = json.loads(datos) #Load the json as a dictionary

    datos_diccionario["cliente"]["telefono"] = str(sys.argv[3]) #Modify the phone
    modificado = json.dumps(datos_diccionario) #Convert the dictionary to json

    outputFile = open("outputData.json", "w") #Open the output file
    outputFile.write(modificado) #Write the modified json

    outputFile.close() #Close the output file
    jsonFile.close() #Close the json file

    print(modificado) #Print the modified json

#ES: Método main
#EN: main method
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
    #ES: No se ejecuta si es un módulo importado
    #EN: It is not executed if it is an imported module
    main()
