import argparse
import requests
import json

parser = argparse.ArgumentParser(description='Finds the stadiums')
parser.add_argument('team', metavar='team', type=str, help='Enter your team')
parser.add_argument('--league', '-l', metavar='league', type=str, help='Enter your league')
parser.add_argument('--country', '-c', metavar='country', type=str, help='Enter your country')
args = parser.parse_args()

def getArsenalInfo():
    """
    ES: Obtener información del Arsenal
    EN: Get Arsenal info
    Note: this is a simple example of use of argparse
    """
    try:
        team = args.team
        print("Team: "+team)
        if(args.league):
            print("League: "+args.league)
        if(args.country):
            print("Country: "+args.country)
    except Exception as e:
        print("Error: "+str(e))

def main():
    #ES: Metodo main
    #EN: Main method
    getArsenalInfo()

if __name__ == "__main__":
    #ES: No se ejecuta si se importa como modulo
    #EN: It doesn't run if it is imported as a module
    main()