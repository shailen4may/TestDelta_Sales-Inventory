package com.ObjectRepo;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.ExcelUtils;
import genericUtility.FileUtils;
import genericUtility.JavaUtils;
import genericUtility.WebDriverUtiliy;

public class addProductPage 
{
	@FindBy(xpath = "//a[@type='button' and @data-target='#aModal']")
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
	@FindBy(name ="prodcode")
	private WebElement prodcodetxt;
	@FindBy(name ="name")
	private WebElement nametxt;
	@FindBy(xpath="//textarea[@placeholder='Description']")
	private WebElement descriptiontxt;
	@FindBy(name="quantity")
	private WebElement quanttxt;
	@FindBy(name="onhand")
	private WebElement onhandtxt;
	@FindBy(name="price")
	private WebElement pricetxt;
	@FindBy(name="category")
	private WebElement categoryList;
	@FindBy(name="supplier")
	private WebElement supplierList;
	@FindBy(name="datestock")
	private WebElement datestocktxt;
	
	
	public WebElement getSupplieraddbtn() {
		return supplieraddbtn;
	}


	public void setSupplieraddbtn(WebElement supplieraddbtn) {
		this.supplieraddbtn = supplieraddbtn;
	}


	public WebElement getShowEntriesbtn() {
		return showEntriesbtn;
	}


	public void setShowEntriesbtn(WebElement showEntriesbtn) {
		this.showEntriesbtn = showEntriesbtn;
	}


	public WebElement getSearchbtn() {
		return searchbtn;
	}


	public void setSearchbtn(WebElement searchbtn) {
		this.searchbtn = searchbtn;
	}


	public WebElement getPreviousbtn() {
		return previousbtn;
	}


	public void setPreviousbtn(WebElement previousbtn) {
		this.previousbtn = previousbtn;
	}


	public WebElement getNextbtn() {
		return nextbtn;
	}


	public void setNextbtn(WebElement nextbtn) {
		this.nextbtn = nextbtn;
	}


	public WebElement getDetailsbtn() {
		return detailsbtn;
	}


	public void setDetailsbtn(WebElement detailsbtn) {
		this.detailsbtn = detailsbtn;
	}


	public WebElement getEllipsis() {
		return ellipsis;
	}


	public void setEllipsis(WebElement ellipsis) {
		this.ellipsis = ellipsis;
	}


	public WebElement getProdcodetxt() {
		return prodcodetxt;
	}


	public void setProdcodetxt(WebElement prodcodetxt) {
		this.prodcodetxt = prodcodetxt;
	}


	public WebElement getNametxt() {
		return nametxt;
	}


	public void setNametxt(WebElement nametxt) {
		this.nametxt = nametxt;
	}


	public WebElement getDescriptiontxt() {
		return descriptiontxt;
	}


	public void setDescriptiontxt(WebElement descriptiontxt) {
		this.descriptiontxt = descriptiontxt;
	}


	public WebElement getQuanttxt() {
		return quanttxt;
	}


	public void setQuanttxt(WebElement quanttxt) {
		this.quanttxt = quanttxt;
	}


	public WebElement getOnhandtxt() {
		return onhandtxt;
	}


	public void setOnhandtxt(WebElement onhandtxt) {
		this.onhandtxt = onhandtxt;
	}


	public WebElement getPricetxt() {
		return pricetxt;
	}


	public void setPricetxt(WebElement pricetxt) {
		this.pricetxt = pricetxt;
	}


	public WebElement getCategoryList() {
		return categoryList;
	}


	public void setCategoryList(WebElement categoryList) {
		this.categoryList = categoryList;
	}


	public WebElement getSupplierList() {
		return supplierList;
	}


	public void setSupplierList(WebElement supplierList) {
		this.supplierList = supplierList;
	}


	public WebElement getDatestocktxt() {
		return datestocktxt;
	}


	public void setDatestocktxt(WebElement datestocktxt) {
		this.datestocktxt = datestocktxt;
	}
	public addProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// business logic
	public void addProduct(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		FileUtils fLib= new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		WebDriverUtiliy wLib = new WebDriverUtiliy();
		wLib.implycitlywait(driver, 10);
		HomePage hp = new HomePage(driver);
		hp.getProductTabandicon().click();
		wLib.waituntilelementToBeClickable(driver, 10, supplieraddbtn);
		supplieraddbtn.click();
		HashMap<String, String> map = eLib.hashMapData("AddProd", 0);
		for(Entry<String, String> s:map.entrySet())
		{
			String key = s.getKey();
			String value = s.getValue();
			driver.findElement(By.name(key)).sendKeys(value);
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wLib.selectByVisibleText(categoryList, "Mouse");
		wLib.selectByVisibleText(supplierList, "A4technology");
		getDescriptiontxt().sendKeys("Dell wireless mouse");
		driver.findElement(By.name("datestock")).click();
		driver.switchTo().activeElement().sendKeys("12112023");

		//getDatestocktxt().sendKeys("12052023");

	}
}