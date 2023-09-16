package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final static String user = "root";
	private final static String password = "root";
	private final static String driverClass = "com.mysql.cj.jdbc.Driver";
	private final static String connectionUrl = "jdbc:mysql://localhost:3306/22jan";

	public static Connection getDbConnection() {
		Connection conn = null;
		try {
			// load driver class
			Class.forName(driverClass);

			// getting connection with db.,...
			conn = DriverManager.getConnection(connectionUrl, user, password);
			if (conn != null) {

				System.out.println("connected with database successfully....");
			} else {
				System.out.println("Error while connecting...");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	public static void main(String[] args) {

		getDbConnection();

	}
}
