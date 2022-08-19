package JDBC.bglabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import junit.framework.Assert;

public class Preparedtestuc4 {

	@Test
	public void Comparetest() throws ClassNotFoundException, SQLException {
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
		String query=("update payroll_service.employee_payroll set name='Vaishak',basic_pay=3000000.00 where id=22");
		int ret=stm.executeUpdate(query);
		System.out.println(ret +"\ndata updated");
		con.close();
		Assert.assertEquals(true, ret);
	}

}
