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


public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver initializeBrowser() throws IOException {
		
		
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Harmanpreet Singh\\SELENIUMNEWWORKSPACE\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//String browserName = System.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Harmanpreet Singh\\Desktop\\SELENIUM WorkSPace\\chromedriver_win32_83.exe");
			 driver = new ChromeDriver();
		
		}
		
		else if(browserName.equals("headless")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Harmanpreet Singh\\Desktop\\SELENIUM WorkSPace\\chromedriver_win32_83.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			 driver = new ChromeDriver(options);
		
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Harmanpreet Singh\\Desktop\\SELENIUM WorkSPace\\geckodriver.exe");
			 driver = new FirefoxDriver();	
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
		
}
