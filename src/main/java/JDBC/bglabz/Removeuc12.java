package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Removeuc12 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stm=null;
		String query=("Alter table payroll_service.employee_payroll ADD is_active BIT(1) not null after name");
		try {
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver registered");
			//step 2
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=varsha-sql");
			System.out.println("Connection established");
			//step 3
			stm=con.createStatement();		
			System.out.println("Platform created");
			con.setAutoCommit(true);
			int ret=stm.executeUpdate(query);
			System.out.println(ret +"\naltered");
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.rollback();
					con.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
