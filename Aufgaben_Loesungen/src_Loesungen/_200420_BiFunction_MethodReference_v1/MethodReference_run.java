package _200420_BiFunction_MethodReference_v1;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference_run {
	
	
	static {
		VehicleOwnerUtil.setOwnerList(Arrays.asList(	new Owner("Manuel", "Neuer"), 
														new Owner("Nico", "Schulz"), 
														new Owner("Julian", "Brandt")
													));
		
		VehicleOwnerUtil.setVehilceList(Arrays.asList(	new Vehicle("911", "Porsche", 1), 
														new Vehicle("Defender", "Landrover", 0), 
														new Vehicle("SLK", "Mercedes", 5),
														new Vehicle("A8 quadro", "Audi", 0)
													  ));
	}
	
	public static void main(String[] args) {
		
		// A1
		Function<Vehicle, Owner> f1 = new Function<Vehicle, Owner>() {
			@Override
			public Owner apply(Vehicle v) {
				return VehicleOwnerUtil.getOwner4Vehicle(v);
			}
		};
		
		System.out.println("Der '" + VehicleOwnerUtil.getVehicle(0) + "' gehört: " + f1.apply(VehicleOwnerUtil.getVehicle(0)));
		
		
		// A2
		Function<Vehicle, Owner> f2 = v -> VehicleOwnerUtil.getOwner4Vehicle(v);
		
		System.out.println("Der '" + VehicleOwnerUtil.getVehicle(1) + "' gehört: " + f2.apply(VehicleOwnerUtil.getVehicle(1)));
		
		// A3
		Function<Vehicle, Owner> f3 = VehicleOwnerUtil::getOwner4Vehicle;
		
		System.out.println("Der '" + VehicleOwnerUtil.getVehicle(2) + "' gehört: " + f3.apply(VehicleOwnerUtil.getVehicle(2)));
		
		// A4
		// Die feste Verknüpfung von VehicleOwnerUtil und Vehicle / Owner
		// macht so wenig Sinn ... zweck ... Test des Aufruf 'Klasse::new'
		BiFunction<String[], Vehicle, Owner> f4 = Owner::new;
		String [] oName = {"Lukas", "Podolskie"};
		Owner o1 = f4.apply(oName, VehicleOwnerUtil.getVehicle(3));
		System.out.println("Der '" + VehicleOwnerUtil.getVehicle(3) + "' gehört: " + VehicleOwnerUtil.getOwner4Vehicle(VehicleOwnerUtil.getVehicle(3)));
		
		BiFunction<String[], Owner, Vehicle> f4b = Vehicle::new;
		String [] vMB = {"F50", "Farrari"};
		f4b.apply(vMB, VehicleOwnerUtil.getOwner(2));
		System.out.println("Der '" + VehicleOwnerUtil.getVehicle(4) + "' gehört: " + VehicleOwnerUtil.getOwner4Vehicle(VehicleOwnerUtil.getVehicle(4)));
		
		// A5
		BiFunction<Owner, Vehicle, Boolean> f5 = Owner::setNewOwner;
		boolean verkauft = f5.apply(o1, VehicleOwnerUtil.getVehicle(0));
		System.out.println("Der '" + VehicleOwnerUtil.getVehicle(0) + "' wurde verkauft: " + verkauft +
				" - und gehört nun: " + VehicleOwnerUtil.getOwner4Vehicle(VehicleOwnerUtil.getVehicle(4)));
	}
}
