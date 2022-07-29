package companyDetails;

import java.io.IOException;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;

import AccountDetailsPageObjects.loginPageObjects;
import TempsusCentralAccountDetails.AccountAddDeleteNewFields;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import companyDetailsPageObjects.addLocation;

public class reset extends LoginPageSetup{
  
	public WebDriver driver;
	WebDriverWait wait;
     private By companyLocation=By.xpath("//*[contains(text(),\'Company Locations\')]");
	  private By timeZone=By.id("DropTimeZone");
	  private By reset=By.id("btnLocationReset");

	
	//  protected By addoptions=By.id("AddOptions");
     @BeforeTest
     public void executebrowser() throws IOException
     {
    	 driver=browserSetup();
    	
     }
	@SuppressWarnings("unused")
	@Test(priority=1,enabled=true)
	public void login() throws InterruptedException, IOException
	{
	    try {
		
	    	 driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
			loginPageObjects lp=new loginPageObjects(driver);
			lp.getUsername().sendKeys(prop.getProperty("username"));
			//log.info("User has entered username");
			//System.out.println(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
			//log.info("User has entered password");
			lp.login().click();
		    Thread.sleep(5000);
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	@Test(priority=2,enabled=true)
	public void allFieldsAreBlank() throws InterruptedException
	{
		CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);
		Thread.sleep(2000);
	    cd.clickMaster().click();
	    cd.clickCompanyDetails().click();
	    cd.clickAddButton().click();
	    addLocation al=new addLocation(driver);
	    al.sendDatatoLocationName().sendKeys("location 8");
	    Select timezone=new Select(driver.findElement(timeZone));
	    timezone.selectByValue("-11:30");
	    driver.findElement(reset).click();
	    Thread.sleep(3000);
	    
	}	  
	@AfterTest(enabled=true)
	public void teardown()
	{
		driver.close();
	}
}
	
	 
