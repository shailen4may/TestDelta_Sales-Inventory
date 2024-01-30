package ProductList;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.DatabaseUtils;
import genericUtility.ExcelUtils;
import genericUtility.FileUtils;
import genericUtility.JavaUtils;
import genericUtility.WebDriverUtiliy;

public class ProductListSmoke {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileUtils fLib= new FileUtils();
		ExcelUtils eLib= new ExcelUtils();
		DatabaseUtils dLib= new DatabaseUtils();
		JavaUtils jLib= new JavaUtils();
		WebDriverUtiliy wLib= new WebDriverUtiliy();
		
		
		//get common data from property file
//				FileInputStream f1 = new FileInputStream("./src/test/resources/CommonData.properties");
//				Properties p= new Properties();
//				p.load(f1);
//				String URL = p.getProperty("url");
//				String AdminUSERNAME = p.getProperty("username1");
//				String AdminPASSWORD = p.getProperty("password1");
//				String UserUSERNAME = p.getProperty("username2");
//				String UserPASSWORD = p.getProperty("password2");
				
		String URL = fLib.readData("url");
		String AdminUsername = fLib.readData("username1");
		String AdminPassword = fLib.readData("password1");
		
		
				//open browser
				WebDriver driver = new ChromeDriver();

				//wait and maximize to browser
				//driver.manage().window().maximize();
				wLib.maximize(driver);
				
				//wait for page load
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				wLib.implycitlywait(driver, 10);
				
				//enter the URL
				driver.get(URL);

				//enter the credentials and click on login button
				driver.findElement(By.name("user")).sendKeys(AdminUsername);
				driver.findElement(By.name("password")).sendKeys(AdminPassword);
				driver.findElement(By.name("btnlogin")).click();
				
				//driver.switchTo().alert().accept();
				wLib.acceptAlert(driver);
				
				driver.findElement(By.xpath("//span[text()='Product']")).click();
			
				//System.out.println(driver.getTitle());
				String Actual = driver.getCurrentUrl();
				System.out.println(Actual);
				if(Actual.contains("product")) {
					System.out.println("Product list page is displayed");
				}
				else
					System.out.println("Not displayed");
				
			 driver.quit();
	}

}
