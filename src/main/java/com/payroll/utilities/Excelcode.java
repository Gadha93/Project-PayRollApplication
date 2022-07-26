package com.payroll.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelcode {

	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	
	  public static String readStringData(int i,int j) throws IOException
	  { 
	  f = new FileInputStream("/home/sangeeth/Downloads/excel-java.xlsx"); 
	  w = new XSSFWorkbook(f); 
	  s = w.getSheet("payrollsheet"); 
	  Row r = s.getRow(i); 
	  Cell c =r.getCell(j); 
	  return c.getStringCellValue(); 
	  }
	 
	
	 public static String readIntegerData(int i,int j) throws IOException
	 {
		 f = new FileInputStream("/home/sangeeth/Downloads/excel-java.xlsx");
		 w = new XSSFWorkbook(f);
		 s = w.getSheet("payrollsheet");
		// for (int row=0; row<=3; row++) {
			 Row r = s.getRow(i);
			 Cell c = r.getCell(j);
			int a = (int) c.getNumericCellValue();
			return String.valueOf(a);
			}
}
