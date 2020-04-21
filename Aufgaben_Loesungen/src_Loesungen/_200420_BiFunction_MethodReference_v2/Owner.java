package _200420_BiFunction_MethodReference_v2;

public class Owner {
	private int id;
	private Vehicle vehicle;
	
	
	public Owner (Vehicle v, Integer id) {
		this.vehicle = v;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", " + vehicle + "]";
	}

}
