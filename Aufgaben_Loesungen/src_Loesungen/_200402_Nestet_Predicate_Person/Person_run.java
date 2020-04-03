package _200402_Nestet_Predicate_Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

class PredicateAfter1890 implements Predicate<Person>  {

	@Override
	public boolean test(Person p) {
		return p.getBirthday().isAfter(LocalDate.parse("1890-01-11"));
	}
}

public class Person_run {
	public static class PredicateLastWithA implements Predicate<Person>  {

		@Override
		public boolean test(Person p) {
			return p.getLastName().contains("a") || p.getLastName().contains("A");
		}
	}

	public static void main(String... args) {
		Person[] persons = {new Person("Thomas", "Shelby",  LocalDate.parse("1890-05-01")),
							new Person("Arthur", "Shelby", LocalDate.parse("1887-08-20")),
							new Person("Polly", "Gray", LocalDate.parse("1884-11-04")),
							new Person("Michael", "Gray", LocalDate.parse("1903-04-16")),
							new Person("Grace", "Shelby", LocalDate.parse("1894-02-02")),
							new Person("John", "Shelby", LocalDate.parse("1895-04-14"))
						};
		
		System.out.println("Template of Persons: " + Arrays.toString(persons));
		
		Predicate<Person> after1890 = new PredicateAfter1890();
		List<Person> l1 = filter(persons, after1890);
		System.out.println("\nBorn after 1890-01-01: " + l1);
		
		Predicate<Person> lastWithA = new Person_run.PredicateLastWithA();
		l1 = filter(persons, lastWithA);
		System.out.println("\nLastname with 'a': " + l1);
		
		class PredicateLastLongerThan4 implements Predicate<Person>  {

			@Override
			public boolean test(Person p) {
				return p.getLastName().length() > 4;
			}
		}
		
		Predicate<Person> longerThan4 = new PredicateLastLongerThan4();
		l1 = filter(persons, longerThan4);
		System.out.println("\nLastname longer than 4: " + l1);
		
		Predicate<Person> after1890AndLastWithA = new Predicate<Person> () {

			@Override
			public boolean test(Person p) {
				return p.getBirthday().isAfter(LocalDate.parse("1890-01-11")) && 
						(p.getLastName().contains("a") || p.getLastName().contains("A"));
			}
			
		};
		l1 = filter(persons, after1890AndLastWithA);
		System.out.println("\nBorn after 1890-01-01 and lastname with 'a':" + l1);
		
		Predicate<Person> longerThan4AndAfter1890 = longerThan4.and(after1890);
		l1 = filter(persons, longerThan4AndAfter1890);
		System.out.println("\nLastname longer than 4 and born after 1890-01-01: " + l1);
		
		Predicate<Person> bornInLeapYear = (p) -> p.getBirthday().isLeapYear();
		l1 = filter(persons, bornInLeapYear);
		System.out.println("\nBorn in leap year: " + l1);
	}
	
	private static List<Person> filter(Person[] persons, Predicate<Person> predic) {
		List<Person> personList = new ArrayList<Person>();
		for(Person p : persons) {
			if (predic.test(p))
				personList.add(p);
		}
		return personList;
	}
}
