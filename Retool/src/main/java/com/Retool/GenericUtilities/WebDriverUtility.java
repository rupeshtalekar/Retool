package com.Retool.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class is used to write WebDriver specific methods
 * 
 * @author RUPESH
 */
public class WebDriverUtility {
	
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to wait for page load
	 * 
	 * @author RUPESH
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to wait until the element is visible
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method enables user to handle drop down by index
	 * 
	 * @author RUPESH
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method enables user to handle drop down by value
	 * 
	 * @author RUPESH
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method enables user to handle drop down by visible text
	 * 
	 * @author RUPESH
	 * @param element
	 * @param index
	 */
	public void select(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		
	}

	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 * [HTML-Document]
	 * 
	 * @author RUPESH
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	/**
	 * wait for page to load before indentifying any assychronized[java scripts
	 * actions] element in DOM [HTML-Docuent]
	 * 
	 * @author RUPESH
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}

	/**
	 * used to wait for element to be clickable in GUI , & check for specific
	 * element for every 500 milli seconds
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * used to wait for element to be clickable in GUI , & check for specific
	 * element for every 500 milli seconds
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param element
	 * @param pollingTime in the form second
	 * @throws Throwable
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime)
			throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * used to Switch to Any Window based on Window Title
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * used to Switch to Alert Window & click on OK button
	 * 
	 * @author RUPESH
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * 
	 * @author RUPESH
	 * @param driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}

	/**
	 * used to Switch to Frame Window based on index
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

	/**
	 * used to right click on specified element
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}

	/**
	 * This method is used to execute java script commands
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript);
	}

	/**
	 * This method waits till the element is loaded and clicks
	 * 
	 * @author RUPESH
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This method is used to take screenshot of a webpage
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + screenshotName + ".PNG");
		FileUtils.copyFile(src, dest);
	}

	/**
	 * pass enter Key appertain in to Browser
	 * 
	 * @author RUPESH
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method is used to double click on the element
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method is used to double click on the webpage
	 * 
	 * @author RUPESH
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method is used to press enter button using Robot class
	 * 
	 * @author RUPESH
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * This method is used to release the enter button
	 * 
	 * @author RUPESH
	 * @param driver
	 * @throws Throwable
	 */
	public void enterRelease(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method is used to drag and drop elements
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param src
	 * @param des
	 */
	public void dragAndDropElement(WebDriver driver, WebElement src, WebElement des) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, des).perform();
	}

	/**
	 * This method is used to switch to frame using address
	 * 
	 * @author RUPESH
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}

	/**
	 * This method will perform random scroll
	 * 
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver,int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+y+")");
	}

	/**
	 * This method will scroll until specified element is found
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0," + y + ")", element);
		// jse.executeScript("argument[0].scrollIntoView()", element);
	}

}
