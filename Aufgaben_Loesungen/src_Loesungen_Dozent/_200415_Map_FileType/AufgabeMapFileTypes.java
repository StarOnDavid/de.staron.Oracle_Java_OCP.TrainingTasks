package _200415_Map_FileType;

import java.util.Map;

public class AufgabeMapFileTypes {

	public static void main(String[] args) {
		
		FileTypes ft = new FileTypes("C:\\Windows");
		
		Map<String, Integer> mapCounters = ft.getFileTypeCounters();

		System.out.println(mapCounters);
		
	}

}
