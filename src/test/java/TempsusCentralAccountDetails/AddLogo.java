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

public class AddLogo extends LoginPageSetup{

	public WebDriver driver;
	WebDriverWait wait;

	 protected By accountdetails=By.xpath("//*[contains(text(),\' Account Details\')]");
	 protected By addNewField=By.xpath("//select[@id=\'dropDownStatus\']");
	  protected By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	  protected By selectFromDropDown=By.xpath("//select[@class=\' floating-select ClassDropxtraParameter\']");
     @BeforeTest
     public void executebrowser() throws IOException
     {
    	 driver=browserSetup();
     }
	@Test(priority=1,enabled=true)
	public void login()
	{
		try {
		
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			loginPageObjects lp=new loginPageObjects(driver);
			lp.getUsername().sendKeys(prop.getProperty("username"));		
			lp.getPassword().sendKeys(prop.getProperty("password"));
			lp.login().click();
			System.out.println("you have logged in successfully");
  
	    	}	
		catch(Exception e)
		{
			e.getMessage();
		}
       
		
	}
	@Test(priority=2,enabled=true)
	public void addJPGfileLogo() throws InterruptedException
	{
		try
		{
			AddNewMandatoryFieldsPageObjects anmf=new AddNewMandatoryFieldsPageObjects(driver);
			Thread.sleep(2000);
			anmf.clickOnMaster().click();
			
			Thread.sleep(2000);
	
			anmf.clickAccountDetails().click();
		
			Thread.sleep(2000);
			anmf.clickEdit().click();
	
	    	Thread.sleep(2000);
			      driver.findElement(By.xpath("//i[@class=\'fa fa-pen icon-sm text-muted\']")).click();
			  	Thread.sleep(2000);
			 Runtime.getRuntime().exec("C:\\Users\\DELL\\eclipse-workspace\\demo\\files\\newfile.exe");
			 Thread.sleep(2000);
			  //	Run("C:\\Users\\DELL\\Desktop\\newfile.exe");
			  	AccountMandatoryFieldsPageObjects amfp=new AccountMandatoryFieldsPageObjects(driver);
			  	
			  	amfp.clickUpdate().click();
			  Thread.sleep(5000);
			    	 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test(priority=3,enabled=true)
	public void addExcelsheet() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);

			AddNewMandatoryFieldsPageObjects anmf=new AddNewMandatoryFieldsPageObjects(driver);
			Thread.sleep(2000);
			anmf.clickOnMaster().click();
			
			Thread.sleep(2000);
	
			anmf.clickAccountDetails().click();
		
			Thread.sleep(2000);
			anmf.clickEdit().click();
	
	    	Thread.sleep(2000);
			      driver.findElement(By.xpath("//i[@class=\'fa fa-pen icon-sm text-muted\']")).click();
			  	Thread.sleep(2000);
			 Runtime.getRuntime().exec("C:\\Users\\DELL\\eclipse-workspace\\demo\\files\\excel.exe");
			 Thread.sleep(2000);
			  //	Run("C:\\Users\\DELL\\Desktop\\newfile.exe");
			  	AccountMandatoryFieldsPageObjects amfp=new AccountMandatoryFieldsPageObjects(driver);
			//  	Thread.sleep(2000);
			  	amfp.clickUpdate().click();
				  Thread.sleep(2000);

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@AfterTest(enabled=true)
	public void testdown() throws InterruptedException
	{
		Thread.sleep(5000);
	driver.close();
	
}
	
}
