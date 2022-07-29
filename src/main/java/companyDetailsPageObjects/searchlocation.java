package companyDetailsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchlocation {
	public WebDriver driver;
	 private By search=By.id("txtSearchlist");
	  
	 public searchlocation(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 public WebElement sendlocation()
	 {
		 return driver.findElement(search);
	 }
	
	 
	
}
