package com.nit.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallStmt {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
		System.out.println("database is connected");
		String query="call insert_patient(?,?,?,?,?,?)";
		CallableStatement ct=con.prepareCall(query);
		ct.setInt(1,101);  
		ct.setString(2,"Amit");
		ct.setString(3, "kanpur");
		ct.setString(4, "9203450612");
		ct.setString(5, "12-09-2024");
		ct.setString(6, "fever");
		ct.execute();   
		System.out.println("record inserted");  
		ct.close();
		con.close();
       
	}

}
