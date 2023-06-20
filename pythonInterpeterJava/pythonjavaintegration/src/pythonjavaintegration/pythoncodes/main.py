def saludar():
    """
    ES: imprime un saludo
    EN: print a greeting
    """
    print("Hola desde Python")

def saludar2():
    """
    ES: imprime un saludo
    EN: print a greeting
    """
    print("Hola desde Python 2")

def suma(a, b):
    """
    ES: suma dos numeros
    EN: sum two numbers
    """
    return a + b

#ES: Método main
#EN: main method
def main():
    saludar2()

if __name__ == '__main__':
    #ES: no se ejecuta si es un modulo importado
    #EN: it is not executed if it is an imported module
    main()
    