package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	// Initialize the driver
	public WebDriver initializeDriver() throws IOException {
		prop= new Properties();
		FileInputStream fis=new FileInputStream("src/main/java/Resources/data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		String pageUrl=prop.getProperty("url");
		System.out.println(browserName);
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			
		} 
		else if (browserName.equals("ie")) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}

	public void getScreenShotPath(String failedMethod, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+failedMethod+".png";
		System.out.println("Destination File name"+destFile);
		FileUtils.copyFile(source, new File(destFile));
	}
}
