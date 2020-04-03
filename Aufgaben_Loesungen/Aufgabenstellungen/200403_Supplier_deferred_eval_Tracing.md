# Aufgabe 'Tracing - deferred evaluation - Supplier'

Geplannt ist folgende Klasse `MyTracer`:

	public class MyTracer {
		public enum Level {
			NONE, TRACE
		}
		
		private final Level level;
		
		public MyTracer(Level level) {
			this.level = level;
		}
	
		public void trace(String message) {
			if (level == Level.TRACE) {
				System.out.println(message);
			}
		}
		
	}
	
und die Klasse `Foo`, in der die Klasse `MyTracer` verwendet wird:	
	
		public class Foo {
			MyTracer tracer = new MyTracer(MyTracer.Level.TRACE);
			
			public void m(String[] args) {		
				tracer.trace("args length: " + args.length);
				//...
			}
		}

Bekannt ist, dass die Methode `m` sehr häufig aufgerufen wird. Da auch beim Ändern vom Tracing-Level im `tracer` auf MyTracer.Level.NONE bei jedem Aufruf der Methode `m` der neue String gebildet wird, wurde es entschieden die Methode `trace` so zu ändern, dass das Bilden vom String nur dann stattfindet, wenn Level.TRACE gesetzt war. Übernehmen Sie bitte die Aufgabe.

