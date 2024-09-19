package com.nit.oracletb;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class OracleTable {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
      System.out.println("database is connected");
      Statement st=con.createStatement();
      String query="CREATE TABLE student(sid number primary key, sname varchar2(20), address varchar2(20), mob varchar2(20), dob date)";
	  st.executeUpdate(query);
	  System.out.println("table is created");
	  st.close();
	  con.close();
	
	}

}
