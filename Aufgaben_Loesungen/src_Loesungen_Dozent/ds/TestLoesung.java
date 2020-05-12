package ds;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestLoesung {
	
	public static void main(String[] args) {
//		testStaedte();
		testJSoupWikiParser();
	}
	

	static void testJSoupWikiParser() {
		Path file = Paths.get("wiki.html");
		
		String wikiHtml;
		
		// TextIO.writeToFile(wikiHtml, file);
		wikiHtml = TextIO.readFromFile(file);
		
		WikiParser wikiParser = new JSoupWikiParser();

		List<Stadt> list = wikiParser.parse(wikiHtml);

		StadtConsole.printTable(list);

	}
	
	static void testStaedte() {

		List<Stadt> list = Staedte.deutscheStaedte();

		StadtConsole.printTable(list);
		
		System.out.println("Städte geladen: " + list.size()); // 81
		
	}

}
