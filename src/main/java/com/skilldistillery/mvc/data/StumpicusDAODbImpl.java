package com.skilldistillery.mvc.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;


@Repository
@Primary
public class StumpicusDAODbImpl implements StumpicusDAO {

	ArrayList<Warrior> army;
	private static String url = "jdbc:mysql://localhost:3306/stumpedb";
	private String user = "stumpicus";
	private String pass = "stumpicus";

	public StumpicusDAODbImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}
	
	@Override
	public Warrior getWarriorById(int id) {
		Warrior warrior = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT w.id, w.name, r.name, wep.weapon_name, c.class_name\n" + 
					"FROM warrior w JOIN rank r ON w.rank_id = r.id\n" + 
					"							JOIN weapon wep ON w.weapon_id = wep.id\n" + 
					"                            JOIN warrior_class c ON w.warrior_class_id = c.id\n" + 
					"WHERE w.id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
				String name = rs.getString(2);
				Rank rank = Rank.valueOf(rs.getString(3).toUpperCase());
				Weapons weapon = Weapons.valueOf(rs.getString(4).toUpperCase());
				WarriorClass wClass = WarriorClass.valueOf(rs.getString(5).toUpperCase());
				warrior = new Warrior(id, name, rank, weapon, wClass);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return warrior;
	}

	@Override
	public Warrior addWarrior(Warrior w) {
		Warrior warrior = new Warrior();
		String sql = "INSERT INTO warrior(name, rank_id, weapon_id, warrior_class_id) VALUES(?,?,?,?)";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, w.getName());
			st.setInt(2, w.getRank().getValue());
			st.setInt(3, w.getWeapon().getValue());
			st.setInt(4, w.getwClass().getValue());

			// trying to get it to add to the list, so far no luck
			int uc = st.executeUpdate();
			if (uc == 1) {
				ResultSet keys = st.getGeneratedKeys();
				if (keys.next()) {
					int id = keys.getInt(1);
					conn.commit();
					w.setId(id);
				}
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return warrior;
	}

	@Override
	public Warrior deleteWarrior(Warrior w) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "DELETE FROM warrior WHERE id= ?";
			conn.setAutoCommit(false);
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, w.getId());
			st.executeUpdate();
			conn.commit();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException e2) {
					System.err.println("Error trying to rollback");
				}
			}
			return w;
		}
		return w;

	}

	@Override
	public Warrior updateWarrior(Warrior w) {
		Warrior warrior = null;
		String sql = "UPDATE warrior SET name = ?, rank_id = ?, weapon_id = ?, warrior_class_id = ? WHERE id = ?";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, w.getName());
			st.setInt(2, w.getRank().getValue());
			st.setInt(3, w.getWeapon().getValue());
			st.setInt(4, w.getwClass().getValue());
			st.setInt(5, w.getId());

			// trying to get it to add to the list, so far no luck
			int uc = st.executeUpdate();
			if (uc == 1) {
				ResultSet keys = st.getGeneratedKeys();
				while (keys.next()) {
					String name = keys.getString(2);
					int id = keys.getInt(1);
					w.setId(id);
				}
			}
			conn.commit();
			st.close();
			conn.close();
			warrior = w;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return warrior;
	}

	@Override
	public List<Warrior> getAllWarriors() {
		Warrior warrior = null;
		Rank rank = null;
		WarriorClass wClass = null;
		Weapons weapon = null;
		army = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
						//		   1		2		3				4			5
			String sql = "SELECT w.id, w.name, r.name, wep.weapon_name, c.class_name\n" + 
					"FROM warrior w JOIN rank r ON w.rank_id = r.id\n" + 
					"							JOIN weapon wep ON w.weapon_id = wep.id\n" + 
					"							JOIN warrior_class c ON w.warrior_class_id = c.id;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int id = 0;
			while (rs.next()) {
				id = rs.getInt(1);
				String name = rs.getString(2);
				rank = Rank.valueOf(rs.getString(3).toUpperCase());
				weapon = Weapons.valueOf(rs.getString(4).toUpperCase());
				wClass = WarriorClass.valueOf(rs.getString(5).toUpperCase());
				warrior = new Warrior(id, name, rank, weapon, wClass);
				army.add(warrior);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return army;
	}

}
