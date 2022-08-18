package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Preparedstmuc4 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement stm1=null;                                     
		String query=("update payroll_service.employee_payroll set name='Vaishak',basic_pay=3000000.00 where id=22");
		try {
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver registered");
			//step 2
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=varsha-sql");
			System.out.println("Connection established");
			//step 3
			stm1=con.prepareStatement(query);
			System.out.println("Platform created");
			
			stm1.executeUpdate();
			System.out.println("data inserted");
	}catch(Exception e) {
		e.getStackTrace();
	}finally {
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
     }
	}
}
