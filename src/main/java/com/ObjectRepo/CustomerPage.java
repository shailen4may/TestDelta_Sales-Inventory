package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage 
{
	@FindBy(xpath="//a[@type='button' and @data-target='#customerModal']")
	private WebElement customeraddbtn;
	@FindBy(name ="dataTable_length")
	private WebElement showEntriesbtn;
	@FindBy(xpath ="type")
	private WebElement searchbtn;
	@FindBy(id="dataTable_previous")
	private WebElement previousbtn;
	@FindBy(xpath="//a[text()='Next']")
	private WebElement nextbtn;
	public CustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCustomeraddbtn() {
		return customeraddbtn;
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
	
}
