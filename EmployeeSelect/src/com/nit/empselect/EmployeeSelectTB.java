package com.nit.empselect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeSelectTB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	     Class.forName("com.mysql.cj.jdbc.Driver");
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
	       System.out.println("database is connected");
	       Statement st=con.createStatement();
	       String qe="SELECT * FROM emp";
	       ResultSet rs=st.executeQuery(qe);
	       while(rs.next()) {
	    	   System.out.println("Empno:" +rs.getInt(1));
	    	   System.out.println("Ename:" +rs.getString(2));
	    	   System.out.println("Salary:" +rs.getInt(3));
	    	   System.out.println("Address:" +rs.getString(4));
	    	   System.out.println("DateofJoining:" +rs.getDate(5));
	    	   System.out.println("MobileNo:" +rs.getString(6));
	    	   System.out.println("DeptName:" +rs.getString(7));
	       }
	       System.out.println("Record Fetched Successfully");
	       rs.close();
	       st.close();
	       con.close();
	}

}
