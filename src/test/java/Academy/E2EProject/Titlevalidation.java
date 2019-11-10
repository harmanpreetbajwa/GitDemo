package Academy.E2EProject;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class Titlevalidation extends Base{
	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));	
		log.info("Navigated to url");
	}
	@Test
	public void baseNavigation() {
		LandingPage lp = new LandingPage(driver);
		String text = lp.getTitle().getText();
		Assert.assertEquals(text, "FEATURED COURSES");
		Assert.assertTrue(lp.Navigationlinks().isDisplayed());
	}

	@AfterTest
	public void ClosingDriver() {
		driver.close();
		driver=null;
	}
	}
