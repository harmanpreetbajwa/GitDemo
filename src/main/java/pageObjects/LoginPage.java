package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
		By userName =By.id("user_email");
		By pass =By.id("user_password");
		By submit = By.name("commit");
		
		public WebElement Email() {
			return driver.findElement(userName);	
		}
		
		public WebElement Password() {
			return driver.findElement(pass);	
		}
		
		public WebElement LoginButton() {
			return driver.findElement(submit);	
		}
	}


