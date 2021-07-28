package hotel.managment.system;

import java.sql.*;

public class Conn {
	Connection con;
	//Statement stmt;

	public Conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			//stmt=con.createStatement();
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
