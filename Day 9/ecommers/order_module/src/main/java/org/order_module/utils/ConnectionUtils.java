package org.order_module.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionUtils {
	public static Connection getConnection() {
		
		Connection connection = null;
		try {
//			ResourceBundle bundle = ResourceBundle.getBundle("application");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
