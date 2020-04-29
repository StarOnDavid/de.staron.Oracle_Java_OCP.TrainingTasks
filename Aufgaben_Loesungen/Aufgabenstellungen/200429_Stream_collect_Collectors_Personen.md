# Aufgabe 'collect, Collectors - Personen'

gegeben ist folgende Klasse:

	public class Person {
		private String name;
		private String beruf;
		
		public Person(String name, String beruf) {
			this.name = name;
			this.beruf = beruf;
		}
		// more methods here...
		public String toString() {
			return name;
		}
	}

und ein Person-Array:

	Person[] personen = {
		new Person("Tom", "Bauarbeiter(in)"),	
		new Person("Jerry", "Lehrer(in)"),	
		new Person("Peter", "Metzger(in)"),	
		new Person("Paul", "Bauarbeiter(in)"),	
		new Person("Mary", "Lehrer(in)"),	
	};
	
###### A1.
Verwenden Sie bitte eine Stream-Methode `collect` und einen Collector `Collectors.toXxx` um alle Personen in einem TreeSet zu speichern.

###### A2. toMap
Verwenden Sie bitte eine Stream-Methode `collect` und einen Collector `Collectors.toMap` um eine Map zu bilden, in der einem String-Namen (Key) eine Person (Value) zugeordnet wird. Als Datenquelle der Pipeline verwenden Sie bitte das Array 'personen'.
	
###### A3. mapping
Bitte verwenden Sie `Stream/collect` und `Collectors/mapping` um eine Collection zu erhalten, in der die Berufe (Strings) aller Personen aus dem Array __einzigartig__ vertreten sind.  

###### A4. groupingBy
Bitte gruppieren Sie die Personen aus dem Array nach ihren Berufen. Jedem Beruf sollten die Personen zugeordnet werden, die diesen Beruf ausüben. Verwenden Sie bitte `Stream/collect` und `Collectors/groupingBy`.

###### A5. partitioningBy
Bitte verwenden Sie `Stream/collect` und `Collectors/partitioningBy` um die Bauarbeiter(inen) aus dem Array von Personen mit den anderen Berufen zu trennen.
