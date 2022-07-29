package AdminRoleMaster;

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
import AdminRoleMasterPajeObjects.AdminRoleFullAccessUser;
import AdminRoleMasterPajeObjects.adminRoleFullAccessCompanyLocations;
import AdminRoleMasterPajeObjects.fieldsAreBlank;
import AdminRoleMasterPajeObjects.fullAccessUserDelete;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import companyDetailsPageObjects.ParentLocation;
import companyDetailsPageObjects.addLocation;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class FullUserLocationsCheck extends LoginPageSetup {
  int count;
  int count1;
	public WebDriver driver;
	WebDriverWait wait;
	private By attendanceLeavePolicy=By.xpath("//*[contains(text(),\' Attendance Policy\')]");
	// protected By addoptions=By.id("AddOptions");
	@BeforeTest
	public void executebrowser() throws IOException {
		driver = browserSetup();

	}

	@SuppressWarnings("unused")
	@Test(priority = 1, enabled = true)
	public void login() throws InterruptedException, IOException {
		try {

			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			loginPageObjects lp = new loginPageObjects(driver);
			lp.getUsername().sendKeys(prop.getProperty("username"));
			
			lp.getPassword().sendKeys(prop.getProperty("password"));
		
			lp.login().click();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void fullAccessUserLocationCheck() throws InterruptedException {
		
		CompanyDetailsFieldsBlank cd = new CompanyDetailsFieldsBlank(driver);

		cd.clickMaster().click();
	
		adminRoleFullAccessCompanyLocations arfc=new adminRoleFullAccessCompanyLocations(driver);
		arfc.clickAdminRoleMaster().click();
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.xpath("//*[@id=\'tblAdminRole\']/tbody"));
		// List<WebElement> tablerows=table.findElements(By.tagName("td"));
		List<WebElement> tablerows = table.findElements(By.xpath("//tr[@style=\'cursor: pointer;\']/td[2]"));

		for (int i = 0; i < tablerows.size(); i++) {
			if (tablerows.get(i).getText().equalsIgnoreCase("MyRole")) {
				tablerows.get(i).click();
				// driver.findElements(By.xpath("//img[@class=\'DeleteUserRole\']")).get(i).click();
				break;
			}
		}
	   Thread.sleep(2000);
	   List<WebElement> adminrolelocations=driver.findElements(By.xpath("//span[@class=\'title\']"));
	    count=adminrolelocations.size();
	    System.out.println("Total locations in admin role master are: " + count);
	    Thread.sleep(2000);
	    driver.close();
	}
	@Test(priority=3,enabled=true)
	public void execute() throws IOException
	{
		driver = browserSetup();
	}
	@Test(priority = 4, enabled = true)
	public void fullAccessAttendanceMaster() throws InterruptedException, IOException {
		count1=0;
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		loginPageObjects lp = new loginPageObjects(driver);
		lp.getUsername().sendKeys(prop.getProperty("fullusername"));
		
		lp.getPassword().sendKeys(prop.getProperty("password"));
	
		lp.login().click();
		CompanyDetailsFieldsBlank cd = new CompanyDetailsFieldsBlank(driver);

		cd.clickMaster().click();	

		Thread.sleep(2000);
		driver.findElement(attendanceLeavePolicy).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\'example\']/tbody/tr[1]/td[2]")).click();
	    Thread.sleep(2000);
	   // List<WebElement> locationunderattendancepolicy=driver.findElements(By.xpath("//span[@class=\'k-sprite folder\']"));
	    List<WebElement> locationunderattendancepolicy=driver.findElements(By.xpath("//span[@class=\'k-in\']"));
	    Thread.sleep(2000);
	  for(WebElement list:locationunderattendancepolicy)
	  {
	     if(list.getText().contains("Location"))
	     {
	    	 count1=count1+1;
	     }
	     if(list.getText().contains("location"))
	     {
	    	 count1=count1+1;
	     }
	     
	     
	    }
	   //  count1=locationunderattendancepolicy.size();
		    System.out.println("Total locations in attendance policy  are: " + count1);

		   if(count==count1)
		   {
			   System.out.println("Locations count in Admin role master and Attendance policies are same");
		   }
		   else
		   {
			   System.out.println("Locations count in Admin role master and Attendance policies are not same");

		   }

	}
	@AfterTest(enabled = true)
	public void teardown() {
		driver.close();
	}

}
