package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import reportingUtils.ExtentTestManager;



public class testbase {
	
	protected static WebDriver driver; 
	protected static ExtentReports extent;
	public static ExtentTest extenttest;
	
	@BeforeSuite
	public void beforesuite() {
		
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		
	}
	
	 	 	
	
	@BeforeMethod
	public static void BrowserLaunch() {
		
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\javautilities\\chromedriver.exe");			  
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
		driver.close();
		extent.flush();
		System.out.println("closing the Browser");
	}
	
	
	


	
	
	


	

}
