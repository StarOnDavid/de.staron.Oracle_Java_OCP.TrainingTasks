package _200420_BiFunction_MethodReference;

public class Besitzer {
	public static Besitzer createInstance(Auto a, Integer id) {
		return new Besitzer(a, id);
	}
	
	private Auto auto;
	private int id;

	public Besitzer(Auto auto, int id) {
		this.auto = auto;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Besitzer " + id + " hat das Auto " + auto;
	}
}
