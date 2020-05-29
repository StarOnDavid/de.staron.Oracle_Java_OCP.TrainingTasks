package _200528_DAO_interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlUtils {

	private static final String url = "jdbc:mysql://localhost/test_java?serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "1234";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	/*
	 * A3. printTestTable soll die Test-Tabelle 'tiere' formatiert ausgeben
	 *
	 * | id | name   | alter |
	 * |  1 |  Tom   |     3 |
	 * |  2 |  Jerry |     5 |
	 * |  3 |  Rex   |     2 |
	 *
	 */
	public static void printTestTable() {
		try(Connection connection = getConnection();
				Statement stm = connection.createStatement();
					ResultSet res = stm.executeQuery("select * from tiere")) {
			
			String fmt = "| %2s | %5s | %5s |%n";
			System.out.printf(fmt, "id", "name", "alter");
			
			while( res.next() ) {
				
				System.out.printf(fmt, res.getInt("id"),
						res.getString("name"),
						res.getInt("alter") );
			}
			
		} catch (SQLException e) {
			throw new AssertionError(e);
		}
	}
	
	
	/*
	 * A2. rebuildTestTable soll eine Test-Tabelle erzeugen (alte löschen)
	 *
	 * - SQL, Tabelle löschen:  drop table tiere
	 * - MySQL, Tabelle löschen falls sie existiert:  drop table if exists tiere
	 *
	 * - SQL, Tabelle erstellen
	 *
	 *	CREATE TABLE tiere (
	 *    `id` INT NOT NULL,
	 *    `name` VARCHAR(45) NOT NULL,
	 *    `alter` INT NOT NULL)
	 */
	
	public static void rebuildTestTable() {
	
		try(Connection connection = getConnection()) {
			
			try(Statement stm = connection.createStatement()) {
				stm.executeUpdate("drop table if exists tiere");
				
				String script = loadScript("/jdbc/mysql/createTable.sql");
				stm.executeUpdate(script);
			}
			
			
			String script = loadScript("/jdbc/mysql/insertRow.sql");
			// INSERT INTO `tiere` (`id`, `name`, `alter`) VALUES (?, ?, ?)
			//                                                     1  2  3  <- Parameter Index für setInt oder setString
			
			try( PreparedStatement stm = connection.prepareStatement(script) ) {
				stm.setInt(1, 1); // id setzen
				stm.setString(2, "Tom");
				stm.setInt(3, 3); // alter (parameter index = 3)
				
				stm.execute();
				
				stm.setInt(1, 2); // id setzen
				stm.setString(2, "Jerry");
				stm.setInt(3, 2); // alter (parameter index = 3)
				
				stm.execute();
				
				stm.setInt(1, 3); // id setzen
				stm.setString(2, "Rex");
				stm.setInt(3, 2); // alter (parameter index = 3)
				
				stm.execute();
			}
			
		} catch (SQLException e) {
			throw new AssertionError(e);
		}
		
		// 3 Test-Datensätze speichern (id, name, alter):
		// 1 Tom 3
		// 2 Jerry 5
		// 3 Rex 2
	}
	
	/*
	 * A1.
	 *
	 * 		Datei 'selectAll.sql' hat den Text:  select * from autos
	 *
	 * 		Die Methode loadScript soll den Text aus einer Datei aus dem Classpath laden und liefern
	 *
	 * 		String script = loadScript("/jdbc/mysql/selectAll.sql");
	 *		// Im String script ist jetzt der Text "select * from autos"
	 */
	public static String loadScript(String resourceName) {
		InputStream is = MySqlUtils.class.getResourceAsStream(resourceName);
		
		try( BufferedReader in = new BufferedReader(new InputStreamReader(is)) ) {
			String line;
			StringBuilder sb = new StringBuilder();
			while( (line=in.readLine()) != null ) {
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public static void main(String[] args) {
//		String script = loadScript("/jdbc/mysql/selectAll.sql");
//		String script = loadScript("selectAll.sql");
//		System.out.println(script);
		rebuildTestTable();
		printTestTable();
	}
}
