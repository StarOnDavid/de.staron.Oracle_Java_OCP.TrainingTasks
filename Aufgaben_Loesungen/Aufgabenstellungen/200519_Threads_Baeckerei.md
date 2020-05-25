# Aufgabe 'Threads - Bäckerei'

Erstellen Sie bitte eine Anwendung wo die Klassensammlung getestet wird, die den folgenden Beschreibungen entspricht:

- Jede Bäckerei hat einen Namen


- Jede Bäckerei kann Brötchen produzieren und im eigenen Lager halten. Lagerkapazität: 100 Stück. 

> Optional: die Lagerkapazität kann für jede Bäckerei gesetzt werden.  


- Die Produktion in jeder Bäckerei dauert mindestens 100 Millisekunden (simuliert durch Thread.sleep). 

> Optional: Die Produktionsdauer kann für eine Bäckerei zufällig variiren.


 - Bei jedem Produktionsvorgang produziert eine Bäckerei 10 Brötchen. Wenn die 10 Brötchen das Lager überfüllen würden, werden nur so viel produziert, um das Lager voll zu kriegen.  

- Jede Bäckerei existiert im eigenen endlosen Thread, in dem die Produktion immer wieder wiederholt wird.


- Jede Person hat einen Namen und eine bestimmte Lieblingsbäckerei


- Jede Person möchte 3 bis 15 Brötchen kaufen. Die gewünschte Anzahl der Brötchen wird vor jedem Einkauf zufällig ermittelt. Sollte es auf dem Lager nicht genug Brötchen geben, wird einfach der Restbestand eingekauft - der aktuelle Einkauf ist danach erledigt.


- Jede Person existiert im eigenen endlosen Thread und versucht immer wieder neue Brötchen einzukaufen.


- Bitte synchronisieren Sie die Threads sinnvoll.


- Bitte lassen Sie die Personen keine unnötigen Einkäufe versuchen, wenn das Bäckerei-Lager leer ist.

>Tipp: Methode wait() einsetzen


- Bitte lassen Sie die Personen nicht unnötig warten, wenn es auf dem Lager Brötchen gibt.

> Tipp: Die Methoden notify() oder notifyAll() einsetzen


- Bitte erstellen Sie eine Bäckerei "Agethen" und zwei-drei Personen, die dort einkaufen. 


- Visualisieren Sie bitte mit den Consolenausgaben die Produktion und den Einkauf der Brötchen.


- Optional. Entwickeln Sie eine alternative Lösung, in der die synchronized-Blöcke und wait/notify-Aufrufe durch das Einsetzen vom Lock-Interface und Condition-Interface ersetzt werden.

