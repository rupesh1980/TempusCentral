package EmployeeFormSetupPajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TempsusCentralLoginPageSetup.LoginPageSetup;

@SuppressWarnings("unused")
public class addTextasNewField{
	 public WebDriver driver;
	 private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	 private By employeeForm=By.xpath("//*[contains(text(),\' Employee Form Setup\')]");
	 private By add=By.xpath("//input[@id=\'btnAddParameter\']");
	 private By dropdown=By.id("dropDownStatus");
	 private By textparameter=By.id("txtParametername");
	 private By addMsg=By.xpath("//*[@id=\'toast-container\']/div/div");
	 private By addedtoform=By.xpath("//*[@id=\'toast-container\']/div[2]/div");




	 public addTextasNewField(WebDriver driver)
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
	 public WebElement selectDropDown()
	 {
		 return driver.findElement(dropdown);
	 }
	 public WebElement textParameterName()
	 {
		 return driver.findElement(textparameter);
	 }
	 public WebElement addMessage()
	 {
		 return driver.findElement(addMsg);
	 }
	 public WebElement addedtoFormMsg()
	 {
		 return driver.findElement(addedtoform);
	 }
}
