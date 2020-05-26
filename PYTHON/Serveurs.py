#!/usr/bin/env python3
""" chat application."""
from socket import AF_INET, socket, SOCK_STREAM
from threading import Thread


def accept_incoming_connections():
    """Configure la gestion des clients entrants."""
    while True:
        client, client_address = SERVER.accept()
        print("%s:%s client connecte." % client_address)
        client.send(bytes("Reception", "utf8"))
        clients[client]= client_address
        Thread(target=connexion_client, args=(client,)).start()


def connexion_client(client):   
    """Gère une seule connexion client"""

    name = client.recv(DEC).decode("utf8") 
    welcome = name
    client.send(bytes(welcome, "utf8"))
    msg =  name + str(client)
    broadcast(bytes(msg, "utf8" ))
    addresses[client] = name

    while True:
        msg = client.recv(DEC)
        if msg != bytes("quit", "utf8"):
            broadcast(msg, name+": ")
        else:
            client.send(bytes("quit", "utf8"))
            client.close()
            del clients[client]
            broadcast(bytes("%s à quitté la discussion." % name, "utf8"))
            break


def broadcast(msg, prefix=""):  #  le préfixe est pour l'identification du nom
    """Diffuse un message à tous les clients.""" 


    for sock in clients:
        sock.send(bytes(prefix, "utf8")+msg)



       
                
clients = {}
addresses = {}

HOST = ''
PORT = 12800
DEC  = 1024
ADDR = (HOST, PORT)

SERVER = socket(AF_INET, SOCK_STREAM)
SERVER.bind(ADDR)

if __name__ == "__main__":
    SERVER.listen(5)
    print("Attente de connexion...")
    ACCEPT_THREAD = Thread(target=accept_incoming_connections)
    ACCEPT_THREAD.start()
    ACCEPT_THREAD.join()
    SERVER.close()