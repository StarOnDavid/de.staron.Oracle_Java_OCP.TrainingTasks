# Aufgabe 'PriorityQueue'

- Definieren Sie eine Klasse 'Task' mit der man eine Liste der geplannten Aufgaben realisieren kann. Jedes Object der Klasse 'Task' hat die Aufgabenbeschreibung als String und die Aufgabenpriorität als einen der drei möglichen konstanten Werten: LOW, NORMAL oder HIGH. 


- Erzeugen sie folgende Instanzen der Klasse 'Task': 

    'Autowäsche', Priorität: LOW 
    'Einkaufen', Priorität: NORMAL 
    'Rechnung bezahlen', Priorität: HIGH. 

Speichern Sie die drei Tasks in einer PriorityQueue


- Mit der poll-Methode soll die PriorityQueue geleert werden. Dabei sollen die entfernten Elemente ausgegeben werden. Die Tasks mit den höheren Prioritäten (HIGH ist höher als NORMAL ist höher als LOW) sollen die Queue dabei zuerst verlassen.


- Optional. Führen Sie in der Klasse 'Task' die Möglichkeit ein den Termin einer Task zu setzen. Der Termin soll dann auch bei der Ermittlung der Reihenfolge der Tasks berücksichtigt werden. 
