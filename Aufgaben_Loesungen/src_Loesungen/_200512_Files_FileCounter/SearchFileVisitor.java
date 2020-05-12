package _200512_Files_FileCounter;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchFileVisitor<T extends Path> implements FileVisitor<Path>  {
	
	private int numFound = 0;
	private String searchExtention = "";
	
	public SearchFileVisitor(String extention) {
		searchExtention = extention;
	}
	
	public void resetFoundCount() {
		numFound = 0;
	}
	
	public int getFoundCount() {
		return numFound;
	}
	
	public void setSearchExtention(String extention) {
		searchExtention = extention;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		if(searchExtention == "")
			numFound++;
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		 if(attrs.isRegularFile() && file.getFileName().toString().endsWith(searchExtention))
			 numFound++;
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.err.println("Fehler (visitFileFailed): " + file);
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		if(exc!=null) {
			System.err.println("Fehler (postVisitDirectory): " + exc.getMessage());
		} else {
			//System.out.println("Verzichnis durchsucht: " + dir);
		}
		
		return FileVisitResult.CONTINUE;
	}
} // end class SearchFileVisitor()