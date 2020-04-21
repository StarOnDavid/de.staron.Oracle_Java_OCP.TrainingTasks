package _200420_BiFunction_MethodReference;

public class Auto {

	/*
	 * Seltsame Method ist nur für die Lernaufgabe A6 sinnvoll:
	 * 
	 */
	public Besitzer buildBesitzer(Integer id) {
		return Besitzer.createInstance(this, id);
	}

	@Override
	public String toString() {
		return "A-" + hashCode();
	}
}
