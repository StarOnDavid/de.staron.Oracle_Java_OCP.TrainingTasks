package _200420_BiFunction_MethodReference_v2;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference_run {

	
	public static void main(String[] args) {
		
		BiFunction<Vehicle, Integer, Owner> f1 = new BiFunction<Vehicle, Integer, Owner>() {
			@Override
			public Owner apply(Vehicle v, Integer id) {
				return new Owner(v, id);
			}
		};
	
	Owner o1 = f1.apply(new Vehicle(), 0);
	System.out.println("owner 1: " + o1);
		
	} // end of main
}
