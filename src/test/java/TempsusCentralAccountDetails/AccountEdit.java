package TempsusCentralAccountDetails;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TempsusCentralLoginPageSetup.LoginPageSetup;

public class AccountEdit extends LoginPageSetup{

	static WebDriver driver;
	WebDriverWait wait;
     protected By username=By.id("Central_UserName");
     protected By password=By.id("Central_Password");
     protected By login=By.id("btnLoginCentral");
     protected By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
     protected By EditDetails=By.id("btnCompanyform");
     protected By accountdetails=By.xpath("//*[contains(text(),\' Account Details\')]");
     protected By website=By.xpath("//input[@id=\'txtWebsite\']");
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
			driver.findElement(username).sendKeys(prop.getProperty("username"));
			driver.findElement(password).sendKeys(prop.getProperty("password"));
			
			driver.findElement(login).click();
			System.out.println("you have logged in successfully");

		   wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(master));
			Thread.sleep(3000);
			
			driver.findElement(master).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(accountdetails));
			driver.findElement(accountdetails).click();
			Thread.sleep(4000);
	        driver.findElement(EditDetails).click();
			Thread.sleep(4000);

	        driver.findElement(website).clear();
			Thread.sleep(3000);

	        driver.findElement(website).sendKeys("5678");
			Thread.sleep(3000);

	        driver.findElement(update).click();
	        System.out.println("details are updated successfully");
	        
		       driver.close();

		
		}
		catch(Exception e)
		{
			e.getMessage();
		}
        
		
	}
	@AfterTest		
	public void testdown()
	{
	driver.close();
	
}

}
