package _200508_Files_Laufwerke;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Laufwerke {
	static void print(List<Path> listRoot, PrintWriter out) {
		
		String fmt = "| %3s | %15s | %15s |\n";
		
		out.format(fmt, "LW", "usable(MiB)", "total(MiB)");
		
		int div = 1024 * 1024;
		
		for( Path root : listRoot ) {
			try {
				FileStore store = Files.getFileStore(root);
				long total = store.getTotalSpace() / div;
				long available = store.getUsableSpace() / div;
				
				out.format(fmt, root, available, total);
				
			} catch (IOException e) {
				out.format(fmt, root, "*", "*");
				out.print("* " + e.getMessage());
			}
		}
		out.flush();
	}

	static List<Path> getRoots() {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		
		List<Path> listRoots = new ArrayList<>();
		for(Path root : dirs) {
			listRoots.add(root);
		}
		
		return listRoots;
	}
	
	public static long getAvailableSpace(Path p) {
		try {
			return Files.getFileStore(p).getUsableSpace();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}

public class AufgabeFilesLaufwerke {

	public static void main(String[] args) {
		
		List<Path> listRoots = Laufwerke.getRoots();
		Laufwerke.print(listRoots, new PrintWriter(System.out));
		
		System.out.println("*** A2");
		
		Comparator<Path> cmp = ( p1, p2 ) -> {
			
			long available1 = 0;
			
			try {
				available1 = Laufwerke.getAvailableSpace(p1);
			} catch(UncheckedIOException e) {
				System.out.println("Kann 'available1' nicht ermitteln für " + p1);
			}
			
			long available2 = 0; 
			
			try {
				available2  = Laufwerke.getAvailableSpace(p2);
			} catch (UncheckedIOException e) {
				System.out.println("Kann 'available2' nicht ermitteln für " + p2);
			}
			
			long res = available1 - available2;
			if(res > 0) {
				return 1;
			} else if(res < 0) {
				return -1;
			} else {
				return 0;
			}
		};
		
		listRoots.sort( cmp );
		
		Laufwerke.print(listRoots, new PrintWriter(System.out));
		
		System.out.println("*** A3");
		try(PrintWriter out = new PrintWriter("roots.txt")) {
			Laufwerke.print(listRoots, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
