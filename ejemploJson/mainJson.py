import sys
import json


def cambiarTelefono():
    datos_diccionario = json.loads(sys.argv[2]) #Cargamos el json como diccionario
    datos_diccionario["cliente"]["telefono"] = str(sys.argv[3]) #Modificamos el teléfono
    modificado = json.dumps(datos_diccionario) #Convertimos el diccionario a json
    print(modificado) #Imprimimos el json modificado


def main():
    if len(sys.argv) < 2:
        print("Debe proporcionar el nombre de la función a llamar como argumento")
        return

    function_name = sys.argv[1]
    
    if function_name == "cambiarTelefono":
        print("Hola")
        print(str(sys.argv[2]))
        cambiarTelefono()
    else:
        #print("Hey, voy a llamar a la función: " + function_name)
        print("Función desconocida: " + function_name + ".")
        
if __name__ == '__main__':
    #No se ejecuta si es un módulo importado
    main()
