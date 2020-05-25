package _200518_Philosophen_List;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Philosophen_List_run {

	public static void main(String[] args) {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://de.wikipedia.org/wiki/Liste_antiker_Philosophen").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Philosoph> philosophen = doc.getElementsByTag("li")
			.stream()
			.skip(27)
			.limit(85)
			.map(e -> e.getElementsByTag("a"))
			.flatMap(List::stream)
			.map( Element::ownText)
			.map( Philosoph::new)
			.collect(Collectors.toList());
		
		philosophen.forEach(System.out::println);
//		Path philosophPath = Paths.get(".\\src_Loesungen\\_200518_Philosophen_List\\philosopen\\philosophen.txt");
//		Files.write(philosophPath, philosophen, StandardOpenOption.CREATE);
	}

}
