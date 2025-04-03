package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VarificationPage {
	
	public WebDriver driver;
	
	public VarificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement createdOrgName;
	public WebElement getCreatedOrgName() {
		return createdOrgName;
	}

}
