package _200325_InterfaceComperableComperator_OS;

public class OS implements Comparable<OS> {

	private String name;
	private int version;
	
	public OS(String name, int version) {
		this.name = name;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public int getVersion() {
		return version;
	}
	
	@Override
	public int compareTo(OS os2) {
		int erg = name.compareTo(os2.name);
		
		if(erg==0) {
			erg = version - os2.version;
		}
		
		return erg;
	}
	
	@Override
	public String toString() {
		return name + " " + version;
	}
}
