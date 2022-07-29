package DepartmentMaster;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AccountDetailsPageObjects.loginPageObjects;
import DepartmentMasterPageObjects.addNewDeptLocationIsBlank;
import DepartmentMasterPageObjects.deleteDept;
import DepartmentMasterPageObjects.fieldsBlank;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import companyDetailsPageObjects.ParentLocation;

public class addDeptwithSingleLocation extends LoginPageSetup {
    public WebDriver driver;
    private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
    private By clickDepartment=By.xpath("//a[@href=\'/Master/DepartmentMaster\']");
    private By clickAdd=By.id("btnDepartmentSave");
    private By shortname=By.id("txtShortName");
    private By departmentName=By.id("txtDepartmentName");
    private By message=By.xpath("//*[@id=\'toast-container\']/div/div");
    WebDriverWait wait;
	@BeforeTest
    public void executebrowser() throws IOException
    {
   	 driver=browserSetup();
   	
    }
	@Test
	public void DeptWithLocation() throws InterruptedException
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
			wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(master));
		    cd.clickMaster().click();    	
		    
		    fieldsBlank fb=new fieldsBlank(driver);	
		    fb.clickDepartment().click();
		    addNewDeptLocationIsBlank and=new addNewDeptLocationIsBlank(driver);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(shortname));
		    and.sendShortName().sendKeys("D");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(departmentName));
		    and.sendDepartmentName().sendKeys("Dpt");
			List<WebElement> location=driver.findElements(By.xpath("//a[@class=\'jstree-anchor\']"));
			for(WebElement listlocation:location)
			{
				if(listlocation.getText().equalsIgnoreCase("Location 1"))
				{
					listlocation.click();
					break;
				}
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(clickAdd));
	        fb.clickAdd().click();
	      
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	        
	}
	@AfterTest(enabled=true)
	public void teardown()
	{
		driver.close();
	}
}
