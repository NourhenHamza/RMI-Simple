# RMI-Simple
 

Ce projet implémente une calculatrice à distance utilisant Java RMI (Remote Method Invocation). La calculatrice prend en charge les opérations d'addition, de soustraction, de multiplication et de division.

## Structure du Projet

1. **RmiCalculatorInterface.java**

   Cette interface définit les méthodes de calcul que le serveur RMI prend en charge. Les méthodes comprennent add, subtract, multiply et divide. Cette interface doit être partagée entre le serveur et le client pour assurer la communication correcte entre les deux.

2. **RmiCalculatorServer.java**

   Cette classe implémente l'interface RmiCalculatorInterface et crée un serveur RMI. Le serveur expose les méthodes de calcul via RMI et les rend accessibles aux clients. Il démarre un registre RMI sur le port par défaut (1099) et lie l'objet distant (stub) de la calculatrice.

3. **RmiCalculatorClient.java**

   Ce client utilise RMI pour se connecter au serveur, invoquer les méthodes de calcul et afficher les résultats. Le client interagit avec l'utilisateur pour saisir les opérations et les opérandes. Il recherche l'objet distant (stub) de la calculatrice dans le registre RMI, puis utilise ce stub pour effectuer des appels distants aux méthodes de calcul sur le serveur.

 
