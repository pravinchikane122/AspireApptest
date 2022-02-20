package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utilityclass 
{
	
	public static String getdatafromproperty(String key) throws EncryptedDocumentException, IOException
	{
		Properties prop = new Properties();
		FileInputStream myfile = new FileInputStream("C:\\Users\\hghh\\eclipse-workspace\\AspireApptest\\aspirertestdata.properties");
		prop.load(myfile);
		String value = prop.getProperty(key);
		return value;			
	}
	
	public static void screenshot(WebDriver driver, int TCID) throws IOException
	{		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\PRAVIN\\Companies\\Aspire\\QA challange\\Aspire data\\aspireappscreenshots\\Testcase"+TCID+".png");
		FileHandler.copy(src, dest);
	}
	
}
