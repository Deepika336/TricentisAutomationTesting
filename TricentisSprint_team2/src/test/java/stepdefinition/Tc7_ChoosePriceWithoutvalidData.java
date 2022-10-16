package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import utilities.Screenshots;


@Test
public class Tc7_ChoosePriceWithoutvalidData extends Screenshots {
	HomePage h;
	WebDriver driver;
	@Given("when user is in HOME PAGE")
	public void when_user_is_in_home_page() {
		startTest();
		System.setProperty("webdriver.edge.driver","C:\\Users\\Hp\\git\\repository3\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		driver.manage().window().maximize();
	    h=new HomePage(driver);
	   
	}
	
	@Given("user clicks on Camper")
	public void user_clicks_on_camper() {
		 h.clickCamper();
	}
	
	@When("User selects Price option for Camper")
	public void user_selects_price_option_for_camper() throws IOException {
	    driver.findElement(By.xpath("//nav[@id='idealsteps-nav']//child::li//child::a[@id='selectpriceoption']")).click();
	    takeScreenshot(driver);
	}
	
	@Then("User cannot view Price Table")
	public void user_cannot_view_price_table() {
		
		boolean res=driver.findElement(By.xpath("//table[@id='priceTable']/tbody/tr/td[contains(text(),'Price per Year ($)')]")).isDisplayed();
		assertEquals(false,res);
	    driver.close();
	    endTest();
	   
	}
}
