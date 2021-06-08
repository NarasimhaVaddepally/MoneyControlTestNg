package seleniumutilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumUtils {
	
	
	public void capabilities(String  BrowserName) {
		DesiredCapabilities capabilites = DesiredCapabilities.chrome();
		
	}
	
	
	public void takescreenshots(WebDriver driver) {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File desfile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots");
		try {
			FileUtils.copyDirectory(src, desfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
