package _200506_Projekt_Deutsche_Staedte;

public class Stadt {

	private String name, land;
	private int einwohner;
	
	public Stadt(String name, String land, int einwohner) {
		this.name = name;
		this.land = land;
		this.einwohner = einwohner;
	}
	
	public String getName() {
		return name;
	}
	public String getLand() {
		return land;
	}
	public int getEinwohner() {
		return einwohner;
	}
	
	@Override
	public String toString() {
		return name + " (" + land + "), " + einwohner;
	}	
}
