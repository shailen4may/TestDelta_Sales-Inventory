package SupplierModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genericUtility.ExcelUtils;
import genericUtility.FileUtils;
import genericUtility.JavaUtils;
import genericUtility.WebDriverUtiliy;

public class SupplierModule 
{
	@Test
	public void SupplierModuleTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		WebDriverUtiliy wLib = new WebDriverUtiliy();
		
		int random=jLib.getRandom(100);
//		Random ran = new Random();
//		int random = ran.nextInt(100);
		//get common data from property file
		
		String AdminUSERNAME = fLib.readData("username1");
		String URL = fLib.readData("url");
		String AdminPASSWORD = fLib.readData("password1");
		
//		FileInputStream f1 = new FileInputStream("./src/test/resources/CommonData.properties");
//		Properties p= new Properties();
//		p.load(f1);
//		String URL = p.getProperty("url");
//		String AdminUSERNAME = p.getProperty("username1");
//		String AdminPASSWORD = p.getProperty("password1");
//		String UserUSERNAME = p.getProperty("username2");
//		String UserPASSWORD = p.getProperty("password2");
		
		//get test data from excel
//		FileInputStream f2 = new FileInputStream("./src/test/resources/TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(f2);
//		Sheet sh = wb.getSheet("AddSupplier");
//		int rowcount = sh.getLastRowNum();
//		
//		
//		String cname = wb.getSheet("AddSupplier").getRow(0).getCell(1).getStringCellValue();
//		String phno = wb.getSheet("AddSupplier").getRow(1).getCell(1).getStringCellValue();
		



		//open browser
		WebDriver driver = new ChromeDriver();

		//wait and maximize to browser
		//driver.manage().window().maximize();
		wLib.maximize(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wLib.implycitlywait(driver, 10);

		//enter the URL
		driver.get(URL);

		//enter the credentials and click on login button
		driver.findElement(By.name("user")).sendKeys(AdminUSERNAME);
		driver.findElement(By.name("password")).sendKeys(AdminPASSWORD);
		driver.findElement(By.name("btnlogin")).click();

		//handle the alert popup
		//driver.switchTo().alert().accept();
		wLib.acceptAlert(driver);
		
		//add a supplier
		driver.findElement(By.xpath("//span[text()='Supplier']")).click();
		driver.findElement(By.xpath("//i[@class=\"fas fa-fw fa-plus\"]")).click();
		//driver.findElement(By.name("companyname")).sendKeys(cname);
		//driver.findElement(By.name("phonenumber")).sendKeys(phno);
		/*
		WebElement selProv = driver.findElement(By.name("province"));
		Select s= new Select(selProv);
		s.selectByVisibleText("Sulu");
		WebElement selCity = driver.findElement(By.name("city"));
		Select s1= new Select(selCity);
		Thread.sleep(2000);
		s1.selectByVisibleText("Omar");
		driver.findElement(By.xpath("//button[text()='Save']")).click();*/

		//using map
		
		HashMap<String, String> map = eLib.hashMapData("AddSupplier", 0);
		for(Entry<String, String> s:map.entrySet())
		{
			String key = s.getKey();
			String value = s.getValue();
			driver.findElement(By.xpath(key)).sendKeys(value);
		}
//		
//		HashMap<String, String> map= new HashMap<String, String>();
//		for(int i =0;i<=rowcount;i++)
//		{
//			String key = sh.getRow(i).getCell(0).getStringCellValue();
//			String value = sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//			
//		}
//		for(Entry<String, String> set:map.entrySet())
//		{
//			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//		}
		WebElement selProv = driver.findElement(By.name("province"));
//		Select s= new Select(selProv);
//		s.selectByVisibleText("Sulu");
		wLib.selectByVisibleText(selProv, "Sulu");
		WebElement selCity = driver.findElement(By.name("city"));
//		Select s1= new Select(selCity);
//		Thread.sleep(2000);
		wLib.selectByVisibleText(selCity,"Omar");
		//s1.selectByVisibleText("Omar");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("----Supplier is Created----");
	}

}
