package com.api.testing;

import java.io.FileInputStream;

import org.testng.annotations.Test;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;

public class XLUtils {
	
//	String xfile = "C:\\Users\\Public\\testData.xlsx";
//	String xcelSheet = "Sheet1";
	
	public static int getRowsCount(String xfile, String xcelSheet ) throws IOException {
		
		
		FileInputStream fi = new FileInputStream(xfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);		
		XSSFSheet ws = wb.getSheet(xcelSheet);
		int rowCount = ws.getLastRowNum();	
		//int rowCountwithHeader =ws.getPhysicalNumberOfRows();
		wb.close();
		fi.close();
		return rowCount;

	}
	
	public static int getColumnCount(String xfile, String xcelSheet, String rowNum ) throws IOException {
		
		FileInputStream fi = new FileInputStream(xfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xcelSheet);
		XSSFRow row= ws.getRow(1);
		int columCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return columCount;
	}
	
	
	
	public static String getCellData(String xfile, String xcelSheet, int rowNum, int colNum) throws IOException {
		
		FileInputStream fi = new FileInputStream(xfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xcelSheet);
		XSSFRow row= ws.getRow(2);
		XSSFCell cell = row.getCell(2);
		String cellData = cell.getStringCellValue();
		wb.close();
		fi.close();
		return cellData;
		
	}
	
	
	
//	public static void setCellData(String xfile, String xcelSheet, String rowCount) throws IOException {
//		
//		FileInputStream fi = new FileInputStream(xfile);
//		XSSFWorkbook wb = new XSSFWorkbook(fi);
//		XSSFSheet ws = wb.getSheet(xcelSheet);
//		XSSFRow row = ws.getRow(2);
//		XSSFCell cell = row.createCell(4);
//		cell.setCellValue("Automation");
//		wb.close();
//		fi.close();
//		//return setCellValue();
//	}
	
	
}
