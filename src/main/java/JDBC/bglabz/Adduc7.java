package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Adduc7 {
	public static void main(String[] args) {
		Connection con =null;
		Statement stm=null;
		String query=("insert into payroll_service.employee_payroll(name,deductions,department,gender,basic_pay,taxable_pay,tax,net_pay,start) Values"
				+ "('mark',1000.00,'stocks','M',500000.00,500.00,15000.00,5000.00,'2022-08-19')");
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
			int ret=stm.executeUpdate(query);
			System.out.println(ret +"\ndata inserted");
			
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
