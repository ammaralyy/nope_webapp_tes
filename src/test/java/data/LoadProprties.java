package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProprties {
	
	public static Properties userData = loadProprties(System.getProperty("user.dir") + "\\src\\main\\java\\proprties\\userDataProprties");
	
	public static Properties loadProprties(String path) {
		Properties properties = new Properties();
		
		try {
			FileInputStream stream = new FileInputStream(path);
			properties.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("error occurred : " + e.getMessage());
		}catch (IOException e) {
			System.out.println("error occurred : " + e.getMessage());
		}
	
		return properties;
	}

}
