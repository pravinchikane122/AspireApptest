package TestAspireApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener
{
	
	int TCID;
	WebDriver driver;
	
	public void onTestFailure(ITestResult result)
	{
		
		System.out.println("TC failed please try again for "+result.getMethod().getMethodName());
				
		try 
		{
			utility.utilityclass.screenshot(driver, TCID);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result) 
	{		
		System.out.println("TC skipped please check code "+result.getMethod().getMethodName());
		
	}
}
