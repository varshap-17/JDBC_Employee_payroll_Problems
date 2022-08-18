package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Refactoruc4 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement stm=null;
		String query=("Select name from payroll_service.employee_payroll");
		try {
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver registered");
			//step 2
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=varsha-sql");
			System.out.println("Connection established");
			//step 3
			stm=con.prepareStatement(query);
			System.out.println("Platform created");
			stm.executeQuery();
			System.out.println("statement executed");
			// Result set use
			DatabaseMetaData dbmd=con.getMetaData();
			boolean isSupportResultSetType=dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			if(isSupportResultSetType==true) {
				stm=con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			}
			stm.executeQuery();
			System.out.println("resultset is reused");
		}catch(Exception e) {
			e.getStackTrace();
		}finally{
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
