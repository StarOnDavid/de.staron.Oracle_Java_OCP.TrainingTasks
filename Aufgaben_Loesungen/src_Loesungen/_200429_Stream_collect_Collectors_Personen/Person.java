package _200429_Stream_collect_Collectors_Personen;

public class Person implements Comparable<Person>{
	private String name;
	private String beruf;
	
	public Person(String name, String beruf) {
		this.name = name;
		this.beruf = beruf;
	}

	public String getJob() {
		return beruf;
	}
	
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(Person p) {
		return this.name.compareTo(p.name);
	}
}