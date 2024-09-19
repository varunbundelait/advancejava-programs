package com.nit.oracleselect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleSelect {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
	      System.out.println("database is connected");
	      Statement st=con.createStatement();
	      String qr="SELECT * FROM student";
	      ResultSet rs=st.executeQuery(qr);
	      while(rs.next()) {
	    	  System.out.println("SID:" +rs.getInt(1));
	    	  System.out.println("SNAME:" +rs.getString(2));
	    	  System.out.println("ADDRESS:" +rs.getString(3));
	    	  System.out.println("MOB:" +rs.getString(4));
	    	  System.out.println("DOB:" +rs.getDate(5));
	      }
	      System.out.println("records is fetched successfully");
	      rs.close();
	      st.close();
	      con.close();
	      
	}

}
