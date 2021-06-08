package javautilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;


import pages.testbase;

public class SeleniumUtils extends testbase {

	WebDriver ldriver = null;
	
	public static void mousehower(WebDriver ldriver,WebElement element) {
		
		try {
			Actions action = new Actions(ldriver);
			action.moveToElement(element).click().build().perform();
			extenttest.log(Status.PASS, "MouseOver to element and click is successfull");
		} catch (Exception e) {
			System.out.println(e);
			extenttest.log(Status.FAIL, "MouseOver to Element and click is failed" +e);
		}
		
	}
	
}
