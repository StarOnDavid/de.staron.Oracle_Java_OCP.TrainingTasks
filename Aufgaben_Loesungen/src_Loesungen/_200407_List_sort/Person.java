package _200407_List_sort;

public class Person implements Comparable<Person>{
	String firstName, lastName;
	int alter;
	
	public Person() {}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int compareTo(Person p) {
		int res = this.lastName.compareTo(p.lastName);
		if (res == 0)
			return this.firstName.compareTo(p.firstName);
		return res;
	}

	
}
