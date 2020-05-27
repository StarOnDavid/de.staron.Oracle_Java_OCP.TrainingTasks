package JDBC_Utils.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test_Connection {
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1";
	private static final String USER = "JAVAJBDC";
	private static final String PASS = "javaJBDC";

	public static void main(String[] args) {
		Connection dbCon = getJDBC_Connection(URL, USER, PASS);
		
		try {
			System.out.println(dbCon.isReadOnly());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finish(dbCon);
	}

	private static Connection getJDBC_Connection(String url, String user, String pass) {
		Connection conn = null;
		
		/**
		 * Nicht nötig wenn der DB-Treiber nach JDBC 4 spezifiziert ist. Denn ist der Treiber nach
		 * JDBC spezifiziert kann "DriverManager.getConnection(url, user, pass)" den Treiber automatisch
		 * registrieren.
		 * Die dafür nötige Info welche Treiberklasse geladen werden soll muss wie folgt im db-treiber.jar
		 * hinterlegt sein: db-treiber.jar/META-INF/services/java.sql.Driver (ist eine txt Datei).
		 */
		/*
		try {
			   Driver myDriver = new oracle.jdbc.driver.OracleDriver();
			   DriverManager.registerDriver( myDriver );
			   System.out.println("JDBC Driver loaded !");
			}
			catch (SQLException e) {
				 System.out.println("Error: unable to load driver class!");
				   System.exit(1);
			}
			*/
		
			try {
				conn = DriverManager.getConnection(url, user, pass);
				System.out.println("DB connected !!! ");
			} catch (SQLException e) {
				System.out.println("Error: unable to connect!");
				e.printStackTrace();
				   System.exit(1);
			}
		   
		return conn;
	}

	private static void finish(Connection conn) {
		try {
			conn.close();
			System.out.println("DB connection closed.");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		   System.out.println("end of main");
	}

}
