package _200505_IO_saveLoad_Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class saveLoadArray_run {
	private static String path = "./src_Loesungen/_200505_IO_saveLoad_Array/files/";

	public static void main(String[] args) {
		try {
			System.out.println("aktuelles Arbeitsverzeichnis: " + new File(".").getAbsoluteFile().getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		testGetRandom(-20, 20, 10);
		
		int[] arr = createArray(new Random().nextInt(20)+1, -20, 20);
		printArray(arr, "Array ... nach dem Erzeugen: ");
		
		saveArray(arr, "IntArr.csv");
		arr = loadArray("IntArr.csv");
		printArray(arr, "Array ... nach dem schreiben/Lesen in/aus der Datei: ");
		
	}

	public static void saveArray(int[] arr, String fileName) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter(path + fileName)))) {
			for (int i : arr) {
				out.write(String.valueOf(i)+",");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int[] loadArray(String fileName) {
		String temp = null;
		try (BufferedReader in = new BufferedReader(new FileReader(path + fileName))) {
			temp = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (temp != null) {
			String[] tmpArr = temp.split(",");
			int[] newArr = new int[tmpArr.length];
			
			for (int i = 0; i < newArr.length; i++) {
				newArr[i] = Integer.parseInt(tmpArr[i]);
			}
			return newArr;
		} else {
			return new int[1];
		}
	}

	public static int[] createArray(int length, int min, int max) {
		int[] arr = new int[length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = getRandom(min, max);
		}
		
		return arr;
	}
	
	private static int getRandom(int min, int max) {
		Random rand = new Random();
		return (rand.nextInt(max-min+1) + min);
	}
	
	private static void printArray(int[] arr, String msg) {
		System.out.println(msg);
		for (int i : arr) {
			System.out.println(i);
		}
		System.out.println();
	}
	
	@SuppressWarnings(value = {"unused"})
	private static void testGetRandom(int min, int max, int numOfRandoms) {
		System.out.println("*** Test 'getRandom()' with min: " + min + " max: " + max + " (" + numOfRandoms + " times).");
		
		List<Integer> list = new ArrayList<>();
		Stream.generate( () -> getRandom(min, max))
			.limit(numOfRandoms)
			.forEach(i -> list.add(i));
		
		int maxInside = list.stream().reduce((a, b) -> a>b ? a : b).get();
		int minInside = list.stream().reduce((a, b) -> a<b ? a : b).get();
		
		System.out.println("List max: " + maxInside);
		System.out.println("List min: " + minInside);
		
		if (max >= maxInside && min <= minInside) {
			System.out.println("Result in line with expectations!".toUpperCase());
		} else {
			System.out.println("The result does not meet expectations".toUpperCase());
		}	
	}
}
