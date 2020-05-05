package _200505_IO_copyFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtils {

	public static void copyTextFile (String fromFile, String toFile, boolean consolePrint) {
				_copyTextFile(fromFile, toFile, consolePrint, false);
	}
	
	public static void copyTextFile (String fromFile, String toFile, boolean consolePrint, boolean append) {
		_copyTextFile(fromFile, toFile, consolePrint, append);
}
	
	public static void showWorkingPath() {
		try {
			System.out.println("aktuelles Arbeitsverzeichnis: " + new File(".").getAbsoluteFile().getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void _copyTextFile (String fromFile, String toFile, boolean consolePrint, boolean append) {
		
		try(	BufferedReader in = new BufferedReader(new FileReader(fromFile));
				BufferedReader outTest = new BufferedReader(new FileReader(toFile));
				PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter(toFile, append)), append) 
						//new BufferedWriter( new FileWriter(toFile))
			) {
			
			if(append) { // Leerzeile 
				int empty = outTest.read();
				if(empty != -1)
					out.write("\n\n");
			}
			
			char[] cbuf = new char[80];
			
			int len;
			while( (len = in.read(cbuf)) != -1 ) {
				if (consolePrint)
					System.out.println("readed: " + len + " writed: " + String.valueOf(cbuf, 0, len));
				out.write(cbuf, 0, len);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: when opening the file to be read!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error when reading, writing or closing a file!");
			e.printStackTrace();
		}
	}
}
