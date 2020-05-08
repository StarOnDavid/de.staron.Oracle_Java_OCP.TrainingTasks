# Aufgabe "Verzeichnisse"

> Benutzen Sie bitte für die Lösung die Methode(n) aus der Klasse `java.nio.file.Files`


- Definieren Sie eine Methode `printSubdirs` mit dem Parameter von Typ `java.nio.file.Path` mit dem Namen `dir`.  Die Methode soll für das Verzeichnis `dir` alle Unterverzeichnisse auf der Konsole auflisten.


- Definieren Sie eine weitere Methode `printFiles` mit dem Parameter von Typ `java.nio.file.Path` mit dem Namen `dir`. Die Methode soll für ein Verzeichnis `dir` alle Dateien auf der Konsole auflisten.


- Erstellen Sie ein Methode `createDirs(String)` die folgendermaßen aufgerufen werden kann:
 
    createDirs("a\\b\\c\\d");
 
 Die Methode erzeugt dann die beschriebene Verzeichnisstruktur.


- Erstellen Sie ine Methode `deleteDirs(String)` die folgendermaßen aufgerufen werden kann:
 
	deleteDirs("a\\b\\c\\d");

 Die Methode löscht dann die Verzeichnisse, aber nur wenn sie keine weiteren Elemente beinhalten. Das Parent-Verzeichnis für das Verzeichnis 'a' darf nicht gelöscht werden.

