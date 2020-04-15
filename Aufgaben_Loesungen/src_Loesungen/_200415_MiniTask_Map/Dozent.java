package _200415_MiniTask_Map;

public class Dozent implements Comparable<Dozent>{
	private String name;
	
	public Dozent(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Dozent d) {
		return this.name.compareTo(d.name);
	}

	@Override
	public String toString() {
		return name;
	}
	
	

}
