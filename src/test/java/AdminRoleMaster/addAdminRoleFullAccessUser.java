package AdminRoleMaster;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AccountDetailsPageObjects.loginPageObjects;
import AdminRoleMasterPajeObjects.AdminRoleFullAccessUser;
import AdminRoleMasterPajeObjects.fieldsAreBlank;
import AdminRoleMasterPajeObjects.fullAccessUserDelete;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import companyDetailsPageObjects.ParentLocation;
import companyDetailsPageObjects.addLocation;

public class addAdminRoleFullAccessUser extends LoginPageSetup{
	
	public WebDriver driver;
	WebDriverWait wait;
    private By clickAdd=By.id("btnSaveUserRole");
    private By clickAdminRoleMaster=By.xpath("//*[contains(text(),\' Admin Role Master\')]");
    private By adminRoleName=By.id("txtRoleName");
    private By roleType=By.id("droptype");
    private By update=By.id("btnSaveUserRole");
    private By Yes=By.id("YesDeleteUserRole");


	
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
   @Test(priority=2,enabled=true)
   public void addFullAccesUser()
   {
		CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);
		
	    cd.clickMaster().click();
	   
	   fieldsAreBlank fb=new fieldsAreBlank(driver);
	   fb.clickAdminRoleMaster().click();
	   AdminRoleFullAccessUser full=new AdminRoleFullAccessUser (driver);
	   full.sendAdminRoleName().sendKeys("MyRole");
	   Select RoleType=new Select(driver.findElement(roleType));
	   RoleType.selectByIndex(0);
	   full.clickUpdate().click();
	   
	   
   }
	
	@AfterTest(enabled=false)
	public void teardown()
	{
		driver.close();
	}

}
