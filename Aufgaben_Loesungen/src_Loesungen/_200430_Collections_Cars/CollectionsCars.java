package _200430_Collections_Cars;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class CollectionsCars {
	private enum Collection { LL, HS, TS, PQ, AL, AD }
	private static Car vw1 = new VW("T1", 1962);
	private static Car vw2 = new VW("T2", 1969);
	private static Car vw3 = new VW("Karmann-Ghia", 1965);
	
	private static Car bmw1 = new BMW("1600 GT", 1967);
	private static Car bmw2 = new BMW("Isetta", 1959);
	
	private static LinkedList<Car> ll = new LinkedList<>();
	private static HashSet<Car> hs = new HashSet<>();
	private static TreeSet<Car> ts = new TreeSet<>();
	private static PriorityQueue<Car> pq = new PriorityQueue<>();
	
	private static ArrayList<Car> al = new ArrayList<>();
	private static HashSet<Car> hs2 = new HashSet<>();
	private static TreeSet<Car> ts2 = new TreeSet<>();
	private static ArrayDeque<Car> ad = new ArrayDeque<>();
	

	public static void main(String[] args) {
//		a2();
		
//		a4();
//		a5(Collection.LL);
//		a5(Collection.HS);
//		a5(Collection.TS);
//		a5(Collection.PQ);
		
//		a6_1();
//		a6_2(Collection.AL);
//		a6_2(Collection.HS);
//		a6_2(Collection.TS);
//		a6_2(Collection.AD);
//		
//		a7();
//		
//		a8();
		
//		a9();
		
//		a10();
		
//		a11();
		
		a12();
	}
	
	private static void a12() {
		a9();
		Collections.sort(al, (a, b) -> b.compareTo(a) );
		System.out.println("Nach dem revers Sotieren ... ");
		a6_2(Collection.AL);
	}
	
	private static void a11() {
		a9();
		Collections.sort(al);
		
		System.out.println("Nach dem Sotieren ... ");
		a6_2(Collection.AL);
	}

	private static void a10() {
		a9();
		int pos = Collections.binarySearch(al, new BMW("509", 1958));
		System.out.println("The BMW 507 found at: " + pos);
		
		pos = Collections.binarySearch(al, bmw1);
		System.out.println("The BMW 1600 GT found at: " + pos);
		
		pos = Collections.binarySearch(al, al.get(2));
		System.out.println("The " + al.get(2) + " found at: " + pos);
		
		/*
		 * Bin mir nicht mehr sicher ... es wird nach der Objekt-Referenz gesucht?!?
		 * aber wieso funktionier diese Zeile nicht:
		 * pos = Collections.binarySearch(al, al.get(2));
		 */
	}

	private static void a9() {
		a6_1();
		al.add(new BMW("507", 1958));	
		a6_2(Collection.AL);
	}



	private static void a8() {
		((BMW) bmw1).setYoM(1968);
		System.out.println("Year of manufacture changed to '1968'.");
		a6_2(Collection.HS);
		
		a7();	
		/*
		 * Die 'HashSet.contains(x)' nutzt den HashCode einer Instanz um das Objekt im HashSet zu suchen.
		 * Beim anlegen des HashCodeBucked im HashSet wurde allerdings der HashCode mit Baujahr 1967 benutzt. Daher kann 'bmw1'
		 * mit dem neuen HashCode für Baujahr 1968 nicht gefunden werden.
		 */
	}

	private static void a7() {
		boolean cont = hs2.contains(bmw1);
		System.out.println("The HashSet contains " + bmw1 + " : " + cont + "\n");
	}

	private static void a6_1() {
		al.addAll(Arrays.asList(bmw1, bmw2));
		hs2.addAll(Arrays.asList(bmw1, bmw2));
		ts2.addAll(Arrays.asList(bmw1, bmw2));
		ad.addAll(Arrays.asList(bmw1, bmw2));
	}

	@SuppressWarnings("incomplete-switch")
	private static void a6_2(Collection col) {
		switch(col) {
		case AL:
			System.out.println("*** ArrayList:");
			for (Car car : al)
				System.out.println(car);
			System.out.println();
			break;
		case HS:
			System.out.println("*** HashSet:");
			for (Car car : hs2)
				System.out.println(car);
			System.out.println();
			break;
		case TS:
			System.out.println("*** TreeSet:");
			for (Car car : ts2)
				System.out.println(car);
			System.out.println();
			break;
		case AD:
			System.out.println("*** ArrayDeque:");
			for (Car car : ad)
				System.out.println(car);
			System.out.println();
			break;
		}
	}
	
	private static void a4() {
		ll.addAll(Arrays.asList(vw1, vw2, vw3));
		
		hs.addAll(Arrays.asList(vw1, vw2, vw3));
		
		ts.addAll(Arrays.asList(vw1, vw2, vw3));
		
		pq.addAll(Arrays.asList(vw1, vw2, vw3));
	}
	
	@SuppressWarnings("incomplete-switch")
	private static void a5(Collection col) {
		switch(col) {
		case LL:
			System.out.println("*** LinkedList:");
			for (Car car : ll)
				System.out.println(car);
			System.out.println();
			break;
		case HS:
			System.out.println("*** HashSet:");
			for (Car car : hs)
				System.out.println(car);
			System.out.println();
			break;
		case TS:
			System.out.println("*** TreeSet:");
			for (Car car : ts)
				System.out.println(car);
			System.out.println();
			break;
		case PQ:
			System.out.println("*** PriorityQueue:");
			for (Car car : pq)
				System.out.println(car);
			System.out.println();
			break;
		}
	}

	private static void a2() {
		List<Car> cars = Arrays.asList(new VW("Golf", 1990), new BMW("Z4", 2000));

		for (Car car : cars) {
			System.out.println(car);
		}
	}
}
