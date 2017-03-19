package com.antmendoza.dbunit;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import com.antmendoza.db.state.InitialState;

public abstract class DBEnvironment {

	public abstract void execute(IDatabaseConnection connection) throws Exception;

	public void run() throws Exception {
		IDatabaseConnection connection = initConnection();
		try {
			setUpDB(connection);
			execute(connection);
		} catch (Exception e) {
			throw e;
		} finally {
			closeConnection(connection);
		}
	}

	private void closeConnection(IDatabaseConnection connection) throws Exception {
		connection.close();

	}

	private void setUpDB(IDatabaseConnection connection) throws Exception {
		// initialize your dataset here
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(new InitialState());
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
	}

	private IDatabaseConnection initConnection() throws Exception {
		// initialize your database connection here
		JdbcDatabaseTester jdbcDatabaseTester = new JdbcDatabaseTester("oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@localhost:49161:xe", "uTest", "uTest");
		jdbcDatabaseTester.setSchema("uTest");
		IDatabaseConnection connection = jdbcDatabaseTester.getConnection();

		return connection;
	}

}
