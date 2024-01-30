package UserPOS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ObjectRepo.LoginPage;
import com.ObjectRepo.PosPage;

import genericUtility.FileUtils;
import genericUtility.WebDriverUtiliy;

public class PosUserTest {
	
	@Test
	
	public void loginAdmin() throws Throwable
	{
				
		FileUtils fLib= new FileUtils();
		WebDriverUtiliy wLib= new WebDriverUtiliy();
		WebDriver driver= new ChromeDriver();
		LoginPage lp= new LoginPage(driver);
		
		wLib.maximize(driver);
		
		String url = fLib.readData("url");
		driver.get(url);
		
		wLib.implycitlywait(driver, 10);
		String AdminUSERNAME=fLib.readData("username2");
		String AdminPASSWORD = fLib.readData("password2");
		lp.setLogin(AdminUSERNAME, AdminPASSWORD);
		wLib.acceptAlert(driver);
		
		String actualUrl = driver.getCurrentUrl();
		
		System.out.println(actualUrl);
		Assert.assertEquals(actualUrl,"http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/pos.php");
		
		
//		if(actualUrl.contains("pos"))
//		{
//			System.out.println("--pos page is displayed--");
//		}
//		
//		else {
//			System.out.println("--pos page is not displayed--");
//		}
		
		//executing method created to check

		PosPage pp= new PosPage(driver);
		pp.pos(driver, "Asis", 5, "a z",60.00);
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		wLib.acceptAlert(driver);
		driver.quit();
		
	}

}