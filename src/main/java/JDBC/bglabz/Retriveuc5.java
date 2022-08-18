package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Retriveuc5 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stm=null;
		String query=("Select * from payroll_service.employee_payroll where start BETWEEN CAST('2018-01-01' AS DATE) AND DATE(NOW())");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=varsha-sql");
			System.out.println("Connection Established");
			stm=con.createStatement();
			System.out.println("Platform Created");
			stm.executeQuery(query);
			System.out.println("Date Retrived");
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
