package JDBC_Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SqlStatements {
	
	public static void execute (String path, String file) {
		List<String> createTableSQL = OracleSqlUtils.loadSqlScript(path, file);
		
		try (Connection con = OracleSqlUtils.getTestConnection()){
			try(Statement stm = con.createStatement()) {
				for (String sql : createTableSQL) {
					try {
						stm.execute(sql);
						System.out.println("Statement: '" + sql + " executed.\n" );
					} catch (SQLSyntaxErrorException e) {
						System.out.println(e.getMessage()) ;
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void select (String path, String file) {
		List<String> createTableSQL = OracleSqlUtils.loadSqlScript(path, file);
		
		try (Connection con = OracleSqlUtils.getTestConnection()){
			
			try(Statement stm = con.createStatement()) {
				
				for (String sql : createTableSQL) {
					
					try ( ResultSet res = stm.executeQuery(sql) ) {
						String tmpTab = sql.substring(sql.indexOf("FROM")+ 5, sql.length());
						String table;
						if ( tmpTab.contains(" ")) {
							table = tmpTab.substring(0, tmpTab.indexOf(" "));
						} else {
							table = tmpTab.substring(0, tmpTab.length()-1);
						}
					
						System.out.println("\n*** Daten aus der Tabelle '" + table + "'\n");
						
						String tmpCol = sql.substring(6, sql.indexOf("FROM"));

						List<String> columns = Arrays.asList(tmpCol.split(" "));
						
						columns = columns.stream().filter(s -> !s.isBlank())
								.map(s -> s.charAt(s.length()-1) == ',' ?
											 s.substring(0, s.length()-1) : s
								)
								.collect(Collectors.toList());
						
						for (String col : columns) {
							System.out.printf("%1$" + (col.length()+8) + "s |", col);
						}
						System.out.println();
						
						while( res.next() ) {
							for (String col : columns) {
								System.out.printf("%1$" + (col.length()+8) + "s |", res.getString(col));
							}
							System.out.println();
						}
					
//					try {
//						stm.execute(sql);
//						System.out.println("Statement: '" + sql + " executed.\n" );
//					} catch (SQLSyntaxErrorException e) {
//						System.out.println(e.getMessage()) ;
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
