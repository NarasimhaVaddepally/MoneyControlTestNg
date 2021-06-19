package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

import javautilities.SeleniumUtils;
import javautilities.Xls_Reader;



public class Page1  {
	private WebDriver driver; 
	public Page1(WebDriver ldriver) {
		this.driver= ldriver;
	}

	
	@FindBy(how=How.XPATH , using="//form[@id='form_topsearch']//input[@id='search_str']")
	private WebElement Searchbox;
	@FindBy(how=How.XPATH , using="//div[@id='nsecp']")
	private WebElement ShareValue;
	
	
	public void searchstocks(String companyName) {

		try {
		
			System.out.println("=====Page1======");			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(Searchbox));
			Searchbox.sendKeys(companyName);	
			WebElement element1 = driver.findElement(By.xpath("//form[@id='form_topsearch']//div[@id='autosuggestlist']//a[contains(text(),'"+companyName+"')]"));		
			
			assertEquals(element1.isEnabled(), true);
			SeleniumUtils.mousehower(driver, element1);
			driver.manage().timeouts().implicitlyWait('2', TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains(companyName));			
			String stockvalue = ShareValue.getAttribute("rel");
			System.out.println(stockvalue);

						  
			Xls_Reader reader = new Xls_Reader("E://Projects//com.moneycontrol//src//test//resources//TestData.xlsx");
			int rownum = reader.getCellRowNum("Company", "Company",companyName );
			reader.setCellData("Company", "Value", rownum, stockvalue);
		} catch (Exception e) {
			System.out.println(e);
		}







		



	}
}

