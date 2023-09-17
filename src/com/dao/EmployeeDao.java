package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.util.DBConnection;

class Employee {

	int eId;
	String eName;
	int eAge;
	String eEmail;

	public Employee(int eId, String eName, int eAge, String eEmail) {

		this.eId = eId;
		this.eName = eName;
		this.eAge = eAge;
		this.eEmail = eEmail;
	}

}

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

	public void addEmployees() {

		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			String insertSQL = "insert into employee(ename,eemail,eage)values(?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, "ram");
				pstmt.setString(2, "ram1@gmail.com");
				pstmt.setInt(3, 24);

				pstmt.addBatch();

				pstmt.setString(1, "sita");
				pstmt.setString(2, "sita@gmail.com");
				pstmt.setInt(3, 23);

				pstmt.addBatch();
				pstmt.setString(1, "kush");
				pstmt.setString(2, "kush@gmail.com");
				pstmt.setInt(3, 3);

				pstmt.addBatch();

				// batch execute..

				int res[] = pstmt.executeBatch();
				if (res.length > 0) {

					System.out.println(res.length + " employee inseted...");
				} else {

					System.out.println("No employee inserted...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void addEmpList() {

		List<Employee> emplist = new ArrayList<Employee>();
		emplist.add(new Employee(101, "rahul", 23, "rahul@gmail.com"));
		emplist.add(new Employee(102, "priya", 26, "priya@gmail.com"));

		Connection conn = DBConnection.getDbConnection();
		String insertSQL = "insert into employee(ename,eemail,eage)values(?,?,?)";
		if (conn != null) {

			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				for (Employee e : emplist) {

					pstmt.setString(1, e.eName);
					pstmt.setString(2, e.eEmail);
					pstmt.setInt(3, e.eAge);
					pstmt.addBatch();
				}

				int res[] = pstmt.executeBatch();
				if (res.length > 0) {

					System.out.println(res.length + " employee inseted...");
				} else {

					System.out.println("No employee inserted...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		EmployeeDao employeeDao = new EmployeeDao();
		// employeeDao.addEmployee();
		// employeeDao.updateEmployee();
		//employeeDao.addEmployees();
		employeeDao.addEmpList();

	}
}
