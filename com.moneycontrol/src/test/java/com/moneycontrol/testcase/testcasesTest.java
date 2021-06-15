package com.moneycontrol.testcase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import javautilities.datarelatedmethods;
import pages.Page1;
import pages.testbase;

public class testcasesTest extends testbase {

	@DataProvider
	public Iterator<Object[]> getData() {
		XSSFWorkbook workbook = datarelatedmethods.readexcel(System.getProperty("user.dir")+"//src//test//resources//TestData.xlsx");
		XSSFSheet sheet = workbook.getSheet("Company");
		int count = sheet.getLastRowNum();
		System.out.println("Numnber of records in test data is "+count); 
		
		ArrayList<Object[]>   abc = new ArrayList<Object[]>();	
		for(int i=1;i<count+1;i++) {
			String companyName = sheet.getRow(i).getCell(0).getStringCellValue();			
			Object ab[] = {companyName};			
			abc.add(ab);
		}
		System.out.println(abc);
		return abc.iterator();
	}
	
	@Test(dataProvider = "getData")
	public void getstockdetails(String companyName) {
		try {
			extenttest = extent.createTest("getstockdetails"+companyName);	
			driver.manage().timeouts().implicitlyWait('2', TimeUnit.SECONDS);	
			Page1 Page1 = PageFactory.initElements(driver, Page1.class);
			Page1.searchstocks(companyName);
		} catch (Exception e) {
				
			extenttest.log(Status.PASS, "Error in Test method"+e);
		}
	}
	

}
