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
import AccountDetailsPageObjects.MoreDetailsPageObjects;
import AccountDetailsPageObjects.loginPageObjects;
import TempsusCentralLoginPageSetup.LoginPageSetup;

public class MoreDetails extends LoginPageSetup{

	public WebDriver driver;
	WebDriverWait wait;
 
	 protected By accountdetails=By.xpath("//*[contains(text(),\' Account Details\')]");
	 protected By addNewField=By.xpath("//select[@id=\'dropDownStatus\']");
	  protected By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	  protected By selectFromDropDown=By.xpath("//select[@class=\' floating-select ClassDropxtraParameter\']");
	//  protected By otherdetails=By.xpath("//input[@id=\'txt3236\']");
	  protected By otherdetails=By.xpath("//select[@style=\'cursor:pointer\']");
	  protected By update=By.id("btnUpdateCompany");
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
	public void moreDetails() throws InterruptedException
	{
		try
		{
			AddNewMandatoryFieldsPageObjects anmf=new AddNewMandatoryFieldsPageObjects(driver);
			Thread.sleep(2000);

			anmf.clickOnMaster().click();
			
			Thread.sleep(2000);
	
			anmf.clickAccountDetails().click();
		
			Thread.sleep(2000);
			

	    	driver.findElement(By.xpath("//*[contains(text(),\' More Details\')]")).click();
			Thread.sleep(2000);
			MoreDetailsPageObjects md=new MoreDetailsPageObjects(driver);
			md.clickEditDetals().click();
	    	//driver.findElement(By.id("btnCompanyform")).click();
	    driver.findElement(By.id("dropDownCity")).click();
	    	Thread.sleep(2000);
	    	Actions textbox=new Actions(driver);
	    	textbox.moveToElement(md.sendDataTextField()).build().perform();
	    	Thread.sleep(2000);
	    	md.sendDataTextField().click();
	    	md.sendDataTextField().clear();
	    	md.sendDataTextField().sendKeys("data5");
	    	md.sendDataTextField().click();
	    	Select dropdown=new Select(driver.findElement(By.xpath("//div[@style=\'width:100%;margin-top: 10%;\']/select")));
	    	dropdown.selectByIndex(1);
	
	    	driver.findElement(update).click();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@AfterTest
	public void testdown() throws InterruptedException
	{
		Thread.sleep(5000);
	driver.close();
	
}
}
