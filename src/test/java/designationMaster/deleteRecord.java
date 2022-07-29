package designationMaster;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import designationMasterPageObjects.recordDelete;
import designationMasterPageObjects.recordUpdate;

public class deleteRecord extends LoginPageSetup {
    public WebDriver driver;
    public WebDriverWait wait;
	private By designationType=By.id("dropDesignationType");
	private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	private By DesignationMaster=By.xpath("//*[contains(text(),\' Designation Master\')]");
	private By addbutton=By.id("btnDesignationSave");
	private By designationRecords=By.xpath("//tr[@style=\'cursor: pointer;width:100%\']/td[2]");
	private By deleteRecord=By.className("DeleteDesignation");
	private By yes=By.id("YesDeleteDesignation");

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
			recordDelete rd=new recordDelete(driver);
			wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(master));
			 cd.clickMaster().click();  
			 wait.until(ExpectedConditions.visibilityOfElementLocated(DesignationMaster));
			 fb.clickDesignationMaster().click();
			 Thread.sleep(2000);
		  List<WebElement> designationRecords=driver.findElements(By.xpath("//tr[@style=\'cursor: pointer;width:100%\']/td[2]"));
		//  System.out.println(designationRecords.size());
		 for(int i=0;i<designationRecords.size();i++)
		  {
			 Boolean result=driver.findElements(deleteRecord).get(i).isEnabled();
		 //s   System.out.println(result);
	
			  if(driver.findElements(By.xpath("//tr[@style=\'cursor: pointer;width:100%\']/td[2]")).get(i).getText().equalsIgnoreCase("rupesh"))				  
			  {
				  Actions person=new Actions(driver);
				  person.moveToElement(driver.findElements(By.xpath("//tr[@style=\'cursor: pointer;width:100%\']/td[2]")).get(i)).build().perform();
				//	 Boolean result1=driver.findElements(deleteRecord).get(i).isEnabled();

				  driver.findElements(By.className("DeleteDesignation")).get(i).click();
				  wait.until(ExpectedConditions.visibilityOfElementLocated(yes));
				// Thread.sleep(2000);
				 rd.clickYes().click();
				    System.out.println("Record is deleted successfully");

			  }
		  }
		 

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
