import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeInsertTB{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	     Class.forName("com.mysql.cj.jdbc.Driver");
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
	       System.out.println("database is connected");
	       Statement st=con.createStatement();
	       String qr="INSERT INTO emp VALUES(102,'ravi',30000,'gonda', '2023-12-05', 9738499320, 'manager')";
	       st.executeUpdate(qr);
	       System.out.println("record is added");
	       st.close();
	       con.close();
	}

}
