package stepdefinition;

import static org.testng.Assert.assertEquals;

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
import pageobjects.CamperVehicleData;
import utilities.ExcelReader;
import utilities.Screenshots;


@Test
public class Tc2_ValidCamperVehicleData extends Screenshots {
 
	CamperVehicleData cv;
	 WebDriver driver;

	 
	
	@Given("when user is in Tricentis Home page")
	public void when_user_is_in_tricentis_home_page() {
		startTest();
		System.setProperty("webdriver.edge.driver","C:\\Users\\Hp\\OneDrive\\Documents\\selenium\\selenium demo\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		cv=new CamperVehicleData(driver);
		
	   
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Camper")).click();
	    
	}
	@When("he enters vehicle data for camper from {string} and {int}")
	public void he_enters_vehicle_data_for_camper_from_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData("D:/file1.xls", SheetName);
		
		
	    String make=testData.get(RowNumber).get("make");
	    String Eperformance=testData.get(RowNumber).get("Eperformance");
	    String dom=testData.get(RowNumber).get("dom");
	    String seats=testData.get(RowNumber).get("seats");
	    String fuel=testData.get(RowNumber).get("fuel");
	    String payload=testData.get(RowNumber).get("payload");
	    String totalweight=testData.get(RowNumber).get("totalweight");
	    String listprice=testData.get(RowNumber).get("listprice");
	    String license=testData.get(RowNumber).get("license");
	    String mileage=testData.get(RowNumber).get("mileage");
	    
	      cv.selectMake(make);
		  cv.enterDateOfManufacture(dom);
		  cv.enterEnginePerformance(Integer.parseInt(Eperformance));
		  cv.selectSeats(Integer.parseInt(seats));
		  cv.selectFuelType(fuel);
		  cv.enterPayload(Integer.parseInt(payload));		  
		  cv.enterTotalWeight(Integer.parseInt(totalweight));		  
		  cv.enterListPrice(Integer.parseInt(listprice));		 
		  cv.enterLicensePlateNumber(license);
		  cv.enterAnnualMileage(Integer.parseInt(mileage));
		  
		  takeScreenshot(driver);
		  Thread.sleep(3000);
		  String a=driver.findElement(By.xpath("//a[@id='entervehicledata']//child::span")).getText();
		  boolean res=a.equals("0");
		  assertEquals(true,res);  
		  
	    
	    
	    
	}
	@Then("he can click on next to enter insurant data")
	public void he_can_click_on_next_to_enter_insurant_data() {
		
	    driver.close();
	    endTest();
	 
		
		
	
	    
	}
}
