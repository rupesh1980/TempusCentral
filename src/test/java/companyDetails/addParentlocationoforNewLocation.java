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

public class addParentlocationoforNewLocation extends LoginPageSetup{
  
	public WebDriver driver;
	WebDriverWait wait;
     private By companyLocation=By.xpath("//*[contains(text(),\'Company Locations\')]");
	  private By timeZone=By.id("DropTimeZone");
	  private By latitudelongigute=By.id("txtLatitude");
	  private By range=By.xpath("//i[@class=\'ki ki-arrow-up\']");
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
		    Thread.sleep(2000);
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	@Test(priority=2,enabled=true)
	public void seleetParentLocationfirttime() throws InterruptedException
	{
		CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);
		ParentLocation spl=new ParentLocation(driver);
	    cd.clickMaster().click();
	    cd.clickCompanyDetails().click();
	    cd.clickAddButton().click();
	    addLocation al=new addLocation(driver);
	   
	    List<WebElement> locations=driver.findElements(By.xpath("//a[@class=\'jstree-anchor\']"));
	    for(WebElement listlocation:locations)
	    	
	   {
	   	if(listlocation.getText().equalsIgnoreCase("location 14"))
	   	{
	    		listlocation.click();
	    	}
	    }
	   
	    Thread.sleep(2000);
	    spl.sendDatatoLatitudeLongitude().clear();
	    spl.sendDatatoLatitudeLongitude().sendKeys("200");	   
	    driver.findElement(By.id("DropLocationCode")).click();
	    Thread.sleep(2000);
	    List<WebElement> locations2=driver.findElements(By.xpath("//span[@class=\'comboTreeItemTitle selectable\']"));
	    for(WebElement listlocations:locations2)
	    	
	   {
	    	if(listlocations.getText().equalsIgnoreCase("location 15"))
	    	{
	    		listlocations.click();
	    	}
	    }
		   spl.clickRange().click();
		 //   spl.sendDatatoLocationName().sendKeys("location 9");	 
		   // spl.selectDropDown().click();
		 //   Thread.sleep(2000);
	   Select timezone=new Select(driver.findElement(timeZone));
	    timezone.selectByValue("-11:30");
	  //  Thread.sleep(20000);
	   al.clickAddButton().click();
	   Thread.sleep(1000);
	   boolean message=driver.findElement(By.xpath("//div[@class=\'toast-message\']")).isDisplayed();
	  // WebElement text=driver.findElement(By.xpath("//*[@id=\'toast-container\']/div/div/text()"));
	//   System.out.println("text is:"+ text.getText());
	   if(true)
	   {
		   System.out.println("Details have been added in this location therefore a sub location cannot be added in this.");
		   
	   }
	   {
		   System.out.println("no message is displayed");
	   }  
	    
	}	  
	
	@AfterTest(enabled=true)
	public void teardown()
	{
		
		driver.close();
	}
}
	
	 
