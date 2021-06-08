package javautilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datarelatedmethods {
	
	static XSSFSheet sheet = null;
	static XSSFWorkbook workbook;
	
	public static XSSFWorkbook readexcel(String path) {
		
		 
		try {
			FileInputStream	file = new FileInputStream(path);
			workbook = new XSSFWorkbook(file);
			return workbook;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}
	
	public static XSSFSheet getexceldata(XSSFWorkbook workbook, String path, String sheetname) {
		try {
			
			sheet = workbook.getSheet(sheetname);
			return sheet;
			
		}  catch (Exception e) {
			System.out.println("Exception in getexceldata "+e);
			return null;
		}
		
	}
	
	
	
	public static void  writetoexcel(String path, String sheetname, String value) {
		
		try {
			workbook = readexcel(path);
			sheet = workbook.getSheet(sheetname);
			sheet.getRow(1).createCell(1).setCellValue(value);
			
			
			
			
		}  catch (Exception e) {
			System.out.println("Exception in getexceldata "+e);
			
		}
	}
	
	public static  void writefile(String path, XSSFWorkbook workbook) {
		FileOutputStream fis;
		try {
			fis = new FileOutputStream(path);		
			workbook.write(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
