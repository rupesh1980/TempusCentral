package EmployeeFormSetupPajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TempsusCentralLoginPageSetup.LoginPageSetup;

@SuppressWarnings("unused")
public class fieldsAreBlank{
	 public WebDriver driver;
	 private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	 private By employeeForm=By.xpath("//*[contains(text(),\' Employee Form Setup\')]");
	 private By add=By.xpath("//input[@id=\'btnAddParameter\']");

	 public fieldsAreBlank(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 public WebElement clickOnMaster()
	 {
		 return driver.findElement(master);
	 }
	 public WebElement clickOnEmployeeForm()
	 {
		 return driver.findElement(employeeForm);
	 }
	 public WebElement clickAdd()
	 {
		 return driver.findElement(add);
	 }
}
