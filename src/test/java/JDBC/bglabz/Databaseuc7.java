package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import junit.framework.Assert;

public class Databaseuc7 {

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		Connection con =null;
		Statement stm=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver registered");
		//step 2
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=varsha-sql");
		System.out.println("Connection established");
		//step 3
		stm=con.createStatement();		
		System.out.println("Platform created");
		
		String query=("insert into payroll_service.employee_payroll(name,deductions,department,gender,basic_pay,taxable_pay,tax,net_pay,start) Values"
				+ "('mark',1000.00,'stocks','M',500000.00,500.00,15000.00,5000.00,'2022-08-19')");
		int ret=stm.executeUpdate(query);
		System.out.println(ret +"\ndata inserted");
		con.close();
		Assert.assertEquals(true, ret);
	}

}
