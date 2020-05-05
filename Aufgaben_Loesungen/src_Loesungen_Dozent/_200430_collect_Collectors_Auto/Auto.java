package _200430_collect_Collectors_Auto;

public class Auto {
	private String hersteller, modell;
	public Auto(String hersteller, String modell) {
		this.hersteller = hersteller;
		this.modell = modell;
	}
	public String getHersteller() { return hersteller; }
	public String getModell() { return modell; }
	
	public String toString() { return hersteller + "/" + modell; }
}