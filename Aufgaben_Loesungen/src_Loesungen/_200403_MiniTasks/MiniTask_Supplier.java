package _200403_MiniTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MiniTask_Supplier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		miniTask();
	}
	
	static void miniTask() {
		/*
		 * Bitte die Methode 'fillList' erzeugen, die aus dem Supplier die Liste für Integer erhält.
		 * Dann speichert die Methode die Werte 1, 2 und 3 in der Liste und liefert die Liste zurück.
		 */
		
		Supplier<List<Integer>> s = () -> new ArrayList<Integer>();
		
		List<Integer> list = fillList(s);
		System.out.println(list);
		System.out.println(list.getClass());
	}
	
	static List<Integer> fillList(Supplier<List<Integer>> s) {
		List<Integer> list = s.get();
		list.add(1);
		list.add(2);
		list.add(3);
		return list;
	}

}
