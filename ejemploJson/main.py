import sys

def procesarJson():
    pass

def main():
    if len(sys.argv) < 2:
        print("Debe proporcionar el nombre de la función a llamar como argumento")
        return

    function_name = sys.argv[1]
    
    if function_name == "procesarJson":
        procesarJson()
    else:
        print("Función desconocida: " + function_name)

if __name__ == '__main__':
    #No se ejecuta si es un módulo importado
    main()
