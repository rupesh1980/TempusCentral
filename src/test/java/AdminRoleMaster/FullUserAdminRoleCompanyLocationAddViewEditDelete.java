package AdminRoleMaster;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AccountDetailsPageObjects.loginPageObjects;
import AdminRoleMasterPajeObjects.AdminRoleFullAccessUser;
import AdminRoleMasterPajeObjects.adminRoleFullAccessCompanyLocations;
import AdminRoleMasterPajeObjects.fieldsAreBlank;
import AdminRoleMasterPajeObjects.fullAccessUserDelete;
import TempsusCentralLoginPageSetup.LoginPageSetup;
import companyDetailsPageObjects.CompanyDetailsFieldsBlank;
import companyDetailsPageObjects.ParentLocation;
import companyDetailsPageObjects.addLocation;

public class FullUserAdminRoleCompanyLocationAddViewEditDelete extends LoginPageSetup {

	public WebDriver driver;
	WebDriverWait wait;
	private By clickAdd = By.id("btnSaveUserRole");
	private By clickAdminRoleMaster = By.xpath("//*[contains(text(),\' Admin Role Master\')]");
	private By adminRoleName = By.id("txtRoleName");
	private By roleType = By.id("droptype");
	private By update = By.id("btnSaveUserRole");
	private By Yes = By.id("YesDeleteUserRole");
	private By CompanyLocationView = By.xpath("//*[@id=\'TableContent1\']/div[3]/div/div[2]/label/span");
	private By CompanyLocationEdit = By.xpath("//*[@id=\'TableContent1\']/div[3]/div/div[4]/label/span");
	private By CompanyLocationDelete = By.xpath("//*[@id=\'TableContent1\']/div[3]/div/div[5]/label/span");
	private By CompanyLocationAdd = By.xpath("//*[@id=\'TableContent1\']/div[3]/div/div[3]/label/span");

	// protected By addoptions=By.id("AddOptions");
	@BeforeTest
	public void executebrowser() throws IOException {
		driver = browserSetup();

	}

	@SuppressWarnings("unused")
	@Test(priority = 1, enabled = true)
	public void login() throws InterruptedException, IOException {
		try {

			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			loginPageObjects lp = new loginPageObjects(driver);
			lp.getUsername().sendKeys(prop.getProperty("username"));
			// log.info("User has entered username");
			// System.out.println(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
			// log.info("User has entered password");
			lp.login().click();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = false)
	public void fullAccessUserViewCompanyLocationOnly() throws InterruptedException {
		CompanyDetailsFieldsBlank cd = new CompanyDetailsFieldsBlank(driver);

		cd.clickMaster().click();

		fieldsAreBlank fb = new fieldsAreBlank(driver);
		fb.clickAdminRoleMaster().click();
		fullAccessUserDelete full = new fullAccessUserDelete(driver);
		WebElement table = driver.findElement(By.xpath("//*[@id=\'tblAdminRole\']/tbody"));
		// List<WebElement> tablerows=table.findElements(By.tagName("td"));
		List<WebElement> tablerows = table.findElements(By.xpath("//tr[@style=\'cursor: pointer;\']/td[2]"));

		for (int i = 0; i < tablerows.size(); i++) {
			if (tablerows.get(i).getText().equalsIgnoreCase("MyRole")) {
				tablerows.get(i).click();
				// driver.findElements(By.xpath("//img[@class=\'DeleteUserRole\']")).get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		adminRoleFullAccessCompanyLocations arcl = new adminRoleFullAccessCompanyLocations(driver);

		boolean viewresult = driver.findElement(By.id("ViewCheckbox/1/26")).isSelected();
		if (viewresult == false) {
			arcl.clickCompanyLocationView().click();
		} else {
			arcl.clickCompanyLocationView().click();

		}
		boolean editresult = driver.findElement(By.id("EditCheckboxs/1/1")).isSelected();

		if (editresult == true) {
			arcl.clickCompanyLocationEditAccess().click();

		}
		boolean deleteresult = driver.findElement(By.id("DeleteCheckbox/1/1")).isSelected();

		if (deleteresult == true) {
			arcl.clickCompanyLocationDeleteAccess().click();

		}

		arcl.clickUpdate().click();
		// arcl.clickCompanyLocationEditAccess().click();
		Thread.sleep(2000);
		WebElement table1 = driver.findElement(By.xpath("//*[@id=\'tblAdminRole\']/tbody"));

		List<WebElement> tablerows1 = table.findElements(By.xpath("//tr[@style=\'cursor: pointer;\']/td[2]"));

		for (int i = 0; i < tablerows1.size(); i++) {
			if (tablerows1.get(i).getText().equalsIgnoreCase("MyRole")) {
				tablerows1.get(i).click();
				// driver.findElements(By.xpath("//img[@class=\'DeleteUserRole\']")).get(i).click();
				break;
			}
		}

	}

	@Test(priority = 3, enabled = false)
	public void fullAccessUserEditAccountOnly() throws InterruptedException {
		CompanyDetailsFieldsBlank cd = new CompanyDetailsFieldsBlank(driver);

		cd.clickMaster().click();

		fieldsAreBlank fb = new fieldsAreBlank(driver);
		fb.clickAdminRoleMaster().click();
		fullAccessUserDelete full = new fullAccessUserDelete(driver);
		WebElement table = driver.findElement(By.xpath("//*[@id=\'tblAdminRole\']/tbody"));
		// List<WebElement> tablerows=table.findElements(By.tagName("td"));
		List<WebElement> tablerows = table.findElements(By.xpath("//tr[@style=\'cursor: pointer;\']/td[2]"));

		for (int i = 0; i < tablerows.size(); i++) {
			if (tablerows.get(i).getText().equalsIgnoreCase("MyRole")) {
				tablerows.get(i).click();
				// driver.findElements(By.xpath("//img[@class=\'DeleteUserRole\']")).get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		adminRoleFullAccessCompanyLocations arcl = new adminRoleFullAccessCompanyLocations(driver);

		// arcl.clickCompanyLocationView().click();
		arcl.clickCompanyLocationEditAccess().click();
		arcl.clickUpdate().click();

		Thread.sleep(2000);
		WebElement table1 = driver.findElement(By.xpath("//*[@id=\'tblAdminRole\']/tbody"));

		List<WebElement> tablerows1 = table.findElements(By.xpath("//tr[@style=\'cursor: pointer;\']/td[2]"));

		for (int i = 0; i < tablerows1.size(); i++) {
			if (tablerows1.get(i).getText().equalsIgnoreCase("MyRole")) {
				tablerows1.get(i).click();
				// driver.findElements(By.xpath("//img[@class=\'DeleteUserRole\']")).get(i).click();
				break;
			}
		}

	}

	@Test(priority = 4, enabled = false)
	public void fullAccessUserDeleteRecord() throws InterruptedException {
		CompanyDetailsFieldsBlank cd = new CompanyDetailsFieldsBlank(driver);

		cd.clickMaster().click();

		fieldsAreBlank fb = new fieldsAreBlank(driver);
		fb.clickAdminRoleMaster().click();
		fullAccessUserDelete full = new fullAccessUserDelete(driver);
		WebElement table = driver.findElement(By.xpath("//*[@id=\'tblAdminRole\']/tbody"));
		// List<WebElement> tablerows=table.findElements(By.tagName("td"));
		List<WebElement> tablerows = table.findElements(By.xpath("//tr[@style=\'cursor: pointer;\']/td[2]"));

		for (int i = 0; i < tablerows.size(); i++) {
			if (tablerows.get(i).getText().equalsIgnoreCase("MyRole")) {
				tablerows.get(i).click();
				// driver.findElements(By.xpath("//img[@class=\'DeleteUserRole\']")).get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		adminRoleFullAccessCompanyLocations arcl = new adminRoleFullAccessCompanyLocations(driver);

		// arcl.clickCompanyLocationView().click();
		arcl.clickCompanyLocationDeleteAccess().click();
		arcl.clickUpdate().click();

		Thread.sleep(2000);
		WebElement table1 = driver.findElement(By.xpath("//*[@id=\'tblAdminRole\']/tbody"));

		List<WebElement> tablerows1 = table.findElements(By.xpath("//tr[@style=\'cursor: pointer;\']/td[2]"));

		for (int i = 0; i < tablerows1.size(); i++) {
			if (tablerows1.get(i).getText().equalsIgnoreCase("MyRole")) {
				tablerows1.get(i).click();
				// driver.findElements(By.xpath("//img[@class=\'DeleteUserRole\']")).get(i).click();
				break;
			}
		}

	}

	@Test(priority = 2, enabled = true)
	public void fullUseAccessAddEditOnly() throws InterruptedException {
		CompanyDetailsFieldsBlank cd = new CompanyDetailsFieldsBlank(driver);

		cd.clickMaster().click();

		fieldsAreBlank fb = new fieldsAreBlank(driver);
		fb.clickAdminRoleMaster().click();
		fullAccessUserDelete full = new fullAccessUserDelete(driver);
		WebElement table = driver.findElement(By.xpath("//*[@id=\'tblAdminRole\']/tbody"));
		// List<WebElement> tablerows=table.findElements(By.tagName("td"));
		List<WebElement> tablerows = table.findElements(By.xpath("//tr[@style=\'cursor: pointer;\']/td[2]"));

		for (int i = 0; i < tablerows.size(); i++) {
			if (tablerows.get(i).getText().equalsIgnoreCase("MyRole")) {
				tablerows.get(i).click();
				// driver.findElements(By.xpath("//img[@class=\'DeleteUserRole\']")).get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		adminRoleFullAccessCompanyLocations arcl = new adminRoleFullAccessCompanyLocations(driver);

	
		
		arcl.clickCompanyLocationEditAccess().click();
		arcl.clickCompanyLocationDeleteAccess().click();
		arcl.clickCompanyLocationAddAccess().click();
		arcl.clickUpdate().click();

		Thread.sleep(2000);
		WebElement table1 = driver.findElement(By.xpath("//*[@id=\'tblAdminRole\']/tbody"));

		List<WebElement> tablerows1 = table1.findElements(By.xpath("//tr[@style=\'cursor: pointer;\']/td[2]"));

		for (int i = 0; i < tablerows1.size(); i++) {
			if (tablerows1.get(i).getText().equalsIgnoreCase("MyRole")) {
				tablerows1.get(i).click();
				// driver.findElements(By.xpath("//img[@class=\'DeleteUserRole\']")).get(i).click();
				break;
			}
		}

	}

	@AfterTest(enabled = true)
	public void teardown() {
		driver.close();
	}

}
