package _200402_Nestet_Predicate_Person;

public class PersonDozent {
	private String vorname, nachname;
	private int geburtsjahr;
	
	
	public PersonDozent(String vorname, String nachname, int geburtsjahr) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}
	
	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}
	
}