package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CamperProductData {
	
	WebDriver driver;
	@FindBy(id="enterproductdata")
	WebElement product;
	
	@FindBy(id="startdate")
	WebElement DOS;
	
	@FindBy(id="insurancesum")
	WebElement sum;
	
	@FindBy(id="damageinsurance")
	WebElement damage;
	
	 @FindBy(xpath="//input[@id='EuroProtection']//following::span[@class='ideal-check']")
	 WebElement euroProtection;
	 
	 @FindBy(xpath="//input[@id='LegalDefenseInsurance']//following::span[@class='ideal-check']")
	 WebElement legalDefence;
	
	@FindBy(id="nextselectpriceoption")
	WebElement next;
	
	
	
	public  CamperProductData(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickProductData() {
		product.click();
	}
	
	public void enterStartDate(String s) {
		DOS.sendKeys(s);
		}
	
	public void selectInsuranceSum(String s)
	{
	Select sum1 =new Select(sum);
		sum1.selectByVisibleText(s);
	}
	
	public void selectDamageInsurance(String s)
	{
	Select ds =new Select(damage);
		ds.selectByVisibleText(s);
	}
	
	public void selectOP(String OP)
	{
		if(OP.equals("euro")) {
		euroProtection.click();
		}
		if(OP.equals("legal")) {
			legalDefence.click();
			}
		
	}
	public void clickNext() {
		next.click();
		
	}

}
