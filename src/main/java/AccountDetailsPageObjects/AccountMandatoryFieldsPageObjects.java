package AccountDetailsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountMandatoryFieldsPageObjects {
	 public WebDriver driver;
	 protected By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
     protected By EditDetails=By.id("btnCompanyform");
     protected By accountdetails=By.xpath("//*[contains(text(),\' Account Details\')]");
     protected By companyname=By.id("txtCompanyName");     
     protected By emailId=By.id("txtEmailId");
     protected By update=By.xpath("//input[@id=\'btnUpdateCompany\']");
	  protected By uploadexcel=By.xpath("//*[@id=\'toast-container\']/div/div");

     
    public AccountMandatoryFieldsPageObjects(WebDriver driver)
    {
    	this.driver=driver;
    }
    public WebElement companyName()    
    {
		return driver.findElement(companyname);
    	
    }
    public WebElement emailid()    
    {
		return driver.findElement(emailId);
    	
    }
    public WebElement clickUpdate()    
    {
		return driver.findElement(update);
    	
    }
    public WebElement clickUploadExcel()    
    {
		return driver.findElement(uploadexcel);
    	
    }
}
