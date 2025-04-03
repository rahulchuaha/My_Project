package product;

import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.ProductPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProductTest {
	
	public void createProductTest() throws IOException{
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromPropFile("bro");
		String userName = fUtil.getDataFromPropFile("username");
		String password = fUtil.getDataFromPropFile("pass");
		String Url = fUtil.getDataFromPropFile("url");
		
		String productName = fUtil.getDataFromExcelFile("org", 4, 0);
		
		// opening browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(Url);
		
		// login
		LoginPage lp = new LoginPage(driver);
		lp.getUser().sendKeys(userName);
		lp.getPass().sendKeys(password);
		lp.getLoginBtn().click();
		
		// creating product
		
		HomePage hp = new HomePage(driver);
		hp.getProdLink().click();
		ProductPage pp = new ProductPage(driver);
		pp.getCreateLinkBtn().click();
		pp.getProductName().sendKeys(productName);
		pp.getPropSaveBtn().click();
		
		// varifiacation
		
		
		
	}

}
