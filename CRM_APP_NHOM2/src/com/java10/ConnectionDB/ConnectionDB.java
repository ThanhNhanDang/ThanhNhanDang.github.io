package com.java10.ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static String urlSQL = "jdbc:mysql://localhost:3306/CRM_APP";
	private static String userNameSQL = "root";
	private static String passwordSQL = "1234";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(urlSQL, userNameSQL, passwordSQL);
		} catch (ClassNotFoundException e) {
			System.out.println("Kết nối thất bại! Không đ�?c được drive jdbc");
		} catch (SQLException e) {
			System.out.println("Kết nối thất bại! Sai userName hoặc password");
		}
		return null;
	}
}
