package ch15.exam05;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		String path = PropertiesExample.class.getResource("database.properties").getPath();

		prop.load(new FileReader(path));

		String driver = prop.getProperty("driver");
		System.out.println(driver);

		String manager = prop.getProperty("manager");
		System.out.println(manager);

	}

}
