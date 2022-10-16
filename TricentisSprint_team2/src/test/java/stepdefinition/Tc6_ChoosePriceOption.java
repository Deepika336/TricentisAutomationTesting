package stepdefinition;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CamperInsurantData;
import pageobjects.CamperProductData;
import pageobjects.CamperVehicleData;
import pageobjects.SelectPriceOption;
import utilities.Screenshots;




@Test
public class Tc6_ChoosePriceOption extends Screenshots {
	WebDriver driver;
	CamperVehicleData cv1;
	CamperInsurantData cv2;
	CamperProductData cv3;
	SelectPriceOption cv4;
	WebDriverWait wait;
	
	
  
	
	@Given("when user enters valid vehicle data")
	public void when_user_enters_valid_vehicle_data() throws IOException {
		startTest();
		System.setProperty("webdriver.edge.driver","C:\\Users\\Hp\\git\\repository3\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		driver.manage().window().maximize();		
		driver.findElement(By.linkText("Camper")).click();
		
		cv1=new CamperVehicleData(driver);
		 
		  cv1.selectMake("Opel");
		  cv1.enterDateOfManufacture("09/27/2020");
		  cv1.enterEnginePerformance(344);
		  cv1.selectSeats(4);
		  cv1.selectFuelType("Petrol");
		  cv1.enterPayload(300);
		  cv1.enterTotalWeight(400);
		  cv1.enterListPrice(550);
		  cv1.enterLicensePlateNumber("KA-19-5678");
		  cv1.enterAnnualMileage(2000);
		  cv1.clicknext();
	    
	}
	
	@Given("user enters valid insurant data")
	public void user_enters_valid_insurant_data() throws InterruptedException {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'First Name')]")));
		    cv2=new CamperInsurantData(driver);
		    cv2.enterfirstname("Deepika");
		    cv2.enterlastname("mm");
		    cv2.enterDateOfBirth("05/01/2000");
		    cv2.enterAddress("Mangalore");
		    cv2.selectCountry("India");
		    cv2.enterZipcode(575006);
		    cv2.selectOccupation("Employee");
		    cv2.selectHobbies("cliffdiving");
		    cv2.clicknext();
		
	   
	}
	
	@Given("user enters valid product data")
	public void user_enters_valid_product_data() throws InterruptedException{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Start Date')]")));
		
		cv3=new CamperProductData(driver);
		
		 cv3.enterStartDate("11/25/2022");
		  cv3.selectInsuranceSum("5.000.000,00");
		  cv3.selectDamageInsurance("No Coverage");
		  cv3.selectOP("euro");
		  cv3.clickNext();
		
		
	}

	@When("User selects price option for camper")
	public void user_selects_price_option_for_camper() throws InterruptedException, IOException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='priceTable']/tbody/tr/td[contains(text(),'Price per Year ($)')]")));
		cv4=new SelectPriceOption(driver);
		cv4.selectPriceOption("Platinum");
		takeScreenshot(driver);
		
		Thread.sleep(2000);
		String a=driver.findElement(By.xpath("//a[@id='selectpriceoption']//child::span")).getText();
		boolean res=a.equals("0");
		assertEquals(true,res);  
	
		
		
		
	}
	
	@Then("User navigates To Send Quote window of Camper")
	public void user_navigates_to_send_quote_window_of_camper() {
		cv4.clickNextBtn();
		driver.close();
		endTest();
	   
	    
	}
}
