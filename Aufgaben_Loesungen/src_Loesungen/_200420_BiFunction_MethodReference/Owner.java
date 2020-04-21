package _200420_BiFunction_MethodReference;

public class Owner implements Comparable<Owner>{
	private static int idCounter = 0;
	private int id;
	private String firstName;
	private String lastName;
	
	public Owner(String firstName, String lastName) {
		this.id = idCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Diese Abhänigkeit zu 'VehicleOwnerUtil' ist nicht sinvoll !!! Dient hier aber dazu die MethodenReferenz 'Owner:new' zu 
	// testen und gleichzeitig den neuen Owner aus der Util-Klasse ab fragen zu können.
	public Owner(String[] name, Vehicle v) {
		this(name[0], name[1]);
		v.setOwnerID(this.id);
		VehicleOwnerUtil.addOwner(this);
	}
	
	public boolean setNewOwner(Vehicle v) {
		if (v == null)
			return false;
		v.setOwnerID(this.id); 
		return true;
	}

	public int getId() {
		return id;
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
