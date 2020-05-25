# Aufgabe 'Blocking - Permutation'

Gegeben sind folgende Methoden:

	/*
	 * Erzeugt rekursiv alle möglichen Permutationen der Zeichen 
	 * in dem übergebenen Array mit dem Algorithmus von B. R. Heap
	 * (https://en.wikipedia.org/wiki/Heap%27s_algorithm)
	 *
	 * Z.B. für das Array [a, b, c] werden folgende 6 Permutationen erzeugt:
	 *
	 * 		[a, b, c] 
	 * 		[b, a, c] 
	 * 		[c, a, b] 
	 * 		[a, c, b] 
	 * 		[b, c, a] 
	 * 		[c, b, a] 
	 *
	 * Für den initiirenden Aufruf verwendet man die Länge 
	 * des Arrays als pointer-Argument:
	 *
	 *		char[] array = { 'a', 'b', 'c' };
	 *		permutate(array, array.length);
	 * 
	 */
	public static void permutate(char[] arr, int pointer) {
	    if(pointer==1) {
	        System.out.printf("%s %n", Arrays.toString(arr));
	        return;
	    }
	    
		for (int i = 0; i < pointer-1; i++) {
		   permutate(arr, pointer-1);
		    
			if(pointer%2==0) {
			    char tmp = arr[pointer-1];
			    arr[pointer-1] = arr[i];
			    arr[i] = tmp;
			} else {
			    char tmp = arr[pointer-1];
			    arr[pointer-1] = arr[0];
			    arr[0] = tmp;
			}
		}
		
		permutate(arr, pointer-1);
	}

	/* Berechnet rekursiv die Fakultät einer Zahl bi:
	 *
	 *   1*2*3*4*...*bi
	 *
	 * Mit der Methode kann man z.B. die Anzahl der Permutationen 
	 * für ein char-Array 'array' mit einzigartigen Zeichen berechnen:
	 *
	 * BigInteger bi = BigInteger.valueOf( array.length );
	 * BigInteger numberPermutations = factorial( bi );
	 * 
	 */
	public static BigInteger factorial(BigInteger bi) {
		if(bi.intValue()==1) {
			return bi;
		}
		return bi.multiply( factorial(bi.subtract(BigInteger.ONE)) );
	}

	
###### A1.
Definieren Sie ein char-Array mit 6 einzigartigen englischen Kleinbuchstaben. Starten Sie damit die Methode `permutate` in einem extra-Thread. 

###### A2.
Ändern Sie bitte die Methode `permutate`. Statt die Ergebnisse selbst auszugeben, soll sie jedes mal eine Kopie vom Array mit der aktuellen Permutation erzeugen und in einer Blocking-Collection speichern. Ein anderer Thread soll auf die Blocking-Collection zugreifen und, falls sie nicht leer ist, die nächste Permutation entfernen und auf der Konsole präsentieren.

Optional: Wenn noch nicht geschehen, lassen Sie die Threads von einem ExecutorService verwalten.

###### A3.
Gestalten Sie bitte die Lösung so, dass die beiden Threads aus einem dritten Thread vorzeitig beendet werden können. 

###### A4. Optional.
Statt die Permutationen zu erzeugen, soll der erste Thread die zweier-Kombinationen von Zeichen eines char-Arrays generieren. Z.B. für das Array [a, b, c] würden die zweier-Kombinationen so aussehen:

	a b
	a c
	b c

> https://en.wikipedia.org/wiki/Combination 

