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

public class Addlocation extends LoginPageSetup{
  
	public WebDriver driver;
	WebDriverWait wait;
     private By companyLocation=By.xpath("//*[contains(text(),\'Company Locations\')]");
	  private By timeZone=By.id("DropTimeZone");
	  private By clickadd=By.id("btnAddLocationWithRole");
	  private By clickEmpAdd=By.xpath("//*[@id=\'tblEmployeeList_wrapper\']/div[1]/div[1]/div/table/thead/tr/th[1]/label/span");
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
	@Test(priority=2,enabled=true,invocationCount = 2)
	public void addLocation() throws InterruptedException
	{
		int i=1;
		CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);
	    cd.clickMaster().click();
	    cd.clickCompanyDetails().click();
	    addLocation al=new addLocation(driver);
	    al.sendDatatoLocationName().sendKeys("location "+i);
	    i=i+1;
	    Select timezone=new Select(driver.findElement(timeZone));
	    timezone.selectByValue("-11:30");
	    al.clickAddButton().click();
	    Thread.sleep(2000);
	    al.clickEmpAdd().click();
	    Thread.sleep(2000);
	    al.clickAdd().click();
	    
	}	  
	@AfterTest(enabled=true)
	public void teardown()
	{
		driver.close();
	}
}
	
	 
