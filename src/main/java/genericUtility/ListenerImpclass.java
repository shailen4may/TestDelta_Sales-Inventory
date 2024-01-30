package genericUtility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpclass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//testscript execution starts from here 
		String Methodname = result.getMethod().getMethodName();
		report.createTest(Methodname);
		Reporter.log(Methodname+"Execution started ",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, Methodname+"Passed");
		Reporter.log(Methodname+"Executed successfully",true);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
//		String name = result.getName();
//		//WebDriver driver;
//		TakesScreenshot t = (TakesScreenshot)BaseClass.sdriver;
//		File src = t.getScreenshotAs(OutputType.FILE);
//		String path = "./ScreenShot/"+name+jLib.getSystemDateInFormat()+".png";
//		File dest = new File(path);
		String Methodname = result.getMethod().getMethodName();

		try {
			//FileUtils.copyFile(src, dest);
			//WebDriverUtiliy wLib= new WebDriverUtiliy();
			String path1 = WebDriverUtiliy.getScreenShot(BaseClass.sdriver, Methodname);
			test.addScreenCaptureFromPath(path1);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			}
		test.log(Status.FAIL,Methodname+"Failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(Methodname+"---> Failed ");
		}
	@Override
	public void onTestSkipped(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, Methodname+"skipped ");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(Methodname+"---> Skipped ");
	}

	@Override
	public void onStart(ITestContext context) 
	{
		//configure report
		JavaUtils jLib= new JavaUtils();
		ExtentSparkReporter htmlreport= new ExtentSparkReporter(".//extentReport//report"+jLib.getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("SDET-53");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("DeltaNegocio");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Platform", "OS");
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base-Url", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		report.setSystemInfo("ReporterName", "Shailendra");

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
