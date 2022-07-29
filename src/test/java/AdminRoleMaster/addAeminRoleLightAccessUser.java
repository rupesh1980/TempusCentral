package AdminRoleMaster;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AccountDetailsPageObjects.loginPageObjects;
import AdminRoleMasterPajeObjects.AdminRoleFullAccessUser;
import AdminRoleMasterPajeObjects.fieldsAreBlank;
import AdminRoleMasterPajeObjects.fullAccessUserDelete;
import AdminRoleMasterPajeObjects.lightAccessUser;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import companyDetailsPageObjects.ParentLocation;
import companyDetailsPageObjects.addLocation;

public class addAeminRoleLightAccessUser extends LoginPageSetup{
	
	public WebDriver driver;
	WebDriverWait wait;
    private By clickAdd=By.id("btnSaveUserRole");
    private By clickAdminRoleMaster=By.xpath("//*[contains(text(),\' Admin Role Master\')]");
    private By adminRoleName=By.id("txtRoleName");
    private By roleType=By.id("droptype");
    private By update=By.id("btnSaveUserRole");
    private By Yes=By.id("YesDeleteUserRole");
    private By popup=By.xpath("//*[@id=\'lblvalidateMsg\']");
    private By clickok=By.id("btnOkValidate");
    private By selectLocation=By.xpath("//div[@class=\'treeSelector-input-box\']");
 

	
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
   public void addFullAccesUser() throws InterruptedException
   {
		CompanyDetailsFieldsBlank cd=new CompanyDetailsFieldsBlank(driver);
		
	    cd.clickMaster().click();
	   
	   fieldsAreBlank fb=new fieldsAreBlank(driver);
	   fb.clickAdminRoleMaster().click();
	   AdminRoleFullAccessUser full=new AdminRoleFullAccessUser(driver);
	   full.sendAdminRoleName().sendKeys("mylightrole");
	   Select RoleType=new Select(driver.findElement(roleType));
	   RoleType.selectByIndex(1);
	
	   lightAccessUser lu=new lightAccessUser(driver);
	   lu.clickYes().click();
	   boolean popup=lu.getPopup().isDisplayed();
	   if(true)
	   {
		  
		   lu.clickok().click();
		   
	   }
	  lu.selectLocation().click();
	  List<WebElement> locations=driver.findElements(By.xpath("//span[@class=\'treeSelector-li-title\']"));
	  for(WebElement list:locations)
	  {
		  if(list.getText().equalsIgnoreCase("Location 1"))
				  {
			           list.click();
				  }
	  }
	  lu.clickYes().click();
   }
	@AfterTest(enabled=false)
	public void teardown()
	{
		driver.close();
	}

}
