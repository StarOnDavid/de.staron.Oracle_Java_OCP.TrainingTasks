package _200528_MiniTask_DAO_Tier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JDBC_Utils.OracleSqlUtils;

public class MySqlTierDaoImpl implements TierDAO {

	@Override
	public List<Tier> selectAll() {
		List<Tier> tiere = new ArrayList<>();
		try (Connection con = OracleSqlUtils.getTestConnection()) {
			try(Statement stm = con.createStatement()) {
				try ( ResultSet res = stm.executeQuery("SELECT * FROM animals") ) {
					while(res.next()) {
						tiere.add(new Tier(res.getInt("id"), res.getString("name"), res.getInt("age")));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tiere;
	}

	@Override
	public void insert(Tier t) {
		try (Connection con = OracleSqlUtils.getTestConnection()) {
			try(Statement stm = con.createStatement()) {
				stm.execute("INSERT INTO animals VALUES (" + t.getId() + ", '" + t.getName() + "', " + t.getAlter() + ")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Tier findById(int id) {
		Tier t = null;
		try (Connection con = OracleSqlUtils.getTestConnection()) {
			try(Statement stm = con.createStatement()) {
				try ( ResultSet res = stm.executeQuery("SELECT * FROM animals WHERE id = " + id) ) {
					res.next();
					t = new Tier(res.getInt("id"), res.getString("name"), res.getInt("age"));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

}
