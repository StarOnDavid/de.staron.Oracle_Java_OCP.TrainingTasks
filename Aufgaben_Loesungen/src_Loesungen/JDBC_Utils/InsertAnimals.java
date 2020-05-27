package JDBC_Utils;

public class InsertAnimals {
	private static String path = "./src_Loesungen/JDBC_Utils/scripts";
	
	public static void main(String[] args) {

		SqlStatements.execute(path, "insert_animals.sql");
		
	}

}
