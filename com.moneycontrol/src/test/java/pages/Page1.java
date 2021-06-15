package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import javautilities.SeleniumUtils;
import javautilities.Xls_Reader;

public class Page1  {
	private WebDriver driver; 
	public Page1(WebDriver ldriver) {
		this.driver= ldriver;
	}

	public void searchstocks(String companyName) {

		try {
//			
			
//			
			//driver.findElement(By.xpath("//a[contains(@href='moneycontrol.com')]")).click();
//			
			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.DAYS.SECONDS);
			System.out.println(driver.getTitle());
			//Assert.assertEquals(driver.getTitle(), "Business News | Stock and Share Market News | Financial News");			
			driver.findElement(By.xpath("//form[@id='form_topsearch']//input[@id='search_str']")).sendKeys(companyName);	
//			extenttest.log(Status.PASS, "Company Name is entered");
			WebElement element1 = driver.findElement(By.xpath("//form[@id='form_topsearch']//div[@id='autosuggestlist']//a[contains(text(),'"+companyName+"')]"));		
			
			assertEquals(element1.isEnabled(), true);
			SeleniumUtils.mousehower(driver, element1);
			if(driver.getTitle().contains("Vedanta")) {
//				extenttest.log(Status.PASS, companyName+" stock page is displayed");
			}
			else {
//				extenttest.log(Status.FAIL, companyName+" stock page is not displayed");
				
			}
				
				
			
			driver.manage().timeouts().implicitlyWait('2', TimeUnit.SECONDS);	
			WebElement element = driver.findElement(By.xpath("//div[@id='nsecp']"));
			String stockvalue = element.getAttribute("rel");
			System.out.println(stockvalue);
//			extenttest.log(Status.PASS, companyName+" stock value is "+ stockvalue);
			driver.manage().timeouts().implicitlyWait('2', TimeUnit.SECONDS);					  
			Xls_Reader reader = new Xls_Reader("E://Projects//com.moneycontrol//src//test//resources//TestData.xlsx");
			int rownum = reader.getCellRowNum("Company", "Company",companyName );
			reader.setCellData("Company", "Value", rownum, stockvalue);
		} catch (Exception e) {
//			extenttest.log(Status.FAIL, e);
		}







		



	}
}

