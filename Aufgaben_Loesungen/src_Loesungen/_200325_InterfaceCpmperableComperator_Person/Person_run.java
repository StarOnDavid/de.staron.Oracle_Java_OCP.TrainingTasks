package _200325_InterfaceCpmperableComperator_Person;

import java.util.Arrays;
import java.util.Comparator;

import _200325_InterfacesComperableComperator_OS.OS;

public class Person_run {
	
	public static void main(String[] args) {

		Person[] pa = {
				new Person("Paul", "Smith"),
				new Person("Paul", "Black"),
				new Person("John", "Smith"),
				new Person("John", "Black")
		};	
		System.out.println("--- orginal ---------\n");
		printPersArray(pa);
		
		System.out.println("\n--- sort LastName ---\n");
		Arrays.parallelSort(pa, new MyLastNameCmp());
		printPersArray(pa);
		System.out.println	("\nPerson: 'Paul Black' ist an Pos: " +
								(Arrays.binarySearch(pa, new Person("Paul", "Black"), new MyLastNameCmp())+1)
							);
		
		System.out.println("\n--- sort FirstName --\n");
		Arrays.parallelSort(pa, new MyFirstNameCmp());
		printPersArray(pa);
		System.out.println	("\nPerson: 'Paul Black' ist an Pos: " +
				(Arrays.binarySearch(pa, new Person("Paul", "Black"), new MyFirstNameCmp())+1)
			);
	}
	
	private static void printPersArray(Person[] pa) {
		for(Person p : pa) {
			System.out.println(p);
		}
	}
}

class MyLastNameCmp implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		int last = p1.getLastName().compareTo(p2.getLastName());
		if (last == 0) {
			return p1.getFirstName().compareTo(p2.getFirstName());
		} else {
			return last;
		}
	}
}

class MyFirstNameCmp implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		int first = p1.getFirstName().compareTo(p2.getFirstName());
		if (first == 0) {
			return p1.getLastName().compareTo(p2.getLastName()) ;
		} else {
			return first;
		}
	}
}