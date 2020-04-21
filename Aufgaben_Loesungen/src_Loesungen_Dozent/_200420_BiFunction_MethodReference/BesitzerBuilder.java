package _200420_BiFunction_MethodReference;

public class BesitzerBuilder {
	public Besitzer build(Auto a, Integer id) {
		return Besitzer.createInstance(a, id);
	}
}
