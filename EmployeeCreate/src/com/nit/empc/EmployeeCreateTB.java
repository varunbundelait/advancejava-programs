package com.nit.empc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeCreateTB {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
       System.out.println("database is connected");
       Statement st=con.createStatement();
       String qr="CREATE TABLE emp(empno int primary key, ename varchar(20), salary int, address varchar(20), dateofjoining date, mobileno int, deptname varchar(20))";
       st.executeUpdate(qr);
       System.out.println("table is created");
       st.close();
       con.close();
   
	}

}
