package com.orangehrm.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		
		String path=".\\testData\\OrangeHRM_LoginData.xlsx";
		ExcelUtilities xlutils=new ExcelUtilities(path);  //Create object of ExcelUtilities class
		
		int totalrow=xlutils.getRowCount("Sheet1");
		int totalCell=xlutils.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrow][totalCell]; //Created two dimension Array which can store the data username and password
		
		for(int i=1;i<=totalrow;i++) { //1   
			for(int j=0;j<totalCell;j++) { //0
				logindata[i-1][j]=xlutils.getCellData("Sheet1", i, j); // read the data from excel and storing in two dimensional array 
			}
		}
		return logindata;
		
		
	}

}
