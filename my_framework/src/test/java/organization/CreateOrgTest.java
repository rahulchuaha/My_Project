package organization;

import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LogOut;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.VarificationPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
	
	public static void main(String args[]) throws IOException, InterruptedException{
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromPropFile("bro");
		String password = fUtil.getDataFromPropFile("pass");
		String username = fUtil.getDataFromPropFile("username");
		String Url = fUtil.getDataFromPropFile("url");
		
		String orgName = fUtil.getDataFromExcelFile("org", 1, 0);
		
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		// opening empty browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// login
		driver.get(Url);
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		
		// creating organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrgPage op = new OrgPage(driver);
		op.getPlusBtn().click();
		op.getOrgNameField().sendKeys(orgName);
		op.getSaveBtn().click();
		
		// varifying the organization
		VarificationPage vp = new VarificationPage(driver);
		String actOrgName = vp.getCreatedOrgName().getText();
		if(actOrgName.contains(orgName)) {
			System.out.println("organization created successfully with org name " + actOrgName);
		}
		
		//logout
		Thread.sleep(2000);
		LogOut logout = new LogOut(driver);
		WebElement profileImg = logout.getProfile();
		Actions act = new Actions(driver);
		act.moveToElement(profileImg).build().perform();
		logout.getSignOutLink().click();
		
		// closing the browser
		Thread.sleep(2000);
		driver.close();
		
		// this is my project
		
		
	}

}
