package Academy.E2EProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base{

	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Browser launched Successfully");
	}
	
	@Test(dataProvider="getData")
	public void baseNavigation(String username, String password ) {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		LoginPage sp = new LoginPage(driver);
		lp.LoginLink().click();
		sp.Email().sendKeys(username);
		sp.Password().sendKeys(password);
		sp.LoginButton().click();
		log.debug("successfully entered username and password ");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0]="non-restricteduser@email.com";
		data[0][1]="nonrestricted123";
	
		data[1][0]="restricteduser@email.com";
		data[1][1]="restricted123";	
		return data;
	}
	
	@AfterTest
	public void ClosingDriver() {
		driver.close();
		driver=null;
	}
}
