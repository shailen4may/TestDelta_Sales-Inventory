package ProductList;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.DatabaseUtils;
import genericUtility.ExcelUtils;
import genericUtility.FileUtils;
import genericUtility.JavaUtils;
import genericUtility.WebDriverUtiliy;


public class Product1 {

     @Test

	public void updateProductTest() throws IOException, InterruptedException
	{
		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		DatabaseUtils dLIb = new DatabaseUtils();
		WebDriverUtiliy wLib= new WebDriverUtiliy();

		//generating random number
		int random = jLib.getRandom(100);	
		String search=null;

		//get common data from property file

		String URL=fLib.readData("url");
		String AdminUSERNAME=fLib.readData("username1");
		String AdminPASSWORD = fLib.readData("password1");
		
		//		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//		Properties p= new Properties();
		//		p.load(fis);
		//		String BROWSER = p.getProperty("browser");
		//		String URL = p.getProperty("url");
		//		String USERNAME = p.getProperty("username");
		//		String PASSWORD = p.getProperty("password");


		//launch browser
		WebDriver driver= new ChromeDriver();

		//maximize browser
		wLib.maximize(driver);
		//enter URL
		driver.get(URL);

		//wait for page load
	     wLib.implycitlywait(driver, 10);

		//login to application
		driver.findElement(By.name("user")).sendKeys(AdminUSERNAME);
		driver.findElement(By.name("password")).sendKeys(AdminPASSWORD);
		driver.findElement(By.name("btnlogin")).click();

		//handling alert pop up
		//WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10));
		//Alert a = wait1.until(ExpectedConditions.alertIsPresent());
		//driver.switchTo().alert().accept();
		
		wLib.waituntilalertIsPresent(driver, 20);
		wLib.acceptAlert(driver);



		//click on product major tab
		driver.findElement(By.xpath("//span[text()='Product']")).click();

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement w = driver.findElement(By.xpath("//h4[text()='Product ']"));
		//	wait.until(ExpectedConditions.textToBePresentInElement(w, "Product"));
	//	wLib.waituntilTextPresent(driver, 10, w, "Product");		
		System.out.println("--product is displayed--");

		//click on create product
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();


		//get Testdata from Excel file
//		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet("Product");
//		int rowcount = sh.getLastRowNum();


		//HashMap<String, String> map= new HashMap<String, String>();


//		for(int i=0;i<=rowcount; i++)
//		{
//			String key = sh.getRow(i).getCell(0).getStringCellValue();
//			String value = sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//
//		}
		HashMap<String, String> map = eLib.hashMapData("UpdateProduct", 0);

		for(Entry<String, String> set:map.entrySet())
		{
			if(set.getKey().contains("//h5[text()='Add Product']/../..//input[@name='prodcode']"))
			{

				
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+random);
				search="prodcode"+random;
				System.out.println(random);

			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
		}

		//product category list
		WebElement prodCategoryList = driver.findElement(By.name("category"));
		//		Select s= new Select(prodCategoryList);
		//		s.selectByVisibleText("Keyboard");
		wLib.selectByVisibleText(prodCategoryList,"Keyboard");
		//supplier list box
		WebElement supplierList = driver.findElement(By.name("supplier"));
		//		Select s1= new Select(supplierList);
		//		s1.selectByVisibleText("Hardware Exports");
		wLib.selectByVisibleText(supplierList, "Hardware Exports");

	//	wLib.select("Hardware Exports", supplierList);



		//click on date on stock 
		driver.findElement(By.name("datestock")).click();

		//enter the date of stock value
		driver.switchTo().activeElement().sendKeys("251223");

		//click on save
		driver.findElement(By.xpath("//h5[text()='Add Product']/../..//button[text()='Save']")).click();


		Thread.sleep(5000);
		//type in search box
		WebElement searchBox = driver.findElement(By.xpath("//label[contains(text(),'Search')]/..//input[@type='search']"));
		searchBox.sendKeys(search);
		wLib.waituntilTextPresent(driver, 10, searchBox, "search");

		//click on ellipsis
		driver.findElement(By.xpath("//a[@data-toggle=\"dropdown\" and @style=\"color:white;\"]")).click();

		//click on edit button
		driver.findElement(By.linkText("Edit")).click();

		WebElement editProductText = driver.findElement(By.xpath("//h4[text()='Edit Product']"));
		//		WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10));
		//		wait1.until(ExpectedConditions.);
		wLib.waituntilTextPresent(driver, 10, editProductText, "Edit Product");

		//clear description
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).clear();

		//edit the description
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).sendKeys("Silver colour");


		//handling product category list box
		WebElement categoryList = driver.findElement(By.name("category"));
//		Select s2= new Select(categoryList);
//		s2.selectByVisibleText("Keyboard");
		wLib.selectByVisibleText(categoryList, "Keyboard");
		//wLib.select("keyboard", categoryList);

		driver.findElement(By.xpath("//button[text()='Update']")).click();

		String text = driver.switchTo().alert().getText();
		
		System.out.println(text);

		//handling alert pop up
//		WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait2.until(ExpectedConditions.alertIsPresent());
		wLib.waituntilalertIsPresent(driver, 10);
		
		//driver.switchTo().alert().accept();
		wLib.acceptAlert(driver);

		System.out.println("---product is updated--");
	}
}
