package com.nit.empalter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeAlterTB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		   Class.forName("com.mysql.cj.jdbc.Driver");
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
	       System.out.println("database is connected");
	       Statement st=con.createStatement();
	       String qr="ALTER TABLE emp ADD COLUMN deptname varchar(20)";
	       st.executeUpdate(qr);
	       System.out.println("Records is altered");
	       st.close();
	       con.close();
	}

}
