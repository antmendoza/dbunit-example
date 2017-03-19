package com.antmendoza.db.state;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InitialState extends FileInputStream {

	public InitialState() throws FileNotFoundException {
		super("src/main/resources/release1/INITIAL_STATE.xml");
	}
}
