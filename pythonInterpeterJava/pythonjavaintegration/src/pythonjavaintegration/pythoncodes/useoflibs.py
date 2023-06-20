#ES: Importamos las librerias necesarias
#EN: Import the necessary libraries
import sys
import pymysql
import pandas as pd
import logging
import getopt 
#Import of getopt is ok so code will work in jython (not implemented due to the java code structure implemented)
#To use args in the java code, check mainExample folder (not using jython)
#With PythonInterpreter (set() function), you can set arguments to the python code
import json
import math
import requests
import sockets
import datetime
import jsonify

def useofsys():
    """
    ES: Ejemplo de uso de la libreria sys
    EN: Example of use of sys library
    """
    print("Use of sys")
    print("Path: "+str(sys.path))
    print("Version: "+str(sys.version))
    print("Version info: "+str(sys.version_info))
    print("Executable: "+str(sys.executable))
    print("Platform: "+str(sys.platform))

def useofpandas():
    """
    ES: Ejemplo de uso de la libreria pandas
    EN: Example of use of pandas library
    """
    print("use of pandas")
    df = pd.DataFrame({'col1': [1, 2], 'col2': [3, 4]})
    print(df)

def useoflogging():
    """
    ES: Ejemplo de uso de la libreria logging
    EN: Example of use of logging library
    """
    print("Use of logging")
    logging.basicConfig(filename='./src/pythonjavaintegration/pythoncodes/example.log',level=logging.DEBUG)
    logging.debug(' This message should go to the log file')
    logging.info(' So should this')
    logging.warning(' And this, too')
    print("Log file -> ./src/pythonjavaintegration/pythoncodes/example.log")

def useofgetopt():
    """
    ES: Ejemplo de uso de la libreria getopt
    EN: Example of use of getopt library
    """
    print("Use of getopt")
    """argv = sys.argv[1:]
    try:
        opts, args = getopt.getopt(argv,"hi:o:",["ifile=","ofile="])
    except getopt.GetoptError:
        print('test.py -i <inputfile> -o <outputfile>')
        sys.exit(2)
    for opt, arg in opts:
        if opt == '-h':
            print('test.py -i <inputfile> -o <outputfile>')
            sys.exit()
        elif opt in ("-i", "--ifile"):
            print("Input file: "+arg)
        elif opt in ("-o", "--ofile"):
            print("Output file: "+arg)"""

def useofjson():
    """
    ES: Ejemplo de uso de la libreria json
    EN: Example of use of json library
    """
    print("Use of json")
    x = '{ "name":"John", "age":30, "city":"New York"}'
    y = json.loads(x)
    print(y["age"])
    print(y["name"])

def useofmath():
    """
    ES: Ejemplo de uso de la libreria math
    EN: Example of use of math library
    """
    print("Use of math")
    print("Pi: "+str(math.pi))
    print("E: "+str(math.e))
    print("Cos(0): "+str(math.cos(0)))

def useofrequests():
    """
    ES: Ejemplo de uso de la libreria requests
    EN: Example of use of requests library 
    """
    print("Use of requests")
    x = requests.get('https://w3schools.com/python/demopage.htm')
    print(x.text)

def useofsockets():
    """
    ES: Ejemplo de uso de la libreria sockets
    EN: Example of use of sockets library 
    """
    print("Use of sockets")
    print("Socket: "+str(sockets.gethostname()))

def useofdatetime():
    """
    ES: Ejemplo de uso de la libreria datetime
    EN: Example of use of datetime library 
    """
    print("Use of datetime")
    x = datetime.datetime.now()
    print(x)
    print(x.year)
    print(x.strftime("%A"))

def useofjsonify():
    """
    ES: Ejemplo de uso de la libreria jsonify
    EN: Example of use of jsonify library 
    """
    print("Use of jsonify")
    x = {
        "name": "John",
        "age": 30,
        "city": "New York"
    }
    print(jsonify.dumps(x))

def useofpymysql():
    """
    ES: Ejemplo de uso de la libreria pymysql
    EN: Example of use of pymysql library 
    """
    print("Use of pymysql")
    db = pymysql.connect("localhost","root","root","test")
    cursor = db.cursor()
    cursor.execute("SELECT VERSION()")
    data = cursor.fetchone()
    print("Database version : %s " % data)
    db.close()

def main():
    """
    ES: Funcion principal
    EN: Main function 
    """
    #Printing header
    print("***********************************")
    print("*           Use of libs           *")
    print("***********************************")
    useofsys()
    print("----------------------------------------------------------------------------------")
    useofpandas()
    print("----------------------------------------------------------------------------------")
    useoflogging()
    print("----------------------------------------------------------------------------------")
    useofgetopt()
    print("----------------------------------------------------------------------------------")
    useofjson()
    print("----------------------------------------------------------------------------------")
    useofmath()
    print("----------------------------------------------------------------------------------")
    useofrequests()
    print("----------------------------------------------------------------------------------")
    useofsockets()
    print("----------------------------------------------------------------------------------")
    useofdatetime()
    print("----------------------------------------------------------------------------------")
    useofjsonify()
    print("----------------------------------------------------------------------------------")
    useofpymysql()
    print("----------------------------------------------------------------------------------")

if __name__ == "__main__":
    #ES: No se ejecuta si se importa como modulo
    #EN: It is not executed if it is imported as a module
    main()