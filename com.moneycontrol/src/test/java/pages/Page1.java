package pages;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import javautilities.SeleniumUtils;
import javautilities.Xls_Reader;





public class Page1 extends testbase {
	WebDriver driver;

	public Page1(WebDriver ldriver) {
		this.driver= ldriver;
	}

	public void searchstocks(String companyName) {

		try {
			//extenttest.log(LogStatus.PASS, "Browser is Launched and navigated to URl");
			driver.findElement(By.xpath("//form[@id='form_topsearch']//input[@id='search_str']")).sendKeys(companyName);	
			extenttest.log(Status.PASS, "Company Name is entered");
			WebElement element1 = driver.findElement(By.xpath("//form[@id='form_topsearch']//div[@id='autosuggestlist']//a[contains(text(),'"+companyName+"')]"));			
			SeleniumUtils.mousehower(driver, element1);
			driver.manage().timeouts().implicitlyWait('2', TimeUnit.SECONDS);	
			WebElement element = driver.findElement(By.xpath("//div[@id='nsecp']"));
			String stockvalue = element.getAttribute("rel");
			System.out.println(stockvalue);
			extenttest.log(Status.PASS, companyName+" stock value is "+ stockvalue);
			driver.manage().timeouts().implicitlyWait('2', TimeUnit.SECONDS);					  
			Xls_Reader reader = new Xls_Reader("E://Projects//com.moneycontrol//src//test//resources//TestData.xlsx");
			int rownum = reader.getCellRowNum("Company", "Company",companyName );
			reader.setCellData("Company", "Value", rownum, stockvalue);
		} catch (Exception e) {
			extenttest.log(Status.FAIL, e);
		}







		



	}
}

