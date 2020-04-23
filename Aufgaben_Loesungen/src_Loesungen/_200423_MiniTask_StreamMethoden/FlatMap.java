package _200423_MiniTask_StreamMethoden;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMap {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(4, 5);
		List<Integer> list3 = Arrays.asList(6, 7, 8);
		
		Function<List<Integer>, Stream<Integer>> mapper = list -> list.stream();
		
		Stream<List<Integer>> str = Stream.of(list1, list2, list3);
		str.flatMap(mapper)
			.forEach(System.out::println);

	}

}
