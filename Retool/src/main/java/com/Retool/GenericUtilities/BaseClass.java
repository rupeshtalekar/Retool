package com.Retool.GenericUtilities;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import com.Retool.ObjectRepository.RestApiGeneratorPage;

public class BaseClass implements IPathConstants {

	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver;

	@BeforeClass
	public void launchBrowser() throws Throwable {

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid browser");
		}

		wlib.waitForPageLoad(driver);
		wlib.maximizeWindow(driver);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wlib.scrollBarAction(driver, 500);

	}

	@BeforeMethod
	public void addTextFieds() throws Throwable {
		RestApiGeneratorPage page = new RestApiGeneratorPage(driver);
		
		wlib.switchToFrame(driver, driver.findElement(By.xpath("//iframe[@style='height:1050px']")));
		
		Thread.sleep(3000);
		page.getAddColumnLink().click();
		Thread.sleep(5000);
		page.getAddColumnLink().click();
		Thread.sleep(5000);
		page.getAddColumnLink().click();
		Thread.sleep(5000);

	}

	@AfterMethod
	public void verify() throws Throwable {

		SoftAssert s1 = new SoftAssert();
		String totalRowElementsPath = "//div[contains(@data-testid,'generated_table-id') and @class='inner-cell-container inner-cell-container--number']";
		List<WebElement> totalElements = driver.findElements(By.xpath(totalRowElementsPath));
		int rows = totalElements.size();
		System.out.println(rows);
		if (rows == 5) {
			Reporter.log("Test Case Passed", true);
		} else {
			s1.fail();
			Reporter.log("Test Case Failed", true);
		}
		wlib.takeScreenshot(driver, "pic1");
		s1.assertAll();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("closes the browser");
	}

}
