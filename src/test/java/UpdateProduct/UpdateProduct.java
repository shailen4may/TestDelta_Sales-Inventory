package UpdateProduct;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdateProduct 
{
	public static void main(String[] args) throws IOException, InterruptedException {
		Random ran = new Random();
		int random = ran.nextInt(100);
		//get common data from property file
		FileInputStream f1 = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p= new Properties();
		p.load(f1);
		String URL = p.getProperty("url");
		String AdminUSERNAME = p.getProperty("username1");
		String AdminPASSWORD = p.getProperty("password1");
		String UserUSERNAME = p.getProperty("username2");
		String UserPASSWORD = p.getProperty("password2");
		//get test data from excel
		FileInputStream f2 = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(f2);
		Sheet sh = wb.getSheet("UpdateProduct");
		int rowcount = sh.getLastRowNum();
		
		
		String prodname = wb.getSheet("UpdateProduct").getRow(0).getCell(1).getStringCellValue(); 
		String phno = wb.getSheet("UpdateProduct").getRow(1).getCell(1).getStringCellValue();
		
		//open browser
		WebDriver driver = new ChromeDriver();

		//wait and maximize to browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//enter the URL
		driver.get(URL);

		//enter the credentials and click on login button
		driver.findElement(By.name("user")).sendKeys(AdminUSERNAME);
		driver.findElement(By.name("password")).sendKeys(AdminPASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a/i[@class='fas fa-fw fa-plus']")).click();
		driver.findElement(By.name("prodcode")).sendKeys(prodname);
		driver.findElement(By.name("name")).sendKeys("Laptop");
		driver.findElement(By.xpath("//h5[text()='Add Product']/../..//textarea[@name='description']")).sendKeys("Black colour laptop");
		driver.findElement(By.name("quantity")).sendKeys("5");
		driver.findElement(By.name("onhand")).sendKeys("4");
		driver.findElement(By.name("price")).sendKeys("30000");
		WebElement cat = driver.findElement(By.name("category"));
		Select s=new Select(cat);
		s.selectByVisibleText("Others");
		WebElement suppliername = driver.findElement(By.name("supplier"));
		Select s1= new Select(suppliername);
		s1.selectByVisibleText("A4technology");
		driver.findElement(By.name("datestock")).click();
		driver.switchTo().activeElement().sendKeys("05012024");
		driver.findElement(By.xpath("//h5[text()='Add Product']/../..//button[@type='submit']")).click();
		System.out.println("---Supplier added---");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("HP keyboard");
		driver.findElement(By.xpath("//a[@data-toggle=\"dropdown\" and @style=\"color:white;\"]")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-warning bg-gradient-warning btn-block']")).click();
		driver.findElement(By.xpath("//div[@class='col-sm-9']//textarea[@name='description']")).sendKeys("wireless HP keyboard");
		WebElement cat2 = driver.findElement(By.name("category"));
		Select s2=new Select(cat2);
		s2.selectByVisibleText("Others");
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		System.out.println("---added supplier updated---");
		System.out.println(driver.switchTo().alert().getText());
		 
		
		
		
		


	}

}
