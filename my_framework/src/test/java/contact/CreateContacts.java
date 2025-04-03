package contact;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import object_repository.ContactPage;
import object_repository.ContactVarify;
import object_repository.HomePage;
import object_repository.LogOut;
import object_repository.LoginPage;

public class CreateContacts {

	@Test
	public void createContWithOrgTest() throws IOException {
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromPropFile("bro");
		String Url = fUtil.getDataFromPropFile("url");
		String userName = fUtil.getDataFromPropFile("username");
		String password = fUtil.getDataFromPropFile("pass");

		String orgName = fUtil.getDataFromExcelFile("org", 1, 0);
		String oppName = fUtil.getDataFromExcelFile("org", 2, 0);

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

		// creating contacts
		HomePage hp = new HomePage(driver);
		hp.getContLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContLink().click();
		WebElement title = cp.getTitle();
		Select sel = new Select(title);
		sel.selectByIndex(1);
		cp.getFirstName().sendKeys("rahul");
		cp.getLastName().sendKeys("chauhan");
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
		cp.getCreateOrgLink().click();
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			System.out.println(id);
			driver.switchTo().window(id);
		}
		driver.findElement(By.linkText("orgName579")).click();

		driver.switchTo().window(parentId);

		// save
		cp.getSaveBtn().click();

//		varification
		ContactVarify cv = new ContactVarify(driver);
		String enteredName = cv.getActName().getText();
		if (enteredName.equals("chauhan")) {
			System.out.println("contact created successfully!!!!");
		}

		// logout
		LogOut logout = new LogOut(driver);
		WebElement profile = logout.getProfile();
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		logout.getSignOutLink().click();
		// closing the browser
		driver.close();

	}

	@Test
	public void createContWithBirthDateTest() throws IOException {
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromPropFile("bro");
		String Url = fUtil.getDataFromPropFile("url");
		String userName = fUtil.getDataFromPropFile("username");
		String password = fUtil.getDataFromPropFile("pass");

		String orgName = fUtil.getDataFromExcelFile("org", 1, 0);
		String oppName = fUtil.getDataFromExcelFile("org", 2, 0);
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

		// creating contacts
		HomePage hp = new HomePage(driver);
		hp.getContLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContLink().click();
		WebElement title = cp.getTitle();
		Select sel = new Select(title);
		sel.selectByIndex(1);
		cp.getFirstName().sendKeys("rahul");
		cp.getLastName().sendKeys("chauhan");
		cp.getBirthDate().sendKeys("2000-07-05");
		// save
		cp.getSaveBtn().click();

//		varification

		ContactVarify cv = new ContactVarify(driver);
		String date = cv.getActDate().getText();
		if (date.equals("2000-07-05")) {
			System.out.println("contact create successfully with date " + date);
		}
		// logout
		LogOut logout = new LogOut(driver);
		WebElement profile = logout.getProfile();
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		logout.getSignOutLink().click();
		// closing the browser
		driver.close();

	}

}
