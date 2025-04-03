package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	
	public WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createLinkBtn;
	public WebElement getCreateLinkBtn() {
		return createLinkBtn;
	}
	
	@FindBy(name="productname")
	private WebElement productName;
	public WebElement getProductName() {
		return productName;
	}
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement prodSaveBtn;
	public WebElement getPropSaveBtn() {
		return prodSaveBtn;
	}
	
	

}
