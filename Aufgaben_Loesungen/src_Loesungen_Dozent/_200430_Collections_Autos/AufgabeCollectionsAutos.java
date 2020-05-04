package _200430_Collections_Autos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class AufgabeCollectionsAutos {

	public static void main(String[] args) {

		/*
		 * A3.
		 */
		VW vw1 = new VW("Golf", 1990);
		System.out.println(vw1); // VW. Modell: Golf, Baujahr 1990

		VW vw2 = new VW("Polo", 2003);
		VW vw3 = new VW("Golf", 1988);
		
		/*
		 * A4, A5
		 */
		System.out.println("*** A4, A5");
		
		LinkedList<VW> listVW = new LinkedList<VW>();
		listVW.add(vw1);
		listVW.add(vw2);
		listVW.add(vw3);
		
		print(listVW);
		
		HashSet<VW> hashSetVW = new HashSet<>(listVW);
		hashSetVW.add(new VW("Polo", 2003));
		
		print(hashSetVW);	
		
		TreeSet<VW> treeSetVW = new TreeSet<>(listVW);
		
		print(treeSetVW);
		
		PriorityQueue<VW> priorityQueueVW = new PriorityQueue<VW>(listVW);
		
//		print(priorityQueueVW); // OK, aber nicht sortiert
		System.out.println("* Entfernen von VWs aus der PriorityQueue: ");
		while( !priorityQueueVW.isEmpty() ) {
			VW vw = priorityQueueVW.poll();
			System.out.println(vw);
		}

		/*
		 * A6
		 */
		System.out.println("*** A6");
		
		BMW bmw1 = new BMW("Z4", 2000);
		BMW bmw2 = new BMW("Z2", 2011);
//		System.out.println(bmw1); // BMW. Modell: Z4, Baujahr 2000
		
		ArrayList<BMW> listBMW = new ArrayList<>();
		listBMW.add(bmw1);
		listBMW.add(bmw2);
		
		print(listBMW);
		
		HashSet<BMW> hashSetBMW = new HashSet<BMW>(listBMW);
		hashSetBMW.add(new BMW("Z4", 2000));
		
		print(hashSetBMW);
		
		TreeSet<BMW> treeSetBMW = new TreeSet<>(listBMW);
		
		print(treeSetBMW);
		
		vw1.equals(bmw1);
		// vw1.compareTo(bmw1); // VW implementiert Comparable<VW>
		
		ArrayDeque<BMW> arrayDequeBMW = new ArrayDeque<>(listBMW);
		
		print(arrayDequeBMW);
		
		/*
		 * A7, A8
		 */
		System.out.println("*** A7, A8");
		
		print(hashSetBMW);
		
		System.out.println("bmw1: " + bmw1);
		
		System.out.println("contains: " + hashSetBMW.contains(bmw1)); // true
		
		bmw1.setBaujahr(2044);
		
		print(hashSetBMW);
		
		System.out.println("bmw1: " + bmw1);
		
		System.out.println("contains: " + hashSetBMW.contains(bmw1)); // false
		
		/*
		 * A9
		 */
		System.out.println("*** A9");
		
		listVW.add(new VW("Polo", 2200));
		
		print(listVW);
		
		/*
		 * A10
		 */
		System.out.println("*** A10. Flasche Suche! Liste ist nicht sortiert!");
		
		int pos = Collections.binarySearch(listVW, new VW("Polo", 2200));
		System.out.println("Polo 2200 gefunden an: " + pos); // 3
		
		pos = Collections.binarySearch(listVW, new VW("Golf", 1988));
		System.out.println("Golf 1988 gefunden an: " + pos); // -1
		
		/*
		 * A11
		 */
		System.out.println("*** A11");
		Collections.sort(listVW);
		print(listVW);
		
		pos = Collections.binarySearch(listVW, new VW("Polo", 2200));
		System.out.println("Polo 2200 gefunden an: " + pos); // 3
		
		pos = Collections.binarySearch(listVW, new VW("Golf", 1988));
		System.out.println("Golf 1988 gefunden an: " + pos); // 0
		
		/*
		 * A12
		 */
		System.out.println("*** A12");
		
		Collections.sort(listVW, Comparator.reverseOrder());
		print(listVW);
		
		/*
		 * A13
		 */
		System.out.println("*** A13");
		
		pos = Collections.binarySearch(listVW, new VW("Polo", 2200));
		System.out.println("Falsche Suche, Liste wurde nicht natürlich aufsteigend sortiert: ");
		System.out.println("Polo 2200 gefunden an: " + pos); // -5

		pos = Collections.binarySearch(listVW, new VW("Polo", 2200), Comparator.reverseOrder());
		System.out.println("Polo 2200 gefunden an: " + pos); // 0
		
		/*
		 * A14
		 */
		System.out.println("*** A14");
		
		System.out.println("Falsche Suche: ");
		pos = Collections.binarySearch(listVW, new VW("Polo", 3300));
		System.out.println("Polo 3300 gefunden an: " + pos); // -5
		
		System.out.println("Richtige Suche: ");
		pos = Collections.binarySearch(listVW, new VW("Polo", 3300), Comparator.reverseOrder());
		System.out.println("Polo 3300 gefunden an: " + pos); // -1
		
	}
	
	static void print(Collection<? extends Auto> autos) {
		System.out.println("* autos in " + autos.getClass().getSimpleName() + ": ");
		
		int i = 0;
		for(Auto a : autos) {
			System.out.println( i++ + ". " + a);
		}
	}

}
