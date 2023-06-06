import sys

def saludar():
    print('Hola mundo '+str(sys.argv))

def main():
    saludar()

if __name__ == '__main__':
    #No se ejecuta si es un archivo importado
    main()