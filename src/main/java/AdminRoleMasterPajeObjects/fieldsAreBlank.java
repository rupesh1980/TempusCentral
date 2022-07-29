package AdminRoleMasterPajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fieldsAreBlank {
   public WebDriver driver;
	
   private By clickAdd=By.id("btnSaveUserRole");
   private By clickAdminRoleMaster=By.xpath("//*[contains(text(),\' Admin Role Master\')]");

    public fieldsAreBlank(WebDriver driver)
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
}
