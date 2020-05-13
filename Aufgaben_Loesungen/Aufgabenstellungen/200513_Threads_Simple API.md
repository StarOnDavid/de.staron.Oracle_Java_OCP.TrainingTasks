# Aufgabe 'Threads - Simple API'

###### A1.

Bitte starten Sie einen endlosen extra-Thread, der ca. jede Sekunde seine ID und seinen Namen auf der Konsole ausgibt. Der endlose Thread soll mit einer Klasse realisiert werden, die von der Klasse `Thread` erbt. 

###### A2.

Bitte starten Sie einen endlosen extra-Thread, der ca. jede Sekunde seine ID und seinen Namen auf der Konsole ausgibt. Für die Realisierung implementieren Sie bitte das Interface `Runnable`
 
###### A3.
 
- Bitte 37 Threads im Zustand 'NEW' in einer Schleife erzeigen.
- Erst nachdem die Thread-Objekte erzeugt wurden in einer anderen Schleife alle 37 Threads starten. Jeder Thread gibt einfach seine ID auf der Konsole aus.

###### A4.

Starten Sie bitte 26 weitere extra Threads. Jeder Thread wird seinen eigenen englischen Großbuchstaben ausgeben.
Verwenden Sie bitte das Runnable-Target um einem Thread seine Logik zuzuordnen. 

###### A5. Optional
Gegeben ist folgende Methode:

		public static void bigJob() {
			Thread th = Thread.currentThread();
			System.out.println("Starte " + th.getName() 
				+ ". Priorität: " + th.getPriority());
			
			long start = System.currentTimeMillis();
	
			int exists = 0;
			for (int i = 0; i < 100_000; i++) {
				Path path = Paths.get("./"+i);
				if(Files.exists(path)) {
					exists++;
				}
			}
			
			long ende = System.currentTimeMillis();
			
			System.out.println("Thread: " + th.getName() 
					+ ", Zeit: " + (ende-start)/1000. + " Sek. / " + exists);
		}

Schätzen Sie grob, ob die Threads-Prioritäten auf Ihrem PC eine Auswirkung auf die Threads-Geschwindigkeiten haben. Dafür erzeugen Sie z.B. zwei Threads mit den Srting-Namen "Tom" und "Jerry". Der Thread 'Tom' soll die Methode 'bigJob' mit der niedrigsten Priorität ausführen. Parallel dazu soll der Thread 'Jerry' die Methode 'bigJob' mit der höchsten  Priorität laufen lassen. 

