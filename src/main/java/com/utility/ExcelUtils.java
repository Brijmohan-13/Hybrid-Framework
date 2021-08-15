package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtils {
	
	//read() ,write(),getAllData(), getAllDataAsDP()
	
	FileInputStream fis;
	Workbook wb;
	
	
	public void getAllData(String filePath,String sheetName)
	{
		DataFormatter df=new DataFormatter();
		
		try {
				fis=new FileInputStream(filePath);
				wb=WorkbookFactory.create(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		Sheet sh=wb.getSheet(sheetName);
		int rows=sh.getLastRowNum();
		
		for (int i=0; i<=rows; i++)
		{
			int columns=sh.getRow(i).getLastCellNum();
			for(int j=0; j<=columns; j++)
			{
				Cell cell=sh.getRow(i).getCell(j);
				String data=df.formatCellValue(cell);
				System.out.print(data);								//one row on one line
			}
			System.out.println();									//next line
		}
		
	}

	public String[][] getAllDataAsDP(String filePath,String sheetName,int noOfPara)
	{
		DataFormatter df=new DataFormatter();
		
		try {
				fis=new FileInputStream(filePath);
				wb=WorkbookFactory.create(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		Sheet sh=wb.getSheet(sheetName);
		int rows=sh.getLastRowNum();
		
		String [][] dataArray=new String [rows+1][noOfPara+1];		

		for (int i=0; i<=rows; i++)
		{
			for(int j=0; j<=noOfPara; j++)
			{
				Cell cell=sh.getRow(i).getCell(j);
				String data=df.formatCellValue(cell);
				dataArray[i][j]=data;
			}
		}
		return dataArray;
	}
	
	public String readCell(String filePath, String sheetName, int rowNumb, int cellNum){
		DataFormatter df=new DataFormatter();
		
		try {
				fis=new FileInputStream(filePath);
				wb=WorkbookFactory.create(fis);
			}   catch (Exception e) {
				e.printStackTrace();
			}
		Sheet sh=wb.getSheet(sheetName);
		Cell cell=sh.getRow(rowNumb).getCell(cellNum);
		String data=df.formatCellValue(cell);
		return data;		
	}
	
	@Test
	public void unitTesting()
	{
		getAllData("logindata.xlsx", "page");									//first method unit testing
		
		String [][] arr=getAllDataAsDP("logindata.xlsx", "page",1);			   //second method unit testing
		for(int i=0; i<arr.length; i++)
		{
			String [] ar=arr[i];
			for(int j=0; j<ar.length; j++)
			{
				String data=ar[j];
				System.out.println(data);
			}
		}
		
		System.out.println(readCell("logindata.xlsx", "page", 2, 1));		//third method unit testing
	}

}







