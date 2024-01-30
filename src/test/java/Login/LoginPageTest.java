package Login;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
@Listeners(genericUtility.ListenerImpclass.class)
public class LoginPageTest extends BaseClass
{
	@Test
	public void  Login() throws IOException
	{
	
	System.out.println("method running");
	//Assert.fail();
	System.out.println("========running");
	//driver.findElement(By.xpath("//h5[text()='Ready to Leave?']/../..//div[@class=\"modal-footer\"]//a[text()='Logout']")).click();	
	}

}
