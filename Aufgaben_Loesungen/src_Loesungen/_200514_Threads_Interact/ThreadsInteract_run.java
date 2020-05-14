package _200514_Threads_Interact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

@SuppressWarnings("unused")
public class ThreadsInteract_run {

	public static void main(String[] args) {
//		a1();
//		a2();
//		a3();
		a4();
	}
	
	private static void a4() {
		CountTo runCountUP = new CountTo(1_000_000, true);
		Thread thCountUP = new Thread(runCountUP);
		
		CountTo runCountDOWN = new CountTo(1_000_000, false);
		Thread thCountDOWN = new Thread(runCountDOWN);
		
		thCountUP.start();
		thCountDOWN.start();
		
		while(thCountDOWN.isAlive() || thCountUP.isAlive()) {
			System.out.println("Running: " + CountTo.count);
		}
		
		System.out.println("\nFinish: " + CountTo.count);
	}

	private static void a3() {
		CountTo runCount = new CountTo(1_000_000, true);
		Thread thCount = new Thread(runCount);
		
		thCount.start();
		
		while(thCount.isAlive()) {
			System.out.println("Running: " + CountTo.count);
		}
		
		System.out.println("\nFinish: " + CountTo.count);
	}

	private static void a2() {
		GenRan gen20 = new GenRan(20, 100);
		GenRan gen30 = new GenRan(30, 100);
		
		Thread th20 = new Thread(gen20);
		Thread th30 = new Thread(gen30);
		
		th20.start();
		th30.start();
		
		try {
			th20.join();
			th30.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<Integer> randoms = new ArrayList<>();
		randoms.addAll(Arrays.asList(gen20.randoms));
		randoms.addAll(Arrays.asList(gen30.randoms));
		
//		Integer identity = 0;
//		BiFunction<Integer, Integer, Integer> accumulator = (a, b) -> a + b;
//		BinaryOperator<Integer> combiner = (erg1, erg2) -> erg1 + erg2;
		
		Integer sum = randoms.stream()
							.parallel()
							.reduce(
									0,
									(a, b) -> a + b,
									(erg1, erg2) -> erg1 + erg2
									);
		
		System.out.println("Sum of all Randoms is: " + sum);
	}

	private static void a1() {
		Endless runEndless = new Endless();
		Thread thEndless = new Thread(runEndless);
		
		thEndless.start();
		
		try {
			Thread.sleep(5050);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thEndless.interrupt();
		
	}

	private static class Endless implements Runnable {
		
		@Override
		public void run() {
			Thread th = Thread.currentThread();
			th.setName("Endless");
			long millis = 1000;
			while(true) {
				System.out.println("I'm " + th.getName() + "    :-P");
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
					System.out.println(th.getName() + ": 'Some one interupted my endlessness :-(");
					break;
				}
				
			}
		}
	}
	
private static class GenRan implements Runnable {
		private int max;
		private volatile Integer[] randoms;
		
		public GenRan(int numOfRandoms, int maxRandom) {
			this.randoms = new Integer[numOfRandoms];
			this.max = maxRandom;
		}
		
		@Override
		public void run() {
			Random rand = new Random();
			for(int i = 0; i < randoms.length; i++) {
				this.randoms[i] = rand.nextInt(max);
			}
		}
	}

private static class CountTo implements Runnable {
	private volatile static int count = 0;
	private int to;
	private boolean up;
	
	public CountTo(int countTo, boolean up) {
		this.to = countTo;
		this.up = up;
	}
	
	@Override
	public void run() {
		Random rand = new Random();
		for(int i = 0; i < to; i++) {
			if(up)
				count++;
			else
				count--;
//			try {
//				Thread.sleep(2);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}
}
