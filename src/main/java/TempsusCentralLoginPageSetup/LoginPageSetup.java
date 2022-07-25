package TempsusCentralLoginPageSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class LoginPageSetup {

	public Properties prop;
	 WebDriver driver;
	
	
	@Test
	public WebDriver browserSetup() throws IOException
	{
		 prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\demo\\data.properties");
		prop.load(file);		
	    String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		return driver;
	}

	public void getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\reports\\+"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationfile));
		
	}
}
