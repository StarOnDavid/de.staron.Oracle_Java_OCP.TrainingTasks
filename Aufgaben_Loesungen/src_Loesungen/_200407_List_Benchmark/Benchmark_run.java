package _200407_List_Benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Benchmark_run {
	private static List<Integer> arrList = new ArrayList<>();
	private static List<Integer> linkList = new LinkedList<>();
	
	private static final int N = 500000;
	private static final int M = 250000;

	public static void main(String[] args) {
		System.out.println("\n--- Starting List - Benchmark ---");
		
		System.out.println("\nTest 'addFirst' with 'ArrayList<Integer>' and N = " + N + " needs: " +
							Benchmark.testAddFirst(arrList, N) + "ms");
		System.out.println("Test 'addFirst' with 'LinkedList<Integer>' and N = " + N + " needs: " +
							Benchmark.testAddFirst(linkList, N) + "ms");

		newLists();
		System.out.println("\nTest 'add' with 'ArrayList<Integer>' and N = " + N + " needs: " +
							Benchmark.testAdd(arrList, N) + "ms");
		System.out.println("Test 'add' with 'LinkedList<Integer>' and N = " + N + " needs: " +
							Benchmark.testAdd(linkList, N) + "ms");
		
		newLists();
		System.out.println("\nTest 'addLast' with 'ArrayList<Integer>' and N = " + N + " needs: " +
						Benchmark.testAddLast(arrList, N) + "ms");
		System.out.println("Test 'addLast' with 'LinkedList<Integer>' and N = " + N + " needs: " +
						Benchmark.testAddLast(linkList, N) + "ms");
		
		System.out.println("\nTest 'get' element M = " + M + " from 'ArrayList<Integer>' needs: " +
				Benchmark.testGetM(arrList, M) + "ms");
		System.out.println("Test 'get' element M = " + M + " from 'LinkedList<Integer>' needs: " +
				Benchmark.testGetM(linkList, M) + "ms");
		
		System.out.println("\n--- Benchmark Finnished ---");
	}
	
	private static void newLists() {
		arrList = new ArrayList<>();
		linkList = new LinkedList<>();
	}

}
