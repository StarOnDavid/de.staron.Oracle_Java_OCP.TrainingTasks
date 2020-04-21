package _200420_BiFunction_MethodReference_v2;

public class Vehicle {
	private static int idLfd = 0;
	private int id;
	
	public Vehicle() {
		id = idLfd++;
	}
	
	public int getID() {
		return id;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + "]";
	}
}
