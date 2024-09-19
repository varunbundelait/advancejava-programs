package com.nit.preparemysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//single value insert in database mysql
public class PrepareStmtMysql {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root", "root");
        System.out.println("database is connected");
	    String query="INSERT INTO student(sid, sname, section, marks) VALUES(?, ?, ?, ?)";
        PreparedStatement pr=con.prepareStatement(query);
        pr.setInt(1, 103);
		pr.setString(2, "divya");
		pr.setString(3, "D");
		pr.setInt(4, 67);
		pr.executeUpdate();
        System.out.println("record is inserted");
        pr.close();
        con.close();
	}

}
