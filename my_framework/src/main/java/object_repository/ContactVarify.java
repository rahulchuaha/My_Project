package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactVarify {
	
	public WebDriver driver;
	public ContactVarify(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Last Name")
	private WebElement actName;
	public WebElement getActName() {
		return actName;
	}
	
	@FindBy(id="dtlview_Birthdate")
	private WebElement actDate;
	public WebElement getActDate() {
		return actDate;
	}

}
