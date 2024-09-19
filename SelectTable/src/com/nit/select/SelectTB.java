package com.nit.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
		System.out.println("database is connected");
		Statement st=con.createStatement();
		String query="select * from student";
		
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println("SID:" +rs.getInt(1)+"\t");
			System.out.println("SNAME:" +rs.getString(2)+"\t");
			System.out.println("SECTION:" +rs.getString(3)+"\t");
			System.out.println("MARKS:" +rs.getInt(4)+"\t");
		}
        st.close();
        rs.close();
        con.close();
	}

}
