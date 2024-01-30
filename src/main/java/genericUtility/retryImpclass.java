package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryImpclass implements IRetryAnalyzer
{
	int count=0;
	int retrycount=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}
}
