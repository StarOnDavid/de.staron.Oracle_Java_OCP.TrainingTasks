package _200428_MiniTask_CollectV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect_V1 {
	
	static class Blume implements Comparable<Blume> {
		int preis;

		public Blume(int preis) {
			this.preis = preis;
		}

		@Override
		public String toString() {
			return "Blume (" + preis + ")";
		}

		@Override
		public int compareTo(Blume b) {
			return this.preis-b.preis;
		}
	}

	public static void main(String[] args) {

		Integer[] preise = {
			1, 2, 3	
		};

		/*
		 * Mit einer Pipline bitte Preise aus dem Array in Blumen 
		 * verwandeln und in einem TreeSet sammeln.
		 */
		
		Supplier<TreeSet<Blume>> supplier = () -> new TreeSet<>();
		BiConsumer<TreeSet<Blume>, Integer> accumulator = (list, x) -> list.add(new Blume(x));
		BiConsumer<TreeSet<Blume>, TreeSet<Blume>> combiner = (listA, listB) -> listA.addAll(listB); 
		
		TreeSet<Blume> blumen = Arrays.stream(preise).collect(supplier, accumulator, combiner);
		
		for(Blume b : blumen) {
			System.out.println(b);
		}
	}

}
