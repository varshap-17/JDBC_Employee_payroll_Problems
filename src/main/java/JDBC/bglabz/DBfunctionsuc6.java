package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBfunctionsuc6 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stm=null;
		String query1=("Select SUM(basic_pay) from payroll_service.employee_payroll where gender='F' group by gender");
		String query2=("Select AVG(basic_pay) from payroll_service.employee_payroll where gender='F' group by gender");
		String query3=("Select MIN(basic_pay) from payroll_service.employee_payroll where gender='F' group by gender");
		String query4=("Select MAX(basic_pay) from payroll_service.employee_payroll where gender='F' group by gender");
		String query5=("Select COUNT(basic_pay) from payroll_service.employee_payroll where gender='M' group by gender");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=varsha-sql");
			System.out.println("Connection Established");
			stm=con.createStatement();
			System.out.println("Platform Created");
			stm.executeQuery(query1);
			System.out.println("sum of basic_pay Retrived");
			stm.executeQuery(query2);
			System.out.println("average of basic_pay Retrived");
			stm.executeQuery(query3);
			System.out.println("minimum of basic_pay Retrived");
			stm.executeQuery(query4);
			System.out.println("maximum of basic_pay Retrived");
			stm.executeQuery(query5);
			System.out.println("count of basic_pay Retrived");
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
