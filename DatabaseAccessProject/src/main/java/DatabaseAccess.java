import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseAccess extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		   

		      // Set response content type
		      response.setContentType("text/html");
		      PrintWriter out = response.getWriter();
		      String title = "Employee Data";
		      
		      String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		      
		      out.println(docType +
		         "<html>\n" +
		         "<head><title>" + title + "</title></head>\n" +
		         "<body bgcolor = \"#f0f0f0\">\n" +
		         "<h1 align = \"center\">" + title + "</h1>\n");
		      try {
		         // Register JDBC driver
		         Class.forName("com.mysql.cj.jdbc.Driver");

		         // Open a connection
		         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");

		         // Execute SQL query
		         Statement st = con.createStatement();
		         String sql;
		         sql = "SELECT * FROM emp";
		         ResultSet rs = st.executeQuery(sql);

		         // Extract data from result set
		         while(rs.next()){
		            //Retrieve by column name
		            int empno  = rs.getInt("empno");
		            String ename = rs.getString("ename");
		            int salary = rs.getInt("salary");
		            String address = rs.getString("address");
                    Date dateofjoining =rs.getDate("dateofjoining");
                    String mobileno= rs.getString("mobileno");
                    String deptname = rs.getString("deptname");
		            //Display values
		            out.println("empno: " + empno + "<br>");
		            out.println(", ename: " + ename + "<br>");
		            out.println(", salary: " + salary + "<br>");
		            out.println(", address: " + address + "<br>");
		            out.println(", dateofjoining: " + dateofjoining  + "<br>");
		            out.println(", mobileno: " + mobileno + "<br>");
		            out.println(", deptname: " + deptname + "<br>");
		         }
		         out.println("</body></html>");

		         // Clean-up environment
		         rs.close();
		         st.close();
		         con.close();
		      } catch(SQLException se) {
		         //Handle errors for JDBC
		         se.printStackTrace();
		      } catch(Exception e) {
		         //Handle errors for Class.forName
		         e.printStackTrace();
		      } //end try
	}
}
