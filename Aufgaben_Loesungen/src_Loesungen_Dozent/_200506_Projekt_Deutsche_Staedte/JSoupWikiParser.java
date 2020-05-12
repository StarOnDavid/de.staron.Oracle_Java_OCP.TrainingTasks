package _200506_Projekt_Deutsche_Staedte;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupWikiParser implements WikiParser {

	@Override
	public List<Stadt> parse(String html) {

		Document doc = Jsoup.parse(html);
		
		Elements alleTabellen = doc.getElementsByTag("table");
		
		Element tabelle = alleTabellen.get(0); // Die richtige Tabelle ist Nr. 0 

		Elements alleZeilen = tabelle.getElementsByTag("tr");
		
		List<Stadt> list = new ArrayList<>();
		
		int from = 2; //header ignorieren
		int to = alleZeilen.size()-2; //footer ignorieren
		
		for(int i = from; i<to; i++) {
			Element zeile = alleZeilen.get(i);
			Stadt s = parseRow(zeile);
			list.add(s);
		}
		
		return list;
	}
	
	
	private Stadt parseRow(Element row) {
		
		Elements alleSpalten = row.getElementsByTag("td");
		
		Element spalteName = alleSpalten.get(1);
		Element anchorMitName = spalteName.getElementsByTag("a").first();
		String name = anchorMitName.ownText();
		
		Element spalteEinwohner = alleSpalten.get(11);
		String textEinwohner = spalteEinwohner.ownText().replace(".", "");
		int einwohner = Integer.parseInt(textEinwohner);
		
		Element spalteLand = alleSpalten.get(16);
		Element anchorMitLand = spalteLand.getElementsByTag("a").last();
		String land = anchorMitLand.ownText();
		
		return new Stadt(name, land, einwohner);
	}
}







