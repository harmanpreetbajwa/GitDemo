package Stepdefinations;

import Academy.E2EProject.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class stepdefinations extends Base {
	
	
	@Given("^User has userName and PassWord$")
	public void user_has_userName_and_PassWord() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeBrowser();
		
	}

	@Given("^User navigate to landing page$")
	public void user_navigate_to_landing_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://www.qaclickacademy.com/");
	 
	}

	@Given("^clicks login button$")
	public void clicks_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage lp = new LandingPage(driver);
	
		lp.LoginLink().click();
	   
	}

	@When("^User entered \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_entered_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage sp = new LoginPage(driver);
		sp.Email().sendKeys(arg1);
		sp.Password().sendKeys(arg2);
	    
	}
	@Then("^Page should display invalidusername and password$")
	public void page_should_display_invalidusername_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage sp = new LoginPage(driver);
		sp.LoginButton().click();
	}


	



}
