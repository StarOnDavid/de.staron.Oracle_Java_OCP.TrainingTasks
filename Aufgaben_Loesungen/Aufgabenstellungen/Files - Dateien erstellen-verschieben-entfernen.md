# Aufgabe 'Dateien erstellen - verschieben - entfernen'

> Benutzen Sie bitte für die Lösung die Methode(n) aus der Klasse `java.nio.file.Files`

#### A1.
Entwickeln Sie eine Methode 'createFiles' die so deklariert wird:
    
		static void createFiles(String root, String prefix, String extension, int count)

Wenn die Methode aufgerufen wird, erzeugt sie 'count' leere Dateien mit der Erweiterung 'extension' und mit dem Präfix 'prefix' im Verzeichnis 'root'. 

  Z.B.:

		String root = ".";
		createFiles(root, "file", "txt", 30);

In diesem Beispiel werden 30 leere Dateien im aktuellen Arbeitsverzeichnis erzeugt. Die Dateien müssen dann die Namen nach dem Muster erhalten:

		file001.txt
		file002.txt
		file003.txt
		...
		file030.txt

Die Anzahl der Ziffern im generierten Dateinamen ist mindestens 3.

> Tipp. Die Methode `format` der Klasse `String` ist fähig Zahlen mit der gewünschten Mindestanzahl der Zeichen zu formatieren:

	String s = String.format("file%03d.txt", 12); // s = "file012.txt"

#### A2.
Definieren Sie eine weitere Methode 'moveFiles' die so deklariert wird:

		static void moveFiles(String sourceRoot, String targetRoot, String extension)

Die Methode sollte alle Dateien mit der Erweiterung 'extension' aus dem Verzeichnis 'sourceRoot' in das Verzeichnis 'targetRoot' verschieben. Falls das Ziel Verzeichnis (Verzeichnisse) nicht existiert, sollte es erzeugt werden.

#### A3.
Definieren Sie eine weitere Methode 'deleteFiles' die so deklariert wird:
    
		static void deleteFiles(String root, String extension)

Die Methode löscht alle Dateien mit der Erweiterung 'extension' aus dem Verzeichnis 'root'
