package TestNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annotationsPractice 
{
	
	@BeforeMethod
	public void bMethod4() {
		System.out.println("beforemethod4 is running");

	}
	@BeforeSuite
	public void dbConn()
	{
		System.out.println("DB conn is running");
	}
	@BeforeTest
	public void btest1()
	{
		System.out.println("BeforeTest1  is running");
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("BC is running");
	}
	@BeforeMethod
	public void method()
	{
		System.out.println("Bmethod1 is running");
	}
	@Test
	public void test2()
	{
		System.out.println("test2 is running");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("After class is running");
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("after method is running");
	}
	@Test
	public void test3()
	{
		System.out.println("test3 is running");
	}
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("after suite is running");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("after test is running");
	}
	@BeforeClass
	public void class2()
	{
		System.out.println("class2 is running");
	}
	@Test
	public void test()
	{
		System.out.println("test is running");
	}
@BeforeMethod
public void bMethod2() {
	System.out.println("beforemethod3 is running");

}

	@BeforeTest
	public void btest2()
	{
		System.out.println("before test2 is running");
	}
	@BeforeClass
	public void bclass2()
	{
		System.out.println("before class 2 is running");
	}
	@BeforeMethod
	public void bMethod() {
		System.out.println("beforemethod2 is running");

	}

}
