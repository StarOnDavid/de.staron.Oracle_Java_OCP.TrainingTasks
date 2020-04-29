package _200429_Project_Words_funkt_Streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class Words {

	/**
	 * Quelle: http://www.mieliestronk.com/wordlist.html
	 * 
	 * @return Liste mit 58110 englischen Wörtern
	 */
	public static List<String> englishWords() {
		return load("/_200429_Project_Words_funkt_Streams/files/english_words_lowercase.zip");
	}
	
	/**
	 * Quelle: https://github.com/danielmiessler/SecLists/tree/master/Passwords
	 * 
	 * @return Liste mit 10000 Passwörtern
	 */
	public static List<String> passwords() {
		return load("/_200429_Project_Words_funkt_Streams/files/10k_most_common_passwords.zip");
	}
	
	private static List<String> load(String resourceName) {
		/*
		 * 1. Im Classpath die Ressource finden und zum Lesen öffnen
		 */
		InputStream is = Words.class.getResourceAsStream(resourceName);
		
		try {
		
			/*
			 * 2. Zip-Datei lesen 
			 */
			ZipInputStream zis = new ZipInputStream(is);
			ZipEntry ze = zis.getNextEntry();
			
			if(ze.isDirectory()) {
				throw new IllegalStateException("Bad data in archive: no text file found");
			}
			
			try( BufferedReader in = new BufferedReader( new InputStreamReader(zis) ) ) {
			
				List<String> list = new ArrayList<>();
				
				if( !in.readLine().startsWith("Quelle") ) {
					throw new IllegalStateException("Bad data in archive: first line must start with 'Quelle'");
				}
				
				String line;
				while( (line = in.readLine()) != null ) {
					list.add(line);
				}
				
				return list;
			}
		
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}		
	}
	
	
}
