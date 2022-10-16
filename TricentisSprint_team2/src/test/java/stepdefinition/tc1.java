package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import utilities.Screenshots;

@Test
public class tc1 extends Screenshots{
  
	HomePage home;
	 boolean result;
	 WebDriver driver;
	
	
	@Given("user is in Tricentis Home page")
	public void user_is_in_tricentis_home_page() {
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\Hp\\git\\repository3\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		 
		startReport();
		startTest();
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		driver.manage().window().maximize();
		home=new HomePage(driver);	
	}

	
	@When("User clicks on Camper")
	public void user_clicks_on_camper() throws IOException {
	
		 result=home.clickCamper();	
		 takeScreenshot(driver);
		 assertEquals(true, result);	
		 
		
	}
	@Then("User reaches Enter Vehicle Data Page of Camper")
	public void user_reaches_enter_vehicle_data_page_of_camper() throws IOException {
		
				
		driver.close();
		endTest();
		
}
}
