package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy (name ="user")
	private WebElement untbx;
	@FindBy (name ="password")
	private WebElement pwtbx;
	@FindBy (name ="btnlogin")
	private WebElement lgbtn;
	@FindBy(xpath = "//div[@class='custom-control custom-checkbox small']")
	private WebElement rememberchkbx;
	@FindBy(xpath="//h1[text()='Welcome to Sales and Inventory!']")
	private WebElement appname;
	@FindBy(xpath =" //a[@data-target=\"#logoutModal\"]")
	private WebElement logoutbtn;
	@FindBy(xpath ="//a/span[text()='Home']")
	private WebElement admindropdownbtn;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getUntbx() {
		return untbx;
	}
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	public WebElement getAdmindropdownbtn() {
		return admindropdownbtn;
	}
	public void setUntbx(WebElement untbx) {
		this.untbx = untbx;
	}
	public WebElement getPwtbx() {
		return pwtbx;
	}
	public void setPwtbx(WebElement pwtbx) {
		this.pwtbx = pwtbx;
	}
	public WebElement getLgbtn() {
		return lgbtn;
	}
	public void setLgbtn(WebElement lgbtn) {
		this.lgbtn = lgbtn;
	}
	public WebElement getRememberchkbx() {
		return rememberchkbx;
	}
	public WebElement getAppname() {
		return appname;
	}
	//business logic
	public void setLogin(String un , String pw)
	{
		untbx.sendKeys(un);
		pwtbx.sendKeys(pw);
		lgbtn.click();
	}
	public void logout()
	{
		admindropdownbtn.click();
	    logoutbtn.click();
		
	}
	
	
	
}