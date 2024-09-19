package com.nit.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTB {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver is loaded");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
		System.out.println("connection is opened with database");
		Statement st=con.createStatement();
		String query="CREATE TABLE STUDENT ("
				+ "SID INT,"
				+ "SNAME VARCHAR(20),"
				+ "SECTION VARCHAR(20),"
				+ "MARKS INT,"
				+ "PRIMARY KEY(SID, SECTION)"
				+ ")";
		st.executeUpdate(query);
		System.out.println("create table query is executed");
		System.out.println("table is created");
		st.close();
		con.close();
	}

}
