package stepdefinition;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CamperInsurantData;
import utilities.ExcelReader;
import utilities.Screenshots;



@Test
public class Tc4_ValidCamperInsurantData extends Screenshots {
	
	CamperInsurantData cv;
	 WebDriver driver;
	
	@Given("when user is in Tricentis home page")
	public void when_user_is_in_tricentis_home_page() {
		    startTest();
			System.setProperty("webdriver.edge.driver","C:\\Users\\Hp\\git\\repository3\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			cv=new CamperInsurantData(driver);
			
			driver.get("http://sampleapp.tricentis.com/101/index.php");
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Camper")).click();
			driver.findElement(By.linkText("Enter Insurant Data")).click();
			
	}
	@When("he enters insurant data for camper from {string} and {int}")
	public void he_enters_insurant_data_for_camper_from_and(String SheetName, Integer RowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData("D:/file1.xls", SheetName);
		
		
	    String fname=testData.get(RowNumber).get("fname");
	    String lname=testData.get(RowNumber).get("lname");
	    String dob=testData.get(RowNumber).get("dob");
	    String address=testData.get(RowNumber).get("Address");
	    String Country=testData.get(RowNumber).get("Country");
	    String Zipcode=testData.get(RowNumber).get("Zipcode");
	    String Occupation=testData.get(RowNumber).get("Occupation");
	    String Hobbies=testData.get(RowNumber).get("Hobbies");
	    
	    cv.enterfirstname(fname);
	    cv.enterlastname(lname);
	    cv.enterDateOfBirth(dob);
	    cv.enterAddress(address);
	    cv.selectCountry(Country);
	    cv.enterZipcode(Integer.parseInt(Zipcode));
	    cv.selectOccupation(Occupation);
	    cv.selectHobbies(Hobbies);
	    
	    takeScreenshot(driver);
	      
		  
		
		Thread.sleep(3000);
		  
	    
	}
	@Then("he can click on next To enter insurant data")
	public void he_can_click_on_next_to_enter_insurant_data() {
		String a=driver.findElement(By.xpath("//a[@id='enterinsurantdata']//child::span")).getText();
		boolean res=a.equals("0");
		assertEquals(true,res);
		cv.clicknext();
		driver.close();
	    endTest();
	}
  
 
}
