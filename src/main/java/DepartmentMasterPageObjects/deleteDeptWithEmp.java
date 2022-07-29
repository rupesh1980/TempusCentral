package DepartmentMasterPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class deleteDeptWithEmp {
  public WebDriver driver;
  private By clickDepartment=By.xpath("//a[@href=\'/Master/DepartmentMaster\']");
 
  private By shortname=By.id("txtShortName");
  private By departmentName=By.id("txtDepartmentName");
  private By clickAdd=By.id("btnDepartmentSave");
  private By delete=By.xpath("//i[@class=\'la la-trash icon-lg mt-1 mr-2\']");
  private By deletebutton= By.id("YesDeleteDepartment");
  private By SelectParentDept=By.id("DropDepartmentCode");
  private By clickarrow=By.xpath("//*[@id=\'8171\']/i");
  private By clickYes=By.id("YesDeleteDepartment");
  private By deletedept=By.id("YesUpdateEmployeeDept");

 


  public deleteDeptWithEmp(WebDriver driver)
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
  public WebElement delete()
  {
	  return driver.findElement(delete);
  }
  public WebElement clickYes()
  {
	  return driver.findElement(deletebutton);
  }
  public WebElement clickParentDept()
  {
	  return driver.findElement(SelectParentDept);
  }
  public WebElement clickArrow()
  {
	  return driver.findElement(clickarrow);
  }
  public WebElement clickDeleteEmp()
  {
	  return driver.findElement(deletedept);
  }
  
}
