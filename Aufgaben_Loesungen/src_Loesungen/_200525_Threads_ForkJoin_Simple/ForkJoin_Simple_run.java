package _200525_Threads_ForkJoin_Simple;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoin_Simple_run  {
	
	static class MyRecursiveAction extends RecursiveAction {
		private final int MAX_ELEMENTS;
		
		private int indexStart, indexEnd;

		public MyRecursiveAction( int indexStart, int indexEnd, int max_elements) {
			this.MAX_ELEMENTS = max_elements;
			this.indexStart = indexStart;
			this.indexEnd = indexEnd;
		}
		@Override
		protected void compute() {
			
			
			if( indexEnd - indexStart < MAX_ELEMENTS ) {
				System.out.println("Unterbereich " + indexStart + " bis " + indexEnd);
				
			} else {
				
				int indexMitte = (indexEnd-indexStart) / 2 + indexStart;
			
				RecursiveAction lower = new MyRecursiveAction(indexStart, indexMitte, MAX_ELEMENTS);
				RecursiveAction upper = new MyRecursiveAction(indexMitte+1, indexEnd, MAX_ELEMENTS);
				
				invokeAll(lower, upper);
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool();
		
		MyRecursiveAction action = new MyRecursiveAction(1, 9, 3);
		pool.invoke(action);
		
	}

	
}
