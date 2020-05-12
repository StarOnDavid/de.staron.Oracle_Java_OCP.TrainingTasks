package _200512_Files_FileCounter;

public class FileCounter_run {

	public static void main(String[] args) {
		String path = "C:\\Windows";
		FileCounter fc = new FileCounter(path);
		int numOfDirs = 0, numOfTXTFiles = 0;
		
//		numOfDirs = fc.countFlat("");
//		System.out.println("'"+ path + "' contains " + numOfDirs + " directorys.\n");
//
//		numOfTXTFiles = fc.countFlat("txt");
//		System.out.println("'"+ path + "' contains " + numOfTXTFiles + " *.txt Files.\n");
//
//		numOfDirs = fc.countDeep("");
//		System.out.println("'"+ path + "' contains " + numOfDirs + " directorys including all subdirectorys.\n");
		
		numOfTXTFiles = fc.countDeep("txt");
		System.out.println("'"+ path + "' contains " + numOfTXTFiles + " *.txt Files including all subdirectorys.\n");
		
		numOfTXTFiles = fc.countDeepIgnoreCase("txt");
		System.out.println("'"+ path + "' contains " + numOfTXTFiles + " *.txt (ignore Case) Files including all subdirectorys.\n");
	}

}
