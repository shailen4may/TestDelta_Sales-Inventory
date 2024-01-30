package UpdateProduct;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepo.LoginPage;
import com.ObjectRepo.addProductPage;

import genericUtility.ExcelUtils;
import genericUtility.FileUtils;
import genericUtility.JavaUtils;
import genericUtility.WebDriverUtiliy;

public class addProductTest 
{
	@Test
	public void addProd() throws IOException
	{
		FileUtils fLib= new FileUtils();
		WebDriver driver = new ChromeDriver();
		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		WebDriverUtiliy wLib = new WebDriverUtiliy();
		wLib.maximize(driver);
		String URL = fLib.readData("url");
		driver.get(URL);
		wLib.implycitlywait(driver, 10);
		String AdminUSERNAME=fLib.readData("username1");
		String AdminPASSWORD = fLib.readData("password1");
		LoginPage lp = new LoginPage(driver);
		lp.setLogin(AdminUSERNAME, AdminPASSWORD);
		wLib.acceptAlert(driver);
		addProductPage ap = new addProductPage(driver);
		ap.addProduct(driver);
	}
}
