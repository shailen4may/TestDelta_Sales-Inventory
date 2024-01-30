package com.ObjectRepo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.ExcelUtils;
import genericUtility.JavaUtils;
import genericUtility.WebDriverUtiliy;

public class SupplierPage 
{
	@FindBy(xpath = "//a[@type='button' and @data-target='#supplierModal']")
	private WebElement supplieraddbtn;
	@FindBy(name ="dataTable_length")
	private WebElement showEntriesbtn;
	@FindBy(xpath ="type")
	private WebElement searchbtn;
	@FindBy(id="dataTable_previous")
	private WebElement previousbtn;
	@FindBy(xpath="//a[text()='Next']")
	private WebElement nextbtn;
	@FindBy(xpath="//a[text()=' Details']")
	private WebElement detailsbtn;
	@FindBy(xpath="//a[contains(text(),'...')]")
	private WebElement ellipsis;
	@FindBy(name="companyname")
	private WebElement compnametxt;
	@FindBy(name="phonenumber")
	private WebElement phnotxt;
	@FindBy(id="province")
	private WebElement provincelist;
	@FindBy(id="city")
	private WebElement citylist;
	@FindBy(xpath="//h5[text()='Add Supplier']/../..//button[text()='Save']")
	private WebElement savebtn;


	public SupplierPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSupplieraddbtn() {
		return supplieraddbtn;
	}

	public WebElement getShowEntriesbtn() {
		return showEntriesbtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getPreviousbtn() {
		return previousbtn;
	}

	public WebElement getNextbtn() {
		return nextbtn;
	}

	public WebElement getDetailsbtn() {
		return detailsbtn;
	}

	public WebElement getEllipsis() {
		return ellipsis;
	}


	public WebElement getCompnametxt() {
		return compnametxt;
	}

	public WebElement getPhnotxt() {
		return phnotxt;
	}

	public WebElement getProvincelist() {
		return provincelist;
	}

	public WebElement getCitylist() {
		return citylist;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}

	//business Logic
	public void  addSupp(WebDriver driver,WebDriverUtiliy wLib,ExcelUtils eLib,JavaUtils jLib, String province ,String city) throws EncryptedDocumentException, IOException
	{
		//driver.findElement(By.xpath("//span[text()='Supplier']")).click();
		HomePage hp = new HomePage(driver);
		hp.getSupplierTabandicon().click();
		supplieraddbtn.click();
		// = new ExcelUtils();
		HashMap<String, String> map = eLib.hashMapData("Sheet6", 0);
		for(Entry<String, String> s:map.entrySet())
		{
			String key = s.getKey();
			String value = s.getValue();
			driver.findElement(By.name(key)).sendKeys(value);
		}	// = new WebDriverUtiliy();
		wLib.selectByVisibleText(provincelist, province);
		wLib.selectByVisibleText(citylist, city);

		savebtn.click();
		System.out.println("Supplier is created");
		driver.quit();

	}


}
