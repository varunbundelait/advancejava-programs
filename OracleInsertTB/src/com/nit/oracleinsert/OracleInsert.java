package com.nit.oracleinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OracleInsert {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
	      System.out.println("database is connected");
	      Statement st=con.createStatement();
	      String query="INSERT INTO student VALUES(101,'ramesh','kanpur','9023404567',TO_DATE('2023-07-10', 'YYYY-MM-DD'))";
		  //String query="INSERT INTO emp VALUES(7839,'king','president','',TO_DATE('1981-11-17', 'YYYY-MM-DD'),5000,'',10)";
	      st.executeUpdate(query);
		  System.out.println("record is added");
		  st.close();
		  con.close();
	}

}
