package JDBC_Utils.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC_Utils.OracleSqlUtils;

public class Test_Select {

	public static void main(String[] args) {
try( Connection connection = OracleSqlUtils.getTestConnection()) {
			System.out.println("Schema: " + connection.getSchema());
			System.out.println("ClientInfo: " + connection.getClientInfo());
			
			try( Statement stm = connection.createStatement() ) {
//				String sql = "CREATE TABLE autos ("
//						+ "id NUMBER(5),"
//						+ "hersteller VARCHAR2(45),"
//						+ "modell VARCHAR2(45),"
//						+ "baujahr NUMBER(5)"
//						+ ")";
				
				String insert = "INSERT INTO autos VALUES( sq_autos_id.NEXTVAL, 'Mazda', 'M1', 2003 )";
				stm.execute(insert);
				String sql = "SELECT * FROM AUTOS";
//				String sql = "SELECT SYSDATE FROM DUAL";
				System.out.println("SELECT possible: " + stm.execute(sql));
				
				
				try ( ResultSet res = stm.executeQuery(sql) ) {
					System.out.println("\n*** Daten aus der Tabelle 'autos'\n");
					
					
//					System.out.println("isBeforFirst() " + res.isBeforeFirst());
//					System.out.println("isAfterLast() " + res.isAfterLast());
//					System.out.println("next() " + res.next());
//					
//					System.out.println(res.getString(1));
//					
//					System.out.println("next() " + res.next());
//					System.out.println("isAfterLast() " + res.isAfterLast());
					
					while( res.next() ) {
						System.out.println("next line");
						int id = res.getInt(1);  
						System.out.print("id: " + id);
						
						System.out.printf(", %s %s, Baujahr: %d %n", 
									res.getString("hersteller"), 
									res.getString("modell"), 
									res.getInt("baujahr") );
					}
				} // end ResultSet
			} // end Statement
		} // end Connection	
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
