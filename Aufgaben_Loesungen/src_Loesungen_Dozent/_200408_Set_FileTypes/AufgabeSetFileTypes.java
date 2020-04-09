package _200408_Set_FileTypes;


import java.util.Collection;

/*
 * s. Bsp. KlasseFile.java (wird später im Projekt 'IO' zu finden sein)
 */
public class AufgabeSetFileTypes {

	public static void main(String[] args) {

		FileTypes ft = new FileTypes("C:\\Windows");

		Collection<String> extColl = ft.getFileTypes();
		
		System.out.println(extColl);
	}

}
