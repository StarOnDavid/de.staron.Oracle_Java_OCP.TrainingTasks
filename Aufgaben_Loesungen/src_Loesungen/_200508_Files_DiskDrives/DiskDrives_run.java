package _200508_Files_DiskDrives;



public class DiskDrives_run {

	public static void main ( String[] args ) {
		DiskDrives hdds = new DiskDrives();
		hdds.getExisting();
		hdds.print();
		
		System.out.println();
		
		hdds.readInfos();
		hdds.print();
	}

	

}
