package TempsusCentralAccountDetails;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AccountDetailsPageObjects.AddNewMandatoryFieldsPageObjects;
import AccountDetailsPageObjects.loginPageObjects;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import org.apache.logging.log4j.*;
import org.codehaus.plexus.util.FileUtils;

public class AccountAddDeleteNewFields extends LoginPageSetup{
  
	private static Logger log=LogManager.getLogger(AccountAddDeleteNewFields.class.getName());
	
	public WebDriver driver;
	WebDriverWait wait;
     
	 protected By accountdetails=By.xpath("//*[contains(text(),\' Account Details\')]");
	 protected By addNewField=By.xpath("//select[@id=\'dropDownStatus\']");
	  protected By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	  protected By selectFromDropDown=By.xpath("//select[@class=\' floating-select ClassDropxtraParameter\']");
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
			log.info("User has entered username");
			//System.out.println(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
			log.info("User has entered password");
			lp.login().click();
		    Thread.sleep(5000);
		    				//     System.out.println("title is:"+lp.getTitle());
				     
				 //   assertEquals(driver.getTitle(), "Tempus Central");
		  //  Assert.assertEquals(driver.getTitle(), "Tempus Central");
				//    log.info("Successfully validated text message");
				//    System.out.println("test completed");
				   //  Assert.assertEquals(driver.getTitle(), "Tempus Central");
	    
	   boolean loginresult=driver.findElement(By.xpath("//div[@class=\'d-flex align-items-baseline flex-wrap mr-5\']/h5")).isDisplayed();
	   System.out.println("result is:" + loginresult);
		  
	   if(true)
	   {
		   log.error("login successful");
	   }
	  
	}
	 
	    catch(Exception e)
		{
			log.error("unsuccessul login. Please check username or password");
			//System.out.println(e.getMessage());
			TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File("C:\\Users\\DELL\\eclipse-workspace\\demo\\bugs\\login.png");
            FileUtils.copyFile(SrcFile, DestFile);
            driver.close();
            e.printStackTrace();
            Assert.fail();
          
	      }
	    
	}
	
	
	
	@Test(priority=2,enabled=true,dependsOnMethods = {"login"})
	public void DeleteDropDownOption() throws InterruptedException
	{
		try
		{
			AddNewMandatoryFieldsPageObjects amf=new AddNewMandatoryFieldsPageObjects(driver);
		        wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
					wait.until(ExpectedConditions.visibilityOfElementLocated(master));
					Thread.sleep(4000);
					amf.clickOnMaster().click();
					Thread.sleep(2000);			
					amf.clickCompanyLocation().click();
					Thread.sleep(2000);
			        amf.clickEdit().click();
			    	Thread.sleep(2000);			
			     Select addnewfield=new Select(driver.findElement(addNewField));
			      addnewfield.selectByIndex(1);
			      amf.selectAddNewField().sendKeys("newfield");		
			      amf.selectOption1().sendKeys("firstfield");				
			      amf.selectOption2().sendKeys("secondfield");			
			      amf.clickAdd().click();
				  Thread.sleep(2000);		
				   List<WebElement> deletefields=driver.findElements(By.xpath("//div[@class=\'col-md-5\']"));
				   
				 
			      for(WebElement fields:deletefields)
			      {
			    	  System.out.println(fields.getText());
			    	  if(fields.getText().equalsIgnoreCase("Text")) 
			    	  {
			    		  amf.clickDeleteIcon().click();
			    		  Thread.sleep(2000);			    	
			    		  amf.clickAddDelete().click();
			    	  }
			    	  if(fields.getText().equalsIgnoreCase("Dropdown")) 
			    	  {
			    		  amf.clickDeleteIcon().click();			    		
			    		  Thread.sleep(2000);			    
			    		  amf.clickAddDelete().click();
			    	  }
			      }
			    	  
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test(priority=3,enabled=true,dependsOnMethods = {"login"})
	public void deleteMandoryTextField() throws InterruptedException
	{
		try
		{
			AddNewMandatoryFieldsPageObjects amf=new AddNewMandatoryFieldsPageObjects(driver);
			 wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
				wait.until(ExpectedConditions.visibilityOfElementLocated(master));
				Thread.sleep(4000);
				amf.clickOnMaster().click();
			
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(accountdetails));
				Thread.sleep(2000);
				amf.clickAccountDetails().click();
		
				Thread.sleep(2000);
				amf.clickEdit().click();
		
		    	Thread.sleep(2000);
		    	amf.clickRequireField().click();
		 
		     amf.sendRequiredTextField().sendKeys("Mydetails");
		     Thread.sleep(2000);
		     amf.addTextForField().click();
		  
		    	Thread.sleep(2000);
		     
		    	 List<WebElement> deletefields=driver.findElements(By.xpath("//div[@class=\'col-md-5\']"));
				   
				 
			      for(WebElement fields:deletefields)
			      {
			    	  System.out.println(fields.getText());
			    	  if(fields.getText().equalsIgnoreCase("Text")) 
			    	  {
			    		  amf.clickDeleteIcon().click();
			    		  Thread.sleep(2000);			    	
			    		  amf.clickAddDelete().click();
			    	  }
			    	  if(fields.getText().equalsIgnoreCase("Dropdown")) 
			    	  {
			    		  amf.clickDeleteIcon().click();			    		
			    		  Thread.sleep(2000);			    
			    		  amf.clickAddDelete().click();
			    	  }
			      }

		}	
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test(priority=4,enabled=true,dependsOnMethods = {"login"})
	public void addMandoryTextField() throws InterruptedException
	{
		try
		{
			AddNewMandatoryFieldsPageObjects amf=new AddNewMandatoryFieldsPageObjects(driver);
			 wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
				wait.until(ExpectedConditions.visibilityOfElementLocated(master));
				Thread.sleep(4000);
				amf.clickOnMaster().click();
			
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(accountdetails));
				Thread.sleep(2000);
				amf.clickAccountDetails().click();
		
				Thread.sleep(2000);
				amf.clickEdit().click();
		
		    	Thread.sleep(2000);
		    	amf.clickRequireField().click();
		 
		     amf.sendRequiredTextField().sendKeys("Mydetails");
		  
		    	Thread.sleep(2000);
		     
		    	amf.addTextForField().click();
		  	Thread.sleep(5000);
		  
		  	amf.clickOnTextField1().click();
		    	Thread.sleep(2000);
           amf.SelectFromDropDown().clear();
           amf.SelectFromDropDown().sendKeys("Vadodara");
		 
           amf.clickUpdate().click();
		 
           amf.sendRequireFieldData().sendKeys("data");
		     //  driver.findElement(requiredfield).sendKeys("data");
		
		       amf.clickUpdate().click();
		    	Thread.sleep(4000);

		}	
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
		@Test(priority=4,enabled=true,dependsOnMethods = {"login"})
		public void addMandoryDropdownField() throws InterruptedException
		{
			try
			{
				
					Thread.sleep(2000);
				AddNewMandatoryFieldsPageObjects amf=new AddNewMandatoryFieldsPageObjects(driver);
				amf.clickOnMaster().click();
		
					Thread.sleep(2000);
			
					amf.clickAccountDetails().click();
			
					Thread.sleep(2000);
					amf.clickEdit().click();
			 
			    	Thread.sleep(2000);
			    	amf.clickRequireField().click();
			    	
			    	
                     amf.clickOnTextField().click();
					  
					      Select addnewfield=new Select(driver.findElement(By.xpath("//select[@id=\'dropDownStatus\']")));
					      addnewfield.selectByIndex(1);
					      amf.sendAddNewTitleData().sendKeys("newfield");
					
					      amf.sendDataForOption1().sendKeys("firstfield");
						
					      amf.sendDataForOption2().sendKeys("secondfield");
					      amf.addOption().click();
					      amf.sendDataForOption3().sendKeys("thirdfield");

					
					      amf.addField().click();
						
					    	Thread.sleep(5000);
                          amf.clickNewField().click();
					
							Thread.sleep(2000);
							 amf.SelectFromDropDown().clear();
					           amf.SelectFromDropDown().sendKeys("Vadodara");
				
		                Select dropdown=new Select(driver.findElement(selectFromDropDown));
		                dropdown.selectByIndex(1);
						Thread.sleep(2000);
						 amf.clickUpdate().click();


			}	
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	}
		@AfterTest(enabled=true)	
			public void testdown()
			{
			driver.close();
			
		}
}
