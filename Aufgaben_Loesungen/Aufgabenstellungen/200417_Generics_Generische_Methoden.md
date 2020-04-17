# Aufgabe 'Generics - Generische Methoden'

###### A1.
Bitte definieren Sie eine generische statische Methode `getMax`, die so verwendet werden darf:
		
		String s = getMax("abc", "def"); // getMax liefert "def"
		System.out.println(s);
		
		Integer i = getMax(14, 12); // getMax liefert Integer mit 14
		System.out.println(i);

		Date d = getMax(new Date(), new Date(0)); // getMax liefert das spätere Datum
		System.out.println(d);
		
Dagegen darf folgende Aufruf nicht kompilieren:
		
		getMax("hallo", 22); // hier soll ein Compilerfehler entstehen
		
###### A2.
Gegeben sind folgende Methoden aus der Klasse `IntPositive`:

	private static void checkAndThrow(boolean check, Supplier<Exception> s) 
			throws Exception {
			
		if(!check) {
			throw s.get();
		}
	}

	void setValue(int value) {
		checkAndThrow(value>0, IllegalArgumentException::new);
	}	
	void writeValue(int value) {
		checkAndThrow(value>0, java.io.IOException::new);
	}
	
In der aktuellen Form gibt es in den Methoden `setValue` und `writeValue` je einen Compilerfehler, da in der `checkAndThrow` deklarierte checked-Exception nicht berücksichtigt wurde.

Versuchen Sie die Methode `checkAndThrow` generisch zu gestalten, so dass die Deklaration der geworfenen Exception in `checkAndThrow` in Abhängigkeit von der Parametrisierung des übergebenen Suppliers gebracht wird. 
Mit der umdefinierten Methode `checkAndThrow` soll der Compilefehler aus der Methode `setValue` __verschwinden__ (da `IllegalArgumentException` unchecked ist). Für die Methode `writeValue` soll der Compilerfehler __bestehen__ (da `java.io.IOException` eine checked-Exception ist).

###### A3.

Gegeben ist folgender Legacy-Code:

	public static Integer sum(Collection zahlen) {
		int sum = 0;
		
		for(Object zahlRef : zahlen) {
		   Integer zahl = (Integer) zahlRef;
		   sum += zahl.intValue();
		}
		
		return Integer.valueOf(sum);
	}

Parametrisieren Sie und vereinfachen Sie den Code der Methode `sum`.


###### A4. Optional.

Gegeben ist folgende Methode:

	@SafeVarargs
	public static <A, T extends Collection<A>> T build( Supplier<T> s, A... values ) {
						
		T c = s.get();
		for (A a : values) {
			c.add(a);
		}
		return c;
	}
	
Überlegen Sie, wozu die Methode eingesetzt werden kann? Testen Sie die Methode.
