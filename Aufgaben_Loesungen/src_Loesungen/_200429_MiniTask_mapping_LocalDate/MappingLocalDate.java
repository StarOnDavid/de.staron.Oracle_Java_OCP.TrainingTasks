package _200429_MiniTask_mapping_LocalDate;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * Mit einer Pipeline und collect als Terminal-Op bilden Sie bitte
 * eine ArrayDeque mit LocalDate-Referenzen.
 * 
 * Als Datenquelle bitte das Array 'deltas' nehmen.
 * 
 * LocalDate-Element wird erzeugt mit 'heute' und dem Integer aus dem Array:
 * 
 *    heute + -2 Tage -> Element der Pipeline
 *    heute + -1 Tage -> Element der Pipeline
 *    heute + 5 Tage -> Element der Pipeline
 *    heute + 7 Tage -> Element der Pipeline
 *    
 * Wenn möglich, definieren Sie die Umwandlung der Zahlen in LocalDate-Elemente
 * mit einem mapping-Collector.
 */

public class MappingLocalDate {
	private static Integer[] deltas = { -2, -1, 5, 7 };
	private static LocalDate heute = LocalDate.now();

	public static void main(String[] args) {
		
		Function<Integer, LocalDate> mapper = x -> MappingLocalDate.heute.plusDays(x);
		
		Collector<LocalDate, ?, ArrayDeque<LocalDate>> downstream = Collectors.toCollection(ArrayDeque::new);
		
		Collector<Integer, ?, ArrayDeque<LocalDate>> collector = Collectors.mapping(mapper, downstream);
		
		ArrayDeque<LocalDate> dates = Arrays.stream(deltas).collect(collector);

		for(LocalDate d : dates ) {
			System.out.println(d);
		}
	}

}
