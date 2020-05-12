package _200508_Files_Verzeichnisse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AufgabeFilesVerzeichnisse {

	public static void main(String[] args) throws IOException {

		System.out.println("*** A1");
		printSubdirs( Paths.get(".") );
		
		System.out.println("*** A2");
		printFiles( Paths.get(".").resolve("src") );
		
		System.out.println("*** A3");
		String mydir = "a\\b\\c\\d";
		createDirs(mydir);
		
		System.out.println("*** A4");
		deleteDirs(mydir);
	}
	
	static void printFiles(Path dir) throws IOException {
		Files.walk(dir)
			.filter( Files::isRegularFile )
			.map( Path::normalize )
			.forEach(System.out::println);
	}
	static void printSubdirs(Path dir) throws IOException {
		Files.walk(dir)
				.filter( path ->  !dir.equals(path) )
				//.filter( path -> Files.isDirectory(path) )
				.filter( Files::isDirectory )
				//.map( path -> path.normalize() )
				.map( Path::normalize )
				.forEach(System.out::println);
	}
	static void createDirs(String dirName) throws IOException {
		Files.createDirectories(Paths.get(dirName));
	}
	
	static void deleteDirs(String dirName) throws IOException {
		Path dir = Paths.get(dirName);
		
		while(dir!=null) {
			System.out.println("Löschen: " + dir);
			Files.delete(dir);
			dir = dir.getParent();
		}
	}
}
