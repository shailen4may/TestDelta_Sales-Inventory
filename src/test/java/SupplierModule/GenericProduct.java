package SupplierModule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelUtils;
import genericUtility.FileUtils;
import genericUtility.JavaUtils;
import genericUtility.WebDriverUtiliy;

public class GenericProduct {

	public static void main(String[] args) throws IOException {
		FileUtils fLib = new FileUtils();
		JavaUtils jLib = new JavaUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtiliy wLib = new WebDriverUtiliy();
		
		int random=jLib.getRandom(300);
		String search = null;
		String URL=fLib.readData("url");
		String AdminUSERNAME=fLib.readData("username1");
		String AdminPASSWORD = fLib.readData("password1");
		WebDriver driver= new ChromeDriver();
		wLib.maximize(driver);
		driver.get(URL);
	    wLib.implycitlywait(driver, 10);
	    driver.findElement(By.name("user")).sendKeys(AdminUSERNAME);
		driver.findElement(By.name("password")).sendKeys(AdminPASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		wLib.waituntilalertIsPresent(driver, 20);
		wLib.acceptAlert(driver);
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		System.out.println("--product is displayed--");
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
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



		
	}

}
