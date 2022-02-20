package POMpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageAspireApp {
	
	@FindBy(xpath = "//div[text()='Inventory']") private WebElement inventory;
	@FindBy(xpath = "//div[text()='Manufacturing']") private WebElement manufacturing;
	public HomepageAspireApp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	//methods used to give definitions to 
	public void clickon_inventory_icon()
	{
		inventory.click();
	}
	public void clickon_manufacturing_icon()
	{
		manufacturing.click();
	}
	
	
}
