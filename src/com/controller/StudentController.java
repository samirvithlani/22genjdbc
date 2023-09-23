package com.controller;

import java.util.Scanner;

import com.bean.StudentBean;
import com.dao.StudentDao;

public class StudentController {

	public void addStudent() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter student name :");
		String sName = sc.next();
		System.out.println("enter student email :");
		String sEmail = sc.next();
		System.out.println("enter student age :");
		int sAge = sc.nextInt();
		//replcae by html / jsp --->

		// create an object of student Bean class

		StudentBean studentBean = new StudentBean(); // 1121
		studentBean.setsName(sName);
		studentBean.setsEmail(sEmail);
		studentBean.setsAge(sAge);

		// studentDao....
		StudentDao studentDao = new StudentDao();
		boolean flag = studentDao.addStudent(studentBean);
		if (flag == true) {
			System.out.println("student added...");
		} else {
			System.out.println("student not added...");
		}

	}

	public static void main(String[] args) {

		StudentController studentController = new StudentController();
		studentController.addStudent();
	}
}
