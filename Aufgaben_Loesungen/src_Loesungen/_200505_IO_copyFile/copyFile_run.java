package _200505_IO_copyFile;

public class copyFile_run {
	
	public static void main(String[] args) {
		String path = "./src_Loesungen/_200505_IO_copyFile/files/";
//		FileUtils.copyTextFile(path + "spacex.txt", path + "spaceXcopy.txt", false);
		
		FileUtils.copyTextFile(path + "spacex.txt", path + "spaceXcopy.txt", false, true);
	}
}
