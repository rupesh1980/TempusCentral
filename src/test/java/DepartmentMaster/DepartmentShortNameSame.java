package DepartmentMaster;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AccountDetailsPageObjects.loginPageObjects;
import DepartmentMasterPageObjects.addNewDeptLocationIsBlank;
import DepartmentMasterPageObjects.fieldsBlank;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import companyDetailsPageObjects.ParentLocation;

public class DepartmentShortNameSame extends LoginPageSetup {
    public WebDriver driver;
    private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
    private By clickDepartment=By.xpath("//a[@href=\'/Master/DepartmentMaster\']");
    private By clickAdd=By.id("btnDepartmentSave");
    private By shortName=By.id("txtShortName");
    private By add=By.id("btnLocationSave");
    public WebDriverWait wait;
	@BeforeTest
    public void executebrowser() throws IOException
    {
   	 driver=browserSetup();
   	
    }
	@Test
	public void duplicateShortName() throws InterruptedException
	{
		
		 driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			loginPageObjects lp=new loginPageObjects(driver);
			lp.getUsername().sendKeys(prop.getProperty("username"));			
			lp.getPassword().sendKeys(prop.getProperty("password"));		
			lp.login().click();
			CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);			
			wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(master));
		    cd.clickMaster().click();    
			
		    fieldsBlank fb=new fieldsBlank(driver);	
		  //  wait.until(ExpectedConditions.visibilityOfElementLocated(clickDepartment));
			fb.clickDepartment().click();
			addNewDeptLocationIsBlank adn=new addNewDeptLocationIsBlank(driver);
			

			//fb.clickDepartment().click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(shortName));
			Thread.sleep(2000);

		//	adn.clickAdd().click();
			adn.sendShortName().sendKeys("dept");
			adn.clickAdd().click();
	}
	@AfterTest(enabled=true)
	public void teardown()
	{
		driver.close();
	}
}
