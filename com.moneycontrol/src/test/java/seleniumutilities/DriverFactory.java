package seleniumutilities;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(String browser) {
		System.out.println("Browser valuevis "+browser);
		
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().driverVersion("91.0.4472.101").setup();
			
			ChromeOptions options = new ChromeOptions();
			
			options.setBinary("C:\\Users\\Narasimha Vaddepally\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			
			options.addArguments("start-maximized");
			options.addArguments("disable-extensions");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			DesiredCapabilities capabilities =new  DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);			
			options.merge(capabilities);			
			
			System.setProperty("webdriver.chrome.driver", "E:\\Projects\\com.moneycontrol\\src\\test\\java\\chromedriver.exe");
			tlDriver.set(new ChromeDriver(options));
			//driver = webdriver.Chrome(chrome_options = options, executable_path='\\E:\\Projects\\com.moneycontrol\\src\\test\\javachromedriver.exe');
			
			
			//tlDriver.set(new ChromeDriver(options));
		}
		else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("Safari")) {
		
			tlDriver.set(new SafariDriver());
		}
		else {
			System.out.println("Please pass correct value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
