package com.learnAutomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	Properties pro;
	
	public ExcelDataProvider()
	{
		File src=new File("./TestData/data.xlsx");
		pro=new Properties();
		try {
			FileInputStream fis=new FileInputStream(src);
			 wb=new XSSFWorkbook(fis);
		} catch (Exception e)
		    {
			System.out.println("Unable to read Excel File"+e.getMessage());
			}			
	}
	
	public String getStringData(String sheetname, int row, int col)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericValue(String sheetname, int row, int col)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}
	
	
	

}
