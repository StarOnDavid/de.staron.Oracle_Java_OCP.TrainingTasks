package _200407_List_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person_run {

	public static void main(String[] args) {
		Person[] arrPers = {new Person("Paul", "Smith"), new Person("Paul", "Black"), new Person("John", "Smith"), new Person("John", "Black")};
		List<Person> listPers = new ArrayList<>();
		listPers.add(new Person("Paul", "Smith"));
		listPers.add(new Person("Paul", "Black"));
		listPers.add(new Person("John", "Smith"));
		listPers.add(new Person("John", "Black"));
		
		System.out.println("Inhalt Array: " + Arrays.toString(arrPers));
		System.out.println("Inhalt List:  " + listPers);

		Arrays.sort(arrPers);
		listPers.sort((p1, p2) -> { int result = p1.getLastName().compareTo(p2.getLastName());
									if (result == 0) 
										return p1.getFirstName().compareTo(p2.getFirstName());
									return result;
								});
		
		System.out.println("\nInhalt Array sortiert (ASC): " + Arrays.toString(arrPers));
		System.out.println("Inhalt  List sortiert (ASC): " + listPers);
		
		
		Comparator<Person> desc = (p1, p2) -> { 	int result = p2.getLastName().compareTo(p1.getLastName());
													if (result == 0) 
														return p1.getFirstName().compareTo(p2.getFirstName());
													return result;
												};
		Arrays.sort(arrPers, desc);
		listPers.sort(desc);
												
		System.out.println("\nInhalt Array sortiert (DESC): " + Arrays.toString(arrPers));
		System.out.println("Inhalt  List sortiert (DESC): " + listPers);
	}

}
