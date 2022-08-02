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
import EmployeeFormSetupPajeObjects.addTextasNewFieldRequiredField;
import EmployeeFormSetupPajeObjects.addTextasNewFieldUnuqieField;
import EmployeeFormSetupPajeObjects.fieldsAreBlank;
import TempsusCentralLoginPageSetup.LoginPageSetup;

public class addNewFieldAsTextFieldasUnique extends  LoginPageSetup{
	public WebDriver driver;
	 private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	 private By employeeForm=By.xpath("//*[contains(text(),\' Employee Form Setup\')]");
	 private By add=By.xpath("//input[@id=\'btnAddParameter\']");
	 private By dropdown=By.id("dropDownStatus");
	 private By textparameter=By.id("txtParametername");
	 private By addMsg=By.xpath("//*[@id=\'toast-container\']/div/div");
	// private By addedtoform=By.xpath("//*[@id=\'toast-container\']/div[2]/div");
	 private By addedtoform=By.xpath("///*[@id=\'toast-container\']/div/div");
	 private By fielddeleted=By.xpath("//*[@id=\'toast-container\']/div/div");
	 private By requirefield=By.xpath("//*[@id=\'divRequiredField\']/div/label[1]/span");
	 private By uniquefield=By.xpath("//*[@id=\'divUniqueField\']/div[2]/div/label[1]/span");

	WebDriverWait wait;
	@BeforeTest
    public void executebrowser() throws IOException
    {
   	 driver=browserSetup();
   	}
	@Test
	public void addNewFieldasTextRequiredField()
	{
		try
		{
			 driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
				loginPageObjects lp=new loginPageObjects(driver);
				addTextasNewField atm=new addTextasNewField(driver);
				lp.getUsername().sendKeys(prop.getProperty("username"));			
				lp.getPassword().sendKeys(prop.getProperty("password"));		
				lp.login().click();
				fieldsAreBlank fb=new fieldsAreBlank(driver);
				wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(master));

				fb.clickOnMaster().click();	
				fb.clickOnEmployeeForm().click();
		     	wait.until(ExpectedConditions.visibilityOfElementLocated(add));
				fb.clickAdd().click();
				atm.selectDropDown().click();
				addTextasNewFieldRequiredField atnf=new addTextasNewFieldRequiredField(driver);
				atnf.addedasRequiredField().click();
				addTextasNewFieldUnuqieField atnf1=new addTextasNewFieldUnuqieField(driver);
				atnf1.addfieldasUniqueField().click();
				Select addNewField=new Select(driver.findElement(dropdown));
				
				
				atm.textParameterName().sendKeys("MyuniqueTextField");
				atm.clickAdd().click();
		     	wait.until(ExpectedConditions.visibilityOfElementLocated(addMsg));

				String msg=atm.addMessage().getText();
				if(msg.equalsIgnoreCase("Field added successfully"))
				{
					System.out.println("Record is added successfully");
				}
				else
				{
					System.out.println("Record is not added successfully");
				}
				Thread.sleep(2000);
				List<WebElement> listtextfields=driver.findElements(By.xpath("//div[@style=\'margin-top: 4%; height:35vh !important; overflow-y: scroll; overflow-x: hidden; \']/div/div[1]"));
				Thread.sleep(2000);

				for(WebElement textfields:listtextfields)
				{
					if(textfields.getText().equalsIgnoreCase("MyuniqueTextField"))
					{
						textfields.click();
						break;
						
					}
					System.out.println("Record with required field is added successfully to form");
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
