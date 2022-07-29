package AdminRoleMaster;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import AdminRoleMasterPajeObjects.AdminRoleFullAccessUser;
import AdminRoleMasterPajeObjects.adminRoleFullAccessCompanyLocations;
import AdminRoleMasterPajeObjects.fieldsAreBlank;
import AdminRoleMasterPajeObjects.fullAccessUserDelete;
import DepartmentMasterPageObjects.addNewDeptLocationIsBlank;
import DepartmentMasterPageObjects.fieldsBlank;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import companyDetailsPageObjects.ParentLocation;
import companyDetailsPageObjects.addLocation;

public class AdminRoleCompanyLocationViewAddCheck extends LoginPageSetup{
	
	public WebDriver driver;
	WebDriverWait wait;
    private By clickAdd=By.id("btnSaveUserRole");
    private By clickAdminRoleMaster=By.xpath("//*[contains(text(),\' Admin Role Master\')]");
    private By adminRoleName=By.id("txtRoleName");
    private By roleType=By.id("droptype");
    private By update=By.id("btnSaveUserRole");
    private By Yes=By.id("YesDeleteUserRole");
    private By EmployeeProfileView=By.xpath("//*[@id=\'TableContent1\']/div[2]/div/div[2]/label/span");
    private By CompanyLocationDelete=By.xpath("//*[@id=\'TableContent1\']/div[3]/div/div[5]/label/span");

    private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
    private By clickDepartment=By.xpath("//a[@href=\'/Master/DepartmentMaster\']");
  //  private By clickAdd=By.id("btnDepartmentSave");
    private By shortname=By.id("txtShortName");
    private By departmentName=By.id("txtDepartmentName");
    private By message=By.xpath("//*[@id=\'toast-container\']/div/div");
	  private By timeZone=By.id("DropTimeZone");
	  private By addLocationWithRole=By.id("btnAddLocationWithRole");

	
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
			lp.getUsername().sendKeys(prop.getProperty("fullusername"));
			//log.info("User has entered username");
			//System.out.println(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
			//log.info("User has entered password");
			lp.login().click();
		    Thread.sleep(5000);
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	@Test(priority=3,enabled=true)
	public void companyLocatinViewonly() throws InterruptedException
	{
		AddNewMandatoryFieldsPageObjects amfp=new AddNewMandatoryFieldsPageObjects(driver);
	
	//   amfp.clickOnMaster().click();
	
	//  amfp.clickCompanyLocation().click();
		 Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		List<WebElement> locations=driver.findElements(By.xpath("//a[@class=\'jstree-anchor\']"));
		for(WebElement list:locations)
		{
			if(list.getText().equalsIgnoreCase("Location 8"))
			{
				list.click();
				break;
				
			}
		}
		Thread.sleep(2000);
		String result=driver.findElement(By.id("btnLocationSave")).getAttribute("disabled");
		
		if(result.equalsIgnoreCase("true"))
		{
			System.out.println("User can not edit the record");
		}
		
	}
	@Test(priority=4,enabled=true)
	public void companyLocationDelete() throws InterruptedException
	{
		AddNewMandatoryFieldsPageObjects amfp=new AddNewMandatoryFieldsPageObjects(driver);
		
		WebElement deletebutton=driver.findElement(By.xpath("//span[@class=\'text-decoration-none\']"));
		Actions deletemsg=new Actions(driver);
		deletemsg.moveToElement(deletebutton).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'deleteButton\']/span[2]")).click();
		Thread.sleep(2000);
		boolean delmsg=driver.findElement(By.id("YesDeleteLocation")).isDisplayed();
		if(delmsg==true)
		{
			System.out.println("You have  rigths to delete record");
		}
		else
		{
			System.out.println("User have no rights to delete the record");
		}
		
	}
	@Test(priority=2,enabled=true)
	public void companyLocationAdd() throws InterruptedException
	{
		AddNewMandatoryFieldsPageObjects amfp=new AddNewMandatoryFieldsPageObjects(driver);
		Thread.sleep(2000);
		amfp.clickOnMaster().click();
		amfp.clickCompanyLocation().click();
		Thread.sleep(3000);
		boolean result=driver.findElement(By.id("btnLocationSave")).isEnabled();
		if(result==true)
		{
			System.out.println("user can add details");
			CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);
		    cd.clickMaster().click();
		    cd.clickCompanyDetails().click();
		    cd.clickAddButton().click();
		    addLocation al=new addLocation(driver);
		    al.sendDatatoLocationName().sendKeys("location 8");
		    Select timezone=new Select(driver.findElement(timeZone));
		    timezone.selectByValue("-11:30");
		    wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(master));
		//    Thread.sleep(2000);		
		    driver.findElement(By.id("btnLocationSave")).click();
	      //  Thread.sleep(2000);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(addLocationWithRole));
	        driver.findElement(addLocationWithRole).click();
		}
		else
		{
			System.out.println("user doesn't have permissin to add details");
		}
	}
  
	@AfterTest(enabled=true)
	public void teardown()
	{
		driver.close();
	}

}
