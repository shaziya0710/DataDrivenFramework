package org.training.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datagenerator {
	@DataProvider(name="Excel")
	public static Object[][] testdata() throws Exception {
		
		File credentials=new File("G:\\Tools\\SeleniumCertificationSoftware\\mytestdata.xlsx");
		
		FileInputStream fis=new FileInputStream(credentials);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		int rowcount=sheet1.getPhysicalNumberOfRows();
		Object[][] testvalue=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow row=sheet1.getRow(i);
			XSSFCell emailid=row.getCell(0);
			XSSFCell passvalue=row.getCell(1);
			
			testvalue[i][0]=emailid.getStringCellValue();
			testvalue[i][1]=passvalue.getStringCellValue();
		}
		return testvalue;
	}
}
