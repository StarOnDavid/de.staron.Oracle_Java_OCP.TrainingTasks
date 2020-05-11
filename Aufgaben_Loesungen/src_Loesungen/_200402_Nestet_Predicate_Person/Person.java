package _200402_Nestet_Predicate_Person;

import java.time.LocalDate;

public class Person {
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	
	public Person(String firstName, String lastName, LocalDate birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " born: " + birthday;
	}

	
}
