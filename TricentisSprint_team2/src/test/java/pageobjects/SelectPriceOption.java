package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SelectPriceOption {
	
	 @FindBy(xpath="//input[@id='selectsilver']//following::span[@class='ideal-radio']")
	 WebElement silver;
	 
	 @FindBy(xpath="//input[@id='selectgold']//following::span[@class='ideal-radio']")
	 WebElement gold;
	 
	 @FindBy(xpath="//input[@id='selectplatinum']//following::span[@class='ideal-radio']")
	 WebElement platinum;
	 
	 @FindBy(xpath="//input[@id='selectultimate']//following::span[@class='ideal-radio']")
	 WebElement ultimate;
	 
	 @FindBy(id="nextsendquote")
	 WebElement next;
	 
	 WebDriver driver;

	 public SelectPriceOption(WebDriver driver) {
	 	this.driver=driver;
	 	PageFactory.initElements(driver,this);
	 }
	 
	 public void selectPriceOption(String option) {
		 if(option.equals("Silver")) {
			 silver.click();
		 }
		 if(option.equals("Gold")) {
			 gold.click();
		 }
		 if(option.equals("Platinum")) {
			 platinum.click();
		 }
		 if(option.equals("Ultimate")) {
			 ultimate.click();
		 }
		 
	 }
	 
	 public void clickNextBtn() {
		 next.click();
			
		}

	 
	 
	 

}
