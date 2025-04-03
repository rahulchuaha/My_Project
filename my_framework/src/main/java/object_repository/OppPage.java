package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppPage {
	
	public WebDriver driver;
	public OppPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOpp;
	public WebElement getCreateOpp() {
		return createOpp;
	}
	
	@FindBy(name="potentialname")
	private WebElement oppNameField;
	public WebElement getOppNameField() {
		return oppNameField;
	}
	
	@FindBy(id="related_to_type")
	private WebElement relatedTo;
	public WebElement getRelatedTo() {
		return relatedTo;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement relPlus;
	public WebElement getRelPlus() {
		return relPlus;
	}
	
	@FindBy(name="closingdate")
	private WebElement dateField;
	public WebElement getDateField() {
		return dateField;
	}
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement oppSaveBtn;
	public WebElement getOppSaveBtn() {
		return oppSaveBtn;
	}
	
	@FindBy(name="opportunity_type")
	private WebElement typeField;
	public WebElement getTypeField() {
		return typeField;
	}

}
