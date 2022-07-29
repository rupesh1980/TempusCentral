package designationMasterPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class recordUpdate {

	public WebDriver driver;
	private By shorname=By.id("txtDesiShortName");
	private By designationName=By.id("txtDesignationName");
	private By designationType=By.id("dropDesignationType");
	private By DesignationMaster=By.xpath("//*[contains(text(),\' Designation Master\')]");
	private By addbutton=By.id("btnDesignationSave");

	public recordUpdate(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement shortName()
	{
		return driver.findElement(shorname);
	}
	public WebElement designationName()
	{
		return driver.findElement(designationName);
	}
	public WebElement designationType()
	{
		return driver.findElement(designationType);
	}
	public WebElement clickDesignationMaster()
	{
		return driver.findElement(DesignationMaster);
	}
	public WebElement clickAdd()
	{
		return driver.findElement(addbutton);
	}

}

