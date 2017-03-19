package com.antmendoza.dbunit.test;

import org.dbunit.Assertion;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import com.antmendoza.db.state.ExpectedState;
import com.antmendoza.dbunit.DBEnvironment;

import junit.framework.TestCase;

public class SimpleTest extends TestCase {

	@Test
	public void testInsertRowTABLE1() throws Exception {
		new DBEnvironment() {
			@Override
			public void execute(IDatabaseConnection connection) throws Exception {

				// EXECUTE
				connection.getConnection().createStatement().executeQuery(
						"INSERT INTO uTest.TABLE1 (COLUMN1, COLUMN2, COLUMN3) VALUES ('antonio4', 'mendoza', 'perez33')");

				// Assert
				QueryDataSet actualDataSet = new QueryDataSet(connection);
				actualDataSet.addTable("TABLE1", "SELECT * FROM TABLE1 ORDER BY 1");
				IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new ExpectedState());
				Assertion.assertEquals(expectedDataSet, actualDataSet);
			}
		}.run();

	}

}
