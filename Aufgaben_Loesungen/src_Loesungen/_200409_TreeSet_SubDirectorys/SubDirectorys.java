package _200409_TreeSet_SubDirectorys;

import java.io.File;
import java.util.SortedSet;
import java.util.TreeSet;

public class SubDirectorys {

	private String dirAdress;
	
	public SubDirectorys(String dirAdress) {
		this.dirAdress = dirAdress;
	}
	
	public TreeSet<String> getSubDirs() {
		File dir = new File(dirAdress);
		if(dir.isDirectory()) {
			TreeSet<String> subDirs = new TreeSet<>();
			searchSubDirs(subDirs, dir);
			return subDirs;
		} else {
			throw new IllegalStateException(dirAdress + " must be a directory !!!");
		}
	}
	
	private void searchSubDirs(TreeSet<String> subDirs, File dir) {
		File[] dirSubs = dir.listFiles(p -> p.isDirectory());
		if(dirSubs != null) {
		for(File d : dirSubs) {
			subDirs.add(d.getName());
				if(d.canRead())
				searchSubDirs(subDirs, d.getAbsoluteFile());
			}
		}
	}
	
	
	public static void main(String[] args) {
		SubDirectorys dir = new SubDirectorys("C:\\Users\\CC-Student\\source");
		TreeSet<String> dirSet = dir.getSubDirs();
		System.out.println("Es wurden " + dirSet.size() + " Ordner gefunden.\n");
		
//		- geben Sie den allerersten Namen aus (ausgeben bitte)
		System.out.println("Erster gefundener Ordner: " + dirSet.first());
		
//		- geben Sie den allerletzten Namen aus (ausgeben bitte)
		System.out.println("Letzter gefundener Ordner " + dirSet.last());

//		- Suchen Sie den ersten Namen, der mit 'M' startet (ausgeben bitte)
		System.out.println("Erster Ordner der mit 'M' beginnt: " + dirSet.higher("M"));
		
//		- Suchen Sie den letzten Namen, der mit 'M' startet (ausgeben bitte)
		System.out.println("Erster Ordner der mit 'M' beginnt: " + dirSet.lower("N"));

//		- suchen Sie im TreeSet alle Namen, die mit einem 'S' starten (ausgeben bitte)
		SortedSet<String> subSetWithS = dirSet.subSet("S", "T");
		System.out.println("Alle Ordner die mit 'S' beginnen: " + subSetWithS);
		
//		- suchen Sie im TreeSet alle Namen, die mit einem 'p' oder 'P' starten (ausgeben bitte)
		SortedSet<String> subSetWithP = dirSet.subSet("P", "Q");
		SortedSet<String> subSetWithp = dirSet.subSet("p", "q");
		SortedSet<String> subSetWithPp = new TreeSet<String>();
		subSetWithPp.addAll(subSetWithP);
		subSetWithPp.addAll(subSetWithp);
		System.out.println("Alle Ordner die mit 'P' oder 'p' beginnen: " + subSetWithPp);
		
//		- suchen Sie im TreeSet alle Namen die mit 'B', 'C' oder 'D' starten (ausgeben bitte)
		SortedSet<String> subSetWithBtoD = dirSet.subSet("B", "E");
		System.out.println("Alle Ordner die mit 'B', 'C' oder 'D' beginnen: " + subSetWithBtoD);
		

	}

}
