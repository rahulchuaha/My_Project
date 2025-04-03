package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement user;
	
	public WebElement getUser() {
		return user;
	}
	
	@FindBy(name="user_password")
	private WebElement pass;
	
	public WebElement getPass() {
		return pass;
	}
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login(String USERNAME, String PASSWORD) {
		getUser().sendKeys(USERNAME);
		getPass().sendKeys(PASSWORD);
		getLoginBtn().click();
	}
	

}
