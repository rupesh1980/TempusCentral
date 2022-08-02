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
import EmployeeFormSetupPajeObjects.editNewTextField;
import EmployeeFormSetupPajeObjects.fieldsAreBlank;
import TempsusCentralLoginPageSetup.LoginPageSetup;

public class EditNewTextFieldasUniqueField extends  LoginPageSetup{
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
	 private By edifField=By.xpath("//img[@class=\'EditExtraParam\']");
	 private By editfieldyes=By.id("YesEditEmpParam");
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
				editNewTextField ent=new editNewTextField(driver);
				
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
		     		if(textfields.get(i).getText().equalsIgnoreCase("MyuniqueTextField*"))
		     		{
		     			driver.findElements(By.xpath("//img[@class=\'EditExtraParam\']")).get(i).click();
		     			 wait.until(ExpectedConditions.visibilityOfElementLocated(editfieldyes));
		     			  			
		     			ent.editField().click();
		     			addTextasNewField atn=new addTextasNewField(driver);
		     			driver.findElements(By.xpath("//img[@class=\'EditExtraParam\']")).get(i).click();
		     			Thread.sleep(2000);
		     			driver.findElement(editfieldyes).click();
		     			
		     			

		     			 break;
		     			
		     		}
		     		
		     	}
		     	atm.textParameterName().clear();
		     	Thread.sleep(2000);
		     	atm.textParameterName().sendKeys("MyuniqueTextField new");
		     	Thread.sleep(2000);

		     	atm.clickAdd().click();
		     	Thread.sleep(2000);
		     	List<WebElement> customfields=driver.findElements(By.xpath("//div[@style=\'margin-top: 4%; height:35vh !important; overflow-y: scroll; overflow-x: hidden; \']/div/div"));
		     	for(WebElement fields:customfields)
		     	{
		     		if(fields.getText().equalsIgnoreCase("MyRequireTextField new"))
		     		{
		     			fields.click();
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
