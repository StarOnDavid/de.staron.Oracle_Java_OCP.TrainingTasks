package _200515_Threads_Logger;

public class MyLogger {
	protected StringBuilder sb = new StringBuilder();
	
	public void addMessage(String caller, String message) {
		sb.append(caller)
		  .append(" - ")
		  .append(message)
		  .append("\n");
	}
	
	public String getLog() {
		return sb.toString();
	}
}