# Aufgabe 'Map - FileTypes'

- Erstellen Sie eine Klasse 'FileTypes'


- Definieren Sie einen Konstruktor für die Klasse 'FileTypes', an den man ein String übergeben kann:

		FileTypes ft = new FileTypes("C:\\Windows");


- Definieren Sie eine Methode 'getFileTypes' in der Klasse 'FileTypes', die eine Collection von Strings liefert, in der die alle auftretenden Datei-Erweiterungen eines Verzeichnisses (s. Konstruktor) aufgelistet sind und einmalig auftauchen:

		Collection<String> extColl = ft.getFileTypes();


- Geben Sie die gefundenen Datei-Erweiterungen aus


- Erweitern (ändern) Sie die Klasse so, dass es möglich ist zu erfahren, wieviele Dateien mit einer bestimmten Erweiterung es in dem untersuchten Verzeichnis gibt.

> Tipp: in einer Map könnte man eine Datei-Erweiterung der Anzahl der Dateien zuordnen


- Optional. Geben Sie die Daten sortiert nach Anzahl der Dateien aus.
