# Aufgabe 'save/load Array'

###### A1.
Legen Sie bitte ein int-Array der Länge 'len' an und füllen Sie das Array mit Zufallswerten aus dem Bereich -20 bis 20.
Die Länge des Arrays soll auch zufällig sein und zwischen 1 bis 100 liegen. Das Erzeugen und Füllen des Arrays soll die Methode `int[] createArray(int length, int min, int max)` übernemen:

		int len = new java.util.Random().nextInt(100) + 1;
		int[] arr1 = createArray(len, -20, 20);

###### A2.
Speichern Sie das int-Array in einer Datei. 
Erstellen Sie dafür die Methode `void saveArray(int[] array, String fileName)`:

		saveArray(arr1, "array.txt");

###### A3.
Laden Sie die Werte aus der Datei in ein neues int-Array.
Erstellen Sie dafür die Methode `int[] loadArray(String fileName)`:

    	int[] arr2 = loadArray("array.txt");

###### A4.
Geben Sie bitte das alte und das neue Array aus. Die beiden Arrays müssen gleiche Werte beinhalten.

###### A5. Optional.
Erstellen Sie eine neue Konsolenanwendung in der der User entscheiden darf ob er ein int-Array erzeugen oder laden möchte.
- Erzeugen.
    - Die Anwendung fragt den User, wie groß das Array sein soll. 
    - Die Anwendung fragt den User, wie die Datei heißen soll, in der das Array gespeichert wird.
    - Es wird dann ein int[] mit Zufallswerten erzeugt und in der Datei gespeichert. 
- Laden. 
    - Die Anwendung fragt den User, wie die Datei heißt. 
    - Die Anwendung lädt ein int[] aus der Datei und gibt es aus. 

> Verwenden Sie für die Lösung die Klasse 'java.io.Console'
