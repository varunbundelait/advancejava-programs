package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataResultSet {

	
	private static String URL="jdbc:mysql://localhost:3306/test1";
	private static String USER="root";
	private static String PASS="root";
	private static Connection conn;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			conn=DriverManager.getConnection(URL, USER, PASS);
			System.out.println("database is connected");
			findMetaData(conn);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
					System.out.println("database is disconnected");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

	}
	private static void findMetaData(Connection conn) {
		// TODO Auto-generated method stub
		try(Statement st=conn.createStatement()){
			String sql="SELECT * FROM emp1";
	       ResultSet rs=st.executeQuery(sql);
	       ResultSetMetaData rm=rs.getMetaData();
	       int columnCount=rm.getColumnCount();
	       for(int i=1; i<=columnCount; i++) {
	    	   System.out.println("column"+i+" : "+rm.getColumnName(i)
	    	   +", type"+rm.getColumnTypeName(i));
	       }
	       rs.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
		
	}

}
