package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	
	WebDriver driver;
	public OrgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusBtn;
	public WebElement getPlusBtn() {
		return plusBtn;
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameField;
	public WebElement getOrgNameField() {
		return orgNameField;
	}
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}


}
