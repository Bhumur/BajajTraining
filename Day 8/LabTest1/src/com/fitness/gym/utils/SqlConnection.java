package com.fitness.gym.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SqlConnection {
	public static Connection getSqlConnection() {
		
		Connection connection = null;
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("application");
			String url = bundle.getString("datasource.url");
			String username = bundle.getString("datasource.username");
			String password = bundle.getString("datasource.password");
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
