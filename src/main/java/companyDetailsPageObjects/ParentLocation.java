package companyDetailsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParentLocation {
	public WebDriver driver;
	 private By companyLocations=By.xpath("//*[contains(text(),\' Company Locations\')]");
	  private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	  private By add=By.id("btnLocationSave");
	  private By latitudelongitude=By.id("txtLatitude");
	  private By range=By.xpath("//button[@class=\'btn btn-secondary bootstrap-touchspin-up \']");
	  private By locationname=By.id("txtLocationName");
	  private By dropdown=By.id("DropLocationCode");
	  private By timeZone=By.id("DropTimeZone");
	  
	 public ParentLocation(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 public WebElement clickMaster()
	 {
		 return driver.findElement(master);
	 }
	
	 public WebElement clickCompanyDetails()
	 {
		 return driver.findElement(companyLocations);
	 }
	 public WebElement clickAddButton()
	 {
		 return driver.findElement(add);
	 }
	 public WebElement sendDatatoLatitudeLongitude()
	 {
		 return driver.findElement(latitudelongitude);
	 }
	 public WebElement clickRange()
	 {
		 return driver.findElement(range);
	 }
	 public WebElement sendDatatoLocationName()
	 {
		 return driver.findElement(locationname);
	 }
	 public WebElement selectDropDown()
	 {
		 return driver.findElement(dropdown);
	 }
	 public WebElement selectTimeZone()
	 {
		 return driver.findElement(timeZone);
	 }
	
	
}
