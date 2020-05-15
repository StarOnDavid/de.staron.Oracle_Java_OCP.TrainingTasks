package _200515_Threads_Logger;

@SuppressWarnings("unused")
public class ThreadsLogger_run {
	
	private static class MyLogRunner implements Runnable {
		private MyLogger logger;
		
		public MyLogRunner(int n) {
			switch (n) {
			case 2:
				logger = new MyLogger2();
				break;
			default:
				logger = new MyLogger();
				break;
			}
		}

		@Override
		public void run() {
			Thread th = Thread.currentThread();
			logger.addMessage(th.getName() + " " +  th.getId(), th.getState().name());
		}
		
		private String getLog() {
			return logger.getLog();
		}
	}

	public static void main(String[] args) {
		int numOfLoops = 1000;
		//** A1
//		for(int i = 0; i < numOfLoops; i++)
//			a1();
		
		//** A2
		for(int i = 0; i < numOfLoops; i++)
			a2();
	}

	private static void a2() {
		MyLogRunner myLogger = new MyLogRunner(2);
		testTowThreads(myLogger);
	}

	private static void a1() {
		MyLogRunner myLogger = new MyLogRunner(1);
		testTowThreads(myLogger);
	}

	private static void testTowThreads(MyLogRunner myLogger) {
		Thread thA = new Thread(myLogger);
		Thread thB = new Thread(myLogger);
		
		thA.setName("Thread A");
		thB.setName("Thread B");
		
		thA.start(); thB.start();
		try {
			thA.join(); thB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Out MyLogger: \n" + myLogger.getLog());
	}
}
