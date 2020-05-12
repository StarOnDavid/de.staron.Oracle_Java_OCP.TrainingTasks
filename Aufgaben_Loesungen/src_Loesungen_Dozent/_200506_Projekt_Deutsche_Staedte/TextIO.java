package _200506_Projekt_Deutsche_Staedte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.file.Path;

public class TextIO {
	
	public static String readFromURL(String urlName) throws UncheckedIOException {

		try {
			URL url = new URL( urlName );   
			InputStream is = url.openStream();   
			Reader r = new InputStreamReader(is);
			
			return read(r);			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public static void writeToFile(String text, Path file) throws UncheckedIOException {
		try(PrintWriter out = new PrintWriter(file.toFile())) {
			out.print(text);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public static String readFromFile(Path file) throws UncheckedIOException {
		try {
			FileReader r = new FileReader(file.toFile());
			return read(r);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	private static String read(Reader r) throws IOException {
		try(BufferedReader in = new BufferedReader(r)) {
			StringBuilder result = new StringBuilder(); 
			String line;
			while( (line=in.readLine()) != null ) {
				result.append(line).append("\n");
			}
			return result.toString();
		}
	}
	
}
