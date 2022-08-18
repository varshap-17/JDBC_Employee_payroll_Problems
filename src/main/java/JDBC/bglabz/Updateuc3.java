package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Updateuc3 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stm1=null;                                     
		String query=("update payroll_service.employee_payroll set name='Vimal',basic_pay=3000000.00 where id=19");
		try {
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver registered");
			//step 2
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=varsha-sql");
			System.out.println("Connection established");
			//step 3
			stm1=con.createStatement();
			System.out.println("Platform created");
			stm1.execute(query);
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
