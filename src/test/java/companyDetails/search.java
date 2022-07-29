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
import companyDetailsPageObjects.ParentLocation;
import companyDetailsPageObjects.addLocation;
import companyDetailsPageObjects.searchlocation;

public class search extends LoginPageSetup{
  
	public WebDriver driver;
	WebDriverWait wait;
     private By companyLocation=By.xpath("//*[contains(text(),\'Company Locations\')]");
	  private By timeZone=By.id("DropTimeZone");
	  private By latitudelongigute=By.id("txtLatitude");
	  private By range=By.xpath("//i[@class=\'ki ki-arrow-up\']");
	  private By search=By.xpath("//a[@class=\'jstree-anchor jstree-search\']");
	  private By save=By.id("btnLocationSave");
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
	public void search() throws InterruptedException
	{
		CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);
	    Thread.sleep(2000);
		cd.clickMaster().click();
		cd.clickCompanyDetails().click();
	    Thread.sleep(2000);

		searchlocation sl=new searchlocation(driver);
		sl.sendlocation().sendKeys("location 3");
	    Thread.sleep(2000);
	  /*  List<WebElement> locations=driver.findElements(By.xpath("//a[@class=\'jstree-anchor\']"));
	    for(WebElement listlocations:locations)
	    {
	    	if(listlocations.getText().equalsIgnoreCase("location 3"))
	    	{
	    		listlocations.click();
	    		break;
	    	}*/
	    driver.findElement(search).click();
	    driver.findElement(save).click();
	    		
	}	  
	@AfterTest(enabled=true)
	public void teardown()
	{
		
		driver.close();
	}
}
	
	 
