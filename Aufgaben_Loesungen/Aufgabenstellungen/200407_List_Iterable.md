# Aufgabe 'List - Iterable'

- Definieren Sie eine Klasse `MyList` - einen Container für maximal 10 Strings. Die Klasse darf NICHT von einer Standardcollection erben.


- Die Klasse soll eine `void add(String element)` Methode haben, mit der man einen String zum Speichern an das MyList-Objekt übergeben kann. Die Methode speichert den übergebenen Wert an der nächsten nicht belegten Position. Wenn aber alle 10 Positionen bereits belegt sind, wirft die add-Methode eine Exception.


- Die Klasse soll eine Methode 'int size()' haben, die die Anzahl der bereits gespeicherten String zurückliefert


- Die Klasse soll eine Methode 'String get(int index)' haben. Sie liefert den gespeicherten String Nr. 'index' zurück. 
    - Wenn die Position 'index' noch nicht belegt ist, wirft die Methode eine Exception.
    - Wenn 'index' kleiner als 0 ist oder größer als 9, wirft die Methode eine Exception.


- Testen Sie ihre Klasse


- Implementieren Sie mit der Klasse 'MyList' das Interface `java.lang.Iterable`. Testen Sie Ihre Klasse mit der for-each-Schleife.
