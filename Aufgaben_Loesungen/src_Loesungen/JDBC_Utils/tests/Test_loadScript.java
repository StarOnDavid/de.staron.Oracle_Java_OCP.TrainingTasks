package JDBC_Utils.tests;

import java.util.List;

import JDBC_Utils.OracleSqlUtils;

@SuppressWarnings("unused")
public class Test_loadScript {
	private static String path = "./src_Loesungen/JDBC_Utils/scripts";
	
	public static void main(String[] args) {
//		testSQL("sysdate.sql");
		testSQL("insert_auto.sql");
		testSQL("insert_autos.sql");
	}

	private static void testSQL(String file) {
		System.out.println("Test - sysdate.sql");
		List<String> sysdate = OracleSqlUtils.loadSqlScript(path, file);
		
		for (String s : sysdate) {
			System.out.println(s);
		}
		System.out.println();
	}
}
