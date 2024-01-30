package TestNG;

import org.testng.annotations.Test;

public class dataProviderExecution 
{
	@Test(dataProviderClass = dataprovider.class ,dataProvider = "abc")
	public void excelTest(String src , String dest)
	{
		System.out.println(src+"----->"+dest);
	}

}
