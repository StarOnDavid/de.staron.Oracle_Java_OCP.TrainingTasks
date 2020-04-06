package _200403_Tracing_deferred_evaluation_Supplier;

import java.util.function.Supplier;

public class MyTracer {
	public enum Level {
		NONE, TRACE
	}
	
	private Level level;
	
	public MyTracer(Level level) {
		this.level = level;
	}
	
	public void setLevel (Level newLevel) {
		this.level = newLevel;
	}

	public void trace(Supplier<String> sup) {
		if (level == Level.TRACE) {
			String message = sup.get();
			System.out.println(message);
		}
	}
}
