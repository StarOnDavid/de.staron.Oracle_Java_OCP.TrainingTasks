package _200513_MiniTask_ThreadStarts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class Thread_API {

	public static void main(String[] args) {
		/*	A1
		 * Erzeugen Sie und starten Sie bitte einen endlosen extra-Thread,
		 * der ca. jede Sekunde seine ID ausgibt.
		 */
//		a1();
		
		/* A2
		 *
		 * Erzeugen Sie 5000 Threads im Zustand 'NEW' mit den Namen T1, T2, T3... T5000.
		 * und speichern Sie die Referenzen in einer List.
		 *
		 * Danach starten Sie die Threads.
		 *
		 * Jeder Thread soll seine ID ausgeben.
		 */
		
		a2();
	}

	private static void a2() {
		Runnable target = () -> System.out.println(Thread.currentThread().getName());
		
		List<Thread> list = IntStream.range(1, 5001)
										.mapToObj( i -> new Thread(target, "T"+i) )
										.collect(Collectors.toList());
		
		list.forEach(Thread::start);
		
	}

	private static void a1() {
		Runnable target = () -> {
			Thread th = Thread.currentThread();
			
			while(true) {
				System.out.println( th.getId() );
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(target).start();
	}

}
