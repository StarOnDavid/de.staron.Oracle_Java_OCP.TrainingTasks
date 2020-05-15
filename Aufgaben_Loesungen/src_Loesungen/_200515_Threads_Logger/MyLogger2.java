package _200515_Threads_Logger;

public class MyLogger2 extends MyLogger {
	
	public void addMessage(String caller, String message) {
		synchronized (sb) {
			sb.append(caller)
			  .append(" - ")
			  .append(message)
			  .append("\n");
		}
	}
}