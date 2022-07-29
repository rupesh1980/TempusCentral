package designationMasterPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class recordDelete {

	public WebDriver driver;
	private By shorname=By.id("txtDesiShortName");
	private By designationName=By.id("txtDesignationName");
	private By designationType=By.id("dropDesignationType");
	private By DesignationMaster=By.xpath("//*[contains(text(),\' Designation Master\')]");
	private By addbutton=By.id("btnDesignationSave");
	private By deleteRecord=By.className("DeleteDesignation");
	private By yes=By.id("YesDeleteDesignation");



	public recordDelete(WebDriver driver)
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
	public WebElement clickDelete()
	{
		return driver.findElement(deleteRecord);
	}
	public WebElement clickYes()
	{
		return driver.findElement(yes);
	}

}

