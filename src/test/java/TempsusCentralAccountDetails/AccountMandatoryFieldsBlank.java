package TempsusCentralAccountDetails;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AccountDetailsPageObjects.AccountMandatoryFieldsPageObjects;
import AccountDetailsPageObjects.AddNewMandatoryFieldsPageObjects;
import AccountDetailsPageObjects.loginPageObjects;
import TempsusCentralLoginPageSetup.LoginPageSetup;

public class AccountMandatoryFieldsBlank extends LoginPageSetup{

	static WebDriver driver;
	WebDriverWait wait;
     protected By username=By.id("Central_UserName");
     protected By password=By.id("Central_Password");
     protected By login=By.id("btnLoginCentral");
     protected By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
     protected By EditDetails=By.id("btnCompanyform");
     protected By accountdetails=By.xpath("//*[contains(text(),\' Account Details\')]");
     protected By companyname=By.id("txtCompanyName");     
     protected By emailId=By.id("txtEmailId");
     protected By update=By.xpath("//input[@id=\'btnUpdateCompany\']");
     
     @BeforeTest
     public void executebrowser() throws IOException
     {
    	 driver=browserSetup();
     }
	@Test
	public void checkMandatoryFields()
	{
		try {
		
			 driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			loginPageObjects lp=new loginPageObjects(driver);
			lp.getUsername().sendKeys(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
		
			lp.login().click();
	
			System.out.println("you have logged in successfully");
			AddNewMandatoryFieldsPageObjects amf=new AddNewMandatoryFieldsPageObjects(driver);
			
		 
			Thread.sleep(4000);
			amf.clickOnMaster().click();
		
			Thread.sleep(2000);
		
			amf.clickAccountDetails().click();
		
		   Thread.sleep(2000);
		   amf.clickEdit().click();
	    
	    	Thread.sleep(2000);
	    	AccountMandatoryFieldsPageObjects amf1=new AccountMandatoryFieldsPageObjects(driver);
	    	amf1.companyName().clear();
	    	amf1.companyName().sendKeys(" ");
	    

	        driver.findElement(emailId).clear();
	        driver.findElement(emailId).sendKeys("asdf.com");
	        amf1.emailid().clear();
	        amf1.emailid().sendKeys("asdf.com");
	        AddNewMandatoryFieldsPageObjects anmf=new AddNewMandatoryFieldsPageObjects(driver);
	        anmf.clickUpdate().click();
	   
		       
		}	
		catch(Exception e)
		{
			e.getMessage();
		}
        
		
	}
	@AfterTest		
	public void testdown() throws InterruptedException
	{
	Thread.sleep(5000);
	driver.close();
	
}

}
