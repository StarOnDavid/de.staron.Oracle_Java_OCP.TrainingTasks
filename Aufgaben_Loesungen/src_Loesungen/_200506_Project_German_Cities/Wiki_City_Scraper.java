package _200506_Project_German_Cities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class Wiki_City_Scraper {
	private static final String urlPath = "https://de.wikipedia.org/wiki/Liste_der_Gro%C3%9Fst%C3%A4dte_in_Deutschland";
	private static final List<City> cities = new ArrayList<>();
	
	public static void main(String[] args) {
		Document doc = openURL();
		
		Elements rows = getRowsFromTable(doc);
		
		readCityInformationFormRowsToCities(rows);
		
		printFormatedCityList();
	}

	private static void printFormatedCityList() {
		int nl = 0, pl = 0, cl = 0;
		for (City c : cities) {
			int tmpPop = (c.getPopulation()+ "").length();
			nl = c.getName().length() > nl ? c.getName().length() : nl;
			pl = tmpPop > pl ? tmpPop : pl;
			cl = c.getCountry().length() > cl ? c.getCountry().length() : cl;
			
		}
		nl++; pl++; cl++;
		
		for (City c : cities) {
			System.out.printf("|%3d|%" + nl + "s|%"+ pl +"d|%" + cl + "s|%n", 
					c.getNr(), c.getName(), c.getPopulation(), c.getCountry());
		}
	}

	private static void readCityInformationFormRowsToCities(Elements rows) {
		int nr = 0, population = 0;
		String name = "", country = "";
		
		for (int i = 2; i < rows.size(); i++) {
			Element row = rows.get(i);
			Elements cols = row.select("td");
			
//			System.out.println(cols.size());
//			System.out.println(cols + "\n\n");
			
			if(cols.size() == 17) {
				nr = Integer.parseInt(cols.get(0).text());
				name = parseName(cols);
				population = parsePopulation(cols);
				country = parseCountry(cols);
				
				if(nr != 0) {
					cities.add(new City(nr, name, population, country));
				}
			}
			nr = 0;
		}
	}

	private static String parseCountry(Elements cols) {
		String country = cols.get(16).text();
		country = country.substring(0, country.length()/2);
//		System.out.println(country);
		return country;
	}

	private static String parseName(Elements cols) {
		
		String name = cols.get(1).text();
		while(lastIsNumberOrComma(name))
			name = name.substring(0, name.length()-1);
		return name;
	}

	private static boolean lastIsNumberOrComma(String name) {
		if (name.length() > 1) {
			boolean isNumber = name.charAt(name.length()-1) > 47 && name.charAt(name.length()-1) < 58;
			boolean isComma = name.charAt(name.length()-1) == 44;
			boolean isEmptySpace = name.charAt(name.length()-1) == 32;
			return isNumber || isComma || isEmptySpace;
		}else {
			return false;
		}
	}

	private static int parsePopulation(Elements cols) {
//		System.out.println(cols.get(11).text());
		String tmpPop = cols.get(11).text();
		StringBuffer bufPop = new StringBuffer();
		for (int j = 0; j < tmpPop.length(); j++) {
			if (tmpPop.charAt(j) != '.') {
				bufPop.append(tmpPop.charAt(j));
			}
		}
		return Integer.parseInt(bufPop.toString());

	}

	private static Elements getRowsFromTable(Document doc) {
		Element table = doc.select("table").get(0); //select the first table.
	    Elements rows = table.select("tr");

		System.out.println("The table contains " + rows.size() + "rows.\n");
		return rows;
	}

	private static Document openURL() {
		Document doc = null;
		try {
			doc = Jsoup.connect(urlPath).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

}
