package _200511_Files_create_move_delete;

public class Files_CMD_run {

	public static void main(String[] args) {
		/*
		FileHandler.createFiles(".\\src_Loesungen\\_200511_Files_create_move_delete\\files", 
								"test",
								"txt", 
								10
		);
		*/
		FileHandler.createFiles(".\\src_Loesungen\\_200511_Files_create_move_delete\\files", 
				"data",
				"csv", 
				5
		);
		
		
		FileHandler.moveFiles(".\\src_Loesungen\\_200511_Files_create_move_delete\\files", 
								".\\src_Loesungen\\_200511_Files_create_move_delete\\files_2", 
								"csv");
		
		FileHandler.deleteFiles(".\\src_Loesungen\\_200511_Files_create_move_delete\\files_2", "csv");

	}

}
