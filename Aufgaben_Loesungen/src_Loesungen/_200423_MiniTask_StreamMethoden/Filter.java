package _200423_MiniTask_StreamMethoden;

import java.util.Arrays;
import java.util.List;

public class Filter {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", null, "bb", null, "ccc");
		
		list.stream()
			.filter(x -> x != null && x.length() >= 2)
			.forEach(System.out::println);
	}
}
