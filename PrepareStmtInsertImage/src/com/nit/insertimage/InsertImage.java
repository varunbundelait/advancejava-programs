package com.nit.insertimage;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImage {
    private static final String URL="jdbc:mysql://localhost:3306/test1";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    
    private static Connection con;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
       con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
       System.out.println("connection is opened");
       InsertImg();
       con.close();
       System.out.println("connection is closed");
	}
	private static void InsertImg() throws Exception{
		// TODO Auto-generated method stub
		String q="INSERT INTO IMAGES VALUES(?,?)";
		PreparedStatement ps=con.prepareStatement(q);
		File file= new File("C:\\Users\\vsoft\\Downloads\\p1.gif");
		FileInputStream fis= new FileInputStream(file);
		
		ps.setString(1, "cube");
		ps.setBinaryStream(2, fis);
		
		int count=ps.executeUpdate();
		System.out.println(count+ " : row inserted");
		ps.close();
	}

}
