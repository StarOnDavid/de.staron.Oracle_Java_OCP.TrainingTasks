package _200430_Collections_Autos;

public class Person implements Comparable<Person> {

	private String vorname, nachname;

	public Person(String vorname, String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	@Override
	public String toString() {
		return vorname + " " + nachname;
	}
	
	@Override
	public int compareTo(Person p2) {
		int res = vorname.compareTo(p2.vorname);
		
		if(res==0) {
			res = nachname.compareTo(p2.nachname);
		}
		
		return res;
	}
}
