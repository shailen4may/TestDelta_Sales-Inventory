package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath = "//i[@class='fas fa-laugh-wink']")
	private WebElement laughandWink;
	@FindBy(xpath="//div[text()='Sales and Inventory System']")
	private WebElement appnamelogo;
	@FindBy(xpath="//span[text()='POS']")
	private WebElement POSbutton;
	@FindBy(id="userDropdown")
	private WebElement admindropdownbtn;
	@FindBy(xpath ="//a/span[text()='Home']")
	private WebElement homeMajortab;
	@FindBy(xpath ="//div[contains(text(),'Tables')]")
	private WebElement tableText;
	@FindBy(xpath ="//a/span[text()='Customer']")
	private WebElement customerTabandicon;
	@FindBy(xpath = "//a/span[text()='Employee']")
	private WebElement employeeTabandicon;
	@FindBy(xpath = "//a/span[text()='Product']")
	private WebElement productTabandicon;
	@FindBy(xpath = "//a/span[text()='Inventory']")
	private WebElement inventoryTabandicon;
	@FindBy(xpath = "//a/span[text()='Transaction']")
	private WebElement transactionTabandicon;
	@FindBy(xpath = "//a/span[text()='Supplier']")
	private WebElement supplierTabandicon;
	@FindBy(xpath = "//a/span[text()='Accounts']")
	private WebElement accountsTabandicon;
	@FindBy(xpath =" //a[@data-target=\"#logoutModal\"]")
	private WebElement logoutbtn;
	@FindBy(xpath ="//div[@aria-labelledby=\"userDropdown\"]//a[1]")
	private WebElement settingsbtn;
	@FindBy(id="sidebarToggle")
	private WebElement sideTogglebtn;
	@FindBy(xpath="//h5[text()='Ready to Leave?']/../..//div[@class=\"modal-footer\"]//a[text()='Logout']")
	private WebElement finallgtbtn;
	@FindBy(xpath="//div[@class=\"modal-footer\"]//button[text()='Cancel']")
	private WebElement cancelbtn;
	
	
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getLaughandWink() {
		return laughandWink;
	}
	public WebElement getSettingsbtn() {
		return settingsbtn;
	}
	public void setLaughandWink(WebElement laughandWink) {
		this.laughandWink = laughandWink;
	}
	public WebElement getAppnamelogo() {
		return appnamelogo;
	}
	public void setAppnamelogo(WebElement appnamelogo) {
		this.appnamelogo = appnamelogo;
	}
	public WebElement getPOSbutton() {
		return POSbutton;
	}
	public void setPOSbutton(WebElement pOSbutton) {
		POSbutton = pOSbutton;
	}
	public WebElement getAdmindropdownbtn() {
		return admindropdownbtn;
	}
	public void setAdmindropdownbtn(WebElement admindropdownbtn) {
		this.admindropdownbtn = admindropdownbtn;
	}
	public WebElement getHomeMajortab() {
		return homeMajortab;
	}
	public void setHomeMajortab(WebElement homeMajortab) {
		this.homeMajortab = homeMajortab;
	}
	public WebElement getTableText() {
		return tableText;
	}
	public void setTableText(WebElement tableText) {
		this.tableText = tableText;
	}
	public WebElement getCustomerTabandicon() {
		return customerTabandicon;
	}
	public void setCustomerTabandicon(WebElement customerTabandicon) {
		this.customerTabandicon = customerTabandicon;
	}
	public WebElement getEmployeeTabandicon() {
		return employeeTabandicon;
	}
	public void setEmployeeTabandicon(WebElement employeeTabandicon) {
		this.employeeTabandicon = employeeTabandicon;
	}
	public WebElement getProductTabandicon() {
		return productTabandicon;
	}
	public void setProductTabandicon(WebElement productTabandicon) {
		this.productTabandicon = productTabandicon;
	}
	public WebElement getInventoryTabandicon() {
		return inventoryTabandicon;
	}
	public void setInventoryTabandicon(WebElement inventoryTabandicon) {
		this.inventoryTabandicon = inventoryTabandicon;
	}
	public WebElement getTransactionTabandicon() {
		return transactionTabandicon;
	}
	public void setTransactionTabandicon(WebElement transactionTabandicon) {
		this.transactionTabandicon = transactionTabandicon;
	}
	public WebElement getSupplierTabandicon() {
		return supplierTabandicon;
	}
	public void setSupplierTabandicon(WebElement supplierTabandicon) {
		this.supplierTabandicon = supplierTabandicon;
	}
	public WebElement getAccountsTabandicon() {
		return accountsTabandicon;
	}
	public void setAccountsTabandicon(WebElement accountsTabandicon) {
		this.accountsTabandicon = accountsTabandicon;
	}
	public WebElement getSideTogglebtn() {
		return sideTogglebtn;
	}
	public void setSideTogglebtn(WebElement sideTogglebtn) {
		this.sideTogglebtn = sideTogglebtn;
	}
	
	
	public WebElement getFinallgtbtn() {
		return finallgtbtn;
	}
	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	public void logout()
	{
		admindropdownbtn.click();
	    logoutbtn.click();
	 //   finallgtbtn.click();
	    System.out.println("===final logout===");
	}

}
