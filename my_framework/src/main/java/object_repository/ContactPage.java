package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	public WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContLink;
	public WebElement getCreateContLink() {
		return createContLink;
	}
	
	@FindBy(name="salutationtype")
	private WebElement title;
	public WebElement getTitle() {
		return title;
	}
	
	
	@FindBy(name="firstname")
	private WebElement firstName;
	public WebElement getFirstName() {
		return firstName;
	}
	
	@FindBy(name="lastname")
	private WebElement lastName;
	public WebElement getLastName() {
		return lastName;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement createOrgLink;
	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(id="jscal_field_birthday")
	private WebElement birthDate;
	public WebElement getBirthDate() {
		return birthDate;
	}
}
