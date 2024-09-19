package com.nit.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallableProcedureTB {
	private static final String URL = "jdbc:mysql://localhost:3306/test1";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection conn;
	
	public static void main(String[] args) {
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection is opened");
			
			findDeptDetails(conn);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		finally {
			try {
				if( conn!= null ) {
					conn.close();
					System.out.println("connection is closed");
				}
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
		}

	}

	private static void findDeptDetails(Connection conn) {
		CallableStatement cs = null;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("enter deptno : ");
			int deptno = scan.nextInt();
			
			String str = "{ call dept_procedure(?, ?, ?) }";
			
			//The call statement is compiled and the compiled
			//code will be stored into the cs object.
			cs = conn.prepareCall(str);
			
			//set the in parameter
			cs.setInt(1, deptno);
			
			//register out parameter
			cs.registerOutParameter(2, Types.VARCHAR);
			
			//register out parameter
			cs.registerOutParameter(3, Types.VARCHAR);
			
			//execute the CallableStatement
			cs.execute();
			
			//get the value from out parameter
			String deptName = cs.getString(2);
			String location = cs.getString(3);
			System.out.println("deptname  :  " + deptName);
			System.out.println("location : " + location);
			scan.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		finally {
			try {
				if ( cs != null ) {
					cs.close();
				}
			} catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
	}

}
