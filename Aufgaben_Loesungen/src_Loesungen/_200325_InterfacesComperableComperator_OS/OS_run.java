package _200325_InterfacesComperableComperator_OS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OS_run {

	public static void main(String[] args) {
		OS[] os = {
				new OS("Linux", 3),
				new OS("Windows", 95),
				new OS("Mac", 9),
				new OS("Linux", 1)
		};
		
		System.out.println("-- after ASC sort -----\n");
		Arrays.sort(os, new MyOScmp());
		printOSArray(os);
		
		// FRAGE ... wie geht es ohne den hinzugefügten Comperator?
		int posMac = Arrays.binarySearch(os, new OS("Mac", 9), new MyOScmp());
		System.out.println("\nMac ist an pos.: " + (posMac+1));
		
		System.out.println("\n-- after DESC sort ----\n");
		
		Arrays.sort(os, new MyReverseOScmp());
		printOSArray(os);
		
		int posWin = Arrays.binarySearch(os, new OS("Windows", 95), new MyReverseOScmp());
		System.out.println("\nWindows ist an pos.: " + (posWin+1));
		
		System.out.println("\n-- after shuffle ------\n");
		shuffle(os);
		printOSArray(os);
		
	}
	
	private static void printOSArray(OS[] os) {
		for (int i = 0; i < os.length; i++) {
			System.out.println(String.format("%1$-4s", (i+1)+".") + os[i].toString());
		}
	}
	
	private static void shuffle(OS[] os) {
		Random rnd = ThreadLocalRandom.current();
	    for (int i = os.length - 1; i >= 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      System.out.println("Random-Idx: " + index);
	      // Simple swap
	      OS tmp = os[index];
	      os[index] = os[i];
	      os[i] = tmp;
	    }
	}
}

class MyOScmp implements Comparator<OS> {

	@Override
	public int compare(OS o1, OS o2) {
		return 	o1.getName().compareTo(o2.getName()) + 
				o1.getVersion().compareTo(o2.getVersion());
	}
}

class MyReverseOScmp implements Comparator<OS> {

	@Override
	public int compare(OS o1, OS o2) {
		return 	o2.getName().compareTo(o1.getName()) + 
				o2.getVersion().compareTo(o1.getVersion());
	}
}
