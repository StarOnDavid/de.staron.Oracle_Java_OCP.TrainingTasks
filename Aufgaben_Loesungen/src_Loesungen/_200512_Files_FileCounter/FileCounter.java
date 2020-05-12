package _200512_Files_FileCounter;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

public class FileCounter {
	private Path root;
	
	public FileCounter(String path) {
		this.root = Paths.get(path);
	}
	
	public int countFlat(String extension) {
		return numOfFiles(root, 1, extension);
	}
	
	public int countDeep(String extension) {
		return numOfFilesWalkFileTree(root, extension, false);
	}
	
	public int countDeepIgnoreCase(String extension) {
		return numOfFilesWalkFileTree(root, extension, true);
	}
	
	private static int numOfFiles( Path source, int maxDepth, String extension) {
		long numOf = 0;
		
		BiPredicate<Path, BasicFileAttributes> matcher = null;
		
		if(extension.isBlank()) {
			matcher = (path, bfa) ->
			{
				return bfa.isDirectory();
			};
		} else {
			matcher = (path, bfa) ->
			{
				return bfa.isRegularFile()
						&& path.getFileName().toString().endsWith(extension);
			};
		}
		
		try {
			numOf = Files.find(source, maxDepth, matcher)
					
					.count();
			
		} catch (AccessDeniedException e) {
			System.out.println("ACCESS DENIED: " + e.getMessage() + "\n" +
								e.getFile() + "\n"+
								e.getReason());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (int) numOf;
	} // end findFiles
	
	
	private static int numOfFilesWalkFileTree( Path source, String extention, boolean ignoreCase) {
		SearchFileVisitor<Path> visitor = new SearchFileVisitor<Path>(extention, ignoreCase);
		try {
			Files.walkFileTree(source, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return visitor.getFoundCount();
	} // end findFiles
	
	
	@SuppressWarnings("unused")
	private static class SearchFileVisitor<T> implements FileVisitor<Path>  {
		private boolean errOut = false;
		private boolean ignCase = false;
		private int numFound = 0;
		private String searchExtention = "";
		
		public SearchFileVisitor(String extention) {
			searchExtention = extention;
		}
		
		public SearchFileVisitor(String extention, boolean ignoreCase) {
			this(extention);
			ignCase = ignoreCase;
		}
		
		public SearchFileVisitor(String extention, boolean ignoreCase, boolean errorOutput) {
			this(extention);
			ignCase = ignoreCase;
			errOut = errorOutput;
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
			 if(attrs.isRegularFile()) {
				 String fileName = file.getFileName().toString();
				 if(ignCase) {
					 if (fileName.toUpperCase().endsWith(searchExtention.toUpperCase())) {
						 numFound++;
					 }
				 } else {
					 if (fileName.endsWith(searchExtention)) {
						 numFound++;
					 }
				 }
			 }
				 numFound++;
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			if(errOut)
				System.err.println("Fehler (visitFileFailed): " + file);
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			if(exc!=null) {
				if(errOut)
					System.err.println("Fehler (postVisitDirectory): " + exc.getMessage());
			} else {
				//System.out.println("Verzichnis durchsucht: " + dir);
			}
			
			return FileVisitResult.CONTINUE;
		}
	} // end class SearchFileVisitor()
}