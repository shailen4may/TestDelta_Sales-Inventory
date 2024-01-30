package UserPOS;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelUtils;
import genericUtility.FileUtils;
import genericUtility.JavaUtils;
import genericUtility.WebDriverUtiliy;

public class UserPOSSmoke 
{
	public static void main(String[] args) throws IOException
	{
		WebDriver driver;
		FileUtils flib = new FileUtils();
		WebDriverUtiliy wlib = new WebDriverUtiliy();
		
//		//get common data from property file
//		FileInputStream f1 = new FileInputStream("./src/test/resources/CommonData.properties");
//		Properties p= new Properties();
//		p.load(f1);
		
		String URL =flib.readData("url");

		String UserUSERNAME = flib.readData("username2");
		String UserPASSWORD = flib.readData("password2");
		 
		//open browser
		 driver = new ChromeDriver();

		//wait and maximize to browser
		wlib.maximize(driver);
		 //driver.manage().window().maximize();
		wlib.implycitlywait(driver, 10);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter the URL
		driver.get(URL);

		//enter the credentials and click on login button
		driver.findElement(By.name("user")).sendKeys(UserUSERNAME);
		driver.findElement(By.name("password")).sendKeys(UserPASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		//driver.switchTo().alert().accept();
		wlib.acceptAlert(driver);
		
		System.out.println(driver.getCurrentUrl());
		String actual = driver.getCurrentUrl();
		
		if(actual.contains("pos")) {
			System.out.println("POS page is displayed");
		}
		else
			System.out.println("POS page is not displayed");
		
		driver.quit();
	}

}
