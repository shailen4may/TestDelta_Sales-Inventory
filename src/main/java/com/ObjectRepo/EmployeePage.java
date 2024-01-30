package com.ObjectRepo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.ExcelUtils;
import genericUtility.WebDriverUtiliy;

public class EmployeePage 
{


	@FindBy(xpath="//a[@type='button' and @data-target='#employeeModal']")
	private WebElement employeeaddbtn;
	@FindBy(name ="dataTable_length")
	private WebElement showEntriesbtn;
	@FindBy(xpath ="type")
	private WebElement searchbtn;
	@FindBy(id="dataTable_previous")
	private WebElement previousbtn;
	@FindBy(xpath="//a[text()='Next']")
	private WebElement nextbtn;
	@FindBy(xpath="//h5[text()='Add Employee']/../..//select[@name='gender']")
	private WebElement genderdrpdwn;
	@FindBy(xpath ="//h5[text()='Add Employee']/../..//select[@name='jobs']")
	private WebElement jobdrpdwn;
	@FindBy(xpath="//h5[text()='Add Employee']/../..//select[@name='province']")
	private WebElement provincedrpdwn;
	@FindBy(xpath="//h5[text()='Add Employee']/../..//select[@name='city']")
	private WebElement citydrpdwn;
	@FindBy(xpath = "//h5[text()='Add Employee']/../..//button[@type='submit']")
	private WebElement submitbtn;

	public WebElement getJobdrpdwn() {
		return jobdrpdwn;
	}
	public WebElement getProvincedrpdwn() {
		return provincedrpdwn;
	}
	public WebElement getCitydrpdwn() {
		return citydrpdwn;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	public EmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getEmployeeaddbtn() {
		return employeeaddbtn;
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
	public WebElement getGenderdrpdwn() {
		return genderdrpdwn;
	}
	
	//business logic
	public void saveEmployee(WebDriver driver, String ddmmyyyy) throws Throwable, IOException
	{
		getEmployeeaddbtn().click();
		WebDriverUtiliy wLib = new WebDriverUtiliy();
		ExcelUtils eLib = new ExcelUtils();
		HashMap<String, String> map = eLib.hashMapData("Sheet1", 0);
		for(Entry<String, String> s:map.entrySet())
		{
			String key = s.getKey();
			String value = s.getValue();
			driver.findElement(By.xpath(key)).sendKeys(value);
		}
		//WebElement gender = driver.findElement(By.xpath("//h5[text()='Add Employee']/../..//select[@name='gender']"));
		wLib.selectByVisibleText(genderdrpdwn, "Male");
		//WebElement job = driver.findElement(By.xpath("//h5[text()='Add Employee']/../..//select[@name='jobs']"));
		wLib.selectByVisibleText(jobdrpdwn, "Manager");
		//WebElement province = driver.findElement(By.xpath("//h5[text()='Add Employee']/../..//select[@name='province']"));
		wLib.selectByVisibleText(provincedrpdwn, "Abra");
		//WebElement city = driver.findElement(By.xpath("//h5[text()='Add Employee']/../..//select[@name='city']"));
		wLib.selectByVisibleText(citydrpdwn, "Bucay");
		
		driver.findElement(By.id("FromDate")).click();
		driver.switchTo().activeElement().sendKeys(ddmmyyyy);
		
		//driver.findElement(By.xpath("//h5[text()='Add Employee']/../..//button[@type='submit']")).click();
		submitbtn.click();
		System.out.println("----Employee is added successfully----");
	}

}
