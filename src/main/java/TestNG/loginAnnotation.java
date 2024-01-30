package TestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;

import genericUtility.ExcelUtils;
import genericUtility.FileUtils;
import genericUtility.JavaUtils;
import genericUtility.WebDriverUtiliy;

public class loginAnnotation
{
	FileUtils fLib= new FileUtils();
	WebDriver driver = new ChromeDriver();
	ExcelUtils eLib = new ExcelUtils();
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiliy wLib = new WebDriverUtiliy();
	@BeforeSuite
	public void dbConn()
	{
		System.out.println("DB conn is running");
	}
	@BeforeTest
	public void browser() throws IOException
	{
		driver = new ChromeDriver();
		wLib.maximize(driver);
		String URL = fLib.readData("url");
		driver.get(URL);
		wLib.implycitlywait(driver, 10);
	}
	@BeforeMethod
	public void login() throws IOException
	{
		String AdminUSERNAME=fLib.readData("username1");
		String AdminPASSWORD = fLib.readData("password1");
		LoginPage lp = new LoginPage(driver);
		lp.setLogin(AdminUSERNAME, AdminPASSWORD);
		wLib.acceptAlert(driver);
	}
	@Test
	public void emp()
	{
		HomePage hp = new HomePage(driver);
		hp.getEmployeeTabandicon().click();
	}
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	@AfterSuite
	public void dbConnclosed()
	{
		System.out.println("DB conn closed");
	}

}
