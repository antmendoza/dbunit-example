package com.antmendoza.db.state;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExpectedState extends FileInputStream {

	public ExpectedState() throws FileNotFoundException {
		super("src/main/resources/release1/EXPECTED_STATE.xml");
	}
}
