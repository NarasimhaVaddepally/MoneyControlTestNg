package seleniumutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	public Properties init_prop() {
		
		prop = new Properties();
		
		try {
			FileInputStream inputs = new FileInputStream("E:\\Projects\\CucumberPOMProject\\src\\test\\resources\\config\\config.properties");
			
			try {
				prop.load(inputs);
			} catch (IOException e) { 
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return prop;
		
		
		
		
	}

}
