package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Retriveuc2 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stm=null;
		String query=("Select * from payroll_service.employee_payroll");
		String query1=("insert into payroll_service.employee_payroll(name,deductions,department,gender,basic_pay,taxable_pay,tax,net_pay,start) Values"
				+ "('harshini',1000.00,'finance','F',100000.00,500.00,150000.00,5000.00,'2021-12-12')");
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
			boolean ret=stm.execute(query);
			System.out.println(ret +"\ndatabase retrieved");
			
			int result=stm.executeUpdate(query1);
			System.out.println(result +"\ninserted");
			
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