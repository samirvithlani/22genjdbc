package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConnection;

public class EmployeeDao {

	public void addEmployee() {

		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			// ? place holder..
			String insertSQL = "insert into employee(ename,eemail,eage)values(?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				Scanner sc = new Scanner(System.in);
				System.out.println("enter employee name ::");
				String eName = sc.next();
				pstmt.setString(1, eName);
				pstmt.setString(2, "ram@gmail.com");
				pstmt.setInt(3, 23);
				int res = pstmt.executeUpdate();
				if (res > 0) {

					System.out.println("employee inserted...");
				} else {
					System.out.println("employee not inserted..");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void updateEmployee() {

		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			String updateSQL = "update employee set ename = ?,eemail=?,eage =? where eid =?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, "amit");
				pstmt.setString(2, "amit@gmail.com");
				pstmt.setInt(3, 34);
				pstmt.setInt(4, 2);
				
				int res = pstmt.executeUpdate();
				System.out.println(res);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		EmployeeDao employeeDao = new EmployeeDao();
		//employeeDao.addEmployee();
		employeeDao.updateEmployee();

	}
}
