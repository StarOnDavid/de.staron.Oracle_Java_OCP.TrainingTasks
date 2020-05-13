package _200513_MiniTask_ThreadStarts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class StartThreads {

	public static void main(String[] args) {
		/*
		 * A1.
		 * Starten Sie bitte aus dem main-Thread 10 weitere Threads
		 */
//		a1();
	
		/*
		 * A2.
		 *
		 * target ist gegeben:
		 * Runnable target = () -> System.out.println("run");
		 *
		 * Erzeugen Sie mit einer Pipeline eine List mit 5 Threads (im Zustand NEW),
		 * die dieselbe target zugewiesen bekommen haben.
		 *
		 * Danach die Threads aus der Liste starten
		 */
		a2();
				
	}

	private static void a2() {
		Runnable target = () -> System.out.println("run");
		List<Thread> ths = Stream.generate( () -> new Thread( target))
				.limit(5)
				.collect(Collectors.toList());
		
		for (Thread th : ths) {
			th.start();
		}
	}

	private static void a1() {
		for (int i = 0; i < 5; i++) {
			final int x = i;
		Thread th = new Thread(() -> System.out.println("run th" + x));
		th.run();
		}
	}
}
