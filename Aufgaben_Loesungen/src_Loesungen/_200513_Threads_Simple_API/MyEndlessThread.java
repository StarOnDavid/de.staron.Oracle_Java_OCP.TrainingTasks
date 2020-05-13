package _200513_Threads_Simple_API;

public class MyEndlessThread extends Thread {
	
	@Override
	public void run() {
		Thread th = Thread.currentThread();
		long millis = 1000;
		while(true) {
			System.out.println(th.getId());
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
