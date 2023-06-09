def saludar():
    print("Hola desde Python")

def saludar2():
    print("Hola desde Python 2")

def suma(a, b):
    return a + b

def main():
    saludar2()

if __name__ == '__main__':
    #ES: no se ejecuta si es un modulo importado
    #EN: it is not executed if it is an imported module
    main()
    