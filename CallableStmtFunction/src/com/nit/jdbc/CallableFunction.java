package com.nit.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallableFunction {
	private static final String URL = "jdbc:mysql://localhost:3306/test1";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection conn;
	
	public static void main(String[] args) {
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection is opened");
			
			calculateBonus(conn);
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

	private static void calculateBonus(Connection conn) {
		CallableStatement cs = null;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("enter empno : ");
			int empno = scan.nextInt();
			
			String str = "{ ? = call bonus_function(?) }";
			
			//The call statement is compiled and the compiled
			//code will be stored into the cs object.
			cs = conn.prepareCall(str);
			
			//register out parameter
			cs.registerOutParameter(1, Types.DOUBLE);
			//set the in parameter
			cs.setInt(2, empno);
			//execute the CallableStatement
			cs.execute();
			
			//get the value from out parameter
			double bonus = cs.getDouble(1);
			System.out.println("Bonus : " + bonus);
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
