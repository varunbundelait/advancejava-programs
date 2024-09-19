package com.nit.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteRecordTB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
		System.out.println("database is connected");
		Statement st=con.createStatement();
		String query="DELETE FROM student WHERE sid=102";
        st.executeUpdate(query);
        System.out.println("Records is delete");
        st.close();
        con.close();
	}

}
