# Aufgabe 'FilesCounter'

> Setzen Sie bitte für die Lösung die Möglichkeiten ein, die die Klasse `java.nio.file.Files` anbietet. 

###### A1.
Erstellen Sie eine Klasse `FilesCounter`. Erzeugen Sie in der main-Methode der Klasse `Test` ein Objekt vom Typ `FilesCounter`:

		FilesCounter fc = new FilesCounter("C:\\Windows");

Dabei wird als Argument ein Verzeichnisname übergeben.


###### A2.
Folgender Aufruf muss die Dateien im Verzeichnis "C:\\Windows" (s. den Konstruktoraufruf) (aber nicht in Unterverzeichnissen) zählen:

		int anzahl = fc.countFlat("txt");

Geben Sie die ermittelte Anzahl der txt-Dateien auf der Konsole aus.


###### A3.
Folgender Aufruf muss rekursiv die Dateien im Verzeichnis "C:\\Windows" (s. den Konstruktoraufruf) und allen Unterverzeichnissen zählen:

		int anzahl = fc.countDeep("txt");

Geben Sie die ermittelte Anzahl der txt-Dateien auf der Konsole aus.

###### A4. Optional
Überlegen Sie unterschiedliche Realisierungen der Methode `countDeep`, die intern unterschiedlich die Verzeichnisse durchsuchen (z.B. mit Files.list, Files.walk, Files.walkFileTree, File.listFiles...). Testen Sie grob die Perfomance von 2 oder 3 solchen Realisierungen.

###### A5. Optional
Falls noch nicht geschehen, gestalten Sie die Lösung so, dass die Gross-/Kleinschreibung der Erweiterung ignoriert wird. 

###### A6. Optional
Gestalten Sie eine einfache Konsolenanwendung, die bis zur drei Argumente für die main-Methode erwartet:

- Das erste Argument ist der Pfad zu dem zu untersuchenden Verzeichnis.
- Das zweite Argument ist die Erweiterung der zu zählenden Dateien.
- Das dritte optionale (!) Argument gibt an, mit welcher Periodizität die Anwendung die Anzahl der gefundenen Dateien auf der Könsole ausgeben soll. 

Die Anwendung übernimmt diese Angaben und ermittelt die Anzahl der Dateien rekursiv.
Falls das dritte Argument existiert und sich zur einer Positiven Zahl X parsen lässt, soll die Anwendung jeden X-ten Treffer auf der Konsole bekanntgeben, ansonsten präsentiert die Anwendung keine Zwischenberichte. 
Am Ende wird die Anzahl der gefundenen Dateien sowie die für die Suche verbrauchte Zeit ausgegeben. 
Bei einem Fehler sollte die Anwendung den Fehler mit einer einfachen Konsolenausgabe behandeln und danach beendet werden.

###### A6. Optional
Ändern Sie die Lösung der Aufgaben A1, A2 und A3 so, dass `FilesCounter` ein Interface wird. Die bereits vorhandene Lösung übertragen Sie in die konkrete Klasse `FilesCounterV1`. Erstellen Sie eine alternative Lösung in der neuen Klasse `FilesCounterV2` und verwenden Sie für die Realisierung die Möglichkeiten der Klasse `java.io.File`. Testen Sie die beiden Alternativen Lösungen.
