package JDBC_Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleSqlUtils {
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1";
	private static final String USER = "JAVAJDBC";
	private static final String PASS = "javaJDBC";
	
	public static Connection getTestConnection() throws SQLException{
		return getConnection(URL, USER, PASS);
	}

	public static Connection getConnection(String url, String user, String pass) throws SQLException{
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("DB connected !!! ");
		
		return conn;
	}

	public static void finish(Connection conn) throws SQLException{
		conn.close();
		System.out.println("DB connection closed.");
	}
	
	public static List<String> loadSqlScript(String path, String file){
		List<String> scripts = new ArrayList<>();
		
		
		try ( BufferedReader in = new BufferedReader(new FileReader(path + "/" + file)) ) {
			
			String line;
			StringBuilder tmp = new StringBuilder();
			while( (line = in.readLine()) != null) {
				if(line.isBlank())
					continue;
				if(line.charAt(line.length()-1) == ';') {
					tmp.append(line.substring(0, line.length()-1).trim());
					scripts.add(tmp.toString());
					tmp.delete(0, tmp.length());
				} else {
					tmp.append(line.trim() + " ");
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return scripts;
	}
}