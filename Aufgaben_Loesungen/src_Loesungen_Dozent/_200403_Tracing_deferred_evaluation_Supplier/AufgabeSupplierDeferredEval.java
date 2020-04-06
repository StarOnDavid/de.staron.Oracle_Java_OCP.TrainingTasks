package _200403_Tracing_deferred_evaluation_Supplier;

import java.util.function.Supplier;

class MyTracerDozent {
	public enum Level {
		NONE, TRACE
	}
	
	private Level level;
	
	public MyTracerDozent(Level level) {
		this.level = level;
	}

	public void setLevel(Level newLevel) {
		this.level = newLevel;
	}

//	public void trace(String message) {
//		if (level == Level.TRACE) {
//			System.out.println(message);
//		}
//	}
	public void trace(Supplier<String> s) {
		if (level == Level.TRACE) {
			String message = s.get();
			System.out.println(message);
		}
	}
}

class FooDozent {
	MyTracer tracer = new MyTracer(MyTracer.Level.TRACE);
	
	public void m(String[] args) {
		
		Supplier<String> s = () -> "args length: " + args.length + " ...";
		
//		tracer.trace("args length: " + args.length);
		tracer.trace(s);
		//...
	}
}


public class AufgabeSupplierDeferredEval {

	public static void main(String[] args) {
		

	}

}
