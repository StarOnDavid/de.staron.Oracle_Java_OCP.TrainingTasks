# Aufgabe 'Threads - Philosophenproblem - Deadlock'

> Beschreibung bei der Wikipedia: https://de.wikipedia.org/wiki/Philosophenproblem


Erstellen Sie bitte eine Anwendung in der das Philosophenproblem auftaucht. Beachten Sie die weiteren Aufgabenpunkte. Die auf der Seite beschriebene weitere Variante des Problems soll nicht nachprogrammiert werden.

- In Ihre Anwendung soll es mindestens 3 Philosophen geben. 


- Jeder Philosoph hat einen eindeutigen Namen


- Gestalten Sie die Anwendung flexibel genug, um die Anzahl der Philosophen ohne viel Aufwand ändern zu können. Z.B.:
	
		List<Philosoph> philosophen = getPhilosophen(3); //hier wird die Anzahl auf 3 gesetzt
		...
  
Dabei können Sie einen Pool aus Philosophen im voraus erstellen.


- Simulieren Sie den Tagesablauf einzelner Philosophen mit entsprechenden Konsolenausgaben. Z.B.:

		Sokrates denkt nach...
		Sokrates hat Hunger
		Sokrates nimmt die linke Gabel
		Sokrates nimmt die rechte Gabel
		Sokrates isst...
		Sokrates legt die rechte Gabel ab
		Sokrates legt die linke Gabel ab


- Der Tagesablauf eines Philosophen soll in einem Thread endlos wiederholt werden


- Überlegen Sie, auf welche Ressourcen die Philosophen gleichzeitig angewiesen sind. Synchronisieren Sie bitte den Zugriff auf die gemeinsamen Ressourcen so, dass es zu dem Deadlock kommen kann.
   
> Tipp: Versuchen Sie Deadlock wahrscheinlicher zu gestalten, indem die Threads an den Positionen künstrlich "gebremst" werden, wo das gleichzeitige Anhalten aller Threads zum Deadlock führt.

> Achtung! Die Aufgabe besteht nicht darin, das Philosophenproblem zu lösen! 
Es soll zum Deadlock kommen!

- Optional: Ändern Sie die Lösung. Setzen Sie für die neue Lösung `java.util.concurrent.locks.Lock` ein und sorgen Sie dafür, dass es zu keinem Deadlock mehr kommen kann.