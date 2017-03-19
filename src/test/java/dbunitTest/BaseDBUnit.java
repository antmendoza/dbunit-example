package dbunitTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;

public class BaseDBUnit extends DBTestCase{

	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:49161:xe","system","oracle");  
		
		
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from table1"); 
		

	}
	
	
}
