package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CamperVehicleData {
	
	
	
	@FindBy(id="make")
	WebElement make;

	@FindBy(id="engineperformance")
	WebElement enginePerformance;
	
	@FindBy(id="dateofmanufacture")
	WebElement dateOfManufacture;
	
	@FindBy(id="numberofseats")
	WebElement seats;
	
	@FindBy(id="fuel")
	WebElement fuel;
	
	@FindBy(id="payload")
	WebElement payload;
	
	@FindBy(id="totalweight")
	WebElement totalWeight;
	
	@FindBy(id="listprice")
	WebElement listPrice;
	
	@FindBy(id="licenseplatenumber")
	WebElement licensePlateNumber;
	
	@FindBy(id="annualmileage")
	WebElement annualMileage;
	
	
	
	@FindBy(id="nextenterinsurantdata")
	WebElement next;
	
	WebDriver driver;
	public CamperVehicleData(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void selectMake(String s) {
		Select Make1=new Select(make);
		Make1.selectByVisibleText(s);
	}
  
	
	public void enterEnginePerformance(int n) {
		enginePerformance.sendKeys(""+n);
				
	}
	
	
	public void enterDateOfManufacture(String s) {
				dateOfManufacture.sendKeys(s);
	}
	
	public void selectSeats(int n) {
		Select Seats1=new Select(seats);
		Seats1.selectByVisibleText(""+n);
	}
	

	
	public void selectFuelType(String s) {
		Select Fuel1=new Select(fuel);
		Fuel1.selectByVisibleText(s);
	}
	
	public void enterPayload(int n) {
		
		payload.sendKeys(""+n);
		}
	
	public void enterTotalWeight(int n) {
		
		totalWeight.sendKeys(""+n);
		
	}
	
	
	public void enterListPrice(int n) {
		
		listPrice.sendKeys(""+n);
		
	}
	
	public void enterLicensePlateNumber(String s) {
	
		licensePlateNumber.sendKeys(s);
	}
	
	
	public void enterAnnualMileage(int n) {
		
		annualMileage.sendKeys(""+n);
		
		
	}
	
	public void clicknext() {
		next.click();
		
	}
	
	
	
	
	
	

}
