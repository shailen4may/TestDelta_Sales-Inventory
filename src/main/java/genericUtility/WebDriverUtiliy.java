package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtiliy 
{
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void implycitlywait(WebDriver driver , int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	
	//wait statements
	
	public void waituntilelementToBeSelected(WebDriver driver , int sec , WebElement element )
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waituntilalertIsPresent(WebDriver driver , int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waituntilelementToBeClickable(WebDriver driver , int sec,WebElement element )
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waituntilattributeContains(WebDriver driver , int sec,WebElement element,String attribute , String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.attributeContains(element,attribute,value));
	}
	public void waituntilattributeContains(WebDriver driver , int sec,String attribute)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(attribute));
	}
	public void waituntilnumberOfElementsToBe(WebDriver driver , int sec,int num ,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.numberOfElementsToBe((By) element,num));
	}
	public void waitPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	public void waituntilTextPresent(WebDriver driver , int sec , WebElement element , String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text ));
	}
	/**
	 * 
	 * @param driver
	 * @param sec
	 * @param num
	 * @param element
	 */
	public void waituntilnumberOfElementsToBeLessThan(WebDriver driver , int sec,int num ,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan((By) element,num));
	}
	/**
	 * This method will switch the frame based on address of the element
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**This method is used to accept the alert popup
	 * This method will accept alert popup
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is used to dismiss the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * Thos method will switch between windows
	 * @param driver
	 * @param partialWinTitle
	 */
	
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//step1: use getWindowHandles to capture all window ids
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate thru the windows
		Iterator<String> it = windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			//step5: switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether the current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	

		/**
		 * THis method will perform right click on WebPage
		 * @param driver
		 */
		public void rightClick(WebDriver driver)
		{
			Actions Act = new Actions(driver);
			Act.contextClick().perform();
		}
		/**
		 * This method is used to perform double click
		 * @param driver
		 */
		public void doubleClick(WebDriver driver)
		{
			Actions Act = new Actions(driver);
			Act.doubleClick().perform();
		}
		/**
		 *this method Clicks (without releasing) at the current mouse location
		 */
		public void clickAndHold (WebDriver driver)
		{
			Actions Act = new Actions(driver);
			Act.clickAndHold().perform();
		}
		/**
		 * this method is used to drag and drop the elements to a particular location
		 * @param driver
		 * @param src
		 * @param dest
		 */
		public void dragAndDrop (WebDriver driver,WebElement src,WebElement dest)
		{
			Actions Act = new Actions(driver);
			Act.dragAndDrop(src, dest).perform();
		}
		
		public Select selectAnElement(WebElement element)
		{
			Select sel = new Select(element);
			return sel; 
		}
		/**
		 * this method is used to select a element in dropdown by index
		 * @param element
		 * @param index
		 */
		public void selectByIndex(WebElement element , int index)
		{
			selectAnElement(element).selectByIndex(index);
		}
		/**
		 * this method is used to select a element in dropdown by visible text
		 * @param element
		 * @param text
		 */
		public void selectByVisibleText(WebElement element, String text)
		{
			selectAnElement(element).selectByVisibleText(text);
		}
		/**
		 * this method is used to get all the selected elements present in the dropdown
		 * @param element
		 */
		public void AllSelectedOptions(WebElement element)
		{
			selectAnElement(element).getAllSelectedOptions();
		}
		/**
		 * This method is used to get the first selected option
		 * @param element
		 */
		public void getFirstSelectedOption(WebElement element)
		{
			selectAnElement(element).getFirstSelectedOption();
		}
		/**
		 * this method is used to get options present in dropdown
		 * @param element
		 */
		public void getOptions(WebElement element)
		{
			selectAnElement(element).getOptions();
		}
	//	public void javaScript()
		/**
		 * This method is used to scroll to bottom of the page
		 * @param driver
		 * @param x
		 * @param y
		 */
		public void scrollToBottom(WebDriver driver, int x, int y)
		{
			JavascriptExecutor j= (JavascriptExecutor) driver;
			j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		
		/**
		 * This method is used to scroll to top of the page
		 * @param driver
		 * @param x
		 * @param y
		 */
		public void scrollToTop(WebDriver driver)
		{
			JavascriptExecutor j= (JavascriptExecutor) driver;
			j.executeScript("window.scrollTo(0,0)");
		}
		
		/**
		 * This method is used to scroll the page
		 * @param driver
		 * @param x
		 */
		public void scrollHorizontally(WebDriver driver, int x, int y)
		{
			JavascriptExecutor j= (JavascriptExecutor) driver;
			j.executeScript("window.scrollTo(x,y)");
		}
		
		/**
		 * This method is used to scroll to element present in the page vertically
		 * @param driver
		 * @param element
		 * @param x
		 */
		public void scrollToElement(WebDriver driver,WebElement element ,int x)
		{
			JavascriptExecutor j= (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			j.executeScript("window.scrollTo(0,"+y+")");
		}
		
		public static String getScreenShot(WebDriver driver, String screenShot) throws IOException
		{
			TakesScreenshot t = (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			JavaUtils jLib=new JavaUtils();
			String path = "./screenshot/"+screenShot+jLib.getSystemDateInFormat()+".png";
			File dest = new File(path);
			FileUtils.copyFile(src, dest);
			return dest.getAbsolutePath();
		}


	

}
