package _200511_Files_Dateien_erstellen_verschieben_entfernen;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class FileUtils {
	static void deleteFile(Path file) {
		try {
			Files.delete(file);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	static void moveAndReplaceFile(Path sourceFile, Path targetDir) {
		try {
			Path targetFile = targetDir.resolve( sourceFile.getFileName() );
			Files.move(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	static boolean hasExtension(Path file, String extension) {
		String fileName = file.getFileName().toString();
		return fileName.endsWith("." + extension);
	}
}

public class AufgabeDateienErstellenVerschiebenEntfernen {

	public static void main(String[] args) {

		String root = "testroot";
		
		try {
			System.out.println("*** A1. Dateien erzeugen");
			createFiles(root, "file", "txt", 30);
			
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		String root2 = "testroot2";
		
		try {
			System.out.println("*** A2. Dateien verschieben");
			moveFiles(root, root2, "txt");
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			System.out.println("*** A3. Dateien löschen");
			deleteFiles(root2, "txt");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	} // end of main
	
	static void deleteFiles(String rootName, String extension) throws IOException {
		
		Path root = Paths.get(rootName);
		
		Files.walk(root)
			.filter(Files::isRegularFile)
			.filter(file -> FileUtils.hasExtension(file, extension))
			.forEach(FileUtils::deleteFile);
	}

	static void moveFiles(String sourceRootName, String targetRootName, String extension) throws IOException {
		Path targetRoot = Paths.get(targetRootName);
		
		Files.createDirectories(targetRoot);
		
		Path sourceRoot = Paths.get(sourceRootName);
		
		Files.walk(sourceRoot)
				.filter(Files::isRegularFile)
				.filter(file -> FileUtils.hasExtension(file, extension))
				.forEach(file -> FileUtils.moveAndReplaceFile(file, targetRoot));
	}
	
	static void createFiles(String root, String prefix, String extension, int count) throws IOException {
		
		Path targetDir = Paths.get(root);
		
		for (int i = 1; i <= count; i++) {
			String fileName = String.format("%s%03d.%s", prefix, i, extension);
			Path file = targetDir.resolve(fileName);
			
			if(Files.exists(file, LinkOption.NOFOLLOW_LINKS)) {
				Files.delete(file);
			}
			
			Files.createFile(file);
		}
		
	}
}
