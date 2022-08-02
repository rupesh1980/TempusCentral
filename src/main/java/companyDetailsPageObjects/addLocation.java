package companyDetailsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addLocation {
	public WebDriver driver;
	 private By companyLocations=By.xpath("//*[contains(text(),\' Company Locations\')]");
	  private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	  private By add=By.id("btnLocationSave");
	  private By locationName=By.id("txtLocationName");
	  private By clickadd=By.id("btnAddLocationWithRole");
	  
	  private By clickEmpAdd=By.xpath("//*[@id=\'tblEmployeeList_wrapper\']/div[1]/div[1]/div/table/thead/tr/th[1]/label/span");

	  
	 public addLocation(WebDriver driver)
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
	 public WebElement sendDatatoLocationName()
	 {
		 return driver.findElement(locationName);
	 }
	 public WebElement clickAdd()
	 {
		 return driver.findElement(clickadd);
	 }
	 public WebElement clickEmpAdd()
	 {
		 return driver.findElement(clickEmpAdd);
	 }
	 
}
