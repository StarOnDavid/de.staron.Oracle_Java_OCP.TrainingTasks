package _200513_Threads_Simple_API;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Simple_API_run {

	public static void main(String[] args) {
//		a1();
//		a2();
//		a3();
//		a4();
		a5();
	}

	private static void a5() {
		// Bei dieser großen Anzahl von Operationen wird der Thread mit einer hohen Priorität
		// vermutlich wesentlich schneller abgeschlossen sein.
		
		Thread lowTh = new Thread(() -> bigJob());
		lowTh.setName("LOW  Priority");
		lowTh.setPriority(Thread.MIN_PRIORITY);
		
		Thread highTh = new Thread(() -> bigJob());
		highTh.setName("HIGH Priority");
		highTh.setPriority(Thread.MAX_PRIORITY);
		
		lowTh.start();
		highTh.start();
		
		/*
		 * Bei 100.000-facher Ausführung der Operationen konnte ich eine Differenz von ca. 2 Sek. feststellen.
		 * Richtig deutlich wird des bei 1.000.000-facher Ausführung! -> 23 Sek. Differenz!!!
		 */
		
	}
	
	private static void bigJob() {
		Thread th = Thread.currentThread();
		System.out.println("Starte " + th.getName()
			+ ". Priorität: " + th.getPriority());
		
		long start = System.currentTimeMillis();

		int exists = 0;
		for (int i = 0; i < 1_000_000; i++) {
			Path path = Paths.get("./"+i);
			if(Files.exists(path)) {
				exists++;
			}
		}
		
		long ende = System.currentTimeMillis();
		
		System.out.println("Thread: " + th.getName()
				+ ", Zeit: " + (ende-start)/1000. + " Sek. / " + exists);
	}

	private static void a4() {
		for(int i = 0; i < 26; i++) {
			char c = (char) (i + 65);
			new Thread( () -> System.out.println(c)).start();
		}
		
	}

	private static void a3() {
		List<Thread> ths = new ArrayList<>();
		for(int i = 0; i < 37; i++) {
			ths.add(new Thread( () -> System.out.println(Thread.currentThread().getId())));
		}
		for (Thread th : ths) {
			th.start();
		}
	}

	private static void a2() {
		Runnable target = () -> {
			Thread th = Thread.currentThread();
			th.setName("Thread A2");
			while(true) {
				System.out.println(th.getId() + " " + th.getName());
				try {
					Thread.sleep(1000l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(target).start();
		
	}

	private static void a1() {
		new MyEndlessThread().start();
	}

}
