package opportunity_test;

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
import object_repository.HomePage;
import object_repository.LogOut;
import object_repository.LoginPage;
import object_repository.OppPage;
import object_repository.OppVarify;

public class OpportunityTest {

	@Test
	public void createOppWithDateTest() throws IOException, InterruptedException {
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromPropFile("bro");
		String userName = fUtil.getDataFromPropFile("username");
		String password = fUtil.getDataFromPropFile("pass");
		String Url = fUtil.getDataFromPropFile("url");

		String oppName = fUtil.getDataFromExcelFile("org", 2, 0);
		String orgName = fUtil.getDataFromExcelFile("org", 1, 0);
		// opening empty browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// login
		driver.get(Url);
		LoginPage lp = new LoginPage(driver);
		lp.login(userName, password);

		// create opp
		HomePage hp = new HomePage(driver);
		hp.getOppLink().click();
		OppPage op = new OppPage(driver);
		op.getCreateOpp().click();
		op.getOppNameField().sendKeys(oppName);
		WebElement rel = op.getRelatedTo();
		Select sel = new Select(rel);
		sel.selectByIndex(0);
		Thread.sleep(2000);
		String parentId = driver.getWindowHandle();
		op.getRelPlus().click();
		Thread.sleep(2000);
		System.out.println(parentId);

		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			driver.switchTo().window(id);
			System.out.println(id + " ");

//			if (driver.getCurrentUrl().contains("module=Acounts&actions")) {
//				break;
//			} else {
//				System.out.println("not found child window");
//			}
		}

		Thread.sleep(2000);
		// dynamic path
//		driver.findElement(By.xpath("//a[text()='vtigerCRM Inc']")).click();
		driver.findElement(By.linkText("orgName")).click();

		driver.switchTo().window(parentId);

		WebElement date = op.getDateField();
		date.clear();
		String enterDate = "2025-04-2";
		date.sendKeys(enterDate);

		// save the opp
		op.getOppSaveBtn().click();

		// Varification
		OppVarify ov = new OppVarify(driver);
		String actOppName = ov.getCreateOppName().getText();
		if (actOppName.contains(oppName)) {
			System.out.println("opp created Succesfully!!!!!!!");
		}

		String actDate = ov.getDateVarify().getText();
		if (actDate.equals(enterDate)) {
			System.out.println("date varified succesfully!!!!!!!");
		}

		// logout
		LogOut logout = new LogOut(driver);
		WebElement profile = logout.getProfile();
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		logout.getSignOutLink().click();
		Thread.sleep(2000);

		// closing the browser
		driver.close();

	}

	@Test
	public void oppWithTypeTest() throws IOException, InterruptedException {

		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromPropFile("bro");
		String userName = fUtil.getDataFromPropFile("username");
		String password = fUtil.getDataFromPropFile("pass");
		String Url = fUtil.getDataFromPropFile("url");

		String oppName = fUtil.getDataFromExcelFile("org", 2, 0);
		String orgName = fUtil.getDataFromExcelFile("org", 1, 0);
		// opening empty browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// login
		driver.get(Url);
		LoginPage lp = new LoginPage(driver);
		lp.login(userName, password);

		// create opp
		HomePage hp = new HomePage(driver);
		hp.getOppLink().click();
		OppPage op = new OppPage(driver);
		op.getCreateOpp().click();
		op.getOppNameField().sendKeys(oppName);
		WebElement rel = op.getRelatedTo();
		Select sel = new Select(rel);
		sel.selectByIndex(0);
		Thread.sleep(2000);
		String parentId = driver.getWindowHandle();
		op.getRelPlus().click();
		Thread.sleep(2000);
		System.out.println(parentId);

		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			driver.switchTo().window(id);
			System.out.println(id + " ");

//					if (driver.getCurrentUrl().contains("module=Acounts&actions")) {
//						break;
//					} else {
//						System.out.println("not found child window");
//					}
		}

		Thread.sleep(2000);
		// dynamic path
//				driver.findElement(By.xpath("//a[text()='vtigerCRM Inc']")).click();
		driver.findElement(By.linkText("orgName")).click();

		driver.switchTo().window(parentId);
		WebElement type = op.getTypeField();
		Select sel2 = new Select(type);
		sel2.selectByIndex(1);
		String selectedOpp = sel2.getFirstSelectedOption().toString();

		// save the opp
		op.getOppSaveBtn().click();

		// Varification
		OppVarify ov = new OppVarify(driver);
		String actOppName = ov.getCreateOppName().getText();
		if (actOppName.contains(oppName)) {
			System.out.println("opp created Succesfully!!!!!!!");
		}

		// logout
		LogOut logout = new LogOut(driver);
		WebElement profile = logout.getProfile();
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		logout.getSignOutLink().click();
		Thread.sleep(2000);

		// closing the browser
		driver.close();

	}

}
