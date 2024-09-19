package com.nit.oracleupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OracleUpdateTB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
	      System.out.println("database is connected");
	      Statement st=con.createStatement();
	      String qr="UPDATE student SET sname='rakesh' WHERE sid=101";
	      st.executeUpdate(qr);
	      System.out.println("record is update");
	      st.close();
	      con.close();
	}

}
