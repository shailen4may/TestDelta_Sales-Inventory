package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
	FileInputStream fis;
	Workbook wb;
	/**
	 * @author Shailendra
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheetname,int row ,int cell) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(IpathConstants.Excelpath);
		wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	/**
	 * this is used to get the last row till where the data is entered in that sheet.
	 * @author Shailendra
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(IpathConstants.Excelpath);
		wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	/**
	 * this method is used to read multiple data from excel
	 * @param Sheetname
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String, String> hashMapData(String Sheetname,int cell) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(IpathConstants.Excelpath);
		wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int lastRow = sh.getLastRowNum();
	
		HashMap<String, String> map = new HashMap<String, String>();      //empty
		for(int i=0;i<=lastRow;i++)
		{
			String key = sh.getRow(i).getCell(cell).getStringCellValue();
			String value = sh.getRow(i).getCell(cell+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
		
		public Object[][] readMultipleSetOfData(String sheetName) throws Throwable
		{
			FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
			wb=WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int lastrow = sh.getLastRowNum()+1;
			int lastcell = sh.getRow(0).getLastCellNum();
			Object[][] obj = new Object[lastrow][lastcell];
			for(int i=0;i<lastrow;i++)
			{
				for(int j=0;j<lastcell;j++)
				{
					obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return obj;
		}
}	