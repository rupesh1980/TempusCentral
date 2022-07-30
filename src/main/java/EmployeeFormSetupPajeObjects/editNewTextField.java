package EmployeeFormSetupPajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TempsusCentralLoginPageSetup.LoginPageSetup;

@SuppressWarnings("unused")
public class editNewTextField{
	 public WebDriver driver;
	 private By master=By.xpath("//a[@id=\'MainMenudiv_1\']/img");
	 private By employeeForm=By.xpath("//*[contains(text(),\' Employee Form Setup\')]");
	 private By add=By.xpath("//input[@id=\'btnAddParameter\']");
	 private By dropdown=By.id("dropDownStatus");
	 private By textparameter=By.id("txtParametername");
	 private By addMsg=By.xpath("//*[@id=\'toast-container\']/div/div");
	 private By addedtoform=By.xpath("//*[@id=\'toast-container\']/div[2]/div");
	 private By delete=By.id("YesDeleteEmployeeParamDelete");
	 private By delmessage=By.xpath("//*[@id=\'toast-container\']/div/div");
	 private By clickyes=By.id("YesDeleteEmployeeField");
	 private By editField=By.xpath("//img[@class=\'EditExtraParam\']");
	 private By fielddeleted=By.xpath("//*[@id=\'toast-container\']/div/div");
	 private By editfieldyes=By.id("YesEditEmpParam");




	 public editNewTextField(WebDriver driver)
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
	 public WebElement delmsg()
	 {
		 return driver.findElement(delmessage);
	 }
	 public WebElement clickYes()
	 {
		 return driver.findElement(clickyes);
	 }
	 public WebElement delete()
	 {
		 return driver.findElement(fielddeleted);
	 }
	 public WebElement editField()
	 {
		 return driver.findElement(editfieldyes);
	 }
	 
}
