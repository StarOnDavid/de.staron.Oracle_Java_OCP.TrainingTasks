package _200415_Map_FileType;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FileTypes {
	
	private static String getExtension(File file) {
		String fileName = file.getName();
		
		int pos = fileName.lastIndexOf('.');
		
		// - Dateien ohne Erweiterung:
		// file (pos = -1)
		// file.
		// .file (pos = 0)
		if( pos < 1 || pos==fileName.length()-1 ) {
			return "<keine Erweiterung>";
		}
		
		return fileName.substring(pos+1).toLowerCase();
	}

	private File root;
	
	public FileTypes(String dirname) {
		this.root = new File(dirname);
	}
	
	public Collection<String> getFileTypes() {
		return getFileTypeCounters().keySet();
	}
	
	public Map<String, Integer> getFileTypeCounters() {
		
		if(!root.isDirectory()) {
			throw new IllegalStateException(root + " ist kein Verzeichnis");
		}
		
		File[] files = root.listFiles( path -> path.isFile() ); // kann null werden (für nichtlesbare Verzeichnisse)
		
		Map<String, Integer> map = new HashMap<>();
		
		if( files!=null ) {
			for(File f : files) {
				String ext = getExtension(f);
				
				Integer count = map.get(ext);
				
				if(count==null) {
					count=0;
				}
				
				map.put(ext, ++count);
			}
		}
		
		return map;
	}
	
}


