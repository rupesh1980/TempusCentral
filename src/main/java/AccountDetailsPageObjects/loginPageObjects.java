package AccountDetailsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageObjects {
	
    WebDriver driver;
	 protected By username=By.id("Central_UserName");
     protected By password=By.id("Central_Password");
     protected By login=By.id("btnLoginCentral");
     protected By uesrprofile=By.xpath("//img[@class=\"h-75 align-self-end\"]");
     protected By logout=By.id("userLogout");
     protected By admin=By.xpath("//a[@id=\"MainMenudiv_2\"]/img");
     
     public loginPageObjects(WebDriver driver)
     {
    	 this.driver=driver;
     }
     public WebElement getUsername()
     {
    	 return driver.findElement(username);
     }
     public WebElement getPassword()
     {
    	 return driver.findElement(password);
     }
     public WebElement login()
     {
    	 return driver.findElement(login);
     }
     public String getTitle()
     {
    	 return driver.getTitle();
     }
}
