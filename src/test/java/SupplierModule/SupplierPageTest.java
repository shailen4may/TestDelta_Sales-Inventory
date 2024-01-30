package SupplierModule;

import java.io.IOException;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.SupplierPage;

import genericUtility.BaseClass;
@Listeners(genericUtility.ListenerImpclass.class)

public class SupplierPageTest extends BaseClass
{
	@Test
	
	public void addSupplier() throws IOException
	{
//		FileUtils fLib= new FileUtils();
//		WebDriver driver = new ChromeDriver();
//		ExcelUtils eLib = new ExcelUtils();
//		JavaUtils jLib = new JavaUtils(); 
//		WebDriverUtiliy wLib = new WebDriverUtiliy();
//		wLib.maximize(driver);
//		String URL = fLib.readData("url");
//		driver.get(URL);
//		wLib.implycitlywait(driver, 10);
//		String AdminUSERNAME=fLib.readData("username1");
//		String AdminPASSWORD = fLib.readData("password1");
//		LoginPage lp = new LoginPage(driver);
//		lp.setLogin(AdminUSERNAME, AdminPASSWORD);
//		wLib.acceptAlert(driver);
		SupplierPage sp = new SupplierPage(driver);
		Reporter.log("====supplier====",true);
		//Assert.fail();
		sp.addSupp(driver,wLib,eLib,jLib ,"Abra","Bucay");
		
	}
}
