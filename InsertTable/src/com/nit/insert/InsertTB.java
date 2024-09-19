package com.nit.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertTB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
       System.out.println("database is connected");
       Statement st=con.createStatement();
       String query="INSERT INTO STUDENT VALUES(102,'rajesh','B', 80)";
       st.executeUpdate(query);
       System.out.println("table record added");
       st.close();
       con.close();
	}

}
