package _200327_Kleine_Aufgabe_Enums;

public class ElementAlsKlasse implements Comparable<ElementAlsKlasse>{
	private final String name; 
	public final static ElementAlsKlasse LUFT = new ElementAlsKlasse("LUFT");
	public final static ElementAlsKlasse FEUER = new ElementAlsKlasse("FEUER");;
	public final static ElementAlsKlasse ERDE = new ElementAlsKlasse("ERDE");
	public final static ElementAlsKlasse WASSER = new ElementAlsKlasse("WASSER");
	
	private ElementAlsKlasse(String name) {
		this.name = name;
	}
	
	public static ElementAlsKlasse[] values() {
		ElementAlsKlasse[] arr = new ElementAlsKlasse[4];
		arr[0] = LUFT;
		arr[1] = FEUER;
		arr[2] = ERDE;
		arr[3] = WASSER;
		return arr;
	}
	
	public int ordinal() {
		int num = -1;
		switch(name) {
		case "LUFT":
			num = 0;
			break;
		case "FEUER":
			num = 1;
			break;
		case "ERDE":
			num = 2;
			break;
		case "WASSER":
			num = 3;
			break;
		}
		return num;
	}
	
	public String name() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(ElementAlsKlasse e) {
		return ((Integer) this.ordinal()).compareTo(((Integer) e.ordinal()));
	}	
}
