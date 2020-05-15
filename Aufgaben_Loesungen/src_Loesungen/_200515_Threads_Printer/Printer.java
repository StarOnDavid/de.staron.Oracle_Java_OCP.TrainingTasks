package _200515_Threads_Printer;

import java.util.stream.Stream;

public class Printer {
	private Thread th;
	
	public Printer(char sign, long inLine, int lines) {
		StringBuilder sb = new StringBuilder();
		Stream.generate(() -> sign).limit(inLine).forEach(c -> sb.append(c));
		String signs = sb.toString();
		th = new Thread( () -> {
					for(int i = 0; i < lines; i++) {
						System.out.println(signs);
					}
				}
				);
	}
	
	public void start() {
		th.start();
	}
	
}
