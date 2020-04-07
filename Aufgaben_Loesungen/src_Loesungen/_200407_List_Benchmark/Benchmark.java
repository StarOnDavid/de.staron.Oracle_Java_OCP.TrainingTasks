package _200407_List_Benchmark;

import java.util.List;

public class Benchmark {

	public static long testAddFirst (List<Integer> list, int n) {
		if (n < 1 )
			return -1L;
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			list.add(0, i);
		}
		return System.currentTimeMillis() - start;
	}
	
	public static long testAdd (List<Integer> list, int n) {
		if (n < 1 )
			return -1L;
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			list.add(i);
		}
		return System.currentTimeMillis() - start;
	}
	
	public static long testAddLast (List<Integer> list, int n) {
		if (n < 1 )
			return -1L;
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			list.add(list.size(), i);
		}
		return System.currentTimeMillis() - start;
	}
	
	public static long testGetM (List<Integer> list, int m) {
		if (m < 0 )
			return -1L;
		long start = System.currentTimeMillis();
		list.get(m);
		return System.currentTimeMillis() - start;
	}
}
