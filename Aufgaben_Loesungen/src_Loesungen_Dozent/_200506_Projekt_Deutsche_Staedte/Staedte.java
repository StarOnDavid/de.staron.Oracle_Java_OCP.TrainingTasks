package _200506_Projekt_Deutsche_Staedte;


import java.util.List;

public class Staedte {

	public static List<Stadt> deutscheStaedte() {
		String urlName = "https://de.wikipedia.org/wiki/Liste_der_Gro%C3%9Fst%C3%A4dte_in_Deutschland";
		String wikiHtml = TextIO.readFromURL(urlName);
		
		//System.out.println( wikiHtml );
		WikiParser wikiParser = new JSoupWikiParser();
		
		return wikiParser.parse(wikiHtml);
	}
	
}
