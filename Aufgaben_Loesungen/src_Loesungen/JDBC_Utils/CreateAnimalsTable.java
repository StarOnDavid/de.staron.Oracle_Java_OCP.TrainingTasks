package JDBC_Utils;

public class CreateAnimalsTable {
	private static String path = "./src_Loesungen/JDBC_Utils/scripts";

	public static void main(String[] args) {
		
		SqlStatements.execute(path, "create_table_animals.sql");

	}
}
