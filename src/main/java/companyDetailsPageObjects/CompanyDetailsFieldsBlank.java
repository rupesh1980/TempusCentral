package companyDetailsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyDetailsFieldsBlank {
	public WebDriver driver;
	 private By companyLocations=By.xpath("//*[contains(text(),\' Company Locations\')]");
	  private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	  private By add=By.id("btnLocationSave");
	  
	 public CompanyDetailsFieldsBlank(WebDriver driver)
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
	
}
