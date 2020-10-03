package Academy.E2EProject;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver initializeBrowser() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Harmanpreet Singh\\SELENIUMNEWWORKSPACE\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		

if(browserName.contains("chrome"))
{
	WebDriverManager.chromedriver().setup();
	 ChromeOptions options =new ChromeOptions();
	 if(browserName.contains("headless"))
	 {
	  options.addArguments("headless");
	 }
driver= new ChromeDriver(options);
	
}
else if (browserName.equals("firefox"))
{
	
	 driver= new FirefoxDriver();

}
else if (browserName.equals("IE"))
{

}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	public void Screenshot(String result) throws IOException {
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	}
	
}
