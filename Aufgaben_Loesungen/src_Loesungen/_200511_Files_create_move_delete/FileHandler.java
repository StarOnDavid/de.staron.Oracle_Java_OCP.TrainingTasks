package _200511_Files_create_move_delete;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class FileHandler {
	
	static void createFiles(String root, String prefix, String extension, int count) {
		Path rootDir = Paths.get(root);
		
		if(!Files.exists(rootDir)) {
			try {
				Files.createDirectory(rootDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 1; i <= count; i++) {
			String path = String.format("%s\\%s%03d.%s", root, prefix, i, extension);
			Path filePath = Paths.get(path);
			System.out.println("File created: \n" + path + "\n");
			
			try {
				Files.createFile(filePath);
			} catch (FileAlreadyExistsException e) {
				System.out.println("Not possible to create the file: \n" +
									path + "\n" +
									"File Already Exist !!!\n");
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// not in Use ... better way: "String.format(format, args)"
	@SuppressWarnings("unused")
	private static String getCounter(int count) {
		String counter = "";
		if(count < 10)
			counter = "00" + count;
		else if (count < 100)
			counter = "0" + count;
		else
			counter = "" + count;
		return counter;
	}
	
	static void moveFiles(String sourceRoot, String targetRoot, String extension) {
		Path source = Paths.get(sourceRoot);
		Path target = Paths.get(targetRoot);
		
		List<Path> filePaths = findFiles(extension, source);
		
		if(!Files.exists(target)) {
			try {
				Files.createDirectory(target);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for (Path path : filePaths) {
			Path targetFile = target.resolve(path.getFileName());
			System.out.println("File moved from: \n" + path + "\nto: \n" + targetFile + "\n");
			try {
				Files.move(path, targetFile);
			} catch (IOException e) {
				System.out.println("Not possible to move the file: \n" +
						path + "\n" +
						"to \n" +
						targetFile + "\n" +
						"File Already Exist in the 'target' directory !!!\n");
			}
		}
	} // end moveFiles

	
	
	static void deleteFiles(String root, String extension) {
		Path rootDir = Paths.get(root);
		
		List<Path> filePaths = findFiles(extension, rootDir);
		
		for (Path path : filePaths) {
			try {
				Files.deleteIfExists(path);
				System.out.println("File deleted: \n" + path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} // end deleteFiles
	
	private static List<Path> findFiles(String extension, Path source) {
		List<Path> filePaths = new ArrayList<>();
		
		BiPredicate<Path, BasicFileAttributes> matcher = (path, bfa) -> 
		{ 
			return bfa.isRegularFile() 
					&& path.getFileName().toString().endsWith(extension);
		};
		
		try {
			Files.find(source, 1, matcher)
				.forEach(p -> filePaths.add(p));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePaths;
	} // end findFiles
}
