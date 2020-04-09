# Aufgabe 'Set - Abfahrtzeiten'

- Generieren Sie bitte die Abfahrtzeiten für eine Buslinie von einer Haltestelle:
    - Der erste Bus fährt um 06:12 ab.
    - Der letzte Bus fährt um 23:52 ab.
    - Die Busse fahren in 20-Minuten-Takt


- Die Abfahrtzeiten sollen als Strings in einem TreeSet gespeichert werden. Die Strings sollen folgende Form haben:

    	"06:12", "06:32", "06:52" ... "23:52"

> Tipp: Die Methode String.format("%02d:%02d", 2, 12) liefert den String "02:12" zurück

- Untersuchen Sie die Abfahrtzeiten:
    - suchen Sie die erste Abfahrtzeit nach 12:03
    - suchen Sie nach der ersten Abfahrtzeit vor 12:03
    - suchen Sie nach der ersten Abfahrtzeit nach 17:12 inklusive
    - suchen Sie nach der ersten Abfahrtzeit nach 17:12 exklusive
    - suchen Sie nach allen Abfahrtzeiten zwischen 12:00 bis 13:00
    - suchen Sie nach allen Abfahrtzeiten zwischen 11:52 exklusive bis 13:12 inklusive
    - suchen Sie nach der erstmöglichen Abfahrtzeit
    - suchen Sie nach der letztmöglichen Abfahrtzeit


- Optional. Gibt es andere (bessere) Möglichkeiten die Abfahrtzeiten in einem TreeSet zu speichern als in Form in dieser Aufgabe verwendeter Strings?
