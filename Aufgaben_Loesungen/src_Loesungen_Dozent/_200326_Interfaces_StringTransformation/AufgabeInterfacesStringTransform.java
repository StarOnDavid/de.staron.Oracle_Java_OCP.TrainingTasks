package _200326_Interfaces_StringTransformation;

import java.util.*;

class AddPoint implements Transformationen {
	@Override
	public String execute(String s) {
		return s + ".";
	}
}

public class AufgabeInterfacesStringTransform {

	public static void main(String[] args) {

		String[] arr = { "mo", "di", "mi" };

		System.out.println("*** A1");
		ArrayList<String> list = transform(arr); // ArrayList <- IS-A <- ArrayList
		System.out.println(list); // [MO, DI, MI]
		
		
		System.out.println("*** A3");
		
		list = transform(arr, new AddPoint());
		System.out.println(list); // [mo., di., mi.]
		
		System.out.println("*** A4");
		
		list = transform(arr, s -> s + "(" + s.length() + ")");
		System.out.println(list); // [mo(2), di(2), mi(2)]
		
	} // 
	
	static ArrayList<String> transform(String[] arr, Transformationen logic) {
		ArrayList<String> list = new ArrayList<String>();
		
		for (String s : arr) {
			s = logic.execute(s);
			list.add(s);
		}
		
		return list;
	}
	
	
	static ArrayList<String> transform(String[] arr) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(String s : arr) {
			list.add( s.toUpperCase() );
		}
		
		return list; 
	}

}
