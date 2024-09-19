package com.nit.empdel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeDeleteTB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		   Class.forName("com.mysql.cj.jdbc.Driver");
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
	       System.out.println("database is connected");
	       Statement st=con.createStatement();
	       String qr="DELETE FROM emp WHERE empno=102";
	       st.executeUpdate(qr);
	       System.out.println("Records is deleted");
	       st.close();
	       con.close();

	}

}
