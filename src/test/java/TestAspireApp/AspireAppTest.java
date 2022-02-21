package TestAspireApp;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMpackage.HomepageAspireApp;
import POMpackage.LoginpageAspireApp;
import utility.utilityclass;
@Listeners(Listener.class)
public class AspireAppTest extends base.Baseclass {

	LoginpageAspireApp login;
	HomepageAspireApp home;
	
	@BeforeClass
	public void openbrowser() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Starting the browser", true);
	launchBrowser();
	login = new LoginpageAspireApp(driver);
	 Reporter.log("loging into application", true);
	  	login.enteremail(utilityclass.getdatafromproperty("emailID"));
		login.enterPassword(utilityclass.getdatafromproperty("pass"));	
		login.ClickLoginbutton();
	}
	@AfterClass
	public void logoutapp()
	{
		Reporter.log("loging out from application", true);
		home= new HomepageAspireApp(driver);
		home.logoutfromapp();
		driver.close();
		
	}
	
  @Test
  public void InventoryPage() throws EncryptedDocumentException, IOException {
	 int TCID=01;
	 home= new HomepageAspireApp(driver);
		Reporter.log("Going in inventory page ", true);
		home.clickon_inventory_icon();
	  	driver.findElement(By.xpath("//span[@data-section='120']")).click();
		driver.findElement(By.xpath("//a[@data-section='124']")).click();
		driver.findElement(By.xpath("//button[@title='Create record']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("noodles");
		driver.findElement(By.xpath("//span[text()='Update Quantity']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary o_list_button_add']")).click();
		Reporter.log("Updating qty of newly added product", true);
		WebElement qty = driver.findElement(By.xpath("//input[@name='inventory_quantity']"));
		qty.clear();
		qty.sendKeys("12.00");
		Reporter.log("taking screenshot of inventory Updated qty of newly added product", true);
		utilityclass.screenshot(driver,TCID);
		driver.findElement(By.xpath("//button[@title='Save record']")).click();
		driver.findElement(By.xpath("//a[@title='Home menu']")).click();
  }
  
 @SuppressWarnings("unused")
@Test
  public void ManufacturingPage() throws IOException {
  int TCID=02;
	  home.clickon_manufacturing_icon();
	  driver.findElement(By.xpath("//button[@class='btn btn-primary o_list_button_add']")).click();
		WebElement dd = driver.findElement(By.xpath("(//div//a[@class='o_dropdown_button'])[1]"));
		Actions act =new Actions(driver);
		act.sendKeys(dd, "noodles").build().perform();
//		List<WebElement> ddlist = driver.findElements(By.xpath("(//ul[@tabindex='0'])[1]//li"));
//		String expectedresult= "noodles";
//		for(WebElement w: ddlist)
//		{		
//			String actual = w.getText();				
//			if(actual.equals(expectedresult))
//			{
//				w.click();
//				break;
//			}
//		}
		driver.findElement(By.xpath("((//ul[@tabindex='0'])[1]//li//a[text()='noodles'])[1]")).click();
		WebElement Qty = driver.findElement(By.xpath("(//input[@name='product_qty'])[1]"));
		Qty.clear();
		Qty.sendKeys("12.00");
		WebElement pro = driver.findElement(By.xpath("//input[@name='qty_producing']"));
		pro.clear();
		pro.sendKeys("12.00");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']//span[text()='Ok']")).click();
		driver.findElement(By.xpath("//button[@name='action_confirm']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//button[@type='button']//span[text()='Ok']")).click();
		driver.findElement(By.xpath("//button[@type='button']//span[text()='Apply']")).click();
		driver.findElement(By.xpath("//button[@title='Save record']")).click();
		driver.findElement(By.xpath("//a[@class='dropdown-item o_menu_brand']")).click();
		
		Reporter.log("Validating the qty of newly added product is more than 10 or not?", true);
		String actualqty = driver.findElement(By.xpath("(//span[text()='12.00'])[2]")).getText();
		double qty = Double.parseDouble(actualqty);
		double expectedqty= 10.0;
		if(qty > expectedqty)
		{
			System.out.println("Order qty"+qty+" is more than 10 so test case passed");
		}
		else
		{ 
			System.out.println("Order qty\"+qty+\" is less than 10 so test case failed");
		}
		
}
}
