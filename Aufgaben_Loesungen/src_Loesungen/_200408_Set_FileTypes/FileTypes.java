package _200408_Set_FileTypes;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;

public class FileTypes {
	String dirAdress;
	
	public FileTypes(String dirAdress) {
		this.dirAdress = dirAdress;
	}
	
	public HashSet<String> getFileTypes() {
		HashSet<String> fileTypes = new HashSet<>();
		File dir = new File(dirAdress);
		String[] dirFiles = dir.list();
		for(int i = 0; i < dirFiles.length; i++) {
			if(dirFiles[i].contains(".")) {
				int ptIdx = dirFiles[i].lastIndexOf(".");
				fileTypes.add(dirFiles[i].substring(ptIdx + 1));
			}
		}
		return fileTypes;
	}

	// only for Testing: 
	public static void main(String[] args) {
		FileTypes ft = new FileTypes("C:\\Windows");
		Collection<String> extColl = ft.getFileTypes();
		System.out.println(extColl);
	}
}
