package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
public  WebDriver driver;

public LandingPage(WebDriver driver){
	this.driver=driver;
}

By Login = By.linkText("Login");
By Title = By.xpath("//div[@class='text-center']/h2");
By NavigationBar = By.xpath("//div[@class='container']/nav/ul");

public WebElement LoginLink() {
	return driver.findElement(Login);
	
}

public WebElement getTitle() {
	return driver.findElement(Title);	
}

public WebElement Navigationlinks() {
	return driver.findElement(NavigationBar);
	
}

}
