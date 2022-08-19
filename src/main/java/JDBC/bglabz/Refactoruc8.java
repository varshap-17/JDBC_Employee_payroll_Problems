package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Refactoruc8 {
		public static void main(String[] args) {
			Connection con=null;
			Statement stm=null;
			String query=("delete from payroll_service.employee_payroll where name='Ayesha'");
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
			stm.executeQuery(query);
			System.out.println("executed");
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