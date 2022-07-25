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

public class MoreDetailsPageObjects {

	 public WebDriver driver;
	  protected By selectFromDropDown=By.xpath("//select[@class=\' floating-select ClassDropxtraParameter\']");
		//  protected By otherdetails=By.xpath("//input[@id=\'txt3236\']");
		  protected By otherdetails=By.xpath("//select[@style=\'cursor:pointer\']");
		  protected By update=By.id("btnUpdateCompany");
		  protected By moredetails=By.xpath("//*[contains(text(),\' More Details\')]");
		  protected By editDetails=By.id("btnCompanyform");

	     protected By addTextForNewField= By.id("btnCompanyAddParameter");
	     protected By txtField=By.xpath("//div[@style=\'width:100% !important;\']/input");
	     protected By dropdownfield=By.xpath("//div[@style=\'width:100%;margin-top: 10%;\']/select");
	  
		  public MoreDetailsPageObjects(WebDriver driver)
		  {
			  this.driver=driver;
		  }
		   
	   
	  @Test
	  public WebElement clickOnMaster()
		{
			  return driver.findElement(moredetails);
		}
	  @Test
	  public WebElement clickEditDetals()
		{
			  return driver.findElement(editDetails);
		}
	  @Test
	  public WebElement sendDataTextField()
		{
			  return driver.findElement(txtField);
		}
	  @Test
	  public WebElement selectDropDown()
		{
			  return driver.findElement(dropdownfield);
		}
		
		

}
