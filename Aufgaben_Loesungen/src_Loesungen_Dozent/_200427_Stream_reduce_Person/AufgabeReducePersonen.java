package _200427_Stream_reduce_Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class AufgabeReducePersonen {
	
	static class Person {
		private String vorname, nachname;

		public Person(String vorname, String nachname) {
			this.vorname = vorname;
			this.nachname = nachname;
		}
		
		@Override
		public String toString() {
			return vorname + " " + nachname;
		}
	}
	
	static String getMax(String s1, String s2) {

		if(s1.compareTo(s2) > 0) {
			return s1;
		}
		
		return s2;
	}

	public static void main(String[] args) {

		List<Person> personen = Arrays.asList(
					new Person("Tom", "Katze"),
					new Person("Jerry", "Maus"),
					new Person("Alexander", "Poe")
				);
		
		BinaryOperator<Person> accumulator = (p1, p2) -> {
			String vorname = getMax(p1.vorname, p2.vorname);
			String nachname = getMax(p1.nachname, p2.nachname);
			
			return new Person(vorname, nachname);
		};
		
//		Person person = personen.stream().reduce(accumulator);
		Optional<Person> maybePerson = personen.stream().reduce(accumulator);
		System.out.println("1: " + maybePerson.get());
		
		Person identity = new Person("", "");
		Person p2 = personen.stream().reduce(identity, accumulator);
		System.out.println("2: " + p2);
		
		BinaryOperator<Person> combiner = accumulator;
		Person p3 = personen.stream().reduce(identity, accumulator, combiner);
		System.out.println("3: " + p3);
	}

}
