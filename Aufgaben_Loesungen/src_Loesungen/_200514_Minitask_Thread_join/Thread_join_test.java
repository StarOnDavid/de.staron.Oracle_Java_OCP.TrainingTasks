package _200514_Minitask_Thread_join;

import java.util.ArrayList;
import java.util.List;

import _200429_Project_Words_funkt_Streams.Words;

public class Thread_join_test {

	
	public static void main(String[] args) {
		LoadWords runLoadWors = new LoadWords();
		Thread thLoadWords = new Thread(runLoadWors);
		
		List<ThreadAndData> trList = new ArrayList<>();
		for(int i = 0; i < 26; i++) {
			WordsWith runWords = new WordsWith(runLoadWors, thLoadWords, String.valueOf((char) (97 + i)));
			Thread thWords = new Thread(runWords);
			trList.add(new ThreadAndData(thWords, runWords));
		}
		
		thLoadWords.start();
		
		for (ThreadAndData tad : trList) {
			tad.thread.start();
		}
		
		PrintResults runPrint = new PrintResults(trList);
		Thread thPrint = new Thread(runPrint);
		thPrint.start();

	}

	 private static class LoadWords implements Runnable {
		
			private volatile List<String> words;
			
			public void run() {
				System.out.println("Start 'LoadWords' Thread.");
				words = Words.englishWords();
				System.out.println("Finish 'LoadWords' Thread.");
			}
	}
	 
	private static class PrintResults implements Runnable {
		private volatile List<ThreadAndData> thads;
		
		public PrintResults(List<ThreadAndData> tads) {
			this.thads = tads;
		}
		@Override
		public void run() {
			System.out.println("Start 'PrintResults' Thread.");
			for (ThreadAndData threadAndData : thads) {
				try {
					threadAndData.thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("\nThe Results:\n");
			
			for (ThreadAndData tad : thads) {
				System.out.println("Words with '" + tad.data.searched +
									"': " + tad.data.numWords_t +
									"\nBenötigte Zeit: " + tad.data.time + " Sek.\n");
				
			}
			
			System.out.println("Finish 'PrintResults' Thread.");
		}
		
	}
	
	private static class WordsWith implements Runnable {
		private LoadWords loaded;
		private Thread thLoad;
		private volatile String searched;
		private volatile long numWords_t;
		private volatile double time;
		
		public WordsWith(LoadWords runLoadWords, Thread thLoad, String searched) {
			this.loaded = runLoadWords;
			this.thLoad = thLoad;
			this.searched = searched;
		}
		
		public void run() {
			System.out.println("Start 'WordsWith' searching for '" + searched + "' Thread.");
			long start = System.currentTimeMillis();
			try {
				thLoad.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			List<String> words = loaded.words;
			
			numWords_t = words.stream()
							.filter(s -> s.contains(this.searched))
							.count();
			this.time = (System.currentTimeMillis()-start)/1000.;
			System.out.println("Finish 'WordsWith' searching for '" + searched + "' Thread.");
		}
	}
	
	private static class ThreadAndData {
		WordsWith data;
		Thread thread;
		
		public ThreadAndData (Thread th, WordsWith data) {
			this.thread = th;
			this.data = data;
		}
	}

}
