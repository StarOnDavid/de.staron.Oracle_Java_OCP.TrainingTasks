package _200408_Set_FileTypes;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;

public class FileTypes_v2 {
	private String dirAdress;
	
	public FileTypes_v2(String dirAdress) {
		this.dirAdress = dirAdress;
	}
	
	public HashSet<String> getFileTypes() {
		HashSet<String> fileTypes = new HashSet<>();
		File dir = new File(dirAdress);
		if(dir.isDirectory()) {
			File[] dirFiles = dir.listFiles(p -> p.isFile());
			
			for(int i = 0; i < dirFiles.length; i++) {
					int ptIdx = dirFiles[i].getName().lastIndexOf(".");
					fileTypes.add(dirFiles[i].getName().substring(ptIdx + 1));

			}
			return fileTypes;
		} else {
			throw new IllegalStateException(dirAdress + " must be a directory !!!");
		}
	}

	// only for Testing: 
	public static void main(String[] args) {
		FileTypes_v2 ft = new FileTypes_v2("C:\\Windows");
		Collection<String> extColl = ft.getFileTypes();
		System.out.println(extColl);
		
		FileTypes_v2 ft2 = new FileTypes_v2("C:\\Windows\\py.exe");
		try {
		ft2.getFileTypes();
		} catch (IllegalStateException e) {
			System.out.println("ft2.getFileTypes() throw: " + e.getClass() + " " + e.getMessage());
		}
		
	}
}
