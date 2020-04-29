package _200428_Stream_collect_Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AufgabeCollectNumbers {

	public static void main(String[] args) {
		String[] arr = { "1,2,3,4,5", "7,6,5,4,3", "123,456", };

		List<Integer> list;

		System.out.println("** ohne Stream:");
		// A
		list = new ArrayList<>();
		for (String s : arr) {
			String[] stringNumbers = s.split(",");

			for (String sNum : stringNumbers) {
				Integer num = Integer.valueOf(sNum);
				list.add(num);
			}
		}
		// B

		System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]

		System.out.println("** mit Stream, collect v2:");
		
		list = Arrays.stream(arr) // Stream<String> 
						.map(s -> s.split(",")) // Stream<String[]> 
						.flatMap(Arrays::stream) // Stream<String> 
						.map(Integer::valueOf) // Stream<Integer>
						//.filter(x -> x%2==0) // Aufgabe A2
						.collect(Collectors.toCollection(ArrayList::new));
		
		System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]
		
		System.out.println("** mit Stream, collect v1:");
		
		Supplier<List<Integer>> supplier = ArrayList::new;
		BiConsumer<List<Integer>, String> accumulator = (targetList, s) -> {
			String[] stringNumbers = s.split(",");

			for (String sNum : stringNumbers) {
				Integer num = Integer.valueOf(sNum);
				//if( num%2==0 ) // Aufgabe A2
				targetList.add(num);
			}
		};
		BiConsumer<List<Integer>, List<Integer>> combiner = List::addAll;
		list = Arrays.stream(arr).collect(supplier, accumulator, combiner);
		
		System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]
	}

}
