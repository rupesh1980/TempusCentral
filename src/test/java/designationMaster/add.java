package designationMaster;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AccountDetailsPageObjects.loginPageObjects;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import designationMasterPageObjects.addDesignationRecord;

public class add extends LoginPageSetup {
    public WebDriver driver;
    public WebDriverWait wait;
	private By designationType=By.id("dropDesignationType");
	private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	private By DesignationMaster=By.xpath("//*[contains(text(),\' Designation Master\')]");
	private By addbutton=By.id("btnDesignationSave");
	private By designationName=By.id("txtDesignationName");

	@BeforeTest
    public void executebrowser() throws IOException
    {
   	 driver=browserSetup();
   	}
	@Test
	public void fieldsblank()
	{
		try
		{
		 driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			loginPageObjects lp=new loginPageObjects(driver);
			lp.getUsername().sendKeys(prop.getProperty("username"));			
			lp.getPassword().sendKeys(prop.getProperty("password"));		
			lp.login().click();
			
			CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);	
			addDesignationRecord fb=new addDesignationRecord(driver);
			wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(master));
			 cd.clickMaster().click();  
			 wait.until(ExpectedConditions.visibilityOfElementLocated(DesignationMaster));
			 fb.clickDesignationMaster().click();
		
	    fb.shortName().sendKeys("rupesh");
	    fb.designationName().sendKeys("manager");
	    fb.designationType().click();
	    Select designationtype=new Select(driver.findElement(designationType));
	    designationtype.selectByIndex(1);
	    fb.clickAdd().click();
	    System.out.println("Record is added successfully");
	   }
	
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
