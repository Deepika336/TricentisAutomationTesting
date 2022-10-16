package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendQuote {
WebDriver driver;
	
	public SendQuote(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="email")
	WebElement email;
	
	public void enterEmail(String s)
	{
		email.sendKeys(s);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	public void enterUsername(String s)
	{
		username.sendKeys(s);
	}
	
	@FindBy(id="password")
	WebElement password;
	
	public void enterPassword(String s)
	{
		password.sendKeys(s);
	}
	
	@FindBy(id="confirmpassword")
	WebElement confirmpassword;
	
	public void enterConfirmpassword(String s)
	{
		confirmpassword.sendKeys(s);
	}
	
	@FindBy(id="sendemail")
	WebElement sendemail;
	
	public void clickSendemail()
	{
		sendemail.click();
	}

}
