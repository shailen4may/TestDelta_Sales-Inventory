package TestNG;

import org.testng.annotations.Test;

public class PracticeTestNG_Test{
	@Test(enabled = false )
	public  void createTest()
	{
		System.out.println("-----createTest-----");
	}
	@Test(dependsOnMethods = "createTest")
	public void editTest()
	{
		System.out.println("-----editTest-----");
	}
	@Test(priority = -1)
	public void deleteTest()
	{
		System.out.println("-----deleteTest-----");
	}
}