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
import EmployeeFormSetupPajeObjects.fieldsAreBlank;
import TempsusCentralLoginPageSetup.LoginPageSetup;

public class addNewTextFieldWhichisAlreadyExists extends  LoginPageSetup{
	public WebDriver driver;
	 private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	 private By employeeForm=By.xpath("//*[contains(text(),\' Employee Form Setup\')]");
	 private By add=By.xpath("//input[@id=\'btnAddParameter\']");
	 private By dropdown=By.id("dropDownStatus");
	 private By textparameter=By.id("txtParametername");
	 private By addMsg=By.xpath("//*[@id=\'toast-container\']/div/div");
	

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
				atm.textParameterName().sendKeys("Mysecfield");
				atm.clickAdd().click();
		     	wait.until(ExpectedConditions.visibilityOfElementLocated(addMsg));

				String msg=atm.addMessage().getText();
				if(msg.equalsIgnoreCase("Parameter name already exits. Please enter different parameter name."))
				{
					System.out.println("Parameter name already exits. Please enter different parameter name.");
				}
				else
				{
					System.out.println("No message is displayed");
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
