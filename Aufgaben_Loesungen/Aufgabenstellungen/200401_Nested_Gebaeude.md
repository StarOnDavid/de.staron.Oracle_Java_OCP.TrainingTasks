# Aufgabe 'Innere Klassen - Gebäude'

- Erzeugen Sie eine Klasse "Gebaeude", die der folgenden Beschreibungen entspricht (benutzen Sie innere Klassen für die Typen "Stockwerk" und "Raum"):


- Ein Gebäude kann 1 oder mehrere Stockwerke haben. Ein Stockwerk hat mindestens 1 Raum.


- Definieren Sie für die Klasse "Gebaeude" einen Konstruktor, an den Sie die den Strassennamen, die Hausnummer, die Anzahl von Stockwerke und die Anzahl von Räumen pro Stockwerk übergeben können.


- Erstellen Sie ein Objekt von Typ "Gebaeude". Dabei soll ein Gebäude auf der Hauptstr. 45 mit 3 Stockwerken und 10 Räume pro Stockwerk entstehen. 


- Definieren Sie für die Klasse "Gebaeude" die Methode getStockwerk(int stockwerkNr), die die Referenz auf das Objekt von Typ "Stockwerk" liefert.


- Definieren Sie für die Klasse "Gebaeude" die Methode getRaum(int stockwerkNr, int raumNr), die die Referenz auf das Objekt von Typ "Raum" liefert.


- Benutzen Sie die Methode "getRaum" für das erstellte Gebäude mit den Argumenten 0 und 2.


- Geben Sie die von der Methode gelieferte Referenz auf der Konsole aus. Die Ausgabe soll dabei folgende Form haben:
  
        Raum 0.2 / Hauptstr. 45
