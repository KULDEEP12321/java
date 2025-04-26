package com.app_web_project.model;

import java.sql.*;

public class DAOService {//data access object
	
	private Connection con;
	private Statement stmnt;
	
	public void connectDb() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_project_db","root","test");
			stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email = '"+email+"' and password = '"+password+"'");
			return result.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addStudent(String name , String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into student values('"+name+"','"+email+"','"+mobile+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ResultSet getAllStudents() {
		try {
			ResultSet result = stmnt.executeQuery("select * from student ");
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public void deleteStudentInfo(String email) {
		
		try {
			stmnt.executeUpdate("Delete from student where email = '"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public void updateRegistration(String email, String mobile) {
		try {
			stmnt.executeUpdate("update student set mobile='"+mobile+"'where email = '"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
}
