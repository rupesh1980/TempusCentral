package AccountDetailsPageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddNewMandatoryFieldsPageObjects {

	 WebDriver driver;
	     protected By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	     protected By EditDetails=By.id("btnCompanyform");
	     protected By companylocation=By.xpath("//*[contains(text(),\' Company Locations\')]");
	     protected By accountDetails=By.xpath("//*[contains(text(),\' Account Details\')]");
	     protected By website=By.xpath("//input[@id=\'txtWebsite\']");
	     protected By update=By.xpath("//input[@id=\'btnUpdateCompany\']");
	     protected By textfornewfield=By.id("txtCompanyParametername");
	     protected By addtextfornewfield=By.id("btnCompanyAddParameter");
	     protected By Deletefield=By.id("YesDeleteParamDelete");
	     protected By requiredfield=By.xpath("//input[@class=\'form-control Texboxclass Validation_TextBox\']");
	     protected By newfield=By.xpath("//*[contains(text(),\'newfield\')]");
	     protected By selectFromDropDown=By.xpath("//select[@class=\' floating-select ClassDropxtraParameter\']");
	     protected By addNewField=By.id("txtCompanyParametername");
	     protected By option1=By.id("txtOption1");
	     protected By option2=By.id("txtOption2");
	     protected By option3=By.xpath("//input[@id=\'txtOption\']");	
	     protected By add=By.id("btnCompanyAddParameter");
	     protected By deleteIcon=By.className("DeleteParameter");
	     protected By deleteButton=By.id("YesDeleteField");
	     protected By clickRequiredField=By.xpath("//span[@class=\'slider round\']");
	     protected By textForNewfield=By.id("txtCompanyParametername");
	     protected By clickonTextField1=By.xpath("//*[contains(text(),\'Mydetails\')]");
	     protected By clickonTextField=By.id("dropDownStatus");
	     
	     protected By addTextForField= By.id("btnCompanyAddParameter");
	     protected By clickTextField=By.xpath("//*[contains(text(),\'Mydetails\')]");
	     protected By selectDropDown=By.xpath("//input[@id=\'dropDownCity\']");
	     protected By addNewTitle=By.id("txtCompanyParametername");
	     protected By addDataForOption1=By.id("txtOption1");
	     protected By addDataForOption2=By.id("txtOption2");
	     protected By addOption=By.xpath("//img[@id=\'AddOptions\']");
	     protected By addTextForNewField= By.id("btnCompanyAddParameter");
	   //  protected By newfield=By.xpath("//*[contains(text(),\'newfield\')]");
	   //  protected By requiredfield=By.xpath("//input[@class=\'form-control Texboxclass Validation_TextBox\']");
	     
	  //   driver.findElement(By.id("txtOption1")).sendKeys("firstfield");
		//  driver.findElement(By.id("txtOption2")).sendKeys("secondfield");
	   public AddNewMandatoryFieldsPageObjects(WebDriver driver)
	   {
		   this.driver=driver;
	   }
	  @Test
	public WebElement clickOnMaster()
	{
		  return driver.findElement(master);
	}
	  public WebElement clickCompanyLocation()
		{
			  return driver.findElement(companylocation);
		}
	  public WebElement clickEdit()
		{
			  return driver.findElement(EditDetails);
		}
	  public WebElement selectAddNewField()
		{
			  return driver.findElement(addNewField);
		}
	  public WebElement selectOption1()
		{
			  return driver.findElement(option1);
		}
	  public WebElement selectOption2()
		{
			  return driver.findElement(option2);
		}
	  public WebElement clickAdd()
			{
				  return driver.findElement(add);
			}
	  public WebElement clickDeleteIcon()
		{
			  return driver.findElement(deleteIcon);
		}
	  public WebElement clickAddDelete()
		{
			  return driver.findElement(deleteButton);
		}
	  public WebElement clickRequireField()
		{
			  return driver.findElement(clickRequiredField);
		}
	  public WebElement sendRequiredTextField()
		{
			  return driver.findElement(textForNewfield);
		}
	  public WebElement addTextForField()
		{
			  return driver.findElement(addTextForField);
		}
	  public WebElement clickOnTextField1()
		{
			  return driver.findElement(clickonTextField1);
		}
	  public WebElement clickOnTextField()
		{
			  return driver.findElement(clickonTextField);
		}
	  
	  public WebElement SelectFromDropDown()
		{
			  return driver.findElement(selectDropDown);
		}
	  public WebElement clickUpdate()
		{
			  return driver.findElement(update);
		}
	  public WebElement sendRequireFieldData()
			{
				  return driver.findElement(requiredfield);
			}
	  public WebElement sendAddNewTitleData()
		{
			  return driver.findElement(addNewTitle);
		}
	  public WebElement sendDataForOption1()
		{
			  return driver.findElement(addDataForOption1);
		}
	  public WebElement sendDataForOption2()
		{
			  return driver.findElement(addDataForOption2);
		}
	  public WebElement sendDataForOption3()
		{
			  return driver.findElement(option3);
		}
	  public WebElement addOption()
			{
				  return driver.findElement(addOption);
			}
	  public WebElement addField()
		{
			  return driver.findElement(addTextForNewField);
		}
	  public WebElement clickAccountDetails()
		{
			  return driver.findElement(accountDetails);
		}
	  public WebElement clickNewField()
		{
			  return driver.findElement(newfield);
		}




	 
}
