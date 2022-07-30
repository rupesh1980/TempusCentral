package DepartmentMasterPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fieldsBlank {
  public WebDriver driver;
  private By clickDepartment=By.xpath("//*[@id=\'li_DepartmentMaster\']/a/span");
  private By clickAdd=By.id("btnDepartmentSave");
  public fieldsBlank(WebDriver driver)
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
}
