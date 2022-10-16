package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


@FindBy(linkText="Automobile")
WebElement Automobile;

@FindBy(linkText="Truck")
WebElement Truck;

@FindBy(linkText="Motorcycle")
WebElement Motorcycle;

@FindBy(linkText="Camper")
WebElement Camper;

@FindBy(id="tricentis_resources")
WebElement resources;


public WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public boolean clickAutomobile() {
	
	Automobile.click();
	return driver.findElement(By.xpath("//span[text()='Automobile Insurance']")).isDisplayed();
}
public boolean clickTruck() {
	
	Truck.click();
	return driver.findElement(By.xpath("//span[text()='Truck Insurance']")).isDisplayed();
}
public boolean clickMotorcycle() {
	
	Motorcycle.click();
	return driver.findElement(By.xpath("//span[text()='Motorcycle Insurance']")).isDisplayed();
}
public boolean clickCamper() {
	
	Camper.click();
	return driver.findElement(By.xpath("//span[text()='Camper Insurance']")).isDisplayed();
}
public boolean clickresources()
{
	
	resources.click();	
	return driver.findElement(By.xpath("//h1[text()='Resources']")).isDisplayed();
}
}
