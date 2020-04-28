package _200428_Stream_collect_Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectNumbers {
	private static String[] arr = {
									"1,2,3,4,5",
									"7,6,5,4,3",
									"123,456",
								};
	private static List<Integer> list;

	public static void main(String[] args) {
//		given();
//		a1();
		a2();
		System.out.println(list);
	}

	private static void a1() {
		Function<String[], Stream<String>> mapper = sArr -> Arrays.stream(sArr);
		
		
		list = Arrays.stream(arr)
			.map(s -> s.split(","))
			.flatMap(mapper)
			.collect( () -> new ArrayList<>(),						//supplier: 	Zieldatentyp
					  (list, x) -> list.add(Integer.parseInt(x)),	//accumulator:	Umwandlung und hinzufügen zum Zieldatentyp
					  (listA, listB) -> listA.addAll(listB)			//combiner: 	zusammen bauen von zwischenergebnissen
					  );
		
	}
	
	private static void a2() {
		Function<String[], Stream<String>> mapper = sArr -> Arrays.stream(sArr);
		
		
		list = Arrays.stream(arr)
			.map(s -> s.split(","))
			.flatMap(mapper)
			.filter(x -> (Integer.parseInt(x)%2) == 0)
			.collect( () -> new ArrayList<>(),						//supplier: 	Zieldatentyp
					  (list, x) -> list.add(Integer.parseInt(x)),	//accumulator:	Umwandlung und hinzufügen zum Zieldatentyp
					  (listA, listB) -> listA.addAll(listB)			//combiner: 	zusammen bauen von zwischenergebnissen
					  );
		
	}

	private static void given() {
		list = new ArrayList<>();
		for (String s : arr) {
			String[] stringNumbers = s.split(",");
			
			for (String sNum : stringNumbers) {
				Integer num = Integer.valueOf(sNum);
				list.add(num);
			}
		}
	}

}
