package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;
	public ConfigReader() {
		try {
			String path=System.getProperty("user.dir")+"/config.properties";
			File file=new File(path);
			FileInputStream fis = new FileInputStream(path);
			prop =new Properties();
			prop.load(fis);
		} catch ( IOException e) {
			e.printStackTrace();
			 System.err.println("Error loading properties file: " + e.getMessage());
		}
	}
	public Properties getproperties() {
		return prop;
	}
}
