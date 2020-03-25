package _200325_InterfacesComperableComperator_OS;

public class OS {
	private String name;
	private Integer version;
	
	public OS(String name, int version) {
		super();
		this.name = new String(name);
		this.version = Integer.valueOf(version);
	}

	public String getName() {
		return name;
	}

	public Integer getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return String.format("%1$-10s",name) + version;
	}	
	
}
