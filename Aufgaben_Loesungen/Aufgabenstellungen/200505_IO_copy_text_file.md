# Aufgabe 'Copy file'

###### A1
Erstellen Sie eine Klasse `FileUtils`. Definieren Sie eine Methode `copyTextFile` mit 2 String-Parameter 'fromFile' und 'toFile', die folgendermaßen aufgerufen werden kann:

		copyTextFile("source.txt", "copy.txt");

Die Methode soll die Datei "fromFile" in eine Datei "toFile" kopieren.

###### A2
- Überlegen Sie wie die Methoden definiert werden sollte für den Fall, dass die Datei 'source.txt' nicht gefunden werden kann
- Überlegen Sie wie die Methoden definiert werden sollte für den Fall, dass die Datei 'copy.txt' bereits vorhanden ist


###### A3. Optional.
Überladen Sie die Methode und fügen Sie dabei einen weiteren Parameter 'boolean append' hinzu, der definiert, ob die Zieldatei überschrieben oder erweitert werden darf, wenn sie bereits existiert.

###### A4. Optional.
Erzeugen Sie eine einfache Konsolenanwendung, die zwei Argumente für die main-Methode erwartet und damit die `copyTextFile` aufruft. 
Das erste Argument ist der Pfad zu der zu kopierenden Textdatei.
Das zweite Argument ist der Pfad zu der zu erzeugenden Kopie.

Über das Ergebnis und/oder Probleme sollte die Anwendung mit Konsolenausgaben berichten. 
