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
import pageobjects.CamperProductData;
import pageobjects.HomePage;
import utilities.ExcelReader;
import utilities.Screenshots;



@Test
public class Tc5_ValidCamperProductData extends Screenshots {
	WebDriver driver;
	HomePage h;
	CamperProductData pd;
	@Given("when user is in Tricentis home Page")
	public void when_user_is_in_tricentis_home_page() {
		startTest();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Hp\\OneDrive\\Documents\\selenium\\selenium demo\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		driver.manage().window().maximize();
		h=new HomePage(driver);
		
	}
	@When("he enters product data for camper from {string} and {int}")
	public void he_enters_product_data_for_camper_from_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData("D:/file1.xls", SheetName);
		
		
	    String date=testData.get(RowNumber).get("date");
	    String sum=testData.get(RowNumber).get("sum");
	    String damage=testData.get(RowNumber).get("damage");
	    String op=testData.get(RowNumber).get("op");
	    
		
		
		
		  h.clickCamper();
		  pd=new CamperProductData(driver);
		  pd.clickProductData();		
		  pd.enterStartDate(date);
		  pd.selectInsuranceSum(sum);
		  pd.selectDamageInsurance(damage);
		  pd.selectOP(op);
		  takeScreenshot(driver);
		  
		  Thread.sleep(3000);
		  String a=driver.findElement(By.xpath("//a[@id='enterproductdata']//child::span")).getText();
		  boolean res=a.equals("0");
		  assertEquals(true,res); 
	}
	@Then("he can click on next To Enter insurant data")
	public void he_can_click_on_next_to_enter_insurant_data() {
		pd.clickNext();
	   driver.close();
	   endTest();
       
	   
	}

  
}
