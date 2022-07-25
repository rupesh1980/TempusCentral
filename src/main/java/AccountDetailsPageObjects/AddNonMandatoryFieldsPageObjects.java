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

public class AddNonMandatoryFieldsPageObjects {

	 public WebDriver driver;
	 protected By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
     protected By EditDetails=By.id("btnCompanyform");
     protected By accountdetails=By.xpath("//*[contains(text(),\' Account Details\')]");
	 protected By shortname=By.id("txtCompShortName");
     protected By concactnumber=By.id("txtContactNumber");
     protected By address1=By.id("txtAddressS1");
     protected By address2=By.id("txtAddressS2");
     protected By address3=By.id("txtAddressS3");
     protected By pincode=By.id("lblPincode");
     protected By country=By.id("dropDownCountry");
     protected By state=By.id("dropDownState");
     protected By city=By.id("dropDownCity");
     protected By website=By.xpath("//input[@id=\'txtWebsite\']");

	     protected By addTextForNewField= By.id("btnCompanyAddParameter");
	   //  protected By newfield=By.xpath("//*[contains(text(),\'newfield\')]");
	   //  protected By requiredfield=By.xpath("//input[@class=\'form-control Texboxclass Validation_TextBox\']");
	     
	  //   driver.findElement(By.id("txtOption1")).sendKeys("firstfield");
		//  driver.findElement(By.id("txtOption2")).sendKeys("secondfield");
	   public AddNonMandatoryFieldsPageObjects(WebDriver driver)
	   {
		   this.driver=driver;
	   }
	  @Test
	  public WebElement clickOnMaster()
		{
			  return driver.findElement(master);
		}
		  public WebElement clickAccountDetails()
			{
				  return driver.findElement(accountdetails);
			}
		  public WebElement clickEdit()
			{
				  return driver.findElement(EditDetails);
			}
		  public WebElement sendShortName()
			{
				  return driver.findElement(shortname);
			}
		  public WebElement sendconcactnumber()
			{
				  return driver.findElement(concactnumber);
			}
		  public WebElement sendAddress1()
			{
				  return driver.findElement(address1);
			}
		  public WebElement sendAddress2()
			{
				  return driver.findElement(address2);
			}
		  public WebElement sendAddress3()
			{
				  return driver.findElement(address3);
			}
		  public WebElement sendPincode()
			{
				  return driver.findElement(pincode);
			}
		  public WebElement sendCountry()
			{
				  return driver.findElement(country);
			}
		  public WebElement sendState()
			{
				  return driver.findElement(state);
			}
		  public WebElement sendCity()
			{
				  return driver.findElement(city);
			}
		  public WebElement sendWebsite()
			{
				  return driver.findElement(website);
			}
	  

	 
}
