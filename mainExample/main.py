import sys

def saludar():
    # Lógica de la función "saludar"
    print('Hola mundo ' + str(sys.argv))

def otra_funcion():
    # Lógica de la otra función
    print('Otra función ' + str(sys.argv))

def cumpleagnos():
    sys.argv[3] = int(str(sys.argv[3])) + 1
    print(str(sys.argv)) #Nota: con print "devolvemos" el valor de la función que queremos usar en java!

def main():
    if len(sys.argv) < 2:
        print("Debe proporcionar el nombre de la función a llamar como argumento")
        return

    function_name = sys.argv[1]

    #TODO: mejorar?
    
    if function_name == "saludar":
        saludar()
    elif function_name == "otra_funcion":
        otra_funcion()
    elif function_name == "cumpleagnos":
        cumpleagnos()
    else:
        print("Función desconocida: " + function_name)

if __name__ == '__main__':
    main()
