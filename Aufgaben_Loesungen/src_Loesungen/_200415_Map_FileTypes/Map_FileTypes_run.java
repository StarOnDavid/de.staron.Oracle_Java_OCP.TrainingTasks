package _200415_Map_FileTypes;

import java.util.Collection;

public class Map_FileTypes_run {

	public static void main(String[] args) {
		FileTypes ft = new FileTypes("C:\\Windows");
		
		Collection<String> extColl = ft.getFileTypes(false);

		for (String ext : extColl) {
			System.out.println(ext);
		}
		
		System.out.println();
		
		extColl = ft.getFileTypes(true);

		for (String ext : extColl) {
			System.out.println(ext);
		}
	}

}
