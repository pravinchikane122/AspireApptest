package base;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utility.utilityclass;


public class Baseclass 
{
	public WebDriver driver=null;
	
	public void launchBrowser() throws EncryptedDocumentException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\PRAVIN\\Companies\\Aspire\\QA challange\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions closenotifications = new ChromeOptions().addArguments("--disable-notifications");
		driver=new ChromeDriver(closenotifications);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(utilityclass.getdatafromproperty("URL"));
				
	}
	
}
