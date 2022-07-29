package AdminRoleMasterPajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fullAccessUserDelete {
   public WebDriver driver;
	WebDriverWait wait;

   private By clickAdd=By.id("btnSaveUserRole");
   private By clickAdminRoleMaster=By.xpath("//*[contains(text(),\' Admin Role Master\')]");
   private By adminRoleName=By.id("txtRoleName");
   private By update=By.id("YesDeleteUserRole");
   private By message=By.xpath("//*[@id=\'toast-container\']/div/div");




    public fullAccessUserDelete(WebDriver driver)
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
  
    public WebElement clickYes()
    {
    	return driver.findElement(update);
    }
    public WebElement getMessage()
    {
    	return driver.findElement(message);
    }
}

