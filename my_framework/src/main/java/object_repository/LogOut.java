package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
	
	public WebDriver driver;
	
	public LogOut(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement profile;
	public WebElement getProfile() {
		return profile;
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	public WebElement getSignOutLink() {
		return signOutLink;
	}

}
