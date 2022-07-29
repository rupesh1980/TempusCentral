package companyDetailsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class deleteSelctedLocation {
	public WebDriver driver;
	 
	  private By locationName=By.id("txtLocationName");
	  private By delete=By.xpath("//i[@class=\'la la-trash icon-lg mt-1 mr-2\']");
	  private By yes=By.id("YesDeleteLocation");
	  
	  
	 public deleteSelctedLocation(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	
	 public WebElement clickDelete()
	 {
		 return driver.findElement(delete);
	 }
	 public WebElement clickYes()
	 {
		 return driver.findElement(yes);
	 }
	 
}
