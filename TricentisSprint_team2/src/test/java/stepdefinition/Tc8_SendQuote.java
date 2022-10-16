package stepdefinition;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import pageobjects.SendQuote;
import utilities.Screenshots;


@Test
public class Tc8_SendQuote extends Screenshots{
	WebDriver driver;
	CamperVehicleData cv1;
	CamperInsurantData cv2;
	CamperProductData cv3;
	SelectPriceOption cv4;
	SendQuote cv5;
	WebDriverWait wait;
	@Given("user Enters the valid Vehicle data")
	public void user_enters_the_valid_vehicle_data() {
		startTest();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hp\\git\\repository3\\TricentisSprint_team2\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
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
	
	@Given("user Enters the valid Insurant data")
	public void user_enters_the_valid_insurant_data() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
	
	@Given("user Enters the valid Product data")
	public void user_enters_the_valid_product_data() {
		
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Start Date')]")));
		
		  cv3=new CamperProductData(driver);
		
		  cv3.enterStartDate("11/25/2022");
		  cv3.selectInsuranceSum("5.000.000,00");
		  cv3.selectDamageInsurance("No Coverage");
		  cv3.selectOP("euro");
		  cv3.clickNext();
	    
	}
	
	@Given("user Selects the Price option")
	public void user_selects_the_price_option() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='priceTable']/tbody/tr/td[contains(text(),'Price per Year ($)')]")));
		cv4=new SelectPriceOption(driver);
		cv4.selectPriceOption("Platinum");
		driver.findElement(By.id("sendquote")).click();
	    
	}
	
	@When("User Enters details to send quote")
	public void user_enters_details_to_send_quote() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'E-Mail')]")));
		 cv5=new SendQuote(driver);
		 cv5.enterEmail("deepikam2000@gmail.com");
		 cv5.enterUsername("deepika");
		 cv5.enterPassword("Deepika100");
		 cv5.enterConfirmpassword("Deepika100");
		
	   
	}
	
	@Then("User Receives success alert message")
	public void user_receives_success_alert_message() throws IOException {
		 cv5.clickSendemail();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sweet-alert showSweetAlert visible']//child::h2")));
		 takeScreenshot(driver);
		 String msg=driver.findElement(By.xpath("//div[@class='sweet-alert showSweetAlert visible']//child::h2")).getText();
		 assertEquals("Sending e-mail success!",msg);
		 driver.close();
		 endTest();
		 endReport();
		 
		 
	}

}
