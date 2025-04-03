package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppVarify {

	public WebDriver driver;
	public OppVarify(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement createOppName;
	public WebElement getCreateOppName() {
		return createOppName;
	}
	
	@FindBy(xpath="//td[@class='dvtCellInfo']")
	private WebElement dateVarify;
	public WebElement getDateVarify() {
		return dateVarify;
	}
}
