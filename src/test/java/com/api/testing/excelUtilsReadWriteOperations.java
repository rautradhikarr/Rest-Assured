package com.api.testing;

import java.io.FileInputStream;

import org.testng.annotations.Test;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;

public class excelUtilsReadWriteOperations {
	
	String xfile = "C:\\Users\\Public\\testData.xlsx";
	String xcelSheet = "Sheet1";
	@Test
	public void getRowsCount() throws IOException {
		
		
		FileInputStream fi = new FileInputStream(xfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);		
		XSSFSheet ws = wb.getSheet(xcelSheet);
		int rowCount = ws.getLastRowNum();	
		int rowCountwithHeader =ws.getPhysicalNumberOfRows();
		System.out.println("# of rows : "+rowCount);
		System.out.println("# of rows with heder : "+rowCountwithHeader);
		wb.close();
		fi.close();
	}
	
	@Test
	public void getColumnCount() throws IOException {
		
		FileInputStream fi = new FileInputStream(xfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xcelSheet);
		XSSFRow row= ws.getRow(1);
		int columCount = row.getLastCellNum();
		System.out.println("# of coulmns : "+ columCount);
		wb.close();
		fi.close();
	}
	
	@Test
	
	public void getCellData() throws IOException {
		
		FileInputStream fi = new FileInputStream(xfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xcelSheet);
		XSSFRow row= ws.getRow(2);
		XSSFCell cell = row.getCell(2);
		String cellData = cell.getStringCellValue();
		System.out.println("Cell Data : "+cellData);
		wb.close();
		fi.close();
		
	}
	
	@Test
	
	public void setCellData() throws IOException {
		
		FileInputStream fi = new FileInputStream(xfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xcelSheet);
		XSSFRow row = ws.getRow(2);
		XSSFCell cell = row.createCell(4);
		cell.setCellValue("Automation");
		wb.close();
		fi.close();
	}
	
	
}
