package designationMaster;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import designationMasterPageObjects.recordUpdate;

public class updateRecord extends LoginPageSetup {
    public WebDriver driver;
    public WebDriverWait wait;
	private By designationType=By.id("dropDesignationType");
	private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	private By DesignationMaster=By.xpath("//*[contains(text(),\' Designation Master\')]");
	private By addbutton=By.id("btnDesignationSave");
	private By designationRecords=By.xpath("//tr[@style=\'cursor: pointer;width:100%\']/td[2]");

	@BeforeTest
    public void executebrowser() throws IOException
    {
   	 driver=browserSetup();
   	}
	@Test
	public void deleteRecord()
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
			recordUpdate ru=new recordUpdate(driver);
			wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(master));
			 cd.clickMaster().click();  
			 wait.until(ExpectedConditions.visibilityOfElementLocated(DesignationMaster));
			 fb.clickDesignationMaster().click();
		  List<WebElement> designationRecords=driver.findElements(By.xpath("//tr[@style=\'cursor: pointer;width:100%\']/td[2]"));
		  for(WebElement list:designationRecords)
		  {
			  if(list.getText().equalsIgnoreCase("rupesh"))
			  {
				  list.click();
			  }
		  }
		  ru.designationName().clear();
		  ru.designationName().sendKeys("New Manager");
		   fb.clickAdd().click();
		    System.out.println("Record is updated successfully");

	        
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
