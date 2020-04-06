package _200403_Tracing_deferred_evaluation_Supplier;

import java.util.function.Supplier;

public class Foo {
	private static MyTracer tracer = new MyTracer(MyTracer.Level.TRACE);
	
	public static void m(String[] args) {	
		Supplier<String> sup = () -> "args length: " + args.length;
		tracer.trace(sup);
	}
}