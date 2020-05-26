# -*- coding: utf-8 -*-
from tkinter import *
from threading import Thread
import socket

######################################################################""

WindowTitle = 'JChat v0.1 - Client'
hote = "localhost"
port = 12800
connexion_avec_serveur = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
connexion_avec_serveur.connect((hote, port))
print("Connexion établie avec le serveur sur le port {}".format(port))

######################################################################""""

def receive():
    """Handles receiving of messages."""
    while True:
        try:
            msg = connexion_avec_serveur.recv(1024).decode("utf8")
            msgClient.insert(END,msg)
        
        except OSError:  # Possibly client has left the chat.
            break
	
def ClickAction(event=None):

    ms = connexion_avec_serveur.send((entree.get().encode()))
    value.set("  ")
    if ms == "quit":
        connexion_avec_serveur.close()
        base.quit()

    
def quiter ():
    connexion_avec_serveur.close()
    base.quit()

########################################################################"""
base = Tk()
base.title(WindowTitle)
base.geometry("400x500")

#################################################################################""
ChatLog = Text(base, bd=0, bg="white", height="8", width="50", font="Arial",)
ChatLog.insert(END, "Connexion établie avec le serveur sur le port {}".format(port))
ChatLog.config(state=DISABLED)
ChatLog.place(x=6,y=6, height=386, width=370)


ChatLoge = Text(base, bd=0, bg="white", height="8", width="50", font="Arial",)
ChatLoge.insert(END, "Zone de texte")
ChatLoge.config(state=DISABLED)
ChatLoge.place(x=6,y=50, height=60, width=100)


###################################################################################""
value = StringVar()
value.set("votre nom d'utilisateur")
entree = Entry(base, textvariable=value, width=60, )
entree.place(x=6,y=	80, height=50)
entree.bind("<Return>", ClickAction)

#########################################################################""
msgClient = Listbox(base, height=15, width=60,)
msgClient.place(x=6,y= 150, height=200)

####################################################################################"""

SendButton = Button(base, font=30, text="Send", width="12", height=5, bd=0, bg="#FFBF00", activebackground="#FACC2E",command=ClickAction)
SendButton.place(x=6, y=401, height=90)

QuitButton = Button(base, font=30, text="Quit", width="12", height=12, bd=0, bg="#FFBF00", activebackground="#FACC2E",command=quiter)
QuitButton.place(x=260, y=401, height=90)

####################################################################################
receive_thread = Thread(target=receive)
receive_thread.start()

base.mainloop()
