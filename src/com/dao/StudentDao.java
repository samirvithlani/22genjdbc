package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.StudentBean;
import com.util.DBConnection;

public class StudentDao {

	// 1121
	public boolean addStudent(StudentBean studentBean) {

		// StudentBean studentBean2 = new StudentBean();//1122
		// System.out.println("..."+studentBean2.getsName());//null
		// System.out.println("studen dao,, name..."+studentBean.getsName());
		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			String insertSQL = "insert into student (sname,semail,sage)values(?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, studentBean.getsName());
				pstmt.setString(2, studentBean.getsEmail());
				pstmt.setInt(3, studentBean.getsAge());

				int res = pstmt.executeUpdate();
				if (res > 0) {

					return true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

}
