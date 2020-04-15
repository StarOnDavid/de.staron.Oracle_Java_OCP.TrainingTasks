package _200415_Map_FileTypes;

import java.io.File;
import java.util.*;

public class FileTypes {
	private String dir;

	public FileTypes(String dir) {
		this.dir = dir;
	}
	
	public Collection<String> getFileTypes(boolean sortedByValue) {
		Map<String, Integer> fileExts = getFileExts();
		if(sortedByValue)
			fileExts = sortByValues(fileExts);
		return toCollection(fileExts);
	}

	private Map<String, Integer> getFileExts() {
		Map<String, Integer> fileExts = new TreeMap<>();
		File dir = new File(this.dir);
		if(dir.isDirectory()) {
			File[] dirFiles = dir.listFiles(p -> p.isFile());
			
			for(int i = 0; i < dirFiles.length; i++) {
					int ptIdx = dirFiles[i].getName().lastIndexOf(".");
					String ext = dirFiles[i].getName().substring(ptIdx + 1);
					
					Integer num = fileExts.get(ext);
					
					if (num == null)
						num = 0;
					
					num++;
					fileExts.put(ext, num);
			}
		} else {
			throw new IllegalStateException(dir + " must be a directory !!!");
		}
		return fileExts;
	}

	private List<String> toCollection(Map<String, Integer> fileExts) {
		List<String> list = new ArrayList<>();
		int length = 0;
		for (Map.Entry<String, Integer> entry : fileExts.entrySet()) {
			if(entry.getKey().length() > length)
				length = entry.getKey().length();
		}
		for (Map.Entry<String, Integer> entry : fileExts.entrySet()) {
			list.add(String.format("%"+ length +"s: %d", entry.getKey(), entry.getValue()));
		}
		return list;
	}

	// Nicht selbst geschrieben ... dafür fehlt noch einwenig Wissen über Generischemethoden
	private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
    Comparator<K> valueComparator = 
             new Comparator<K>() {
      public int compare(K k1, K k2) {
        int compare = 
              map.get(k1).compareTo(map.get(k2));
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
    };
 
    Map<K, V> sortedByValues = 
      new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
  }
}
