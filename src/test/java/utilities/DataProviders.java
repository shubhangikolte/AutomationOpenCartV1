package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".//testData//OpenCart_LoginData.xlsx";//taking excel from testData folder
		
		ExcelUtility xlUtil = new ExcelUtility(path);//creating an object  for Excel utility
		
		int totalrows=xlUtil.getRowCount("Sheet1");
		int totalcol=xlUtil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcol];// created a two dimension array which can store the cell data
		
		//read the data from excel storing in two dimensional array
		for(int i=1;i<=totalrows;i++)// 1
		{
			for(int j=0;j<totalcol;j++)//0
			{
				logindata[i-1][j]= xlUtil.getCellData("Sheet1", i, j);//1,0
			}
		}
		
		return logindata;
	}

}
