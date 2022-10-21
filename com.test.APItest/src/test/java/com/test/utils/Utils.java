package com.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.tests.constants.Sourcepath;

public class Utils {
	Properties prop;
	public Utils() throws IOException {
		InputStream fs = new FileInputStream(Sourcepath.CONFIG_PROPERTIES_PATH);
		prop = new Properties();
		prop.load(fs);
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
}
