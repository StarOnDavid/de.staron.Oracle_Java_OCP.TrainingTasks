package _200420_BiFunction_MethodReference;

public class Vehicle implements Comparable<Vehicle> {
	private int ownerID;
	private String model;
	private String brand;
	
	public Vehicle(String model, String brand) {
		this.model = model;
		this.brand = brand;
	}
	
	// Diese Abhänigkeit zu 'VehicleOwnerUtil' ist nicht sinvoll !!! Dient hier aber dazu die MethodenReferenz 'Vehicle:new' zu 
	// testen und gleichzeitig das neue Vehicle aus der Util-Klasse ab fragen zu können.
	public Vehicle(String[] md, Owner o) {
		this.model = md[0];
		this.brand = md[1];
		this.ownerID = o.getId();
		VehicleOwnerUtil.addVehilce(this);
	}
	
	public Vehicle(String model, String brand, int ownerID) {
		this(model, brand);
		this.setOwnerID(ownerID);
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	
	@Override
	public int compareTo(Vehicle v) {
		int br = this.brand.compareTo(v.brand);
		if(br == 0)
			return this.model.compareTo(v.model);
		return br;
	}

	@Override
	public String toString() {
		return brand + " - " + model;
	}	
}
