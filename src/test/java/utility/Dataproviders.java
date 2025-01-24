package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders  {

	@DataProvider(name="LoginData")
	public String[][] getData () throws IOException
	{
	String path="C:\\Eclipse\\OpenCart\\target\\TestData\\Book1.xlsx";
	ExcelUtility xlUtility=new ExcelUtility(path,"Sheet1");
	
	int totalrows=xlUtility.getRowCount();
	int totalcols=xlUtility.getCellCount(1);
	
	String LoginData[][]=new String[totalrows][totalcols];
	for(int i=1;i<=totalrows;i++) {
		for(int j=0;j<totalcols;j++) {
			LoginData[i-1][j]=xlUtility.getcellData(i, j);
		}
	}
	return LoginData;
	}
	
}
