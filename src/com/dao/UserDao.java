package com.dao;

import java.sql.Connection;
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
				
				//String str = "java"+uAge+"hello";
				
				//delete from user where uId = "+id+";
				String insertSQL = "insert into users(uname,uemail,uage)values('"+uName+"','"+uEmail+"',"+uAge+")";
				//String insertSQL = "insert into users(uname,uemail,uage)values('raj','raj@gmail.com',23)";
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

		}

	}

	public static void main(String[] args) {

		UserDao userDao = new UserDao();
		userDao.addUser();

	}
}
