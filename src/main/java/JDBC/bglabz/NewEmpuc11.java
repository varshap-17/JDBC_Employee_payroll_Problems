package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

	public class NewEmpuc11 {
		public static void main(String[] args) {
			Connection con=null;
			Statement stm=null;
			String query=("insert into payroll_service.employee_payroll(name,deductions,department,company_name,company_id,gender,basic_pay,taxable_pay,tax,net_pay,start) Values"
					+ "('Shreya',1000.00,'Executive','Bridgelabz',1011,'F',500000.00,500.00,150000.00,5000.00,'2020-11-12')");
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
				con.setAutoCommit(false);
				int ret=stm.executeUpdate(query);
				System.out.println(ret +"\nemployee inserted");
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