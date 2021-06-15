package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import seleniumutilities.DriverFactory;




public class testbase {
	
	protected static WebDriver driver; 
	protected static ExtentReports extent;
	public static ExtentTest extenttest;
	private static seleniumutilities.DriverFactory driverFactory;
	private static seleniumutilities.ConfigReader configReader;
	
	static Properties prop;
	
	@BeforeSuite
	public void beforesuite() {
		
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		
	}
	
	 	 	
	
	@BeforeMethod
	public static void BrowserLaunch() {
		
		try {
			
		configReader = new seleniumutilities.ConfigReader();
			prop = configReader.init_prop();
			String browsername = prop.getProperty("browser");
//			driverFactory = new DriverFactory();
//			driver = driverFactory.init_driver(browsername);	
			
			
			System.setProperty("webdriver.chrome.driver", "E:\\Projects\\com.moneycontrol\\src\\test\\java\\chromedriver.exe");			  
			  driver = new ChromeDriver();
			  driver.manage().deleteAllCookies();			  
			  driver.manage().window().maximize();
			  driver.navigate().to("http://moneycontrol.com/");
			  System.out.println("Browser is Launched and navigated to URl");
			  //ExtentTestManager.getTest().generateLog(Status.PASS, "Browser is launched and navigated to Money Control Website");
		} catch (Exception e) {
			System.out.println("Error message is"+e);
		}
		  
		 
		
	}
	
	
	@AfterMethod
	public static void CloseBrowser() {
		try {
			driver.quit();
			extent.flush();
			System.out.println("closing the Browser");
		} catch (Exception e) {
			System.out.println("Error message is Closing Browser "+e);
		}
	}
	
	
	


	
	
	


	

}
