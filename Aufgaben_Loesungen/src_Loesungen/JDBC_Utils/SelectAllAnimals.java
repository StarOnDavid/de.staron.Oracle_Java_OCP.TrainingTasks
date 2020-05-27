package JDBC_Utils;

public class SelectAllAnimals {
	private static String path = "./src_Loesungen/JDBC_Utils/scripts";

	public static void main(String[] args) {

		SqlStatements.select(path, "select_animals.sql");;
		
	}
}
