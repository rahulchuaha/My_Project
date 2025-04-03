package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Calendar")
	private WebElement calenderLink;
	
	public WebElement getCalenderLink() {
		return calenderLink;
	}
	
	@FindBy(linkText="Leads")
	private WebElement leadLink;
	
	public WebElement getLeadLink() {
		return leadLink;
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contLink;
	
	public WebElement getContLink() {
		return contLink;
	}
	
	@FindBy(linkText="Opportunities")
	private WebElement oppLink;
	
	public WebElement getOppLink() {
		return oppLink;
	}
	
	@FindBy(linkText="Products")
	private WebElement prodLink;
	
	public WebElement getProdLink() {
		return prodLink;
	}
	
	@FindBy(linkText="Documents")
	private WebElement documentLink;
	
	public WebElement getDocumentLink() {
		return documentLink;
	}
	
	@FindBy(linkText="Email")
	private WebElement emailLink;
	
	public WebElement getEmailLink() {
		return emailLink;
	}
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement TticketLink;
	
	public WebElement getTticketLink() {
		return TticketLink;
	}
	
	@FindBy(linkText="Dashboard")
	private WebElement dashboardLink;
	
	public WebElement getDashboardLink() {
		return dashboardLink;
	}
	
	
}
