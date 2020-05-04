package _200430_Collect_Warenkorb;

public class Bestellung {
	private String produktName;
	private int anzahl; // gewünschte Anzahl der Produkt-Objekte

	public Bestellung(String produktName, int anzahl) {
		this.produktName = produktName;
		this.anzahl = anzahl;
	}
	
	public String getProduktName() {
		return produktName;
	}
	
	public int getAnzahl() {
		return anzahl;
	}
	
}
