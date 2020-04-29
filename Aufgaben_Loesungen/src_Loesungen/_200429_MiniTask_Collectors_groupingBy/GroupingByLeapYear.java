package _200429_MiniTask_Collectors_groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupingByLeapYear {
	private static List<Integer> years = new ArrayList<>();

	public static void main(String[] args) {
		genYears();
		groupByLeapYear();
	}

	private static void groupByLeapYear() {

		Function<Integer, Boolean> classifier = year -> { return isLeap(year); };
		Collector<Integer, ?, Map<Boolean, List<Integer>>> collector = Collectors.groupingBy(classifier);
		Map<Boolean, List<Integer>> leapYear = years.stream().collect(collector);
		

		for(boolean leap : leapYear.keySet()) {
			System.out.println("\nIs leap: " + leap);
			List<Integer> years = leapYear.get(leap);
			System.out.println("Found " + years.size() + " years:");
			for(int i = 0; i < years.size(); i++) {
				System.out.print(years.get(i) + " " );
				if(i-1%20 == 0 && i==0) {
					System.out.println();
				}
			}
			System.out.println();
		}
	}

	private static void genYears() {
		for(int i = 1901; i <= 2020; i++) {
			years.add(i);
			System.out.print(i + " ");
			if(i%20 == 0 && i != 1900 && i != 2020) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public static boolean isLeap ( int year ) {
	      if ( year % 400 == 0 ) 
	     return true ;
	      if ( ( year % 4 == 0 ) && ( ! ( year % 100 == 0 ))) 
	     return true ;
	      return false ;
	    }

}
