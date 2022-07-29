package AdminRoleMasterPajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminRoleFullAccessUser {
   public WebDriver driver;
	
   private By clickAdd=By.id("btnSaveUserRole");
   private By clickAdminRoleMaster=By.xpath("//*[contains(text(),\' Admin Role Master\')]");
   private By adminRoleName=By.id("txtRoleName");
   private By update=By.id("btnSaveUserRole");




    public AdminRoleFullAccessUser(WebDriver driver)
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
    
}

