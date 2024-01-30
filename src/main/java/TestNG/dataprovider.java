package TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelUtils;
import genericUtility.IpathConstants;

public class dataprovider 
{
	@Test(dataProvider = "readMultipleSetOfData")
	public void getData(String src , String dest) throws Throwable
	{
		ExcelUtils eLib = new ExcelUtils();
		eLib.readMultipleSetOfData("DataProvider");
		System.out.println(src+"----->"+dest);

	}
//	@DataProvider(name = "abc")
//	public Object[][] readData() throws Throwable
//	{
//		FileInputStream fi = new FileInputStream(IpathConstants.Excelpath);
//		 Workbook wb = WorkbookFactory.create(fi);
//		 Sheet sh = wb.getSheet("DataProvider");
//		 int lastrow = sh.getLastRowNum()+1;
//		 int lastcell = sh.getRow(0).getLastCellNum();
//		 
//		Object[][] obj = new Object[lastrow][lastcell];
//		for (int i = 0; i < lastrow; i++)               //row
//		{          
//			for (int j = 0; j <lastcell; j++)            //cell
//			{      
//			
//				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
//			}
//			
//		}
//		return obj;
//		
//	}

}
