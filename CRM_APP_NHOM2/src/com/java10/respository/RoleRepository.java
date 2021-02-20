package com.java10.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.java10.ConnectionDB.ConnectionDB;
import com.java10.module.Role;

public class RoleRepository {

	public RoleRepository() {
		// TODO Auto-generated constructor stub
	}

	public List<Role> getAllRole() {
//		
//		if (con == null)
//			return null;
//		
		List<Role> listRole = new LinkedList<Role>();
		try (Connection con = ConnectionDB.getConnection()) {
			String query = "SELECT * FROM CRM_APP.ROLE";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Role role = new Role();
				role.setId(result.getInt("id"));
				role.setName(result.getNString("name"));
				role.setDescription(result.getNString("description"));

				listRole.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listRole;
	}

	public int insert(Role role) {
		int res = -1;
		try {
			Connection con = ConnectionDB.getConnection();
			String query = "INSERT INTO CRM_APP.ROLE(name, description) VALUES(?, ?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			res = statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int delete(int id) {
		int res = -1;
		try {
			Connection con = ConnectionDB.getConnection();
			String query = "DELETE FROM CRM_APP.ROLE WHERE id=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			res = statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public Role findRoleByID(int id) {
		Role role = null;
		try {
			Connection connection = ConnectionDB.getConnection();
			String query = "SELECT * FROM CRM_APP.ROLE WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				role = new Role();
				role.setId(res.getInt("id"));
				role.setName(res.getNString("name"));
				role.setDescription(res.getNString("description"));
				break;
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return role;
	}

	public int edit(Role role) {
		int res = -1;
		try {
			Connection con = ConnectionDB.getConnection();
			String query = "UPDATE CRM_APP.ROLE SET name=?, description=? WHERE id=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());
			res = statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
