package _200515_Threads_Printer;

public class Threads_Printer_run {

	public static void main(String[] args) {	
		for(int i = 0;  i < 100; i++) {
			a1();
			System.out.println("----------------------------------------------------------");
		}
	}

	private static void a1() {
		Printer p1 = new Printer('a', 10, 20);
		  p1.start();
		  
		  Printer p2 = new Printer('*', 15, 40);
		  p2.start();
	}

}
