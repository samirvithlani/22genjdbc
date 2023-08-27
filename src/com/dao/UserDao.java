package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class UserDao {

	public void addUser() {

		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			try {
				Statement stmt = conn.createStatement();
				Scanner sc = new Scanner(System.in);
				System.out.println("enter user Name : ");
				String uName = sc.next();
				System.out.println("enter user email :");
				String uEmail = sc.next();
				System.out.println("enter user Age");
				int uAge = sc.nextInt();

				// String str = "java"+uAge+"hello";

				// delete from user where uId = "+id+";
				String insertSQL = "insert into users(uname,uemail,uage)values('" + uName + "','" + uEmail + "'," + uAge
						+ ")";
				// String insertSQL = "insert into
				// users(uname,uemail,uage)values('raj','raj@gmail.com',23)";
				// submit query
				// stmt.execute(insertSQL); <--- boolean --> DMl DDL DML --> true, DDL -->
				// resultSET
				int res = stmt.executeUpdate(insertSQL); // <-- int DML --> it will return affecetd rows count...
				// stmt.executeQuery(insertSQL); <--- DDL <--- ResultSet interface...
				// stmt.executeLargeUpdate(insertSQL); // <-- batch process.... long

				if (res > 0) {

					System.out.println("[" + res + "] insrted...");
				} else {

					System.out.println("record not inserted...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			System.out.println("connection null");
		}
	}

	public void updateUser() {

		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {
			Scanner sc = new Scanner(System.in);
			try {
				Statement stmt = conn.createStatement();
				System.out.println("enter userName to update...");
				String uName = sc.next();
				System.out.println("enter userEmail to update..");
				String uEmail = sc.next();
				System.out.println("enter user Age to update..");
				int uAge = sc.nextInt();
				System.out.println("enter user id tp update record....");
				int uId = sc.nextInt();

				String updateSQL = "update users set uname = '" + uName + "',uemail = '" + uEmail + "',uage = " + uAge
						+ " where uId = " + uId + "";

				int res = stmt.executeUpdate(updateSQL);
				if (res > 0) {

					System.out.println("rows updated..." + res);
				} else {

					System.out.println("No rows updated !!");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void getUserData() {

		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			try {
				Statement stmt = conn.createStatement();
				String selectSQL = "select * from users";
				ResultSet rs = stmt.executeQuery(selectSQL);
				System.out.println("UID\tUNAME\tuemail\t\t\tuage");
				System.out.println("--------------------------------------------");
				
				while (rs.next()) {

					// rs.getInt("uId");
					//System.out.println(rs.getInt(4));
					System.out.print(rs.getInt("uid"));
					System.out.print("\t" + rs.getString("uname"));
					System.out.print("\t" + rs.getString("uemail"));
					System.out.print("\t\t" + rs.getInt("uage"));
					System.out.println();

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		UserDao userDao = new UserDao();
		// userDao.addUser();
		//userDao.updateUser();
		userDao.getUserData();

	}
}
