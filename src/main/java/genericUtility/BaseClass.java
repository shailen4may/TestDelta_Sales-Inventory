package genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;

public class BaseClass
{
	public DatabaseUtils     dLib= new DatabaseUtils();
	public FileUtils         fLib= new FileUtils();
	public WebDriverUtiliy   wLib= new WebDriverUtiliy();
	public JavaUtils         jLib= new JavaUtils();
	public ExcelUtils        eLib= new ExcelUtils();
	public                   WebDriver driver;
	public static            WebDriver sdriver;
	
	@BeforeSuite
	public void config_DB() throws SQLException  
	{
		dLib.registerDriver();
		System.out.println("db connection");
	}
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void config_browser() throws IOException
	{
		String browser = fLib.readData("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("chrome is running");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println("firefox is running");
		}
		
		//reinitialising driver for screenshot
		sdriver=driver;
		wLib.maximize(driver);
		String URL = fLib.readData("url");
		driver.get(URL);
		wLib.waitPageLoad(driver, 10);
		System.out.println("browser launched");
	}
	@BeforeMethod
	public void config_Login() throws IOException
	{
		String AdminUSERNAME=fLib.readData("username1");
		String AdminPASSWORD = fLib.readData("password1");
		LoginPage lp = new LoginPage(driver);
		lp.setLogin(AdminUSERNAME, AdminPASSWORD);
		wLib.acceptAlert(driver);
	}
	@AfterMethod
	public void config_Logout()
	{
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	@AfterClass
	public void config_CloseBrowser() 
	{
		driver.quit();
	}
	@AfterSuite
	public void config_closeDB() throws SQLException 
	{
		dLib.closeConnection();
	}

}
