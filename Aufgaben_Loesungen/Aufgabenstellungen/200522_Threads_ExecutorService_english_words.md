# Aufgabe 'ExecutorService'

###### A1.
Laden Sie alle englischen Wörter in eine `java.util.List`.

> Quelle: http://www.mieliestronk.com/wordlist.html
> Wenn dafür eine Lösung vom Dozenten freigegeben wurde, bitte diese Lösung verwenden. 

###### A2.
Definieren Sie eine `Runnable` Task, in der die Anzahl der Wörter in der geladenen List ermittelt wird, die ein 't' haben.

###### A3.
Definieren Sie eine `Callable` Task, in der die Anzahl der Wörter in der geladenen List ermittelt wird, die einen Unterstring 'oo' haben.

###### A4.
Übergeben Sie die zuvor beschriebenen Tasks an einen ExecutorService, warten Sie auf die Ergebnisse und geben Sie sie in dem main-Thread aus.

###### A5.
Definieren Sie eine neue Task so, dass sie die ganze Liste durchsucht und die Anzahl der Wörter ermittelt, die die Länge 5 haben. Führen Sie die Task mit einem ExecutorService aus und geben Sie das Ergebnis aus.

###### A6.
Definieren Sie 50 (fünfzig) Tasks so, dass jede nur ein Teil der Liste mit englischen Wörtern durchsucht. Jede einzelne Task wird in ihrem Teil der Liste die Anzahl der Wörter ermitteln, die die Länge 5 haben.

###### A7.
Definieren Sie einen Thread-Pool mit einer nicht beschränkten Anzahl der parallelen Threads. Starten Sie die 50 Tasks aus der Aufgabe A6, warten Sie bis alle Tasks beendet wurden. Geben Sie die Summe aller Ergebnisse aus. 

