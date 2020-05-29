package _200528_MiniTask_DAO_Tier;

import java.util.List;

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
	Tier findById(int id);
	
	//...
	
	// void update(Tier t, java.sql.Connection c); // falsch. Die Methode mein konkrett nach einer JDBC-Lösung
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "Tier [id=" + id + ", name=" + name + ", alter=" + alter + "]";
	}
	
	
	//Konstruktoren ...
	
	//getter/setter ...
}

public class DAO_TierTask {

	public static void main(String[] args) {

		TierDAO dao = TierDAO.getDefaultDAO();
		
		/*
		 * Die Anwendung sollte auf das DAO-Interface programmiert werden
		 */
		
		System.out.println("** 1. alle Tiere: ");
		List<Tier> alleTiere = dao.selectAll();
		for (Tier tier : alleTiere) {
			System.out.println(tier);
		}
		
		Tier t = new Tier(2, "Lassie", 7);
		dao.insert(t);

		
		System.out.println("** 2. alle Tiere: ");
		alleTiere = dao.selectAll();
		for (Tier tier : alleTiere) {
			System.out.println(tier);
		}
		
		Tier t2 = dao.findById(7);
		System.out.println("** 3. Tier mit der id=7: " + t2);
		
	}

}
