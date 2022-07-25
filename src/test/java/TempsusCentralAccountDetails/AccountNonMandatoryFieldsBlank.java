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

import AccountDetailsPageObjects.AddNewMandatoryFieldsPageObjects;
import AccountDetailsPageObjects.AddNonMandatoryFieldsPageObjects;
import AccountDetailsPageObjects.loginPageObjects;
import TempsusCentralLoginPageSetup.LoginPageSetup;

public class AccountNonMandatoryFieldsBlank extends LoginPageSetup{

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
     protected By shortname=By.id("txtCompShortName");
     protected By concactnumber=By.id("txtContactNumber");
     protected By address1=By.id("txtAddressS1");
     protected By address2=By.id("txtAddressS2");
     protected By address3=By.id("txtAddressS3");
     protected By pincode=By.id("lblPincode");
     protected By country=By.id("dropDownCountry");
     protected By state=By.id("dropDownState");
     protected By city=By.id("dropDownCity");

     protected By website=By.id("txtWebsite");
     protected By update=By.xpath("//input[@id=\'btnUpdateCompany\']");
     
     @BeforeTest
     public void executebrowser() throws IOException
     {
    	 driver=browserSetup();
     }
	@Test
	public void display()
	{
		try {
		
			 driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			loginPageObjects lp=new loginPageObjects(driver);
			lp.getUsername().sendKeys(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
		//	driver.findElement(username).sendKeys(prop.getProperty("username"));
		//	driver.findElement(password).sendKeys(prop.getProperty("password"));
			lp.login().click();
		//	driver.findElement(login).click();
			System.out.println("you have logged in successfully");

		   wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(master));
			Thread.sleep(4000);
			AddNewMandatoryFieldsPageObjects anmf=new AddNewMandatoryFieldsPageObjects(driver);
			anmf.clickOnMaster().click();
			//driver.findElement(master).click();
			Thread.sleep(2000);
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(accountdetails));
		//	Thread.sleep(2000);
			anmf.clickAccountDetails().click();
		//	driver.findElement(accountdetails).click();
			Thread.sleep(2000);
			anmf.clickEdit().click();
	   //     driver.findElement(EditDetails).click();
	    	Thread.sleep(2000);
	    	AddNonMandatoryFieldsPageObjects anmfpo=new AddNonMandatoryFieldsPageObjects(driver);
	    	anmfpo.sendShortName().clear();
	    	anmfpo.sendShortName().sendKeys(" ");
	    //	driver.findElement(shortname).clear();
	    	//driver.findElement(shortname).sendKeys(" ");
	    	anmfpo.sendconcactnumber().clear();
	    	anmfpo.sendconcactnumber().sendKeys(" ");

	   //	driver.findElement(concactnumber).clear();
	    //	driver.findElement(concactnumber).sendKeys(" ");
	    	anmfpo.sendWebsite().clear();
	    	anmfpo.sendWebsite().sendKeys(" ");
	    	//driver.findElement(website).clear();
	    //	driver.findElement(website).sendKeys(" ");
	    	
           anmfpo.sendAddress1().clear();
           anmfpo.sendAddress1().sendKeys(" ");
	    //	driver.findElement(address1).clear();
	    //	driver.findElement(address1).sendKeys(" ");
           anmfpo.sendAddress2().clear();
           anmfpo.sendAddress2().sendKeys(" ");
	    //	driver.findElement(address2).clear();
	    	//driver.findElement(address2).sendKeys(" ");
           anmfpo.sendAddress3().clear();
           anmfpo.sendAddress3().sendKeys(" ");
	   // 	driver.findElement(address3).clear();
	    //	driver.findElement(address3).sendKeys(" ");
           anmfpo.sendPincode().clear();
           anmfpo.sendPincode().sendKeys(" ");
	    //.findElement(pincode).clear();
	    	//driver.findElement(pincode).sendKeys(" ");
           anmfpo.sendCountry().clear();
           anmfpo.sendCountry().sendKeys(" ");
	    	//driver.findElement(country).clear();
	    	//driver.findElement(country).sendKeys(" ");
           anmfpo.sendState().clear();
           anmfpo.sendState().sendKeys(" ");
	    	//driver.findElement(state).clear();
	    	//driver.findElement(state).sendKeys(" ");
	    	anmfpo.sendCity().clear();
	    	anmfpo.sendCity().sendKeys(" ");
	    //river.findElement(city).clear();
	    //river.findElement(city).sendKeys(" ");
	    	AddNewMandatoryFieldsPageObjects afpo=new AddNewMandatoryFieldsPageObjects(driver);
	    	afpo.clickUpdate().click();
	    	
	    
	        //driver.findElement(update).click(); 
		       
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
