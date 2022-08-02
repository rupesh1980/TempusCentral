package EmployeeFormSetUp;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AccountDetailsPageObjects.loginPageObjects;
import EmployeeFormSetupPajeObjects.addTextasNewField;
import EmployeeFormSetupPajeObjects.deleteNewTextFld;
import EmployeeFormSetupPajeObjects.fieldsAreBlank;
import TempsusCentralLoginPageSetup.LoginPageSetup;

public class deleteNewDeleteDropdownasMandatory extends  LoginPageSetup{
	public WebDriver driver;
	 private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	 private By employeeForm=By.xpath("//*[contains(text(),\' Employee Form Setup\')]");
	 private By add=By.xpath("//input[@id=\'btnAddParameter\']");
	 private By dropdown=By.id("dropDownStatus");
	 private By textparameter=By.id("txtParametername");
	 private By addMsg=By.xpath("//*[@id=\'toast-container\']/div/div");
	 private By addedtoform=By.xpath("//*[@id=\'toast-container\']/div[2]/div");
	 private By delete=By.id("YesDeleteEmployeeParamDelete");
	 private By delmessage=By.xpath("//*[@id=\'toast-container\']/div/div");
	 private By deletefromCustField=By.xpath("//img[@class=\'DeleteParameter\']");
	 private By clickyes=By.id("YesDeleteEmployeeField");
	 private By fielddeleted=By.xpath("//*[@id=\'toast-container\']/div/div");
	WebDriverWait wait;
	@BeforeTest
    public void executebrowser() throws IOException
    {
   	 driver=browserSetup();
   	}
	@Test
	public void fieldsblank()
	{
		try
		{
			 driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
				loginPageObjects lp=new loginPageObjects(driver);
				deleteNewTextFld dnt=new deleteNewTextFld(driver);
				addTextasNewField atm=new addTextasNewField(driver);
				lp.getUsername().sendKeys(prop.getProperty("username"));			
				lp.getPassword().sendKeys(prop.getProperty("password"));		
				lp.login().click();
				fieldsAreBlank fb=new fieldsAreBlank(driver);
				wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(master));

				fb.clickOnMaster().click();
				fb.clickOnEmployeeForm().click();
				Thread.sleep(2000);
		     	List<WebElement> textfields=driver.findElements(By.xpath("//div[@style=\'width:96% !important;display:flex;border: 1px dashed #97a8b7;padding: 0px 10px 10px 10px;\']/div/label"));
		     	
		     	for(int i=0;i<textfields.size();i++)
		     	{
		     		if(textfields.get(i).getText().equalsIgnoreCase("MyRequireTextField new*"))
		     		{
		     			driver.findElements(By.xpath("//img[@style=\'width:18px;height:18px;margin-top:-10px;margin-left:-10px;cursor:pointer\']")).get(i).click();
		     			 wait.until(ExpectedConditions.visibilityOfElementLocated(delete));
		     			driver.findElement(delete).click();
		     			
					    wait.until(ExpectedConditions.visibilityOfElementLocated(delmessage));
					    String delmsg=dnt.delmsg().getText();
						if(delmsg.equalsIgnoreCase("Field deleted successfully from employee form"))
		     			{
		     				System.out.println("Field deleted successfully from employee form");
		     				break;
		     			}
		     			{
		     				System.out.println("No message is displayed");
		     			}
		     			
		     		}
		     	}
		     	
		     	
		     	List<WebElement> textfields1=driver.findElements(By.xpath("//div[@style=\'background-color:#fcfcfc;margin-bottom:5px;align-items: center;margin-top:0px;padding:5px;cursor:pointer\']/div[1]"));
		     	//System.out.println(textfields1.size());
		     	for(int i=0;i<textfields1.size();i++)
		     	{
		     		if(textfields1.get(i).getText().equalsIgnoreCase("MyRequireTextField new"))
		     		{
		     			driver.findElements(deletefromCustField).get(i).click();
					    wait.until(ExpectedConditions.visibilityOfElementLocated(clickyes));
		     			dnt.clickYes().click();
		     			
					    System.out.println("Field deleted successfully");
					
					 
		     		
		     		}
		     	}
		     	
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
