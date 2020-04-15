package _200415_Map_Besitzer_Fahrzeuge;

public class Owner implements Comparable<Owner>{
	private String firstName;
	private String lastName;
	
	public Owner(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int compareTo(Owner o) {
		int ln = this.lastName.compareTo(o.lastName);
		if (ln == 0)
			return this.firstName.compareTo(o.firstName);
		return ln;
	}
	
	
}
