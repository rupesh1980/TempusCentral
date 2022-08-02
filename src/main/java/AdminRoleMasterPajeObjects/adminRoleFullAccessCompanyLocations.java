package AdminRoleMasterPajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class adminRoleFullAccessCompanyLocations {
   public WebDriver driver;
	
   private By clickAdd=By.id("btnSaveUserRole");
   private By clickAdminRoleMaster=By.xpath("//*[contains(text(),\' Admin Role Master\')]");
   private By adminRoleName=By.id("txtRoleName");
   private By update=By.id("btnSaveUserRole");
   private By CompanyLocationView=By.xpath("//*[@id=\'TableContent1\']/div[3]/div/div[2]/label/span");
   private By CompanyLocationEdit=By.xpath("//*[@id=\'TableContent1\']/div[3]/div/div[4]/label/span");
   private By CompanyLocationDelete=By.xpath("//*[@id=\'TableContent1\']/div[3]/div/div[5]/label/span");
   private By CompanyLocationAdd=By.xpath("//*[@id=\'TableContent1\']/div[3]/div/div[3]/label/span");
  private By selectemp=By.xpath("//*[@id=\'tblEmployeeList_wrapper\']/div[1]/div[1]/div/table/thead/tr/th[1]/label/span");




    public adminRoleFullAccessCompanyLocations(WebDriver driver)
    {
    	this.driver=driver;
    }
    public WebElement clickAdminRoleMaster()
    {
    	return driver.findElement(clickAdminRoleMaster);
    }    	

    public WebElement clickAdd()
    {
    	return driver.findElement(clickAdd);
    }
    public WebElement sendAdminRoleName()
    {
    	return driver.findElement(adminRoleName);
    }
    public WebElement clickUpdate()
    {
    	return driver.findElement(update);
    }
    public WebElement clickCompanyLocationView()
    {
    	return driver.findElement(CompanyLocationView);
    }
    public WebElement clickCompanyLocationEditAccess()
    {
    	return driver.findElement(CompanyLocationEdit);
    }
    public WebElement clickCompanyLocationDeleteAccess()
    {
    	return driver.findElement(CompanyLocationDelete);
    }
    public WebElement clickCompanyLocationAddAccess()
    {
    	return driver.findElement(CompanyLocationAdd);
    }
    public WebElement clickSelectEmp()
    {
    	return driver.findElement(selectemp);
    }
}

