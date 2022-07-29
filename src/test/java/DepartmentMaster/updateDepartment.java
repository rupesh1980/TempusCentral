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
import DepartmentMasterPageObjects.updateDept;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import companyDetailsPageObjects.ParentLocation;

public class updateDepartment extends LoginPageSetup {
    public WebDriver driver;
    private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
    private By clickDepartment=By.xpath("//a[@href=\'/Master/DepartmentMaster\']");
    private By clickAdd=By.id("btnDepartmentSave");
    private By shortname=By.id("txtShortName");
    private By departmentName=By.id("txtDepartmentName");
    private By message=By.xpath("//*[@id=\'toast-container\']/div/div");
  //  private By clickarrow=By.xpath("//*[@id=\'8171\']/i");
  //  private By clickarrow=By.xpath("//li[@class=\'jstree-node jstree-closed\']/div");
    private By clickarrow=By.xpath("//*[@class=\'jstree-node  jstree-closed\']/i");
    //private By clickYes=By.xpath("//input[@id=\'YesAssignLoc\']");
    private By clickYes=By.xpath("//input[@id=\'YesAssignLoc\']");

    private By clickYeswithEmp=By.xpath("//li[@class=\'jstree-node jstree-closed\']/div]");
  

    WebDriverWait wait;
	@BeforeTest
    public void executebrowser() throws IOException
    {
   	 driver=browserSetup();
   	
    }
	@Test
	public void UpdateDepartment() throws InterruptedException
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
		    deleteDept dl=new deleteDept(driver);
		    updateDept ud=new updateDept(driver);  
		 //  wait.until(ExpectedConditions.visibilityOfElementLocated(clickarrow));
		//   List<WebElement> arrows=driver.findElements(By.xpath("//i[@class=\'jstree-icon jstree-ocl\']"));
		  // System.out.println("arrow size is:"+arrows.size());
		 //  driver.findElement(By.xpath("//*[@id=\'8171\']/i")).click();
		  /* for(int i=0;i<arrows.size();i++)
		   {
			   boolean data=driver.findElements(By.xpath("//i[@class=\'jstree-icon jstree-ocl\']")).get(i).isEnabled();
			   System.out.println("data are" + data);
		   }*/
		  //  dl.clickArrow().click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@class=\'jstree-node  jstree-closed\']/i")).click();
		    
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
			Thread.sleep(1000);
			List<WebElement> locations=driver.findElements(By.xpath("//a[@class=\'jstree-anchor\']"));
			Thread.sleep(1000);

			for(WebElement listlocation:locations)
			{
				if(listlocation.getText().contains("4"))
				{
					listlocation.click();
					break;
				}
				
				
			}
		//	Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(clickYes));
			ud.clickYes().click();

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
