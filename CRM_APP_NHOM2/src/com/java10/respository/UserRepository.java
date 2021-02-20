package com.java10.respository;

import com.java10.ConnectionDB.*;
import com.java10.DTO.UserDTO;
import com.java10.module.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class UserRepository {
	public List<User> getAllUser(){
		Connection con = ConnectionDB.getConnection();
		if (con == null)
			return null;
		
		List<User> listUser = new LinkedList<User>();
		try {
			String query = "SELECT * FROM CRM_APP.USER";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				User user = new User();
				user.setId(result.getInt("id"));
				user.setEmail(result.getNString("email"));
				user.setPassword(result.getNString("password"));
				user.setFullname(result.getNString("username"));
				user.setAvatar(result.getNString("avatar"));
				user.setRole_id(result.getInt("roleId"));
				listUser.add(user);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	
	public int insert(User user) {
		int res = -1;
		try {
			Connection con = ConnectionDB.getConnection();
			String query = "INSERT INTO CRM_APP.USER(email, password, username, avatar, roleId) VALUES(? ,?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setNString(1, user.getEmail());
			statement.setNString(2, user.getPassword());
			statement.setNString(3, user.getFullname());
			statement.setNString(4, user.getAvatar());
			statement.setInt(5, user.getRole_id());
			res = statement.executeUpdate();
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public User findUserById(int id) {
		User user;
		try {
			Connection con  = ConnectionDB.getConnection();
			String query = "SELECT * FROM CRM_APP.USER WHERE id=?"; 
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
			    user = new User();
				user.setAvatar(res.getNString("avatar"));
				user.setEmail(res.getNString("email"));
				user.setFullname(res.getNString("username"));
				user.setPassword(null);
				user.setId(res.getInt("id"));
				user.setRole_id(res.getInt("roleId"));
				return user;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UserDTO login(String email, String password) {
		UserDTO userDTO;
		try {
			Connection con  = ConnectionDB.getConnection();
			String query = "SELECT * FROM CRM_APP.ROLE INNER JOIN CRM_APP.USER ON CRM_APP.USER.roleId=CRM_APP.ROLE.id";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				if (res.getNString("email").equals(email) && BCrypt.checkpw(password, res.getNString("password"))) {
					userDTO = new UserDTO();
					userDTO.setAvatar(res.getNString("avatar"));
					userDTO.setDesRole(res.getNString("description"));
					userDTO.setEmail(res.getNString("email"));
					userDTO.setFullname(res.getNString("username"));
					userDTO.setPassword(password);
					userDTO.setId(res.getInt("USER.id"));
					userDTO.setRole_id(res.getInt("roleId"));
					userDTO.setRoleName(res.getNString("name"));
					return userDTO;
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int delete(int id) {
		int res = -1;
		try {
			Connection con = ConnectionDB.getConnection();
			String query = "DELETE FROM CRM_APP.USER WHERE id=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			res = statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int edit(User user) {
		int res = -1;
		try {
			Connection con = ConnectionDB.getConnection();
			String query;
			PreparedStatement statement;
			if (user.getPassword() == "") {
				query= "UPDATE CRM_APP.USER SET email=?,username=?, avatar=?, roleId=? WHERE id=?";
				statement = con.prepareStatement(query);
				statement.setString(1, user.getEmail());
				statement.setString(2, user.getFullname());
				statement.setString(3, user.getAvatar());
				statement.setInt(4, user.getRole_id());
				statement.setInt(5, user.getId());
				res = statement.executeUpdate();
			}
			else {
				query= "UPDATE CRM_APP.USER SET email=?,password=?, username=?, avatar=?, roleId=? WHERE id=?";
				statement = con.prepareStatement(query);
				statement.setString(1, user.getEmail());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getFullname());
				statement.setString(4, user.getAvatar());
				statement.setInt(5, user.getRole_id());
				statement.setInt(6, user.getId());
				res = statement.executeUpdate();
			}
			
			con.close();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return res;
	}
	public List<UserDTO> findAllJoin() {
		
		List<UserDTO> listUser = new LinkedList<UserDTO>();
		Connection con = ConnectionDB.getConnection();
		if (con == null)
			return null;
		try {
			String query = "SELECT * FROM CRM_APP.ROLE INNER JOIN CRM_APP.USER ON CRM_APP.USER.roleId=CRM_APP.ROLE.id";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				UserDTO user = new UserDTO();
				user.setId(result.getInt("USER.id"));
				user.setEmail(result.getNString("email"));
				user.setPassword(result.getNString("password"));
				user.setFullname(result.getNString("username"));
				user.setAvatar(result.getNString("avatar"));
				user.setRole_id(result.getInt("roleId"));
				user.setDesRole(result.getNString("description"));
				listUser.add(user);
			}
     		con.close();
     		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listUser;
	}
	
	
}
