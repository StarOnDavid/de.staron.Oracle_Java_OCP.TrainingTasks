# Aufgabe 'Collections - Autos'

> Lösen Sie bitte die Aufgabe in einem neuen Package

###### A1.
Erstellen Sie eine abstrakte Klasse 'Auto' und die Klassen 'VW' und 'BMW' nach folgendem Klassendiagramm

![Klassendiagramm Auto-VW-BMW]( Collections-Autos-01.png )

###### A2.
Erstellen Sie eine Instanz vom Typ VW (Golf, Baujahr 1990) und eine Instanz vom Typ BMW (Z4, Baujahr 2000). Überschreiben Sie die toString-Methode für VW und BMW so, dass die Ausgaben mit `System.out.println` folgende Form haben:

        VW. Modell: Golf, Baujahr 1990
        BMW. Modell: Z4, Baujahr 2000

###### A3.
Erstellen Sie 3 Instanzen von VW. Weisen Sie dabei die Adressen der Objekte den Referenzen vw1, vw2 und vw3 zu.

###### A4.
Speichern Sie die 3 VW-Referenzen in LinkedList, HashSet, TreeSet und PriorityQueue. Beim Sortieren sollen die Objekte erst nach dem Modell und dann nach dem Baujahr verglichen werden. Die ggf. notwendige(n) hashCode-Methode(n) soll(en) korrekt (richtig, gültig) aber nicht unbedingt sinnvoll implementiert werden.


###### A5.
Geben Sie alle erstellten Collections mit den foreach-Schleifen aus.


###### A6.
Erstellen Sie 2 Objekte von Typ 'BWM' und referenzieren Sie sie mit bmw1 und bmw2. Speicher Sie die Referenzen in ArrayList, HashSet, TreeSet und ArrayDeque. Geben Sie die neu erstellten Collections aus.


###### A7.
Benutzen Sie die Methode 'contains', um in dem HashSet von BMW-Objekten nach bmw1 zu suchen.


###### A8.
Fügen Sie der Klasse BMW die Setter-Methode für das Attribut 'baujahr' hinzu. Benutzen Sie die neue Methode mit der Referenz bmw1 um das Baujahr zu ändern. Versuchen Sie erneut mit der Methode 'contains' in dem HashSet von BMWs nach bmw1 zu suchen. Was liefert die Methode 'contains' und warum?


###### A9.
Erstellen Sie eine Instanz VW (Polo, Baujahr 2200) und speichern Sie ihre Adresse in der Liste mit VWs. Speichern Sie dabei die Adresse in keiner weiteren Referenz.

###### A10.
Benutzen Sie die Methode 'binarySearch' aus der Klasse 'Collections' und suchen Sie nach einem VW Polo, Baujahr 2200 in der Liste aus A9. Geben Sie das Ergebnis aus.


###### A11.
Benutzen Sie die Methode 'sort' aus der Klasse 'Collections' um die Liste mit VWs zu sortieren. Geben Sie die sortierte Liste aus.

###### A12.
Benutzen Sie die Methode 'sort' aus der Klasse 'Collections' um die Liste mit VWs in der Umkehrreihenfolge zu sortieren. Geben Sie die Liste aus.


###### A13.
Benutzen Sie die Methode 'binarySearch' aus der Klasse 'Collections' und suchen Sie nach einem VW Polo, Baujahr 2200 in der  Liste mit VWs. Geben Sie das Ergebnis aus.


###### A14.
Benutzen Sie die Methode 'binarySearch' aus der Klasse 'Collections' und suchen Sie nach einem VW Polo, Baujahr 3300 in der Liste mit VWs. Geben Sie das Ergebnis aus.


