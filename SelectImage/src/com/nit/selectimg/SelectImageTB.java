package com.nit.selectimg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectImageTB{
    
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/test1";
	        String user = "root";
	        String password = "root";

	        try (Connection conn = DriverManager.getConnection(url, user, password)) {
	            String sql = "SELECT image FROM images WHERE name = ?";
	            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	                pstmt.setString(1, "cube");
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        try (InputStream inputStream = rs.getBinaryStream("image");
	                             FileOutputStream outputStream = new FileOutputStream("C:\\\\Users\\\\vsoft\\\\Downloads\\\\p1.gif")) {
	                            byte[] buffer = new byte[1024];
	                            int bytesRead;
	                            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                                outputStream.write(buffer, 0, bytesRead);
	                            }
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                        System.out.println("image inserted");
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	  }
}

