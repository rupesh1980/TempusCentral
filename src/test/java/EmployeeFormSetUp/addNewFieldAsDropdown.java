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
import EmployeeFormSetupPajeObjects.addDropdownasNewField;
import EmployeeFormSetupPajeObjects.addTextasNewField;
import EmployeeFormSetupPajeObjects.fieldsAreBlank;
import TempsusCentralLoginPageSetup.LoginPageSetup;

public class addNewFieldAsDropdown extends  LoginPageSetup{
	public WebDriver driver;
	 private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	 private By employeeForm=By.xpath("//*[contains(text(),\' Employee Form Setup\')]");
	 private By add=By.xpath("//input[@id=\'btnAddParameter\']");
	 private By dropdown=By.id("dropDownStatus");
	 private By textparameter=By.id("txtParametername");
	 private By addMsg=By.xpath("//*[@id=\'toast-container\']/div/div");
	 private By addedtoform=By.xpath("//*[@id=\'toast-container\']/div[2]/div");
	 private By fielddeleted=By.xpath("//*[@id=\'toast-container\']/div/div");
	 private By option1=By.id("txtOption_1");
	 private By option2=By.id("txtOption_2");

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
			
				Select addNewField=new Select(driver.findElement(dropdown));
				//driver.findElement(By.id("txtParametername")).sendKeys("MyField");
				addNewField.selectByIndex(1);
				addDropdownasNewField adnn=new addDropdownasNewField(driver);
				
				atm.textParameterName().sendKeys("Mydropdown");
				adnn.addOption1().sendKeys("a");
				adnn.addOption2().sendKeys("b");
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
				List<WebElement> textfields=driver.findElements(By.xpath("//div[@class=\'row Parameterbox\']/div[1]"));
				for(WebElement fields:textfields)
				{
					if(fields.getText().equalsIgnoreCase("Mydropdown"))
					{
						fields.click();
						wait.until(ExpectedConditions.visibilityOfElementLocated(addedtoform));

						String formmsg=atm.addedtoFormMsg().getText();
						//System.out.println("Message is:"+formmsg);
						if(formmsg.equalsIgnoreCase("Field added to employee form successfully"))
						{
							System.out.println("Record is added successfully to form");
						}
						else
						{
							System.out.println("Record is not added successfully to form");

						}
						
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
