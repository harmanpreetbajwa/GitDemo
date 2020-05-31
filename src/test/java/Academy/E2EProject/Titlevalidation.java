package Academy.E2EProject;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import pageObjects.LandingPage;

public class Titlevalidation extends Base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));	
		log.info("Navigated to url");
	}
	
	
	@Test
	public void baseNavigation() throws IOException {
		LandingPage lp = new LandingPage(driver);
		//driver = initializeBrowser();
		String text = lp.getTitle().getText();
		Assert.assertEquals(text, "FEATURED COURSES");
		System.out.println("verified");
	}
	
	@Test
	public void baseNavigationLink() {
	LandingPage lp = new LandingPage(driver);
	Assert.assertTrue(lp.Navigationlinks().isDisplayed());	
	log.info("Links are Asserted");
	}

	@AfterTest
	public void ClosingDriver() {
		driver.close();
		driver=null;
	}
	}
