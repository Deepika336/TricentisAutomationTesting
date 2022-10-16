package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CamperInsurantData {
	
@FindBy(linkText="Enter Insurant Data")
WebElement btn;

@FindBy(id="firstname")
WebElement fname;

@FindBy(id="lastname")
WebElement lname;

@FindBy(id="birthdate")
WebElement DOB;

@FindBy(id="streetaddress")
WebElement address;

@FindBy(id="country")
WebElement country;

@FindBy(id="zipcode")
WebElement zipcode;

@FindBy(id="occupation")
WebElement occupation;

@FindBy(xpath="//input[@id='cliffdiving']//following::span[@class='ideal-check']")
WebElement cliff;

@FindBy(xpath="//input[@id='speeding']//following::span[@class='ideal-check']")
WebElement speeding;

@FindBy(xpath="//input[@id='bungeejumping']//following::span[@class='ideal-check']")
WebElement bungee;

@FindBy(xpath="//input[@id='skydiving']//following::span[@class='ideal-check']")
WebElement skyDiving;

@FindBy(xpath="//input[@id='skydiving']//following::span[@class='ideal-check']")
WebElement other;

@FindBy(id="nextenterproductdata")
WebElement next;

WebDriver driver;

public CamperInsurantData(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void clickInsurantData() {
	btn.click();
	
}
public void enterfirstname(String s) {
	fname.sendKeys(s);
}

public void enterlastname(String s) {
	lname.sendKeys(s);
}


public void enterDateOfBirth(String s) {
	DOB.sendKeys(s);
}

public void enterAddress(String address1) {
	address.sendKeys(address1);
	
}
public void selectCountry(String s) {
	Select Country1=new Select(country);
	Country1.selectByVisibleText(s);
}


public void enterZipcode(int n) {
	
	zipcode.sendKeys(""+n);
}

public void selectOccupation(String s) {
	Select Occupation1=new Select(occupation);
	Occupation1.selectByVisibleText(s);
}

public void selectHobbies(String hobbies) {
	if(hobbies.equals("cliffdiving")) {
	    cliff.click();
	    }
	if(hobbies.equals("speeding")) {
		speeding.click();
		}
	if(hobbies.equals("bungeejumping")) {
		bungee.click();
		}
	if(hobbies.equals("skydiving")) {
		skyDiving.click();
		}
	if(hobbies.equals("other")) {
		other.click();
		}
	
	
}

public void clicknext() {
	next.click();
}

}
