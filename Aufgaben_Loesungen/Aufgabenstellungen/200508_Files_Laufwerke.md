# Aufgabe 'Laufwerke'

###### A1.
Definieren Sie in einer Klasse "Laufwerke" eine statische Methode "print". Die Methode soll für alle Laufwerke eine formatierte Tabelle auf der Konsole ausgeben. Die Tabelle soll folgende Form haben:

		|   LW  |     usable(MB)|     total(MB) |
		|   C:\ |            ...|            ...|
		|   D:\ |            ...|            ...|
		...

Die Spalte "LW" beinhaltet den Laufwerknamen. In den restlichen Spalten werden der benutzbare und der gesamte Speicher für das jeweilige Laufwerk angezeigt. Die Ausgaben erfolgen in Megabyte (MB). 

> Tipp: So können die aktuellen Laufwerke ermittelt werden:

		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		
> Tipp: Mit der Methode `format(String format, Object... args)` kann eine Tabelle mit den vordefinierten Spaltenbreiten erzeugt werden.


> Tipp: Die Werte für die Spalten "usable", und "total" können Sie so ermitteln:

		FileStore store = Files.getFileStore(root);
		long total = store.getTotalSpace();
		long available = store.getUsableSpace();
 

###### A2.
Sortieren Sie bitte die Daten nach der Spalte "Frei" und geben Sie die aus.

###### A3.
Speichern Sie die Tabelle in einer Textdatei.

###### A4. Optional
Gestalten Sie bitte die Anwendung interaktiv. Der Benutzer darf sich entscheiden ob die Speicherangaben in Gigabyte, Megabyte oder Kilobyte erscheinen. Setzen Sie die Klasse `java.io.Console` für das Auslesen der Benutzereingaben ein.
