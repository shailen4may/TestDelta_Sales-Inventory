package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeDashboardPage 
{
	@FindBy(xpath ="//div[text()='Customers']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement customerRecords;
	@FindBy(xpath ="//div[text()='Employees']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement employeesRecords;
	@FindBy(xpath ="//div[text()='Product']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement productRecords;
	@FindBy(xpath ="//div[text()='Supplier']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement supplierRecords;
	@FindBy(xpath ="//div[text()='Registered Account']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement RegisteredAccRecords;
	@FindBy(xpath="//a[text()='View All Products']")
	private WebElement viewProductlink;
	@FindBy(xpath="//a[@class='scroll-to-top rounded']")
	private WebElement scrolltopbtn;
	
	public HomeDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerRecords() {
		return customerRecords;
	}

	public void setCustomerRecords(WebElement customerRecords) {
		this.customerRecords = customerRecords;
	}

	public WebElement getEmployeesRecords() {
		return employeesRecords;
	}

	public void setEmployeesRecords(WebElement employeesRecords) {
		this.employeesRecords = employeesRecords;
	}

	public WebElement getProductRecords() {
		return productRecords;
	}

	public void setProductRecords(WebElement productRecords) {
		this.productRecords = productRecords;
	}

	public WebElement getSupplierRecords() {
		return supplierRecords;
	}

	public void setSupplierRecords(WebElement supplierRecords) {
		this.supplierRecords = supplierRecords;
	}

	public WebElement getRegisteredAccRecords() {
		return RegisteredAccRecords;
	}

	public void setViewProductlink(WebElement viewProductlink) {
		this.viewProductlink = viewProductlink;
	}

}
