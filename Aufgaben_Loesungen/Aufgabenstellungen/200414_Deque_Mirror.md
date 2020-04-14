# Aufgabe 'Deque - Mirror'

 Gegeben ist folgende main-Methode:
 
		public static void main(String[] args) {
			Mirror m = new Mirror();
			
			for (char ch = 'a'; ch < 'g'; ch++) {
				m.add(ch);
				System.out.println(m);
			}
			
			while( !m.isEmpty() ) {
				System.out.println(m);
				m.remove();
			}
		}
	

Die Ausgaben, die von der for-Schleife erzeugt werden, zeigen, dass jedes neue Zeichen doppelt hinzugefügt wird:

	a|a
	ba|ab
	cba|abc
	dcba|abcd
	edcba|abcde
	fedcba|abcdef


Die Ausgaben, die von der while-Schleife erzeugt werden, zeigen, dass jedes mal die Methode `remove` das äußere Zeichen von beiden Enden entfernt:

	fedcba|abcdef
	edcba|abcde
	dcba|abcd
	cba|abc
	ba|ab
	a|a


Realisieren Sie bitte die Klasse `Mirror` mit den notwendigen Methoden `add`, `remove` und `isEmpty`,  damit die vorgegebene `main`-Methode die gezeigten Ausgaben erzeugt. Verwenden Sie in der Klasse `Mirror` eine `Deque`, um die Zeichen zu speichern. 