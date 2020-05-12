package _200505_IO_Save_Load_Array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class AufgabeSaveLoadArray {

	public static void main(String[] args) {

		int len = new java.util.Random().nextInt(100) + 1;
		int[] arr1 = createArray(len, -20, 20);

		System.out.println("arr1: " + Arrays.toString(arr1));

		/*
		 * ohne Serialisieren
		 */
		try {
			saveArray(arr1, "array.txt");
			
		} catch (FileNotFoundException e) {
			System.out.println("Fehler! Die Datei kann nicht erstellt werden: " + e.getMessage());
			return;
		}

		try {
			int[] arr2 = loadArray("array.txt");
			System.out.println("arr2: " + Arrays.toString(arr2));
		} catch (IOException e) {
			System.out.println("Fehler! Die Datei kann nicht gelesen werden: " + e.getMessage());
		}
		
		/*
		 * Mit dem Serialisieren
		 */
		
		try {
			saveArray2(arr1, "array2.txt");
			
			int[] arr2b = loadArray2("array2.txt");
			
			System.out.println("arr2b: " + Arrays.toString(arr2b));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int[] createArray(int len, int min, int max) {
		int[] arr = new int[len];
		
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(max - min + 1) + min;
		}
		
		return arr;
	}
	
	
	static void saveArray(int[] array, String fileName) throws FileNotFoundException {
		try( PrintWriter out = new PrintWriter(fileName) ) {
			for(int x : array) {
				// out.write(x); // Falsch so, speichert man nur ein Zeichen 
				out.println(x); // Zahl als mehrere Zeichen speichern
			}
		}
	}
	
	static int[] loadArray(String fileName) throws FileNotFoundException, IOException {
		
		List<String> lines = new ArrayList<>();
		
		try(BufferedReader in = new BufferedReader( new FileReader(fileName) )) {
			String line;
			while( (line=in.readLine()) != null ) {
				lines.add(line);
			}
		}
		
		return lines.stream() // Stream<String>
				.mapToInt(Integer::parseInt) // IntStream
				.toArray(); // int[]
	}
	
	
	static void saveArray2(int[] array, String fileName) throws IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(array);
		}
	}
	
	static int[] loadArray2(String fileName) throws IOException, ClassNotFoundException {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (int[])in.readObject();
		}
	}
		
}
