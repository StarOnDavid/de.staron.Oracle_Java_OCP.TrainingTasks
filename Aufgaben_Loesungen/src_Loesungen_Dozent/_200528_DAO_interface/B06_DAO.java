package _200528_DAO_interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * DAO = Data Access Object
 *
 * 		Entwurfsmuster mit dem der Code der Anwendung von den
 * 		Details der Datenverwaltung entkoppelt wird.
 */


/*
 * Die Anwendung sollte auf das DAO-Interface programmiert werden.
 *
 * DAO-Interface beschreibt die Möglichkeiten der Tier-Verwaltung ohne
 * die Details der Realisierung zu verraten
 */
interface TierDAO {
	static TierDAO getDefaultDAO() {
		return new MySqlTierDaoImpl();
	}
	
	List<Tier> selectAll();
	void insert(Tier t);
	Optional<Tier> findById(int id);
	
	//...
	
	// void update(Tier t, java.sql.Connection c); // falsch. Die Methode meint konkrett die JDBC-Lösung
}

/*
 * Datensatz-Klasse (Entity) - 'normale' Java-Klasse (POJO)
 */
class Tier {
	private int id;
	private String name;
	private int alter;
	
	public Tier(int id, String name, int alter) {
		this.id = id;
		this.name = name;
		this.alter = alter;
	}
	
	//Konstruktoren ...
	
	//getter/setter ...
	public int getId() {
		return id;
	}
	public int getAlter() {
		return alter;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("%d. %s %d", id, name, alter);
	}
}



/*
 * Eine konkrete Realisierung des DAO-Interfaces
 */
class MySqlTierDaoImpl implements TierDAO {
	private static final String url = "jdbc:mysql://localhost/test_java?serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "1234";

		
	@Override
	public List<Tier> selectAll() {
		try(Connection connection = DriverManager.getConnection(url, user, password);
				Statement stm = connection.createStatement();
					ResultSet res = stm.executeQuery("select * from tiere")) {

			List<Tier> list = new ArrayList<>();
			
			while(res.next()) {
				list.add( new Tier(res.getInt(1), res.getString(2), res.getInt(3)) );
			}
			
			return list;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insert(Tier t) {
		String sql = "INSERT INTO `tiere` (`id`, `name`, `alter`) VALUES (?, ?, ?)";
		
		try(Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.setInt(1, t.getId());
			stm.setString(2, t.getName());
			stm.setInt(3, t.getAlter());
			stm.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Optional<Tier> findById(int id) {
		try(Connection connection = DriverManager.getConnection(url, user, password);
				Statement stm = connection.createStatement();
					ResultSet res = stm.executeQuery("select * from tiere where id=" + id)) {
			
			if( !res.next() ) {
				return Optional.empty();
			}
			
			Tier t = new Tier(res.getInt(1), res.getString(2), res.getInt(3));
			return Optional.of(t);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}

public class B06_DAO {

	public static void main(String[] args) {

		MySqlUtils.rebuildTestTable();
		
		TierDAO dao = TierDAO.getDefaultDAO();
		
		/*
		 * Die Anwendung sollte auf das DAO-Interface programmiert werden
		 */
		
		System.out.println("** 1. alle Tiere: ");
		List<Tier> alleTiere = dao.selectAll();
		for (Tier tier : alleTiere) {
			System.out.println(tier);
		}
		
		Tier t = new Tier(4, "Lassie", 7);
		dao.insert(t);

		
		System.out.println("** 2. alle Tiere: ");
		alleTiere = dao.selectAll();
		for (Tier tier : alleTiere) {
			System.out.println(tier);
		}
		
		Tier t2 = dao.findById(2).get();
		System.out.println("** 3. Tier mit der id=2: " + t2);
		
	}

}
