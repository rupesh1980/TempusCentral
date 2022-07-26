package DepartmentMasterPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addNewDeptWithlocation {
  public WebDriver driver;
  private By clickDepartment=By.xpath("//a[@href=\'/Master/DepartmentMaster\']");
 
  private By shortname=By.id("txtShortName");
  private By departmentName=By.id("txtDepartmentName");
  private By clickAdd=By.id("btnDepartmentSave");
  public addNewDeptWithlocation(WebDriver driver)
  {
	  this.driver=driver;
	  
  }
  public WebElement clickDepartment()
  {
	  return driver.findElement(clickDepartment);
  }
  public WebElement clickAdd()
  {
	  return driver.findElement(clickAdd);
  }
  public WebElement sendShortName()
  {
	  return driver.findElement(shortname);
  }
  public WebElement sendDepartmentName()
  {
	  return driver.findElement(departmentName);
  }
}
