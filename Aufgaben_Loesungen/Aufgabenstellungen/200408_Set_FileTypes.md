# Aufgabe 'Set - FileTypes'

- Erstellen Sie eine Klasse 'FileTypes'


- Definieren Sie einen Konstruktor für die Klasse 'FileTypes', an den man ein String übergeben kann:

		FileTypes ft = new FileTypes("C:\\Windows");


- Definieren Sie eine Methode 'getFileTypes' in der Klasse 'FileTypes', die eine Collection von Strings liefert, in der die alle auftretenden Datei-Erweiterungen eines Verzeichnisses (s. Konstruktor) aufgelistet sind und einmalig auftauchen:

		Collection<String> extColl = ft.getFileTypes();

> Tipp: Benutzen Sie die Klasse `java.io.File` um die Dateien in einem Verzeichniss aufzulisten.
> Entscheiden Sie selbst, ob auch die Dateien in den Unterverzeichnissen gesucht werden   

- Geben Sie die gefundenen Datei-Erweiterungen aus
