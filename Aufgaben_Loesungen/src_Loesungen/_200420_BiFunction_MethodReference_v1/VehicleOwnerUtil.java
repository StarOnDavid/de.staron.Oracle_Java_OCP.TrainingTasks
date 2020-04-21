package _200420_BiFunction_MethodReference_v1;

import java.util.ArrayList;
import java.util.List;


public class VehicleOwnerUtil {
	private static List<Owner> oList = new ArrayList<>();
	private static List<Vehicle> vList = new ArrayList<>();
	
	
	public static Owner getOwner(int idx) {
		return oList.get(idx);
	}

	public static Vehicle getVehicle(int idx) {
		return vList.get(idx);
	}

	public static void setVehilceList(List<Vehicle> vList) {
		for (Vehicle v : vList) {
			VehicleOwnerUtil.vList.add(v);
		}
	}
	
	public static void setOwnerList(List<Owner> oList) {
		for (Owner o : oList) {
			VehicleOwnerUtil.oList.add(o);
		}
	}

	public static void addVehilce(Vehicle v) {
		VehicleOwnerUtil.vList.add(v);
	}
	
	public static void addOwner(Owner o) {
		VehicleOwnerUtil.oList.add(o);
	}
	
	public static Owner getOwner4Vehicle(Vehicle v) {
		int o = v.getOwnerID();
		for (Owner owner : oList) {
			if(owner.getId() == o)
				return owner;
		}
		return null;
	}
}
