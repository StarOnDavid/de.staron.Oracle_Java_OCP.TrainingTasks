# Aufgabe 'Threads - Logger'

Gegeben ist die Klasse `MyLogger`:

	public class MyLogger {
		private StringBuilder sb = new StringBuilder();
		
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
	
###### A1.
Testen Sie bitte die aktuelle (nicht-threadsichere Klasse). Versuchen Sie den Test so zu gestalten, dass die Fehler erkennbar sind.
	
###### A2.
Bitte gestalten Sie die Klasse `MyLogger` threadsicher (nach Oracle), so dass mehrere Threads, die sich denselben Logger teilen, 'saubere' Zeilen mit der Methode 'addMessage' im StringBuilder erstellen und die getLog-Methode keine 'halbfertige' Zeilen aus dem StringBuilder liefert.

Achten Sie darauf keine unnötige Synchronisation einzuführen.

###### A3.
Wird das Ersetzen vom `StringBuilder`durch einen `StringBuffer` die Klasse `MyLogger` threadsicher gestalten?