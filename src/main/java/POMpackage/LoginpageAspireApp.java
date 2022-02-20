package POMpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageAspireApp {
	@FindBy(id="login") private WebElement emailId;
	@FindBy(id="password") private WebElement Password;
	@FindBy(xpath = "//button[@class='btn btn-primary btn-block']") private WebElement LoginButton;

	public LoginpageAspireApp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	public void enteremail(String emailID)
	{
		emailId.sendKeys(emailID);
	}
	 public void enterPassword(String pass)
	 {
		 Password.sendKeys(pass);
	 }
	 public void ClickLoginbutton()
	 {
		 LoginButton.click();
		
	 }

}
