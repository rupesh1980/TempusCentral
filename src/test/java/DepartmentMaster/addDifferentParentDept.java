package DepartmentMaster;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class addDifferentParentDept extends LoginPageSetup {
    public WebDriver driver;
    private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
    private By clickDepartment=By.xpath("//a[@href=\'/Master/DepartmentMaster\']");
    private By clickAdd=By.id("btnDepartmentSave");
    private By shortname=By.id("txtShortName");
    private By departmentName=By.id("txtDepartmentName");
    private By message=By.xpath("//*[@id=\'toast-container\']/div/div");
    private By delete=By.xpath("//i[@class=\'la la-trash icon-lg mt-1 mr-2\']");
    private By deletebutton= By.id("YesDeleteDepartment");
    private By deleted=By.xpath("//*[contains(text(),\'Department deleted successfully\')]");
    private By SelectParentDept=By.id("DropDepartmentCode");
    WebDriverWait wait;
	@BeforeTest
    public void executebrowser() throws IOException
    {
   	 driver=browserSetup();
   	
    }
	@Test
	public void deleteDepartment() throws InterruptedException
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
		 
			Thread.sleep(3000);
			List<WebElement> location=driver.findElements(By.xpath("//a[@class=\'jstree-anchor\']"));
			Thread.sleep(3000);
		//	System.out.println("total numer are:" + location.size());
			for(WebElement listlocation:location)				
			{
				if(listlocation.getText().contains("Dpt"))
				{
					listlocation.click();
					break;
				}
			}
			  deleteDept dp=new deleteDept(driver);
		        dp.clickParentDept().click();
		        Thread.sleep(2000);
			List<WebElement> locations=driver.findElements(By.xpath("//span[@class=\'comboTreeItemTitle selectable\']"));
			Thread.sleep(000);
		//	System.out.println("total numer are:" + location.size());
			for(WebElement selectLocation:locations)				
			{
				if(selectLocation.getText().contains("newdept"))
				{
					selectLocation.click();
					break;
				}
			}
			
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
