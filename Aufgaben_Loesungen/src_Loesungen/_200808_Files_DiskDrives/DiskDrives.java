package _200808_Files_DiskDrives;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DiskDrives {
	private class Disk {
		Path path;
		long availableMB, totalMB;
		
		Disk(Path path) {
			this.path = path;
		}
		
		
		
	}
	List<Disk> pathsExist = new ArrayList<>();
	
	public void getExisting() {
		Path path = null;
		String hdd = "";
		
		for ( int i = 65; i <= 90; i++ ) {
			hdd = ((char) i) + ":\\";
			path = Paths.get(hdd);
			if ( Files.exists ( path, LinkOption.NOFOLLOW_LINKS ) ) {
				pathsExist.add ( new Disk (path) );
			}
		}
	}
	
	public void readInfos() {
		for (Disk disk : pathsExist) {
			FileStore store;
			try {
				store = Files.getFileStore(disk.path);
				disk.totalMB = store.getTotalSpace() / 1000000;
				disk.availableMB = store.getUsableSpace() / 1000000;
			} catch (IOException e) {
				System.out.println( "Something went wrong!!! ");
				e.printStackTrace();
			}
			
		}
	}
	
	public void print() {
		long maxLengthAv = 0, maxLengthTo = 0;
		for (Disk disk : pathsExist) {
			maxLengthAv = disk.availableMB > maxLengthAv ? disk.availableMB : maxLengthAv;
			maxLengthTo = disk.totalMB > maxLengthTo ? disk.totalMB : maxLengthTo;
		}

		String fmt = "|%5s|'%15s|%15s|%n";
		System.out.println( "Existing drives and their properties: " );
		System.out.printf(fmt, "LW", "useable(MB)", "total(MB)" );
		for (Disk disk : pathsExist) {
			System.out.printf( "|%5s|%15d|%15d|%n", disk.path, disk.availableMB, disk.totalMB);
		}
	}
}
