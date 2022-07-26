package companyDetails;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import companyDetailsPageObjects.deleteSelctedLocation;

public class deleteLocation extends LoginPageSetup{
  
	public WebDriver driver;
	WebDriverWait wait;
   

	
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
	public void locationDelete() throws InterruptedException
	{
		CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);
		deleteSelctedLocation dl=new deleteSelctedLocation(driver);
	    cd.clickMaster().click();
	    cd.clickCompanyDetails().click();
	    Thread.sleep(3000);
		List<WebElement> locations=driver.findElements(By.xpath("//a[@role=\'treeitem\']"));
		for(WebElement listlocations:locations)
		{
			
			if(listlocations.getText().equalsIgnoreCase("location 8"))
			{
			    listlocations.click();
				dl.clickDelete().click();
				Thread.sleep(2000);
				dl.clickYes().click();
				Thread.sleep(2000);
			}
		}
	    
	}	  
	@AfterTest(enabled=true)
	public void teardown()
	{
		driver.close();
	}
}
	
	 
