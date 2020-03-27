package _200325_InterfaceComperableComperator_OS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Achtung! Aufgabestellung leicht geändert: Statt Arrays werden Listen verwendet
 */
public class AufgabeInterfacesComparableComparatorOS {

	public static void main(String[] args) {

		List<OS> list = new ArrayList<>();
		
		list.add(new OS("Linux", 3));
		list.add(new OS("Windows", 95));
		list.add(new OS("Mac", 9));
		list.add(new OS("Linux", 1));
		
		print(list);
		
		System.out.println("*** A4. aufsteigend sortiert: ");
		Collections.sort(list);
		print(list);
		
		System.out.println("*** A5. absteigend sortieren");
		
		Comparator<OS> cmp = Comparator.reverseOrder();
		Collections.sort(list, cmp);
		print(list);
		
		System.out.println("*** A6. aufsteigend sortiert für die Suche: ");
		Collections.sort(list);
		print(list);
		
		OS key = new OS("Mac", 9);
		
		int pos = Collections.binarySearch(list, key);
		System.out.println("Gesucht nach " + key);
		System.out.println("Gefunden an der Position: " + pos);

		
		System.out.println("*** A7. absteigend sortiert für die Suche: ");
		Collections.sort(list, cmp);
		print(list);
		
		key = new OS("Windows", 95);
		pos = Collections.binarySearch(list, key, cmp);
		System.out.println("Gesucht nach " + key);
		System.out.println("Gefunden an: " + pos); // 0
		
		System.out.println("*** test shuffle: ");
		Collections.shuffle(list);
		print(list);
		
	} // end of main
	
	static void print(List<OS> list) {
		for (int i = 0; i < list.size(); i++) {
			OS os = list.get(i);
			
			System.out.format( "| %d. | %8s | %3d | %n", i, os.getName(), os.getVersion() );
		}
	}

}
